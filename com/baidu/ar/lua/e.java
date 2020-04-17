package com.baidu.ar.lua;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.DefinedLuaListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private LuaMsgListener bV;
    private b e;
    private c qs;
    private DefinedLuaListener rC;

    public e(b bVar) {
        if (bVar == null) {
            return;
        }
        this.e = bVar;
        dK();
        if (this.bV == null) {
            this.bV = new LuaMsgListener() { // from class: com.baidu.ar.lua.e.1
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    return Arrays.asList("id", LuaMessageHelper.KEY_EVENT_NAME);
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if (e.this.rC == null || e.this.l(hashMap)) {
                        return;
                    }
                    e.this.m(hashMap);
                }
            };
        }
        if (bVar.dJ() != null) {
            bVar.dJ().addLuaMsgListener(this.bV);
        }
    }

    private void dK() {
        this.qs = new c() { // from class: com.baidu.ar.lua.e.2
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i != 1301 || e.this.rC == null) {
                    return;
                }
                int intValue = ((Integer) hashMap.get("type")).intValue();
                e.this.rC.onOpenUrl((String) hashMap.get("url"), intValue, hashMap);
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return Arrays.asList(1301);
            }
        };
        this.e.c(this.qs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
        if (TextUtils.isEmpty(str) || !"camera_switch".equals(str)) {
            return false;
        }
        String str2 = (String) hashMap.get("camera_action");
        Log.d("LuaMsgHelper", "swichCameraByEvent cameraFace = " + str2);
        if ("front".equals(str2)) {
            this.rC.onRequireSwitchCamera(1);
        } else if ("back".equals(str2)) {
            this.rC.onRequireSwitchCamera(0);
        } else {
            this.rC.onRequireSwitchCamera(-1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(HashMap<String, Object> hashMap) {
        int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
        Log.d("LuaMsgHelper", "switchCameraById id = " + a);
        if (a == 10202) {
            this.rC.onRequireSwitchCamera(-1);
            return true;
        }
        return false;
    }

    public void release() {
        if (this.e != null) {
            if (this.bV != null) {
                this.e.dJ().removeLuaMsgListener(this.bV);
                this.bV = null;
            }
            if (this.qs != null) {
                this.e.d(this.qs);
                this.qs = null;
            }
            this.e = null;
        }
        this.rC = null;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.rC = definedLuaListener;
    }
}
