package com.baidu.ar;

import java.util.HashMap;
/* loaded from: classes.dex */
public interface DefinedLuaListener {
    void onOpenUrl(String str, int i, HashMap<String, Object> hashMap);

    void onRequireSwitchCamera(int i);
}
