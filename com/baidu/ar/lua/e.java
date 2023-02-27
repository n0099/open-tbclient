package com.baidu.ar.lua;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.DefinedLuaListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    public LuaMsgListener cc;
    public b f;
    public c rN;
    public DefinedLuaListener sX;

    public e(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f = bVar;
        fl();
        if (this.cc == null) {
            this.cc = new LuaMsgListener() { // from class: com.baidu.ar.lua.e.1
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    return Arrays.asList("id", "event_name");
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if (e.this.sX == null || e.this.j(hashMap)) {
                        return;
                    }
                    e.this.k(hashMap);
                }
            };
        }
        if (bVar.fk() != null) {
            bVar.fk().addLuaMsgListener(this.cc);
        }
    }

    private void fl() {
        c cVar = new c() { // from class: com.baidu.ar.lua.e.2
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i != 1301 || e.this.sX == null) {
                    return;
                }
                int intValue = ((Integer) hashMap.get("type")).intValue();
                e.this.sX.onOpenUrl((String) hashMap.get("url"), intValue, hashMap);
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return Arrays.asList(1301);
            }
        };
        this.rN = cVar;
        this.f.c(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("event_name");
        if (TextUtils.isEmpty(str) || !"camera_switch".equals(str)) {
            return false;
        }
        String str2 = (String) hashMap.get("camera_action");
        Log.d("LuaMsgHelper", "swichCameraByEvent cameraFace = " + str2);
        if ("front".equals(str2)) {
            this.sX.onRequireSwitchCamera(1);
        } else if ("back".equals(str2)) {
            this.sX.onRequireSwitchCamera(0);
        } else {
            this.sX.onRequireSwitchCamera(-1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(HashMap<String, Object> hashMap) {
        int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
        Log.d("LuaMsgHelper", "switchCameraById id = " + a);
        if (a == 10202) {
            this.sX.onRequireSwitchCamera(-1);
            return true;
        }
        return false;
    }

    public void release() {
        b bVar = this.f;
        if (bVar != null) {
            if (this.cc != null) {
                bVar.fk().removeLuaMsgListener(this.cc);
                this.cc = null;
            }
            c cVar = this.rN;
            if (cVar != null) {
                this.f.d(cVar);
                this.rN = null;
            }
            this.f = null;
        }
        this.sX = null;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.sX = definedLuaListener;
    }
}
