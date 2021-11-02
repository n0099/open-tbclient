package com.baidu.browser.sailor;

import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebViewClient;
/* loaded from: classes7.dex */
public class BdSailorWebViewClientExt implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final BdSailorWebViewClientExt DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ENativeViewType {
        public static final /* synthetic */ ENativeViewType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ENativeViewType ERROR_PAGE_VEIEW;
        public static final ENativeViewType SAFE_PAGE_VIEW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364436693, "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt$ENativeViewType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-364436693, "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt$ENativeViewType;");
                    return;
                }
            }
            ERROR_PAGE_VEIEW = new ENativeViewType("ERROR_PAGE_VEIEW", 0);
            ENativeViewType eNativeViewType = new ENativeViewType("SAFE_PAGE_VIEW", 1);
            SAFE_PAGE_VIEW = eNativeViewType;
            $VALUES = new ENativeViewType[]{ERROR_PAGE_VEIEW, eNativeViewType};
        }

        public ENativeViewType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ENativeViewType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ENativeViewType) Enum.valueOf(ENativeViewType.class, str) : (ENativeViewType) invokeL.objValue;
        }

        public static ENativeViewType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ENativeViewType[]) $VALUES.clone() : (ENativeViewType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class FirstScreenImageInfo implements INoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean bHaveImageInScreen;
        public int nErrorOccurredCount;
        public int nImageCount;
        public long nMaxTimeStamp;
        public int nPaintHeightForMaxImage;
        public int nPaintWidthForMaxImage;
        public int nPosXForMaxImage;
        public int nPosYForMaxImage;
        public long nTimeStampForMaxImage;
        public String url;

        public FirstScreenImageInfo() {
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

        public int getErrorOccurredCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nErrorOccurredCount : invokeV.intValue;
        }

        public boolean getHaveImageInScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bHaveImageInScreen : invokeV.booleanValue;
        }

        public int getImageCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nImageCount : invokeV.intValue;
        }

        public long getMaxTimeStamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.nMaxTimeStamp : invokeV.longValue;
        }

        public int getPaintHeightForMaxImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.nPaintHeightForMaxImage : invokeV.intValue;
        }

        public int getPaintWidthForMaxImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.nPaintWidthForMaxImage : invokeV.intValue;
        }

        public int getPosXForMaxImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.nPosXForMaxImage : invokeV.intValue;
        }

        public int getPosYForMaxImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.nPosYForMaxImage : invokeV.intValue;
        }

        public long getTimeStampForMaxImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.nTimeStampForMaxImage : invokeV.longValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.url : (String) invokeV.objValue;
        }

        public void setErrorOccurredCount(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.nErrorOccurredCount = i2;
            }
        }

        public void setHaveImageInScreen(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
                this.bHaveImageInScreen = z;
            }
        }

        public void setImageCount(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
                this.nImageCount = i2;
            }
        }

        public void setMaxTimeStamp(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
                this.nMaxTimeStamp = j;
            }
        }

        public void setPaintHeightForMaxImage(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
                this.nPaintHeightForMaxImage = i2;
            }
        }

        public void setPaintWidthForMaxImage(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
                this.nPaintWidthForMaxImage = i2;
            }
        }

        public void setPosXForMaxImage(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
                this.nPosXForMaxImage = i2;
            }
        }

        public void setPosYForMaxImage(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
                this.nPosYForMaxImage = i2;
            }
        }

        public void setTimeStampForMaxImage(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
                this.nTimeStampForMaxImage = j;
            }
        }

        public void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
                this.url = str;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class FirstScreenInfo implements INoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int diffDomcompleteAndFspTime;

        public FirstScreenInfo() {
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

        public int getDiffDomcompleteAndFspTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.diffDomcompleteAndFspTime : invokeV.intValue;
        }

        public void setDiffDomcompleteAndFspTime(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.diffDomcompleteAndFspTime = i2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSailorWebView f36596e;

        public a(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebViewClientExt, bdSailorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36596e = bdSailorWebView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36596e.showEmbeddedTitleBar(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-895037950, "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-895037950, "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt;");
                return;
            }
        }
        DEFAULT = new BdSailorWebViewClientExt();
    }

    public BdSailorWebViewClientExt() {
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

    public void antiHijackSignExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
        }
    }

    public int computeHookH5NavigationStep(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bdSailorWebView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
        }
    }

    public void onAbortResourceRequest(BdSailorWebView bdSailorWebView, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bdSailorWebView, str, str2, Long.valueOf(j)}) == null) {
        }
    }

    public String onBrowserPageEventExt(BdSailorWebView bdSailorWebView, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, bdSailorWebView, i2, str)) == null) ? "" : (String) invokeLIL.objValue;
    }

    public void onCheckHasManifestAndServiceWorker(BdSailorWebView bdSailorWebView, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bdSailorWebView, str, str2, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onDidAsyncWiseSearchStatusChangedExt(BdSailorWebView bdSailorWebView, String str, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, str, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
        }
    }

    public void onDisplaySoftKeyboardExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdSailorWebView) == null) {
        }
    }

    public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, str) == null) {
        }
    }

    public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdSailorWebView, str) == null) {
        }
    }

    public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bdSailorWebView, str) == null) {
        }
    }

    public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bdSailorWebView, str) == null) {
        }
    }

    public void onFirstScreenImagePaint(BdSailorWebView bdSailorWebView, FirstScreenImageInfo firstScreenImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, firstScreenImageInfo) == null) {
        }
    }

    @Deprecated
    public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, bdSailorWebView, str) == null) {
        }
    }

    public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str, FirstScreenInfo firstScreenInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bdSailorWebView, str, firstScreenInfo) == null) {
        }
    }

    public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bdSailorWebView, str) == null) {
        }
    }

    public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
        }
    }

    public void onGestureFlingEnded(BdSailorWebView bdSailorWebView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, bdSailorWebView, i2, i3) == null) {
        }
    }

    public void onGestureScrollEnded(BdSailorWebView bdSailorWebView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048594, this, bdSailorWebView, i2, i3) == null) {
        }
    }

    public void onGestureScrollStarted(BdSailorWebView bdSailorWebView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, bdSailorWebView, i2, i3) == null) {
        }
    }

    public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048596, this, bdSailorWebView, i2, str, str2)) == null) {
            return null;
        }
        return (String) invokeLILL.objValue;
    }

    public Class<? extends View> onGetNativeViewClass(BdSailorWebView bdSailorWebView, ENativeViewType eNativeViewType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, bdSailorWebView, eNativeViewType)) == null) {
            return null;
        }
        return (Class) invokeLL.objValue;
    }

    public void onGoBackOrForwardAnimationFinish(BdSailorWebView bdSailorWebView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, bdSailorWebView, i2) == null) {
        }
    }

    public void onGoBackOrForwardAnimationStart(BdSailorWebView bdSailorWebView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048599, this, bdSailorWebView, i2) == null) && bdSailorWebView != null && bdSailorWebView.isAutoShowTitlebar()) {
            bdSailorWebView.post(new a(this, bdSailorWebView));
        }
    }

    public void onGoPreloadForwardExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdSailorWebView) == null) {
        }
    }

    public void onGotNotResponse(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdSailorWebView) == null) {
        }
    }

    public void onHandleBackForwardBeyondHistory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
        }
    }

    public void onHasVideoExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdSailorWebView) == null) {
        }
    }

    public boolean onHideReaderViewExt(BdSailorWebView bdSailorWebView, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, bdSailorWebView, view)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void onHideSoftKeyboardExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdSailorWebView) == null) {
        }
    }

    public boolean onHideSubjectExt(BdSailorWebView bdSailorWebView, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, bdSailorWebView, view)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, bdSailorWebView, str, str2)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void onNativeViewDayNightChanged(BdSailorWebView bdSailorWebView, View view, ENativeViewType eNativeViewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, bdSailorWebView, view, eNativeViewType) == null) {
        }
    }

    @Deprecated
    public void onNavigationAnimationFinish(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bdSailorWebView) == null) {
        }
    }

    public void onNavigationAnimationFinish(BdSailorWebView bdSailorWebView, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    @Deprecated
    public void onNavigationAnimationStart(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bdSailorWebView) == null) {
        }
    }

    public void onNavigationAnimationStart(BdSailorWebView bdSailorWebView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, bdSailorWebView, z) == null) {
        }
    }

    public void onNewPage(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bdSailorWebView) == null) {
        }
    }

    public void onNextPagePreloadFinishedExt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, bdSailorWebView, i2) == null) {
        }
    }

    public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048616, this, bdSailorWebView, z) == null) {
        }
    }

    @Deprecated
    public void onPageLoadTimeExt(BdSailorWebView bdSailorWebView, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{bdSailorWebView, str, Long.valueOf(j)}) == null) {
        }
    }

    public void onPausePluginExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bdSailorWebView) == null) {
        }
    }

    public void onPlayPluginExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bdSailorWebView) == null) {
        }
    }

    public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, bdSailorWebView, str) == null) {
        }
    }

    public void onProceededAfterSslErrorExt(BdSailorWebView bdSailorWebView, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, bdSailorWebView, sslError) == null) {
        }
    }

    public String onProcessWebSearchUrl(BdSailorWebView bdSailorWebView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, bdSailorWebView, str)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public void onReadModeExitExt(BdSailorWebView bdSailorWebView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048623, this, bdSailorWebView, str, str2) == null) {
        }
    }

    public void onReaderDetectedExt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
        }
    }

    public boolean onReceivedSslErrorExt(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048625, this, bdSailorWebView, sslErrorHandler, sslError)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void onRestoreFromCache(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, bdSailorWebView, str) == null) {
        }
    }

    public void onRestoreFromPageCacheDid(BdSailorWebView bdSailorWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, bdSailorWebView, str) == null) {
        }
    }

    public void onResumePluginExt(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bdSailorWebView) == null) {
        }
    }

    public void onSearchLandingPageClicked(BdSailorWebView bdSailorWebView, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{bdSailorWebView, str, str2, Long.valueOf(j)}) == null) {
        }
    }

    public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048630, this, bdSailorWebView, str, securityInfo) == null) {
        }
    }

    public void onShowHotWordExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{bdSailorWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, str2, str3}) == null) {
        }
    }

    public void onShowNativeView(BdSailorWebView bdSailorWebView, View view, ENativeViewType eNativeViewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048632, this, bdSailorWebView, view, eNativeViewType) == null) {
        }
    }

    public boolean onShowReaderViewExt(BdSailorWebView bdSailorWebView, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, bdSailorWebView, view)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean onShowSubjectExt(BdSailorWebView bdSailorWebView, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, bdSailorWebView, view)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void onStartFirstNavigation(BdSailorWebView bdSailorWebView, String str, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{bdSailorWebView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
        }
    }

    public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, bdSailorWebView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void onSubjectsCollectedExt(BdSailorWebView bdSailorWebView, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
        }
    }

    public boolean onSupportsForceZoomScale(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, bdSailorWebView)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public boolean onTextCopiedExt(BdSailorWebView bdSailorWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, bdSailorWebView)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onUpdateTextFieldNextPreStatus(BdSailorWebView bdSailorWebView, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048641, this, bdSailorWebView, str, str2) == null) {
        }
    }

    public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048642, this, new Object[]{bdSailorWebView, str, str2, str3, Boolean.valueOf(z)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public boolean shouldKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, bdSailorWebView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public boolean shouldOpenFlashExt(BdSailorWebView bdSailorWebView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, bdSailorWebView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }
}
