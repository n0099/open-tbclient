package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class m {
    private static m a;
    private static DataOutputStream c;
    private static FileOutputStream d;
    private File b = null;
    private boolean e = false;
    private ExecutorService f;

    private m() {
        this.f = null;
        f();
        g();
        this.f = Executors.newSingleThreadExecutor(new com.baidu.android.moplus.util.a("WriteFileThreadpool"));
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m();
            }
            mVar = a;
        }
        return mVar;
    }

    public static void d() {
        try {
            if (c != null) {
                c.close();
                c = null;
            }
            if (d != null) {
                d.close();
                d = null;
            }
            if (a != null) {
                a = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void f() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) || Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            return;
        }
        this.b = new File(Environment.getExternalStorageDirectory(), ".0fc503e97dcd994232bb6a1f62b7db95");
        if (this.b.exists()) {
            return;
        }
        try {
            this.b.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.b == null) {
            return;
        }
        if (!this.b.exists()) {
            f();
        }
        if (c == null) {
            try {
                d = new FileOutputStream(this.b, true);
                c = new DataOutputStream(d);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(Context context, String str) {
        if (this.e || TextUtils.isEmpty(str)) {
            return;
        }
        this.f.submit(new l(this, str, context));
    }

    public JSONArray b() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r2 = null;
        r2 = null;
        bufferedReader2 = null;
        FileReader fileReader2 = null;
        BufferedReader bufferedReader3 = null;
        BufferedReader bufferedReader4 = null;
        JSONArray jSONArray = new JSONArray();
        if (this.b != null && this.b.exists() && this.b.length() != 0) {
            if (this.e) {
            }
            this.e = true;
            try {
                fileReader = new FileReader(this.b);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            jSONArray.put(com.baidu.android.systemmonitor.security.a.b(readLine));
                        } catch (IOException e) {
                            fileReader2 = fileReader;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (fileReader2 != null) {
                                fileReader2.close();
                            }
                            this.e = false;
                            return jSONArray;
                        } catch (Exception e3) {
                            bufferedReader3 = bufferedReader;
                            if (bufferedReader3 != null) {
                                try {
                                    bufferedReader3.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            this.e = false;
                            return jSONArray;
                        } catch (OutOfMemoryError e5) {
                            bufferedReader4 = bufferedReader;
                            if (bufferedReader4 != null) {
                                try {
                                    bufferedReader4.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            this.e = false;
                            return jSONArray;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                } catch (IOException e9) {
                    bufferedReader = null;
                    fileReader2 = fileReader;
                } catch (Exception e10) {
                } catch (OutOfMemoryError e11) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e12) {
                bufferedReader = null;
            } catch (Exception e13) {
                fileReader = null;
            } catch (OutOfMemoryError e14) {
                fileReader = null;
            } catch (Throwable th3) {
                th = th3;
                fileReader = null;
            }
            this.e = false;
        }
        return jSONArray;
    }

    public void c() {
        this.e = false;
        try {
            if (c != null) {
                c.close();
                c = null;
            }
            if (d != null) {
                d.close();
                d = null;
            }
        } catch (IOException e) {
        }
        if (this.b == null || !this.b.exists()) {
            return;
        }
        if (this.b.delete()) {
        }
        this.b = null;
    }
}
