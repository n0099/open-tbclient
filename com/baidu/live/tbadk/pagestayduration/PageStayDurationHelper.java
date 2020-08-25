package com.baidu.live.tbadk.pagestayduration;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
@Deprecated
/* loaded from: classes7.dex */
public class PageStayDurationHelper {
    public static final String STAT_SOURCE_TRACE_CONNECTORS = "_";

    public static String toSourceTraceString(List<String> list) {
        if (ListUtils.getCount(list) <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        Iterator<String> it = list.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    if (!z2 && !StringUtils.isNull(sb.toString())) {
                        z2 = true;
                    }
                    if (z2) {
                        sb.append(STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    sb.append(next);
                }
                z = z2;
            } else {
                return sb.toString();
            }
        }
    }

    public static List<String> trimToSize(List<String> list, int i) {
        int count = ListUtils.getCount(list);
        if (count > 0 && i >= 0 && count > i) {
            return ListUtils.subList(list, count - i, count);
        }
        return list;
    }
}
