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
    private AladinServer xe;
    private ServerSocket xd = null;
    private boolean xf = false;
    private boolean xg = false;
    private int xh = 6257;

    public a(AladinServer aladinServer) {
        this.xe = aladinServer;
    }

    private void init(int i) {
        this.xd = new ServerSocket();
        this.xd.setReuseAddress(true);
        this.xd.setSoTimeout(0);
        this.xd.bind(new InetSocketAddress(i));
    }

    public void quit() {
        this.xg = true;
        try {
            if (!this.xd.isClosed()) {
                this.xd.close();
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.xh = com.baidu.tbadk.core.sharedPref.b.lk().getInt("aladin_port", -1);
        if (this.xh == -1) {
            this.xh = 6257;
        }
        try {
            init(this.xh);
            while (true) {
                try {
                    this.xf = true;
                    Socket accept = this.xd.accept();
                    if (accept != null) {
                        if (!com.baidu.tbadk.aladin.b.b.a(accept.getInetAddress())) {
                            try {
                                if (!accept.isClosed()) {
                                    accept.close();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            new b(accept, this.xe, this).start();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        BdLog.detailException(th2);
                        this.xf = false;
                        if (this.xd != null) {
                            try {
                                if (!this.xd.isClosed()) {
                                    this.xd.close();
                                }
                            } catch (Throwable th3) {
                                BdLog.detailException(th3);
                            }
                        }
                        if (!this.xg && this.xe != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.xe.reStartListener();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        this.xf = false;
                        if (this.xd != null) {
                            try {
                                if (!this.xd.isClosed()) {
                                    this.xd.close();
                                }
                            } catch (Throwable th5) {
                                BdLog.detailException(th5);
                            }
                        }
                        if (!this.xg && this.xe != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            this.xe.reStartListener();
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            BdLog.detailException(th6);
            TiebaStatic.aladinPortError("", TbErrInfo.ERR_ALADIN_PORT_ERROR, th6.getMessage(), new StringBuilder(String.valueOf(this.xh)).toString());
            if (this.xe != null) {
                this.xe.stopSelf();
            }
            if (this.xd != null) {
                try {
                    if (!this.xd.isClosed()) {
                        this.xd.close();
                    }
                } catch (Throwable th7) {
                    BdLog.detailException(th7);
                }
            }
        }
    }

    public boolean iI() {
        return this.xf;
    }
}
