package com.baidu.searchbox.process.ipc.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.searchbox.process.ipc.agent.provider.MainProcessDelegateProvider;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.tieba.qw9;
import com.baidu.tieba.ww9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class DelegateUtils implements DelegateDef {
    public static /* synthetic */ Interceptable $ic;
    public static Handler sMainHandler;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1497788332, "Lcom/baidu/searchbox/process/ipc/delegate/DelegateUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1497788332, "Lcom/baidu/searchbox/process/ipc/delegate/DelegateUtils;");
                return;
            }
        }
        sMainHandler = new Handler(Looper.getMainLooper());
    }

    public DelegateUtils() {
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

    public static void callOnMainWithActivity(@NonNull Activity activity, @NonNull Class<? extends ProcessDelegateBaseActivity> cls, @NonNull Class<? extends ActivityDelegation> cls2, @NonNull DelegateListener delegateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, cls, cls2, delegateListener) == null) {
            callOnMainWithActivity(activity, cls, cls2, null, delegateListener);
        }
    }

    @NonNull
    public static DelegateResult callOnMainWithContentProvider(@NonNull Context context, @NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, cls, bundle)) == null) {
            try {
                Bundle call = context.getContentResolver().call(MainProcessDelegateProvider.PROVIDER_URI, cls.getName(), (String) null, bundle);
                if (call != null) {
                    call.setClassLoader(cls.getClassLoader());
                }
                if (call == null) {
                    return new DelegateResult(1, cls, null, null);
                }
                return new DelegateResult(call.getInt(DelegateDef.EXTRA_RESULT_CODE), cls, null, call.getBundle(DelegateDef.EXTRA_RESULT));
            } catch (IllegalArgumentException unused) {
                return new DelegateResult(1, cls, null, null);
            } catch (SecurityException unused2) {
                return new DelegateResult(1, cls, null, null);
            }
        }
        return (DelegateResult) invokeLLL.objValue;
    }

    public static void callOnMainWithContentProviderASync(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle, @NonNull DelegateListener delegateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, cls, bundle, delegateListener) == null) {
            notifyResult(delegateListener, new DelegateResult(1, cls, bundle).addDesc("agent is not implement"));
        }
    }

    public static void notifyResult(DelegateListener delegateListener, DelegateResult delegateResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, delegateListener, delegateResult) == null) {
            sMainHandler.post(new Runnable(delegateListener, delegateResult) { // from class: com.baidu.searchbox.process.ipc.delegate.DelegateUtils.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DelegateListener val$listener;
                public final /* synthetic */ DelegateResult val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {delegateListener, delegateResult};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = delegateListener;
                    this.val$result = delegateResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$listener.onDelegateCallBack(this.val$result);
                    }
                }
            });
        }
    }

    @NonNull
    public static qw9<DelegateResult> safeCallOnMainWithContentProvider(@NonNull Context context, @NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, cls, bundle)) == null) ? qw9.a(new qw9.a<DelegateResult>(context, cls, bundle) { // from class: com.baidu.searchbox.process.ipc.delegate.DelegateUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context val$context;
            public final /* synthetic */ Class val$delegation;
            public final /* synthetic */ Bundle val$params;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, cls, bundle};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$delegation = cls;
                this.val$params = bundle;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
            public void call(ww9<? super DelegateResult> ww9Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, ww9Var) == null) {
                    ww9Var.onNext(DelegateUtils.callOnMainWithContentProvider(this.val$context, this.val$delegation, this.val$params));
                    ww9Var.onCompleted();
                }
            }
        }) : (qw9) invokeLLL.objValue;
    }

    public static void callOnMainWithActivity(@NonNull Activity activity, @NonNull Class<? extends ProcessDelegateBaseActivity> cls, @NonNull Class<? extends ActivityDelegation> cls2, @Nullable Bundle bundle, @NonNull DelegateListener delegateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, activity, cls, cls2, bundle, delegateListener) == null) {
            if (cls2 == null) {
                notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("action is null"));
                return;
            }
            String name = cls2.getName();
            if (TextUtils.isEmpty(name)) {
                notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("caller not instanceof ActivityResultDispatcherHolder"));
            } else if (!(activity instanceof ActivityResultDispatcherHolder)) {
                notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("caller not instanceof ActivityResultDispatcherHolder"));
            } else {
                ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher();
                if (resultDispatcher == null) {
                    notifyResult(delegateListener, new DelegateResult(2, cls2, bundle).addDesc("null == observable"));
                    return;
                }
                resultDispatcher.addConsumer(new ActivityResultConsumer(name, delegateListener, cls2, bundle) { // from class: com.baidu.searchbox.process.ipc.delegate.DelegateUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Class val$delegation;
                    public final /* synthetic */ String val$delegationName;
                    public final /* synthetic */ DelegateListener val$listener;
                    public final /* synthetic */ Bundle val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {name, delegateListener, cls2, bundle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$delegationName = name;
                        this.val$listener = delegateListener;
                        this.val$delegation = cls2;
                        this.val$params = bundle;
                    }

                    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                    public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
                        InterceptResult invokeLIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                            if (intent == null || !this.val$delegationName.equals(intent.getStringExtra(DelegateDef.EXTRA_DELEGATION_NAME))) {
                                return false;
                            }
                            if (-1 != i) {
                                DelegateListener delegateListener2 = this.val$listener;
                                DelegateResult delegateResult = new DelegateResult(3, this.val$delegation, this.val$params);
                                DelegateUtils.notifyResult(delegateListener2, delegateResult.addDesc("activity resultCode = " + i));
                                return true;
                            }
                            DelegateResult delegateResult2 = new DelegateResult(intent.getIntExtra(DelegateDef.EXTRA_RESULT_CODE, 0), this.val$delegation, this.val$params, intent.getBundleExtra(DelegateDef.EXTRA_RESULT));
                            delegateResult2.addDesc(intent.getStringExtra(DelegateDef.EXTRA_RESULT_DESC));
                            DelegateUtils.notifyResult(this.val$listener, delegateResult2);
                            return true;
                        }
                        return invokeLIL.booleanValue;
                    }
                });
                resultDispatcher.startActivityForResult(new Intent(activity, cls).putExtra(DelegateDef.EXTRA_DELEGATION_NAME, name).putExtra(DelegateDef.EXTRA_PARAMS, bundle));
            }
        }
    }
}
