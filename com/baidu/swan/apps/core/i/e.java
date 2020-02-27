package com.baidu.swan.apps.core.i;

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
    private File brb = PT();

    @Override // com.baidu.swan.apps.core.i.b
    public /* bridge */ /* synthetic */ HashMap PR() {
        return super.PR();
    }

    @Override // com.baidu.swan.apps.core.i.b
    public /* bridge */ /* synthetic */ void a(c cVar, d dVar) {
        super.a(cVar, dVar);
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected String PQ() {
        if (this.brb.exists()) {
            File file = new File(this.brb, "preset_list.json");
            if (file.exists()) {
                return com.baidu.swan.d.c.readFileData(file);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.core.i.b
    protected String hp(String str) {
        if (this.brb.exists()) {
            File file = new File(this.brb, str + File.separator + "app_info.json");
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
        if (cVar != null && this.brb.exists()) {
            File file = new File(this.brb, cVar.cAX + File.separator + cVar.bra);
            if (file.exists()) {
                try {
                    if (!a(Channels.newChannel(new FileInputStream(file)), cVar.sign)) {
                        if (DEBUG) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                    } else {
                        File d = d(cVar.category, cVar.cAX, cVar.versionCode);
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

    private File PT() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
