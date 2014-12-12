package com.baidu.tbadk.core.frameworkData;

import android.support.v4.widget.ExploreByTouchHelper;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class NetAutoPolicyStatic {
    static {
        b bVar = new b(0);
        bVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().addMessageRule(bVar);
        MessageManager.getInstance().addResponsedMessageRule(new c(0));
        d dVar = new d(2000999);
        dVar.setPriority(ExploreByTouchHelper.INVALID_ID);
        MessageManager.getInstance().registerListener(dVar);
    }
}
