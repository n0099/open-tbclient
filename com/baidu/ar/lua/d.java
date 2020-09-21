package com.baidu.ar.lua;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class d implements c {
    private List<LuaMsgListener> sF = Collections.synchronizedList(new ArrayList());

    @Override // com.baidu.ar.lua.c
    public synchronized void a(int i, int i2, HashMap<String, Object> hashMap) {
        List<String> msgKeyListened;
        if (this.sF != null && hashMap != null) {
            for (int i3 = 0; i3 < this.sF.size(); i3++) {
                LuaMsgListener luaMsgListener = this.sF.get(i3);
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
        com.baidu.ar.g.b.c("LuaMsgBridge", "addLuaMsgListener luaMsgListener = " + r4.hashCode());
        r0 = r3.sF.add(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        boolean add;
        if (this.sF != null) {
            Iterator<LuaMsgListener> it = this.sF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                LuaMsgListener next = it.next();
                if (next != null && next.equals(luaMsgListener)) {
                    add = false;
                    break;
                }
            }
        } else {
            add = false;
        }
        return add;
    }

    public synchronized void destroy() {
        if (this.sF != null) {
            this.sF.clear();
            this.sF = null;
        }
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
        com.baidu.ar.g.b.c("LuaMsgBridge", "removeLuaMsgListener luaMsgListener = " + r5.hashCode());
        r0 = r4.sF.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        boolean z;
        if (this.sF != null) {
            Iterator<LuaMsgListener> it = this.sF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                LuaMsgListener next = it.next();
                if (next != null && next.equals(luaMsgListener)) {
                    break;
                }
            }
        } else {
            z = false;
        }
        return z;
    }
}
