package com.baidu.tbadk.browser;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.util.Base64Encoder;
import d.a.c.e.p.j;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.j0.z0.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@d.a.e.a.a
/* loaded from: classes3.dex */
public class SearchJsBridge implements d.a.k0.d3.l0.b {
    public static final String BAIDUID = "baiduid";
    public static final String CLIENT_VERSION = "_client_version";
    public static final String COOKIE_CFROM = "cfrom";
    public static final String COOKIE_FROM = "from";
    public static final String COOKIE_IMEI = "imei";
    public static final String COOKIE_MERCATOR_CITY = "mercator_city";
    public static final String COOKIE_MERCATOR_LAT = "mercator_lat";
    public static final String COOKIE_MERCATOR_LON = "mercator_lon";
    public static final String COOKIE_MERCATOR_RADIUS = "mercator_radius";
    public static final String COOKIE_MERCATOR_TIME = "mercator_time";
    public static final String COOKIE_MOD = "mod";
    public static final String COOKIE_NET_TYPE = "net_type";
    public static final String COOKIE_OS_TYPE = "os_type";
    public static final String COOKIE_OV = "ov";
    public static final String CUID = "CUID";
    public static final String CUID_GALAXY2 = "cuid_galaxy2";
    public static final String GET_SEARCH_AD_COOKIE = "getSearchAdCookie";
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String METHOD_DELETE_ALL_SEARCH_HISTORY = "deleteAllSearchHistory";
    public static final String METHOD_DELETE_SEARCH_HISTORY = "deleteSearchHistory";
    public static final String METHOD_GET_SEARCH_HISTORY = "getSearchHistory";
    public static final String METHOD_OPEN_SEACH_PAGE = "openSearchPage";
    public static final String METHOD_SET_SEARCH_HISTORY = "setSearchHistory";
    public static final String SHOUBAI_CUID = "shoubai_cuid";
    public static final String SUCCESS_CODE = "1";
    public List<String> mHistoryDatas;

    /* loaded from: classes3.dex */
    public class a extends f0<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f12024a;

        public a(SearchJsBridge searchJsBridge, String str) {
            this.f12024a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public String doInBackground() {
            d.a.k0.d3.n0.a.h(this.f12024a);
            return this.f12024a;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements n<String> {
        public b(SearchJsBridge searchJsBridge) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921557, str));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends f0 {
        public c(SearchJsBridge searchJsBridge) {
        }

        @Override // d.a.j0.z0.f0
        public Object doInBackground() {
            d.a.k0.d3.n0.a.b();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements n {
        public d() {
        }

        @Override // d.a.j0.z0.n
        public void onReturnDataInUI(Object obj) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921558));
            if (SearchJsBridge.this.mHistoryDatas != null) {
                SearchJsBridge.this.mHistoryDatas.clear();
            }
        }
    }

    public SearchJsBridge() {
        this.mHistoryDatas = new ArrayList();
    }

    private void addCookie(JSONObject jSONObject, String str, String str2) throws JSONException {
        jSONObject.put(str, str2);
    }

    private String initCookies() {
        JSONObject jSONObject = new JSONObject();
        try {
            MercatorModel.MercatorData e2 = MercatorModel.d().e();
            if (e2 != null) {
                addCookie(jSONObject, COOKIE_MERCATOR_LAT, e2.t());
                addCookie(jSONObject, COOKIE_MERCATOR_LON, e2.u());
                addCookie(jSONObject, COOKIE_MERCATOR_CITY, String.valueOf(e2.s()));
                addCookie(jSONObject, COOKIE_MERCATOR_RADIUS, e2.v());
                addCookie(jSONObject, COOKIE_MERCATOR_TIME, String.valueOf(e2.w()));
            }
            addCookie(jSONObject, COOKIE_MOD, Build.MODEL);
            addCookie(jSONObject, COOKIE_OV, Build.VERSION.RELEASE);
            addCookie(jSONObject, COOKIE_OS_TYPE, String.valueOf(2));
            addCookie(jSONObject, "net_type", String.valueOf(j.I()));
            addCookie(jSONObject, "imei", TbadkCoreApplication.getInst().getImei());
            addCookie(jSONObject, "from", TbConfig.getFrom());
            addCookie(jSONObject, "cfrom", TbConfig.getCurrentFrom());
            addCookie(jSONObject, "_client_version", TbConfig.getVersion());
            addCookie(jSONObject, CUID, TbadkCoreApplication.getInst().getCuid());
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            addCookie(jSONObject, "shoubai_cuid", cuidGalaxy2);
            addCookie(jSONObject, "cuid_galaxy2", cuidGalaxy2);
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                addCookie(jSONObject, "baiduid", new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())));
            }
        } catch (JSONException e3) {
            BdLog.e(e3);
        }
        return jSONObject.toString();
    }

    @Override // d.a.k0.d3.l0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if (METHOD_GET_SEARCH_HISTORY.equals(str2)) {
                jsPromptResult.confirm(getSearchHistoryJson().a());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921556, Boolean.TRUE));
                return true;
            } else if (METHOD_DELETE_SEARCH_HISTORY.equals(str2)) {
                try {
                    jsPromptResult.confirm(deleteSearchHistory(new JSONObject(str3).optString("query")).a());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return true;
            } else if (METHOD_DELETE_ALL_SEARCH_HISTORY.equals(str2)) {
                jsPromptResult.confirm(deleteAllSearchHistory().a());
                return true;
            } else if (METHOD_OPEN_SEACH_PAGE.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(openSearchPage(jSONObject.optString("query"), jSONObject.optInt("sub_type")).a());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                return true;
            } else if (GET_SEARCH_AD_COOKIE.equals(str2)) {
                jsPromptResult.confirm(getSearchAdCookie().a());
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public d.a.k0.d3.l0.d.c deleteAllSearchHistory() {
        d.a.k0.d3.l0.d.c cVar = new d.a.k0.d3.l0.d.c();
        h0.b(new c(this), new d());
        return cVar;
    }

    public d.a.k0.d3.l0.d.c deleteSearchHistory(String str) {
        d.a.k0.d3.l0.d.c cVar = new d.a.k0.d3.l0.d.c();
        h0.b(new a(this, str), new b(this));
        return cVar;
    }

    public d.a.k0.d3.l0.d.c getSearchAdCookie() {
        d.a.k0.d3.l0.d.c cVar = new d.a.k0.d3.l0.d.c();
        cVar.l(initCookies());
        return cVar;
    }

    public d.a.k0.d3.l0.d.c getSearchHistoryJson() {
        d.a.k0.d3.l0.d.c cVar = new d.a.k0.d3.l0.d.c();
        int count = ListUtils.getCount(this.mHistoryDatas);
        if (count == 0) {
            cVar.l("");
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < count; i2++) {
            jSONArray.put(this.mHistoryDatas.get(i2));
        }
        cVar.l(jSONArray.toString());
        return cVar;
    }

    public d.a.k0.d3.l0.d.c openSearchPage(String str, int i2) {
        d.a.k0.d3.l0.d.c cVar = new d.a.k0.d3.l0.d.c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("query", str);
            jSONObject.put("subType", i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921559, jSONObject.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return cVar;
    }

    public void setHistoryDatas(List<String> list) {
        this.mHistoryDatas = list;
    }

    public SearchJsBridge(List<String> list) {
        this.mHistoryDatas = new ArrayList();
        this.mHistoryDatas = list;
    }
}
