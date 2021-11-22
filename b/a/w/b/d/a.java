package b.a.w.b.d;

import android.content.Context;
import android.text.TextUtils;
import b.a.w.b.d.c.c;
import b.a.w.b.d.c.g;
import b.a.w.c.a.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f30056a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f30057b;

    /* renamed from: c  reason: collision with root package name */
    public String f30058c;

    /* renamed from: d  reason: collision with root package name */
    public b f30059d;

    /* renamed from: e  reason: collision with root package name */
    public Context f30060e;

    /* renamed from: b.a.w.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1451a implements b.a.w.e.d.a<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f30061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f30062b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f30063c;

        public C1451a(a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30063c = aVar;
            this.f30061a = str;
            this.f30062b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't wrap try/catch for region: R(13:3|(2:5|(1:45)(1:8))(1:46)|9|(1:11)(1:44)|12|(3:14|(9:38|39|40|18|(2:(1:36)(1:27)|28)(1:37)|29|30|31|32)|16)(1:43)|17|18|(0)(0)|29|30|31|32) */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
        @Override // b.a.w.e.d.a
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(NetResponse netResponse, c cVar, Map<String, String> map, List<String> list) {
            String str;
            String str2;
            int i2;
            String str3;
            String str4;
            String str5;
            String str6;
            long j;
            String str7;
            g gVar;
            List<LiveTabEntity> list2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse, cVar, map, list) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                String str8 = "";
                if (netResponse == null) {
                    String string = this.f30063c.f30060e.getResources().getString(e.live_feed_net_error);
                    this.f30063c.f30059d.b(-100, string, map);
                    str = "";
                    str2 = string;
                    i2 = -100;
                } else if (!netResponse.isSuccessful() || cVar == null) {
                    this.f30063c.f30059d.b(netResponse.responseCode, netResponse.exception, map);
                    int i3 = netResponse.responseCode;
                    str2 = netResponse.exception;
                    str = "";
                    i2 = i3;
                } else {
                    this.f30063c.f30059d.a(cVar, map);
                    b.a.w.b.f.b.a(list);
                    i2 = cVar.f30068a;
                    str2 = cVar.f30069b;
                    str = cVar.f30070c;
                }
                String str9 = this.f30063c.f30057b ? "chenjinshi" : "zhibopindao";
                if (map != null) {
                    String str10 = map.get("tab");
                    String str11 = map.get("subtab");
                    str4 = map.get("resource");
                    String str12 = map.get("session_id");
                    if (map.containsKey(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY)) {
                        try {
                            j = currentTimeMillis - Long.parseLong(map.get(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY));
                            str3 = str10;
                            str5 = str11;
                            str6 = str12;
                        } catch (NumberFormatException unused) {
                        }
                        if (str4.contains("tab")) {
                            str7 = "";
                        } else {
                            str7 = (cVar == null || (gVar = cVar.f30074g) == null || (list2 = gVar.f30092c) == null || list2.isEmpty()) ? "1" : "0";
                        }
                        str8 = URLEncoder.encode(str4, "UTF-8");
                        b.a.w.b.c.a.q(this.f30063c.f30060e, this.f30063c.f30056a, str9, j, i2, str2, str, str8, str3, str5, str6, str7);
                    }
                    str3 = str10;
                    str5 = str11;
                    str6 = str12;
                } else {
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                    str6 = str5;
                }
                j = 0;
                if (str4.contains("tab")) {
                }
                str8 = URLEncoder.encode(str4, "UTF-8");
                b.a.w.b.c.a.q(this.f30063c.f30060e, this.f30063c.f30056a, str9, j, i2, str2, str, str8, str3, str5, str6, str7);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.w.e.d.a
        /* renamed from: c */
        public c onParseResponseInBackground(NetResponse netResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
                c cVar = new c();
                if (netResponse != null && !TextUtils.isEmpty(netResponse.decodedResponseStr)) {
                    try {
                        cVar.c(new JSONObject(netResponse.decodedResponseStr), this.f30061a, this.f30062b);
                    } catch (JSONException e2) {
                        LiveFeedPageSdk.l(e2.getMessage());
                        if (TextUtils.equals("banner,tab,feed,follow,config", this.f30061a)) {
                            cVar.a("banner,tab,feed,follow,config", -101, e2.getMessage());
                        }
                    }
                }
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(c cVar, Map<String, String> map);

        void b(int i2, String str, Map<String, String> map);
    }

    public a(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30060e = context;
        this.f30056a = str;
        this.f30057b = z;
        this.f30058c = z ? "immer" : "tab";
    }

    public final void e(String str, String str2, int i2, String str3, String str4, String str5, int i3, String str6, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, str5, Integer.valueOf(i3), str6, list}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("resource", str);
            hashMap.put("scene", this.f30058c);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("session_id", str2);
            hashMap.put("refresh_type", String.valueOf(i2));
            hashMap.put("tab", str3);
            hashMap.put("channel_id", str4);
            hashMap.put("subtab", str5);
            hashMap.put("upload_ids", str6);
            hashMap.put("refresh_index", String.valueOf(i3));
            hashMap.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, System.currentTimeMillis() + "");
            b.a.w.e.d.b.d("https://tiebac.baidu.com/livefeed/feed", hashMap, new C1451a(this, str, i2), 0, 0, null, list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e("follow", "", 0, "", "", "", 1, "", null);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e("banner,tab,feed,follow,config", "", 0, "", "", "", 1, b.a.w.b.f.b.b(), b.a.w.b.f.b.f30117b);
        }
    }

    public void h(String str, String str2, int i2, String str3, String str4, String str5, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, str5, Integer.valueOf(i3)}) == null) {
            e(str, str2, i2, str3, str4, str5, i3, b.a.w.b.f.b.b(), b.a.w.b.f.b.f30117b);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f30059d = bVar;
        }
    }
}
