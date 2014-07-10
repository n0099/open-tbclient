package com.baidu.kirin;

import com.baidu.kirin.objects.KirinCheckState;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface CheckUpdateListener {
    void checkUpdateResponse(KirinCheckState kirinCheckState, HashMap<String, String> hashMap);
}
