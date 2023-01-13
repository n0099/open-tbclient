package com.baidu.searchbox.live.model;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.data.pojo.LiveTypeData;
import com.baidu.searchbox.live.data.req.LiveListParamsMix;
import com.baidu.searchbox.live.data.req.RoomEnterParams;
import com.baidu.searchbox.live.data.req.RoomExitParams;
import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.domain.SlideListInfo;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.frame.ListInfo;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.model.MixModel;
import com.baidu.searchbox.live.model.repository.MixListRepository;
import com.baidu.searchbox.live.model.repository.MixRoomRepository;
import com.baidu.searchbox.live.model.repository.MixTypeRepository;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILiveListState;
import com.baidu.searchbox.live.service.MixRequestService;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000:\u0001;B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bJ%\u0010\r\u001a\u00020\u00062\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e¢\u0006\u0004\b\r\u0010\u0012J+\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0014\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00108\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/live/model/MixModel;", "Lcom/baidu/searchbox/live/domain/SlideListInfo$SlideInfo;", "item", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "parseLiveItemModel", "(Lcom/baidu/searchbox/live/domain/SlideListInfo$SlideInfo;)Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "", "queryLiveList", "()V", "", "roomId", "removeReqEnterIdCallbacks", "(Ljava/lang/String;)V", "reqLiveType", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", WebChromeClient.KEY_ARG_CALLBACK, "(Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "Lcom/baidu/searchbox/live/data/req/RoomEnterParams;", "enterParams", "reqRoomEnter", "(Lcom/baidu/searchbox/live/data/req/RoomEnterParams;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "Lcom/baidu/searchbox/live/data/req/RoomExitParams;", "exitParams", "", "reqRoomExit", "(Lcom/baidu/searchbox/live/data/req/RoomExitParams;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;", "callBack", "setOnMixDataLoadedCallBack", "(Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;)V", "Lcom/baidu/searchbox/live/model/repository/MixListRepository;", "listApi$delegate", "Lkotlin/Lazy;", "getListApi", "()Lcom/baidu/searchbox/live/model/repository/MixListRepository;", "listApi", "Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;", "liveTypeApi$delegate", "getLiveTypeApi", "()Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;", "liveTypeApi", "mOnMixDataLoadedCallBack", "Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "prefetchEnterSupport", "Z", "Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;", "roomApi$delegate", "getRoomApi", "()Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;", "roomApi", "<init>", "(Lcom/baidu/live/arch/utils/MiniUniqueId;)V", "OnMixDataLoadedCallBack", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixModel {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy listApi$delegate;
    public final Lazy liveTypeApi$delegate;
    public OnMixDataLoadedCallBack mOnMixDataLoadedCallBack;
    public final MiniUniqueId mixUniqueId;
    public final boolean prefetchEnterSupport;
    public final Lazy roomApi$delegate;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1133317377, "Lcom/baidu/searchbox/live/model/MixModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1133317377, "Lcom/baidu/searchbox/live/model/MixModel;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixModel.class), "listApi", "getListApi()Lcom/baidu/searchbox/live/model/repository/MixListRepository;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixModel.class), "liveTypeApi", "getLiveTypeApi()Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixModel.class), "roomApi", "getRoomApi()Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;"))};
    }

    private final MixListRepository getListApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Lazy lazy = this.listApi$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (MixListRepository) lazy.getValue();
        }
        return (MixListRepository) invokeV.objValue;
    }

    private final MixTypeRepository getLiveTypeApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Lazy lazy = this.liveTypeApi$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (MixTypeRepository) lazy.getValue();
        }
        return (MixTypeRepository) invokeV.objValue;
    }

    private final MixRoomRepository getRoomApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Lazy lazy = this.roomApi$delegate;
            KProperty kProperty = $$delegatedProperties[2];
            return (MixRoomRepository) lazy.getValue();
        }
        return (MixRoomRepository) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;", "Lkotlin/Any;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "errorno", "", "onSlideListFail", "(Ljava/lang/Exception;Ljava/lang/Integer;)V", "", "pageSession", "hasMore", "", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "data", "onSlideListSuccess", "(Ljava/lang/String;ILjava/util/List;)V", "onTemplateIdFail", "()V", "Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "liveType", "onTemplateIdSuccess", "(Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnMixDataLoadedCallBack {
        void onSlideListFail(Exception exc, Integer num);

        void onSlideListSuccess(String str, int i, List<LiveContainer.LiveItemModel> list);

        void onTemplateIdFail();

        void onTemplateIdSuccess(LiveTypeData liveTypeData);

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public static /* synthetic */ void onSlideListFail$default(OnMixDataLoadedCallBack onMixDataLoadedCallBack, Exception exc, Integer num, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        num = -1;
                    }
                    onMixDataLoadedCallBack.onSlideListFail(exc, num);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSlideListFail");
            }
        }
    }

    public MixModel(MiniUniqueId miniUniqueId) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {miniUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mixUniqueId = miniUniqueId;
        this.listApi$delegate = LazyKt__LazyJVMKt.lazy(MixModel$listApi$2.INSTANCE);
        this.liveTypeApi$delegate = LazyKt__LazyJVMKt.lazy(MixModel$liveTypeApi$2.INSTANCE);
        this.roomApi$delegate = LazyKt__LazyJVMKt.lazy(MixModel$roomApi$2.INSTANCE);
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
        this.prefetchEnterSupport = z2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.searchbox.live.service.MixRequestService */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reqLiveType(final OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
        IntentData intentData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onMixDataLoaded) == null) {
            ILiveListState iLiveListState = (ILiveListState) ServiceLocator.Companion.getGlobalService(ILiveListState.class);
            if (iLiveListState != null) {
                intentData = iLiveListState.getIntent();
            } else {
                intentData = null;
            }
            String str = (intentData == null || (r1 = intentData.getId()) == null) ? "" : "";
            if (this.prefetchEnterSupport && MixRequestServiceLocator.Companion.getGlobalService(MixRequestService.class) != null) {
                MediaLivePluginLogger.Companion.getInstance().logListGetLiveTypeStartToSendReqNet();
                MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartGetLiveTypeTime();
                MixRequestService mixRequestService = (MixRequestService) MixRequestServiceLocator.Companion.getGlobalService(MixRequestService.class);
                if (mixRequestService != 0) {
                    mixRequestService.requestRoomEnter(new RoomEnterParams(str, "", null, null, "", false, 44, null), true, new OnMixDataLoaded<MixResult<? extends LiveRoomEnterRespData>>(this, onMixDataLoaded) { // from class: com.baidu.searchbox.live.model.MixModel$reqLiveType$1
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ OnMixDataLoaded $callback;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MixModel this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, onMixDataLoaded};
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
                            this.$callback = onMixDataLoaded;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:44:0x00a2, code lost:
                            r7 = r6.this$0.mOnMixDataLoadedCallBack;
                         */
                        /* renamed from: onMixDataLoaded  reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void onMixDataLoaded2(MixResult<LiveRoomEnterRespData> mixResult) {
                            MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack;
                            JSONObject jSONObject;
                            JSONObject jSONObject2;
                            String str2;
                            String str3;
                            String str4;
                            JSONObject jSONObject3;
                            MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, mixResult) == null) {
                                MediaLivePluginLogger.Companion.getInstance().logGetLiveTypeNetEndAndStartParse();
                                if (mixResult instanceof MixResult.MixSuccess) {
                                    OnMixDataLoaded onMixDataLoaded2 = this.$callback;
                                    if (onMixDataLoaded2 != null) {
                                        onMixDataLoaded2.onMixDataLoaded(mixResult);
                                    }
                                    JSONObject respJsonObj = ((LiveRoomEnterRespData) ((MixResult.MixSuccess) mixResult).getData()).getRespJsonObj();
                                    String str5 = null;
                                    if (respJsonObj != null) {
                                        jSONObject = respJsonObj.optJSONObject("data");
                                    } else {
                                        jSONObject = null;
                                    }
                                    if (jSONObject != null) {
                                        jSONObject2 = jSONObject.optJSONObject("room");
                                    } else {
                                        jSONObject2 = null;
                                    }
                                    if (jSONObject2 != null) {
                                        str2 = jSONObject2.optString("room_id");
                                    } else {
                                        str2 = null;
                                    }
                                    if (jSONObject2 != null) {
                                        str3 = jSONObject2.optString("template_id");
                                    } else {
                                        str3 = null;
                                    }
                                    if (jSONObject2 != null) {
                                        str4 = jSONObject2.optString("room_type");
                                    } else {
                                        str4 = null;
                                    }
                                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                                        if (jSONObject != null) {
                                            jSONObject3 = jSONObject.optJSONObject("room_template_info");
                                        } else {
                                            jSONObject3 = null;
                                        }
                                        if (jSONObject3 != null) {
                                            str3 = jSONObject3.optString("template_id");
                                        } else {
                                            str3 = null;
                                        }
                                        if (jSONObject3 != null) {
                                            str5 = jSONObject3.optString("live_type");
                                        }
                                        str4 = str5;
                                    }
                                    LiveTypeData liveTypeData = new LiveTypeData();
                                    liveTypeData.setRoomId(str2);
                                    liveTypeData.setTemplateId(str3);
                                    liveTypeData.setLiveType(str4);
                                    onMixDataLoadedCallBack2 = this.this$0.mOnMixDataLoadedCallBack;
                                    if (onMixDataLoadedCallBack2 != null) {
                                        onMixDataLoadedCallBack2.onTemplateIdSuccess(liveTypeData);
                                    }
                                } else if ((mixResult instanceof MixResult.MixError) && onMixDataLoadedCallBack != null) {
                                    onMixDataLoadedCallBack.onTemplateIdFail();
                                }
                            }
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
                        public /* bridge */ /* synthetic */ void onMixDataLoaded(MixResult<? extends LiveRoomEnterRespData> mixResult) {
                            onMixDataLoaded2((MixResult<LiveRoomEnterRespData>) mixResult);
                        }
                    });
                    return;
                }
                return;
            }
            getLiveTypeApi().fetchLiveType(str, new OnMixDataLoaded<MixResult<? extends LiveTypeData>>(this) { // from class: com.baidu.searchbox.live.model.MixModel$reqLiveType$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MixModel this$0;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
                public /* bridge */ /* synthetic */ void onMixDataLoaded(MixResult<? extends LiveTypeData> mixResult) {
                    onMixDataLoaded2((MixResult<LiveTypeData>) mixResult);
                }

                /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
                    r5 = r4.this$0.mOnMixDataLoadedCallBack;
                 */
                /* renamed from: onMixDataLoaded  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMixDataLoaded2(MixResult<LiveTypeData> mixResult) {
                    MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack;
                    MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mixResult) == null) {
                        if (mixResult instanceof MixResult.MixSuccess) {
                            onMixDataLoadedCallBack2 = this.this$0.mOnMixDataLoadedCallBack;
                            if (onMixDataLoadedCallBack2 != null) {
                                onMixDataLoadedCallBack2.onTemplateIdSuccess((LiveTypeData) ((MixResult.MixSuccess) mixResult).getData());
                            }
                        } else if ((mixResult instanceof MixResult.MixError) && onMixDataLoadedCallBack != null) {
                            onMixDataLoadedCallBack.onTemplateIdFail();
                        }
                    }
                }
            });
        }
    }

    public final void removeReqEnterIdCallbacks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            getRoomApi().removeEnterIdCallbacks(str);
        }
    }

    public final void setOnMixDataLoadedCallBack(OnMixDataLoadedCallBack onMixDataLoadedCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onMixDataLoadedCallBack) == null) {
            this.mOnMixDataLoadedCallBack = onMixDataLoadedCallBack;
        }
    }

    public final void reqRoomEnter(RoomEnterParams roomEnterParams, OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, roomEnterParams, onMixDataLoaded) == null) {
            getRoomApi().fetchRoomEnter(roomEnterParams, onMixDataLoaded);
        }
    }

    public final void reqRoomExit(RoomExitParams roomExitParams, OnMixDataLoaded<MixResult<Boolean>> onMixDataLoaded) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, roomExitParams, onMixDataLoaded) == null) {
            getRoomApi().fetchRoomExit(roomExitParams, onMixDataLoaded);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveContainer.LiveItemModel parseLiveItemModel(SlideListInfo.SlideInfo slideInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, slideInfo)) == null) {
            LiveContainer.LiveItemModel liveItemModel = new LiveContainer.LiveItemModel();
            String str = slideInfo.roomId;
            Intrinsics.checkExpressionValueIsNotNull(str, "item.roomId");
            liveItemModel.setRoomId(str);
            String str2 = slideInfo.cover;
            Intrinsics.checkExpressionValueIsNotNull(str2, "item.cover");
            liveItemModel.setCover(str2);
            String str3 = slideInfo.liveType;
            Intrinsics.checkExpressionValueIsNotNull(str3, "item.liveType");
            liveItemModel.setLiveType(str3);
            String str4 = slideInfo.scheme;
            Intrinsics.checkExpressionValueIsNotNull(str4, "item.scheme");
            liveItemModel.setScheme(str4);
            String str5 = slideInfo.playUrl;
            Intrinsics.checkExpressionValueIsNotNull(str5, "item.playUrl");
            liveItemModel.setPlayUrl(str5);
            liveItemModel.setStatus(slideInfo.status);
            liveItemModel.setFormat(slideInfo.format);
            liveItemModel.setScreen(slideInfo.screen);
            liveItemModel.setTemplate(slideInfo.template);
            liveItemModel.setFeedId(slideInfo.feedId);
            liveItemModel.setTemplateId(slideInfo.templateId);
            String str6 = slideInfo.bgCover;
            Intrinsics.checkExpressionValueIsNotNull(str6, "item.bgCover");
            liveItemModel.setBgCover(str6);
            String str7 = slideInfo.title;
            Intrinsics.checkExpressionValueIsNotNull(str7, "item.title");
            liveItemModel.setTitle(str7);
            String str8 = slideInfo.cRoomId;
            Intrinsics.checkExpressionValueIsNotNull(str8, "item.cRoomId");
            liveItemModel.setCRoomId(str8);
            liveItemModel.setSlog(slideInfo.slog);
            LiveContainer.LiveRuntimeStatus liveRuntimeStatus = new LiveContainer.LiveRuntimeStatus();
            liveRuntimeStatus.setPosition(-1);
            liveItemModel.setRuntimeStatus(liveRuntimeStatus);
            liveItemModel.setOriginJson(slideInfo.originJson);
            liveItemModel.setIm(slideInfo.im);
            liveItemModel.setAvcUrl(slideInfo.avcUrl);
            liveItemModel.setHevcUrl(slideInfo.hevcUrl);
            liveItemModel.setRtcUrl(slideInfo.rtcUrl);
            liveItemModel.setRtcHevcUrl(slideInfo.rtcHevcUrl);
            liveItemModel.setQuic(slideInfo.quic);
            liveItemModel.setBlurBg(slideInfo.isBlurBg);
            liveItemModel.setHighlightUrl(slideInfo.highlightUrl);
            liveItemModel.setKabrSpts(slideInfo.kabrSpts);
            liveItemModel.setMultiRate(slideInfo.multiRate);
            liveItemModel.setVrParams(slideInfo.vrParams);
            return liveItemModel;
        }
        return (LiveContainer.LiveItemModel) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.model.MixModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reqLiveType$default(MixModel mixModel, OnMixDataLoaded onMixDataLoaded, int i, Object obj) {
        if ((i & 1) != 0) {
            onMixDataLoaded = null;
        }
        mixModel.reqLiveType(onMixDataLoaded);
    }

    public final MiniUniqueId getMixUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mixUniqueId;
        }
        return (MiniUniqueId) invokeV.objValue;
    }

    public final void reqLiveType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            reqLiveType(null);
        }
    }

    public final void queryLiveList() {
        IntentData intentData;
        String str;
        IntentData.SchemeModel model;
        String source;
        IntentData.SchemeModel model2;
        JSONObject ext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ILiveListState iLiveListState = (ILiveListState) ServiceLocator.Companion.getGlobalService(ILiveListState.class);
            ListInfo listInfo = null;
            if (iLiveListState != null) {
                intentData = iLiveListState.getIntent();
            } else {
                intentData = null;
            }
            ILiveListState iLiveListState2 = (ILiveListState) ServiceLocator.Companion.getGlobalService(ILiveListState.class);
            if (iLiveListState2 != null) {
                listInfo = iLiveListState2.getListInfo();
            }
            String str2 = "";
            String str3 = (intentData == null || (str3 = intentData.getId()) == null) ? "" : "";
            String str4 = (listInfo == null || (str4 = listInfo.getPageSession()) == null) ? "" : "";
            if (intentData == null || (model2 = intentData.getModel()) == null || (ext = model2.getExt()) == null || (str = ext.toString()) == null) {
                str = StringUtil.EMPTY_ARRAY;
            }
            Intrinsics.checkExpressionValueIsNotNull(str, "intentData?.model?.ext?.toString() ?: \"{}\"");
            if (intentData != null && (model = intentData.getModel()) != null && (source = model.getSource()) != null) {
                str2 = source;
            }
            ListLogKt.log("MixLiveCell_fake_list", "queryLiveList");
            getListApi().fetchLiveSlideList(new LiveListParamsMix(str3, str4, str, str2), new OnMixDataLoaded<MixResult<? extends SlideListInfo>>(this) { // from class: com.baidu.searchbox.live.model.MixModel$queryLiveList$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MixModel this$0;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
                public void onMixDataLoaded(MixResult<? extends SlideListInfo> mixResult) {
                    MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack;
                    MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack2;
                    LiveContainer.LiveItemModel parseLiveItemModel;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mixResult) == null) {
                        if (mixResult instanceof MixResult.MixSuccess) {
                            ArrayList arrayList = new ArrayList();
                            MixResult.MixSuccess mixSuccess = (MixResult.MixSuccess) mixResult;
                            if (((SlideListInfo) mixSuccess.getData()).list != null && ((SlideListInfo) mixSuccess.getData()).list.size() > 0) {
                                Iterator<SlideListInfo.SlideInfo> it = ((SlideListInfo) mixSuccess.getData()).list.iterator();
                                while (it.hasNext()) {
                                    SlideListInfo.SlideInfo item = it.next();
                                    MixModel mixModel = this.this$0;
                                    Intrinsics.checkExpressionValueIsNotNull(item, "item");
                                    parseLiveItemModel = mixModel.parseLiveItemModel(item);
                                    arrayList.add(parseLiveItemModel);
                                }
                            }
                            ListLogKt.log("MixLiveCell_fake_list", "queryLiveList suc size:" + arrayList.size());
                            MediaLivePluginLogger.Companion.getInstance().logListParseEndAndNextToAddItem();
                            onMixDataLoadedCallBack2 = this.this$0.mOnMixDataLoadedCallBack;
                            if (onMixDataLoadedCallBack2 != null) {
                                String str5 = ((SlideListInfo) mixSuccess.getData()).pageSession;
                                if (str5 == null) {
                                    str5 = "";
                                }
                                onMixDataLoadedCallBack2.onSlideListSuccess(str5, ((SlideListInfo) mixSuccess.getData()).hasMore, arrayList);
                            }
                        } else if (mixResult instanceof MixResult.MixError) {
                            ListLogKt.log("MixLiveCell_fake_list", "queryLiveList fail");
                            onMixDataLoadedCallBack = this.this$0.mOnMixDataLoadedCallBack;
                            if (onMixDataLoadedCallBack != null) {
                                MixModel.OnMixDataLoadedCallBack.DefaultImpls.onSlideListFail$default(onMixDataLoadedCallBack, ((MixResult.MixError) mixResult).getException(), null, 2, null);
                            }
                        }
                    }
                }
            });
        }
    }
}
