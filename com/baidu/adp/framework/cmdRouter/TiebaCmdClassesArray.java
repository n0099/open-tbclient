package com.baidu.adp.framework.cmdRouter;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class TiebaCmdClassesArray {
    public String[] cmdClassesArray = new String[0];

    public Set<String> loadCmdClasses() {
        HashSet hashSet = new HashSet();
        try {
            if (this.cmdClassesArray.length <= 0) {
                return hashSet;
            }
            for (String str : this.cmdClassesArray) {
                hashSet.add(str);
            }
            return hashSet;
        } catch (Throwable th) {
            BdLog.e(th);
            return hashSet;
        }
    }
}
