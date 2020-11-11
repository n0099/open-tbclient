package com.baidu.swan.apps.core.j;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class e extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File cOP = arf();

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ void a(c cVar, d dVar) {
        super.a(cVar, dVar);
    }

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ HashMap ard() {
        return super.ard();
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String arc() {
        if (this.cOP.exists()) {
            File file = new File(this.cOP, "preset_list.json");
            if (file.exists()) {
                return com.baidu.swan.c.d.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String nB(String str) {
        if (this.cOP.exists()) {
            File file = new File(this.cOP, str + File.separator + "app_info.json");
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
        if (cVar != null && this.cOP.exists()) {
            File file = new File(this.cOP, cVar.ehG + File.separator + cVar.cOO);
            if (file.exists()) {
                try {
                    if (!a(Channels.newChannel(new FileInputStream(file)), cVar.sign)) {
                        if (DEBUG) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                    } else {
                        File c = c(cVar.category, cVar.ehG, cVar.versionCode);
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

    private File arf() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
