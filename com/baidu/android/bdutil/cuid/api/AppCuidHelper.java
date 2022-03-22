package com.baidu.android.bdutil.cuid.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes3.dex */
public final class AppCuidHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "AppCuidHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public String mEnUid;
    public String mUid;
    public volatile String mUidFromGalaxy;

    /* renamed from: com.baidu.android.bdutil.cuid.api.AppCuidHelper$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class Singleton {
        public static /* synthetic */ Interceptable $ic;
        public static final AppCuidHelper INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(961667602, "Lcom/baidu/android/bdutil/cuid/api/AppCuidHelper$Singleton;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(961667602, "Lcom/baidu/android/bdutil/cuid/api/AppCuidHelper$Singleton;");
                    return;
                }
            }
            INSTANCE = new AppCuidHelper(null);
        }

        public Singleton() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ AppCuidHelper(AnonymousClass1 anonymousClass1) {
        this();
    }

    private String generateUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) ? CommonParam.getCUID(context) : (String) invokeL.objValue;
    }

    public static final AppCuidHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Singleton.INSTANCE : (AppCuidHelper) invokeV.objValue;
    }

    private synchronized String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            synchronized (this) {
                if (AppRuntime.getAppContext() == null) {
                    return null;
                }
                if (TextUtils.isEmpty(this.mUidFromGalaxy)) {
                    this.mUidFromGalaxy = generateUID(AppRuntime.getAppContext());
                }
                return this.mUidFromGalaxy;
            }
        }
        return (String) invokeV.objValue;
    }

    private void initUid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mUid = getUid();
            this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
        }
    }

    public String getmEnUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.mEnUid)) {
                initUid();
            }
            return this.mEnUid;
        }
        return (String) invokeV.objValue;
    }

    public String getmUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.mUid)) {
                initUid();
            }
            return this.mUid;
        }
        return (String) invokeV.objValue;
    }

    public AppCuidHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initUid();
    }
}
