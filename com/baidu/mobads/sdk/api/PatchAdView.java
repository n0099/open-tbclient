package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes3.dex */
public class PatchAdView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_CLICKED = "onAdClicked";
    public static final String PLAY_END = "playCompletion";
    public static final String PLAY_ERROR = "playFailure";
    public static final String PLAY_START = "onAdShow";
    public static final String TAG = "PacthAdView";
    public transient /* synthetic */ FieldHolder $fh;
    public View mAdView;
    public IPatchAdListener mListener;
    public ClassLoader mLoader;
    public final String mRemoteClassName;
    public Context mViewContext;

    /* loaded from: classes3.dex */
    public class InvocationHandlerImp implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PatchAdView this$0;

        public InvocationHandlerImp(PatchAdView patchAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {patchAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = patchAdView;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                String name = method.getName();
                if (TextUtils.isEmpty(name)) {
                    return null;
                }
                if (name.equals("playCompletion")) {
                    if (this.this$0.mListener != null) {
                        this.this$0.mListener.playCompletion();
                    }
                } else if (name.equals(PatchAdView.PLAY_ERROR)) {
                    if (this.this$0.mListener != null) {
                        this.this$0.mListener.playError();
                    }
                } else if (name.equals(PatchAdView.PLAY_START)) {
                    if (this.this$0.mListener != null) {
                        this.this$0.mListener.onAdShow();
                    }
                } else if (name.equals(PatchAdView.AD_CLICKED) && this.this$0.mListener != null) {
                    this.this$0.mListener.onAdClicked();
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PatchAdView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRemoteClassName = w.i;
        init(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            this.mViewContext = context;
            Object[] objArr = {context};
            ClassLoader a = bq.a(context);
            this.mLoader = a;
            View view2 = (View) ar.a(this.mRemoteClassName, a, new Class[]{Context.class}, objArr);
            this.mAdView = view2;
            if (view2 != null) {
                addView(view2, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    public void setPatchAdListener(IPatchAdListener iPatchAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iPatchAdListener) == null) {
            this.mListener = iPatchAdListener;
            try {
                Class<?> a = ar.a("com.component.patchad.IPatchAdListener", this.mLoader);
                if (a != null) {
                    Object newProxyInstance = Proxy.newProxyInstance(a.getClassLoader(), new Class[]{a}, new InvocationHandlerImp(this));
                    if (this.mAdView != null) {
                        ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "setPatchAdListener", new Class[]{a}, newProxyInstance);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void setAdData(XAdVideoResponse xAdVideoResponse) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xAdVideoResponse) == null) && xAdVideoResponse != null && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setAdData", new Class[]{Object.class}, xAdVideoResponse);
        }
    }

    public void setVideoVolume(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setVideoVolume", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                Object a = ar.a(this.mRemoteClassName, view2, this.mLoader, "getCurrentPosition", new Class[0], new Object[0]);
                if (a instanceof Number) {
                    return ((Long) a).longValue();
                }
                return 0L;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                Object a = ar.a(this.mRemoteClassName, view2, this.mLoader, "getDuration", new Class[0], new Object[0]);
                if (a instanceof Number) {
                    return ((Long) a).longValue();
                }
                return 0L;
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}
