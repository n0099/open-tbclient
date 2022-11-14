package com.baidu.swan.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.tieba.ce2;
import com.baidu.tieba.d32;
import com.baidu.tieba.de2;
import com.baidu.tieba.f12;
import com.baidu.tieba.jp2;
import com.baidu.tieba.m62;
import com.baidu.tieba.no2;
import com.baidu.tieba.ux2;
import com.baidu.tieba.vx2;
import com.baidu.tieba.zh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes3.dex */
public class SwanAppGlobalJsBridge extends no2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public CopyOnWriteArrayList<String> mPendingSchemeList;

    /* loaded from: classes3.dex */
    public class c implements ux2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppGlobalJsBridge a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.a.a.mPendingSchemeList.iterator();
                    while (it.hasNext()) {
                        SwanAppGlobalJsBridge swanAppGlobalJsBridge = this.a.a;
                        swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), (String) it.next());
                    }
                    if (jp2.a) {
                        Log.d("SwanPerformance", "pending api count = " + this.a.a.mPendingSchemeList.size());
                    }
                    this.a.a.mPendingSchemeList.clear();
                }
            }
        }

        public c(SwanAppGlobalJsBridge swanAppGlobalJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGlobalJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppGlobalJsBridge;
        }

        @Override // com.baidu.tieba.ux2
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.mPendingSchemeList.isEmpty()) {
                return;
            }
            zh3.a0(new a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppGlobalJsBridge a;

        public a(SwanAppGlobalJsBridge swanAppGlobalJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGlobalJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppGlobalJsBridge;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.registerLaunchTrigger();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends de2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ SwanAppGlobalJsBridge d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SwanAppGlobalJsBridge swanAppGlobalJsBridge, String str, String str2) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGlobalJsBridge, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = swanAppGlobalJsBridge;
            this.c = str2;
        }

        @Override // com.baidu.tieba.de2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppGlobalJsBridge swanAppGlobalJsBridge = this.d;
                swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, d32 d32Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, d32Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, unitedSchemeMainDispatcher, callbackHandler, d32Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (UnitedSchemeMainDispatcher) objArr2[1], (CallbackHandler) objArr2[2], (d32) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPendingSchemeList = new CopyOnWriteArrayList<>();
        zh3.e0(new a(this));
    }

    private void dispatchOnUiThread(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            ce2.b().c(new b(this, str, str), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str2) && str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
                UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
                unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
                unitedSchemeEntity.setPageUrl(str);
                if (no2.DEBUG) {
                    Log.d(TAG, "doSchemeDispatch scheme: " + str2 + " mCallbackHandler: " + this.mCallbackHandler);
                }
                SchemeTimeCostMoniter.getInstance().schemeStart(str2);
                boolean dispatch = this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
                SchemeTimeCostMoniter.getInstance().schemeEnd(str2);
                return dispatch;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLaunchTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            vx2.c().d(new c(this));
        }
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            f12.i(TAG, "dispatch: scheme " + str);
            if (m62.a(this.mJsContainer, str)) {
                return false;
            }
            if (vx2.c().b(str)) {
                this.mPendingSchemeList.add(str);
                return true;
            }
            dispatchOnUiThread(str);
            return true;
        }
        return invokeL.booleanValue;
    }
}
