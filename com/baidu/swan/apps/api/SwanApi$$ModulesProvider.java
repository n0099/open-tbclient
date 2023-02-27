package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a02;
import com.baidu.tieba.ay1;
import com.baidu.tieba.az1;
import com.baidu.tieba.b02;
import com.baidu.tieba.by1;
import com.baidu.tieba.c02;
import com.baidu.tieba.ck3;
import com.baidu.tieba.cx1;
import com.baidu.tieba.dq1;
import com.baidu.tieba.dz2;
import com.baidu.tieba.ey1;
import com.baidu.tieba.ez1;
import com.baidu.tieba.f02;
import com.baidu.tieba.fc2;
import com.baidu.tieba.fz1;
import com.baidu.tieba.fz2;
import com.baidu.tieba.gy1;
import com.baidu.tieba.gz1;
import com.baidu.tieba.h02;
import com.baidu.tieba.hy1;
import com.baidu.tieba.hz1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.iz1;
import com.baidu.tieba.j23;
import com.baidu.tieba.jg3;
import com.baidu.tieba.jy1;
import com.baidu.tieba.k12;
import com.baidu.tieba.ky1;
import com.baidu.tieba.kz1;
import com.baidu.tieba.l12;
import com.baidu.tieba.ly1;
import com.baidu.tieba.lz1;
import com.baidu.tieba.m02;
import com.baidu.tieba.m12;
import com.baidu.tieba.my1;
import com.baidu.tieba.n02;
import com.baidu.tieba.n12;
import com.baidu.tieba.nd2;
import com.baidu.tieba.nx1;
import com.baidu.tieba.ny1;
import com.baidu.tieba.nz1;
import com.baidu.tieba.o02;
import com.baidu.tieba.oy1;
import com.baidu.tieba.oz1;
import com.baidu.tieba.p02;
import com.baidu.tieba.pl3;
import com.baidu.tieba.pm2;
import com.baidu.tieba.px1;
import com.baidu.tieba.py1;
import com.baidu.tieba.q02;
import com.baidu.tieba.qx1;
import com.baidu.tieba.qy1;
import com.baidu.tieba.qz1;
import com.baidu.tieba.r02;
import com.baidu.tieba.rd3;
import com.baidu.tieba.rz1;
import com.baidu.tieba.s02;
import com.baidu.tieba.sc3;
import com.baidu.tieba.sx1;
import com.baidu.tieba.t02;
import com.baidu.tieba.tb2;
import com.baidu.tieba.tx1;
import com.baidu.tieba.ty1;
import com.baidu.tieba.tz1;
import com.baidu.tieba.u02;
import com.baidu.tieba.u43;
import com.baidu.tieba.ux1;
import com.baidu.tieba.uz1;
import com.baidu.tieba.v02;
import com.baidu.tieba.vx1;
import com.baidu.tieba.vz1;
import com.baidu.tieba.wx1;
import com.baidu.tieba.wz1;
import com.baidu.tieba.x02;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yx1;
import com.baidu.tieba.yz1;
import com.baidu.tieba.z13;
import com.baidu.tieba.zy1;
import com.baidu.tieba.zz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final nx1 nx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("1930258908", tx1Var);
                }
                Pair<Boolean, l12> a = n12.a(tx1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = tx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ux1Var);
                }
                Pair<Boolean, l12> a = n12.a(ux1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = ux1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("1754780133", vx1Var);
                }
                Pair<Boolean, l12> a = n12.a(vx1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = vx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                cx1 cx1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof cx1)) {
                    cx1Var = (cx1) obj;
                } else {
                    cx1Var = new cx1(this.mSwanApiContext);
                    this.mApis.put("-343998465", cx1Var);
                }
                Pair<Boolean, l12> a = n12.a(cx1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = cx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ux1Var);
                }
                Pair<Boolean, l12> a = n12.a(ux1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = ux1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-337742792", sx1Var);
                }
                Pair<Boolean, l12> a = n12.a(sx1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = sx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ux1Var);
                }
                Pair<Boolean, l12> a = n12.a(ux1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = ux1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", wx1Var);
                }
                Pair<Boolean, l12> a = n12.a(wx1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = wx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", wx1Var);
                }
                Pair<Boolean, l12> a = n12.a(wx1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = wx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = dq1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 P = dq1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 U = dq1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 V = dq1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 X = dq1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", qx1Var);
                }
                Pair<Boolean, l12> a = n12.a(qx1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = qx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", qx1Var);
                }
                Pair<Boolean, l12> a = n12.a(qx1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = qx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", qx1Var);
                }
                Pair<Boolean, l12> a = n12.a(qx1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = qx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", yx1Var);
                }
                Pair<Boolean, l12> a = n12.a(yx1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = yx1Var.x(str);
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
                Pair<Boolean, l12> a = n12.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", ay1Var);
                }
                Pair<Boolean, l12> a = n12.a(ay1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = ay1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                pm2 pm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof pm2)) {
                    pm2Var = (pm2) obj;
                } else {
                    pm2Var = new pm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", pm2Var);
                }
                Pair<Boolean, l12> a = n12.a(pm2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = pm2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                pm2 pm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof pm2)) {
                    pm2Var = (pm2) obj;
                } else {
                    pm2Var = new pm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", pm2Var);
                }
                Pair<Boolean, l12> a = n12.a(pm2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = pm2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = by1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = by1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 query = by1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = by1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("1445003743", dz2Var);
                }
                Pair<Boolean, l12> a = n12.a(dz2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = dz2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", ey1Var);
                }
                Pair<Boolean, l12> a = n12.a(ey1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = ey1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = my1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = my1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = iy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = ky1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = ky1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = my1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", jy1Var);
                }
                Pair<Boolean, l12> a = n12.a(jy1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = jy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = iy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = iy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = my1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 L = ky1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                oy1 oy1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("1172469410", oy1Var);
                }
                Pair<Boolean, l12> a = n12.a(oy1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = oy1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("5236036", gy1Var);
                }
                Pair<Boolean, l12> a = n12.a(gy1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1913747800", hy1Var);
                }
                Pair<Boolean, l12> a = n12.a(hy1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = hy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = iy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ny1Var);
                }
                Pair<Boolean, l12> a = n12.a(ny1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 Q = ny1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                ly1 ly1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof ly1)) {
                    ly1Var = (ly1) obj;
                } else {
                    ly1Var = new ly1(this.mSwanApiContext);
                    this.mApis.put("1165118609", ly1Var);
                }
                Pair<Boolean, l12> a = n12.a(ly1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = ly1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 M = ky1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                gy1 gy1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("5236036", gy1Var);
                }
                Pair<Boolean, l12> a = n12.a(gy1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = gy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                ny1 ny1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ny1Var);
                }
                Pair<Boolean, l12> a = n12.a(ny1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = ny1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                py1 py1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof py1)) {
                    py1Var = (py1) obj;
                } else {
                    py1Var = new py1(this.mSwanApiContext);
                    this.mApis.put("-137346255", py1Var);
                }
                Pair<Boolean, l12> a = n12.a(py1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = py1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                py1 py1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof py1)) {
                    py1Var = (py1) obj;
                } else {
                    py1Var = new py1(this.mSwanApiContext);
                    this.mApis.put("-137346255", py1Var);
                }
                Pair<Boolean, l12> a = n12.a(py1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = py1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                qy1 qy1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("-397373095", qy1Var);
                }
                Pair<Boolean, l12> a = n12.a(qy1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = qy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                qy1 qy1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("-397373095", qy1Var);
                }
                Pair<Boolean, l12> a = n12.a(qy1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = qy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                qy1 qy1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("-397373095", qy1Var);
                }
                Pair<Boolean, l12> a = n12.a(qy1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = qy1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                h02 h02Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("538070032", h02Var);
                }
                Pair<Boolean, l12> a = n12.a(h02Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = h02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ty1Var);
                }
                Pair<Boolean, l12> a = n12.a(ty1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = ty1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("968563034", az1Var);
                }
                Pair<Boolean, l12> a = n12.a(az1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = az1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("453220699", zy1Var);
                }
                Pair<Boolean, l12> a = n12.a(zy1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = zy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                zy1 zy1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("453220699", zy1Var);
                }
                Pair<Boolean, l12> a = n12.a(zy1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = zy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                az1 az1Var;
                String a;
                try {
                    k12.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof az1)) {
                        az1Var = (az1) obj;
                    } else {
                        az1Var = new az1(this.mSwanApiContext);
                        this.mApis.put("968563034", az1Var);
                    }
                    Pair<Boolean, l12> a2 = n12.a(az1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((l12) a2.second).a();
                    } else if (tb2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<l12, JSONObject> t = px1.t(jsObject);
                        if (!((l12) t.first).isSuccess()) {
                            a = ((l12) t.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) t.second;
                            if (jSONObject == null) {
                                a = l12.a.a();
                            } else {
                                m12 V = az1Var.V(jSONObject);
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
                        k12.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                j23 j23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof j23)) {
                    j23Var = (j23) obj;
                } else {
                    j23Var = new j23(this.mSwanApiContext);
                    this.mApis.put("-336396851", j23Var);
                }
                Pair<Boolean, l12> a = n12.a(j23Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = j23Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                j23 j23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof j23)) {
                    j23Var = (j23) obj;
                } else {
                    j23Var = new j23(this.mSwanApiContext);
                    this.mApis.put("-336396851", j23Var);
                }
                Pair<Boolean, l12> a = n12.a(j23Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = j23Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                z13 z13Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof z13)) {
                    z13Var = (z13) obj;
                } else {
                    z13Var = new z13(this.mSwanApiContext);
                    this.mApis.put("1854689529", z13Var);
                }
                Pair<Boolean, l12> a = n12.a(z13Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = z13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                j23 j23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof j23)) {
                    j23Var = (j23) obj;
                } else {
                    j23Var = new j23(this.mSwanApiContext);
                    this.mApis.put("-336396851", j23Var);
                }
                Pair<Boolean, l12> a = n12.a(j23Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = j23Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                u43 u43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof u43)) {
                    u43Var = (u43) obj;
                } else {
                    u43Var = new u43(this.mSwanApiContext);
                    this.mApis.put("-254510461", u43Var);
                }
                Pair<Boolean, l12> a = n12.a(u43Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = u43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                u43 u43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof u43)) {
                    u43Var = (u43) obj;
                } else {
                    u43Var = new u43(this.mSwanApiContext);
                    this.mApis.put("-254510461", u43Var);
                }
                Pair<Boolean, l12> a = n12.a(u43Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = u43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                u43 u43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof u43)) {
                    u43Var = (u43) obj;
                } else {
                    u43Var = new u43(this.mSwanApiContext);
                    this.mApis.put("-254510461", u43Var);
                }
                Pair<Boolean, l12> a = n12.a(u43Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = u43Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                nd2 nd2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof nd2)) {
                    nd2Var = (nd2) obj;
                } else {
                    nd2Var = new nd2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", nd2Var);
                }
                Pair<Boolean, l12> a = n12.a(nd2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = nd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                fc2 fc2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof fc2)) {
                    fc2Var = (fc2) obj;
                } else {
                    fc2Var = new fc2(this.mSwanApiContext);
                    this.mApis.put("423661539", fc2Var);
                }
                Pair<Boolean, l12> a = n12.a(fc2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = fc2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                pl3 pl3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof pl3)) {
                    pl3Var = (pl3) obj;
                } else {
                    pl3Var = new pl3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", pl3Var);
                }
                Pair<Boolean, l12> a = n12.a(pl3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = pl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", ez1Var);
                }
                Pair<Boolean, l12> a = n12.a(ez1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = ez1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", ez1Var);
                }
                Pair<Boolean, l12> a = n12.a(ez1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = ez1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("1968522584", fz1Var);
                }
                Pair<Boolean, l12> a = n12.a(fz1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = fz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("1317280190", hz1Var);
                }
                Pair<Boolean, l12> a = n12.a(hz1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = hz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-420075743", iz1Var);
                }
                Pair<Boolean, l12> a = n12.a(iz1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = iz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("1792515533", gz1Var);
                }
                Pair<Boolean, l12> a = n12.a(gz1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = gz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("1968522584", fz1Var);
                }
                Pair<Boolean, l12> a = n12.a(fz1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = fz1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = lz1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = lz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                kz1 kz1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("450273045", kz1Var);
                }
                Pair<Boolean, l12> a = n12.a(kz1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = kz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = lz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = lz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = lz1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                jg3 jg3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof jg3)) {
                    jg3Var = (jg3) obj;
                } else {
                    jg3Var = new jg3(this.mSwanApiContext);
                    this.mApis.put("712777136", jg3Var);
                }
                Pair<Boolean, l12> a = n12.a(jg3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = jg3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = oz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = oz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = nz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = nz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = oz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = oz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = nz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = nz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = oz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = oz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = nz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = nz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = nz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 R = oz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 T = oz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 R = nz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 T = nz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 U = oz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 W = oz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 U = nz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 W = nz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("823117982", qz1Var);
                }
                Pair<Boolean, l12> a = n12.a(qz1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 E = qz1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-947445811", rz1Var);
                }
                Pair<Boolean, l12> a = n12.a(rz1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = rz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("1936205521", yz1Var);
                }
                Pair<Boolean, l12> a = n12.a(yz1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = yz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                xz1 xz1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("1694151270", xz1Var);
                }
                Pair<Boolean, l12> a = n12.a(xz1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = xz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", zz1Var);
                }
                Pair<Boolean, l12> a = n12.a(zz1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = zz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                a02 a02Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof a02)) {
                    a02Var = (a02) obj;
                } else {
                    a02Var = new a02(this.mSwanApiContext);
                    this.mApis.put("-1569246082", a02Var);
                }
                Pair<Boolean, l12> a = n12.a(a02Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = a02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1099851202", c02Var);
                }
                Pair<Boolean, l12> a = n12.a(c02Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = c02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-1707203360", b02Var);
                }
                Pair<Boolean, l12> a = n12.a(b02Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = b02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", vz1Var);
                }
                Pair<Boolean, l12> a = n12.a(vz1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = vz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                fz2 fz2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof fz2)) {
                    fz2Var = (fz2) obj;
                } else {
                    fz2Var = new fz2(this.mSwanApiContext);
                    this.mApis.put("1161486049", fz2Var);
                }
                Pair<Boolean, l12> a = n12.a(fz2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = fz2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("447234992", f02Var);
                }
                Pair<Boolean, l12> a = n12.a(f02Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = f02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", tz1Var);
                }
                Pair<Boolean, l12> a = n12.a(tz1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = tz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", wz1Var);
                }
                Pair<Boolean, l12> a = n12.a(wz1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = wz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                uz1 uz1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("99997465", uz1Var);
                }
                Pair<Boolean, l12> a = n12.a(uz1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = uz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                vz1 vz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", vz1Var);
                }
                Pair<Boolean, l12> a = n12.a(vz1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = vz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                f02 f02Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("447234992", f02Var);
                }
                Pair<Boolean, l12> a = n12.a(f02Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = f02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                tz1 tz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", tz1Var);
                }
                Pair<Boolean, l12> a = n12.a(tz1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = tz1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                wz1 wz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", wz1Var);
                }
                Pair<Boolean, l12> a = n12.a(wz1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = wz1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("201194468", q02Var);
                }
                Pair<Boolean, l12> a = n12.a(q02Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = q02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-1412306947", m02Var);
                }
                Pair<Boolean, l12> a = n12.a(m02Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = m02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("1626415364", n02Var);
                }
                Pair<Boolean, l12> a = n12.a(n02Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = n02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                p02 p02Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-836768778", p02Var);
                }
                Pair<Boolean, l12> a = n12.a(p02Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = p02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-810858308", r02Var);
                }
                Pair<Boolean, l12> a = n12.a(r02Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = r02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = v02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                s02 s02Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof s02)) {
                    s02Var = (s02) obj;
                } else {
                    s02Var = new s02(this.mSwanApiContext);
                    this.mApis.put("-2097727681", s02Var);
                }
                Pair<Boolean, l12> a = n12.a(s02Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = s02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("2084449317", o02Var);
                }
                Pair<Boolean, l12> a = n12.a(o02Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = o02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                rd3 rd3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof rd3)) {
                    rd3Var = (rd3) obj;
                } else {
                    rd3Var = new rd3(this.mSwanApiContext);
                    this.mApis.put("1031678042", rd3Var);
                }
                Pair<Boolean, l12> a = n12.a(rd3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = rd3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("1751900130", t02Var);
                }
                Pair<Boolean, l12> a = n12.a(t02Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = t02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                sc3 sc3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof sc3)) {
                    sc3Var = (sc3) obj;
                } else {
                    sc3Var = new sc3(this.mSwanApiContext);
                    this.mApis.put("1748196865", sc3Var);
                }
                Pair<Boolean, l12> a = n12.a(sc3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = sc3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("589529211", u02Var);
                }
                Pair<Boolean, l12> a = n12.a(u02Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = u02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-577481801", x02Var);
                }
                Pair<Boolean, l12> a = n12.a(x02Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = x02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 E = v02Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = v02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = v02Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = ck3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = ck3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = ck3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = ck3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = ck3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final nx1 nx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                tx1 tx1Var;
                Object obj = this.mApis.get("1930258908");
                if (obj != null && (obj instanceof tx1)) {
                    tx1Var = (tx1) obj;
                } else {
                    tx1Var = new tx1(this.mSwanApiContext);
                    this.mApis.put("1930258908", tx1Var);
                }
                Pair<Boolean, l12> a = n12.a(tx1Var, "swanAPI/checkSession");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = tx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getLoginCode(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ux1Var);
                }
                Pair<Boolean, l12> a = n12.a(ux1Var, "swanAPI/getLoginCode");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = ux1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                vx1 vx1Var;
                Object obj = this.mApis.get("1754780133");
                if (obj != null && (obj instanceof vx1)) {
                    vx1Var = (vx1) obj;
                } else {
                    vx1Var = new vx1(this.mSwanApiContext);
                    this.mApis.put("1754780133", vx1Var);
                }
                Pair<Boolean, l12> a = n12.a(vx1Var, "swanAPI/getOpenId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = vx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                cx1 cx1Var;
                Object obj = this.mApis.get("-343998465");
                if (obj != null && (obj instanceof cx1)) {
                    cx1Var = (cx1) obj;
                } else {
                    cx1Var = new cx1(this.mSwanApiContext);
                    this.mApis.put("-343998465", cx1Var);
                }
                Pair<Boolean, l12> a = n12.a(cx1Var, "swanAPI/getUnionBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = cx1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String login(String str) {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ux1Var);
                }
                Pair<Boolean, l12> a = n12.a(ux1Var, "swanAPI/login");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.login")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = ux1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                sx1 sx1Var;
                Object obj = this.mApis.get("-337742792");
                if (obj != null && (obj instanceof sx1)) {
                    sx1Var = (sx1) obj;
                } else {
                    sx1Var = new sx1(this.mSwanApiContext);
                    this.mApis.put("-337742792", sx1Var);
                }
                Pair<Boolean, l12> a = n12.a(sx1Var, "swanAPI/isBaiduAccountSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = sx1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String isLoginSync() {
                ux1 ux1Var;
                Object obj = this.mApis.get("-1017914143");
                if (obj != null && (obj instanceof ux1)) {
                    ux1Var = (ux1) obj;
                } else {
                    ux1Var = new ux1(this.mSwanApiContext);
                    this.mApis.put("-1017914143", ux1Var);
                }
                Pair<Boolean, l12> a = n12.a(ux1Var, "swanAPI/isLoginSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = ux1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        hashMap.put("_naBasic", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", wx1Var);
                }
                Pair<Boolean, l12> a = n12.a(wx1Var, "swanAPI/loadSubPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = wx1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String loadSubPackages(String str) {
                wx1 wx1Var;
                Object obj = this.mApis.get("-1249666566");
                if (obj != null && (obj instanceof wx1)) {
                    wx1Var = (wx1) obj;
                } else {
                    wx1Var = new wx1(this.mSwanApiContext);
                    this.mApis.put("-1249666566", wx1Var);
                }
                Pair<Boolean, l12> a = n12.a(wx1Var, "swanAPI/loadSubPackages");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = wx1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naBookshelf", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/deleteBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = dq1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/insertBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 P = dq1Var.P(str);
                if (P == null) {
                    return "";
                }
                return P.a();
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/navigateToBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 U = dq1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/queryBookshelf");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 V = dq1Var.V(str);
                if (V == null) {
                    return "";
                }
                return V.a();
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                dq1 dq1Var;
                Object obj = this.mApis.get("1460300387");
                if (obj != null && (obj instanceof dq1)) {
                    dq1Var = (dq1) obj;
                } else {
                    dq1Var = new dq1(this.mSwanApiContext);
                    this.mApis.put("1460300387", dq1Var);
                }
                Pair<Boolean, l12> a = n12.a(dq1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 X = dq1Var.X(str);
                if (X == null) {
                    return "";
                }
                return X.a();
            }
        });
        hashMap.put("_naCoupon", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", qx1Var);
                }
                Pair<Boolean, l12> a = n12.a(qx1Var, "swanAPI/coupon/getPlatformCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = qx1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", qx1Var);
                }
                Pair<Boolean, l12> a = n12.a(qx1Var, "swanAPI/coupon/getUserCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = qx1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                qx1 qx1Var;
                Object obj = this.mApis.get("-277316359");
                if (obj != null && (obj instanceof qx1)) {
                    qx1Var = (qx1) obj;
                } else {
                    qx1Var = new qx1(this.mSwanApiContext);
                    this.mApis.put("-277316359", qx1Var);
                }
                Pair<Boolean, l12> a = n12.a(qx1Var, "swanAPI/coupon/takeCoupons");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = qx1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naFavorite", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getFavorStatus(String str) {
                yx1 yx1Var;
                Object obj = this.mApis.get("-1225406515");
                if (obj != null && (obj instanceof yx1)) {
                    yx1Var = (yx1) obj;
                } else {
                    yx1Var = new yx1(this.mSwanApiContext);
                    this.mApis.put("-1225406515", yx1Var);
                }
                Pair<Boolean, l12> a = n12.a(yx1Var, "swanAPI/getFavorStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = yx1Var.x(str);
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
                Pair<Boolean, l12> a = n12.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = showFavoriteGuideApi.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        hashMap.put("_naFile", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                ay1 ay1Var;
                Object obj = this.mApis.get("-2057135077");
                if (obj != null && (obj instanceof ay1)) {
                    ay1Var = (ay1) obj;
                } else {
                    ay1Var = new ay1(this.mSwanApiContext);
                    this.mApis.put("-2057135077", ay1Var);
                }
                Pair<Boolean, l12> a = n12.a(ay1Var, "swanAPI/shareFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = ay1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naGameCenter", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                pm2 pm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof pm2)) {
                    pm2Var = (pm2) obj;
                } else {
                    pm2Var = new pm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", pm2Var);
                }
                Pair<Boolean, l12> a = n12.a(pm2Var, "swanAPI/postGameCenterMessage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = pm2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                pm2 pm2Var;
                Object obj = this.mApis.get("2077414795");
                if (obj != null && (obj instanceof pm2)) {
                    pm2Var = (pm2) obj;
                } else {
                    pm2Var = new pm2(this.mSwanApiContext);
                    this.mApis.put("2077414795", pm2Var);
                }
                Pair<Boolean, l12> a = n12.a(pm2Var, "swanAPI/postGameCenterMessageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = pm2Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naHostDownloadManager", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String download(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/download");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = by1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openFile(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/openFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = by1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String query(String str) {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/query");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 query = by1Var.query(str);
                if (query == null) {
                    return "";
                }
                return query.a();
            }

            @JavascriptInterface
            public String openDownloadCenter() {
                by1 by1Var;
                Object obj = this.mApis.get("-170124576");
                if (obj != null && (obj instanceof by1)) {
                    by1Var = (by1) obj;
                } else {
                    by1Var = new by1(this.mSwanApiContext);
                    this.mApis.put("-170124576", by1Var);
                }
                Pair<Boolean, l12> a = n12.a(by1Var, "swanAPI/openDownloadCenter");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = by1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naImage", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                dz2 dz2Var;
                Object obj = this.mApis.get("1445003743");
                if (obj != null && (obj instanceof dz2)) {
                    dz2Var = (dz2) obj;
                } else {
                    dz2Var = new dz2(this.mSwanApiContext);
                    this.mApis.put("1445003743", dz2Var);
                }
                Pair<Boolean, l12> a = n12.a(dz2Var, "swanAPI/callImageMenu");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = dz2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String compressImage(String str) {
                ey1 ey1Var;
                Object obj = this.mApis.get("-1252730367");
                if (obj != null && (obj instanceof ey1)) {
                    ey1Var = (ey1) obj;
                } else {
                    ey1Var = new ey1(this.mSwanApiContext);
                    this.mApis.put("-1252730367", ey1Var);
                }
                Pair<Boolean, l12> a = n12.a(ey1Var, "swanAPI/compressImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = ey1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naInteraction", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/closeTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = my1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/closeTabBarRedDot");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = my1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/hideNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = iy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/openMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = ky1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String openPicker(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/openPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = ky1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/openTabBar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = my1Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                jy1 jy1Var;
                Object obj = this.mApis.get("-1750613704");
                if (obj != null && (obj instanceof jy1)) {
                    jy1Var = (jy1) obj;
                } else {
                    jy1Var = new jy1(this.mSwanApiContext);
                    this.mApis.put("-1750613704", jy1Var);
                }
                Pair<Boolean, l12> a = n12.a(jy1Var, "swanAPI/pageScrollTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = jy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/setNavigationBarColor");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = iy1Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/setNavigationBarTitle");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = iy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                my1 my1Var;
                Object obj = this.mApis.get("-1871435471");
                if (obj != null && (obj instanceof my1)) {
                    my1Var = (my1) obj;
                } else {
                    my1Var = new my1(this.mSwanApiContext);
                    this.mApis.put("-1871435471", my1Var);
                }
                Pair<Boolean, l12> a = n12.a(my1Var, "swanAPI/setTabBarItem");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = my1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/showDatePickerView");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 L = ky1Var.L(str);
                if (L == null) {
                    return "";
                }
                return L.a();
            }

            @JavascriptInterface
            public String showHalfScreenWebview(String str) {
                oy1 oy1Var;
                Object obj = this.mApis.get("1172469410");
                if (obj != null && (obj instanceof oy1)) {
                    oy1Var = (oy1) obj;
                } else {
                    oy1Var = new oy1(this.mSwanApiContext);
                    this.mApis.put("1172469410", oy1Var);
                }
                Pair<Boolean, l12> a = n12.a(oy1Var, "swanAPI/showHalfScreenWebview");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = oy1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String showLoading(String str) {
                gy1 gy1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("5236036", gy1Var);
                }
                Pair<Boolean, l12> a = n12.a(gy1Var, "swanAPI/showLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = gy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String showModal(String str) {
                hy1 hy1Var;
                Object obj = this.mApis.get("1913747800");
                if (obj != null && (obj instanceof hy1)) {
                    hy1Var = (hy1) obj;
                } else {
                    hy1Var = new hy1(this.mSwanApiContext);
                    this.mApis.put("1913747800", hy1Var);
                }
                Pair<Boolean, l12> a = n12.a(hy1Var, "swanAPI/showModal");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = hy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                iy1 iy1Var;
                Object obj = this.mApis.get("-246386074");
                if (obj != null && (obj instanceof iy1)) {
                    iy1Var = (iy1) obj;
                } else {
                    iy1Var = new iy1(this.mSwanApiContext);
                    this.mApis.put("-246386074", iy1Var);
                }
                Pair<Boolean, l12> a = n12.a(iy1Var, "swanAPI/showNavigationBarLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = iy1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String showToast(String str) {
                ny1 ny1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ny1Var);
                }
                Pair<Boolean, l12> a = n12.a(ny1Var, "swanAPI/showToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 Q = ny1Var.Q(str);
                if (Q == null) {
                    return "";
                }
                return Q.a();
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                ly1 ly1Var;
                Object obj = this.mApis.get("1165118609");
                if (obj != null && (obj instanceof ly1)) {
                    ly1Var = (ly1) obj;
                } else {
                    ly1Var = new ly1(this.mSwanApiContext);
                    this.mApis.put("1165118609", ly1Var);
                }
                Pair<Boolean, l12> a = n12.a(ly1Var, "swanAPI/stopPullDownRefresh");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = ly1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                ky1 ky1Var;
                Object obj = this.mApis.get("-108978463");
                if (obj != null && (obj instanceof ky1)) {
                    ky1Var = (ky1) obj;
                } else {
                    ky1Var = new ky1(this.mSwanApiContext);
                    this.mApis.put("-108978463", ky1Var);
                }
                Pair<Boolean, l12> a = n12.a(ky1Var, "swanAPI/updateMultiPicker");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 M = ky1Var.M(str);
                if (M == null) {
                    return "";
                }
                return M.a();
            }

            @JavascriptInterface
            public String hideLoading() {
                gy1 gy1Var;
                Object obj = this.mApis.get("5236036");
                if (obj != null && (obj instanceof gy1)) {
                    gy1Var = (gy1) obj;
                } else {
                    gy1Var = new gy1(this.mSwanApiContext);
                    this.mApis.put("5236036", gy1Var);
                }
                Pair<Boolean, l12> a = n12.a(gy1Var, "swanAPI/hideLoading");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = gy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hideToast() {
                ny1 ny1Var;
                Object obj = this.mApis.get("1159492510");
                if (obj != null && (obj instanceof ny1)) {
                    ny1Var = (ny1) obj;
                } else {
                    ny1Var = new ny1(this.mSwanApiContext);
                    this.mApis.put("1159492510", ny1Var);
                }
                Pair<Boolean, l12> a = n12.a(ny1Var, "swanAPI/hideToast");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = ny1Var.K();
                if (K == null) {
                    return "";
                }
                return K.a();
            }
        });
        hashMap.put("_naKeyboard", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                py1 py1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof py1)) {
                    py1Var = (py1) obj;
                } else {
                    py1Var = new py1(this.mSwanApiContext);
                    this.mApis.put("-137346255", py1Var);
                }
                Pair<Boolean, l12> a = n12.a(py1Var, "swanAPI/startKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = py1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                py1 py1Var;
                Object obj = this.mApis.get("-137346255");
                if (obj != null && (obj instanceof py1)) {
                    py1Var = (py1) obj;
                } else {
                    py1Var = new py1(this.mSwanApiContext);
                    this.mApis.put("-137346255", py1Var);
                }
                Pair<Boolean, l12> a = n12.a(py1Var, "swanAPI/stopKeyboardHeightChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = py1Var.D();
                if (D == null) {
                    return "";
                }
                return D.a();
            }
        });
        hashMap.put("_naLocationService", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                qy1 qy1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("-397373095", qy1Var);
                }
                Pair<Boolean, l12> a = n12.a(qy1Var, "swanAPI/getLocation");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = qy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                qy1 qy1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("-397373095", qy1Var);
                }
                Pair<Boolean, l12> a = n12.a(qy1Var, "swanAPI/startLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = qy1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                qy1 qy1Var;
                Object obj = this.mApis.get("-397373095");
                if (obj != null && (obj instanceof qy1)) {
                    qy1Var = (qy1) obj;
                } else {
                    qy1Var = new qy1(this.mSwanApiContext);
                    this.mApis.put("-397373095", qy1Var);
                }
                Pair<Boolean, l12> a = n12.a(qy1Var, "swanAPI/stopLocationUpdate");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = qy1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }
        });
        hashMap.put("_naMenu", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getMenuButtonBoundingClientRect() {
                h02 h02Var;
                Object obj = this.mApis.get("538070032");
                if (obj != null && (obj instanceof h02)) {
                    h02Var = (h02) obj;
                } else {
                    h02Var = new h02(this.mSwanApiContext);
                    this.mApis.put("538070032", h02Var);
                }
                Pair<Boolean, l12> a = n12.a(h02Var, "swanAPI/getMenuButtonBoundingClientRect");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = h02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naNetwork", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String callService(String str) {
                ty1 ty1Var;
                Object obj = this.mApis.get("-1076509454");
                if (obj != null && (obj instanceof ty1)) {
                    ty1Var = (ty1) obj;
                } else {
                    ty1Var = new ty1(this.mSwanApiContext);
                    this.mApis.put("-1076509454", ty1Var);
                }
                Pair<Boolean, l12> a = n12.a(ty1Var, "swanAPI/callService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.callService")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = ty1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                az1 az1Var;
                Object obj = this.mApis.get("968563034");
                if (obj != null && (obj instanceof az1)) {
                    az1Var = (az1) obj;
                } else {
                    az1Var = new az1(this.mSwanApiContext);
                    this.mApis.put("968563034", az1Var);
                }
                Pair<Boolean, l12> a = n12.a(az1Var, "swanAPI/cancelRequest");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = az1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                zy1 zy1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("453220699", zy1Var);
                }
                Pair<Boolean, l12> a = n12.a(zy1Var, "swanAPI/networkStatusChange");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = zy1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getNetworkType() {
                zy1 zy1Var;
                Object obj = this.mApis.get("453220699");
                if (obj != null && (obj instanceof zy1)) {
                    zy1Var = (zy1) obj;
                } else {
                    zy1Var = new zy1(this.mSwanApiContext);
                    this.mApis.put("453220699", zy1Var);
                }
                Pair<Boolean, l12> a = n12.a(zy1Var, "swanAPI/getNetworkType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = zy1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                az1 az1Var;
                String a;
                try {
                    k12.c().a("request");
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof az1)) {
                        az1Var = (az1) obj;
                    } else {
                        az1Var = new az1(this.mSwanApiContext);
                        this.mApis.put("968563034", az1Var);
                    }
                    Pair<Boolean, l12> a2 = n12.a(az1Var, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        a = ((l12) a2.second).a();
                    } else if (tb2.a(this.mSwanApiContext.f(), "Network.request")) {
                        a = new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<l12, JSONObject> u = px1.u(str);
                        if (!((l12) u.first).isSuccess()) {
                            a = ((l12) u.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) u.second;
                            if (jSONObject == null) {
                                a = l12.a.a();
                            } else {
                                m12 V = az1Var.V(jSONObject);
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
                        k12.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPayment", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String chooseCoupon(String str) {
                j23 j23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof j23)) {
                    j23Var = (j23) obj;
                } else {
                    j23Var = new j23(this.mSwanApiContext);
                    this.mApis.put("-336396851", j23Var);
                }
                Pair<Boolean, l12> a = n12.a(j23Var, "swanAPI/chooseCoupon");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = j23Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getPaymentInfo(String str) {
                j23 j23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof j23)) {
                    j23Var = (j23) obj;
                } else {
                    j23Var = new j23(this.mSwanApiContext);
                    this.mApis.put("-336396851", j23Var);
                }
                Pair<Boolean, l12> a = n12.a(j23Var, "swanAPI/getPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = j23Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String requestThirdPayment(String str) {
                z13 z13Var;
                Object obj = this.mApis.get("1854689529");
                if (obj != null && (obj instanceof z13)) {
                    z13Var = (z13) obj;
                } else {
                    z13Var = new z13(this.mSwanApiContext);
                    this.mApis.put("1854689529", z13Var);
                }
                Pair<Boolean, l12> a = n12.a(z13Var, "swanAPI/requestThirdPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = z13Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setPaymentInfo(String str) {
                j23 j23Var;
                Object obj = this.mApis.get("-336396851");
                if (obj != null && (obj instanceof j23)) {
                    j23Var = (j23) obj;
                } else {
                    j23Var = new j23(this.mSwanApiContext);
                    this.mApis.put("-336396851", j23Var);
                }
                Pair<Boolean, l12> a = n12.a(j23Var, "swanAPI/setPaymentInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = j23Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPlugin", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                u43 u43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof u43)) {
                    u43Var = (u43) obj;
                } else {
                    u43Var = new u43(this.mSwanApiContext);
                    this.mApis.put("-254510461", u43Var);
                }
                Pair<Boolean, l12> a = n12.a(u43Var, "swanAPI/invokePluginChooseAddress");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = u43Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                u43 u43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof u43)) {
                    u43Var = (u43) obj;
                } else {
                    u43Var = new u43(this.mSwanApiContext);
                    this.mApis.put("-254510461", u43Var);
                }
                Pair<Boolean, l12> a = n12.a(u43Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = u43Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                u43 u43Var;
                Object obj = this.mApis.get("-254510461");
                if (obj != null && (obj instanceof u43)) {
                    u43Var = (u43) obj;
                } else {
                    u43Var = new u43(this.mSwanApiContext);
                    this.mApis.put("-254510461", u43Var);
                }
                Pair<Boolean, l12> a = n12.a(u43Var, "swanAPI/invokePluginPayment");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = u43Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naPrefetch", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                nd2 nd2Var;
                Object obj = this.mApis.get("-2068479848");
                if (obj != null && (obj instanceof nd2)) {
                    nd2Var = (nd2) obj;
                } else {
                    nd2Var = new nd2(this.mSwanApiContext);
                    this.mApis.put("-2068479848", nd2Var);
                }
                Pair<Boolean, l12> a = n12.a(nd2Var, "swanAPI/prefetchResources");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = nd2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPreload", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                fc2 fc2Var;
                Object obj = this.mApis.get("423661539");
                if (obj != null && (obj instanceof fc2)) {
                    fc2Var = (fc2) obj;
                } else {
                    fc2Var = new fc2(this.mSwanApiContext);
                    this.mApis.put("423661539", fc2Var);
                }
                Pair<Boolean, l12> a = n12.a(fc2Var, "swanAPI/preloadStatus");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = fc2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }
        });
        hashMap.put("_naPrivateFile", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                pl3 pl3Var;
                Object obj = this.mApis.get("-1929343869");
                if (obj != null && (obj instanceof pl3)) {
                    pl3Var = (pl3) obj;
                } else {
                    pl3Var = new pl3(this.mSwanApiContext);
                    this.mApis.put("-1929343869", pl3Var);
                }
                Pair<Boolean, l12> a = n12.a(pl3Var, "swanAPI/uploadFileToBos");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = pl3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }
        });
        hashMap.put("_naRouter", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String hideModalPage() {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", ez1Var);
                }
                Pair<Boolean, l12> a = n12.a(ez1Var, "swanAPI/hideModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = ez1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                ez1 ez1Var;
                Object obj = this.mApis.get("-1495163604");
                if (obj != null && (obj instanceof ez1)) {
                    ez1Var = (ez1) obj;
                } else {
                    ez1Var = new ez1(this.mSwanApiContext);
                    this.mApis.put("-1495163604", ez1Var);
                }
                Pair<Boolean, l12> a = n12.a(ez1Var, "swanAPI/navigateBack");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = ez1Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("1968522584", fz1Var);
                }
                Pair<Boolean, l12> a = n12.a(fz1Var, "swanAPI/navigateTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = fz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                hz1 hz1Var;
                Object obj = this.mApis.get("1317280190");
                if (obj != null && (obj instanceof hz1)) {
                    hz1Var = (hz1) obj;
                } else {
                    hz1Var = new hz1(this.mSwanApiContext);
                    this.mApis.put("1317280190", hz1Var);
                }
                Pair<Boolean, l12> a = n12.a(hz1Var, "swanAPI/reLaunch");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = hz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String reLoadErrorPage(String str) {
                iz1 iz1Var;
                Object obj = this.mApis.get("-420075743");
                if (obj != null && (obj instanceof iz1)) {
                    iz1Var = (iz1) obj;
                } else {
                    iz1Var = new iz1(this.mSwanApiContext);
                    this.mApis.put("-420075743", iz1Var);
                }
                Pair<Boolean, l12> a = n12.a(iz1Var, "swanAPI/reLoadErrorPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = iz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                gz1 gz1Var;
                Object obj = this.mApis.get("1792515533");
                if (obj != null && (obj instanceof gz1)) {
                    gz1Var = (gz1) obj;
                } else {
                    gz1Var = new gz1(this.mSwanApiContext);
                    this.mApis.put("1792515533", gz1Var);
                }
                Pair<Boolean, l12> a = n12.a(gz1Var, "swanAPI/redirectTo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = gz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String showModalPage(String str) {
                fz1 fz1Var;
                Object obj = this.mApis.get("1968522584");
                if (obj != null && (obj instanceof fz1)) {
                    fz1Var = (fz1) obj;
                } else {
                    fz1Var = new fz1(this.mSwanApiContext);
                    this.mApis.put("1968522584", fz1Var);
                }
                Pair<Boolean, l12> a = n12.a(fz1Var, "swanAPI/showModalPage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = fz1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naSetting", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getAppInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = lz1Var.F();
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getSlaveIdSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = lz1Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                kz1 kz1Var;
                Object obj = this.mApis.get("450273045");
                if (obj != null && (obj instanceof kz1)) {
                    kz1Var = (kz1) obj;
                } else {
                    kz1Var = new kz1(this.mSwanApiContext);
                    this.mApis.put("450273045", kz1Var);
                }
                Pair<Boolean, l12> a = n12.a(kz1Var, "swanAPI/isAllowedAdOpenAppSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = kz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSetting(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getSetting");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = lz1Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getSwanId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = lz1Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                lz1 lz1Var;
                Object obj = this.mApis.get("-594895721");
                if (obj != null && (obj instanceof lz1)) {
                    lz1Var = (lz1) obj;
                } else {
                    lz1Var = new lz1(this.mSwanApiContext);
                    this.mApis.put("-594895721", lz1Var);
                }
                Pair<Boolean, l12> a = n12.a(lz1Var, "swanAPI/getUserInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = lz1Var.J(str);
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naStatisticEvent", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                jg3 jg3Var;
                Object obj = this.mApis.get("712777136");
                if (obj != null && (obj instanceof jg3)) {
                    jg3Var = (jg3) obj;
                } else {
                    jg3Var = new jg3(this.mSwanApiContext);
                    this.mApis.put("712777136", jg3Var);
                }
                Pair<Boolean, l12> a = n12.a(jg3Var, "swanAPI/ubcAndCeresStatisticEvent");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = jg3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }
        });
        hashMap.put("_naStorage", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/clearGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = oz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/clearGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = oz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String clearStorage() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/clearStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = nz1Var.A();
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String clearStorageSync() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/clearStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = nz1Var.C();
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = oz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = oz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getStorageInfo() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = nz1Var.G();
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String getStorageInfoSync() {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = nz1Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = oz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/getGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = oz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String getStorage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 D = nz1Var.D(str);
                if (D == null) {
                    return "";
                }
                return D.a();
            }

            @JavascriptInterface
            public String getStorageInfoAsync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = nz1Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/getStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 K = nz1Var.K(str);
                if (K == null) {
                    return "";
                }
                return K.a();
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/removeGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 R = oz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/removeGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 T = oz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/removeStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 R = nz1Var.R(str);
                if (R == null) {
                    return "";
                }
                return R.a();
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/removeStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 T = nz1Var.T(str);
                if (T == null) {
                    return "";
                }
                return T.a();
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/setGlobalStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 U = oz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                oz1 oz1Var;
                Object obj = this.mApis.get("-804054859");
                if (obj != null && (obj instanceof oz1)) {
                    oz1Var = (oz1) obj;
                } else {
                    oz1Var = new oz1(this.mSwanApiContext);
                    this.mApis.put("-804054859", oz1Var);
                }
                Pair<Boolean, l12> a = n12.a(oz1Var, "swanAPI/setGlobalStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 W = oz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }

            @JavascriptInterface
            public String setStorage(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/setStorage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 U = nz1Var.U(str);
                if (U == null) {
                    return "";
                }
                return U.a();
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                nz1 nz1Var;
                Object obj = this.mApis.get("130910081");
                if (obj != null && (obj instanceof nz1)) {
                    nz1Var = (nz1) obj;
                } else {
                    nz1Var = new nz1(this.mSwanApiContext);
                    this.mApis.put("130910081", nz1Var);
                }
                Pair<Boolean, l12> a = n12.a(nz1Var, "swanAPI/setStorageSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 W = nz1Var.W(str);
                if (W == null) {
                    return "";
                }
                return W.a();
            }
        });
        hashMap.put("_naSubscription", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String requestSubscribeFormId(String str) {
                qz1 qz1Var;
                Object obj = this.mApis.get("823117982");
                if (obj != null && (obj instanceof qz1)) {
                    qz1Var = (qz1) obj;
                } else {
                    qz1Var = new qz1(this.mSwanApiContext);
                    this.mApis.put("823117982", qz1Var);
                }
                Pair<Boolean, l12> a = n12.a(qz1Var, "swanAPI/subscription/requestSubscribeFormId");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 E = qz1Var.E(str);
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                rz1 rz1Var;
                Object obj = this.mApis.get("-947445811");
                if (obj != null && (obj instanceof rz1)) {
                    rz1Var = (rz1) obj;
                } else {
                    rz1Var = new rz1(this.mSwanApiContext);
                    this.mApis.put("-947445811", rz1Var);
                }
                Pair<Boolean, l12> a = n12.a(rz1Var, "swanAPI/subscribeService");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = rz1Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }
        });
        hashMap.put("_naSystem", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                yz1 yz1Var;
                Object obj = this.mApis.get("1936205521");
                if (obj != null && (obj instanceof yz1)) {
                    yz1Var = (yz1) obj;
                } else {
                    yz1Var = new yz1(this.mSwanApiContext);
                    this.mApis.put("1936205521", yz1Var);
                }
                Pair<Boolean, l12> a = n12.a(yz1Var, "swanAPI/exitFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = yz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                xz1 xz1Var;
                Object obj = this.mApis.get("1694151270");
                if (obj != null && (obj instanceof xz1)) {
                    xz1Var = (xz1) obj;
                } else {
                    xz1Var = new xz1(this.mSwanApiContext);
                    this.mApis.put("1694151270", xz1Var);
                }
                Pair<Boolean, l12> a = n12.a(xz1Var, "swanAPI/getDeviceInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = xz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getDeviceProfile(String str) {
                zz1 zz1Var;
                Object obj = this.mApis.get("-1321681619");
                if (obj != null && (obj instanceof zz1)) {
                    zz1Var = (zz1) obj;
                } else {
                    zz1Var = new zz1(this.mSwanApiContext);
                    this.mApis.put("-1321681619", zz1Var);
                }
                Pair<Boolean, l12> a = n12.a(zz1Var, "swanAPI/getDeviceProfile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = zz1Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                a02 a02Var;
                Object obj = this.mApis.get("-1569246082");
                if (obj != null && (obj instanceof a02)) {
                    a02Var = (a02) obj;
                } else {
                    a02Var = new a02(this.mSwanApiContext);
                    this.mApis.put("-1569246082", a02Var);
                }
                Pair<Boolean, l12> a = n12.a(a02Var, "swanAPI/makePhoneCall");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = a02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                c02 c02Var;
                Object obj = this.mApis.get("1099851202");
                if (obj != null && (obj instanceof c02)) {
                    c02Var = (c02) obj;
                } else {
                    c02Var = new c02(this.mSwanApiContext);
                    this.mApis.put("1099851202", c02Var);
                }
                Pair<Boolean, l12> a = n12.a(c02Var, "swanAPI/openSMSPanel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = c02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                b02 b02Var;
                Object obj = this.mApis.get("-1707203360");
                if (obj != null && (obj instanceof b02)) {
                    b02Var = (b02) obj;
                } else {
                    b02Var = new b02(this.mSwanApiContext);
                    this.mApis.put("-1707203360", b02Var);
                }
                Pair<Boolean, l12> a = n12.a(b02Var, "swanAPI/requestFullScreen");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = b02Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                vz1 vz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", vz1Var);
                }
                Pair<Boolean, l12> a = n12.a(vz1Var, "swanAPI/setClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = vz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String setErrorPageType(String str) {
                fz2 fz2Var;
                Object obj = this.mApis.get("1161486049");
                if (obj != null && (obj instanceof fz2)) {
                    fz2Var = (fz2) obj;
                } else {
                    fz2Var = new fz2(this.mSwanApiContext);
                    this.mApis.put("1161486049", fz2Var);
                }
                Pair<Boolean, l12> a = n12.a(fz2Var, "swanAPI/setErrorPageType");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = fz2Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String setMediaVolume(String str) {
                f02 f02Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("447234992", f02Var);
                }
                Pair<Boolean, l12> a = n12.a(f02Var, "swanAPI/setMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = f02Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                tz1 tz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", tz1Var);
                }
                Pair<Boolean, l12> a = n12.a(tz1Var, "swanAPI/startAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = tz1Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String startCompass(String str) {
                wz1 wz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", wz1Var);
                }
                Pair<Boolean, l12> a = n12.a(wz1Var, "swanAPI/startCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = wz1Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getBrightness() {
                uz1 uz1Var;
                Object obj = this.mApis.get("99997465");
                if (obj != null && (obj instanceof uz1)) {
                    uz1Var = (uz1) obj;
                } else {
                    uz1Var = new uz1(this.mSwanApiContext);
                    this.mApis.put("99997465", uz1Var);
                }
                Pair<Boolean, l12> a = n12.a(uz1Var, "swanAPI/getBrightness");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = uz1Var.y();
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getClipboardData() {
                vz1 vz1Var;
                Object obj = this.mApis.get("-518757484");
                if (obj != null && (obj instanceof vz1)) {
                    vz1Var = (vz1) obj;
                } else {
                    vz1Var = new vz1(this.mSwanApiContext);
                    this.mApis.put("-518757484", vz1Var);
                }
                Pair<Boolean, l12> a = n12.a(vz1Var, "swanAPI/getClipboardData");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = vz1Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getMediaVolume() {
                f02 f02Var;
                Object obj = this.mApis.get("447234992");
                if (obj != null && (obj instanceof f02)) {
                    f02Var = (f02) obj;
                } else {
                    f02Var = new f02(this.mSwanApiContext);
                    this.mApis.put("447234992", f02Var);
                }
                Pair<Boolean, l12> a = n12.a(f02Var, "swanAPI/getMediaVolume");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = f02Var.x();
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                tz1 tz1Var;
                Object obj = this.mApis.get("1372680763");
                if (obj != null && (obj instanceof tz1)) {
                    tz1Var = (tz1) obj;
                } else {
                    tz1Var = new tz1(this.mSwanApiContext);
                    this.mApis.put("1372680763", tz1Var);
                }
                Pair<Boolean, l12> a = n12.a(tz1Var, "swanAPI/stopAccelerometer");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = tz1Var.B();
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String stopCompass() {
                wz1 wz1Var;
                Object obj = this.mApis.get("1689255576");
                if (obj != null && (obj instanceof wz1)) {
                    wz1Var = (wz1) obj;
                } else {
                    wz1Var = new wz1(this.mSwanApiContext);
                    this.mApis.put("1689255576", wz1Var);
                }
                Pair<Boolean, l12> a = n12.a(wz1Var, "swanAPI/stopCompass");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 z = wz1Var.z();
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naUtils", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                q02 q02Var;
                Object obj = this.mApis.get("201194468");
                if (obj != null && (obj instanceof q02)) {
                    q02Var = (q02) obj;
                } else {
                    q02Var = new q02(this.mSwanApiContext);
                    this.mApis.put("201194468", q02Var);
                }
                Pair<Boolean, l12> a = n12.a(q02Var, "swanAPI/addToDesktop");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = q02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String calcMD5(String str) {
                m02 m02Var;
                Object obj = this.mApis.get("-1412306947");
                if (obj != null && (obj instanceof m02)) {
                    m02Var = (m02) obj;
                } else {
                    m02Var = new m02(this.mSwanApiContext);
                    this.mApis.put("-1412306947", m02Var);
                }
                Pair<Boolean, l12> a = n12.a(m02Var, "swanAPI/calcMD5");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = m02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                n02 n02Var;
                Object obj = this.mApis.get("1626415364");
                if (obj != null && (obj instanceof n02)) {
                    n02Var = (n02) obj;
                } else {
                    n02Var = new n02(this.mSwanApiContext);
                    this.mApis.put("1626415364", n02Var);
                }
                Pair<Boolean, l12> a = n12.a(n02Var, "swanAPI/checkAppInstalled");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = n02Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                p02 p02Var;
                Object obj = this.mApis.get("-836768778");
                if (obj != null && (obj instanceof p02)) {
                    p02Var = (p02) obj;
                } else {
                    p02Var = new p02(this.mSwanApiContext);
                    this.mApis.put("-836768778", p02Var);
                }
                Pair<Boolean, l12> a = n12.a(p02Var, "swanAPI/getCommonSysInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = p02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String getPerformanceLevel(String str) {
                r02 r02Var;
                Object obj = this.mApis.get("-810858308");
                if (obj != null && (obj instanceof r02)) {
                    r02Var = (r02) obj;
                } else {
                    r02Var = new r02(this.mSwanApiContext);
                    this.mApis.put("-810858308", r02Var);
                }
                Pair<Boolean, l12> a = n12.a(r02Var, "swanAPI/getPerformanceLevel");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = r02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String getSystemInfoAsync(String str) {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getSystemInfoAsync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = v02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String handleException(String str) {
                s02 s02Var;
                Object obj = this.mApis.get("-2097727681");
                if (obj != null && (obj instanceof s02)) {
                    s02Var = (s02) obj;
                } else {
                    s02Var = new s02(this.mSwanApiContext);
                    this.mApis.put("-2097727681", s02Var);
                }
                Pair<Boolean, l12> a = n12.a(s02Var, "swanAPI/handleException");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = s02Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String hasCloseHandler(String str) {
                o02 o02Var;
                Object obj = this.mApis.get("2084449317");
                if (obj != null && (obj instanceof o02)) {
                    o02Var = (o02) obj;
                } else {
                    o02Var = new o02(this.mSwanApiContext);
                    this.mApis.put("2084449317", o02Var);
                }
                Pair<Boolean, l12> a = n12.a(o02Var, "swanAPI/hasCloseHandler");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = o02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                rd3 rd3Var;
                Object obj = this.mApis.get("1031678042");
                if (obj != null && (obj instanceof rd3)) {
                    rd3Var = (rd3) obj;
                } else {
                    rd3Var = new rd3(this.mSwanApiContext);
                    this.mApis.put("1031678042", rd3Var);
                }
                Pair<Boolean, l12> a = n12.a(rd3Var, "swanAPI/hideCaptureScreenShareDialog");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 x = rd3Var.x(str);
                if (x == null) {
                    return "";
                }
                return x.a();
            }

            @JavascriptInterface
            public String logToFile(String str) {
                t02 t02Var;
                Object obj = this.mApis.get("1751900130");
                if (obj != null && (obj instanceof t02)) {
                    t02Var = (t02) obj;
                } else {
                    t02Var = new t02(this.mSwanApiContext);
                    this.mApis.put("1751900130", t02Var);
                }
                Pair<Boolean, l12> a = n12.a(t02Var, "swanAPI/logToFile");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = t02Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String preloadPackage(String str) {
                sc3 sc3Var;
                Object obj = this.mApis.get("1748196865");
                if (obj != null && (obj instanceof sc3)) {
                    sc3Var = (sc3) obj;
                } else {
                    sc3Var = new sc3(this.mSwanApiContext);
                    this.mApis.put("1748196865", sc3Var);
                }
                Pair<Boolean, l12> a = n12.a(sc3Var, "swanAPI/preloadPackage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = sc3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String previewImage(String str) {
                u02 u02Var;
                Object obj = this.mApis.get("589529211");
                if (obj != null && (obj instanceof u02)) {
                    u02Var = (u02) obj;
                } else {
                    u02Var = new u02(this.mSwanApiContext);
                    this.mApis.put("589529211", u02Var);
                }
                Pair<Boolean, l12> a = n12.a(u02Var, "swanAPI/previewImage");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = u02Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                x02 x02Var;
                Object obj = this.mApis.get("-577481801");
                if (obj != null && (obj instanceof x02)) {
                    x02Var = (x02) obj;
                } else {
                    x02Var = new x02(this.mSwanApiContext);
                    this.mApis.put("-577481801", x02Var);
                }
                Pair<Boolean, l12> a = n12.a(x02Var, "swanAPI/ubcFlowJar");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 I = x02Var.I(str);
                if (I == null) {
                    return "";
                }
                return I.a();
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getCommonSysInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 E = v02Var.E();
                if (E == null) {
                    return "";
                }
                return E.a();
            }

            @JavascriptInterface
            public String getSystemInfo() {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getSystemInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = v02Var.H();
                if (H == null) {
                    return "";
                }
                return H.a();
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                v02 v02Var;
                Object obj = this.mApis.get("-1011537871");
                if (obj != null && (obj instanceof v02)) {
                    v02Var = (v02) obj;
                } else {
                    v02Var = new v02(this.mSwanApiContext);
                    this.mApis.put("-1011537871", v02Var);
                }
                Pair<Boolean, l12> a = n12.a(v02Var, "swanAPI/getSystemInfoSync");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 J = v02Var.J();
                if (J == null) {
                    return "";
                }
                return J.a();
            }
        });
        hashMap.put("_naWifi", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String connectWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/connectWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 A = ck3Var.A(str);
                if (A == null) {
                    return "";
                }
                return A.a();
            }

            @JavascriptInterface
            public String getConnectedWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/getConnectedWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 B = ck3Var.B(str);
                if (B == null) {
                    return "";
                }
                return B.a();
            }

            @JavascriptInterface
            public String getWifiList(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/getWifiList");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 C = ck3Var.C(str);
                if (C == null) {
                    return "";
                }
                return C.a();
            }

            @JavascriptInterface
            public String startWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/startWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = ck3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String stopWifi(String str) {
                ck3 ck3Var;
                Object obj = this.mApis.get("1879401452");
                if (obj != null && (obj instanceof ck3)) {
                    ck3Var = (ck3) obj;
                } else {
                    ck3Var = new ck3(this.mSwanApiContext);
                    this.mApis.put("1879401452", ck3Var);
                }
                Pair<Boolean, l12> a = n12.a(ck3Var, "swanAPI/stopWifi");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 H = ck3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
