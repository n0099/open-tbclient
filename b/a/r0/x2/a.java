package b.a.r0.x2;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WebView f27085a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f27086b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.l3.n0.a f27087c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f27088d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f27089e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f27090f;

    /* renamed from: g  reason: collision with root package name */
    public String f27091g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f27092h;

    /* renamed from: b.a.r0.x2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1333a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1333a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27093a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            String str2;
            boolean z;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof QuickWebViewHttpResMsg)) {
                QuickWebViewHttpResMsg quickWebViewHttpResMsg = (QuickWebViewHttpResMsg) httpResponsedMessage;
                int i2 = 0;
                String str5 = null;
                if (quickWebViewHttpResMsg.getOrginalMessage() instanceof QuickWebViewHttpReqMsg) {
                    QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = (QuickWebViewHttpReqMsg) quickWebViewHttpResMsg.getOrginalMessage();
                    z = quickWebViewHttpReqMsg.isFromRequestByNative;
                    if (StringUtils.isNull(quickWebViewHttpReqMsg.url)) {
                        str = "";
                        str2 = null;
                    } else {
                        String str6 = quickWebViewHttpReqMsg.url;
                        long j = quickWebViewHttpReqMsg.begin;
                        str = quickWebViewHttpReqMsg.module;
                        String str7 = quickWebViewHttpReqMsg.jsCallbackMethod;
                        if (TextUtils.isEmpty(str7) && !z) {
                            str7 = (String) this.f27093a.f27089e.remove(str6);
                            i2 = 1;
                        }
                        this.f27093a.f27088d.remove(str6);
                        str5 = str7;
                        str2 = str6;
                    }
                } else {
                    str = "";
                    str2 = null;
                    z = false;
                }
                if (quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                    str4 = quickWebViewHttpResMsg.getResult();
                    str3 = BasicPushStatus.SUCCESS_CODE;
                } else {
                    str3 = quickWebViewHttpResMsg.getError() + "";
                    str4 = "\"\"";
                }
                String s = b.q().s(str);
                if (s == null) {
                    s = "0.0.0.0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(StringUtil.ARRAY_START);
                sb.append("\"status\":");
                sb.append("\"");
                sb.append(str3);
                sb.append("\"");
                sb.append(",");
                sb.append("\"data\":");
                sb.append(str4);
                sb.append(",");
                sb.append("\"cache_version\":");
                sb.append("\"");
                sb.append(s);
                sb.append("\"");
                sb.append(",");
                sb.append("\"cache\":");
                sb.append("\"");
                sb.append(i2);
                sb.append("\"");
                sb.append("}");
                if (z) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("result", sb.toString());
                    linkedHashMap.put("NotificationKey", str2);
                    this.f27093a.f27087c.h(this.f27093a.f27085a, "RequestByNativeToH5", linkedHashMap);
                } else if (StringUtils.isNull(str5)) {
                    this.f27093a.f27090f.put(str2, sb.toString());
                } else {
                    this.f27093a.k(str5, sb.toString());
                }
            }
        }
    }

    public a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27088d = new HashSet<>();
        this.f27089e = new HashMap<>();
        this.f27090f = new HashMap<>();
        this.f27092h = new C1333a(this, CmdConfigHttp.CMD_WEB_HTTP_PROXY);
        this.f27085a = webView;
        this.f27091g = webView.getSettings().getUserAgentString();
        BdUniqueId gen = BdUniqueId.gen();
        this.f27086b = gen;
        this.f27092h.setTag(gen);
        this.f27092h.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f27092h);
    }

    public final void g(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, quickWebViewBridgeData, str, z) == null) || quickWebViewBridgeData == null || StringUtils.isNull(quickWebViewBridgeData.url) || StringUtils.isNull(quickWebViewBridgeData.type)) {
            return;
        }
        String remove = this.f27090f.remove(quickWebViewBridgeData.url);
        if (!StringUtils.isNull(remove) && str != null) {
            k(str, remove);
        } else if (!StringUtils.isNull(remove) && z) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", remove);
            linkedHashMap.put("NotificationKey", quickWebViewBridgeData.url);
            this.f27087c.h(this.f27085a, "RequestByNativeToH5", linkedHashMap);
        } else if (this.f27088d.contains(quickWebViewBridgeData.url) && !z) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f27089e.put(quickWebViewBridgeData.url, str);
        } else {
            QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
            quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
            quickWebViewHttpReqMsg.module = quickWebViewBridgeData.module;
            quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
            quickWebViewHttpReqMsg.jsCallbackMethod = str;
            quickWebViewHttpReqMsg.setTag(this.f27086b);
            quickWebViewHttpReqMsg.isFromRequestByNative = z;
            CookieSyncManager.createInstance(this.f27085a.getContext());
            String cookie = CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME);
            if (!TextUtils.isEmpty(cookie)) {
                HashMap<String, String> headers = quickWebViewHttpReqMsg.getHeaders();
                if (headers != null) {
                    String str2 = headers.get("Cookie");
                    if (!TextUtils.isEmpty(str2)) {
                        cookie = str2.endsWith(";") ? str2 + cookie : str2 + ";" + cookie;
                    }
                    quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                } else {
                    quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                }
            }
            quickWebViewHttpReqMsg.setUserAgent(this.f27091g);
            quickWebViewHttpReqMsg.addCookie("cache_version", b.q().s(quickWebViewBridgeData.module));
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_WEB_HTTP_PROXY, quickWebViewBridgeData.url);
            tbHttpMessageTask.setResponsedClass(QuickWebViewHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setPriority(4);
            if (quickWebViewBridgeData.type.toLowerCase().equals("post")) {
                Map<String, String> map = quickWebViewBridgeData.data;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : quickWebViewBridgeData.data.entrySet()) {
                        quickWebViewHttpReqMsg.addParam(entry.getKey(), entry.getValue());
                    }
                }
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            } else {
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            }
            MessageManager.getInstance().sendMessage(quickWebViewHttpReqMsg, tbHttpMessageTask);
            this.f27088d.add(quickWebViewBridgeData.url);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f27086b);
            MessageManager.getInstance().removeMessage(this.f27086b);
            this.f27088d.clear();
            this.f27088d = null;
            this.f27089e.clear();
            this.f27089e = null;
            this.f27090f.clear();
            this.f27090f = null;
        }
    }

    public void i(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, quickWebViewBridgeData, str) == null) {
            g(quickWebViewBridgeData, str, false);
        }
    }

    public void j(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, quickWebViewBridgeData, str, z) == null) {
            g(quickWebViewBridgeData, str, z);
        }
    }

    public final void k(String str, String str2) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || (webView = this.f27085a) == null) {
            return;
        }
        webView.loadUrl("javascript:window." + str + "('" + str2 + "')");
    }

    public void l(b.a.r0.l3.n0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f27087c = aVar;
        }
    }
}
