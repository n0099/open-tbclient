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
    private AladinServer RR;
    private ServerSocket RQ = null;
    private boolean RS = false;
    private boolean RT = false;
    private int RU = 6257;

    public a(AladinServer aladinServer) {
        this.RR = aladinServer;
    }

    private void init(int i) {
        this.RQ = new ServerSocket();
        this.RQ.setReuseAddress(true);
        this.RQ.setSoTimeout(0);
        this.RQ.bind(new InetSocketAddress(i));
    }

    public void quit() {
        this.RT = true;
        try {
            if (!this.RQ.isClosed()) {
                this.RQ.close();
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.RU = com.baidu.tbadk.core.sharedPref.b.tx().getInt("aladin_port", -1);
        if (this.RU == -1) {
            this.RU = 6257;
        }
        try {
            init(this.RU);
            while (true) {
                try {
                    this.RS = true;
                    Socket accept = this.RQ.accept();
                    if (accept != null) {
                        if (!com.baidu.tbadk.aladin.b.b.b(accept.getInetAddress())) {
                            try {
                                if (!accept.isClosed()) {
                                    accept.close();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            new b(accept, this.RR, this).start();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        BdLog.detailException(th2);
                        this.RS = false;
                        if (this.RQ != null) {
                            try {
                                if (!this.RQ.isClosed()) {
                                    this.RQ.close();
                                }
                            } catch (Throwable th3) {
                                BdLog.detailException(th3);
                            }
                        }
                        if (!this.RT && this.RR != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.RR.reStartListener();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        this.RS = false;
                        if (this.RQ != null) {
                            try {
                                if (!this.RQ.isClosed()) {
                                    this.RQ.close();
                                }
                            } catch (Throwable th5) {
                                BdLog.detailException(th5);
                            }
                        }
                        if (!this.RT && this.RR != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            this.RR.reStartListener();
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            BdLog.detailException(th6);
            TiebaStatic.aladinPortError(TbErrInfo.ERR_ALADIN_PORT_ERROR, th6.getMessage(), new StringBuilder(String.valueOf(this.RU)).toString());
            if (this.RR != null) {
                this.RR.stopSelf();
            }
            if (this.RQ != null) {
                try {
                    if (!this.RQ.isClosed()) {
                        this.RQ.close();
                    }
                } catch (Throwable th7) {
                    BdLog.detailException(th7);
                }
            }
        }
    }

    public boolean qd() {
        return this.RS;
    }
}
