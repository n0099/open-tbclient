package com.baidu.ar.lua;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.DefinedLuaListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private LuaMsgListener ci;
    private b f;
    private c qR;
    private DefinedLuaListener sb;

    public e(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f = bVar;
        ea();
        if (this.ci == null) {
            this.ci = new LuaMsgListener() { // from class: com.baidu.ar.lua.e.1
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    return Arrays.asList("id", LuaMessageHelper.KEY_EVENT_NAME);
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if (e.this.sb == null || e.this.l(hashMap)) {
                        return;
                    }
                    e.this.m(hashMap);
                }
            };
        }
        if (bVar.dZ() != null) {
            bVar.dZ().addLuaMsgListener(this.ci);
        }
    }

    private void ea() {
        this.qR = new c() { // from class: com.baidu.ar.lua.e.2
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i != 1301 || e.this.sb == null) {
                    return;
                }
                int intValue = ((Integer) hashMap.get("type")).intValue();
                e.this.sb.onOpenUrl((String) hashMap.get("url"), intValue, hashMap);
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return Arrays.asList(1301);
            }
        };
        this.f.c(this.qR);
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
            this.sb.onRequireSwitchCamera(1);
        } else if ("back".equals(str2)) {
            this.sb.onRequireSwitchCamera(0);
        } else {
            this.sb.onRequireSwitchCamera(-1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(HashMap<String, Object> hashMap) {
        int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
        Log.d("LuaMsgHelper", "switchCameraById id = " + a);
        if (a == 10202) {
            this.sb.onRequireSwitchCamera(-1);
            return true;
        }
        return false;
    }

    public void release() {
        if (this.f != null) {
            if (this.ci != null) {
                this.f.dZ().removeLuaMsgListener(this.ci);
                this.ci = null;
            }
            if (this.qR != null) {
                this.f.d(this.qR);
                this.qR = null;
            }
            this.f = null;
        }
        this.sb = null;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.sb = definedLuaListener;
    }
}
