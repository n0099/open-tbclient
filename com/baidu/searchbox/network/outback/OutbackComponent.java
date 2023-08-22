package com.baidu.searchbox.network.outback;

import android.content.Context;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import com.baidu.tieba.hk1;
import com.baidu.tieba.ik1;
import com.baidu.tieba.kk1;
/* loaded from: classes4.dex */
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
        kk1<IOutbackContext> kk1Var = this.componentHolder.outbackContextHolder;
        if (kk1Var != null && kk1Var.get() != null) {
            return this.componentHolder.outbackContextHolder.get().getIAdditionalRecord();
        }
        throw new IllegalStateException("No Context provided!");
    }

    public IOutbackClientIPProvider getClientIPProvider() {
        kk1<IOutbackContext> kk1Var = this.componentHolder.outbackContextHolder;
        if (kk1Var != null && kk1Var.get() != null) {
            return this.componentHolder.outbackContextHolder.get().getClientIPProvider();
        }
        throw new IllegalStateException("No Context provided!");
    }

    public Context getContext() {
        kk1<IOutbackContext> kk1Var = this.componentHolder.outbackContextHolder;
        if (kk1Var != null && kk1Var.get() != null) {
            return this.componentHolder.outbackContextHolder.get().getContext();
        }
        throw new IllegalStateException("No Context provided!");
    }

    public boolean isCallFactoryProducerAvailable() {
        IOutbackContext iOutbackContext;
        kk1<IOutbackContext> kk1Var = this.componentHolder.outbackContextHolder;
        if (kk1Var == null || (iOutbackContext = kk1Var.get()) == null || iOutbackContext.getDefaultCallFactoryProducer() == null) {
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
        kk1<IOutbackContext> kk1Var = this.componentHolder.outbackContextHolder;
        if (kk1Var != null && (iOutbackContext = kk1Var.get()) != null) {
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
            outbackComponentHolder.outbackContextHolder = new ik1();
        }
        this.componentHolder.outbackContextHolder.a(new hk1<IOutbackContext>() { // from class: com.baidu.searchbox.network.outback.OutbackComponent.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.hk1
            public IOutbackContext get() {
                return iOutbackContext;
            }
        });
        return this;
    }
}
