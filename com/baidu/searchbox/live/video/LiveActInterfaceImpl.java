package com.baidu.searchbox.live.video;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.data.req.RoomEnterParams;
import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.frame.ListInfo;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.searchbox.live.gesture.HorizonMotionEventCaptureView;
import com.baidu.searchbox.live.host2live.video.ILiveActInterface;
import com.baidu.searchbox.live.host2live.video.ILiveItem;
import com.baidu.searchbox.live.host2live.video.ILiveToListInvokeAbility;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.LiveSessionService;
import com.baidu.searchbox.live.model.MixModel;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.service.ILiveListState;
import com.baidu.searchbox.live.service.ILivePageInfoInterface;
import com.baidu.searchbox.live.service.MixRequestService;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.util.ImmersionUtils;
import com.baidu.searchbox.live.util.ListExtKt;
import com.baidu.searchbox.live.util.LruLinkedHashMap;
import com.baidu.searchbox.live.video.LiveActInterfaceImpl;
import com.baidu.searchbox.live.video.LiveItemImpl;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 a2\u00020\u0001:\u0002baB#\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010]\u001a\u0004\u0018\u00010=\u0012\b\u0010^\u001a\u0004\u0018\u00010,¢\u0006\u0004\b_\u0010`J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J)\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010$\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0 2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004R\u0019\u0010(\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0019\u0010/\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R$\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010Q\u001a\n P*\u0004\u0018\u00010O0O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001b\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001d\u0010\\\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[¨\u0006c"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl;", "Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "", "destroyLive", "()V", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "genMixActInstance", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "", "scheme", "", CriusAttrConstants.POSITION, "Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "getLiveItem", "(Ljava/lang/String;I)Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "init", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "release", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl$ClearInterfaceCallback;", "clearCallback", "Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl$ClearInterfaceCallback;", "context", "getContext", "Lcom/baidu/searchbox/live/video/LiveItemImpl;", "currentSelectedItem", "Lcom/baidu/searchbox/live/video/LiveItemImpl;", "getCurrentSelectedItem", "()Lcom/baidu/searchbox/live/video/LiveItemImpl;", "setCurrentSelectedItem", "(Lcom/baidu/searchbox/live/video/LiveItemImpl;)V", "Landroid/view/ViewGroup;", "fakeRootView", "Landroid/view/ViewGroup;", "firstRoomScheme", "Ljava/lang/String;", "Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "invokeAbility", "Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "Lcom/baidu/searchbox/live/util/LruLinkedHashMap;", "items", "Lcom/baidu/searchbox/live/util/LruLinkedHashMap;", "Lcom/baidu/searchbox/live/frame/IntentData;", "mIntentData", "Lcom/baidu/searchbox/live/frame/IntentData;", "mMixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lcom/baidu/searchbox/live/model/MixModel;", "mNetModel", "Lcom/baidu/searchbox/live/model/MixModel;", "getMNetModel", "()Lcom/baidu/searchbox/live/model/MixModel;", "setMNetModel", "(Lcom/baidu/searchbox/live/model/MixModel;)V", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "kotlin.jvm.PlatformType", "mUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "getPluginInvokeService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "schemeIntent$delegate", "Lkotlin/Lazy;", "getSchemeIntent", "()Landroid/content/Intent;", "schemeIntent", "liveToListInvokeAbility", "clearInterfaceCallback", "<init>", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl$ClearInterfaceCallback;)V", "Companion", "ClearInterfaceCallback", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LiveActInterfaceImpl implements ILiveActInterface {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveActInterfaceImpl.class), "schemeIntent", "getSchemeIntent()Landroid/content/Intent;"))};
    public static final Companion Companion = new Companion(null);
    public static final boolean isDebug;
    public final Activity activity;
    public ClearInterfaceCallback clearCallback;
    public final Activity context;
    public LiveItemImpl currentSelectedItem;
    public ViewGroup fakeRootView;
    public String firstRoomScheme;
    public ILiveToListInvokeAbility invokeAbility;
    public LruLinkedHashMap<String, LiveItemImpl> items;
    public IntentData mIntentData;
    public MixModel mNetModel;
    public final Lazy schemeIntent$delegate;
    public final PluginInvokeService pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
    public IMixActivityInterface mMixActivity = genMixActInstance();
    public final MiniUniqueId mUniqueId = MiniUniqueId.gen();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl$ClearInterfaceCallback;", "Lkotlin/Any;", "", "onClear", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface ClearInterfaceCallback {
        void onClear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent getSchemeIntent() {
        Lazy lazy = this.schemeIntent$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Intent) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl$Companion;", "", "message", "", LocalFilesFilterKt.FILTER_NAME_LOG, "(Ljava/lang/String;)V", "", "isDebug", "Z", "()Z", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public final boolean isDebug() {
            return LiveActInterfaceImpl.isDebug;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void log(String str) {
            if (isDebug()) {
                Log.d("LiveActInterfaceImpl", str);
            }
        }
    }

    static {
        boolean z = false;
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            z = appInfoService.isDebug();
        }
        isDebug = z;
    }

    public LiveActInterfaceImpl(Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility, ClearInterfaceCallback clearInterfaceCallback) {
        this.activity = activity;
        this.invokeAbility = iLiveToListInvokeAbility;
        this.clearCallback = clearInterfaceCallback;
        MiniUniqueId mUniqueId = this.mUniqueId;
        Intrinsics.checkExpressionValueIsNotNull(mUniqueId, "mUniqueId");
        this.mNetModel = new MixModel(mUniqueId);
        this.context = this.activity;
        this.schemeIntent$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Intent>() { // from class: com.baidu.searchbox.live.video.LiveActInterfaceImpl$schemeIntent$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Intent invoke() {
                return new Intent();
            }
        });
        this.items = new LruLinkedHashMap<>(2);
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveActInterface
    public void onActivityResult(int i, int i2, Intent intent) {
        Companion companion = Companion;
        companion.log("onActivityResult " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onActivityResult(this.activity, i, i2, intent);
        }
        LiveItemImpl liveItemImpl = this.currentSelectedItem;
        if (liveItemImpl != null) {
            liveItemImpl.onActivityResult(i, i2, intent);
        }
        Companion.log("onActivityResult end");
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveActInterface
    public void onConfigurationChanged(Configuration configuration) {
        Companion.log("onConfigurationChanged");
        if (configuration != null) {
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null) {
                iMixActivityInterface.onConfigurationChanged(this.activity, configuration);
            }
            LiveItemImpl liveItemImpl = this.currentSelectedItem;
            if (liveItemImpl != null) {
                liveItemImpl.onConfigurationChanged(configuration);
            }
        }
        Companion.log("onConfigurationChanged end");
    }

    public final void setCurrentSelectedItem(LiveItemImpl liveItemImpl) {
        this.currentSelectedItem = liveItemImpl;
    }

    public final void setMNetModel(MixModel mixModel) {
        this.mNetModel = mixModel;
    }

    private final IMixActivityInterface genMixActInstance() {
        IMixActivityInterface iMixActivityInterface;
        PluginInvokeService pluginInvokeService = this.pluginInvokeService;
        if (pluginInvokeService != null) {
            iMixActivityInterface = pluginInvokeService.genFakeActivityImpl();
        } else {
            iMixActivityInterface = null;
        }
        Companion companion = Companion;
        companion.log("genMixActInstance: " + iMixActivityInterface);
        return iMixActivityInterface;
    }

    public final void destroyLive() {
        ILiveToListInvokeAbility iLiveToListInvokeAbility = this.invokeAbility;
        if (iLiveToListInvokeAbility != null) {
            iLiveToListInvokeAbility.destroyLive();
        }
        this.invokeAbility = null;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Activity getContext() {
        return this.context;
    }

    public final LiveItemImpl getCurrentSelectedItem() {
        return this.currentSelectedItem;
    }

    public final MixModel getMNetModel() {
        return this.mNetModel;
    }

    public final PluginInvokeService getPluginInvokeService() {
        return this.pluginInvokeService;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.Object, java.lang.String] */
    @Override // com.baidu.searchbox.live.host2live.video.ILiveActInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ILiveItem getLiveItem(final String str, int i) {
        String str2;
        IMixActivityInterface iMixActivityInterface;
        Companion companion = Companion;
        companion.log("getLiveItem: mActivity " + this.mMixActivity);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str3 = "";
        objectRef.element = "";
        try {
            str2 = Uri.parse(str).getQueryParameter("params");
            if (str2 == null) {
                str2 = "";
            }
        } catch (Exception e) {
            e = e;
            str2 = "";
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                ?? optString = jSONObject.optString("roomId");
                Intrinsics.checkExpressionValueIsNotNull(optString, "paramsJsonObj.optString(\"roomId\")");
                objectRef.element = optString;
                String optString2 = jSONObject.optString("source");
                Intrinsics.checkExpressionValueIsNotNull(optString2, "paramsJsonObj.optString(\"source\")");
                str3 = optString2;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (!TextUtils.isEmpty((String) objectRef.element)) {
            }
        }
        if (!TextUtils.isEmpty((String) objectRef.element)) {
            return null;
        }
        if (TextUtils.isEmpty(this.firstRoomScheme)) {
            this.firstRoomScheme = str;
            Intent schemeIntent = getSchemeIntent();
            schemeIntent.putExtra("scheme", str);
            schemeIntent.putExtra("params", str2);
            schemeIntent.putExtra("source", str3);
            this.mIntentData = ListExtKt.parseLiveData(getSchemeIntent());
        }
        IMixActivityInterface iMixActivityInterface2 = this.mMixActivity;
        if (iMixActivityInterface2 != null) {
            iMixActivityInterface2.setMixEventDispatcher(MixConstants.KEY_PLUGIN_LOAD_SOURCE, str3);
        }
        if (this.items.get((String) objectRef.element) == null && (iMixActivityInterface = this.mMixActivity) != null) {
            Activity activity = this.context;
            MiniUniqueId mUniqueId = this.mUniqueId;
            Intrinsics.checkExpressionValueIsNotNull(mUniqueId, "mUniqueId");
            this.items.put((String) objectRef.element, new LiveItemImpl(activity, str, mUniqueId, iMixActivityInterface, new LiveItemImpl.ILiveItemStateChangCallback() { // from class: com.baidu.searchbox.live.video.LiveActInterfaceImpl$getLiveItem$$inlined$let$lambda$1
                @Override // com.baidu.searchbox.live.video.LiveItemImpl.ILiveItemStateChangCallback
                public void onSelectedStateChanged(boolean z, LiveItemImpl liveItemImpl) {
                    if (z) {
                        LiveActInterfaceImpl.this.setCurrentSelectedItem(liveItemImpl);
                    } else if (Intrinsics.areEqual(LiveActInterfaceImpl.this.getCurrentSelectedItem(), liveItemImpl)) {
                        LiveActInterfaceImpl.this.setCurrentSelectedItem(null);
                    }
                }
            }));
        }
        return this.items.get((String) objectRef.element);
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveActInterface
    public void init() {
        this.fakeRootView = new HorizonMotionEventCaptureView(this.activity);
        MixRequestServiceLocator.Companion.registerGlobalServices(ILivePageInfoInterface.class, new ILivePageInfoInterface() { // from class: com.baidu.searchbox.live.video.LiveActInterfaceImpl$init$1
            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public boolean isInsertVideo() {
                return true;
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public void finishActivity() {
                ILiveToListInvokeAbility iLiveToListInvokeAbility;
                ILiveToListInvokeAbility iLiveToListInvokeAbility2;
                LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
                StringBuilder sb = new StringBuilder();
                sb.append("init finishActivity ");
                iLiveToListInvokeAbility = LiveActInterfaceImpl.this.invokeAbility;
                sb.append(iLiveToListInvokeAbility);
                companion.log(sb.toString());
                iLiveToListInvokeAbility2 = LiveActInterfaceImpl.this.invokeAbility;
                if (iLiveToListInvokeAbility2 != null) {
                    iLiveToListInvokeAbility2.finishActivity();
                }
                LiveActInterfaceImpl.Companion.log("init finishActivity end");
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public View getLiveRootView() {
                ViewGroup viewGroup;
                viewGroup = LiveActInterfaceImpl.this.fakeRootView;
                return viewGroup;
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public Intent getSchemeIntent() {
                Intent schemeIntent;
                schemeIntent = LiveActInterfaceImpl.this.getSchemeIntent();
                return schemeIntent;
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public IntentData getSchemeIntentData() {
                IntentData intentData;
                intentData = LiveActInterfaceImpl.this.mIntentData;
                return intentData;
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public void scrollToNext() {
                ILiveToListInvokeAbility iLiveToListInvokeAbility;
                ILiveToListInvokeAbility iLiveToListInvokeAbility2;
                LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
                StringBuilder sb = new StringBuilder();
                sb.append("init scrollToNext ");
                iLiveToListInvokeAbility = LiveActInterfaceImpl.this.invokeAbility;
                sb.append(iLiveToListInvokeAbility);
                companion.log(sb.toString());
                iLiveToListInvokeAbility2 = LiveActInterfaceImpl.this.invokeAbility;
                if (iLiveToListInvokeAbility2 != null) {
                    iLiveToListInvokeAbility2.scrollToNext();
                }
                LiveActInterfaceImpl.Companion.log("init scrollToNext end");
            }
        });
        Companion.log("init");
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.attachBaseContext(this.context);
        }
        Companion.log("init attachBaseContext end");
        IMixActivityInterface iMixActivityInterface2 = this.mMixActivity;
        if (iMixActivityInterface2 != null) {
            iMixActivityInterface2.beforeCreate(this.context, null);
        }
        Companion.log("init beforeCreate end");
        ImmersionUtils.setupNavBarStyleImmersiveStickyWithLightStatusBar(this.activity);
        LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
        if (liveSessionService != null) {
            liveSessionService.generateSessionId();
        }
        ServiceLocator.Companion.registerGlobalServices(ILiveListState.class, new ILiveListState() { // from class: com.baidu.searchbox.live.video.LiveActInterfaceImpl$init$3
            @Override // com.baidu.searchbox.live.service.ILiveListState
            public ListInfo getListInfo() {
                return null;
            }

            @Override // com.baidu.searchbox.live.service.ILiveListState
            public PageInfo getPageInfo() {
                return null;
            }

            @Override // com.baidu.searchbox.live.service.ILiveListState
            public IntentData getIntent() {
                IntentData intentData;
                intentData = LiveActInterfaceImpl.this.mIntentData;
                return intentData;
            }
        });
        IMixActivityInterface iMixActivityInterface3 = this.mMixActivity;
        if (iMixActivityInterface3 != null) {
            iMixActivityInterface3.onCreate(this.context, null);
        }
        Companion.log("init onCreate end");
        MixRequestServiceLocator.Companion.registerGlobalServices(MixRequestService.class, new MixRequestService() { // from class: com.baidu.searchbox.live.video.LiveActInterfaceImpl$init$4
            @Override // com.baidu.searchbox.live.service.MixRequestService
            public void requestRoomEnter(RoomEnterParams roomEnterParams, boolean z, OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
                LiveActInterfaceImpl.Companion.log("init requestRoomEnter");
                MixModel mNetModel = LiveActInterfaceImpl.this.getMNetModel();
                if (mNetModel != null) {
                    mNetModel.reqRoomEnter(roomEnterParams, onMixDataLoaded);
                }
                LiveActInterfaceImpl.Companion.log("init requestRoomEnter end");
            }
        });
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveActInterface
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Boolean bool;
        Companion.log("onKeyDown: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + keyEvent);
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        Boolean bool2 = null;
        if (iMixActivityInterface != null) {
            bool = Boolean.valueOf(iMixActivityInterface.onKeyDown(this.activity, i, keyEvent));
        } else {
            bool = null;
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            LiveItemImpl liveItemImpl = this.currentSelectedItem;
            if (liveItemImpl != null) {
                bool2 = Boolean.valueOf(liveItemImpl.onKeyDown(i, keyEvent));
            }
            bool = bool2;
        }
        Companion.log("onKeyDown: end, " + bool);
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveActInterface
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Companion companion = Companion;
        companion.log("onRequestPermissionsResult " + i);
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onRequestPermissionsResult(this.activity, i, strArr, iArr);
        }
        LiveItemImpl liveItemImpl = this.currentSelectedItem;
        if (liveItemImpl != null) {
            liveItemImpl.onRequestPermissionsResult(i, strArr, iArr);
        }
        Companion.log("onRequestPermissionsResult end");
    }

    @Override // com.baidu.searchbox.live.host2live.video.ILiveActInterface
    public void release() {
        ViewParent parent;
        ClearInterfaceCallback clearInterfaceCallback = this.clearCallback;
        if (clearInterfaceCallback != null) {
            clearInterfaceCallback.onClear();
        }
        this.firstRoomScheme = null;
        getSchemeIntent().removeExtra("scheme");
        getSchemeIntent().removeExtra("params");
        getSchemeIntent().removeExtra("source");
        this.items.clear();
        this.currentSelectedItem = null;
        ViewGroup viewGroup = this.fakeRootView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup2 = this.fakeRootView;
        if (viewGroup2 != null && (parent = viewGroup2.getParent()) != null) {
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup3 = (ViewGroup) parent;
            if (viewGroup3 != null) {
                viewGroup3.removeView(this.fakeRootView);
            }
        }
        this.fakeRootView = null;
        Companion.log("release");
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.dispatchFinishLifecycle();
        }
        Companion.log("release - finish end");
        IMixActivityInterface iMixActivityInterface2 = this.mMixActivity;
        if (iMixActivityInterface2 != null) {
            iMixActivityInterface2.onDestroy(this.activity);
        }
        Companion.log("release - onDestroy end");
        MixModel mixModel = this.mNetModel;
        if (mixModel != null) {
            mixModel.removeReqEnterIdCallbacks(null);
        }
        this.mNetModel = null;
        MixRequestServiceLocator.Companion.unregisterGlobalService(MixRequestService.class);
        MixRequestServiceLocator.Companion.unregisterGlobalService(ILivePageInfoInterface.class);
        ServiceLocator.Companion.unregisterGlobalService(ILiveListState.class);
        LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
        if (liveSessionService != null) {
            liveSessionService.resetSession();
        }
    }
}
