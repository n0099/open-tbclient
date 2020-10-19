package com.baidu.ar.lua;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.DefinedLuaListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class e {
    private LuaMsgListener bZ;
    private b f;
    private c rw;
    private DefinedLuaListener sG;

    public e(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f = bVar;
        fm();
        if (this.bZ == null) {
            this.bZ = new LuaMsgListener() { // from class: com.baidu.ar.lua.e.1
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    return Arrays.asList("id", LuaMessageHelper.KEY_EVENT_NAME);
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if (e.this.sG == null || e.this.j(hashMap)) {
                        return;
                    }
                    e.this.k(hashMap);
                }
            };
        }
        if (bVar.fl() != null) {
            bVar.fl().addLuaMsgListener(this.bZ);
        }
    }

    private void fm() {
        this.rw = new c() { // from class: com.baidu.ar.lua.e.2
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i != 1301 || e.this.sG == null) {
                    return;
                }
                int intValue = ((Integer) hashMap.get("type")).intValue();
                e.this.sG.onOpenUrl((String) hashMap.get("url"), intValue, hashMap);
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return Arrays.asList(1301);
            }
        };
        this.f.c(this.rw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
        if (TextUtils.isEmpty(str) || !"camera_switch".equals(str)) {
            return false;
        }
        String str2 = (String) hashMap.get("camera_action");
        Log.d("LuaMsgHelper", "swichCameraByEvent cameraFace = " + str2);
        if ("front".equals(str2)) {
            this.sG.onRequireSwitchCamera(1);
        } else if ("back".equals(str2)) {
            this.sG.onRequireSwitchCamera(0);
        } else {
            this.sG.onRequireSwitchCamera(-1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(HashMap<String, Object> hashMap) {
        int a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
        Log.d("LuaMsgHelper", "switchCameraById id = " + a2);
        if (a2 == 10202) {
            this.sG.onRequireSwitchCamera(-1);
            return true;
        }
        return false;
    }

    public void release() {
        if (this.f != null) {
            if (this.bZ != null) {
                this.f.fl().removeLuaMsgListener(this.bZ);
                this.bZ = null;
            }
            if (this.rw != null) {
                this.f.d(this.rw);
                this.rw = null;
            }
            this.f = null;
        }
        this.sG = null;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.sG = definedLuaListener;
    }
}
