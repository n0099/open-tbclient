package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a02;
import com.baidu.tieba.a43;
import com.baidu.tieba.ai3;
import com.baidu.tieba.b02;
import com.baidu.tieba.b12;
import com.baidu.tieba.b32;
import com.baidu.tieba.c02;
import com.baidu.tieba.c12;
import com.baidu.tieba.c32;
import com.baidu.tieba.d02;
import com.baidu.tieba.d22;
import com.baidu.tieba.d32;
import com.baidu.tieba.e02;
import com.baidu.tieba.e12;
import com.baidu.tieba.e22;
import com.baidu.tieba.e32;
import com.baidu.tieba.ef2;
import com.baidu.tieba.ez1;
import com.baidu.tieba.f02;
import com.baidu.tieba.f12;
import com.baidu.tieba.f22;
import com.baidu.tieba.g02;
import com.baidu.tieba.g22;
import com.baidu.tieba.gn3;
import com.baidu.tieba.go2;
import com.baidu.tieba.gz1;
import com.baidu.tieba.h02;
import com.baidu.tieba.h12;
import com.baidu.tieba.h22;
import com.baidu.tieba.hz1;
import com.baidu.tieba.i12;
import com.baidu.tieba.i22;
import com.baidu.tieba.if3;
import com.baidu.tieba.j22;
import com.baidu.tieba.je3;
import com.baidu.tieba.jz1;
import com.baidu.tieba.k02;
import com.baidu.tieba.k12;
import com.baidu.tieba.k22;
import com.baidu.tieba.kd2;
import com.baidu.tieba.kz1;
import com.baidu.tieba.l12;
import com.baidu.tieba.l22;
import com.baidu.tieba.l63;
import com.baidu.tieba.lz1;
import com.baidu.tieba.m12;
import com.baidu.tieba.m22;
import com.baidu.tieba.mz1;
import com.baidu.tieba.n12;
import com.baidu.tieba.nz1;
import com.baidu.tieba.o12;
import com.baidu.tieba.o22;
import com.baidu.tieba.p12;
import com.baidu.tieba.pz1;
import com.baidu.tieba.q02;
import com.baidu.tieba.q12;
import com.baidu.tieba.q33;
import com.baidu.tieba.r02;
import com.baidu.tieba.r12;
import com.baidu.tieba.rz1;
import com.baidu.tieba.s12;
import com.baidu.tieba.sz1;
import com.baidu.tieba.t12;
import com.baidu.tieba.tl3;
import com.baidu.tieba.ty1;
import com.baidu.tieba.u03;
import com.baidu.tieba.ur1;
import com.baidu.tieba.v02;
import com.baidu.tieba.vz1;
import com.baidu.tieba.w02;
import com.baidu.tieba.w03;
import com.baidu.tieba.w12;
import com.baidu.tieba.wd2;
import com.baidu.tieba.x02;
import com.baidu.tieba.xz1;
import com.baidu.tieba.y02;
import com.baidu.tieba.y12;
import com.baidu.tieba.yz1;
import com.baidu.tieba.z02;
import com.baidu.tieba.zz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final ez1 ez1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                kz1 kz1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("1930258908", kz1Var);
                }
                Pair<Boolean, c32> a = e32.a(kz1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = kz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", lz1Var);
                }
                Pair<Boolean, c32> a = e32.a(lz1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = lz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                mz1 mz1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof mz1)) {
                    mz1Var = (mz1) obj;
                } else {
                    mz1Var = new mz1(this.mSwanApiContext);
                    this.mApis.put("1754780133", mz1Var);
                }
                Pair<Boolean, c32> a = e32.a(mz1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = mz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("-343998465", ty1Var);
                }
                Pair<Boolean, c32> a = e32.a(ty1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = ty1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", lz1Var);
                }
                Pair<Boolean, c32> a = e32.a(lz1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = lz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                jz1 jz1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof jz1)) {
                    jz1Var = (jz1) obj;
                } else {
                    jz1Var = new jz1(this.mSwanApiContext);
                    this.mApis.put("-337742792", jz1Var);
                }
                Pair<Boolean, c32> a = e32.a(jz1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = jz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                lz1 lz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", lz1Var);
                }
                Pair<Boolean, c32> a = e32.a(lz1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = lz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", nz1Var);
                }
                Pair<Boolean, c32> a = e32.a(nz1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = nz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", nz1Var);
                }
                Pair<Boolean, c32> a = e32.a(nz1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = nz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = ur1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 P = ur1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 U = ur1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 V = ur1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 X = ur1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", hz1Var);
                }
                Pair<Boolean, c32> a = e32.a(hz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = hz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", hz1Var);
                }
                Pair<Boolean, c32> a = e32.a(hz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = hz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", hz1Var);
                }
                Pair<Boolean, c32> a = e32.a(hz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = hz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", pz1Var);
                }
                Pair<Boolean, c32> a = e32.a(pz1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = pz1Var.x(str);
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
                Pair<Boolean, c32> a = e32.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", rz1Var);
                }
                Pair<Boolean, c32> a = e32.a(rz1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = rz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                go2 go2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof go2)) {
                    go2Var = (go2) obj;
                } else {
                    go2Var = new go2(this.mSwanApiContext);
                    this.mApis.put("2077414795", go2Var);
                }
                Pair<Boolean, c32> a = e32.a(go2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = go2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                go2 go2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof go2)) {
                    go2Var = (go2) obj;
                } else {
                    go2Var = new go2(this.mSwanApiContext);
                    this.mApis.put("2077414795", go2Var);
                }
                Pair<Boolean, c32> a = e32.a(go2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = go2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = sz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = sz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 query = sz1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = sz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("1445003743", u03Var);
                }
                Pair<Boolean, c32> a = e32.a(u03Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = u03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", vz1Var);
                }
                Pair<Boolean, c32> a = e32.a(vz1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = vz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = d02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = d02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = zz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = b02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = b02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = d02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                a02 a02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof a02)) {
                    a02Var = (a02) obj;
                } else {
                    a02Var = new a02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", a02Var);
                }
                Pair<Boolean, c32> a = e32.a(a02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = a02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = zz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = zz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = d02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 L = b02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("1172469410", f02Var);
                }
                Pair<Boolean, c32> a = e32.a(f02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = f02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                xz1 xz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("5236036", xz1Var);
                }
                Pair<Boolean, c32> a = e32.a(xz1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = xz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("1913747800", yz1Var);
                }
                Pair<Boolean, c32> a = e32.a(yz1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = yz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = zz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                e02 e02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("1159492510", e02Var);
                }
                Pair<Boolean, c32> a = e32.a(e02Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 Q = e02Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1165118609", c02Var);
                }
                Pair<Boolean, c32> a = e32.a(c02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = c02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 M = b02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                xz1 xz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("5236036", xz1Var);
                }
                Pair<Boolean, c32> a = e32.a(xz1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = xz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                e02 e02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("1159492510", e02Var);
                }
                Pair<Boolean, c32> a = e32.a(e02Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = e02Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                g02 g02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-137346255", g02Var);
                }
                Pair<Boolean, c32> a = e32.a(g02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = g02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                g02 g02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-137346255", g02Var);
                }
                Pair<Boolean, c32> a = e32.a(g02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = g02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-397373095", h02Var);
                }
                Pair<Boolean, c32> a = e32.a(h02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = h02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-397373095", h02Var);
                }
                Pair<Boolean, c32> a = e32.a(h02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = h02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                h02 h02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-397373095", h02Var);
                }
                Pair<Boolean, c32> a = e32.a(h02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = h02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                y12 y12Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("538070032", y12Var);
                }
                Pair<Boolean, c32> a = e32.a(y12Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = y12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1076509454", k02Var);
                }
                Pair<Boolean, c32> a = e32.a(k02Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = k02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("968563034", r02Var);
                }
                Pair<Boolean, c32> a = e32.a(r02Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = r02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("453220699", q02Var);
                }
                Pair<Boolean, c32> a = e32.a(q02Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = q02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                q02 q02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("453220699", q02Var);
                }
                Pair<Boolean, c32> a = e32.a(q02Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = q02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                r02 r02Var;
                String a;
                try {
                    b32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof r02)) {
                        r02Var = (r02) obj;
                    } else {
                        r02Var = new r02(this.mSwanApiContext);
                        this.mApis.put("968563034", r02Var);
                    }
                    Pair<Boolean, c32> a2 = e32.a(r02Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((c32) a2.second).a();
                    } else if (kd2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<c32, JSONObject> t = gz1.t(jsObject);
                        if (!((c32) t.first).isSuccess()) {
                            a = ((c32) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = c32.a.a();
                            } else {
                                d32 V = r02Var.V(jSONObject);
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
                        b32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                a43 a43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof a43)) {
                    a43Var = (a43) obj;
                } else {
                    a43Var = new a43(this.mSwanApiContext);
                    this.mApis.put("-336396851", a43Var);
                }
                Pair<Boolean, c32> a = e32.a(a43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = a43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                a43 a43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof a43)) {
                    a43Var = (a43) obj;
                } else {
                    a43Var = new a43(this.mSwanApiContext);
                    this.mApis.put("-336396851", a43Var);
                }
                Pair<Boolean, c32> a = e32.a(a43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = a43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                q33 q33Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof q33)) {
                    q33Var = (q33) obj;
                } else {
                    q33Var = new q33(this.mSwanApiContext);
                    this.mApis.put("1854689529", q33Var);
                }
                Pair<Boolean, c32> a = e32.a(q33Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = q33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                a43 a43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof a43)) {
                    a43Var = (a43) obj;
                } else {
                    a43Var = new a43(this.mSwanApiContext);
                    this.mApis.put("-336396851", a43Var);
                }
                Pair<Boolean, c32> a = e32.a(a43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = a43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                l63 l63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof l63)) {
                    l63Var = (l63) obj;
                } else {
                    l63Var = new l63(this.mSwanApiContext);
                    this.mApis.put("-254510461", l63Var);
                }
                Pair<Boolean, c32> a = e32.a(l63Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = l63Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                l63 l63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof l63)) {
                    l63Var = (l63) obj;
                } else {
                    l63Var = new l63(this.mSwanApiContext);
                    this.mApis.put("-254510461", l63Var);
                }
                Pair<Boolean, c32> a = e32.a(l63Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = l63Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                l63 l63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof l63)) {
                    l63Var = (l63) obj;
                } else {
                    l63Var = new l63(this.mSwanApiContext);
                    this.mApis.put("-254510461", l63Var);
                }
                Pair<Boolean, c32> a = e32.a(l63Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = l63Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ef2 ef2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ef2)) {
                    ef2Var = (ef2) obj;
                } else {
                    ef2Var = new ef2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ef2Var);
                }
                Pair<Boolean, c32> a = e32.a(ef2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = ef2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                wd2 wd2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof wd2)) {
                    wd2Var = (wd2) obj;
                } else {
                    wd2Var = new wd2(this.mSwanApiContext);
                    this.mApis.put("423661539", wd2Var);
                }
                Pair<Boolean, c32> a = e32.a(wd2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = wd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                gn3 gn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof gn3)) {
                    gn3Var = (gn3) obj;
                } else {
                    gn3Var = new gn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", gn3Var);
                }
                Pair<Boolean, c32> a = e32.a(gn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = gn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                v02 v02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", v02Var);
                }
                Pair<Boolean, c32> a = e32.a(v02Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = v02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", v02Var);
                }
                Pair<Boolean, c32> a = e32.a(v02Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = v02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1968522584", w02Var);
                }
                Pair<Boolean, c32> a = e32.a(w02Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = w02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("1317280190", y02Var);
                }
                Pair<Boolean, c32> a = e32.a(y02Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = y02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-420075743", z02Var);
                }
                Pair<Boolean, c32> a = e32.a(z02Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = z02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("1792515533", x02Var);
                }
                Pair<Boolean, c32> a = e32.a(x02Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = x02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1968522584", w02Var);
                }
                Pair<Boolean, c32> a = e32.a(w02Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = w02Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = c12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = c12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                b12 b12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("450273045", b12Var);
                }
                Pair<Boolean, c32> a = e32.a(b12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = b12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = c12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = c12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = c12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ai3 ai3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ai3)) {
                    ai3Var = (ai3) obj;
                } else {
                    ai3Var = new ai3(this.mSwanApiContext);
                    this.mApis.put("712777136", ai3Var);
                }
                Pair<Boolean, c32> a = e32.a(ai3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = ai3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = f12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = f12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = e12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = e12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = f12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = f12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = e12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = e12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = f12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = f12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = e12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = e12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = e12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 R = f12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 T2 = f12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 R = e12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 T2 = e12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 U = f12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 W = f12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 U = e12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 W = e12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                h12 h12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof h12)) {
                    h12Var = (h12) obj;
                } else {
                    h12Var = new h12(this.mSwanApiContext);
                    this.mApis.put("823117982", h12Var);
                }
                Pair<Boolean, c32> a = e32.a(h12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 E = h12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("-947445811", i12Var);
                }
                Pair<Boolean, c32> a = e32.a(i12Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = i12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                p12 p12Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("1936205521", p12Var);
                }
                Pair<Boolean, c32> a = e32.a(p12Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = p12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1694151270", o12Var);
                }
                Pair<Boolean, c32> a = e32.a(o12Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = o12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("-1321681619", q12Var);
                }
                Pair<Boolean, c32> a = e32.a(q12Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = q12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-1569246082", r12Var);
                }
                Pair<Boolean, c32> a = e32.a(r12Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = r12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                t12 t12Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("1099851202", t12Var);
                }
                Pair<Boolean, c32> a = e32.a(t12Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = t12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("-1707203360", s12Var);
                }
                Pair<Boolean, c32> a = e32.a(s12Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = s12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-518757484", m12Var);
                }
                Pair<Boolean, c32> a = e32.a(m12Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = m12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                w03 w03Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof w03)) {
                    w03Var = (w03) obj;
                } else {
                    w03Var = new w03(this.mSwanApiContext);
                    this.mApis.put("1161486049", w03Var);
                }
                Pair<Boolean, c32> a = e32.a(w03Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = w03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("447234992", w12Var);
                }
                Pair<Boolean, c32> a = e32.a(w12Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = w12Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                k12 k12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof k12)) {
                    k12Var = (k12) obj;
                } else {
                    k12Var = new k12(this.mSwanApiContext);
                    this.mApis.put("1372680763", k12Var);
                }
                Pair<Boolean, c32> a = e32.a(k12Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = k12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("1689255576", n12Var);
                }
                Pair<Boolean, c32> a = e32.a(n12Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = n12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                l12 l12Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof l12)) {
                    l12Var = (l12) obj;
                } else {
                    l12Var = new l12(this.mSwanApiContext);
                    this.mApis.put("99997465", l12Var);
                }
                Pair<Boolean, c32> a = e32.a(l12Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = l12Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                m12 m12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-518757484", m12Var);
                }
                Pair<Boolean, c32> a = e32.a(m12Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = m12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                w12 w12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("447234992", w12Var);
                }
                Pair<Boolean, c32> a = e32.a(w12Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = w12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                k12 k12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof k12)) {
                    k12Var = (k12) obj;
                } else {
                    k12Var = new k12(this.mSwanApiContext);
                    this.mApis.put("1372680763", k12Var);
                }
                Pair<Boolean, c32> a = e32.a(k12Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = k12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                n12 n12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("1689255576", n12Var);
                }
                Pair<Boolean, c32> a = e32.a(n12Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = n12Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("201194468", h22Var);
                }
                Pair<Boolean, c32> a = e32.a(h22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = h22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", d22Var);
                }
                Pair<Boolean, c32> a = e32.a(d22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = d22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("1626415364", e22Var);
                }
                Pair<Boolean, c32> a = e32.a(e22Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = e22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("-836768778", g22Var);
                }
                Pair<Boolean, c32> a = e32.a(g22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = g22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-810858308", i22Var);
                }
                Pair<Boolean, c32> a = e32.a(i22Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = i22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = m22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("-2097727681", j22Var);
                }
                Pair<Boolean, c32> a = e32.a(j22Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = j22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                f22 f22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("2084449317", f22Var);
                }
                Pair<Boolean, c32> a = e32.a(f22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = f22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                if3 if3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof if3)) {
                    if3Var = (if3) obj;
                } else {
                    if3Var = new if3(this.mSwanApiContext);
                    this.mApis.put("1031678042", if3Var);
                }
                Pair<Boolean, c32> a = e32.a(if3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = if3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("1751900130", k22Var);
                }
                Pair<Boolean, c32> a = e32.a(k22Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = k22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                je3 je3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof je3)) {
                    je3Var = (je3) obj;
                } else {
                    je3Var = new je3(this.mSwanApiContext);
                    this.mApis.put("1748196865", je3Var);
                }
                Pair<Boolean, c32> a = e32.a(je3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = je3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("589529211", l22Var);
                }
                Pair<Boolean, c32> a = e32.a(l22Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = l22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("-577481801", o22Var);
                }
                Pair<Boolean, c32> a = e32.a(o22Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = o22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 E = m22Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = m22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = m22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = tl3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = tl3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = tl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = tl3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = tl3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final ez1 ez1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                kz1 kz1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("1930258908", kz1Var);
                }
                Pair<Boolean, c32> a = e32.a(kz1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = kz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", lz1Var);
                }
                Pair<Boolean, c32> a = e32.a(lz1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = lz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                mz1 mz1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof mz1)) {
                    mz1Var = (mz1) obj;
                } else {
                    mz1Var = new mz1(this.mSwanApiContext);
                    this.mApis.put("1754780133", mz1Var);
                }
                Pair<Boolean, c32> a = e32.a(mz1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = mz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("-343998465", ty1Var);
                }
                Pair<Boolean, c32> a = e32.a(ty1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = ty1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", lz1Var);
                }
                Pair<Boolean, c32> a = e32.a(lz1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = lz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                jz1 jz1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof jz1)) {
                    jz1Var = (jz1) obj;
                } else {
                    jz1Var = new jz1(this.mSwanApiContext);
                    this.mApis.put("-337742792", jz1Var);
                }
                Pair<Boolean, c32> a = e32.a(jz1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = jz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                lz1 lz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", lz1Var);
                }
                Pair<Boolean, c32> a = e32.a(lz1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = lz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", nz1Var);
                }
                Pair<Boolean, c32> a = e32.a(nz1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = nz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", nz1Var);
                }
                Pair<Boolean, c32> a = e32.a(nz1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = nz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = ur1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 P = ur1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 U = ur1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 V = ur1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                ur1 ur1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof ur1)) {
                    ur1Var = (ur1) obj;
                } else {
                    ur1Var = new ur1(this.mSwanApiContext);
                    this.mApis.put("1460300387", ur1Var);
                }
                Pair<Boolean, c32> a = e32.a(ur1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 X = ur1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", hz1Var);
                }
                Pair<Boolean, c32> a = e32.a(hz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = hz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", hz1Var);
                }
                Pair<Boolean, c32> a = e32.a(hz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = hz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", hz1Var);
                }
                Pair<Boolean, c32> a = e32.a(hz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = hz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                pz1 pz1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof pz1)) {
                    pz1Var = (pz1) obj;
                } else {
                    pz1Var = new pz1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", pz1Var);
                }
                Pair<Boolean, c32> a = e32.a(pz1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = pz1Var.x(str);
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
                Pair<Boolean, c32> a = e32.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", rz1Var);
                }
                Pair<Boolean, c32> a = e32.a(rz1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = rz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                go2 go2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof go2)) {
                    go2Var = (go2) obj;
                } else {
                    go2Var = new go2(this.mSwanApiContext);
                    this.mApis.put("2077414795", go2Var);
                }
                Pair<Boolean, c32> a = e32.a(go2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = go2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                go2 go2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof go2)) {
                    go2Var = (go2) obj;
                } else {
                    go2Var = new go2(this.mSwanApiContext);
                    this.mApis.put("2077414795", go2Var);
                }
                Pair<Boolean, c32> a = e32.a(go2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = go2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = sz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = sz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 query = sz1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                sz1 sz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", sz1Var);
                }
                Pair<Boolean, c32> a = e32.a(sz1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = sz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                u03 u03Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof u03)) {
                    u03Var = (u03) obj;
                } else {
                    u03Var = new u03(this.mSwanApiContext);
                    this.mApis.put("1445003743", u03Var);
                }
                Pair<Boolean, c32> a = e32.a(u03Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = u03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", vz1Var);
                }
                Pair<Boolean, c32> a = e32.a(vz1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = vz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = d02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = d02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = zz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = b02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = b02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = d02Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                a02 a02Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof a02)) {
                    a02Var = (a02) obj;
                } else {
                    a02Var = new a02(this.mSwanApiContext);
                    this.mApis.put("-1750613704", a02Var);
                }
                Pair<Boolean, c32> a = e32.a(a02Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = a02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = zz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = zz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                d02 d02Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof d02)) {
                    d02Var = (d02) obj;
                } else {
                    d02Var = new d02(this.mSwanApiContext);
                    this.mApis.put("-1871435471", d02Var);
                }
                Pair<Boolean, c32> a = e32.a(d02Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = d02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 L = b02Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("1172469410", f02Var);
                }
                Pair<Boolean, c32> a = e32.a(f02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = f02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                xz1 xz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("5236036", xz1Var);
                }
                Pair<Boolean, c32> a = e32.a(xz1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = xz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("1913747800", yz1Var);
                }
                Pair<Boolean, c32> a = e32.a(yz1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = yz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", zz1Var);
                }
                Pair<Boolean, c32> a = e32.a(zz1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = zz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                e02 e02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("1159492510", e02Var);
                }
                Pair<Boolean, c32> a = e32.a(e02Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 Q = e02Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1165118609", c02Var);
                }
                Pair<Boolean, c32> a = e32.a(c02Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = c02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-108978463", b02Var);
                }
                Pair<Boolean, c32> a = e32.a(b02Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 M = b02Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                xz1 xz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("5236036", xz1Var);
                }
                Pair<Boolean, c32> a = e32.a(xz1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = xz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                e02 e02Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof e02)) {
                    e02Var = (e02) obj;
                } else {
                    e02Var = new e02(this.mSwanApiContext);
                    this.mApis.put("1159492510", e02Var);
                }
                Pair<Boolean, c32> a = e32.a(e02Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = e02Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                g02 g02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-137346255", g02Var);
                }
                Pair<Boolean, c32> a = e32.a(g02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = g02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                g02 g02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof g02)) {
                    g02Var = (g02) obj;
                } else {
                    g02Var = new g02(this.mSwanApiContext);
                    this.mApis.put("-137346255", g02Var);
                }
                Pair<Boolean, c32> a = e32.a(g02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = g02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-397373095", h02Var);
                }
                Pair<Boolean, c32> a = e32.a(h02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = h02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                h02 h02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-397373095", h02Var);
                }
                Pair<Boolean, c32> a = e32.a(h02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = h02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                h02 h02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("-397373095", h02Var);
                }
                Pair<Boolean, c32> a = e32.a(h02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = h02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                y12 y12Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("538070032", y12Var);
                }
                Pair<Boolean, c32> a = e32.a(y12Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = y12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                k02 k02Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof k02)) {
                    k02Var = (k02) obj;
                } else {
                    k02Var = new k02(this.mSwanApiContext);
                    this.mApis.put("-1076509454", k02Var);
                }
                Pair<Boolean, c32> a = e32.a(k02Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = k02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("968563034", r02Var);
                }
                Pair<Boolean, c32> a = e32.a(r02Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = r02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("453220699", q02Var);
                }
                Pair<Boolean, c32> a = e32.a(q02Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = q02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                q02 q02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("453220699", q02Var);
                }
                Pair<Boolean, c32> a = e32.a(q02Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = q02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                r02 r02Var;
                String a;
                try {
                    b32.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof r02)) {
                        r02Var = (r02) obj;
                    } else {
                        r02Var = new r02(this.mSwanApiContext);
                        this.mApis.put("968563034", r02Var);
                    }
                    Pair<Boolean, c32> a2 = e32.a(r02Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((c32) a2.second).a();
                    } else if (kd2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<c32, JSONObject> u = gz1.u(str);
                        if (!((c32) u.first).isSuccess()) {
                            a = ((c32) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = c32.a.a();
                            } else {
                                d32 V = r02Var.V(jSONObject);
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
                        b32.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                a43 a43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof a43)) {
                    a43Var = (a43) obj;
                } else {
                    a43Var = new a43(this.mSwanApiContext);
                    this.mApis.put("-336396851", a43Var);
                }
                Pair<Boolean, c32> a = e32.a(a43Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = a43Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                a43 a43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof a43)) {
                    a43Var = (a43) obj;
                } else {
                    a43Var = new a43(this.mSwanApiContext);
                    this.mApis.put("-336396851", a43Var);
                }
                Pair<Boolean, c32> a = e32.a(a43Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = a43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                q33 q33Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof q33)) {
                    q33Var = (q33) obj;
                } else {
                    q33Var = new q33(this.mSwanApiContext);
                    this.mApis.put("1854689529", q33Var);
                }
                Pair<Boolean, c32> a = e32.a(q33Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = q33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                a43 a43Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof a43)) {
                    a43Var = (a43) obj;
                } else {
                    a43Var = new a43(this.mSwanApiContext);
                    this.mApis.put("-336396851", a43Var);
                }
                Pair<Boolean, c32> a = e32.a(a43Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = a43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                l63 l63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof l63)) {
                    l63Var = (l63) obj;
                } else {
                    l63Var = new l63(this.mSwanApiContext);
                    this.mApis.put("-254510461", l63Var);
                }
                Pair<Boolean, c32> a = e32.a(l63Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = l63Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                l63 l63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof l63)) {
                    l63Var = (l63) obj;
                } else {
                    l63Var = new l63(this.mSwanApiContext);
                    this.mApis.put("-254510461", l63Var);
                }
                Pair<Boolean, c32> a = e32.a(l63Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = l63Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                l63 l63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof l63)) {
                    l63Var = (l63) obj;
                } else {
                    l63Var = new l63(this.mSwanApiContext);
                    this.mApis.put("-254510461", l63Var);
                }
                Pair<Boolean, c32> a = e32.a(l63Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = l63Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ef2 ef2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ef2)) {
                    ef2Var = (ef2) obj;
                } else {
                    ef2Var = new ef2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ef2Var);
                }
                Pair<Boolean, c32> a = e32.a(ef2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = ef2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                wd2 wd2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof wd2)) {
                    wd2Var = (wd2) obj;
                } else {
                    wd2Var = new wd2(this.mSwanApiContext);
                    this.mApis.put("423661539", wd2Var);
                }
                Pair<Boolean, c32> a = e32.a(wd2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = wd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                gn3 gn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof gn3)) {
                    gn3Var = (gn3) obj;
                } else {
                    gn3Var = new gn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", gn3Var);
                }
                Pair<Boolean, c32> a = e32.a(gn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = gn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                v02 v02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", v02Var);
                }
                Pair<Boolean, c32> a = e32.a(v02Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = v02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", v02Var);
                }
                Pair<Boolean, c32> a = e32.a(v02Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = v02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1968522584", w02Var);
                }
                Pair<Boolean, c32> a = e32.a(w02Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = w02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                y02 y02Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof y02)) {
                    y02Var = (y02) obj;
                } else {
                    y02Var = new y02(this.mSwanApiContext);
                    this.mApis.put("1317280190", y02Var);
                }
                Pair<Boolean, c32> a = e32.a(y02Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = y02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("-420075743", z02Var);
                }
                Pair<Boolean, c32> a = e32.a(z02Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = z02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("1792515533", x02Var);
                }
                Pair<Boolean, c32> a = e32.a(x02Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = x02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                w02 w02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("1968522584", w02Var);
                }
                Pair<Boolean, c32> a = e32.a(w02Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = w02Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = c12Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = c12Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                b12 b12Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof b12)) {
                    b12Var = (b12) obj;
                } else {
                    b12Var = new b12(this.mSwanApiContext);
                    this.mApis.put("450273045", b12Var);
                }
                Pair<Boolean, c32> a = e32.a(b12Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = b12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = c12Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = c12Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("-594895721", c12Var);
                }
                Pair<Boolean, c32> a = e32.a(c12Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = c12Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                ai3 ai3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof ai3)) {
                    ai3Var = (ai3) obj;
                } else {
                    ai3Var = new ai3(this.mSwanApiContext);
                    this.mApis.put("712777136", ai3Var);
                }
                Pair<Boolean, c32> a = e32.a(ai3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = ai3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = f12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = f12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = e12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = e12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = f12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = f12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = e12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = e12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = f12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = f12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 D = e12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = e12Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 K = e12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 R = f12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 T2 = f12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 R = e12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 T2 = e12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 U = f12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("-804054859", f12Var);
                }
                Pair<Boolean, c32> a = e32.a(f12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 W = f12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 U = e12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                e12 e12Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof e12)) {
                    e12Var = (e12) obj;
                } else {
                    e12Var = new e12(this.mSwanApiContext);
                    this.mApis.put("130910081", e12Var);
                }
                Pair<Boolean, c32> a = e32.a(e12Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 W = e12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                h12 h12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof h12)) {
                    h12Var = (h12) obj;
                } else {
                    h12Var = new h12(this.mSwanApiContext);
                    this.mApis.put("823117982", h12Var);
                }
                Pair<Boolean, c32> a = e32.a(h12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 E = h12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("-947445811", i12Var);
                }
                Pair<Boolean, c32> a = e32.a(i12Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = i12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                p12 p12Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof p12)) {
                    p12Var = (p12) obj;
                } else {
                    p12Var = new p12(this.mSwanApiContext);
                    this.mApis.put("1936205521", p12Var);
                }
                Pair<Boolean, c32> a = e32.a(p12Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = p12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1694151270", o12Var);
                }
                Pair<Boolean, c32> a = e32.a(o12Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = o12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                q12 q12Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof q12)) {
                    q12Var = (q12) obj;
                } else {
                    q12Var = new q12(this.mSwanApiContext);
                    this.mApis.put("-1321681619", q12Var);
                }
                Pair<Boolean, c32> a = e32.a(q12Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = q12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("-1569246082", r12Var);
                }
                Pair<Boolean, c32> a = e32.a(r12Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = r12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                t12 t12Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("1099851202", t12Var);
                }
                Pair<Boolean, c32> a = e32.a(t12Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = t12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                s12 s12Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof s12)) {
                    s12Var = (s12) obj;
                } else {
                    s12Var = new s12(this.mSwanApiContext);
                    this.mApis.put("-1707203360", s12Var);
                }
                Pair<Boolean, c32> a = e32.a(s12Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = s12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-518757484", m12Var);
                }
                Pair<Boolean, c32> a = e32.a(m12Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = m12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                w03 w03Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof w03)) {
                    w03Var = (w03) obj;
                } else {
                    w03Var = new w03(this.mSwanApiContext);
                    this.mApis.put("1161486049", w03Var);
                }
                Pair<Boolean, c32> a = e32.a(w03Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = w03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                w12 w12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("447234992", w12Var);
                }
                Pair<Boolean, c32> a = e32.a(w12Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = w12Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                k12 k12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof k12)) {
                    k12Var = (k12) obj;
                } else {
                    k12Var = new k12(this.mSwanApiContext);
                    this.mApis.put("1372680763", k12Var);
                }
                Pair<Boolean, c32> a = e32.a(k12Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = k12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("1689255576", n12Var);
                }
                Pair<Boolean, c32> a = e32.a(n12Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = n12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                l12 l12Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof l12)) {
                    l12Var = (l12) obj;
                } else {
                    l12Var = new l12(this.mSwanApiContext);
                    this.mApis.put("99997465", l12Var);
                }
                Pair<Boolean, c32> a = e32.a(l12Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = l12Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                m12 m12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-518757484", m12Var);
                }
                Pair<Boolean, c32> a = e32.a(m12Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = m12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                w12 w12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof w12)) {
                    w12Var = (w12) obj;
                } else {
                    w12Var = new w12(this.mSwanApiContext);
                    this.mApis.put("447234992", w12Var);
                }
                Pair<Boolean, c32> a = e32.a(w12Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = w12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                k12 k12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof k12)) {
                    k12Var = (k12) obj;
                } else {
                    k12Var = new k12(this.mSwanApiContext);
                    this.mApis.put("1372680763", k12Var);
                }
                Pair<Boolean, c32> a = e32.a(k12Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = k12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                n12 n12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("1689255576", n12Var);
                }
                Pair<Boolean, c32> a = e32.a(n12Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 z = n12Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("201194468", h22Var);
                }
                Pair<Boolean, c32> a = e32.a(h22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = h22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("-1412306947", d22Var);
                }
                Pair<Boolean, c32> a = e32.a(d22Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = d22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("1626415364", e22Var);
                }
                Pair<Boolean, c32> a = e32.a(e22Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = e22Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("-836768778", g22Var);
                }
                Pair<Boolean, c32> a = e32.a(g22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = g22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                i22 i22Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof i22)) {
                    i22Var = (i22) obj;
                } else {
                    i22Var = new i22(this.mSwanApiContext);
                    this.mApis.put("-810858308", i22Var);
                }
                Pair<Boolean, c32> a = e32.a(i22Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = i22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = m22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("-2097727681", j22Var);
                }
                Pair<Boolean, c32> a = e32.a(j22Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = j22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                f22 f22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("2084449317", f22Var);
                }
                Pair<Boolean, c32> a = e32.a(f22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = f22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                if3 if3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof if3)) {
                    if3Var = (if3) obj;
                } else {
                    if3Var = new if3(this.mSwanApiContext);
                    this.mApis.put("1031678042", if3Var);
                }
                Pair<Boolean, c32> a = e32.a(if3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 x = if3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                k22 k22Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof k22)) {
                    k22Var = (k22) obj;
                } else {
                    k22Var = new k22(this.mSwanApiContext);
                    this.mApis.put("1751900130", k22Var);
                }
                Pair<Boolean, c32> a = e32.a(k22Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = k22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                je3 je3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof je3)) {
                    je3Var = (je3) obj;
                } else {
                    je3Var = new je3(this.mSwanApiContext);
                    this.mApis.put("1748196865", je3Var);
                }
                Pair<Boolean, c32> a = e32.a(je3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = je3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                l22 l22Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof l22)) {
                    l22Var = (l22) obj;
                } else {
                    l22Var = new l22(this.mSwanApiContext);
                    this.mApis.put("589529211", l22Var);
                }
                Pair<Boolean, c32> a = e32.a(l22Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = l22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                o22 o22Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof o22)) {
                    o22Var = (o22) obj;
                } else {
                    o22Var = new o22(this.mSwanApiContext);
                    this.mApis.put("-577481801", o22Var);
                }
                Pair<Boolean, c32> a = e32.a(o22Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 I = o22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 E = m22Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = m22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                m22 m22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof m22)) {
                    m22Var = (m22) obj;
                } else {
                    m22Var = new m22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", m22Var);
                }
                Pair<Boolean, c32> a = e32.a(m22Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 J = m22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 A = tl3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 B = tl3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 C = tl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = tl3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                tl3 tl3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof tl3)) {
                    tl3Var = (tl3) obj;
                } else {
                    tl3Var = new tl3(this.mSwanApiContext);
                    this.mApis.put("1879401452", tl3Var);
                }
                Pair<Boolean, c32> a = e32.a(tl3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 H = tl3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
