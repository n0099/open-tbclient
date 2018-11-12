package com.baidu.ar.component.c;

import android.content.Context;
import com.baidu.ar.ARController;
import com.baidu.ar.tts.TTSCallback;
import com.baidu.ar.tts.TTSManager;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeTTSDispatcher;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private static a a;
    private ARController b;
    private Context c;
    private HashMap<String, Object> d;

    private a(Context context, ARController aRController) {
        this.b = aRController;
        this.c = context;
    }

    public static a a(Context context, ARController aRController) {
        if (a == null) {
            a = new a(context, aRController);
        }
        return a;
    }

    private void b(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get(AiAppUnitedSchemeTTSDispatcher.MODULE_TTS);
        String valueOf = String.valueOf(hashMap.get(TTSManager.TTS_CONFIG_KEY_SPEAKER));
        String valueOf2 = String.valueOf(hashMap.get("speed"));
        String valueOf3 = String.valueOf(hashMap.get("volume"));
        if (str != null) {
            TTSManager.getTTSManager(this.c).initTts(valueOf, valueOf2, valueOf3);
            TTSManager.getTTSManager(this.c).speak(str, new TTSCallback() { // from class: com.baidu.ar.component.c.a.1
                @Override // com.baidu.ar.tts.TTSCallback
                public void onTtsError(int i) {
                    a.this.d = new HashMap();
                    a.this.d.put("id", 2005);
                    a.this.d.put("status", 3);
                    a.this.d.put("error_code", Integer.valueOf(i));
                    a.this.b.sendMessage2Lua(a.this.d);
                }

                @Override // com.baidu.ar.tts.TTSCallback
                public void onTtsFinish() {
                    a.this.d = new HashMap();
                    a.this.d.put("id", 2005);
                    a.this.d.put("status", 2);
                    a.this.b.sendMessage2Lua(a.this.d);
                }

                @Override // com.baidu.ar.tts.TTSCallback
                public void onTtsStarted() {
                    a.this.d = new HashMap();
                    a.this.d.put("id", 2005);
                    a.this.d.put("status", 1);
                    a.this.b.sendMessage2Lua(a.this.d);
                }
            });
        }
    }

    public void a() {
        TTSManager.getTTSManager(this.c).stop();
    }

    public void a(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            switch (MsgParamsUtil.obj2Int(hashMap.get("id"), -1)) {
                case 2005:
                    b(hashMap);
                    return;
                case 2006:
                    a();
                    return;
                case 2007:
                    b();
                    return;
                case 2008:
                    c();
                    return;
                default:
                    return;
            }
        }
    }

    public void b() {
        TTSManager.getTTSManager(this.c).pause();
    }

    public void c() {
        TTSManager.getTTSManager(this.c).resume();
    }

    public void d() {
        TTSManager.getTTSManager(this.c).stop();
        TTSManager.getTTSManager(this.c).release();
        this.c = null;
        a = null;
    }
}
