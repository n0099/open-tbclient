package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BM\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012-\u0010\u001f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001a¢\u0006\u0002\b\u001eø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0013\u0010\u0006\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\f\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSource", "Landroidx/lifecycle/LiveData;", "source", "Lkotlinx/coroutines/DisposableHandle;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "onActive", "()V", "onInactive", "Landroidx/lifecycle/BlockRunner;", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "Landroidx/lifecycle/EmittedSource;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "<init>", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BlockRunner<T> blockRunner;
    public EmittedSource emittedSource;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* renamed from: androidx.lifecycle.CoroutineLiveData$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoroutineLiveData this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoroutineLiveData coroutineLiveData) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coroutineLiveData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = coroutineLiveData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function0
        public final void invoke() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.this$0.blockRunner = null;
        }
    }

    public CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {coroutineContext, Long.valueOf(j), function2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.blockRunner = new BlockRunner<>(this, function2, j, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(coroutineContext).plus(SupervisorKt.SupervisorJob((Job) coroutineContext.get(Job.Key)))), new AnonymousClass1(this));
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i & 2) != 0 ? 5000L : j, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        InterceptResult invokeL;
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        int i;
        CoroutineLiveData<T> coroutineLiveData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, continuation)) == null) {
            if (continuation instanceof CoroutineLiveData$clearSource$1) {
                coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) continuation;
                int i2 = coroutineLiveData$clearSource$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    coroutineLiveData$clearSource$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = coroutineLiveData$clearSource$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = coroutineLiveData$clearSource$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        EmittedSource emittedSource = this.emittedSource;
                        if (emittedSource != null) {
                            coroutineLiveData$clearSource$1.L$0 = this;
                            coroutineLiveData$clearSource$1.label = 1;
                            obj = emittedSource.disposeNow(coroutineLiveData$clearSource$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            coroutineLiveData = this;
                        } else {
                            coroutineLiveData = this;
                            coroutineLiveData.emittedSource = null;
                            return Unit.INSTANCE;
                        }
                    }
                    Unit unit = (Unit) obj;
                    coroutineLiveData.emittedSource = null;
                    return Unit.INSTANCE;
                }
            }
            coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
            Object obj2 = coroutineLiveData$clearSource$1.result;
            Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = coroutineLiveData$clearSource$1.label;
            if (i == 0) {
            }
            Unit unit2 = (Unit) obj2;
            coroutineLiveData.emittedSource = null;
            return Unit.INSTANCE;
        }
        return invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super DisposableHandle> continuation) {
        InterceptResult invokeLL;
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveData, continuation)) == null) {
            if (continuation instanceof CoroutineLiveData$emitSource$1) {
                coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) continuation;
                int i2 = coroutineLiveData$emitSource$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    coroutineLiveData$emitSource$1.label = i2 - Integer.MIN_VALUE;
                    obj = coroutineLiveData$emitSource$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = coroutineLiveData$emitSource$1.label;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                LiveData liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                                coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                EmittedSource emittedSource = (EmittedSource) obj;
                                coroutineLiveData.emittedSource = emittedSource;
                                return emittedSource;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        liveData2 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                        coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        coroutineLiveData$emitSource$1.L$0 = this;
                        coroutineLiveData$emitSource$1.L$1 = liveData;
                        coroutineLiveData$emitSource$1.label = 1;
                        if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        liveData2 = liveData;
                        coroutineLiveData = this;
                    }
                    coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
                    coroutineLiveData$emitSource$1.L$1 = liveData2;
                    coroutineLiveData$emitSource$1.label = 2;
                    obj = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    EmittedSource emittedSource2 = (EmittedSource) obj;
                    coroutineLiveData.emittedSource = emittedSource2;
                    return emittedSource2;
                }
            }
            coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
            obj = coroutineLiveData$emitSource$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = coroutineLiveData$emitSource$1.label;
            if (i == 0) {
            }
            coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
            coroutineLiveData$emitSource$1.L$1 = liveData2;
            coroutineLiveData$emitSource$1.label = 2;
            obj = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
            if (obj == coroutine_suspended) {
            }
            EmittedSource emittedSource22 = (EmittedSource) obj;
            coroutineLiveData.emittedSource = emittedSource22;
            return emittedSource22;
        }
        return invokeLL.objValue;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onActive();
            BlockRunner<T> blockRunner = this.blockRunner;
            if (blockRunner != null) {
                blockRunner.maybeRun();
            }
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onInactive();
            BlockRunner<T> blockRunner = this.blockRunner;
            if (blockRunner != null) {
                blockRunner.cancel();
            }
        }
    }
}
