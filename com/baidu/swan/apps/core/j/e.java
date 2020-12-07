package com.baidu.swan.apps.core.j;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class e extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File cTY = atF();

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ void a(c cVar, d dVar) {
        super.a(cVar, dVar);
    }

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ HashMap atD() {
        return super.atD();
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String atC() {
        if (this.cTY.exists()) {
            File file = new File(this.cTY, "preset_list.json");
            if (file.exists()) {
                return com.baidu.swan.c.d.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String oc(String str) {
        if (this.cTY.exists()) {
            File file = new File(this.cTY, str + File.separator + "app_info.json");
            if (file.exists()) {
                return com.baidu.swan.c.d.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null && this.cTY.exists()) {
            File file = new File(this.cTY, cVar.emZ + File.separator + cVar.cTX);
            if (file.exists()) {
                try {
                    if (!a(Channels.newChannel(new FileInputStream(file)), cVar.sign)) {
                        if (DEBUG) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                    } else {
                        File c = c(cVar.category, cVar.emZ, cVar.versionCode);
                        if (c == null) {
                            if (DEBUG) {
                                Log.e("SdCardPresetController", "获取解压路径失败");
                            }
                        } else {
                            z = a(new BufferedInputStream(new FileInputStream(file)), c);
                        }
                    }
                } catch (IOException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    private File atF() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
