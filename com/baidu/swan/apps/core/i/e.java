package com.baidu.swan.apps.core.i;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class e extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File bmc = Nj();

    @Override // com.baidu.swan.apps.core.i.b
    public /* bridge */ /* synthetic */ HashMap Nh() {
        return super.Nh();
    }

    @Override // com.baidu.swan.apps.core.i.b
    public /* bridge */ /* synthetic */ void a(c cVar, d dVar) {
        super.a(cVar, dVar);
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected String Ng() {
        if (this.bmc.exists()) {
            File file = new File(this.bmc, "preset_list.json");
            if (file.exists()) {
                return com.baidu.swan.d.c.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected String gX(String str) {
        if (this.bmc.exists()) {
            File file = new File(this.bmc, str + File.separator + "app_info.json");
            if (file.exists()) {
                return com.baidu.swan.d.c.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected boolean a(c cVar) {
        boolean z = false;
        if (cVar != null && this.bmc.exists()) {
            File file = new File(this.bmc, cVar.cwO + File.separator + cVar.bmb);
            if (file.exists()) {
                try {
                    if (!a(Channels.newChannel(new FileInputStream(file)), cVar.sign)) {
                        if (DEBUG) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                    } else {
                        File d = d(cVar.category, cVar.cwO, cVar.versionCode);
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

    private File Nj() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
