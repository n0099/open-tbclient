package com.baidu.swan.uuid.a;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes5.dex */
public class e implements b<String> {
    private Context mContext;

    public e(Context context) {
        if (context == null) {
            throw new RuntimeException("context can not be null");
        }
        this.mContext = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    public void put(String str) {
        zm(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    /* renamed from: aMx */
    public String get() {
        return beq();
    }

    @Override // com.baidu.swan.uuid.a.b
    public boolean ben() {
        return !new File(this.mContext.getFilesDir(), "libuuid.so").exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zm(String str) {
        FileOutputStream fileOutputStream;
        File file = new File(this.mContext.getFilesDir(), "libuuid.so");
        boolean z = Build.VERSION.SDK_INT >= 24;
        try {
            fileOutputStream = this.mContext.openFileOutput("libuuid.so", z ? 0 : 1);
            try {
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    com.baidu.swan.uuid.b.a.closeSafely(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.uuid.b.a.closeSafely(fileOutputStream);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                com.baidu.swan.uuid.b.a.closeSafely(fileOutputStream);
                if (!z) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            com.baidu.swan.uuid.b.a.closeSafely(fileOutputStream);
            throw th;
        }
        if (!z) {
            try {
                Os.chmod(file.getAbsolutePath(), RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
            } catch (Exception e3) {
            }
        }
    }

    private String beq() {
        File file = new File(this.mContext.getFilesDir(), "libuuid.so");
        if (!file.exists()) {
            return null;
        }
        return com.baidu.swan.uuid.b.a.u(file);
    }
}
