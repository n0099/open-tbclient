package com.baidu.swan.apps.core.j;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class e extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File bZn = aaG();

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ void a(c cVar, d dVar) {
        super.a(cVar, dVar);
    }

    @Override // com.baidu.swan.apps.core.j.b
    public /* bridge */ /* synthetic */ HashMap aaE() {
        return super.aaE();
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String aaD() {
        if (this.bZn.exists()) {
            File file = new File(this.bZn, "preset_list.json");
            if (file.exists()) {
                return com.baidu.swan.e.d.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected String jI(String str) {
        if (this.bZn.exists()) {
            File file = new File(this.bZn, str + File.separator + "app_info.json");
            if (file.exists()) {
                return com.baidu.swan.e.d.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.j.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null && this.bZn.exists()) {
            File file = new File(this.bZn, cVar.dlx + File.separator + cVar.bZm);
            if (file.exists()) {
                try {
                    if (!a(Channels.newChannel(new FileInputStream(file)), cVar.sign)) {
                        if (DEBUG) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                    } else {
                        File d = d(cVar.category, cVar.dlx, cVar.versionCode);
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

    private File aaG() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
