package com.baidu.mobads.container.util;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BackListManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BackListManager";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<BackRecord> mBackList;
    public int mCurrentIndex;
    public WebView mView;

    /* loaded from: classes5.dex */
    public class BackRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mExtra;
        public int mStep;
        public String mURL;
        public final /* synthetic */ BackListManager this$0;

        public BackRecord(BackListManager backListManager, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backListManager, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = backListManager;
            this.mURL = str;
            this.mExtra = str2;
            this.mStep = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isSameExtra(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
                String str2 = this.mExtra;
                if (str2 != null) {
                    return str2.equals(str);
                }
                return str == null;
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateStep(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
                this.mStep--;
                this.mURL = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1846408415, "Lcom/baidu/mobads/container/util/BackListManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1846408415, "Lcom/baidu/mobads/container/util/BackListManager;");
        }
    }

    public BackListManager() {
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
        this.mBackList = new ArrayList<>();
        this.mCurrentIndex = -1;
    }

    private boolean isNewRecord(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (this.mBackList.isEmpty()) {
                return true;
            }
            try {
                return !this.mBackList.get(this.mCurrentIndex).isSameExtra(str);
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void addBackList(String str, boolean z) {
        WebView.HitTestResult hitTestResult;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || this.mView == null || z || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = this.mCurrentIndex;
        if ((i2 <= -1 || !str.equals(this.mBackList.get(i2).mURL)) && (hitTestResult = this.mView.getHitTestResult()) != null) {
            String extra = hitTestResult.getExtra();
            synchronized (this) {
                if (!isNewRecord(extra)) {
                    this.mBackList.get(this.mCurrentIndex).updateStep(str);
                } else {
                    this.mBackList.add(new BackRecord(this, str, extra));
                    this.mCurrentIndex++;
                }
            }
        }
    }

    public boolean canGoBack() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !this.mBackList.isEmpty() && (i2 = this.mBackList.get(this.mCurrentIndex).mStep) < 0 && this.mView.canGoBackOrForward(i2) : invokeV.booleanValue;
    }

    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mView == null) {
                RemoteXAdLogger.getInstance().i(TAG, "go back with a null mView.");
                return;
            }
            synchronized (this) {
                this.mView.goBackOrForward(this.mBackList.isEmpty() ? 0 : this.mBackList.get(this.mCurrentIndex).mStep);
                this.mBackList.remove(this.mCurrentIndex);
                this.mCurrentIndex--;
            }
        }
    }

    public void resetManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.mView = null;
                this.mCurrentIndex = -1;
                this.mBackList.clear();
            }
        }
    }

    public void setWebView(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, webView) == null) {
            this.mView = webView;
        }
    }
}
