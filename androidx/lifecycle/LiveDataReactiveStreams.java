package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes.dex */
public final class LiveDataReactiveStreams {

    /* loaded from: classes.dex */
    public static final class LiveDataPublisher<T> implements Publisher<T> {
        public final LifecycleOwner mLifecycle;
        public final LiveData<T> mLiveData;

        /* loaded from: classes.dex */
        public static final class LiveDataSubscription<T> implements Subscription, Observer<T> {
            public volatile boolean mCanceled;
            @Nullable
            public T mLatest;
            public final LifecycleOwner mLifecycle;
            public final LiveData<T> mLiveData;
            public boolean mObserving;
            public long mRequested;
            public final Subscriber<? super T> mSubscriber;

            public LiveDataSubscription(Subscriber<? super T> subscriber, LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
                this.mSubscriber = subscriber;
                this.mLifecycle = lifecycleOwner;
                this.mLiveData = liveData;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (this.mCanceled) {
                    return;
                }
                this.mCanceled = true;
                ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() { // from class: androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveDataSubscription liveDataSubscription = LiveDataSubscription.this;
                        if (liveDataSubscription.mObserving) {
                            liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                            LiveDataSubscription.this.mObserving = false;
                        }
                        LiveDataSubscription.this.mLatest = null;
                    }
                });
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable T t) {
                if (this.mCanceled) {
                    return;
                }
                if (this.mRequested > 0) {
                    this.mLatest = null;
                    this.mSubscriber.onNext(t);
                    long j = this.mRequested;
                    if (j != Long.MAX_VALUE) {
                        this.mRequested = j - 1;
                        return;
                    }
                    return;
                }
                this.mLatest = t;
            }

            @Override // org.reactivestreams.Subscription
            public void request(final long j) {
                if (this.mCanceled) {
                    return;
                }
                ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() { // from class: androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveDataSubscription.this.mCanceled) {
                            return;
                        }
                        long j2 = j;
                        if (j2 <= 0) {
                            LiveDataSubscription.this.mCanceled = true;
                            LiveDataSubscription liveDataSubscription = LiveDataSubscription.this;
                            if (liveDataSubscription.mObserving) {
                                liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                                LiveDataSubscription.this.mObserving = false;
                            }
                            LiveDataSubscription liveDataSubscription2 = LiveDataSubscription.this;
                            liveDataSubscription2.mLatest = null;
                            liveDataSubscription2.mSubscriber.onError(new IllegalArgumentException("Non-positive request"));
                            return;
                        }
                        LiveDataSubscription liveDataSubscription3 = LiveDataSubscription.this;
                        long j3 = liveDataSubscription3.mRequested;
                        liveDataSubscription3.mRequested = j3 + j2 >= j3 ? j3 + j2 : Long.MAX_VALUE;
                        LiveDataSubscription liveDataSubscription4 = LiveDataSubscription.this;
                        if (!liveDataSubscription4.mObserving) {
                            liveDataSubscription4.mObserving = true;
                            liveDataSubscription4.mLiveData.observe(liveDataSubscription4.mLifecycle, liveDataSubscription4);
                            return;
                        }
                        T t = liveDataSubscription4.mLatest;
                        if (t != null) {
                            liveDataSubscription4.onChanged(t);
                            LiveDataSubscription.this.mLatest = null;
                        }
                    }
                });
            }
        }

        public LiveDataPublisher(LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
            this.mLifecycle = lifecycleOwner;
            this.mLiveData = liveData;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            subscriber.onSubscribe(new LiveDataSubscription(subscriber, this.mLifecycle, this.mLiveData));
        }
    }

    /* loaded from: classes.dex */
    public static class PublisherLiveData<T> extends LiveData<T> {
        public final Publisher<T> mPublisher;
        public final AtomicReference<PublisherLiveData<T>.LiveDataSubscriber> mSubscriber = new AtomicReference<>();

        /* loaded from: classes.dex */
        public final class LiveDataSubscriber extends AtomicReference<Subscription> implements Subscriber<T> {
            public LiveDataSubscriber() {
            }

            public void cancelSubscription() {
                Subscription subscription = get();
                if (subscription != null) {
                    subscription.cancel();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                PublisherLiveData.this.mSubscriber.compareAndSet(this, null);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(final Throwable th) {
                PublisherLiveData.this.mSubscriber.compareAndSet(this, null);
                ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() { // from class: androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.LiveDataSubscriber.1
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", th);
                    }
                });
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                PublisherLiveData.this.postValue(t);
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (compareAndSet(null, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.cancel();
                }
            }
        }

        public PublisherLiveData(@NonNull Publisher<T> publisher) {
            this.mPublisher = publisher;
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            super.onActive();
            PublisherLiveData<T>.LiveDataSubscriber liveDataSubscriber = new LiveDataSubscriber();
            this.mSubscriber.set(liveDataSubscriber);
            this.mPublisher.subscribe(liveDataSubscriber);
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            super.onInactive();
            PublisherLiveData<T>.LiveDataSubscriber andSet = this.mSubscriber.getAndSet(null);
            if (andSet != null) {
                andSet.cancelSubscription();
            }
        }
    }

    @NonNull
    public static <T> LiveData<T> fromPublisher(@NonNull Publisher<T> publisher) {
        return new PublisherLiveData(publisher);
    }

    @NonNull
    public static <T> Publisher<T> toPublisher(@NonNull LifecycleOwner lifecycleOwner, @NonNull LiveData<T> liveData) {
        return new LiveDataPublisher(lifecycleOwner, liveData);
    }
}
