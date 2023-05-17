package com.baidu.searchbox.network.outback.manager;

import android.content.Context;
import com.baidu.searchbox.network.outback.IOutbackClientIPProvider;
import com.baidu.searchbox.network.outback.IOutbackContext;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public final class HttpEngineRegister {
    public static void register(final Context context, final String str, final String str2, List<CallFactory.CallFactoryProducer> list, final IOutbackClientIPProvider iOutbackClientIPProvider, final IAdditionalRecord iAdditionalRecord) {
        final HashMap hashMap = new HashMap();
        if (!list.isEmpty()) {
            for (CallFactory.CallFactoryProducer callFactoryProducer : list) {
                hashMap.put(callFactoryProducer.getEngineName(), callFactoryProducer);
            }
            OutbackComponent.getInstance().setOutbackContext(new IOutbackContext() { // from class: com.baidu.searchbox.network.outback.manager.HttpEngineRegister.1
                @Override // com.baidu.searchbox.network.outback.IOutbackContext
                public CallFactory.CallFactoryProducer getBackupCallFactoryProducer() {
                    if (!hashMap.containsKey(str2)) {
                        return getDefaultCallFactoryProducer();
                    }
                    return (CallFactory.CallFactoryProducer) hashMap.get(str2);
                }

                @Override // com.baidu.searchbox.network.outback.IOutbackContext
                public IOutbackClientIPProvider getClientIPProvider() {
                    return iOutbackClientIPProvider;
                }

                @Override // com.baidu.searchbox.network.outback.IOutbackContext
                public Context getContext() {
                    return context;
                }

                @Override // com.baidu.searchbox.network.outback.IOutbackContext
                public CallFactory.CallFactoryProducer getDefaultCallFactoryProducer() {
                    if (hashMap.containsKey(str)) {
                        return (CallFactory.CallFactoryProducer) hashMap.get(str);
                    }
                    throw new IllegalStateException("No CallFactory producer available!");
                }

                @Override // com.baidu.searchbox.network.outback.IOutbackContext
                public IAdditionalRecord getIAdditionalRecord() {
                    return iAdditionalRecord;
                }

                @Override // com.baidu.searchbox.network.outback.IOutbackContext
                public HashMap<String, CallFactory.CallFactoryProducer> getOutbackEngines() {
                    return hashMap;
                }
            });
            return;
        }
        throw new IllegalStateException("OutbackEngine is null!");
    }
}
