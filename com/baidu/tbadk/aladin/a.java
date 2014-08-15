package com.baidu.tbadk.aladin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/* loaded from: classes.dex */
public class a extends Thread {
    private AladinServer b;
    private ServerSocket a = null;
    private boolean c = false;
    private boolean d = false;
    private int e = 6257;

    public a(AladinServer aladinServer) {
        this.b = aladinServer;
    }

    private void a(int i) {
        this.a = new ServerSocket();
        this.a.setReuseAddress(true);
        this.a.setSoTimeout(0);
        this.a.bind(new InetSocketAddress(i));
    }

    public void a() {
        this.d = true;
        try {
            this.a.close();
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.e = com.baidu.tbadk.core.sharedPref.b.a().a("aladin_port", -1);
        if (this.e == -1) {
            this.e = 6257;
        }
        try {
            a(this.e);
            while (true) {
                try {
                    try {
                        this.c = true;
                        Socket accept = this.a.accept();
                        if (accept != null) {
                            if (!com.baidu.tbadk.aladin.b.b.a(accept.getInetAddress())) {
                                try {
                                    accept.close();
                                } catch (IOException e) {
                                }
                            } else {
                                new b(accept, this.b, this).start();
                            }
                        }
                    } catch (Throwable th) {
                        this.c = false;
                        if (this.a != null) {
                            try {
                                this.a.close();
                            } catch (IOException e2) {
                                BdLog.detailException(e2);
                            }
                        }
                        if (!this.d && this.b != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                            this.b.reStartListener();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    BdLog.detailException(e4);
                    this.c = false;
                    if (this.a != null) {
                        try {
                            this.a.close();
                        } catch (IOException e5) {
                            BdLog.detailException(e5);
                        }
                    }
                    if (!this.d && this.b != null) {
                        try {
                            Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                        this.b.reStartListener();
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e7) {
            BdLog.detailException(e7);
            TiebaStatic.aladinPortError("", TbErrInfo.ERR_ALADIN_PORT_ERROR, e7.getMessage(), new StringBuilder(String.valueOf(this.e)).toString());
            if (this.b != null) {
                this.b.stopSelf();
            }
            if (this.a != null) {
                try {
                    this.a.close();
                } catch (IOException e8) {
                    BdLog.detailException(e8);
                }
            }
        }
    }

    public boolean b() {
        return this.c;
    }
}
