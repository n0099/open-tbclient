package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {91, 95, 96}, m = "invokeSuspend", n = {"$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "value"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes.dex */
public final class FlowLiveDataConversions$asFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ LiveData $this_asFlow;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public FlowCollector p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, continuation);
        flowLiveDataConversions$asFlow$1.p$ = (FlowCollector) obj;
        return flowLiveDataConversions$asFlow$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowLiveDataConversions$asFlow$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Observer $observer;
        public int label;
        public CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Observer observer, Continuation continuation) {
            super(2, continuation);
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, continuation);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowLiveDataConversions$asFlow$1.this.$this_asFlow.observeForever(this.$observer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Observer $observer;
        public int label;
        public CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Observer observer, Continuation continuation) {
            super(2, continuation);
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$observer, continuation);
            anonymousClass2.p$ = (CoroutineScope) obj;
            return anonymousClass2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowLiveDataConversions$asFlow$1.this.$this_asFlow.removeObserver(this.$observer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00e4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[Catch: all -> 0x00e4, TRY_LEAVE, TryCatch #0 {all -> 0x00e4, blocks: (B:29:0x00ad, B:31:0x00b5), top: B:45:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.lifecycle.Observer] */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.lifecycle.Observer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:47:0x0095). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Channel channel;
        Observer<T> observer;
        FlowLiveDataConversions$asFlow$1<T> flowLiveDataConversions$asFlow$1;
        Throwable th;
        FlowCollector flowCollector2;
        Channel channel2;
        ChannelIterator channelIterator;
        ChannelIterator channelIterator2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r5 = 1;
        try {
            try {
                if (i != 0) {
                    if (i != 1) {
                        try {
                            if (i != 2) {
                                if (i == 3) {
                                    channelIterator = (ChannelIterator) this.L$4;
                                    Observer<T> observer2 = (Observer) this.L$2;
                                    channel2 = (Channel) this.L$1;
                                    flowCollector2 = (FlowCollector) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    flowLiveDataConversions$asFlow$1 = this;
                                    Observer<T> observer3 = observer2;
                                    FlowCollector flowCollector3 = flowCollector2;
                                    channelIterator2 = channelIterator;
                                    observer = observer3;
                                    channel = channel2;
                                    flowCollector = flowCollector3;
                                    flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                                    flowLiveDataConversions$asFlow$1.L$1 = channel;
                                    flowLiveDataConversions$asFlow$1.L$2 = observer;
                                    flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
                                    flowLiveDataConversions$asFlow$1.label = 2;
                                    obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Channel channel3 = channel;
                                    r5 = observer;
                                    channelIterator = channelIterator2;
                                    flowCollector2 = flowCollector;
                                    channel2 = channel3;
                                    try {
                                        if (!((Boolean) obj2).booleanValue()) {
                                            Object next = channelIterator.next();
                                            flowLiveDataConversions$asFlow$1.L$0 = flowCollector2;
                                            flowLiveDataConversions$asFlow$1.L$1 = channel2;
                                            flowLiveDataConversions$asFlow$1.L$2 = r5;
                                            flowLiveDataConversions$asFlow$1.L$3 = next;
                                            flowLiveDataConversions$asFlow$1.L$4 = channelIterator;
                                            flowLiveDataConversions$asFlow$1.label = 3;
                                            observer3 = r5;
                                            if (flowCollector2.emit(next, flowLiveDataConversions$asFlow$1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            FlowCollector flowCollector32 = flowCollector2;
                                            channelIterator2 = channelIterator;
                                            observer = observer3;
                                            channel = channel2;
                                            flowCollector = flowCollector32;
                                            flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                                            flowLiveDataConversions$asFlow$1.L$1 = channel;
                                            flowLiveDataConversions$asFlow$1.L$2 = observer;
                                            flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
                                            flowLiveDataConversions$asFlow$1.label = 2;
                                            obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                                            if (obj2 == coroutine_suspended) {
                                            }
                                        } else {
                                            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
                                        throw th;
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                channelIterator = (ChannelIterator) this.L$3;
                                Observer observer4 = (Observer) this.L$2;
                                channel2 = (Channel) this.L$1;
                                flowCollector2 = (FlowCollector) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                obj2 = obj;
                                flowLiveDataConversions$asFlow$1 = this;
                                r5 = observer4;
                                if (!((Boolean) obj2).booleanValue()) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            flowLiveDataConversions$asFlow$1 = this;
                            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
                            throw th;
                        }
                    } else {
                        observer = (Observer) this.L$2;
                        channel = (Channel) this.L$1;
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = this.p$;
                    final Channel Channel = ChannelKt.Channel(-1);
                    Observer<T> observer5 = new Observer<T>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(T t) {
                            Channel.this.offer(t);
                        }
                    };
                    MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(observer5, null);
                    this.L$0 = flowCollector;
                    this.L$1 = Channel;
                    this.L$2 = observer5;
                    this.label = 1;
                    if (BuildersKt.withContext(immediate, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channel = Channel;
                    observer = observer5;
                }
                flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                flowLiveDataConversions$asFlow$1.L$1 = channel;
                flowLiveDataConversions$asFlow$1.L$2 = observer;
                flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
                flowLiveDataConversions$asFlow$1.label = 2;
                obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                if (obj2 == coroutine_suspended) {
                }
            } catch (Throwable th4) {
                th = th4;
                r5 = observer;
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
                throw th;
            }
            channelIterator2 = channel.iterator();
            flowLiveDataConversions$asFlow$1 = this;
        } catch (Throwable th5) {
            th = th5;
            flowLiveDataConversions$asFlow$1 = this;
            r5 = observer;
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
            throw th;
        }
    }
}
