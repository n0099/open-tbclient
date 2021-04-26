package androidx.lifecycle;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BM\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012-\u0010\u001f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001a¢\u0006\u0002\b\u001eø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0013\u0010\u0006\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\f\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSource", "Landroidx/lifecycle/LiveData;", "source", "Lkotlinx/coroutines/DisposableHandle;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "onActive", "()V", "onInactive", "Landroidx/lifecycle/BlockRunner;", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "Landroidx/lifecycle/EmittedSource;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "<init>", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    public BlockRunner<T> blockRunner;
    public EmittedSource emittedSource;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* renamed from: androidx.lifecycle.CoroutineLiveData$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CoroutineLiveData.this.blockRunner = null;
        }
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 2) != 0 ? 5000L : j, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        int i2;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) continuation;
            int i3 = coroutineLiveData$clearSource$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label = i3 - Integer.MIN_VALUE;
                Object obj = coroutineLiveData$clearSource$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = coroutineLiveData$clearSource$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    EmittedSource emittedSource = this.emittedSource;
                    if (emittedSource == null) {
                        coroutineLiveData = this;
                        coroutineLiveData.emittedSource = null;
                        return Unit.INSTANCE;
                    }
                    coroutineLiveData$clearSource$1.L$0 = this;
                    coroutineLiveData$clearSource$1.label = 1;
                    obj = emittedSource.disposeNow(coroutineLiveData$clearSource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineLiveData = this;
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Unit unit = (Unit) obj;
                coroutineLiveData.emittedSource = null;
                return Unit.INSTANCE;
            }
        }
        coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
        Object obj2 = coroutineLiveData$clearSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = coroutineLiveData$clearSource$1.label;
        if (i2 != 0) {
        }
        Unit unit2 = (Unit) obj2;
        coroutineLiveData.emittedSource = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super DisposableHandle> continuation) {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        Object obj;
        Object coroutine_suspended;
        int i2;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) continuation;
            int i3 = coroutineLiveData$emitSource$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label = i3 - Integer.MIN_VALUE;
                obj = coroutineLiveData$emitSource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = coroutineLiveData$emitSource$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineLiveData$emitSource$1.L$0 = this;
                    coroutineLiveData$emitSource$1.L$1 = liveData;
                    coroutineLiveData$emitSource$1.label = 1;
                    if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveData2 = liveData;
                    coroutineLiveData = this;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LiveData liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                    coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    EmittedSource emittedSource = (EmittedSource) obj;
                    coroutineLiveData.emittedSource = emittedSource;
                    return emittedSource;
                } else {
                    ResultKt.throwOnFailure(obj);
                    liveData2 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                    coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
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
        i2 = coroutineLiveData$emitSource$1.label;
        if (i2 != 0) {
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

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }

    public CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.blockRunner = new BlockRunner<>(this, function2, j, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(coroutineContext).plus(SupervisorKt.SupervisorJob((Job) coroutineContext.get(Job.Key)))), new AnonymousClass1());
    }
}
