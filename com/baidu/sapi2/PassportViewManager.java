package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import c.a.b0.a.b;
import c.a.b0.a.c;
import c.a.b0.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PassportViewManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static SapiConfiguration f44306c;

    /* renamed from: d  reason: collision with root package name */
    public static PassportViewManager f44307d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TitleBtnCallback f44308a;

    /* renamed from: b  reason: collision with root package name */
    public TitleViewModule f44309b;

    /* loaded from: classes5.dex */
    public static class TitleViewModule implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public static final int DEFAULT_TEXT_COLOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int bgColor;
        public int bgHeight;
        public int dividerLineVisible;
        public Drawable leftBtnDrawableBottom;
        public Drawable leftBtnDrawableLeft;
        public Drawable leftBtnDrawableRight;
        public Drawable leftBtnDrawableTop;
        public int leftBtnImgResId;
        public int leftBtnImgVisible;
        public String leftBtnText;
        public int leftBtnTextColor;
        public float leftBtnTextSize;
        public int leftBtnTextVisible;
        public String rightBtnText;
        public int rightBtnTextColor;
        public float rightBtnTextSize;
        public int rightBtnVisible;
        public Drawable titleDrawableBottom;
        public Drawable titleDrawableLeft;
        public Drawable titleDrawableRight;
        public Drawable titleDrawableTop;
        public String titleText;
        public boolean titleTextBold;
        public int titleTextColor;
        public float titleTextSize;
        public int titleVisible;
        public boolean useWebviewTitle;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1697857134, "Lcom/baidu/sapi2/PassportViewManager$TitleViewModule;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1697857134, "Lcom/baidu/sapi2/PassportViewManager$TitleViewModule;");
                    return;
                }
            }
            DEFAULT_TEXT_COLOR = PassportViewManager.f44306c.context.getResources().getColor(b.sapi_sdk_edit_text_color);
        }

        public TitleViewModule() {
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
            this.bgColor = Integer.MAX_VALUE;
            this.bgHeight = Integer.MAX_VALUE;
            this.leftBtnImgResId = Integer.MAX_VALUE;
            this.leftBtnImgVisible = 0;
            this.leftBtnTextColor = DEFAULT_TEXT_COLOR;
            this.leftBtnText = null;
            this.leftBtnTextVisible = 4;
            this.leftBtnTextSize = PassportViewManager.f44306c.context.getResources().getDimension(c.sapi_sdk_title_left_btn_text_size);
            this.leftBtnDrawableLeft = null;
            this.leftBtnDrawableTop = null;
            this.leftBtnDrawableRight = null;
            this.leftBtnDrawableBottom = null;
            this.titleTextColor = DEFAULT_TEXT_COLOR;
            this.titleText = null;
            this.titleVisible = 0;
            this.titleTextSize = PassportViewManager.f44306c.context.getResources().getDimension(c.sapi_sdk_title_text_size);
            this.titleTextBold = false;
            this.useWebviewTitle = true;
            this.titleDrawableLeft = null;
            this.titleDrawableTop = null;
            this.titleDrawableRight = null;
            this.titleDrawableBottom = null;
            this.rightBtnTextColor = DEFAULT_TEXT_COLOR;
            this.rightBtnText = null;
            this.rightBtnVisible = 4;
            this.rightBtnTextSize = PassportViewManager.f44306c.context.getResources().getDimension(c.sapi_sdk_title_right_btn_text_size);
            this.dividerLineVisible = 0;
        }
    }

    public PassportViewManager() {
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
        this.f44309b = null;
        f44306c = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    public static synchronized PassportViewManager getInstance() {
        InterceptResult invokeV;
        PassportViewManager passportViewManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (PassportViewManager.class) {
                if (f44307d == null) {
                    f44307d = new PassportViewManager();
                }
                passportViewManager = f44307d;
            }
            return passportViewManager;
        }
        return (PassportViewManager) invokeV.objValue;
    }

    public void configTitle(TitleViewModule titleViewModule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, titleViewModule) == null) {
            this.f44309b = titleViewModule;
            if (titleViewModule.bgColor == Integer.MAX_VALUE) {
                titleViewModule.bgColor = -1;
            }
            if (titleViewModule.leftBtnImgResId == Integer.MAX_VALUE) {
                titleViewModule.leftBtnImgResId = d.sapi_sdk_btn_back;
            }
        }
    }

    public TitleBtnCallback getTitleBtnCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44308a : (TitleBtnCallback) invokeV.objValue;
    }

    public TitleViewModule getTitleViewModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44309b : (TitleViewModule) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f44308a = null;
            this.f44309b = null;
            SapiWebView.statLoadLogin = null;
        }
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, titleBtnCallback) == null) {
            this.f44308a = titleBtnCallback;
        }
    }
}
