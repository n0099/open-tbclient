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
    private AladinServer Ar;
    private ServerSocket Aq = null;
    private boolean As = false;
    private boolean At = false;
    private int mPort = 6257;

    public a(AladinServer aladinServer) {
        this.Ar = aladinServer;
    }

    private void init(int i) {
        this.Aq = new ServerSocket();
        this.Aq.setReuseAddress(true);
        this.Aq.setSoTimeout(0);
        this.Aq.bind(new InetSocketAddress(i));
    }

    public void quit() {
        this.At = true;
        try {
            if (!this.Aq.isClosed()) {
                this.Aq.close();
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mPort = com.baidu.tbadk.core.sharedPref.b.og().getInt("aladin_port", -1);
        if (this.mPort == -1) {
            this.mPort = 6257;
        }
        try {
            init(this.mPort);
            while (true) {
                try {
                    this.As = true;
                    Socket accept = this.Aq.accept();
                    if (accept != null) {
                        if (!com.baidu.tbadk.aladin.b.b.a(accept.getInetAddress())) {
                            try {
                                if (!accept.isClosed()) {
                                    accept.close();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            new b(accept, this.Ar, this).start();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        BdLog.detailException(th2);
                        this.As = false;
                        if (this.Aq != null) {
                            try {
                                if (!this.Aq.isClosed()) {
                                    this.Aq.close();
                                }
                            } catch (Throwable th3) {
                                BdLog.detailException(th3);
                            }
                        }
                        if (!this.At && this.Ar != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.Ar.reStartListener();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        this.As = false;
                        if (this.Aq != null) {
                            try {
                                if (!this.Aq.isClosed()) {
                                    this.Aq.close();
                                }
                            } catch (Throwable th5) {
                                BdLog.detailException(th5);
                            }
                        }
                        if (!this.At && this.Ar != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            this.Ar.reStartListener();
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            BdLog.detailException(th6);
            TiebaStatic.aladinPortError("", TbErrInfo.ERR_ALADIN_PORT_ERROR, th6.getMessage(), new StringBuilder(String.valueOf(this.mPort)).toString());
            if (this.Ar != null) {
                this.Ar.stopSelf();
            }
            if (this.Aq != null) {
                try {
                    if (!this.Aq.isClosed()) {
                        this.Aq.close();
                    }
                } catch (Throwable th7) {
                    BdLog.detailException(th7);
                }
            }
        }
    }

    public boolean kU() {
        return this.As;
    }
}
