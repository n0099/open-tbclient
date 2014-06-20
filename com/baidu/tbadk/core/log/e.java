package com.baidu.tbadk.core.log;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
class e {
    final /* synthetic */ a a;
    private an b;

    private e(a aVar) {
        this.a = aVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [600=4, 601=4, 604=4, 605=8, 606=4, 610=4, 611=4, 614=4, 615=8, 616=4] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String str3;
        String str4;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            File file = new File(str);
            String name = file.getName();
            if (file != null) {
                fileInputStream = new FileInputStream(file);
                try {
                    String[] split = name.split("-");
                    String str5 = split.length > 1 ? split[0] : null;
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        if (z) {
                            com.baidu.tbadk.b.b.a(fileInputStream, byteArrayOutputStream);
                        } else {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byteArrayOutputStream.flush();
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray == null) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e) {
                                    BdLog.e(getClass().getName(), "sendLogFile", e.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (Exception e2) {
                                    BdLog.e(getClass().getName(), "sendLogFile", e2.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        this.b = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + str2);
                        this.b.a("cuid", TbadkApplication.getUniqueIdentifier());
                        this.b.a(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
                        this.b.a("time", str5);
                        this.b.a("errortype", "99");
                        this.b.a("logfile", byteArray);
                        this.b.j();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                            byteArrayOutputStream = null;
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            fileInputStream = null;
                        }
                        if (this.b.a().b().b()) {
                            str3 = a.d;
                            x.l(str3);
                            if (TextUtils.isEmpty(x.a(TbConfig.TMP_LOG_DIR_NAME, name, TbConfig.TMP_LOGBAK_DIR_NAME, name))) {
                                BdLog.e(getClass().getName(), "sendLogFile", "file.move error");
                            }
                            a aVar = this.a;
                            str4 = a.d;
                            aVar.g(str4);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            BdLog.e(getClass().getName(), "sendLogFile", e.getMessage());
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e4) {
                                    BdLog.e(getClass().getName(), "sendLogFile", e4.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (Exception e5) {
                                    BdLog.e(getClass().getName(), "sendLogFile", e5.getMessage());
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e6) {
                                    BdLog.e(getClass().getName(), "sendLogFile", e6.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e7) {
                                    BdLog.e(getClass().getName(), "sendLogFile", e7.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } else {
                fileInputStream = null;
                byteArrayOutputStream = null;
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e9) {
                    BdLog.e(getClass().getName(), "sendLogFile", e9.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e10) {
                    BdLog.e(getClass().getName(), "sendLogFile", e10.getMessage());
                }
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
    }
}
