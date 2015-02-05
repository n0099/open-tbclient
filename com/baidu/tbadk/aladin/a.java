package com.baidu.tbadk.aladin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/* loaded from: classes.dex */
public class a extends Thread {
    private AladinServer Ao;
    private ServerSocket An = null;
    private boolean Ap = false;
    private boolean Aq = false;
    private int mPort = 6257;

    public a(AladinServer aladinServer) {
        this.Ao = aladinServer;
    }

    private void init(int i) {
        this.An = new ServerSocket();
        this.An.setReuseAddress(true);
        this.An.setSoTimeout(0);
        this.An.bind(new InetSocketAddress(i));
    }

    public void quit() {
        this.Aq = true;
        try {
            if (!this.An.isClosed()) {
                this.An.close();
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mPort = com.baidu.tbadk.core.sharedPref.b.oc().getInt("aladin_port", -1);
        if (this.mPort == -1) {
            this.mPort = 6257;
        }
        try {
            init(this.mPort);
            while (true) {
                try {
                    this.Ap = true;
                    Socket accept = this.An.accept();
                    if (accept != null) {
                        if (!com.baidu.tbadk.aladin.b.b.a(accept.getInetAddress())) {
                            try {
                                if (!accept.isClosed()) {
                                    accept.close();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            new b(accept, this.Ao, this).start();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        BdLog.detailException(th2);
                        this.Ap = false;
                        if (this.An != null) {
                            try {
                                if (!this.An.isClosed()) {
                                    this.An.close();
                                }
                            } catch (Throwable th3) {
                                BdLog.detailException(th3);
                            }
                        }
                        if (!this.Aq && this.Ao != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.Ao.reStartListener();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        this.Ap = false;
                        if (this.An != null) {
                            try {
                                if (!this.An.isClosed()) {
                                    this.An.close();
                                }
                            } catch (Throwable th5) {
                                BdLog.detailException(th5);
                            }
                        }
                        if (!this.Aq && this.Ao != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            this.Ao.reStartListener();
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            BdLog.detailException(th6);
            TiebaStatic.aladinPortError("", TbErrInfo.ERR_ALADIN_PORT_ERROR, th6.getMessage(), new StringBuilder(String.valueOf(this.mPort)).toString());
            if (this.Ao != null) {
                this.Ao.stopSelf();
            }
            if (this.An != null) {
                try {
                    if (!this.An.isClosed()) {
                        this.An.close();
                    }
                } catch (Throwable th7) {
                    BdLog.detailException(th7);
                }
            }
        }
    }

    public boolean kN() {
        return this.Ap;
    }
}
