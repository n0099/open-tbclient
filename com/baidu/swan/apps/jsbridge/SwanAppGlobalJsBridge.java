package com.baidu.swan.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.h0.l.g.f;
import c.a.o0.a.r1.l.e;
import c.a.o0.a.v2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes6.dex */
public class SwanAppGlobalJsBridge extends c.a.o0.a.d1.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public CopyOnWriteArrayList<String> mPendingSchemeList;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppGlobalJsBridge f45861e;

        public a(SwanAppGlobalJsBridge swanAppGlobalJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGlobalJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45861e = swanAppGlobalJsBridge;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45861e.registerLaunchTrigger();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.o0.a.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45862g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppGlobalJsBridge f45863h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SwanAppGlobalJsBridge swanAppGlobalJsBridge, String str, String str2) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGlobalJsBridge, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45863h = swanAppGlobalJsBridge;
            this.f45862g = str2;
        }

        @Override // c.a.o0.a.o0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppGlobalJsBridge swanAppGlobalJsBridge = this.f45863h;
                swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.f45862g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppGlobalJsBridge f45865f;

        public c(SwanAppGlobalJsBridge swanAppGlobalJsBridge, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGlobalJsBridge, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45865f = swanAppGlobalJsBridge;
            this.f45864e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppGlobalJsBridge swanAppGlobalJsBridge = this.f45865f;
                swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.f45864e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.o0.a.r1.k.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppGlobalJsBridge f45866a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45867e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45867e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.f45867e.f45866a.mPendingSchemeList.iterator();
                    while (it.hasNext()) {
                        SwanAppGlobalJsBridge swanAppGlobalJsBridge = this.f45867e.f45866a;
                        swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), (String) it.next());
                    }
                    if (c.a.o0.a.f1.f.a.f5674a) {
                        String str = "pending api count = " + this.f45867e.f45866a.mPendingSchemeList.size();
                    }
                    this.f45867e.f45866a.mPendingSchemeList.clear();
                }
            }
        }

        public d(SwanAppGlobalJsBridge swanAppGlobalJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGlobalJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45866a = swanAppGlobalJsBridge;
        }

        @Override // c.a.o0.a.r1.k.h.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45866a.mPendingSchemeList.isEmpty()) {
                return;
            }
            q0.X(new a(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, c.a.o0.a.h0.f.a aVar) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, unitedSchemeMainDispatcher, callbackHandler, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (UnitedSchemeMainDispatcher) objArr2[1], (CallbackHandler) objArr2[2], (c.a.o0.a.h0.f.a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPendingSchemeList = new CopyOnWriteArrayList<>();
        q0.b0(new a(this));
    }

    private void dispatchOnUiThread(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (e.a()) {
                c.a.o0.a.o0.b.b().c(new b(this, str, str), null);
            } else {
                q0.b0(new c(this, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2) || !str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
                return false;
            }
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
            unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
            unitedSchemeEntity.setPageUrl(str);
            if (c.a.o0.a.d1.a.DEBUG) {
                String str3 = "doSchemeDispatch scheme: " + str2 + " mCallbackHandler: " + this.mCallbackHandler;
            }
            SchemeTimeCostMoniter.getInstance().schemeStart(str2);
            boolean dispatch = this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
            SchemeTimeCostMoniter.getInstance().schemeEnd(str2);
            return dispatch;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLaunchTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            c.a.o0.a.r1.k.h.b.c().d(new d(this));
        }
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (f.a(this.mJsContainer, str)) {
                return false;
            }
            if (c.a.o0.a.r1.k.h.b.c().b(str)) {
                this.mPendingSchemeList.add(str);
                if (c.a.o0.a.f1.f.a.f5674a) {
                    String str2 = "pending api size = " + this.mPendingSchemeList.size();
                    return true;
                }
                return true;
            }
            dispatchOnUiThread(str);
            return true;
        }
        return invokeL.booleanValue;
    }
}
