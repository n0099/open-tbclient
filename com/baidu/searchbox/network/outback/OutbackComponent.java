package com.baidu.searchbox.network.outback;

import android.content.Context;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import com.baidu.tieba.aj1;
import com.baidu.tieba.bj1;
import com.baidu.tieba.dj1;
/* loaded from: classes2.dex */
public class OutbackComponent {
    public static volatile OutbackComponent sInstance;
    public OutbackComponentHolder componentHolder = new OutbackComponentHolder();

    public static OutbackComponent getInstance() {
        if (sInstance == null) {
            synchronized (OutbackComponent.class) {
                if (sInstance == null) {
                    sInstance = new OutbackComponent();
                }
            }
        }
        return sInstance;
    }

    public IAdditionalRecord getAdditionalRecord() {
        dj1<IOutbackContext> dj1Var = this.componentHolder.outbackContextHolder;
        if (dj1Var != null && dj1Var.get() != null) {
            return this.componentHolder.outbackContextHolder.get().getIAdditionalRecord();
        }
        throw new IllegalStateException("No Context provided!");
    }

    public IOutbackClientIPProvider getClientIPProvider() {
        dj1<IOutbackContext> dj1Var = this.componentHolder.outbackContextHolder;
        if (dj1Var != null && dj1Var.get() != null) {
            return this.componentHolder.outbackContextHolder.get().getClientIPProvider();
        }
        throw new IllegalStateException("No Context provided!");
    }

    public Context getContext() {
        dj1<IOutbackContext> dj1Var = this.componentHolder.outbackContextHolder;
        if (dj1Var != null && dj1Var.get() != null) {
            return this.componentHolder.outbackContextHolder.get().getContext();
        }
        throw new IllegalStateException("No Context provided!");
    }

    public boolean isCallFactoryProducerAvailable() {
        IOutbackContext iOutbackContext;
        dj1<IOutbackContext> dj1Var = this.componentHolder.outbackContextHolder;
        if (dj1Var == null || (iOutbackContext = dj1Var.get()) == null || iOutbackContext.getDefaultCallFactoryProducer() == null) {
            return false;
        }
        return true;
    }

    public CallFactory chooseCallFactory(String str, CallFactoryParams callFactoryParams) {
        CallFactory.CallFactoryProducer callFactoryProducer;
        if (!isRightEngine(str)) {
            callFactoryProducer = this.componentHolder.outbackContextHolder.get().getDefaultCallFactoryProducer();
        } else {
            callFactoryProducer = this.componentHolder.outbackContextHolder.get().getOutbackEngines().get(str);
        }
        return callFactoryProducer.produceCallFactory(callFactoryParams);
    }

    public CallFactory getBackupCallFactory(CallFactoryParams callFactoryParams) {
        return this.componentHolder.outbackContextHolder.get().getBackupCallFactoryProducer().produceCallFactory(callFactoryParams);
    }

    public boolean isRightEngine(String str) {
        IOutbackContext iOutbackContext;
        dj1<IOutbackContext> dj1Var = this.componentHolder.outbackContextHolder;
        if (dj1Var != null && (iOutbackContext = dj1Var.get()) != null) {
            return iOutbackContext.getOutbackEngines().containsKey(str);
        }
        return false;
    }

    public CallFactory newCallFactory(CallFactoryParams callFactoryParams) {
        if (isCallFactoryProducerAvailable()) {
            return this.componentHolder.outbackContextHolder.get().getDefaultCallFactoryProducer().produceCallFactory(callFactoryParams);
        }
        throw new IllegalStateException("No CallFactory producer available!");
    }

    public OutbackComponent setOutbackContext(final IOutbackContext iOutbackContext) {
        OutbackComponentHolder outbackComponentHolder = this.componentHolder;
        if (outbackComponentHolder.outbackContextHolder == null) {
            outbackComponentHolder.outbackContextHolder = new bj1();
        }
        this.componentHolder.outbackContextHolder.a(new aj1<IOutbackContext>() { // from class: com.baidu.searchbox.network.outback.OutbackComponent.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.aj1
            public IOutbackContext get() {
                return iOutbackContext;
            }
        });
        return this;
    }
}
