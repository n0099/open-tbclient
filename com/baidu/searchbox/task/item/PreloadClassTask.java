package com.baidu.searchbox.task.item;

import android.os.Build;
import android.os.Trace;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
/* loaded from: classes7.dex */
public class PreloadClassTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PreloadClassTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean canPreloadClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Runtime runtime = Runtime.getRuntime();
            int availableProcessors = runtime != null ? runtime.availableProcessors() : 0;
            if (LaunchTask.DEBUG) {
                String str = "preLoadClassAsync core count: " + availableProcessors + ", sdk int: " + Build.VERSION.SDK_INT;
            }
            if (availableProcessors < 2 || availableProcessors == 3 || availableProcessors == 5 || availableProcessors == 6) {
                return false;
            }
            boolean z = LaunchTask.DEBUG;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    private void forName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            try {
                Class.forName(str);
            } catch (ClassNotFoundException e2) {
                String str2 = "preLoadClass exception " + e2.toString();
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && canPreloadClass()) {
            if (LaunchTask.DEBUG && DeviceUtil.OSInfo.hasJellyBeanMR2()) {
                Trace.beginSection("preLoadClass");
            }
            try {
                Class.forName("com.baidu.searchbox.MainActivity");
            } catch (ClassNotFoundException e2) {
                String str = "preLoadClass exception " + e2.toString();
                e2.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.bdeventbus.BdEventBus");
            } catch (ClassNotFoundException e3) {
                String str2 = "preLoadClass exception " + e3.toString();
                e3.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.controller.FeedDataManager");
            } catch (ClassNotFoundException e4) {
                String str3 = "preLoadClass exception " + e4.toString();
                e4.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.introduction.model.IntroductionDisplayManager");
            } catch (ClassNotFoundException e5) {
                String str4 = "preLoadClass exception " + e5.toString();
                e5.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.tab.FeedTabContainer");
            } catch (ClassNotFoundException e6) {
                String str5 = "preLoadClass exception " + e6.toString();
                e6.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.home.HomeDrawerContainer");
            } catch (ClassNotFoundException e7) {
                String str6 = "preLoadClass exception " + e7.toString();
                e7.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.home.tabs.HomeFragmentTabHost");
            } catch (ClassNotFoundException e8) {
                String str7 = "preLoadClass exception " + e8.toString();
                e8.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.util.Utility");
            } catch (ClassNotFoundException e9) {
                String str8 = "preLoadClass exception " + e9.toString();
                e9.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.tab.SlidingTabLayout");
            } catch (ClassNotFoundException e10) {
                String str9 = "preLoadClass exception " + e10.toString();
                e10.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.home.tabs.view.BottomNavigationItemView");
            } catch (ClassNotFoundException e11) {
                String str10 = "preLoadClass exception " + e11.toString();
                e11.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.ui.ShimmerFrameLayout");
            } catch (ClassNotFoundException e12) {
                String str11 = "preLoadClass exception " + e12.toString();
                e12.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.home.feed.widget.HomeScrollView");
            } catch (ClassNotFoundException e13) {
                String str12 = "preLoadClass exception " + e13.toString();
                e13.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.tab.view.MainFeedPageView");
            } catch (ClassNotFoundException e14) {
                String str13 = "preLoadClass exception " + e14.toString();
                e14.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.tab.fragment.MainFeedFragment");
            } catch (ClassNotFoundException e15) {
                String str14 = "preLoadClass exception " + e15.toString();
                e15.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.template.FeedLabelView");
            } catch (ClassNotFoundException e16) {
                String str15 = "preLoadClass exception " + e16.toString();
                e16.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.template.mutevideo.ad.AdVerticalMuteVideoView");
            } catch (ClassNotFoundException e17) {
                String str16 = "preLoadClass exception " + e17.toString();
                e17.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.home.HomeHeaderLayout");
            } catch (ClassNotFoundException e18) {
                String str17 = "preLoadClass exception " + e18.toString();
                e18.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.tab.FeedNavigationAdapter");
            } catch (ClassNotFoundException e19) {
                String str18 = "preLoadClass exception " + e19.toString();
                e19.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.ui.view.BadgeView");
            } catch (ClassNotFoundException e20) {
                String str19 = "preLoadClass exception " + e20.toString();
                e20.printStackTrace();
            }
            try {
                Class.forName("com.baidu.browser.tablayout.TabLayout");
            } catch (ClassNotFoundException e21) {
                String str20 = "preLoadClass exception " + e21.toString();
                e21.printStackTrace();
            }
            try {
                Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (ClassNotFoundException e22) {
                String str21 = "preLoadClass exception " + e22.toString();
                e22.printStackTrace();
            }
            try {
                Class.forName("androidx.recyclerview.widget.LinearLayoutManager");
            } catch (ClassNotFoundException e23) {
                String str22 = "preLoadClass exception " + e23.toString();
                e23.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.feed.template.FeedTemplateImpl");
            } catch (ClassNotFoundException e24) {
                String str23 = "preLoadClass exception " + e24.toString();
                e24.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.home.feed.widget.HomeView");
            } catch (ClassNotFoundException e25) {
                String str24 = "preLoadClass exception " + e25.toString();
                e25.printStackTrace();
            }
            try {
                Class.forName("com.baidu.searchbox.ui.SearchBoxView");
            } catch (ClassNotFoundException e26) {
                String str25 = "preLoadClass exception " + e26.toString();
                e26.printStackTrace();
            }
            try {
                Class.forName("com.baidu.sapi2.utils.SapiUtils");
            } catch (ClassNotFoundException e27) {
                String str26 = "preLoadClass exception " + e27.toString();
                e27.printStackTrace();
            }
            try {
                Class.forName("com.baidu.webkit.sdk.WebView");
            } catch (ClassNotFoundException e28) {
                String str27 = "preLoadClass exception " + e28.toString();
                e28.printStackTrace();
            }
            if (Fresco.hasBeenInitialized()) {
                ImagePipelineFactory.getInstance().getImagePipeline();
            }
            if (LaunchTask.DEBUG && DeviceUtil.OSInfo.hasJellyBeanMR2()) {
                Trace.endSection();
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "preloadClass" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}
