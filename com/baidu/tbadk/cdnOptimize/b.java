package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<f> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<f> customMessage) {
        boolean z;
        if (customMessage != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                f data = customMessage.getData();
                if (data == null || data.ipListData == null || data.ipListData.BK == null) {
                    return null;
                }
                String str = "";
                if (f.a(data) == null) {
                    if (data.pos < data.ipListData.BK.size()) {
                        ArrayList<String> arrayList = data.ipListData.BK.get(data.pos);
                        if (arrayList.size() > 0) {
                            z = false;
                            str = arrayList.get(0);
                        }
                    }
                    z = false;
                } else if (f.a(data).length() <= 0) {
                    return null;
                } else {
                    str = f.a(data);
                    z = true;
                }
                if (str.length() > 0) {
                    data.isSuccess = data.cdnTachometerModel.a(data.ipListData.imageUrl, str, data.ipListData.BM, data.ipListData.BJ, f.b(data));
                    data.vD = System.currentTimeMillis() - currentTimeMillis;
                    data.cdnIp = str;
                    if (z) {
                        f.a(data, str);
                    }
                    return new CustomResponsedMessage<>(2017000, data);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return null;
    }
}
