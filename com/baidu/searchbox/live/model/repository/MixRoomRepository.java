package com.baidu.searchbox.live.model.repository;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.data.constant.MixUrlConfigKt;
import com.baidu.searchbox.live.data.constant.MixYaLogConstants;
import com.baidu.searchbox.live.data.req.RoomEnterParams;
import com.baidu.searchbox.live.data.req.RoomExitParams;
import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.interfaces.data.UserAccount;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.net.NetStatData;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.searchbox.live.model.net.MixNetCallback;
import com.baidu.searchbox.live.model.requester.MixRequesterKt;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.MixResultStatData;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.service.MixYaLogService;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListExtKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\t\u0018\u0000B\u0007¢\u0006\u0004\b1\u00102J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010!R%\u0010(\u001a\n #*\u0004\u0018\u00010\"0\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R?\u0010.\u001a$\u0012\u0004\u0012\u00020\u0011\u0012\u001a\u0012\u0018\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003\u0018\u00010*0)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;", "Lcom/baidu/searchbox/live/data/req/RoomEnterParams;", "enterParams", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", WebChromeClient.KEY_ARG_CALLBACK, "", "fetchRoomEnter", "(Lcom/baidu/searchbox/live/data/req/RoomEnterParams;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "Lcom/baidu/searchbox/live/data/req/RoomExitParams;", "exitParams", "", "fetchRoomExit", "(Lcom/baidu/searchbox/live/data/req/RoomExitParams;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "params", "", "", "genRoomEnterReqParams", "(Lcom/baidu/searchbox/live/data/req/RoomEnterParams;)Ljava/util/Map;", "Lcom/baidu/searchbox/live/interfaces/data/UserAccount;", "getAccount", "()Lcom/baidu/searchbox/live/interfaces/data/UserAccount;", "isLogin", "()Z", "Lorg/json/JSONObject;", "extra", "putAudioExtraAppId", "(Lorg/json/JSONObject;)V", "roomId", "removeEnterIdCallbacks", "(Ljava/lang/String;)V", "addAudioExtraParams", "(Lcom/baidu/searchbox/live/data/req/RoomEnterParams;Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "accountService$delegate", "Lkotlin/Lazy;", "getAccountService", "()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "accountService", "", "", "enterIdCallbacks$delegate", "getEnterIdCallbacks", "()Ljava/util/Map;", "enterIdCallbacks", "prefetchEnterSwitch", "Z", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixRoomRepository {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy accountService$delegate;
    public final Lazy enterIdCallbacks$delegate;
    public final boolean prefetchEnterSwitch;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1942679472, "Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1942679472, "Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixRoomRepository.class), "accountService", "getAccountService()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixRoomRepository.class), "enterIdCallbacks", "getEnterIdCallbacks()Ljava/util/Map;"))};
    }

    private final AccountManagerService getAccountService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Lazy lazy = this.accountService$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (AccountManagerService) lazy.getValue();
        }
        return (AccountManagerService) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, List<OnMixDataLoaded<MixResult<LiveRoomEnterRespData>>>> getEnterIdCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Lazy lazy = this.enterIdCallbacks$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (Map) lazy.getValue();
        }
        return (Map) invokeV.objValue;
    }

    public MixRoomRepository() {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
        boolean z2 = false;
        if (abConfigService != null) {
            z = abConfigService.getSwitch(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, false);
        } else {
            z = false;
        }
        if (z) {
            PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
            if (pluginMgrService != null) {
                i = pluginMgrService.getPluginVersionCode("com.baidu.searchbox.livenps");
            } else {
                i = 0;
            }
            if (i >= 604000000) {
                z2 = true;
            }
        }
        this.prefetchEnterSwitch = z2;
        this.accountService$delegate = LazyKt__LazyJVMKt.lazy(MixRoomRepository$accountService$2.INSTANCE);
        this.enterIdCallbacks$delegate = LazyKt__LazyJVMKt.lazy(MixRoomRepository$enterIdCallbacks$2.INSTANCE);
    }

    private final void putAudioExtraAppId(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, jSONObject) == null) && jSONObject != null) {
            jSONObject.put("connector_app_id", MixConstants.Companion.getAudioConnectorAppId());
        }
    }

    public final void removeEnterIdCallbacks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str == null) {
                getEnterIdCallbacks().clear();
            } else {
                getEnterIdCallbacks().remove(str);
            }
        }
    }

    private final void addAudioExtraParams(RoomEnterParams roomEnterParams, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, roomEnterParams, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("room_id", str);
                if (isLogin()) {
                    UserAccount account = getAccount();
                    String str3 = null;
                    if (account != null) {
                        str2 = account.getNickName();
                    } else {
                        str2 = null;
                    }
                    jSONObject.put("nickname", str2);
                    UserAccount account2 = getAccount();
                    if (account2 != null) {
                        str3 = account2.getProtrait();
                    }
                    jSONObject.put("avatar", str3);
                }
                jSONObject.put("im_uk", String.valueOf(AccountManager.getUK(MiniShellRuntime.INSTANCE.getAppContext())));
                jSONObject.put("tags", "[\"follow\",\"others\"]");
                putAudioExtraAppId(jSONObject);
                roomEnterParams.addExtParams(new Pair<>("audio_extra", jSONObject.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final Map<String, String> genRoomEnterReqParams(RoomEnterParams roomEnterParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, roomEnterParams)) == null) {
            try {
                String encode = URLEncoder.encode(DeviceId.getCUID(MiniShellRuntime.INSTANCE.getAppContext()), "UTF-8");
                Intrinsics.checkExpressionValueIsNotNull(encode, "URLEncoder.encode(Device…ime.appContext), \"UTF-8\")");
                roomEnterParams.addExtParams("device_id", encode);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            roomEnterParams.addExtParams("device_static_score", String.valueOf(ListExtKt.getStaticDeviceScore(MiniShellRuntime.INSTANCE.getAppContext())));
            roomEnterParams.addExtParams("video_play_score", String.valueOf(ListExtKt.getPlayQualityScore()));
            roomEnterParams.addExtParams("bim_uk", String.valueOf(AccountManager.getUK(MiniShellRuntime.INSTANCE.getAppContext())));
            return roomEnterParams.toMap();
        }
        return (Map) invokeL.objValue;
    }

    private final UserAccount getAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            AccountManagerService accountService = getAccountService();
            if (accountService != null) {
                return accountService.getAccount();
            }
            return null;
        }
        return (UserAccount) invokeV.objValue;
    }

    private final boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            AccountManagerService accountService = getAccountService();
            if (accountService != null) {
                return accountService.isLogin(2);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void fetchRoomEnter(final RoomEnterParams roomEnterParams, OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, roomEnterParams, onMixDataLoaded) == null) {
            List<OnMixDataLoaded<MixResult<LiveRoomEnterRespData>>> list = getEnterIdCallbacks().get(roomEnterParams.getId());
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (onMixDataLoaded != null) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                if (list != null) {
                    list.add(onMixDataLoaded);
                }
                getEnterIdCallbacks().put(roomEnterParams.getId(), list);
            }
            if (!z) {
                return;
            }
            if (Intrinsics.areEqual(roomEnterParams.isAudio(), Boolean.TRUE)) {
                addAudioExtraParams(roomEnterParams, roomEnterParams.getId());
            }
            Map<String, String> genRoomEnterReqParams = genRoomEnterReqParams(roomEnterParams);
            MixYaLogService mixYaLogService = (MixYaLogService) MixRequestServiceLocator.Companion.getGlobalService(MixYaLogService.class);
            if (mixYaLogService != null) {
                mixYaLogService.yaLogWithStringFormat(MixYaLogConstants.ENTER_TAG_ID, "request", genRoomEnterReqParams.toString());
            }
            MediaLivePluginLogger.Companion.getInstance().logPageEnterLiveRoomReqNetStart();
            MediaLivePlayLogger.Companion.getInstance().logLiveRoomPageStartEnterLiveReq();
            MixRequesterKt.fetchData(MixUrlConfigKt.getRoomEnterUrl(), genRoomEnterReqParams, new MixNetCallback<JSONObject>(this, roomEnterParams) { // from class: com.baidu.searchbox.live.model.repository.MixRoomRepository$fetchRoomEnter$3
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ RoomEnterParams $enterParams;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MixRoomRepository this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, roomEnterParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$enterParams = roomEnterParams;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.live.model.net.MixNetCallback
                public void onNetResponse(NetResponse netResponse, JSONObject jSONObject) {
                    int i;
                    Map enterIdCallbacks;
                    long j;
                    Map enterIdCallbacks2;
                    NetStatData netStatData;
                    NetStatData netStatData2;
                    Map enterIdCallbacks3;
                    Map enterIdCallbacks4;
                    Integer num;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse, jSONObject) == null) {
                        MediaLivePluginLogger.Companion.getInstance().logPageEnterLiveRoomReqNetEnd();
                        LiveRoomEnterRespData liveRoomEnterRespData = null;
                        String str = null;
                        if (netResponse != null && !netResponse.isSuccessful()) {
                            enterIdCallbacks4 = this.this$0.getEnterIdCallbacks();
                            List<OnMixDataLoaded> list2 = (List) enterIdCallbacks4.get(this.$enterParams.getId());
                            if (list2 != null) {
                                for (OnMixDataLoaded onMixDataLoaded2 : list2) {
                                    if (onMixDataLoaded2 != null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("errno Invalid, errno = ");
                                        if (netResponse != null) {
                                            num = Integer.valueOf(netResponse.responseCode);
                                        } else {
                                            num = null;
                                        }
                                        sb.append(num.intValue());
                                        onMixDataLoaded2.onMixDataLoaded(new MixResult.MixError(new Exception(sb.toString()), null, null, 6, null));
                                    }
                                }
                            }
                        } else if (jSONObject != null && jSONObject.optInt("errno") == 0) {
                            LiveRoomEnterRespData liveRoomEnterRespData2 = new LiveRoomEnterRespData(jSONObject);
                            if (netResponse != null) {
                                str = netResponse.traceid;
                            }
                            liveRoomEnterRespData2.setTraceid(str);
                            MixResultStatData mixResultStatData = new MixResultStatData();
                            long j2 = 0;
                            if (netResponse != null && (netStatData2 = netResponse.statData) != null) {
                                j = netStatData2.requestTimestamp;
                            } else {
                                j = 0;
                            }
                            mixResultStatData.requestTime = j;
                            if (netResponse != null && (netStatData = netResponse.statData) != null) {
                                j2 = netStatData.responseTimestamp;
                            }
                            mixResultStatData.responseTime = j2;
                            enterIdCallbacks2 = this.this$0.getEnterIdCallbacks();
                            List<OnMixDataLoaded> list3 = (List) enterIdCallbacks2.get(this.$enterParams.getId());
                            if (list3 != null) {
                                for (OnMixDataLoaded onMixDataLoaded3 : list3) {
                                    if (onMixDataLoaded3 != null) {
                                        onMixDataLoaded3.onMixDataLoaded(new MixResult.MixSuccess(liveRoomEnterRespData2, mixResultStatData));
                                    }
                                }
                            }
                        } else {
                            if (jSONObject != null) {
                                i = jSONObject.optInt("errno");
                            } else {
                                i = -1;
                            }
                            if (jSONObject != null) {
                                liveRoomEnterRespData = new LiveRoomEnterRespData(jSONObject);
                            }
                            enterIdCallbacks = this.this$0.getEnterIdCallbacks();
                            List<OnMixDataLoaded> list4 = (List) enterIdCallbacks.get(this.$enterParams.getId());
                            if (list4 != null) {
                                for (OnMixDataLoaded onMixDataLoaded4 : list4) {
                                    if (onMixDataLoaded4 != null) {
                                        onMixDataLoaded4.onMixDataLoaded(new MixResult.MixError(new Exception("errno Invalid, errno = " + i), Integer.valueOf(i), liveRoomEnterRespData));
                                    }
                                }
                            }
                        }
                        enterIdCallbacks3 = this.this$0.getEnterIdCallbacks();
                        enterIdCallbacks3.remove(this.$enterParams.getId());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.live.model.net.MixNetCallback
                public JSONObject onParseResponseInBackground(NetResponse netResponse) {
                    InterceptResult invokeL;
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, netResponse)) == null) {
                        MixYaLogService mixYaLogService2 = (MixYaLogService) MixRequestServiceLocator.Companion.getGlobalService(MixYaLogService.class);
                        if (mixYaLogService2 != null) {
                            if (netResponse != null) {
                                str = netResponse.decodedResponseStr;
                            } else {
                                str = null;
                            }
                            mixYaLogService2.yaLogWithStringFormat(MixYaLogConstants.ENTER_TAG_ID, "response", str);
                        }
                        if (netResponse != null && netResponse.isSuccessful()) {
                            try {
                                return new JSONObject(netResponse.decodedResponseStr);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            }, 17, 101, true, null, this.prefetchEnterSwitch);
        }
    }

    public final void fetchRoomExit(RoomExitParams roomExitParams, final OnMixDataLoaded<MixResult<Boolean>> onMixDataLoaded) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, roomExitParams, onMixDataLoaded) == null) {
            if (Intrinsics.areEqual(roomExitParams.isAudio(), Boolean.TRUE)) {
                roomExitParams.addExtParams(ActVideoSetting.ACT_URL, "1");
                JSONObject jSONObject = new JSONObject();
                putAudioExtraAppId(jSONObject);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "audioExtra.toString()");
                roomExitParams.addExtParams("audio_extra", jSONObject2);
            }
            MixRequesterKt.fetchData$default(MixUrlConfigKt.getRoomExitUrl(), roomExitParams.toMap(), new MixNetCallback<Integer>(onMixDataLoaded) { // from class: com.baidu.searchbox.live.model.repository.MixRoomRepository$fetchRoomExit$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ OnMixDataLoaded $callback;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onMixDataLoaded};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$callback = onMixDataLoaded;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.live.model.net.MixNetCallback
                public void onNetResponse(NetResponse netResponse, Integer num) {
                    long j;
                    NetStatData netStatData;
                    NetStatData netStatData2;
                    Integer num2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netResponse, num) == null) {
                        if (num == null) {
                            OnMixDataLoaded onMixDataLoaded2 = this.$callback;
                            if (onMixDataLoaded2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("exitRoom Invalid, code = ");
                                if (netResponse != null) {
                                    num2 = Integer.valueOf(netResponse.responseCode);
                                } else {
                                    num2 = null;
                                }
                                sb.append(num2);
                                onMixDataLoaded2.onMixDataLoaded(new MixResult.MixError(new Exception(sb.toString()), null, null, 6, null));
                            }
                        } else if (num.intValue() == 0) {
                            MixResultStatData mixResultStatData = new MixResultStatData();
                            long j2 = 0;
                            if (netResponse != null && (netStatData2 = netResponse.statData) != null) {
                                j = netStatData2.requestTimestamp;
                            } else {
                                j = 0;
                            }
                            mixResultStatData.requestTime = j;
                            if (netResponse != null && (netStatData = netResponse.statData) != null) {
                                j2 = netStatData.responseTimestamp;
                            }
                            mixResultStatData.responseTime = j2;
                            OnMixDataLoaded onMixDataLoaded3 = this.$callback;
                            if (onMixDataLoaded3 != null) {
                                onMixDataLoaded3.onMixDataLoaded(new MixResult.MixSuccess(Boolean.TRUE, mixResultStatData));
                            }
                        } else {
                            OnMixDataLoaded onMixDataLoaded4 = this.$callback;
                            if (onMixDataLoaded4 != null) {
                                onMixDataLoaded4.onMixDataLoaded(new MixResult.MixError(new Exception("errno Invalid, errno = " + num), null, null, 6, null));
                            }
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.searchbox.live.model.net.MixNetCallback
                public Integer onParseResponseInBackground(NetResponse netResponse) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
                        if (netResponse != null && netResponse.isSuccessful()) {
                            try {
                                return Integer.valueOf(new JSONObject(netResponse.decodedResponseStr).optInt("errno"));
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    }
                    return (Integer) invokeL.objValue;
                }
            }, 17, 102, true, null, false, 192, null);
        }
    }
}
