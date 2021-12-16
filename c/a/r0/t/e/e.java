package c.a.r0.t.e;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.t.c.e0;
import c.a.r0.t.c.g0;
import c.a.r0.t.c.h;
import c.a.r0.t.c.i;
import c.a.r0.t.c.j;
import c.a.r0.t.c.n0;
import c.a.r0.t.c.p0;
import c.a.r0.t.c.r0;
import c.a.r0.t.c.t;
import c.a.r0.t.c.u;
import c.a.r0.t.c.v;
import c.a.r0.t.c.y;
import c.a.r0.t.c.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z A;
    public h B;
    public y C;
    public VersionData a;

    /* renamed from: b  reason: collision with root package name */
    public t f13836b;

    /* renamed from: c  reason: collision with root package name */
    public u f13837c;

    /* renamed from: d  reason: collision with root package name */
    public String f13838d;

    /* renamed from: e  reason: collision with root package name */
    public CombineDownload f13839e;

    /* renamed from: f  reason: collision with root package name */
    public e0 f13840f;

    /* renamed from: g  reason: collision with root package name */
    public r0 f13841g;

    /* renamed from: h  reason: collision with root package name */
    public i f13842h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.t.c.d f13843i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.t.c.f f13844j;

    /* renamed from: k  reason: collision with root package name */
    public final c.a.r0.t.c.c f13845k;
    public g0 l;
    public int m;
    public int n;
    public int o;
    public int p;
    public v q;
    public c.a.r0.t.c.a r;
    public ABTestExtraData s;
    public JSONArray t;
    public JSONArray u;
    public JSONArray v;
    public JSONObject w;
    public YYLiveConfig x;
    public c.a.s0.p4.a y;
    public NewGodData z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.i0.e.c.d().g();
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.a = new VersionData();
        this.f13836b = new t();
        this.f13837c = new u();
        this.f13839e = new CombineDownload();
        this.f13840f = new e0();
        this.f13841g = new r0();
        this.q = new v();
        this.f13842h = new i();
        this.f13843i = new c.a.r0.t.c.d();
        this.f13845k = new c.a.r0.t.c.c();
        this.r = new c.a.r0.t.c.a();
        this.l = new g0();
        this.s = new ABTestExtraData();
        this.z = new NewGodData();
        this.A = new z();
        this.f13844j = new c.a.r0.t.c.f();
        this.B = new h();
        this.C = new y();
    }

    public void A(JSONObject jSONObject) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            TbSingleton.getInstance().setVoiceRoomConfig(p0.b(jSONObject));
            this.A.a(x(jSONObject, "index_tab_info"));
            this.a.parserJson(jSONObject.optJSONObject("version"));
            this.f13836b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            c.a.d.f.n.g.g(jSONObject.optString("client_ip", null));
            this.f13837c.f(jSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME));
            this.f13841g.h0(jSONObject.optJSONObject("wl_config"));
            jSONObject.optJSONObject("channel_icon_config");
            this.f13844j.c(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.f13844j);
            String optString = jSONObject.optString("new_god_data", "");
            if (!StringUtils.isNull(optString)) {
                this.z.parserJson(optString);
            }
            this.q.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.q);
            this.f13838d = jSONObject.optString("config_version");
            this.n = jSONObject.optInt("is_uninterest");
            this.o = jSONObject.optInt("first_time_motivate");
            this.p = jSONObject.optInt("needNewUserLead");
            this.f13839e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f13840f.a(jSONObject.optJSONObject("mainbar"));
            jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
            this.m = jSONObject.optInt("faceshop_version");
            if (this.m > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                TbadkCoreApplication.getInst().setTempFaceShopVersion(this.m);
                TbadkCoreApplication.getInst().setFaceShopNew(true);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
            if (optJSONObject != null) {
                TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
            }
            new c().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            j.c(jSONObject.optJSONArray("scheme_whitelist"));
            UrlSchemaJumpHelper.setBlackList(x(jSONObject, UrlSchemaJumpHelper.KEY_APP_JUMP_BLACK_LIST));
            this.f13842h.a(jSONObject.optJSONObject("app_entrance"));
            this.f13843i.j(jSONObject.optJSONObject("ad_adsense"));
            g.d(jSONObject.optJSONObject("video_report_config"));
            this.f13845k.b(jSONObject.optJSONObject("activity_switch"));
            this.r.b(y(jSONObject, "abtest_config"));
            this.s.parseJson(y(jSONObject, "new_abtest_entra"));
            this.t = x(jSONObject, "new_abtest_config");
            this.u = x(jSONObject, "ubs_abtest_config");
            x(jSONObject, "outside_callback_icon");
            this.v = jSONObject.optJSONArray("windowStrategyList");
            this.w = y(jSONObject, "bear_sdk_config");
            if (y(jSONObject, "advertisement_config") != null) {
                this.B.d(y(jSONObject, "advertisement_config"));
            }
            YYLiveConfig yYLiveConfig = new YYLiveConfig();
            this.x = yYLiveConfig;
            yYLiveConfig.parseJson(y(jSONObject, "yy_live_config"));
            c.a.s0.p4.a aVar = new c.a.s0.p4.a();
            this.y = aVar;
            aVar.c(x(jSONObject, "yy_live_tab"));
            c.a.r0.s.p.a.b().f(this.v);
            this.l.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            c.a.r0.s.g0.b.j().t("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray x = x(jSONObject, "offpack");
            if (x != null && x.length() > 0 && (jSONObject2 = x.getJSONObject(0)) != null) {
                c.a.s0.h3.d.b bVar = new c.a.s0.h3.d.b();
                bVar.e(jSONObject2.optString("mod_name"));
                bVar.f(jSONObject2.optInt("upload_offline_web_cache") == 1);
                bVar.d(jSONObject2.optInt("clear_offline_web_cache") == 1);
                if (!TextUtils.isEmpty(bVar.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(bVar);
                }
            }
            String optString2 = jSONObject.optString("proxy_ip");
            String optString3 = jSONObject.optString("proxy_port");
            TbadkCoreApplication.getInst().setProxyIp(optString2);
            TbadkCoreApplication.getInst().setProxyPort(optString3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_priority", jSONObject.optString("ad_sdk_priority", null));
            jSONObject3.put("ad_origin_config_switch", jSONObject.optString("ad_origin_config_switch", null));
            jSONObject3.put("bear_sid_type", jSONObject.optString("bear_sid_type", null));
            MessageManager.getInstance().runTask(2016552, null, jSONObject3);
            TbSingleton.getInstance().setSyncYYSwitch(jSONObject.optInt("is_yy_user", 1) == 1);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(LowFlowsActivityConfig.LF_USER_INFO);
            if (optJSONObject2 != null) {
                String optString4 = optJSONObject2.optString(LowFlowsActivityConfig.LF_USER);
                TbSingleton.getInstance().setLFUser(optString4);
                if (!StringUtils.isNull(optString4) && "2".equals(optString4)) {
                    TbSingleton.getInstance().setLFUserTaskId(optJSONObject2.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                    TbSingleton.getInstance().setBannerText(optJSONObject2.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
                }
            }
            this.C.e(jSONObject.optJSONObject("homepage_interest_config"));
            TbSingleton.getInstance().setHomepageInterestConfig(this.C);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject3 != null) {
                c.a.r0.i0.e.c.d().h(optJSONObject3);
                c.a.d.f.m.e.a().post(new a(this));
            }
            c.a.r0.s.g0.b.j().v("key_work_video_guide_pop", jSONObject.optInt("videoup_guide_pop", -1));
            TbSingleton.getInstance().setVideoEventsConfig(n0.e(jSONObject));
            c.a.r0.s.g0.b.j().x("key_sync_extra_field", jSONObject.optString("extra"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public c.a.r0.t.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (c.a.r0.t.c.a) invokeV.objValue;
    }

    public ABTestExtraData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (ABTestExtraData) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (JSONArray) invokeV.objValue;
    }

    public c.a.r0.t.c.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13845k : (c.a.r0.t.c.c) invokeV.objValue;
    }

    public c.a.r0.t.c.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13843i : (c.a.r0.t.c.d) invokeV.objValue;
    }

    public c.a.r0.t.c.f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13844j : (c.a.r0.t.c.f) invokeV.objValue;
    }

    public h g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.B : (h) invokeV.objValue;
    }

    public i h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13842h : (i) invokeV.objValue;
    }

    public t i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13836b : (t) invokeV.objValue;
    }

    public CombineDownload j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13839e : (CombineDownload) invokeV.objValue;
    }

    public u k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f13837c : (u) invokeV.objValue;
    }

    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.w : (JSONObject) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o == 1 : invokeV.booleanValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.p : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n : invokeV.intValue;
    }

    public NewGodData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.z : (NewGodData) invokeV.objValue;
    }

    public g0 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : (g0) invokeV.objValue;
    }

    public JSONArray r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.u : (JSONArray) invokeV.objValue;
    }

    public VersionData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a : (VersionData) invokeV.objValue;
    }

    public r0 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f13841g : (r0) invokeV.objValue;
    }

    public YYLiveConfig u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.x : (YYLiveConfig) invokeV.objValue;
    }

    public c.a.s0.p4.a v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.y : (c.a.s0.p4.a) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f13838d : (String) invokeV.objValue;
    }

    public final JSONArray x(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public final JSONObject y(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            try {
                A(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
