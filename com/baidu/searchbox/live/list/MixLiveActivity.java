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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.searchbox.live.shell.LiveBaseActivity;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ImmersionUtils;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.util.LiveActivityUtil;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\\\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J)\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0014¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0014¢\u0006\u0004\b'\u0010\bJ!\u0010,\u001a\u00020+2\u0006\u0010(\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001bH\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0014¢\u0006\u0004\b1\u0010\bJ/\u00107\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000f2\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u000203022\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0004H\u0014¢\u0006\u0004\b9\u0010\bJ\u000f\u0010:\u001a\u00020\u0004H\u0014¢\u0006\u0004\b:\u0010\bJ\u000f\u0010;\u001a\u00020\u0004H\u0014¢\u0006\u0004\b;\u0010\bJ\u000f\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\bR\u0016\u0010=\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR!\u0010K\u001a\n J*\u0004\u0018\u00010I0I8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR%\u0010T\u001a\n J*\u0004\u0018\u00010O0O8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006]"}, d2 = {"Lcom/baidu/searchbox/live/list/MixLiveActivity;", "Lcom/baidu/searchbox/live/shell/LiveBaseActivity;", "Landroid/content/Context;", "newBase", "", "attachBaseContext", "(Landroid/content/Context;)V", "finish", "()V", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "genMixActInstance", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Landroid/content/res/AssetManager;", "getAssets", "()Landroid/content/res/AssetManager;", "", "getCaptureBgColor", "()I", "Ljava/lang/ClassLoader;", "getClassLoader", "()Ljava/lang/ClassLoader;", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "isAnimation", GroupInfoActivityConfig.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "overrideEnterAnim", "isInnerJump", "Z", "Lcom/baidu/searchbox/live/list/controller/ListController;", "mListController", "Lcom/baidu/searchbox/live/list/controller/ListController;", "mMixActivity", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "matchParent", "I", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "getPluginInvokeService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "preStartPlayerService$delegate", "Lkotlin/Lazy;", "getPreStartPlayerService", "()Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "preStartPlayerService", "Landroid/view/View;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class MixLiveActivity extends LiveBaseActivity {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap _$_findViewCache;
    public boolean isInnerJump;
    public ListController mListController;
    public IMixActivityInterface mMixActivity;
    public final int matchParent;
    public final MiniUniqueId mixUniqueId;
    public final PluginInvokeService pluginInvokeService;
    public final Lazy preStartPlayerService$delegate;
    public View rootView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1307281012, "Lcom/baidu/searchbox/live/list/MixLiveActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1307281012, "Lcom/baidu/searchbox/live/list/MixLiveActivity;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MixLiveActivity.class), "preStartPlayerService", "getPreStartPlayerService()Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;"))};
    }

    private final LivePreStartPlayerService getPreStartPlayerService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Lazy lazy = this.preStartPlayerService$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (LivePreStartPlayerService) lazy.getValue();
        }
        return (LivePreStartPlayerService) invokeV.objValue;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this._$_findViewCache) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
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
        return (View) invokeI.objValue;
    }

    public int getCaptureBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return -16777216;
        }
        return invokeV.intValue;
    }

    public MixLiveActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        this.preStartPlayerService$delegate = LazyKt__LazyJVMKt.lazy(MixLiveActivity$preStartPlayerService$2.INSTANCE);
        MiniUniqueId gen = MiniUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "MiniUniqueId.gen()");
        this.mixUniqueId = gen;
        this.matchParent = -1;
        this.mMixActivity = genMixActInstance();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        AssetManager pluginAssets;
        AssetManager pluginAssets2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        ClassLoader pluginClassLoader;
        ClassLoader pluginClassLoader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        return (ClassLoader) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Resources pluginResource;
        Resources pluginResource2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (Resources) invokeV.objValue;
    }

    private final IMixActivityInterface genMixActInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            PluginInvokeService pluginInvokeService = this.pluginInvokeService;
            if (pluginInvokeService != null) {
                return pluginInvokeService.genFakeActivityImpl();
            }
            return null;
        }
        return (IMixActivityInterface) invokeV.objValue;
    }

    private final int isAnimation() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
        return invokeV.intValue;
    }

    public final PluginInvokeService getPluginInvokeService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.pluginInvokeService;
        }
        return (PluginInvokeService) invokeV.objValue;
    }

    public final View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.rootView;
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null) {
                iMixActivityInterface.onPause(this);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onResume start");
            super.onResume();
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null) {
                iMixActivityInterface.onResume(this);
            }
            ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onResume end");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onStart start");
            super.onStart();
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null) {
                iMixActivityInterface.onStart(this);
            }
            ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onStart end");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStop();
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null) {
                iMixActivityInterface.onStop(this);
            }
        }
    }

    public void overrideEnterAnim() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && isAnimation() == 0) {
            overridePendingTransition(R.anim.liveshow_slide_in_right, R.anim.liveshow_slide_no_anim);
        }
    }

    @Override // com.baidu.searchbox.live.shell.LiveBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            super.attachBaseContext(context);
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null) {
                iMixActivityInterface.attachBaseContext(context);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
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
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
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
    }

    public final void setRootView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            this.rootView = view2;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        EventDispatcherService eventDispatcherService;
        EventDispatcherService eventDispatcherService2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.finish();
            if (LiveActivityHelper.isOnlyOneLiveActivity() && !this.isInnerJump && (eventDispatcherService2 = (EventDispatcherService) ServiceManager.getService(EventDispatcherService.Companion.getSERVICE_REFERENCE())) != null) {
                eventDispatcherService2.onEvent("onClose", null);
            }
            if (!this.isInnerJump && (eventDispatcherService = (EventDispatcherService) ServiceManager.getService(EventDispatcherService.Companion.getSERVICE_REFERENCE())) != null) {
                eventDispatcherService.onEvent("onActivityClose", null);
            }
            this.isInnerJump = false;
            overridePendingTransition(R.anim.liveshow_slide_no_anim, R.anim.liveshow_slide_out_left);
            ListController listController = this.mListController;
            if (listController != null) {
                listController.finish();
            }
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null) {
                iMixActivityInterface.finish(this);
            }
            LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
            if (liveSessionService != null) {
                liveSessionService.resetSession();
            }
            super.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, intent) == null) {
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
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048593, this, i, strArr, iArr) == null) {
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
    }

    @Override // com.baidu.searchbox.live.shell.LiveBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        View createView;
        IMixActivityInterface iMixActivityInterface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onCreate start");
            IMixActivityInterface iMixActivityInterface2 = this.mMixActivity;
            if (iMixActivityInterface2 == null) {
                super.onCreate(null);
                LivePreStartPlayerService preStartPlayerService = getPreStartPlayerService();
                if (preStartPlayerService != null) {
                    preStartPlayerService.releasePreStartPlayer();
                }
                finish();
                return;
            }
            if (iMixActivityInterface2 != null) {
                iMixActivityInterface2.beforeCreate(this, bundle);
            }
            ImmersionUtils.setupNavBarStyleImmersiveStickyWithLightStatusBar(this);
            LiveActivityUtil.fixTiebaWindowSoftInputMode(this);
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
            LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
            if (liveSessionService != null) {
                liveSessionService.generateSessionId();
            }
            ListLogKt.log(MixTagConstants.MIX_REAL_ACT, "onCreate end");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        ListController listController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, keyEvent)) == null) {
            IMixActivityInterface iMixActivityInterface = this.mMixActivity;
            if (iMixActivityInterface != null && iMixActivityInterface.onKeyDown(this, i, keyEvent)) {
                return true;
            }
            if (keyEvent != null && (listController = this.mListController) != null && listController.onKeyDown(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
