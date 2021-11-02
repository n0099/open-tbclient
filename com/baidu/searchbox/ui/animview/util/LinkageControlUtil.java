package com.baidu.searchbox.ui.animview.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class LinkageControlUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "LinkageControlUtil";
    public static WeakReference<Object> sBindObj;
    public static WeakReference<ILinkageOpr> sLinkageOpr;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface ILinkageOpr {
        void disableLinkageScroll();

        void enableLinkageScroll();

        boolean isLinakgeControlling();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-382002228, "Lcom/baidu/searchbox/ui/animview/util/LinkageControlUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-382002228, "Lcom/baidu/searchbox/ui/animview/util/LinkageControlUtil;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
    }

    public LinkageControlUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isPraiseOptimized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (ComboPraiseRuntime.getContext() == null) {
                boolean z = DEBUG;
                return false;
            }
            boolean isPraiseOptimized = ComboPraiseRuntime.getContext().isPraiseOptimized();
            if (DEBUG) {
                String str = "isPraiseOptimized ab switch is " + isPraiseOptimized;
            }
            return isPraiseOptimized;
        }
        return invokeV.booleanValue;
    }

    public static void notifyDisableLinkageScroll() {
        WeakReference<ILinkageOpr> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && (weakReference = sLinkageOpr) != null && weakReference.get() != null && isPraiseOptimized() && sLinkageOpr.get().isLinakgeControlling()) {
            sLinkageOpr.get().disableLinkageScroll();
        }
    }

    public static void notifyEnableLinkageScroll() {
        WeakReference<ILinkageOpr> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (weakReference = sLinkageOpr) == null || weakReference.get() == null) {
            return;
        }
        sLinkageOpr.get().enableLinkageScroll();
    }

    public static void start(Object obj, ILinkageOpr iLinkageOpr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, iLinkageOpr) == null) || iLinkageOpr == null || obj == null) {
            return;
        }
        sBindObj = new WeakReference<>(obj);
        sLinkageOpr = new WeakReference<>(iLinkageOpr);
        BdEventBus.Companion.getDefault().lazyRegister(obj, CoolPraiseView.PraiseAnimState.class, 1, new Action<CoolPraiseView.PraiseAnimState>() { // from class: com.baidu.searchbox.ui.animview.util.LinkageControlUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(CoolPraiseView.PraiseAnimState praiseAnimState) {
                int animState;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, praiseAnimState) == null) || praiseAnimState == null || (animState = praiseAnimState.getAnimState()) == 1 || animState == 3) {
                    return;
                }
                LinkageControlUtil.notifyEnableLinkageScroll();
            }
        });
    }

    public static void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            notifyEnableLinkageScroll();
            WeakReference<Object> weakReference = sBindObj;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            BdEventBus.Companion.getDefault().unregister(sBindObj.get());
        }
    }
}
