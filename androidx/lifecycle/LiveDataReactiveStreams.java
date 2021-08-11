package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes.dex */
public final class LiveDataReactiveStreams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class LiveDataPublisher<T> implements Publisher<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LifecycleOwner mLifecycle;
        public final LiveData<T> mLiveData;

        /* loaded from: classes.dex */
        public static final class LiveDataSubscription<T> implements Subscription, Observer<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public volatile boolean mCanceled;
            @Nullable
            public T mLatest;
            public final LifecycleOwner mLifecycle;
            public final LiveData<T> mLiveData;
            public boolean mObserving;
            public long mRequested;
            public final Subscriber<? super T> mSubscriber;

            public LiveDataSubscription(Subscriber<? super T> subscriber, LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {subscriber, lifecycleOwner, liveData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mSubscriber = subscriber;
                this.mLifecycle = lifecycleOwner;
                this.mLiveData = liveData;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mCanceled) {
                    return;
                }
                this.mCanceled = true;
                ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable(this) { // from class: androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveDataSubscription this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            LiveDataSubscription liveDataSubscription = this.this$0;
                            if (liveDataSubscription.mObserving) {
                                liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                                this.this$0.mObserving = false;
                            }
                            this.this$0.mLatest = null;
                        }
                    }
                });
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || this.mCanceled) {
                    return;
                }
                if (this.mRequested > 0) {
                    this.mLatest = null;
                    this.mSubscriber.onNext(t);
                    long j2 = this.mRequested;
                    if (j2 != Long.MAX_VALUE) {
                        this.mRequested = j2 - 1;
                        return;
                    }
                    return;
                }
                this.mLatest = t;
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || this.mCanceled) {
                    return;
                }
                ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable(this, j2) { // from class: androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveDataSubscription this$0;
                    public final /* synthetic */ long val$n;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$n = j2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mCanceled) {
                            return;
                        }
                        long j3 = this.val$n;
                        if (j3 <= 0) {
                            this.this$0.mCanceled = true;
                            LiveDataSubscription liveDataSubscription = this.this$0;
                            if (liveDataSubscription.mObserving) {
                                liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                                this.this$0.mObserving = false;
                            }
                            LiveDataSubscription liveDataSubscription2 = this.this$0;
                            liveDataSubscription2.mLatest = null;
                            liveDataSubscription2.mSubscriber.onError(new IllegalArgumentException("Non-positive request"));
                            return;
                        }
                        LiveDataSubscription liveDataSubscription3 = this.this$0;
                        long j4 = liveDataSubscription3.mRequested;
                        liveDataSubscription3.mRequested = j4 + j3 >= j4 ? j4 + j3 : Long.MAX_VALUE;
                        LiveDataSubscription liveDataSubscription4 = this.this$0;
                        if (!liveDataSubscription4.mObserving) {
                            liveDataSubscription4.mObserving = true;
                            liveDataSubscription4.mLiveData.observe(liveDataSubscription4.mLifecycle, liveDataSubscription4);
                            return;
                        }
                        T t = liveDataSubscription4.mLatest;
                        if (t != null) {
                            liveDataSubscription4.onChanged(t);
                            this.this$0.mLatest = null;
                        }
                    }
                });
            }
        }

        public LiveDataPublisher(LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lifecycleOwner, liveData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLifecycle = lifecycleOwner;
            this.mLiveData = liveData;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
                subscriber.onSubscribe(new LiveDataSubscription(subscriber, this.mLifecycle, this.mLiveData));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PublisherLiveData<T> extends LiveData<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Publisher<T> mPublisher;
        public final AtomicReference<PublisherLiveData<T>.LiveDataSubscriber> mSubscriber;

        /* loaded from: classes.dex */
        public final class LiveDataSubscriber extends AtomicReference<Subscription> implements Subscriber<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PublisherLiveData this$0;

            public LiveDataSubscriber(PublisherLiveData publisherLiveData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {publisherLiveData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = publisherLiveData;
            }

            public void cancelSubscription() {
                Subscription subscription;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (subscription = get()) == null) {
                    return;
                }
                subscription.cancel();
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.mSubscriber.compareAndSet(this, null);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.this$0.mSubscriber.compareAndSet(this, null);
                    ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable(this, th) { // from class: androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.LiveDataSubscriber.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveDataSubscriber this$1;
                        public final /* synthetic */ Throwable val$ex;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, th};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$ex = th;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                throw new RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", this.val$ex);
                            }
                        }
                    });
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.this$0.postValue(t);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                    if (compareAndSet(null, subscription)) {
                        subscription.request(Long.MAX_VALUE);
                    } else {
                        subscription.cancel();
                    }
                }
            }
        }

        public PublisherLiveData(@NonNull Publisher<T> publisher) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {publisher};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPublisher = publisher;
            this.mSubscriber = new AtomicReference<>();
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onActive();
                PublisherLiveData<T>.LiveDataSubscriber liveDataSubscriber = new LiveDataSubscriber(this);
                this.mSubscriber.set(liveDataSubscriber);
                this.mPublisher.subscribe(liveDataSubscriber);
            }
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onInactive();
                PublisherLiveData<T>.LiveDataSubscriber andSet = this.mSubscriber.getAndSet(null);
                if (andSet != null) {
                    andSet.cancelSubscription();
                }
            }
        }
    }

    public LiveDataReactiveStreams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static <T> LiveData<T> fromPublisher(@NonNull Publisher<T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, publisher)) == null) ? new PublisherLiveData(publisher) : (LiveData) invokeL.objValue;
    }

    @NonNull
    public static <T> Publisher<T> toPublisher(@NonNull LifecycleOwner lifecycleOwner, @NonNull LiveData<T> liveData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, lifecycleOwner, liveData)) == null) ? new LiveDataPublisher(lifecycleOwner, liveData) : (Publisher) invokeLL.objValue;
    }
}
