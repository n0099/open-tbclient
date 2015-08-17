package com.baidu.tbadk.core.frameworkData;

import android.support.v4.widget.ExploreByTouchHelper;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class NetAutoPolicyStatic {
    static {
        c cVar = new c(0);
        cVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().addMessageRule(cVar);
        MessageManager.getInstance().addResponsedMessageRule(new d(0));
        e eVar = new e(2000999);
        eVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().registerListener(eVar);
    }
}
