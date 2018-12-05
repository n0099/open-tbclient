package com.baidu.searchbox.ng.ai.apps.core.container.init;

import android.content.Context;
import com.baidu.browser.sailor.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class NgWebViewInitHelper implements NgWebViewInitListener {
    private static final boolean DEBUG = false;
    public static final String INIT_BWEBKIT_APPID = "tieba";
    private static final String TAG = "NgWebViewInitHelper";
    private Context mContext;
    private volatile boolean mIsLoaded;
    private InitListenerAdapter mListenerAdapter;
    private ArrayList<NgWebViewInitListener> mListeners;
    private final Lock mLock;
    private Executor mThreadPoolExecutor;

    private NgWebViewInitHelper() {
        this.mListeners = new ArrayList<>();
        this.mLock = new ReentrantLock();
        this.mIsLoaded = false;
        this.mListenerAdapter = new InitListenerAdapter(this);
        a.qn().a(this.mListenerAdapter);
        this.mThreadPoolExecutor = Executors.newSingleThreadExecutor();
        this.mContext = AppRuntime.getAppContext();
    }

    public static NgWebViewInitHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void initBWebkit() {
        if (!isLoaded()) {
            this.mThreadPoolExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    NgWebViewInitHelper.this.doInitBWebKit();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInitBWebKit() {
        if (!isLoaded()) {
            a.qn().init(this.mContext, null, AiAppsRuntime.getAiAppAccountRuntime().getUid(this.mContext));
            a.qn().aA(false);
            a.qn().j(INIT_BWEBKIT_APPID, false);
            a.qn().qq().aB(true);
        }
    }

    public void addInitListener(NgWebViewInitListener ngWebViewInitListener) {
        try {
            this.mLock.lock();
            if (ngWebViewInitListener != null) {
                if (!this.mListeners.contains(ngWebViewInitListener)) {
                    this.mListeners.add(ngWebViewInitListener);
                }
                if (isLoaded()) {
                    notifyAllListeners();
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void removeInitListener(NgWebViewInitListener ngWebViewInitListener) {
        try {
            this.mLock.lock();
            if (ngWebViewInitListener != null && this.mListeners.contains(ngWebViewInitListener)) {
                this.mListeners.remove(ngWebViewInitListener);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    private void notifyAllListeners() {
        try {
            this.mLock.lock();
            Iterator<NgWebViewInitListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                NgWebViewInitListener next = it.next();
                if (next != null) {
                    next.onInitFinished();
                }
            }
            this.mListeners.clear();
            if (this.mListenerAdapter != null) {
                a.qn().b(this.mListenerAdapter);
                this.mListenerAdapter = null;
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean isLoaded() {
        boolean z;
        try {
            this.mLock.lock();
            if (!this.mIsLoaded) {
                if (!a.qn().qp()) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitListener
    public void onInitFinished() {
        try {
            this.mLock.lock();
            this.mIsLoaded = true;
            notifyAllListeners();
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static final NgWebViewInitHelper INSTANCE = new NgWebViewInitHelper();

        private SingletonHolder() {
        }
    }
}
