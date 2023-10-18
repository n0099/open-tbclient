package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IBasicCPUAggregation;
import com.baidu.mobads.sdk.internal.aq;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.w;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class NativeCPUAggregationData implements IBasicCPUAggregation {
    public static /* synthetic */ Interceptable $ic;
    public static final String CLASS_NAME;
    public transient /* synthetic */ FieldHolder $fh;
    public final ClassLoader mClassLoader;
    public IBasicCPUAggregation.ICpuHotNativeStatus mCpuNativeStatusCBListener;
    public final Context mCtx;
    public Object mInstance;
    public final HashMap<String, Object> mSettings;
    public aq remoteUtils;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1229121989, "Lcom/baidu/mobads/sdk/api/NativeCPUAggregationData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1229121989, "Lcom/baidu/mobads/sdk/api/NativeCPUAggregationData;");
                return;
            }
        }
        CLASS_NAME = w.n;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getContentId", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public List<String> getImagesList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getImagesList", new Object[0]);
            if (b instanceof List) {
                return (List) b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getLongTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getLongTitle", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getShortTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getShortTitle", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public NativeCPUAggregationData(Context context, Object obj, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, obj, hashMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = aq.a(context, CLASS_NAME);
        this.mClassLoader = bq.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2) == null) {
            HashMap<String, Object> hashMap = this.mSettings;
            if (hashMap != null) {
                this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
            }
            this.remoteUtils.a(this.mInstance, "handleClickView", view2);
        }
    }

    private void onImpression(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, view2) == null) {
            HashMap<String, Object> hashMap = this.mSettings;
            if (hashMap != null) {
                this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
            }
            this.remoteUtils.a(this.mInstance, "onImpression", view2);
        }
    }

    private void setStatusListener(IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, iCpuHotNativeStatus) == null) {
            this.mCpuNativeStatusCBListener = iCpuHotNativeStatus;
            try {
                this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.mClassLoader, new Class[]{ar.a(w.o, this.mClassLoader)}, new InvocationHandler(this) { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NativeCPUAggregationData this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                            if (this.this$0.mCpuNativeStatusCBListener != null && method != null && "onNotifyPerformance".equals(method.getName()) && objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                                this.this$0.mCpuNativeStatusCBListener.onNotifyPerformance((String) objArr[0]);
                            }
                            return null;
                        }
                        return invokeLLL.objValue;
                    }
                }));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public void registerViewForInteraction(View view2, List<View> list, IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, view2, list, iCpuHotNativeStatus) == null) {
            setStatusListener(iCpuHotNativeStatus);
            onImpression(view2);
            if (list != null && list.size() > 0) {
                for (View view3 : list) {
                    if (view3 != null) {
                        view3.setOnClickListener(new View.OnClickListener(this, view3) { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NativeCPUAggregationData this$0;
                            public final /* synthetic */ View val$clickView;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, view3};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$clickView = view3;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view4) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null && interceptable2.invokeL(1048576, this, view4) != null) {
                                    return;
                                }
                                this.this$0.handleClickView(view4);
                                this.val$clickView.setClickable(false);
                                this.val$clickView.postDelayed(new Runnable(this) { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        View view5;
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (view5 = this.this$1.val$clickView) != null) {
                                            view5.setClickable(true);
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            }
        }
    }
}
