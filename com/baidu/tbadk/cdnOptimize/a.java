package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements CustomMessageTask.CustomRunnable<e> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<e> customMessage) {
        boolean z;
        if (customMessage != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                e data = customMessage.getData();
                if (data == null || data.a == null || data.a.e == null) {
                    return null;
                }
                String str = "";
                if (e.a(data) == null) {
                    if (data.b < data.a.e.size()) {
                        ArrayList<String> arrayList = data.a.e.get(data.b);
                        if (arrayList.size() > 0) {
                            z = false;
                            str = arrayList.get(0);
                        }
                    }
                    z = false;
                } else if (e.a(data).length() <= 0) {
                    return null;
                } else {
                    str = e.a(data);
                    z = true;
                }
                if (str.length() > 0) {
                    data.c = data.f.a(data.a.c, str, data.a.g, data.a.d, e.b(data));
                    data.d = System.currentTimeMillis() - currentTimeMillis;
                    data.e = str;
                    if (z) {
                        e.a(data, str);
                    }
                    return new CustomResponsedMessage<>(2016000, data);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return null;
    }
}
