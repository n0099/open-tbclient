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
    private AladinServer Nk;
    private ServerSocket Nj = null;
    private boolean Nl = false;
    private boolean Nm = false;
    private int mPort = 6257;

    public a(AladinServer aladinServer) {
        this.Nk = aladinServer;
    }

    private void init(int i) {
        this.Nj = new ServerSocket();
        this.Nj.setReuseAddress(true);
        this.Nj.setSoTimeout(0);
        this.Nj.bind(new InetSocketAddress(i));
    }

    public void quit() {
        this.Nm = true;
        try {
            if (!this.Nj.isClosed()) {
                this.Nj.close();
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mPort = com.baidu.tbadk.core.sharedPref.b.sl().getInt("aladin_port", -1);
        if (this.mPort == -1) {
            this.mPort = 6257;
        }
        try {
            init(this.mPort);
            while (true) {
                try {
                    this.Nl = true;
                    Socket accept = this.Nj.accept();
                    if (accept != null) {
                        if (!com.baidu.tbadk.aladin.b.b.a(accept.getInetAddress())) {
                            try {
                                if (!accept.isClosed()) {
                                    accept.close();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            new b(accept, this.Nk, this).start();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        BdLog.detailException(th2);
                        this.Nl = false;
                        if (this.Nj != null) {
                            try {
                                if (!this.Nj.isClosed()) {
                                    this.Nj.close();
                                }
                            } catch (Throwable th3) {
                                BdLog.detailException(th3);
                            }
                        }
                        if (!this.Nm && this.Nk != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.Nk.reStartListener();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        this.Nl = false;
                        if (this.Nj != null) {
                            try {
                                if (!this.Nj.isClosed()) {
                                    this.Nj.close();
                                }
                            } catch (Throwable th5) {
                                BdLog.detailException(th5);
                            }
                        }
                        if (!this.Nm && this.Nk != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            this.Nk.reStartListener();
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            BdLog.detailException(th6);
            TiebaStatic.aladinPortError("", TbErrInfo.ERR_ALADIN_PORT_ERROR, th6.getMessage(), new StringBuilder(String.valueOf(this.mPort)).toString());
            if (this.Nk != null) {
                this.Nk.stopSelf();
            }
            if (this.Nj != null) {
                try {
                    if (!this.Nj.isClosed()) {
                        this.Nj.close();
                    }
                } catch (Throwable th7) {
                    BdLog.detailException(th7);
                }
            }
        }
    }

    public boolean pg() {
        return this.Nl;
    }
}
