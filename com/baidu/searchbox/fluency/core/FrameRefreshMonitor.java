package com.baidu.searchbox.fluency.core;

import android.app.Activity;
import android.view.Choreographer;
import androidx.annotation.CallSuper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.fluency.core.MainLooperMonitor;
import com.baidu.searchbox.fluency.utils.Logcat;
import com.baidu.searchbox.fluency.utils.ReflectHelper;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001=\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001MB\t\b\u0002¢\u0006\u0004\bL\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\rR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020/\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010;R\u0016\u0010<\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001d\u0010E\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR&\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\b0Fj\b\u0012\u0004\u0012\u00020\b`G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010:R\u0018\u0010K\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00101¨\u0006N"}, d2 = {"Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor;", "Ljava/lang/Runnable;", "", "type", WebChromeClient.KEY_ARG_CALLBACK, "", "addCallbackToQueue", "(ILjava/lang/Runnable;)V", "Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor$FrameRefreshObserver;", "observer", "addFrameRefreshObserver", "(Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor$FrameRefreshObserver;)V", "dispatchBegin", "()V", "dispatchEnd", "doQueueBegin", "(I)V", "doQueueEnd", "", "defaultValue", "getIntendedFrameTimeNs", "(J)J", "", "isAlive", "()Z", "removeFrameRefreshObserver", "run", "startMonitor", "stopMonitor", "CALLBACK_ANIMATION", "I", "CALLBACK_COMMIT", "CALLBACK_INPUT", "CALLBACK_LAST", "CALLBACK_TRAVERSAL", "", "METHOD_ADD_CALLBACK", "Ljava/lang/String;", "TAG", "Ljava/lang/reflect/Method;", "addAnimationQueue", "Ljava/lang/reflect/Method;", "addInputQueue", "addTraversalQueue", "", "callbackExist", "[Z", "", "callbackQueueLock", "Ljava/lang/Object;", "", "callbackQueues", "[Ljava/lang/Object;", "Landroid/view/Choreographer;", "choreographer", "Landroid/view/Choreographer;", "", "dispatchTimeNs", "[J", "Z", "isVsyncFrame", "com/baidu/searchbox/fluency/core/FrameRefreshMonitor$looperListener$1", "looperListener", "Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor$looperListener$1;", "Lcom/baidu/searchbox/fluency/core/MainLooperMonitor;", "mainLooperMonitor$delegate", "Lkotlin/Lazy;", "getMainLooperMonitor", "()Lcom/baidu/searchbox/fluency/core/MainLooperMonitor;", "mainLooperMonitor", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "observers", "Ljava/util/HashSet;", "queueCost", "vsyncRecevier", "<init>", "FrameRefreshObserver", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class FrameRefreshMonitor implements Runnable {
    public static int CALLBACK_ANIMATION = 0;
    public static int CALLBACK_COMMIT = 0;
    public static final int CALLBACK_INPUT = 0;
    public static int CALLBACK_LAST = 0;
    public static int CALLBACK_TRAVERSAL = 0;
    public static final String METHOD_ADD_CALLBACK = "addCallbackLocked";
    public static final String TAG = "FrameRefreshMonitor";
    public static Method addAnimationQueue;
    public static Method addInputQueue;
    public static Method addTraversalQueue;
    public static boolean[] callbackExist;
    public static Object[] callbackQueues;
    public static boolean isAlive;
    public static boolean isVsyncFrame;
    public static long[] queueCost;
    public static Object vsyncRecevier;
    public static final FrameRefreshMonitor INSTANCE = new FrameRefreshMonitor();
    public static final HashSet<FrameRefreshObserver> observers = new HashSet<>();
    public static long[] dispatchTimeNs = new long[2];
    public static final Lazy mainLooperMonitor$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MainLooperMonitor>() { // from class: com.baidu.searchbox.fluency.core.FrameRefreshMonitor$mainLooperMonitor$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MainLooperMonitor invoke() {
            return new MainLooperMonitor();
        }
    });
    public static final FrameRefreshMonitor$looperListener$1 looperListener = new MainLooperMonitor.LopperDispatchListener() { // from class: com.baidu.searchbox.fluency.core.FrameRefreshMonitor$looperListener$1
        @Override // com.baidu.searchbox.fluency.core.MainLooperMonitor.LopperDispatchListener
        public void dispatchEnd() {
            super.dispatchEnd();
            FrameRefreshMonitor.INSTANCE.dispatchEnd();
        }

        @Override // com.baidu.searchbox.fluency.core.MainLooperMonitor.LopperDispatchListener
        public void dispatchStart() {
            super.dispatchStart();
            FrameRefreshMonitor.INSTANCE.dispatchBegin();
        }

        @Override // com.baidu.searchbox.fluency.core.MainLooperMonitor.LopperDispatchListener
        public boolean isEnable() {
            boolean z;
            FrameRefreshMonitor frameRefreshMonitor = FrameRefreshMonitor.INSTANCE;
            z = FrameRefreshMonitor.isAlive;
            return z;
        }
    };
    public static Choreographer choreographer = Choreographer.getInstance();
    public static Object callbackQueueLock = ReflectHelper.INSTANCE.reflectField(choreographer, "mLock", new Object(), false);

    private final MainLooperMonitor getMainLooperMonitor() {
        return (MainLooperMonitor) mainLooperMonitor$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\bJG\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor$FrameRefreshObserver;", "", "beginNs", "", "dispatchBegin", "(J)V", "endNs", "dispatchEnd", "(JJ)V", "", "topPage", "startNs", "", "isVsyncFrame", "inputCostNs", "animationCostNs", "traversalCostNs", "doFrame", "(Ljava/lang/String;JJZJJJ)V", "isDispatchBegin", "()Z", "Z", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static abstract class FrameRefreshObserver {
        public boolean isDispatchBegin;

        public void doFrame(String topPage, long j, long j2, boolean z, long j3, long j4, long j5) {
            Intrinsics.checkNotNullParameter(topPage, "topPage");
        }

        public final boolean isDispatchBegin() {
            return this.isDispatchBegin;
        }

        public final void dispatchBegin(long j) {
            this.isDispatchBegin = true;
        }

        @CallSuper
        public final void dispatchEnd(long j, long j2) {
            this.isDispatchBegin = false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.baidu.searchbox.fluency.core.FrameRefreshMonitor$looperListener$1] */
    static {
        CALLBACK_ANIMATION = 1;
        CALLBACK_TRAVERSAL = 2;
        CALLBACK_COMMIT = 4;
        CALLBACK_LAST = 4;
        Object[] objArr = (Object[]) ReflectHelper.INSTANCE.reflectField(choreographer, "mCallbackQueues", null, false);
        callbackQueues = objArr;
        if (objArr != null) {
            Intrinsics.checkNotNull(objArr);
            int length = objArr.length - 1;
            CALLBACK_LAST = length;
            CALLBACK_COMMIT = length;
            CALLBACK_TRAVERSAL = length - 1;
            CALLBACK_ANIMATION = 1;
            queueCost = new long[length + 1];
            callbackExist = new boolean[length + 1];
            ReflectHelper reflectHelper = ReflectHelper.INSTANCE;
            Object[] objArr2 = callbackQueues;
            Intrinsics.checkNotNull(objArr2);
            addInputQueue = reflectHelper.reflectMethod(objArr2[0], METHOD_ADD_CALLBACK, Long.TYPE, Object.class, Object.class);
            ReflectHelper reflectHelper2 = ReflectHelper.INSTANCE;
            Object[] objArr3 = callbackQueues;
            Intrinsics.checkNotNull(objArr3);
            addAnimationQueue = reflectHelper2.reflectMethod(objArr3[CALLBACK_ANIMATION], METHOD_ADD_CALLBACK, Long.TYPE, Object.class, Object.class);
            ReflectHelper reflectHelper3 = ReflectHelper.INSTANCE;
            Object[] objArr4 = callbackQueues;
            Intrinsics.checkNotNull(objArr4);
            addTraversalQueue = reflectHelper3.reflectMethod(objArr4[CALLBACK_TRAVERSAL], METHOD_ADD_CALLBACK, Long.TYPE, Object.class, Object.class);
            vsyncRecevier = ReflectHelper.INSTANCE.reflectField(choreographer, "mDisplayEventReceiver", null, false);
        }
    }

    private final void startMonitor() {
        if (!isAlive) {
            isAlive = true;
            getMainLooperMonitor().register(looperListener);
            int i = CALLBACK_LAST;
            queueCost = new long[i + 1];
            callbackExist = new boolean[i + 1];
            addCallbackToQueue(0, this);
        }
    }

    private final void stopMonitor() {
        if (isAlive) {
            isAlive = false;
            getMainLooperMonitor().unregister(looperListener);
            looperListener.resetDispatchListener();
        }
    }

    public final boolean isAlive() {
        return isAlive;
    }

    @Override // java.lang.Runnable
    public void run() {
        isVsyncFrame = true;
        doQueueBegin(0);
        addCallbackToQueue(CALLBACK_ANIMATION, new Runnable() { // from class: com.baidu.searchbox.fluency.core.FrameRefreshMonitor$run$1
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                FrameRefreshMonitor.INSTANCE.doQueueEnd(0);
                FrameRefreshMonitor frameRefreshMonitor = FrameRefreshMonitor.INSTANCE;
                i = FrameRefreshMonitor.CALLBACK_ANIMATION;
                frameRefreshMonitor.doQueueBegin(i);
            }
        });
        addCallbackToQueue(CALLBACK_TRAVERSAL, new Runnable() { // from class: com.baidu.searchbox.fluency.core.FrameRefreshMonitor$run$2
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                int i2;
                FrameRefreshMonitor frameRefreshMonitor = FrameRefreshMonitor.INSTANCE;
                i = FrameRefreshMonitor.CALLBACK_ANIMATION;
                frameRefreshMonitor.doQueueEnd(i);
                FrameRefreshMonitor frameRefreshMonitor2 = FrameRefreshMonitor.INSTANCE;
                i2 = FrameRefreshMonitor.CALLBACK_TRAVERSAL;
                frameRefreshMonitor2.doQueueBegin(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doQueueBegin(int i) {
        long[] jArr = queueCost;
        Intrinsics.checkNotNull(jArr);
        jArr[i] = System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doQueueEnd(int i) {
        long[] jArr = queueCost;
        Intrinsics.checkNotNull(jArr);
        long nanoTime = System.nanoTime();
        long[] jArr2 = queueCost;
        Intrinsics.checkNotNull(jArr2);
        jArr[i] = nanoTime - jArr2[i];
        boolean[] zArr = callbackExist;
        Intrinsics.checkNotNull(zArr);
        zArr[i] = false;
    }

    public final void addFrameRefreshObserver(FrameRefreshObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!isAlive) {
            startMonitor();
        }
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public final void removeFrameRefreshObserver(FrameRefreshObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (observers) {
            observers.remove(observer);
            if (observers.isEmpty()) {
                INSTANCE.stopMonitor();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final synchronized void addCallbackToQueue(int i, Runnable runnable) {
        Method method;
        boolean[] zArr = callbackExist;
        Intrinsics.checkNotNull(zArr);
        if (zArr[i]) {
            return;
        }
        if (!isAlive && i == 0) {
            Logcat.INSTANCE.d(TAG, "[addCallbackToQueue] UIThreadMonitor is not alive!");
            return;
        }
        try {
            Object obj = callbackQueueLock;
            Intrinsics.checkNotNull(obj);
            synchronized (obj) {
                if (i == 0) {
                    method = addInputQueue;
                } else if (i == CALLBACK_ANIMATION) {
                    method = addAnimationQueue;
                } else if (i == CALLBACK_TRAVERSAL) {
                    method = addTraversalQueue;
                } else {
                    method = null;
                }
                if (method != null) {
                    Object[] objArr = callbackQueues;
                    Intrinsics.checkNotNull(objArr);
                    method.invoke(objArr[i], -1, runnable, null);
                    boolean[] zArr2 = callbackExist;
                    Intrinsics.checkNotNull(zArr2);
                    zArr2[i] = true;
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            Logcat.INSTANCE.e(TAG, "[addCallbackToQueue] " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchBegin() {
        dispatchTimeNs[0] = System.nanoTime();
        Logcat logcat = Logcat.INSTANCE;
        logcat.d(TAG, "[dispatchBegin] " + dispatchTimeNs[0]);
        synchronized (observers) {
            Iterator<FrameRefreshObserver> it = observers.iterator();
            while (it.hasNext()) {
                FrameRefreshObserver next = it.next();
                if (!next.isDispatchBegin()) {
                    next.dispatchBegin(dispatchTimeNs[0]);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchEnd() {
        long j;
        long j2;
        String str;
        Class<?> cls;
        long j3 = dispatchTimeNs[0];
        if (isVsyncFrame) {
            doQueueEnd(CALLBACK_TRAVERSAL);
            addCallbackToQueue(0, this);
            j = getIntendedFrameTimeNs(j3);
        } else {
            j = j3;
        }
        long nanoTime = System.nanoTime();
        Logcat logcat = Logcat.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("[dispatchEnd], isVsyncFrame: ");
        sb.append(isVsyncFrame);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("dispatchCost: ");
        long j4 = 1000000;
        sb.append((nanoTime - j3) / j4);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("frameCost: ");
        sb.append((nanoTime - j) / j4);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("intendedFrameTimeNs: ");
        sb.append(j);
        sb.append(", startNs: ");
        sb.append(j3);
        sb.append(", endNs: ");
        sb.append(nanoTime);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("inputCost: ");
        long[] jArr = queueCost;
        Intrinsics.checkNotNull(jArr);
        sb.append(jArr[0]);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("animationCost: ");
        long[] jArr2 = queueCost;
        Intrinsics.checkNotNull(jArr2);
        sb.append(jArr2[CALLBACK_ANIMATION]);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("traversalCost: ");
        long[] jArr3 = queueCost;
        Intrinsics.checkNotNull(jArr3);
        sb.append(jArr3[CALLBACK_TRAVERSAL]);
        logcat.d(TAG, sb.toString());
        synchronized (observers) {
            Iterator<FrameRefreshObserver> it = observers.iterator();
            while (it.hasNext()) {
                FrameRefreshObserver next = it.next();
                if (next.isDispatchBegin()) {
                    Activity topActivity = BdBoxActivityManager.getTopActivity();
                    if (topActivity == null || (cls = topActivity.getClass()) == null || (str = cls.getName()) == null) {
                        str = "unknown";
                    }
                    String str2 = str;
                    boolean z = isVsyncFrame;
                    long[] jArr4 = queueCost;
                    Intrinsics.checkNotNull(jArr4);
                    long j5 = jArr4[0];
                    long[] jArr5 = queueCost;
                    Intrinsics.checkNotNull(jArr5);
                    long j6 = jArr5[CALLBACK_ANIMATION];
                    long[] jArr6 = queueCost;
                    Intrinsics.checkNotNull(jArr6);
                    j2 = nanoTime;
                    next.doFrame(str2, j, nanoTime, z, j5, j6, jArr6[CALLBACK_TRAVERSAL]);
                } else {
                    j2 = nanoTime;
                }
                nanoTime = j2;
            }
            Unit unit = Unit.INSTANCE;
        }
        dispatchTimeNs[1] = System.nanoTime();
        synchronized (observers) {
            Iterator<FrameRefreshObserver> it2 = observers.iterator();
            while (it2.hasNext()) {
                FrameRefreshObserver next2 = it2.next();
                if (next2.isDispatchBegin()) {
                    next2.dispatchEnd(dispatchTimeNs[0], dispatchTimeNs[1]);
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
        isVsyncFrame = false;
    }

    private final long getIntendedFrameTimeNs(long j) {
        try {
            Object reflectField = ReflectHelper.INSTANCE.reflectField(vsyncRecevier, "mTimestampNanos", Long.valueOf(j), true);
            if (reflectField != null) {
                return ((Long) reflectField).longValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        } catch (Exception e) {
            Logcat logcat = Logcat.INSTANCE;
            logcat.e(TAG, "[getIntendedFrameTimeNs] " + e.toString());
            return j;
        }
    }
}
