package c.a.r0.w2;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WebView f28128a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f28129b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.j3.m0.a f28130c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f28131d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f28132e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f28133f;

    /* renamed from: g  reason: collision with root package name */
    public String f28134g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f28135h;

    /* renamed from: c.a.r0.w2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1326a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28136a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1326a(a aVar, int i2) {
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
            this.f28136a = aVar;
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
                        long j2 = quickWebViewHttpReqMsg.begin;
                        str = quickWebViewHttpReqMsg.module;
                        String str7 = quickWebViewHttpReqMsg.jsCallbackMethod;
                        if (TextUtils.isEmpty(str7)) {
                            str7 = (String) this.f28136a.f28132e.remove(str6);
                            i2 = 1;
                        }
                        this.f28136a.f28131d.remove(str6);
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
                    str3 = "200";
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
                    linkedHashMap.put("result", sb.toString().replace("\\\"", "\""));
                    linkedHashMap.put("NotificationKey", str2);
                    this.f28136a.f28130c.h(this.f28136a.f28128a, "RequestByNativeToH5", linkedHashMap);
                } else if (StringUtils.isNull(str5)) {
                    this.f28136a.f28133f.put(str2, sb.toString());
                } else {
                    this.f28136a.k(str5, sb.toString());
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
        this.f28131d = new HashSet<>();
        this.f28132e = new HashMap<>();
        this.f28133f = new HashMap<>();
        this.f28135h = new C1326a(this, CmdConfigHttp.CMD_WEB_HTTP_PROXY);
        this.f28128a = webView;
        this.f28134g = webView.getSettings().getUserAgentString();
        BdUniqueId gen = BdUniqueId.gen();
        this.f28129b = gen;
        this.f28135h.setTag(gen);
        this.f28135h.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f28135h);
    }

    public final void g(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, quickWebViewBridgeData, str, z) == null) || quickWebViewBridgeData == null || StringUtils.isNull(quickWebViewBridgeData.url) || StringUtils.isNull(quickWebViewBridgeData.type)) {
            return;
        }
        String remove = this.f28133f.remove(quickWebViewBridgeData.url);
        if (!StringUtils.isNull(remove) && str != null) {
            k(str, remove);
        } else if (!StringUtils.isNull(remove) && z) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", remove.replace("\\\"", "\""));
            linkedHashMap.put("NotificationKey", quickWebViewBridgeData.url);
            this.f28130c.h(this.f28128a, "RequestByNativeToH5", linkedHashMap);
        } else if (this.f28131d.contains(quickWebViewBridgeData.url) && !z) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f28132e.put(quickWebViewBridgeData.url, str);
        } else {
            QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
            quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
            quickWebViewHttpReqMsg.module = quickWebViewBridgeData.module;
            quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
            quickWebViewHttpReqMsg.jsCallbackMethod = str;
            quickWebViewHttpReqMsg.setTag(this.f28129b);
            quickWebViewHttpReqMsg.isFromRequestByNative = z;
            CookieSyncManager.createInstance(this.f28128a.getContext());
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
            quickWebViewHttpReqMsg.setUserAgent(this.f28134g);
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
            this.f28131d.add(quickWebViewBridgeData.url);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f28129b);
            MessageManager.getInstance().removeMessage(this.f28129b);
            this.f28131d.clear();
            this.f28131d = null;
            this.f28132e.clear();
            this.f28132e = null;
            this.f28133f.clear();
            this.f28133f = null;
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
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || (webView = this.f28128a) == null) {
            return;
        }
        webView.loadUrl("javascript:window." + str + "('" + str2 + "')");
    }

    public void l(c.a.r0.j3.m0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f28130c = aVar;
        }
    }
}
