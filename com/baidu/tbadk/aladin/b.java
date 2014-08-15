package com.baidu.tbadk.aladin;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.aladin.b.c;
import com.baidu.tbadk.aladin.b.d;
import com.baidu.tbadk.aladin.b.e;
import com.baidu.tieba.service.WebNativeReceiver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
/* loaded from: classes.dex */
public class b extends Thread {
    private Socket a;
    private AladinServer b;
    private a c;

    public b(Socket socket, AladinServer aladinServer, a aVar) {
        this.a = socket;
        this.b = aladinServer;
        this.c = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [150=6, 152=6, 153=6, 154=6, 157=6, 158=6, 159=6, 162=6, 163=6, 164=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        com.baidu.tbadk.aladin.a.a a;
        if (this.a == null) {
            return;
        }
        try {
            try {
                if (this.b == null || this.c == null) {
                    if (this.a != null) {
                        try {
                            this.a.shutdownInput();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            this.a.shutdownOutput();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            this.a.close();
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                this.a.setSoTimeout(1000);
                this.a.setTcpNoDelay(true);
                InputStream inputStream = this.a.getInputStream();
                if (inputStream == null) {
                    if (this.a != null) {
                        try {
                            this.a.shutdownInput();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        try {
                            this.a.shutdownOutput();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        try {
                            this.a.close();
                            return;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String str = null;
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (str == null) {
                        str = readLine;
                    }
                } while (readLine.length() != 0);
                com.baidu.tbadk.aladin.a.a a2 = new d(new com.baidu.tbadk.aladin.a.a(str)).a();
                if (a2 != null && (a = new e(a2).a()) != null && c.a()) {
                    com.baidu.tbadk.aladin.a.b bVar = new com.baidu.tbadk.aladin.a.b(a);
                    boolean a3 = bVar.a();
                    String c = bVar.c();
                    if (a3) {
                        Intent b = bVar.b();
                        if (b == null) {
                            bVar.a(2);
                            c = bVar.c();
                        } else if (new com.baidu.tbadk.aladin.b.a().a(b)) {
                            try {
                                b.setClass(this.b.getApplicationContext(), WebNativeReceiver.class);
                                this.b.sendBroadcast(b);
                            } catch (Exception e7) {
                                bVar.a(1);
                                c = bVar.c();
                            }
                        } else {
                            bVar.a(2);
                            c = bVar.c();
                        }
                    } else {
                        bVar.a(2);
                        c = bVar.c();
                    }
                    com.baidu.tbadk.aladin.a.c cVar = new com.baidu.tbadk.aladin.a.c();
                    cVar.a("Connection", "Close");
                    cVar.a(c);
                    String a4 = cVar.a();
                    OutputStream outputStream = this.a.getOutputStream();
                    if (outputStream == null) {
                        if (this.a != null) {
                            try {
                                this.a.shutdownInput();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                            try {
                                this.a.shutdownOutput();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                            try {
                                this.a.close();
                                return;
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                    bufferedWriter.write(a4);
                    bufferedWriter.flush();
                }
                if (this.a != null) {
                    try {
                        this.a.shutdownInput();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    try {
                        this.a.shutdownOutput();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    try {
                        this.a.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
            } catch (IOException e14) {
                BdLog.detailException(e14);
                if (this.a != null) {
                    try {
                        this.a.shutdownInput();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                    try {
                        this.a.shutdownOutput();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    try {
                        this.a.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            if (this.a != null) {
                try {
                    this.a.shutdownInput();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                try {
                    this.a.shutdownOutput();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                try {
                    this.a.close();
                } catch (IOException e20) {
                    e20.printStackTrace();
                }
            }
            throw th;
        }
    }
}
