package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a02;
import com.baidu.tieba.a12;
import com.baidu.tieba.a22;
import com.baidu.tieba.b02;
import com.baidu.tieba.b22;
import com.baidu.tieba.bn3;
import com.baidu.tieba.bo2;
import com.baidu.tieba.bz1;
import com.baidu.tieba.c02;
import com.baidu.tieba.c12;
import com.baidu.tieba.c22;
import com.baidu.tieba.cz1;
import com.baidu.tieba.d12;
import com.baidu.tieba.d22;
import com.baidu.tieba.df3;
import com.baidu.tieba.e22;
import com.baidu.tieba.ee3;
import com.baidu.tieba.ez1;
import com.baidu.tieba.f02;
import com.baidu.tieba.f12;
import com.baidu.tieba.f22;
import com.baidu.tieba.fd2;
import com.baidu.tieba.fz1;
import com.baidu.tieba.g12;
import com.baidu.tieba.g22;
import com.baidu.tieba.g63;
import com.baidu.tieba.gz1;
import com.baidu.tieba.h12;
import com.baidu.tieba.h22;
import com.baidu.tieba.hz1;
import com.baidu.tieba.i12;
import com.baidu.tieba.iz1;
import com.baidu.tieba.j12;
import com.baidu.tieba.j22;
import com.baidu.tieba.k12;
import com.baidu.tieba.kz1;
import com.baidu.tieba.l02;
import com.baidu.tieba.l12;
import com.baidu.tieba.l33;
import com.baidu.tieba.m02;
import com.baidu.tieba.m12;
import com.baidu.tieba.mz1;
import com.baidu.tieba.n12;
import com.baidu.tieba.nz1;
import com.baidu.tieba.o12;
import com.baidu.tieba.ol3;
import com.baidu.tieba.oy1;
import com.baidu.tieba.p03;
import com.baidu.tieba.pr1;
import com.baidu.tieba.q02;
import com.baidu.tieba.qz1;
import com.baidu.tieba.r02;
import com.baidu.tieba.r03;
import com.baidu.tieba.r12;
import com.baidu.tieba.rd2;
import com.baidu.tieba.s02;
import com.baidu.tieba.sz1;
import com.baidu.tieba.t02;
import com.baidu.tieba.t12;
import com.baidu.tieba.tz1;
import com.baidu.tieba.u02;
import com.baidu.tieba.uz1;
import com.baidu.tieba.v33;
import com.baidu.tieba.vh3;
import com.baidu.tieba.vz1;
import com.baidu.tieba.w02;
import com.baidu.tieba.w22;
import com.baidu.tieba.wz1;
import com.baidu.tieba.x02;
import com.baidu.tieba.x22;
import com.baidu.tieba.xz1;
import com.baidu.tieba.y12;
import com.baidu.tieba.y22;
import com.baidu.tieba.yz1;
import com.baidu.tieba.z02;
import com.baidu.tieba.z12;
import com.baidu.tieba.z22;
import com.baidu.tieba.ze2;
import com.baidu.tieba.zy1;
import com.baidu.tieba.zz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final zy1 zy1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("1930258908", fz1Var);
                }
                Pair<Boolean, x22> a = z22.a(fz1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = fz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", gz1Var);
                }
                Pair<Boolean, x22> a = z22.a(gz1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = gz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("1754780133", hz1Var);
                }
                Pair<Boolean, x22> a = z22.a(hz1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = hz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                oy1 oy1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("-343998465", oy1Var);
                }
                Pair<Boolean, x22> a = z22.a(oy1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = oy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", gz1Var);
                }
                Pair<Boolean, x22> a = z22.a(gz1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = gz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-337742792", ez1Var);
                }
                Pair<Boolean, x22> a = z22.a(ez1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = ez1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", gz1Var);
                }
                Pair<Boolean, x22> a = z22.a(gz1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = gz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", iz1Var);
                }
                Pair<Boolean, x22> a = z22.a(iz1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = iz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", iz1Var);
                }
                Pair<Boolean, x22> a = z22.a(iz1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = iz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = pr1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 P = pr1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 U = pr1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 V = pr1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 X = pr1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", cz1Var);
                }
                Pair<Boolean, x22> a = z22.a(cz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = cz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", cz1Var);
                }
                Pair<Boolean, x22> a = z22.a(cz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = cz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", cz1Var);
                }
                Pair<Boolean, x22> a = z22.a(cz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = cz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                kz1 kz1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", kz1Var);
                }
                Pair<Boolean, x22> a = z22.a(kz1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = kz1Var.x(str);
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
                Pair<Boolean, x22> a = z22.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                mz1 mz1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof mz1)) {
                    mz1Var = (mz1) obj;
                } else {
                    mz1Var = new mz1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", mz1Var);
                }
                Pair<Boolean, x22> a = z22.a(mz1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = mz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                bo2 bo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof bo2)) {
                    bo2Var = (bo2) obj;
                } else {
                    bo2Var = new bo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", bo2Var);
                }
                Pair<Boolean, x22> a = z22.a(bo2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = bo2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                bo2 bo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof bo2)) {
                    bo2Var = (bo2) obj;
                } else {
                    bo2Var = new bo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", bo2Var);
                }
                Pair<Boolean, x22> a = z22.a(bo2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = bo2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = nz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = nz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 query = nz1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = nz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                p03 p03Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof p03)) {
                    p03Var = (p03) obj;
                } else {
                    p03Var = new p03(this.mSwanApiContext);
                    this.mApis.put("1445003743", p03Var);
                }
                Pair<Boolean, x22> a = z22.a(p03Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = p03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", qz1Var);
                }
                Pair<Boolean, x22> a = z22.a(qz1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = qz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = yz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = yz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = uz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = wz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = wz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = yz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", vz1Var);
                }
                Pair<Boolean, x22> a = z22.a(vz1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = vz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = uz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = uz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = yz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 L = wz1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                a02 a02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof a02)) {
                    a02Var = (a02) obj;
                } else {
                    a02Var = new a02(this.mSwanApiContext);
                    this.mApis.put("1172469410", a02Var);
                }
                Pair<Boolean, x22> a = z22.a(a02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = a02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("5236036", sz1Var);
                }
                Pair<Boolean, x22> a = z22.a(sz1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = sz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("1913747800", tz1Var);
                }
                Pair<Boolean, x22> a = z22.a(tz1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = tz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = uz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("1159492510", zz1Var);
                }
                Pair<Boolean, x22> a = z22.a(zz1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 Q = zz1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                xz1 xz1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("1165118609", xz1Var);
                }
                Pair<Boolean, x22> a = z22.a(xz1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = xz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 M = wz1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                sz1 sz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("5236036", sz1Var);
                }
                Pair<Boolean, x22> a = z22.a(sz1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = sz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                zz1 zz1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("1159492510", zz1Var);
                }
                Pair<Boolean, x22> a = z22.a(zz1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = zz1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                b02 b02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-137346255", b02Var);
                }
                Pair<Boolean, x22> a = z22.a(b02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = b02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                b02 b02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-137346255", b02Var);
                }
                Pair<Boolean, x22> a = z22.a(b02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = b02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("-397373095", c02Var);
                }
                Pair<Boolean, x22> a = z22.a(c02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = c02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("-397373095", c02Var);
                }
                Pair<Boolean, x22> a = z22.a(c02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = c02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                c02 c02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("-397373095", c02Var);
                }
                Pair<Boolean, x22> a = z22.a(c02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = c02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                t12 t12Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("538070032", t12Var);
                }
                Pair<Boolean, x22> a = z22.a(t12Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = t12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-1076509454", f02Var);
                }
                Pair<Boolean, x22> a = z22.a(f02Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = f02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("968563034", m02Var);
                }
                Pair<Boolean, x22> a = z22.a(m02Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = m02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("453220699", l02Var);
                }
                Pair<Boolean, x22> a = z22.a(l02Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = l02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                l02 l02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("453220699", l02Var);
                }
                Pair<Boolean, x22> a = z22.a(l02Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = l02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                m02 m02Var;
                String a;
                try {
                    w22.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof m02)) {
                        m02Var = (m02) obj;
                    } else {
                        m02Var = new m02(this.mSwanApiContext);
                        this.mApis.put("968563034", m02Var);
                    }
                    Pair<Boolean, x22> a2 = z22.a(m02Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((x22) a2.second).a();
                    } else if (fd2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<x22, JSONObject> t = bz1.t(jsObject);
                        if (!((x22) t.first).isSuccess()) {
                            a = ((x22) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = x22.a.a();
                            } else {
                                y22 V = m02Var.V(jSONObject);
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
                        w22.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                v33 v33Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof v33)) {
                    v33Var = (v33) obj;
                } else {
                    v33Var = new v33(this.mSwanApiContext);
                    this.mApis.put("-336396851", v33Var);
                }
                Pair<Boolean, x22> a = z22.a(v33Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = v33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                v33 v33Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof v33)) {
                    v33Var = (v33) obj;
                } else {
                    v33Var = new v33(this.mSwanApiContext);
                    this.mApis.put("-336396851", v33Var);
                }
                Pair<Boolean, x22> a = z22.a(v33Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = v33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                l33 l33Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof l33)) {
                    l33Var = (l33) obj;
                } else {
                    l33Var = new l33(this.mSwanApiContext);
                    this.mApis.put("1854689529", l33Var);
                }
                Pair<Boolean, x22> a = z22.a(l33Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = l33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                v33 v33Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof v33)) {
                    v33Var = (v33) obj;
                } else {
                    v33Var = new v33(this.mSwanApiContext);
                    this.mApis.put("-336396851", v33Var);
                }
                Pair<Boolean, x22> a = z22.a(v33Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = v33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                g63 g63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof g63)) {
                    g63Var = (g63) obj;
                } else {
                    g63Var = new g63(this.mSwanApiContext);
                    this.mApis.put("-254510461", g63Var);
                }
                Pair<Boolean, x22> a = z22.a(g63Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = g63Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                g63 g63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof g63)) {
                    g63Var = (g63) obj;
                } else {
                    g63Var = new g63(this.mSwanApiContext);
                    this.mApis.put("-254510461", g63Var);
                }
                Pair<Boolean, x22> a = z22.a(g63Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = g63Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                g63 g63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof g63)) {
                    g63Var = (g63) obj;
                } else {
                    g63Var = new g63(this.mSwanApiContext);
                    this.mApis.put("-254510461", g63Var);
                }
                Pair<Boolean, x22> a = z22.a(g63Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = g63Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ze2 ze2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ze2)) {
                    ze2Var = (ze2) obj;
                } else {
                    ze2Var = new ze2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ze2Var);
                }
                Pair<Boolean, x22> a = z22.a(ze2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = ze2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                rd2 rd2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof rd2)) {
                    rd2Var = (rd2) obj;
                } else {
                    rd2Var = new rd2(this.mSwanApiContext);
                    this.mApis.put("423661539", rd2Var);
                }
                Pair<Boolean, x22> a = z22.a(rd2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = rd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                bn3 bn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof bn3)) {
                    bn3Var = (bn3) obj;
                } else {
                    bn3Var = new bn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", bn3Var);
                }
                Pair<Boolean, x22> a = z22.a(bn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = bn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                q02 q02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", q02Var);
                }
                Pair<Boolean, x22> a = z22.a(q02Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = q02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", q02Var);
                }
                Pair<Boolean, x22> a = z22.a(q02Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = q02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("1968522584", r02Var);
                }
                Pair<Boolean, x22> a = z22.a(r02Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = r02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("1317280190", t02Var);
                }
                Pair<Boolean, x22> a = z22.a(t02Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = t02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("-420075743", u02Var);
                }
                Pair<Boolean, x22> a = z22.a(u02Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = u02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                s02 s02Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof s02)) {
                    s02Var = (s02) obj;
                } else {
                    s02Var = new s02(this.mSwanApiContext);
                    this.mApis.put("1792515533", s02Var);
                }
                Pair<Boolean, x22> a = z22.a(s02Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = s02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("1968522584", r02Var);
                }
                Pair<Boolean, x22> a = z22.a(r02Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = r02Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = x02Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = x02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                w02 w02Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("450273045", w02Var);
                }
                Pair<Boolean, x22> a = z22.a(w02Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = w02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = x02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = x02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = x02Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                vh3 vh3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof vh3)) {
                    vh3Var = (vh3) obj;
                } else {
                    vh3Var = new vh3(this.mSwanApiContext);
                    this.mApis.put("712777136", vh3Var);
                }
                Pair<Boolean, x22> a = z22.a(vh3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = vh3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = a12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = a12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = z02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = z02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = a12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = a12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = z02Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = z02Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = a12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = a12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = z02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = z02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = z02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 R = a12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 T2 = a12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 R = z02Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 T2 = z02Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 U = a12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 W = a12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 U = z02Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 W = z02Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("823117982", c12Var);
                }
                Pair<Boolean, x22> a = z22.a(c12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 E = c12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-947445811", d12Var);
                }
                Pair<Boolean, x22> a = z22.a(d12Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = d12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                k12 k12Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof k12)) {
                    k12Var = (k12) obj;
                } else {
                    k12Var = new k12(this.mSwanApiContext);
                    this.mApis.put("1936205521", k12Var);
                }
                Pair<Boolean, x22> a = z22.a(k12Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = k12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("1694151270", j12Var);
                }
                Pair<Boolean, x22> a = z22.a(j12Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = j12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                l12 l12Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof l12)) {
                    l12Var = (l12) obj;
                } else {
                    l12Var = new l12(this.mSwanApiContext);
                    this.mApis.put("-1321681619", l12Var);
                }
                Pair<Boolean, x22> a = z22.a(l12Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = l12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-1569246082", m12Var);
                }
                Pair<Boolean, x22> a = z22.a(m12Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = m12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1099851202", o12Var);
                }
                Pair<Boolean, x22> a = z22.a(o12Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = o12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("-1707203360", n12Var);
                }
                Pair<Boolean, x22> a = z22.a(n12Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = n12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                h12 h12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof h12)) {
                    h12Var = (h12) obj;
                } else {
                    h12Var = new h12(this.mSwanApiContext);
                    this.mApis.put("-518757484", h12Var);
                }
                Pair<Boolean, x22> a = z22.a(h12Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = h12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("1161486049", r03Var);
                }
                Pair<Boolean, x22> a = z22.a(r03Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = r03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("447234992", r12Var);
                }
                Pair<Boolean, x22> a = z22.a(r12Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = r12Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("1372680763", f12Var);
                }
                Pair<Boolean, x22> a = z22.a(f12Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = f12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("1689255576", i12Var);
                }
                Pair<Boolean, x22> a = z22.a(i12Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = i12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                g12 g12Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("99997465", g12Var);
                }
                Pair<Boolean, x22> a = z22.a(g12Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = g12Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                h12 h12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof h12)) {
                    h12Var = (h12) obj;
                } else {
                    h12Var = new h12(this.mSwanApiContext);
                    this.mApis.put("-518757484", h12Var);
                }
                Pair<Boolean, x22> a = z22.a(h12Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = h12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                r12 r12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("447234992", r12Var);
                }
                Pair<Boolean, x22> a = z22.a(r12Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = r12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                f12 f12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("1372680763", f12Var);
                }
                Pair<Boolean, x22> a = z22.a(f12Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = f12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                i12 i12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("1689255576", i12Var);
                }
                Pair<Boolean, x22> a = z22.a(i12Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = i12Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                c22 c22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("201194468", c22Var);
                }
                Pair<Boolean, x22> a = z22.a(c22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = c22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-1412306947", y12Var);
                }
                Pair<Boolean, x22> a = z22.a(y12Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = y12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                z12 z12Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof z12)) {
                    z12Var = (z12) obj;
                } else {
                    z12Var = new z12(this.mSwanApiContext);
                    this.mApis.put("1626415364", z12Var);
                }
                Pair<Boolean, x22> a = z22.a(z12Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = z12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-836768778", b22Var);
                }
                Pair<Boolean, x22> a = z22.a(b22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = b22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("-810858308", d22Var);
                }
                Pair<Boolean, x22> a = z22.a(d22Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = d22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = h22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-2097727681", e22Var);
                }
                Pair<Boolean, x22> a = z22.a(e22Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = e22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("2084449317", a22Var);
                }
                Pair<Boolean, x22> a = z22.a(a22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = a22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                df3 df3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof df3)) {
                    df3Var = (df3) obj;
                } else {
                    df3Var = new df3(this.mSwanApiContext);
                    this.mApis.put("1031678042", df3Var);
                }
                Pair<Boolean, x22> a = z22.a(df3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = df3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                f22 f22Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("1751900130", f22Var);
                }
                Pair<Boolean, x22> a = z22.a(f22Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = f22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ee3 ee3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ee3)) {
                    ee3Var = (ee3) obj;
                } else {
                    ee3Var = new ee3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ee3Var);
                }
                Pair<Boolean, x22> a = z22.a(ee3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = ee3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("589529211", g22Var);
                }
                Pair<Boolean, x22> a = z22.a(g22Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = g22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("-577481801", j22Var);
                }
                Pair<Boolean, x22> a = z22.a(j22Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = j22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 E = h22Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = h22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = h22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = ol3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = ol3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = ol3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = ol3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = ol3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final zy1 zy1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("1930258908", fz1Var);
                }
                Pair<Boolean, x22> a = z22.a(fz1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.checkSession")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = fz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", gz1Var);
                }
                Pair<Boolean, x22> a = z22.a(gz1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.getLoginCode")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = gz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("1754780133", hz1Var);
                }
                Pair<Boolean, x22> a = z22.a(hz1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.getOpenId")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = hz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                oy1 oy1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("-343998465", oy1Var);
                }
                Pair<Boolean, x22> a = z22.a(oy1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.getUnionBDUSS")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = oy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", gz1Var);
                }
                Pair<Boolean, x22> a = z22.a(gz1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.login")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = gz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-337742792", ez1Var);
                }
                Pair<Boolean, x22> a = z22.a(ez1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.isBaiduAccountSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = ez1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                gz1 gz1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", gz1Var);
                }
                Pair<Boolean, x22> a = z22.a(gz1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Account.isLoginSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = gz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", iz1Var);
                }
                Pair<Boolean, x22> a = z22.a(iz1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = iz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", iz1Var);
                }
                Pair<Boolean, x22> a = z22.a(iz1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Basic.loadSubPackages")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = iz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.deleteBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = pr1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.insertBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 P = pr1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.navigateToBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 U = pr1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.queryBookshelf")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 V = pr1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                pr1 pr1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof pr1)) {
                    pr1Var = (pr1) obj;
                } else {
                    pr1Var = new pr1(this.mSwanApiContext);
                    this.mApis.put("1460300387", pr1Var);
                }
                Pair<Boolean, x22> a = z22.a(pr1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Bookshelf.updateBookshelfReadTime")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 X = pr1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", cz1Var);
                }
                Pair<Boolean, x22> a = z22.a(cz1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Coupon.getPlatformCoupons")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = cz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", cz1Var);
                }
                Pair<Boolean, x22> a = z22.a(cz1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Coupon.getUserCoupons")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = cz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                cz1 cz1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof cz1)) {
                    cz1Var = (cz1) obj;
                } else {
                    cz1Var = new cz1(this.mSwanApiContext);
                    this.mApis.put("-277316359", cz1Var);
                }
                Pair<Boolean, x22> a = z22.a(cz1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Coupon.takeCoupons")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = cz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                kz1 kz1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", kz1Var);
                }
                Pair<Boolean, x22> a = z22.a(kz1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Favorite.getFavorStatus")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = kz1Var.x(str);
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
                Pair<Boolean, x22> a = z22.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Favorite.showFavoriteGuide")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                mz1 mz1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof mz1)) {
                    mz1Var = (mz1) obj;
                } else {
                    mz1Var = new mz1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", mz1Var);
                }
                Pair<Boolean, x22> a = z22.a(mz1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "File.shareFile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = mz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                bo2 bo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof bo2)) {
                    bo2Var = (bo2) obj;
                } else {
                    bo2Var = new bo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", bo2Var);
                }
                Pair<Boolean, x22> a = z22.a(bo2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = bo2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                bo2 bo2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof bo2)) {
                    bo2Var = (bo2) obj;
                } else {
                    bo2Var = new bo2(this.mSwanApiContext);
                    this.mApis.put("2077414795", bo2Var);
                }
                Pair<Boolean, x22> a = z22.a(bo2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "GameCenter.postGameCenterMessageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = bo2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.download")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = nz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openFile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = nz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.query")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 query = nz1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                nz1 nz1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("-170124576", nz1Var);
                }
                Pair<Boolean, x22> a = z22.a(nz1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "HostDownloadManager.openDownloadCenter")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = nz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                p03 p03Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof p03)) {
                    p03Var = (p03) obj;
                } else {
                    p03Var = new p03(this.mSwanApiContext);
                    this.mApis.put("1445003743", p03Var);
                }
                Pair<Boolean, x22> a = z22.a(p03Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Image.callImageMenu")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = p03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", qz1Var);
                }
                Pair<Boolean, x22> a = z22.a(qz1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Image.compressImage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = qz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBar")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = yz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.closeTabBarRedDot")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = yz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.hideNavigationBarLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = uz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.openMultiPicker")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = wz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.openPicker")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = wz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.openTabBar")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = yz1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", vz1Var);
                }
                Pair<Boolean, x22> a = z22.a(vz1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.pageScrollTo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = vz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarColor")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = uz1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.setNavigationBarTitle")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = uz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", yz1Var);
                }
                Pair<Boolean, x22> a = z22.a(yz1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.setTabBarItem")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = yz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showDatePickerView")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 L = wz1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                a02 a02Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof a02)) {
                    a02Var = (a02) obj;
                } else {
                    a02Var = new a02(this.mSwanApiContext);
                    this.mApis.put("1172469410", a02Var);
                }
                Pair<Boolean, x22> a = z22.a(a02Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showHalfScreenWebview")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = a02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                sz1 sz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("5236036", sz1Var);
                }
                Pair<Boolean, x22> a = z22.a(sz1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = sz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("1913747800", tz1Var);
                }
                Pair<Boolean, x22> a = z22.a(tz1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showModal")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = tz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                uz1 uz1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("-246386074", uz1Var);
                }
                Pair<Boolean, x22> a = z22.a(uz1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showNavigationBarLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = uz1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("1159492510", zz1Var);
                }
                Pair<Boolean, x22> a = z22.a(zz1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.showToast")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 Q = zz1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                xz1 xz1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("1165118609", xz1Var);
                }
                Pair<Boolean, x22> a = z22.a(xz1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.stopPullDownRefresh")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = xz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("-108978463", wz1Var);
                }
                Pair<Boolean, x22> a = z22.a(wz1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.updateMultiPicker")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 M = wz1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                sz1 sz1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof sz1)) {
                    sz1Var = (sz1) obj;
                } else {
                    sz1Var = new sz1(this.mSwanApiContext);
                    this.mApis.put("5236036", sz1Var);
                }
                Pair<Boolean, x22> a = z22.a(sz1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.hideLoading")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = sz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                zz1 zz1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("1159492510", zz1Var);
                }
                Pair<Boolean, x22> a = z22.a(zz1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Interaction.hideToast")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = zz1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                b02 b02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-137346255", b02Var);
                }
                Pair<Boolean, x22> a = z22.a(b02Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Keyboard.startKeyboardHeightChange")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = b02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                b02 b02Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-137346255", b02Var);
                }
                Pair<Boolean, x22> a = z22.a(b02Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Keyboard.stopKeyboardHeightChange")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = b02Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("-397373095", c02Var);
                }
                Pair<Boolean, x22> a = z22.a(c02Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "LocationService.getLocation")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = c02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("-397373095", c02Var);
                }
                Pair<Boolean, x22> a = z22.a(c02Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "LocationService.startLocationUpdate")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = c02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                c02 c02Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("-397373095", c02Var);
                }
                Pair<Boolean, x22> a = z22.a(c02Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "LocationService.stopLocationUpdate")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = c02Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                t12 t12Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof t12)) {
                    t12Var = (t12) obj;
                } else {
                    t12Var = new t12(this.mSwanApiContext);
                    this.mApis.put("538070032", t12Var);
                }
                Pair<Boolean, x22> a = z22.a(t12Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = t12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("-1076509454", f02Var);
                }
                Pair<Boolean, x22> a = z22.a(f02Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.callService")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = f02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("968563034", m02Var);
                }
                Pair<Boolean, x22> a = z22.a(m02Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.cancelRequest")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = m02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                l02 l02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("453220699", l02Var);
                }
                Pair<Boolean, x22> a = z22.a(l02Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.networkStatusChange")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = l02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                l02 l02Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof l02)) {
                    l02Var = (l02) obj;
                } else {
                    l02Var = new l02(this.mSwanApiContext);
                    this.mApis.put("453220699", l02Var);
                }
                Pair<Boolean, x22> a = z22.a(l02Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Network.getNetworkType")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = l02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                m02 m02Var;
                String a;
                try {
                    w22.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof m02)) {
                        m02Var = (m02) obj;
                    } else {
                        m02Var = new m02(this.mSwanApiContext);
                        this.mApis.put("968563034", m02Var);
                    }
                    Pair<Boolean, x22> a2 = z22.a(m02Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((x22) a2.second).a();
                    } else if (fd2.a(this.mSwanApiContext.d(), "Network.request")) {
                        a = new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<x22, JSONObject> u = bz1.u(str);
                        if (!((x22) u.first).isSuccess()) {
                            a = ((x22) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = x22.a.a();
                            } else {
                                y22 V = m02Var.V(jSONObject);
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
                        w22.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                v33 v33Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof v33)) {
                    v33Var = (v33) obj;
                } else {
                    v33Var = new v33(this.mSwanApiContext);
                    this.mApis.put("-336396851", v33Var);
                }
                Pair<Boolean, x22> a = z22.a(v33Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.chooseCoupon")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = v33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                v33 v33Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof v33)) {
                    v33Var = (v33) obj;
                } else {
                    v33Var = new v33(this.mSwanApiContext);
                    this.mApis.put("-336396851", v33Var);
                }
                Pair<Boolean, x22> a = z22.a(v33Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.getPaymentInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = v33Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                l33 l33Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof l33)) {
                    l33Var = (l33) obj;
                } else {
                    l33Var = new l33(this.mSwanApiContext);
                    this.mApis.put("1854689529", l33Var);
                }
                Pair<Boolean, x22> a = z22.a(l33Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.requestThirdPayment")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = l33Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                v33 v33Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof v33)) {
                    v33Var = (v33) obj;
                } else {
                    v33Var = new v33(this.mSwanApiContext);
                    this.mApis.put("-336396851", v33Var);
                }
                Pair<Boolean, x22> a = z22.a(v33Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Payment.setPaymentInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = v33Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                g63 g63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof g63)) {
                    g63Var = (g63) obj;
                } else {
                    g63Var = new g63(this.mSwanApiContext);
                    this.mApis.put("-254510461", g63Var);
                }
                Pair<Boolean, x22> a = z22.a(g63Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginChooseAddress")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = g63Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                g63 g63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof g63)) {
                    g63Var = (g63) obj;
                } else {
                    g63Var = new g63(this.mSwanApiContext);
                    this.mApis.put("-254510461", g63Var);
                }
                Pair<Boolean, x22> a = z22.a(g63Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = g63Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                g63 g63Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof g63)) {
                    g63Var = (g63) obj;
                } else {
                    g63Var = new g63(this.mSwanApiContext);
                    this.mApis.put("-254510461", g63Var);
                }
                Pair<Boolean, x22> a = z22.a(g63Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Plugin.invokePluginPayment")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = g63Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                ze2 ze2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof ze2)) {
                    ze2Var = (ze2) obj;
                } else {
                    ze2Var = new ze2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", ze2Var);
                }
                Pair<Boolean, x22> a = z22.a(ze2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Prefetch.prefetchResources")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = ze2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                rd2 rd2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof rd2)) {
                    rd2Var = (rd2) obj;
                } else {
                    rd2Var = new rd2(this.mSwanApiContext);
                    this.mApis.put("423661539", rd2Var);
                }
                Pair<Boolean, x22> a = z22.a(rd2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Preload.preloadStatus")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = rd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                bn3 bn3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof bn3)) {
                    bn3Var = (bn3) obj;
                } else {
                    bn3Var = new bn3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", bn3Var);
                }
                Pair<Boolean, x22> a = z22.a(bn3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateFile.uploadFileToBos")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = bn3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                q02 q02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", q02Var);
                }
                Pair<Boolean, x22> a = z22.a(q02Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.hideModalPage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = q02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("-1495163604", q02Var);
                }
                Pair<Boolean, x22> a = z22.a(q02Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.navigateBack")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = q02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("1968522584", r02Var);
                }
                Pair<Boolean, x22> a = z22.a(r02Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.navigateTo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = r02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("1317280190", t02Var);
                }
                Pair<Boolean, x22> a = z22.a(t02Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.reLaunch")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = t02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("-420075743", u02Var);
                }
                Pair<Boolean, x22> a = z22.a(u02Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.reLoadErrorPage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = u02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                s02 s02Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof s02)) {
                    s02Var = (s02) obj;
                } else {
                    s02Var = new s02(this.mSwanApiContext);
                    this.mApis.put("1792515533", s02Var);
                }
                Pair<Boolean, x22> a = z22.a(s02Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.redirectTo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = s02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("1968522584", r02Var);
                }
                Pair<Boolean, x22> a = z22.a(r02Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Router.showModalPage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = r02Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getAppInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = x02Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getSlaveIdSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = x02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                w02 w02Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof w02)) {
                    w02Var = (w02) obj;
                } else {
                    w02Var = new w02(this.mSwanApiContext);
                    this.mApis.put("450273045", w02Var);
                }
                Pair<Boolean, x22> a = z22.a(w02Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.isAllowedAdOpenAppSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = w02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getSetting")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = x02Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getSwanId")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = x02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-594895721", x02Var);
                }
                Pair<Boolean, x22> a = z22.a(x02Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Setting.getUserInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = x02Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                vh3 vh3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof vh3)) {
                    vh3Var = (vh3) obj;
                } else {
                    vh3Var = new vh3(this.mSwanApiContext);
                    this.mApis.put("712777136", vh3Var);
                }
                Pair<Boolean, x22> a = z22.a(vh3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = vh3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = a12Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = a12Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = z02Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.clearStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = z02Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = a12Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = a12Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = z02Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = z02Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = a12Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = a12Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 D = z02Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageInfoAsync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = z02Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.getStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 K = z02Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 R = a12Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 T2 = a12Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 R = z02Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.removeStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 T2 = z02Var.T(str);
                if (T2 == null) {
                    return "";
                }
                return T2.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 U = a12Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                a12 a12Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof a12)) {
                    a12Var = (a12) obj;
                } else {
                    a12Var = new a12(this.mSwanApiContext);
                    this.mApis.put("-804054859", a12Var);
                }
                Pair<Boolean, x22> a = z22.a(a12Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setGlobalStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 W = a12Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setStorage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 U = z02Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                z02 z02Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof z02)) {
                    z02Var = (z02) obj;
                } else {
                    z02Var = new z02(this.mSwanApiContext);
                    this.mApis.put("130910081", z02Var);
                }
                Pair<Boolean, x22> a = z22.a(z02Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Storage.setStorageSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 W = z02Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                c12 c12Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof c12)) {
                    c12Var = (c12) obj;
                } else {
                    c12Var = new c12(this.mSwanApiContext);
                    this.mApis.put("823117982", c12Var);
                }
                Pair<Boolean, x22> a = z22.a(c12Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Subscription.requestSubscribeFormId")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 E = c12Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d12 d12Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof d12)) {
                    d12Var = (d12) obj;
                } else {
                    d12Var = new d12(this.mSwanApiContext);
                    this.mApis.put("-947445811", d12Var);
                }
                Pair<Boolean, x22> a = z22.a(d12Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Subscription.subscribeService")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = d12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                k12 k12Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof k12)) {
                    k12Var = (k12) obj;
                } else {
                    k12Var = new k12(this.mSwanApiContext);
                    this.mApis.put("1936205521", k12Var);
                }
                Pair<Boolean, x22> a = z22.a(k12Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.exitFullScreen")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = k12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                j12 j12Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof j12)) {
                    j12Var = (j12) obj;
                } else {
                    j12Var = new j12(this.mSwanApiContext);
                    this.mApis.put("1694151270", j12Var);
                }
                Pair<Boolean, x22> a = z22.a(j12Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getDeviceInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = j12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                l12 l12Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof l12)) {
                    l12Var = (l12) obj;
                } else {
                    l12Var = new l12(this.mSwanApiContext);
                    this.mApis.put("-1321681619", l12Var);
                }
                Pair<Boolean, x22> a = z22.a(l12Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getDeviceProfile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = l12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                m12 m12Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof m12)) {
                    m12Var = (m12) obj;
                } else {
                    m12Var = new m12(this.mSwanApiContext);
                    this.mApis.put("-1569246082", m12Var);
                }
                Pair<Boolean, x22> a = z22.a(m12Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.makePhoneCall")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = m12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                o12 o12Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof o12)) {
                    o12Var = (o12) obj;
                } else {
                    o12Var = new o12(this.mSwanApiContext);
                    this.mApis.put("1099851202", o12Var);
                }
                Pair<Boolean, x22> a = z22.a(o12Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.openSMSPanel")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = o12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                n12 n12Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof n12)) {
                    n12Var = (n12) obj;
                } else {
                    n12Var = new n12(this.mSwanApiContext);
                    this.mApis.put("-1707203360", n12Var);
                }
                Pair<Boolean, x22> a = z22.a(n12Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.requestFullScreen")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = n12Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                h12 h12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof h12)) {
                    h12Var = (h12) obj;
                } else {
                    h12Var = new h12(this.mSwanApiContext);
                    this.mApis.put("-518757484", h12Var);
                }
                Pair<Boolean, x22> a = z22.a(h12Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.setClipboardData")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = h12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                r03 r03Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof r03)) {
                    r03Var = (r03) obj;
                } else {
                    r03Var = new r03(this.mSwanApiContext);
                    this.mApis.put("1161486049", r03Var);
                }
                Pair<Boolean, x22> a = z22.a(r03Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.setErrorPageType")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = r03Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                r12 r12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("447234992", r12Var);
                }
                Pair<Boolean, x22> a = z22.a(r12Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.setMediaVolume")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = r12Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                f12 f12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("1372680763", f12Var);
                }
                Pair<Boolean, x22> a = z22.a(f12Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.startAccelerometer")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = f12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                i12 i12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("1689255576", i12Var);
                }
                Pair<Boolean, x22> a = z22.a(i12Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.startCompass")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = i12Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                g12 g12Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof g12)) {
                    g12Var = (g12) obj;
                } else {
                    g12Var = new g12(this.mSwanApiContext);
                    this.mApis.put("99997465", g12Var);
                }
                Pair<Boolean, x22> a = z22.a(g12Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getBrightness")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = g12Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                h12 h12Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof h12)) {
                    h12Var = (h12) obj;
                } else {
                    h12Var = new h12(this.mSwanApiContext);
                    this.mApis.put("-518757484", h12Var);
                }
                Pair<Boolean, x22> a = z22.a(h12Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getClipboardData")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = h12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                r12 r12Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof r12)) {
                    r12Var = (r12) obj;
                } else {
                    r12Var = new r12(this.mSwanApiContext);
                    this.mApis.put("447234992", r12Var);
                }
                Pair<Boolean, x22> a = z22.a(r12Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.getMediaVolume")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = r12Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                f12 f12Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof f12)) {
                    f12Var = (f12) obj;
                } else {
                    f12Var = new f12(this.mSwanApiContext);
                    this.mApis.put("1372680763", f12Var);
                }
                Pair<Boolean, x22> a = z22.a(f12Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.stopAccelerometer")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = f12Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                i12 i12Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof i12)) {
                    i12Var = (i12) obj;
                } else {
                    i12Var = new i12(this.mSwanApiContext);
                    this.mApis.put("1689255576", i12Var);
                }
                Pair<Boolean, x22> a = z22.a(i12Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "System.stopCompass")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 z = i12Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                c22 c22Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof c22)) {
                    c22Var = (c22) obj;
                } else {
                    c22Var = new c22(this.mSwanApiContext);
                    this.mApis.put("201194468", c22Var);
                }
                Pair<Boolean, x22> a = z22.a(c22Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.addToDesktop")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = c22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                y12 y12Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof y12)) {
                    y12Var = (y12) obj;
                } else {
                    y12Var = new y12(this.mSwanApiContext);
                    this.mApis.put("-1412306947", y12Var);
                }
                Pair<Boolean, x22> a = z22.a(y12Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.calcMD5")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = y12Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                z12 z12Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof z12)) {
                    z12Var = (z12) obj;
                } else {
                    z12Var = new z12(this.mSwanApiContext);
                    this.mApis.put("1626415364", z12Var);
                }
                Pair<Boolean, x22> a = z22.a(z12Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.checkAppInstalled")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = z12Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                b22 b22Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof b22)) {
                    b22Var = (b22) obj;
                } else {
                    b22Var = new b22(this.mSwanApiContext);
                    this.mApis.put("-836768778", b22Var);
                }
                Pair<Boolean, x22> a = z22.a(b22Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = b22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                d22 d22Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof d22)) {
                    d22Var = (d22) obj;
                } else {
                    d22Var = new d22(this.mSwanApiContext);
                    this.mApis.put("-810858308", d22Var);
                }
                Pair<Boolean, x22> a = z22.a(d22Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getPerformanceLevel")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = d22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoAsync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = h22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                e22 e22Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof e22)) {
                    e22Var = (e22) obj;
                } else {
                    e22Var = new e22(this.mSwanApiContext);
                    this.mApis.put("-2097727681", e22Var);
                }
                Pair<Boolean, x22> a = z22.a(e22Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.handleException")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = e22Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                a22 a22Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof a22)) {
                    a22Var = (a22) obj;
                } else {
                    a22Var = new a22(this.mSwanApiContext);
                    this.mApis.put("2084449317", a22Var);
                }
                Pair<Boolean, x22> a = z22.a(a22Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.hasCloseHandler")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = a22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                df3 df3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof df3)) {
                    df3Var = (df3) obj;
                } else {
                    df3Var = new df3(this.mSwanApiContext);
                    this.mApis.put("1031678042", df3Var);
                }
                Pair<Boolean, x22> a = z22.a(df3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.hideCaptureScreenShareDialog")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 x = df3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                f22 f22Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof f22)) {
                    f22Var = (f22) obj;
                } else {
                    f22Var = new f22(this.mSwanApiContext);
                    this.mApis.put("1751900130", f22Var);
                }
                Pair<Boolean, x22> a = z22.a(f22Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.logToFile")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = f22Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                ee3 ee3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof ee3)) {
                    ee3Var = (ee3) obj;
                } else {
                    ee3Var = new ee3(this.mSwanApiContext);
                    this.mApis.put("1748196865", ee3Var);
                }
                Pair<Boolean, x22> a = z22.a(ee3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.preloadPackage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = ee3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                g22 g22Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof g22)) {
                    g22Var = (g22) obj;
                } else {
                    g22Var = new g22(this.mSwanApiContext);
                    this.mApis.put("589529211", g22Var);
                }
                Pair<Boolean, x22> a = z22.a(g22Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.previewImage")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = g22Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                j22 j22Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof j22)) {
                    j22Var = (j22) obj;
                } else {
                    j22Var = new j22(this.mSwanApiContext);
                    this.mApis.put("-577481801", j22Var);
                }
                Pair<Boolean, x22> a = z22.a(j22Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.ubcFlowJar")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 I = j22Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getCommonSysInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 E = h22Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = h22Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                h22 h22Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof h22)) {
                    h22Var = (h22) obj;
                } else {
                    h22Var = new h22(this.mSwanApiContext);
                    this.mApis.put("-1011537871", h22Var);
                }
                Pair<Boolean, x22> a = z22.a(h22Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Utils.getSystemInfoSync")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 J = h22Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.connectWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 A = ol3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.getConnectedWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 B = ol3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.getWifiList")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 C = ol3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.startWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = ol3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ol3 ol3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ol3)) {
                    ol3Var = (ol3) obj;
                } else {
                    ol3Var = new ol3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ol3Var);
                }
                Pair<Boolean, x22> a = z22.a(ol3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "Wifi.stopWifi")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 H = ol3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
