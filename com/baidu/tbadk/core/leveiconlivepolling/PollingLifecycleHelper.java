package com.baidu.tbadk.core.leveiconlivepolling;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tbadk/core/leveiconlivepolling/PollingLifecycleHelper;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "mDelayFirst", "", "mLoopCallback", "Lcom/baidu/tbadk/core/leveiconlivepolling/PollingLifecycleHelper$LoopCallback;", "mPollLoopTimer", "Ljava/lang/Runnable;", "mPollingModel", "Lcom/baidu/tbadk/core/leveiconlivepolling/PollingModel;", "mTimeInterval", "type", "", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", MissionEvent.MESSAGE_DESTROY, "seType", "value", "setCallback", "loopCallback", "setDelayFirst", "LoopCallback", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PollingLifecycleHelper implements DefaultLifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public long c;
    public a d;
    public PollingModel e;
    public final Runnable f;

    /* loaded from: classes4.dex */
    public interface a {
        void onLoop();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onPause(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onPause(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onResume(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStart(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStop(this, lifecycleOwner);
    }

    /* loaded from: classes4.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PollingLifecycleHelper a;

        public b(PollingLifecycleHelper pollingLifecycleHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pollingLifecycleHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pollingLifecycleHelper;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    a aVar = this.a.d;
                    if (aVar != null) {
                        aVar.onLoop();
                    }
                } else {
                    PollingModel pollingModel = this.a.e;
                    if (pollingModel != null) {
                        pollingModel.getData(this.a.b);
                    }
                }
                SafeHandler.getInst().postDelayed(this, this.a.c);
            }
        }
    }

    public PollingLifecycleHelper() {
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
        this.c = 300000L;
        this.f = new b(this);
    }

    public final PollingLifecycleHelper k(a loopCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, loopCallback)) == null) {
            Intrinsics.checkNotNullParameter(loopCallback, "loopCallback");
            this.d = loopCallback;
            return this;
        }
        return (PollingLifecycleHelper) invokeL.objValue;
    }

    public final PollingLifecycleHelper l(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            this.a = j;
            return this;
        }
        return (PollingLifecycleHelper) invokeJ.objValue;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            SafeHandler.getInst().removeCallbacks(this.f);
            m.$default$onDestroy(this, owner);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            m.$default$onCreate(this, owner);
            if (owner instanceof TbPageContextSupport) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) owner;
                this.e = new PollingModel(tbPageContextSupport.getPageContext(), tbPageContextSupport.getPageContext().getUniqueId());
                if (this.a > 0) {
                    SafeHandler.getInst().postDelayed(this.f, this.a);
                    return;
                } else {
                    SafeHandler.getInst().post(this.f);
                    return;
                }
            }
            throw new Exception("this polling should add to TbPageContextSupport");
        }
    }
}
