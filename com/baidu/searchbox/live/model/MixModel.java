package com.baidu.searchbox.live.model;

import android.text.TextUtils;
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
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000:\u0001;B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bJ%\u0010\r\u001a\u00020\u00062\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e¢\u0006\u0004\b\r\u0010\u0012J+\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0014\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00108\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/live/model/MixModel;", "Lcom/baidu/searchbox/live/domain/SlideListInfo$SlideInfo;", "item", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "parseLiveItemModel", "(Lcom/baidu/searchbox/live/domain/SlideListInfo$SlideInfo;)Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "", "queryLiveList", "()V", "", "roomId", "removeReqEnterIdCallbacks", "(Ljava/lang/String;)V", "reqLiveType", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", WebChromeClient.KEY_ARG_CALLBACK, "(Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "Lcom/baidu/searchbox/live/data/req/RoomEnterParams;", "enterParams", "reqRoomEnter", "(Lcom/baidu/searchbox/live/data/req/RoomEnterParams;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "Lcom/baidu/searchbox/live/data/req/RoomExitParams;", "exitParams", "", "reqRoomExit", "(Lcom/baidu/searchbox/live/data/req/RoomExitParams;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;", "callBack", "setOnMixDataLoadedCallBack", "(Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;)V", "Lcom/baidu/searchbox/live/model/repository/MixListRepository;", "listApi$delegate", "Lkotlin/Lazy;", "getListApi", "()Lcom/baidu/searchbox/live/model/repository/MixListRepository;", "listApi", "Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;", "liveTypeApi$delegate", "getLiveTypeApi", "()Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;", "liveTypeApi", "mOnMixDataLoadedCallBack", "Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "getMixUniqueId", "()Lcom/baidu/live/arch/utils/MiniUniqueId;", "prefetchEnterSupport", "Z", "Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;", "roomApi$delegate", "getRoomApi", "()Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;", "roomApi", "<init>", "(Lcom/baidu/live/arch/utils/MiniUniqueId;)V", "OnMixDataLoadedCallBack", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MixModel {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixModel.class), "listApi", "getListApi()Lcom/baidu/searchbox/live/model/repository/MixListRepository;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixModel.class), "liveTypeApi", "getLiveTypeApi()Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixModel.class), "roomApi", "getRoomApi()Lcom/baidu/searchbox/live/model/repository/MixRoomRepository;"))};
    public OnMixDataLoadedCallBack mOnMixDataLoadedCallBack;
    public final MiniUniqueId mixUniqueId;
    public final boolean prefetchEnterSupport;
    public final Lazy listApi$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MixListRepository>() { // from class: com.baidu.searchbox.live.model.MixModel$listApi$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MixListRepository invoke() {
            return new MixListRepository();
        }
    });
    public final Lazy liveTypeApi$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MixTypeRepository>() { // from class: com.baidu.searchbox.live.model.MixModel$liveTypeApi$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MixTypeRepository invoke() {
            return new MixTypeRepository();
        }
    });
    public final Lazy roomApi$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MixRoomRepository>() { // from class: com.baidu.searchbox.live.model.MixModel$roomApi$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MixRoomRepository invoke() {
            return new MixRoomRepository();
        }
    });

    private final MixListRepository getListApi() {
        Lazy lazy = this.listApi$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (MixListRepository) lazy.getValue();
    }

    private final MixTypeRepository getLiveTypeApi() {
        Lazy lazy = this.liveTypeApi$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (MixTypeRepository) lazy.getValue();
    }

    private final MixRoomRepository getRoomApi() {
        Lazy lazy = this.roomApi$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (MixRoomRepository) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0013\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/model/MixModel$OnMixDataLoadedCallBack;", "Lkotlin/Any;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "errorno", "", "traceId", "", "onSlideListFail", "(Ljava/lang/Exception;Ljava/lang/Integer;Ljava/lang/String;)V", "pageSession", "hasMore", "", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "data", "onSlideListSuccess", "(Ljava/lang/String;ILjava/util/List;)V", "onTemplateIdFail", "Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "liveType", "onTemplateIdSuccess", "(Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface OnMixDataLoadedCallBack {
        void onSlideListFail(Exception exc, Integer num, String str);

        void onSlideListSuccess(String str, int i, List<LiveContainer.LiveItemModel> list);

        void onTemplateIdFail(Exception exc, Integer num, String str);

        void onTemplateIdSuccess(LiveTypeData liveTypeData);

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
        /* loaded from: classes3.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onSlideListFail$default(OnMixDataLoadedCallBack onMixDataLoadedCallBack, Exception exc, Integer num, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        num = -1;
                    }
                    if ((i & 4) != 0) {
                        str = null;
                    }
                    onMixDataLoadedCallBack.onSlideListFail(exc, num, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSlideListFail");
            }

            public static /* synthetic */ void onTemplateIdFail$default(OnMixDataLoadedCallBack onMixDataLoadedCallBack, Exception exc, Integer num, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        num = -1;
                    }
                    if ((i & 4) != 0) {
                        str = null;
                    }
                    onMixDataLoadedCallBack.onTemplateIdFail(exc, num, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTemplateIdFail");
            }
        }
    }

    public MixModel(MiniUniqueId miniUniqueId) {
        boolean z;
        int i;
        this.mixUniqueId = miniUniqueId;
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

    public final void removeReqEnterIdCallbacks(String str) {
        getRoomApi().removeEnterIdCallbacks(str);
    }

    public final void setOnMixDataLoadedCallBack(OnMixDataLoadedCallBack onMixDataLoadedCallBack) {
        this.mOnMixDataLoadedCallBack = onMixDataLoadedCallBack;
    }

    public final void reqRoomEnter(RoomEnterParams roomEnterParams, OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
        getRoomApi().fetchRoomEnter(roomEnterParams, onMixDataLoaded);
    }

    public final void reqRoomExit(RoomExitParams roomExitParams, OnMixDataLoaded<MixResult<Boolean>> onMixDataLoaded) {
        getRoomApi().fetchRoomExit(roomExitParams, onMixDataLoaded);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveContainer.LiveItemModel parseLiveItemModel(SlideListInfo.SlideInfo slideInfo) {
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
        liveItemModel.setPlayRateSetting(slideInfo.playRateSetting);
        return liveItemModel;
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
        return this.mixUniqueId;
    }

    public final void reqLiveType() {
        reqLiveType(null);
    }

    public final void queryLiveList() {
        IntentData intentData;
        IntentData.SchemeModel model;
        String source;
        IntentData.SchemeModel model2;
        JSONObject ext;
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
        String str = "";
        String str2 = (intentData == null || (str2 = intentData.getId()) == null) ? "" : "";
        String str3 = (listInfo == null || (str3 = listInfo.getPageSession()) == null) ? "" : "";
        String str4 = (intentData == null || (model2 = intentData.getModel()) == null || (ext = model2.getExt()) == null || (str4 = ext.toString()) == null) ? "{}" : "{}";
        Intrinsics.checkExpressionValueIsNotNull(str4, "intentData?.model?.ext?.toString() ?: \"{}\"");
        if (intentData != null && (model = intentData.getModel()) != null && (source = model.getSource()) != null) {
            str = source;
        }
        ListLogKt.log("MixLiveCell_fake_list", "queryLiveList");
        getListApi().fetchLiveSlideList(new LiveListParamsMix(str2, str3, str4, str), new OnMixDataLoaded<MixResult<? extends SlideListInfo>>() { // from class: com.baidu.searchbox.live.model.MixModel$queryLiveList$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
            public void onMixDataLoaded(MixResult<? extends SlideListInfo> mixResult) {
                MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack;
                MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack2;
                LiveContainer.LiveItemModel parseLiveItemModel;
                if (mixResult instanceof MixResult.MixSuccess) {
                    ArrayList arrayList = new ArrayList();
                    MixResult.MixSuccess mixSuccess = (MixResult.MixSuccess) mixResult;
                    if (((SlideListInfo) mixSuccess.getData()).list != null && ((SlideListInfo) mixSuccess.getData()).list.size() > 0) {
                        Iterator<SlideListInfo.SlideInfo> it = ((SlideListInfo) mixSuccess.getData()).list.iterator();
                        while (it.hasNext()) {
                            SlideListInfo.SlideInfo item = it.next();
                            MixModel mixModel = MixModel.this;
                            Intrinsics.checkExpressionValueIsNotNull(item, "item");
                            parseLiveItemModel = mixModel.parseLiveItemModel(item);
                            arrayList.add(parseLiveItemModel);
                        }
                    }
                    ListLogKt.log("MixLiveCell_fake_list", "queryLiveList suc size:" + arrayList.size());
                    MediaLivePluginLogger.Companion.getInstance().logListParseEndAndNextToAddItem();
                    onMixDataLoadedCallBack2 = MixModel.this.mOnMixDataLoadedCallBack;
                    if (onMixDataLoadedCallBack2 != null) {
                        String str5 = ((SlideListInfo) mixSuccess.getData()).pageSession;
                        if (str5 == null) {
                            str5 = "";
                        }
                        onMixDataLoadedCallBack2.onSlideListSuccess(str5, ((SlideListInfo) mixSuccess.getData()).hasMore, arrayList);
                    }
                } else if (mixResult instanceof MixResult.MixError) {
                    ListLogKt.log("MixLiveCell_fake_list", "queryLiveList fail");
                    onMixDataLoadedCallBack = MixModel.this.mOnMixDataLoadedCallBack;
                    if (onMixDataLoadedCallBack != null) {
                        MixResult.MixError mixError = (MixResult.MixError) mixResult;
                        MixModel.OnMixDataLoadedCallBack.DefaultImpls.onSlideListFail$default(onMixDataLoadedCallBack, mixError.getException(), mixError.getErrorno(), null, 4, null);
                    }
                }
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.searchbox.live.service.MixRequestService */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reqLiveType(final OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
        IntentData intentData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        IntentData.SchemeModel model;
        JSONObject extLog;
        String jSONObject;
        IntentData.SchemeModel model2;
        JSONObject ext;
        String jSONObject2;
        IntentData.SchemeModel model3;
        JSONObject hlReplyIntoLive;
        String optString;
        IntentData.SchemeModel model4;
        JSONObject searchIntoLiveJson;
        String optString2;
        String source;
        String id;
        ILiveListState iLiveListState = (ILiveListState) ServiceLocator.Companion.getGlobalService(ILiveListState.class);
        if (iLiveListState != null) {
            intentData = iLiveListState.getIntent();
        } else {
            intentData = null;
        }
        String str6 = "";
        if (intentData == null || (id = intentData.getId()) == null) {
            str = "";
        } else {
            str = id;
        }
        if (this.prefetchEnterSupport && MixRequestServiceLocator.Companion.getGlobalService(MixRequestService.class) != null) {
            MediaLivePluginLogger.Companion.getInstance().logListGetLiveTypeStartToSendReqNet();
            MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartGetLiveTypeTime();
            if (intentData == null || (source = intentData.getSource()) == null) {
                str2 = "";
            } else {
                str2 = source;
            }
            if (intentData == null || (model4 = intentData.getModel()) == null || (searchIntoLiveJson = model4.getSearchIntoLiveJson()) == null || (optString2 = searchIntoLiveJson.optString("question")) == null) {
                str3 = "";
            } else {
                str3 = optString2;
            }
            if (intentData == null || (model3 = intentData.getModel()) == null || (hlReplyIntoLive = model3.getHlReplyIntoLive()) == null || (optString = hlReplyIntoLive.optString("nid", "")) == null) {
                str4 = "";
            } else {
                str4 = optString;
            }
            if (intentData == null || (model2 = intentData.getModel()) == null || (ext = model2.getExt()) == null || (jSONObject2 = ext.toString()) == null) {
                str5 = "";
            } else {
                str5 = jSONObject2;
            }
            RoomEnterParams roomEnterParams = new RoomEnterParams(str, str2, str3, str4, str5, false, 32, null);
            if (intentData != null && (model = intentData.getModel()) != null && (extLog = model.getExtLog()) != null && (jSONObject = extLog.toString()) != null) {
                str6 = jSONObject;
            }
            roomEnterParams.setExtLog(str6);
            MixRequestService mixRequestService = (MixRequestService) MixRequestServiceLocator.Companion.getGlobalService(MixRequestService.class);
            if (mixRequestService != 0) {
                mixRequestService.requestRoomEnter(roomEnterParams, true, new OnMixDataLoaded<MixResult<? extends LiveRoomEnterRespData>>() { // from class: com.baidu.searchbox.live.model.MixModel$reqLiveType$1
                    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
                        r1 = r7.this$0.mOnMixDataLoadedCallBack;
                     */
                    /* renamed from: onMixDataLoaded  reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onMixDataLoaded2(MixResult<LiveRoomEnterRespData> mixResult) {
                        MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack;
                        JSONObject jSONObject3;
                        JSONObject jSONObject4;
                        String str7;
                        String str8;
                        String str9;
                        JSONObject jSONObject5;
                        MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack2;
                        MediaLivePluginLogger.Companion.getInstance().logGetLiveTypeNetEndAndStartParse();
                        if (mixResult instanceof MixResult.MixSuccess) {
                            OnMixDataLoaded onMixDataLoaded2 = onMixDataLoaded;
                            if (onMixDataLoaded2 != null) {
                                onMixDataLoaded2.onMixDataLoaded(mixResult);
                            }
                            JSONObject respJsonObj = ((LiveRoomEnterRespData) ((MixResult.MixSuccess) mixResult).getData()).getRespJsonObj();
                            String str10 = null;
                            if (respJsonObj != null) {
                                jSONObject3 = respJsonObj.optJSONObject("data");
                            } else {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                jSONObject4 = jSONObject3.optJSONObject(YYOption.ROOM_ID);
                            } else {
                                jSONObject4 = null;
                            }
                            if (jSONObject4 != null) {
                                str7 = jSONObject4.optString("room_id");
                            } else {
                                str7 = null;
                            }
                            if (jSONObject4 != null) {
                                str8 = jSONObject4.optString("template_id");
                            } else {
                                str8 = null;
                            }
                            if (jSONObject4 != null) {
                                str9 = jSONObject4.optString(Constants.EXTRA_ROOM_TYPE);
                            } else {
                                str9 = null;
                            }
                            if (TextUtils.isEmpty(str8) || TextUtils.isEmpty(str9)) {
                                if (jSONObject3 != null) {
                                    jSONObject5 = jSONObject3.optJSONObject("room_template_info");
                                } else {
                                    jSONObject5 = null;
                                }
                                if (jSONObject5 != null) {
                                    str8 = jSONObject5.optString("template_id");
                                } else {
                                    str8 = null;
                                }
                                if (jSONObject5 != null) {
                                    str10 = jSONObject5.optString("live_type");
                                }
                                str9 = str10;
                            }
                            LiveTypeData liveTypeData = new LiveTypeData();
                            liveTypeData.setRoomId(str7);
                            liveTypeData.setTemplateId(str8);
                            liveTypeData.setLiveType(str9);
                            onMixDataLoadedCallBack2 = MixModel.this.mOnMixDataLoadedCallBack;
                            if (onMixDataLoadedCallBack2 != null) {
                                onMixDataLoadedCallBack2.onTemplateIdSuccess(liveTypeData);
                            }
                        } else if ((mixResult instanceof MixResult.MixError) && onMixDataLoadedCallBack != null) {
                            MixResult.MixError mixError = (MixResult.MixError) mixResult;
                            MixModel.OnMixDataLoadedCallBack.DefaultImpls.onTemplateIdFail$default(onMixDataLoadedCallBack, mixError.getException(), mixError.getErrorno(), null, 4, null);
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
        getLiveTypeApi().fetchLiveType(str, new OnMixDataLoaded<MixResult<? extends LiveTypeData>>() { // from class: com.baidu.searchbox.live.model.MixModel$reqLiveType$2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.searchbox.live.model.res.OnMixDataLoaded
            public /* bridge */ /* synthetic */ void onMixDataLoaded(MixResult<? extends LiveTypeData> mixResult) {
                onMixDataLoaded2((MixResult<LiveTypeData>) mixResult);
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
                r1 = r7.this$0.mOnMixDataLoadedCallBack;
             */
            /* renamed from: onMixDataLoaded  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMixDataLoaded2(MixResult<LiveTypeData> mixResult) {
                MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack;
                MixModel.OnMixDataLoadedCallBack onMixDataLoadedCallBack2;
                if (mixResult instanceof MixResult.MixSuccess) {
                    onMixDataLoadedCallBack2 = MixModel.this.mOnMixDataLoadedCallBack;
                    if (onMixDataLoadedCallBack2 != null) {
                        onMixDataLoadedCallBack2.onTemplateIdSuccess((LiveTypeData) ((MixResult.MixSuccess) mixResult).getData());
                    }
                } else if ((mixResult instanceof MixResult.MixError) && onMixDataLoadedCallBack != null) {
                    MixResult.MixError mixError = (MixResult.MixError) mixResult;
                    MixModel.OnMixDataLoadedCallBack.DefaultImpls.onTemplateIdFail$default(onMixDataLoadedCallBack, mixError.getException(), mixError.getErrorno(), null, 4, null);
                }
            }
        });
    }
}
