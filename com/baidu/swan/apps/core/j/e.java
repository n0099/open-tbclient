package com.baidu.swan.apps.core.j;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class e extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File cfM = acQ();

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ void a(c cVar, d dVar) {
        super.a(cVar, dVar);
    }

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ HashMap acO() {
        return super.acO();
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String acN() {
        if (this.cfM.exists()) {
            File file = new File(this.cfM, "preset_list.json");
            if (file.exists()) {
                return com.baidu.swan.d.d.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String kj(String str) {
        if (this.cfM.exists()) {
            File file = new File(this.cfM, str + File.separator + "app_info.json");
            if (file.exists()) {
                return com.baidu.swan.d.d.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null && this.cfM.exists()) {
            File file = new File(this.cfM, cVar.dvZ + File.separator + cVar.cfL);
            if (file.exists()) {
                try {
                    if (!a(Channels.newChannel(new FileInputStream(file)), cVar.sign)) {
                        if (DEBUG) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                    } else {
                        File d = d(cVar.category, cVar.dvZ, cVar.versionCode);
                        if (d == null) {
                            if (DEBUG) {
                                Log.e("SdCardPresetController", "获取解压路径失败");
                            }
                        } else {
                            z = a(new BufferedInputStream(new FileInputStream(file)), d);
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

    private File acQ() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
