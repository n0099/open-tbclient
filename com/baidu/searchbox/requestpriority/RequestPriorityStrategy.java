package com.baidu.searchbox.requestpriority;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class RequestPriorityStrategy {
    public static final int REQUEST_PRIORITY_DELAY_TIME_VALUE = 4000;
    public static final int REQUEST_PRIORITY_INITED = 1;
    public static final int REQUEST_PRIORITY_NOT_INITED = -1;
    public static boolean sRequestPriorityEnabled = false;
    public static int sRequestPrioritySwitchValue = -1;
    public static String sRequestPriorityWhiteList;
    public static volatile ScheduledExecutorService sScheduledExecutorService;
    public static volatile List<Runnable> sWaitingList = new ArrayList();
    public static volatile int sCoreRequestNum = 0;
    public static volatile Set<Integer> sTimeoutRequestSet = new HashSet();

    public static /* synthetic */ int access$110() {
        int i = sCoreRequestNum;
        sCoreRequestNum = i - 1;
        return i;
    }

    public static boolean isRequestPriorityEnabled() {
        RequestPriorityParams requestPriorityParams;
        if (sRequestPrioritySwitchValue == -1) {
            sRequestPrioritySwitchValue = 1;
            IRequestPriorityManager requestPriorityManager = RequestPriorityRuntime.getRequestPriorityManager();
            if (requestPriorityManager == null || (requestPriorityParams = requestPriorityManager.getRequestPriorityParams()) == null) {
                return false;
            }
            String requestPriorityWhitelist = requestPriorityParams.getRequestPriorityWhitelist();
            sRequestPriorityWhiteList = requestPriorityWhitelist;
            sRequestPriorityEnabled = true ^ TextUtils.isEmpty(requestPriorityWhitelist);
        }
        return sRequestPriorityEnabled;
    }

    public static void promoteAndExecute() {
        synchronized (sWaitingList) {
            int size = sWaitingList.size();
            for (int i = 0; i < size; i++) {
                sWaitingList.get(i).run();
            }
            sWaitingList.clear();
        }
    }

    public static ScheduledExecutorService scheduledExecutorService() {
        if (sScheduledExecutorService == null) {
            synchronized (RequestPriorityStrategy.class) {
                if (sScheduledExecutorService == null) {
                    sScheduledExecutorService = new ScheduledThreadPoolExecutor(1);
                }
            }
        }
        return sScheduledExecutorService;
    }

    public static void addToWaitingList(Runnable runnable) {
        synchronized (sWaitingList) {
            sWaitingList.add(runnable);
        }
        if (sCoreRequestNum <= 0) {
            promoteAndExecute();
        }
    }

    public static Object executeSync(IRequestCall iRequestCall) throws Exception {
        if (isCoreRequest(iRequestCall)) {
            scheduleWaitingRequestCalls(iRequestCall);
        } else if (sCoreRequestNum > 0) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            addToWaitingList(new Runnable() { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.1
                @Override // java.lang.Runnable
                public void run() {
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return iRequestCall.priorityExecuteSync();
    }

    public static boolean isCoreRequest(IRequestCall iRequestCall) {
        return sRequestPriorityWhiteList.contains(iRequestCall.getRequestFrom() + "|" + iRequestCall.getRequestSubFrom());
    }

    public static void scheduleWaitingRequestCalls(final IRequestCall iRequestCall) {
        synchronized (IRequestCall.class) {
            sCoreRequestNum++;
        }
        scheduledExecutorService().schedule(new Runnable() { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.4
            @Override // java.lang.Runnable
            public void run() {
                if (!IRequestCall.this.isFinished()) {
                    synchronized (IRequestCall.class) {
                        RequestPriorityStrategy.sTimeoutRequestSet.add(Integer.valueOf(IRequestCall.this.hashCode()));
                        if (RequestPriorityStrategy.sCoreRequestNum > 0) {
                            RequestPriorityStrategy.access$110();
                        }
                    }
                    RequestPriorityStrategy.promoteAndExecute();
                }
            }
        }, 4000L, TimeUnit.MILLISECONDS);
    }

    public static void startPriorityControlled(final IRequestCall iRequestCall) {
        synchronized (IRequestCall.class) {
            sCoreRequestNum++;
        }
        scheduledExecutorService().schedule(new Runnable() { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.5
            @Override // java.lang.Runnable
            public void run() {
                if (!IRequestCall.this.isFinished()) {
                    synchronized (IRequestCall.class) {
                        RequestPriorityStrategy.sTimeoutRequestSet.add(Integer.valueOf(IRequestCall.this.hashCode()));
                        if (RequestPriorityStrategy.sCoreRequestNum > 0) {
                            RequestPriorityStrategy.access$110();
                        }
                    }
                    RequestPriorityStrategy.promoteAndExecute();
                }
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    public static <T> void enqueueWithResponseCallback(final IRequestCall iRequestCall, final T t, final T t2) {
        if (isCoreRequest(iRequestCall)) {
            scheduleWaitingRequestCalls(iRequestCall);
            iRequestCall.priorityEnqueueWithResponseCallback(t, t2);
        } else if (sCoreRequestNum > 0) {
            addToWaitingList(new Runnable() { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.3
                @Override // java.lang.Runnable
                public void run() {
                    IRequestCall.this.priorityEnqueueWithResponseCallback(t, t2);
                }
            });
        } else {
            iRequestCall.priorityEnqueueWithResponseCallback(t, t2);
        }
    }

    public static <T> void enqueueWithStatResponseCallback(final IRequestCall iRequestCall, final T t, final T t2) {
        if (isCoreRequest(iRequestCall)) {
            scheduleWaitingRequestCalls(iRequestCall);
            iRequestCall.priorityEnqueueWithStatResponseCallback(t, t2);
        } else if (sCoreRequestNum > 0) {
            addToWaitingList(new Runnable() { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.2
                @Override // java.lang.Runnable
                public void run() {
                    IRequestCall.this.priorityEnqueueWithStatResponseCallback(t, t2);
                }
            });
        } else {
            iRequestCall.priorityEnqueueWithStatResponseCallback(t, t2);
        }
    }

    public static void promoteAndExecuteIfNeeded(IRequestCall iRequestCall) {
        if (isRequestPriorityEnabled() && isCoreRequest(iRequestCall)) {
            synchronized (IRequestCall.class) {
                if (sTimeoutRequestSet.contains(Integer.valueOf(iRequestCall.hashCode()))) {
                    sTimeoutRequestSet.remove(Integer.valueOf(iRequestCall.hashCode()));
                } else if (sCoreRequestNum > 0) {
                    sCoreRequestNum--;
                }
            }
            if (sCoreRequestNum <= 0) {
                promoteAndExecute();
            }
        }
    }

    public static void stopPriorityControlled(IRequestCall iRequestCall) {
        synchronized (IRequestCall.class) {
            if (sTimeoutRequestSet.contains(Integer.valueOf(iRequestCall.hashCode()))) {
                sTimeoutRequestSet.remove(Integer.valueOf(iRequestCall.hashCode()));
            } else if (sCoreRequestNum > 0) {
                sCoreRequestNum--;
            }
        }
        if (sCoreRequestNum <= 0) {
            promoteAndExecute();
        }
    }
}
