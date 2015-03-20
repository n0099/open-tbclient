package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.Disk.f {
    final /* synthetic */ BdNormalStatBase wX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdNormalStatBase bdNormalStatBase) {
        this.wX = bdNormalStatBase;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [535=4, 536=4] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.Disk.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.baidu.adp.lib.Disk.e eVar, DiskFileOperate diskFileOperate, com.baidu.adp.lib.Disk.b bVar) {
        FileInputStream fileInputStream;
        boolean z;
        File a;
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream = null;
        try {
            a = bVar.a(diskFileOperate.getPath(), diskFileOperate.getName(), false, diskFileOperate.fB());
        } catch (Exception e) {
            e = e;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a == null || !a.exists() || eVar.fl()) {
            com.baidu.adp.lib.g.a.d(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            return false;
        }
        fileInputStream = new FileInputStream(a);
        File file = null;
        int i = 0;
        int i2 = 0;
        try {
            byte[] bArr = new byte[10240];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                i++;
                if (fileOutputStream == null || file == null) {
                    file = bVar.a(diskFileOperate.getPath(), this.wX.getUploadingLogFile(), false, diskFileOperate.fB());
                    fileOutputStream = new FileOutputStream(file);
                }
                boolean z2 = i * 10240 >= 102400;
                if (z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= bArr.length) {
                            break;
                        } else if (bArr[i3] == 10) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                } else {
                    i2 = read;
                }
                fileOutputStream.write(bArr, 0, i2);
                fileOutputStream.flush();
                if (z2) {
                    com.baidu.adp.lib.g.a.b(fileOutputStream);
                    if (i2 != read) {
                        try {
                            File a2 = bVar.a(diskFileOperate.getPath(), this.wX.getUploadingLogFile(), false, diskFileOperate.fB());
                            fileOutputStream = new FileOutputStream(a2);
                            fileOutputStream.write(bArr, i2, read - i2);
                            fileOutputStream.flush();
                            i = 0;
                            file = a2;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            try {
                                BdLog.e(e);
                                com.baidu.adp.lib.g.a.d(fileInputStream2);
                                com.baidu.adp.lib.g.a.b(fileOutputStream);
                                z = false;
                                if (z) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.b(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.b(fileOutputStream);
                            throw th;
                        }
                    } else {
                        file = null;
                        fileOutputStream = null;
                        i = 0;
                    }
                }
            }
            z = true;
            com.baidu.adp.lib.g.a.d(fileInputStream);
            com.baidu.adp.lib.g.a.b(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (z) {
            return z;
        }
        this.wX.an(diskFileOperate.getName());
        return z;
    }
}
