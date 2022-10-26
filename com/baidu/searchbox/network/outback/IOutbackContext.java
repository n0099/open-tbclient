package com.baidu.searchbox.network.outback;

import android.content.Context;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import java.util.HashMap;
/* loaded from: classes2.dex */
public interface IOutbackContext {
    CallFactory.CallFactoryProducer getBackupCallFactoryProducer();

    IOutbackClientIPProvider getClientIPProvider();

    Context getContext();

    CallFactory.CallFactoryProducer getDefaultCallFactoryProducer();

    IAdditionalRecord getIAdditionalRecord();

    HashMap getOutbackEngines();
}
