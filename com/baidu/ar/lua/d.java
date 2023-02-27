package com.baidu.ar.lua;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d implements c {
    public List<LuaMsgListener> sW = Collections.synchronizedList(new ArrayList());

    @Override // com.baidu.ar.lua.c
    public synchronized void a(int i, int i2, HashMap<String, Object> hashMap) {
        List<String> msgKeyListened;
        if (this.sW != null && hashMap != null) {
            for (int i3 = 0; i3 < this.sW.size(); i3++) {
                LuaMsgListener luaMsgListener = this.sW.get(i3);
                if (luaMsgListener != null && (msgKeyListened = luaMsgListener.getMsgKeyListened()) != null) {
                    for (int i4 = 0; i4 < msgKeyListened.size(); i4++) {
                        String str = msgKeyListened.get(i4);
                        if (!TextUtils.isEmpty(str) && hashMap.get(str) != null) {
                            luaMsgListener.onLuaMessage(hashMap);
                        }
                    }
                }
            }
        }
    }

    public synchronized boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.sW == null) {
            return false;
        }
        for (LuaMsgListener luaMsgListener2 : this.sW) {
            if (luaMsgListener2 != null && luaMsgListener2.equals(luaMsgListener)) {
                return false;
            }
        }
        com.baidu.ar.h.b.c("LuaMsgBridge", "addLuaMsgListener luaMsgListener = " + luaMsgListener.hashCode());
        return this.sW.add(luaMsgListener);
    }

    public synchronized void destroy() {
        if (this.sW != null) {
            this.sW.clear();
            this.sW = null;
        }
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(1901);
    }

    public synchronized boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.sW == null) {
            return false;
        }
        for (LuaMsgListener luaMsgListener2 : this.sW) {
            if (luaMsgListener2 != null && luaMsgListener2.equals(luaMsgListener)) {
                com.baidu.ar.h.b.c("LuaMsgBridge", "removeLuaMsgListener luaMsgListener = " + luaMsgListener.hashCode());
                return this.sW.remove(luaMsgListener2);
            }
        }
        return false;
    }
}
