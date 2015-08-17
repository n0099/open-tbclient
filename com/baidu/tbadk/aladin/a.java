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
    private AladinServer RT;
    private ServerSocket RS = null;
    private boolean RU = false;
    private boolean RV = false;
    private int RW = 6257;

    public a(AladinServer aladinServer) {
        this.RT = aladinServer;
    }

    private void init(int i) {
        this.RS = new ServerSocket();
        this.RS.setReuseAddress(true);
        this.RS.setSoTimeout(0);
        this.RS.bind(new InetSocketAddress(i));
    }

    public void quit() {
        this.RV = true;
        try {
            if (!this.RS.isClosed()) {
                this.RS.close();
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.RW = com.baidu.tbadk.core.sharedPref.b.ts().getInt("aladin_port", -1);
        if (this.RW == -1) {
            this.RW = 6257;
        }
        try {
            init(this.RW);
            while (true) {
                try {
                    this.RU = true;
                    Socket accept = this.RS.accept();
                    if (accept != null) {
                        if (!com.baidu.tbadk.aladin.b.b.b(accept.getInetAddress())) {
                            try {
                                if (!accept.isClosed()) {
                                    accept.close();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            new b(accept, this.RT, this).start();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        BdLog.detailException(th2);
                        this.RU = false;
                        if (this.RS != null) {
                            try {
                                if (!this.RS.isClosed()) {
                                    this.RS.close();
                                }
                            } catch (Throwable th3) {
                                BdLog.detailException(th3);
                            }
                        }
                        if (!this.RV && this.RT != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.RT.reStartListener();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        this.RU = false;
                        if (this.RS != null) {
                            try {
                                if (!this.RS.isClosed()) {
                                    this.RS.close();
                                }
                            } catch (Throwable th5) {
                                BdLog.detailException(th5);
                            }
                        }
                        if (!this.RV && this.RT != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            this.RT.reStartListener();
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            BdLog.detailException(th6);
            TiebaStatic.aladinPortError(TbErrInfo.ERR_ALADIN_PORT_ERROR, th6.getMessage(), new StringBuilder(String.valueOf(this.RW)).toString());
            if (this.RT != null) {
                this.RT.stopSelf();
            }
            if (this.RS != null) {
                try {
                    if (!this.RS.isClosed()) {
                        this.RS.close();
                    }
                } catch (Throwable th7) {
                    BdLog.detailException(th7);
                }
            }
        }
    }

    public boolean qg() {
        return this.RU;
    }
}
