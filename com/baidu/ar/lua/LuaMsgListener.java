package com.baidu.ar.lua;

import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public interface LuaMsgListener {
    List<String> getMsgKeyListened();

    void onLuaMessage(HashMap<String, Object> hashMap);
}
