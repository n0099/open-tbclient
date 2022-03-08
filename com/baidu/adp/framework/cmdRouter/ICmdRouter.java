package com.baidu.adp.framework.cmdRouter;

import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public interface ICmdRouter {
    Map<String, String> getCmdRouterMap();

    Map<String, ArrayList<String>> getConfigRouterMap();
}
