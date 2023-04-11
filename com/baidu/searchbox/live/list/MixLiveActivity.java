package com.baidu.searchbox.live.list;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.utils.LiveActivityHelper;
import com.baidu.live.arch.utils.MiniScreenOrientationCompat;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.gesture.HorizonMotionEventCaptureView;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService;
import com.baidu.searchbox.live.interfaces.service.EventDispatcherService;
import com.baidu.searchbox.live.interfaces.service.LiveSessionService;
import com.baidu.searchbox.live.list.controller.ListController;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILivePageInfoInterface;
import com.baidu.searchbox.live.service.MixListOperatorInterface;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.shell.LiveBaseActivity;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ImmersionUtils;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.util.LiveActivityUtil;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b`\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u0012J)\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0014¢\u0006\u0004\b(\u0010\bJ!\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001cH\u0014¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0004H\u0014¢\u0006\u0004\b2\u0010\bJ/\u00108\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00102\u000e\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u000204032\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0004H\u0014¢\u0006\u0004\b:\u0010\bJ\u000f\u0010;\u001a\u00020\u0004H\u0014¢\u0006\u0004\b;\u0010\bJ\u000f\u0010<\u001a\u00020\u0004H\u0014¢\u0006\u0004\b<\u0010\bJ\u000f\u0010=\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010\bJ\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020,H\u0002¢\u0006\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00108\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR!\u0010O\u001a\n N*\u0004\u0018\u00010M0M8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR%\u0010X\u001a\n N*\u0004\u0018\u00010S0S8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006a"}, d2 = {"Lcom/baidu/searchbox/live/list/MixLiveActivity;", "Lcom/baidu/searchbox/live/shell/LiveBaseActivity;", "Landroid/content/Context;", "newBase", "", "attachBaseContext", "(Landroid/content/Context;)V", "finish", "()V", "finishAndDispatchLifecycle", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "genMixActInstance", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Landroid/content/res/AssetManager;", "getAssets", "()Landroid/content/res/AssetManager;", "", "getCaptureBgColor", "()I", "Ljava/lang/ClassLoader;", "getClassLoader", "()Ljava/lang/ClassLoader;", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "isAnimation", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "overrideEnterAnim", "dispatchLifecycle", "realFinish", "(Z)V", "isInnerJump", "Z", "Lcom/baidu/searchbox/live/list/controller/ListController;", "mListController", "Lcom/baidu/searchbox/live/list/controller/ListController;", "mMixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "matchParent", "I", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "getPluginInvokeService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "preStartPlayerService$delegate", "Lkotlin/Lazy;", "getPreStartPlayerService", "()Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "preStartPlayerService", "Landroid/view/View;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class MixLiveActivity extends LiveBaseActivity {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixLiveActivity.class), "preStartPlayerService", "getPreStartPlayerService()Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;"))};
    public HashMap _$_findViewCache;
    public boolean isInnerJump;
    public ListController mListController;
    public IMixActivityInterface mMixActivity;
    public final int matchParent;
    public final MiniUniqueId mixUniqueId;
    public final PluginInvokeService pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
    public final Lazy preStartPlayerService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LivePreStartPlayerService>() { // from class: com.baidu.searchbox.live.list.MixLiveActivity$preStartPlayerService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LivePreStartPlayerService invoke() {
            return (LivePreStartPlayerService) ServiceManager.getService(LivePreStartPlayerService.Companion.getSERVICE_REFERENCE());
        }
    });
    public View rootView;

    private final LivePreStartPlayerService getPreStartPlayerService() {
        Lazy lazy = this.preStartPlayerService$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (LivePreStartPlayerService) lazy.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    public int getCaptureBgColor() {
        return -16777216;
    }

    public MixLiveActivity() {
        MiniUniqueId gen = MiniUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "MiniUniqueId.gen()");
        this.mixUniqueId = gen;
        this.matchParent = -1;
        this.mMixActivity = genMixActInstance();
    }

    private final IMixActivityInterface genMixActInstance() {
        PluginInvokeService pluginInvokeService = this.pluginInvokeService;
        if (pluginInvokeService != null) {
            return pluginInvokeService.genFakeActivityImpl();
        }
        return null;
    }

    private final int isAnimation() {
        String str;
        try {
            Intent intent = getIntent();
            if (intent == null || (str = intent.getStringExtra("params")) == null) {
                str = "";
            }
            return new JSONObject(str).optInt("noAnimation", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        realFinish(getIntent().getBooleanExtra("finish_dispatch_lifecycle", false));
    }

    public final PluginInvokeService getPluginInvokeService() {
        return this.pluginInvokeService;
    }

    public final View getRootView() {
        return this.rootView;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ListController listController = this.mListController;
        if (listController != null) {
            listController.onDestroy();
        }
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onDestroy(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onPause(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onResume start");
        try {
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onResume(this);
        }
        ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onResume end");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onStart start");
        super.onStart();
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onStart(this);
        }
        ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onStart end");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onStop(this);
        }
    }

    public void overrideEnterAnim() {
        if (isAnimation() == 0) {
            overridePendingTransition(R.anim.liveshow_slide_in_right, R.anim.liveshow_slide_no_anim);
        }
    }

    @Override // com.baidu.searchbox.live.shell.LiveBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.attachBaseContext(context);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Resources resources = getResources();
        resources.updateConfiguration(new Configuration(configuration), resources.getDisplayMetrics());
        super.onConfigurationChanged(configuration);
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onConfigurationChanged(this, configuration);
        }
        ListController listController = this.mListController;
        if (listController != null) {
            listController.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ListController listController = this.mListController;
        if (listController != null) {
            listController.onNewIntent(intent);
        }
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onNewIntent(this, intent);
        }
    }

    public final void setRootView(View view2) {
        this.rootView = view2;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListController listController;
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null && iMixActivityInterface.onKeyDown(this, i, keyEvent)) {
            return true;
        }
        if (keyEvent != null && (listController = this.mListController) != null && listController.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private final void realFinish(boolean z) {
        IMixActivityInterface iMixActivityInterface;
        EventDispatcherService eventDispatcherService;
        EventDispatcherService eventDispatcherService2;
        super.finish();
        if (LiveActivityHelper.isOnlyOneLiveActivity() && !this.isInnerJump && (eventDispatcherService2 = (EventDispatcherService) ServiceManager.getService(EventDispatcherService.Companion.getSERVICE_REFERENCE())) != null) {
            eventDispatcherService2.onEvent("onClose", null);
        }
        if (!this.isInnerJump && (eventDispatcherService = (EventDispatcherService) ServiceManager.getService(EventDispatcherService.Companion.getSERVICE_REFERENCE())) != null) {
            eventDispatcherService.onEvent("onActivityClose", null);
        }
        int i = 0;
        this.isInnerJump = false;
        overridePendingTransition(R.anim.liveshow_slide_no_anim, R.anim.liveshow_slide_out_left);
        ListController listController = this.mListController;
        if (listController != null) {
            listController.finish();
        }
        IMixActivityInterface iMixActivityInterface2 = this.mMixActivity;
        if (iMixActivityInterface2 != null) {
            iMixActivityInterface2.finish(this);
        }
        if (z) {
            PluginInvokeService pluginInvokeService = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
            if (pluginInvokeService != null) {
                i = pluginInvokeService.getPluginVersionCode("com.baidu.searchbox.livenps");
            }
            if (i >= 670000000 && (iMixActivityInterface = this.mMixActivity) != null) {
                iMixActivityInterface.dispatchFinishLifecycle();
            }
        }
        MixRequestServiceLocator.Companion.unregisterGlobalService(ILivePageInfoInterface.class);
        LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
        if (liveSessionService != null) {
            liveSessionService.resetSession();
        }
        super.finish();
    }

    public final void finishAndDispatchLifecycle() {
        IMixActivityInterface iMixActivityInterface;
        int i;
        int i2 = 0;
        boolean z = false;
        if (!isFinishing() && !isDestroyed()) {
            PluginInvokeService pluginInvokeService = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
            if (pluginInvokeService != null) {
                i = pluginInvokeService.getPluginVersionCode("com.baidu.searchbox.livenps");
            } else {
                i = 0;
            }
            if (i >= 670000000) {
                z = true;
            }
            realFinish(z);
            return;
        }
        PluginInvokeService pluginInvokeService2 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
        if (pluginInvokeService2 != null) {
            i2 = pluginInvokeService2.getPluginVersionCode("com.baidu.searchbox.livenps");
        }
        if (i2 >= 670000000 && (iMixActivityInterface = this.mMixActivity) != null) {
            iMixActivityInterface.dispatchFinishLifecycle();
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        AssetManager pluginAssets;
        AssetManager pluginAssets2;
        try {
            PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
            if (pluginMgrService == null || (pluginAssets2 = pluginMgrService.getPluginAssets("com.baidu.searchbox.livenps")) == null) {
                PluginInvokeService pluginMgrService2 = MiniPluginManager.INSTANCE.getPluginMgrService();
                if (pluginMgrService2 == null || (pluginAssets = pluginMgrService2.getPluginAssets("com.baidu.searchbox.yylive.entrance")) == null) {
                    AssetManager assets = super.getAssets();
                    Intrinsics.checkExpressionValueIsNotNull(assets, "super.getAssets()");
                    return assets;
                }
                return pluginAssets;
            }
            return pluginAssets2;
        } catch (Exception e) {
            AssetManager assets2 = super.getAssets();
            Intrinsics.checkExpressionValueIsNotNull(assets2, "super.getAssets()");
            e.printStackTrace();
            return assets2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        ClassLoader pluginClassLoader;
        ClassLoader pluginClassLoader2;
        try {
            PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
            if (pluginMgrService == null || (pluginClassLoader2 = pluginMgrService.getPluginClassLoader("com.baidu.searchbox.livenps")) == null) {
                PluginInvokeService pluginMgrService2 = MiniPluginManager.INSTANCE.getPluginMgrService();
                if (pluginMgrService2 == null || (pluginClassLoader = pluginMgrService2.getPluginClassLoader("com.baidu.searchbox.yylive.entrance")) == null) {
                    ClassLoader classLoader = super.getClassLoader();
                    Intrinsics.checkExpressionValueIsNotNull(classLoader, "super.getClassLoader()");
                    return classLoader;
                }
                return pluginClassLoader;
            }
            return pluginClassLoader2;
        } catch (Exception e) {
            ClassLoader classLoader2 = super.getClassLoader();
            Intrinsics.checkExpressionValueIsNotNull(classLoader2, "super.getClassLoader()");
            e.printStackTrace();
            return classLoader2;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources pluginResource;
        Resources pluginResource2;
        try {
            PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
            if (pluginMgrService == null || (pluginResource2 = pluginMgrService.getPluginResource("com.baidu.searchbox.livenps")) == null) {
                PluginInvokeService pluginMgrService2 = MiniPluginManager.INSTANCE.getPluginMgrService();
                if (pluginMgrService2 == null || (pluginResource = pluginMgrService2.getPluginResource("com.baidu.searchbox.yylive.entrance")) == null) {
                    Resources resources = super.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources, "super.getResources()");
                    return resources;
                }
                return pluginResource;
            }
            return pluginResource2;
        } catch (Exception e) {
            Resources resources2 = super.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources2, "super.getResources()");
            e.printStackTrace();
            return resources2;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onActivityResult(this, i, i2, intent);
        }
        ListController listController = this.mListController;
        if (listController != null) {
            listController.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        IMixActivityInterface iMixActivityInterface = this.mMixActivity;
        if (iMixActivityInterface != null) {
            iMixActivityInterface.onRequestPermissionsResult(this, i, strArr, iArr);
        }
        ListController listController = this.mListController;
        if (listController != null) {
            listController.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.searchbox.live.shell.LiveBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        View createView;
        IMixActivityInterface iMixActivityInterface;
        ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onCreate start");
        if (this.mMixActivity == null) {
            super.onCreate(null);
            LivePreStartPlayerService preStartPlayerService = getPreStartPlayerService();
            if (preStartPlayerService != null) {
                preStartPlayerService.releasePreStartPlayer();
            }
            finish();
            return;
        }
        MixRequestServiceLocator.Companion.registerGlobalServices(ILivePageInfoInterface.class, new ILivePageInfoInterface() { // from class: com.baidu.searchbox.live.list.MixLiveActivity$onCreate$1
            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public boolean isInsertVideo() {
                return false;
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public void finishActivity() {
                MixLiveActivity.this.finish();
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public View getLiveRootView() {
                return MixLiveActivity.this.getRootView();
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public Intent getSchemeIntent() {
                return MixLiveActivity.this.getIntent();
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public IntentData getSchemeIntentData() {
                ListController listController;
                listController = MixLiveActivity.this.mListController;
                if (listController != null) {
                    return listController.getMIntentData();
                }
                return null;
            }

            @Override // com.baidu.searchbox.live.service.ILivePageInfoInterface
            public void scrollToNext() {
                MixListOperatorInterface mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class);
                if (mixListOperatorInterface != null) {
                    mixListOperatorInterface.scrollToNextLiveRoom();
                }
            }
        });
        IMixActivityInterface iMixActivityInterface2 = this.mMixActivity;
        if (iMixActivityInterface2 != null) {
            iMixActivityInterface2.beforeCreate(this, bundle);
        }
        ImmersionUtils.setupNavBarStyleImmersiveStickyWithLightStatusBar(this);
        int releaseFixedOrientation = MiniScreenOrientationCompat.releaseFixedOrientation(this);
        super.onCreate(null);
        MiniScreenOrientationCompat.fixedOrientation(this, releaseFixedOrientation);
        LiveActivityUtil.fixTarget26Crash(this);
        overrideEnterAnim();
        if (bundle != null) {
            finish();
        }
        getWindow().setFormat(-3);
        String stringExtra = getIntent().getStringExtra("source");
        if (stringExtra != null && (iMixActivityInterface = this.mMixActivity) != null) {
            iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_PLUGIN_LOAD_SOURCE, stringExtra);
        }
        LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
        if (liveSessionService != null) {
            liveSessionService.generateSessionId();
        }
        IMixActivityInterface iMixActivityInterface3 = this.mMixActivity;
        if (iMixActivityInterface3 != null) {
            this.mListController = new ListController(this, this.mixUniqueId, iMixActivityInterface3);
        }
        HorizonMotionEventCaptureView horizonMotionEventCaptureView = new HorizonMotionEventCaptureView(this);
        int i = this.matchParent;
        horizonMotionEventCaptureView.setLayoutParams(new ViewGroup.LayoutParams(i, i));
        horizonMotionEventCaptureView.setBackgroundColor(getCaptureBgColor());
        this.rootView = horizonMotionEventCaptureView;
        setContentView(horizonMotionEventCaptureView);
        ListController listController = this.mListController;
        if (listController != null && (createView = listController.createView()) != null) {
            if (createView.getParent() != null) {
                ViewParent parent = createView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(createView);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            View view2 = this.rootView;
            if (view2 != null) {
                ((ViewGroup) view2).addView(createView);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        IMixActivityInterface iMixActivityInterface4 = this.mMixActivity;
        if (iMixActivityInterface4 != null) {
            iMixActivityInterface4.onCreate(this, bundle);
        }
        MediaLivePluginLogger.Companion.getInstance().logPageOnCreateEnd();
        ListController listController2 = this.mListController;
        if (listController2 != null) {
            listController2.onCreate();
        }
        ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onCreate end");
    }
}
