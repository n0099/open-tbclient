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
    private AladinServer MU;
    private ServerSocket MT = null;
    private boolean MV = false;
    private boolean MW = false;
    private int mPort = 6257;

    public a(AladinServer aladinServer) {
        this.MU = aladinServer;
    }

    private void init(int i) {
        this.MT = new ServerSocket();
        this.MT.setReuseAddress(true);
        this.MT.setSoTimeout(0);
        this.MT.bind(new InetSocketAddress(i));
    }

    public void quit() {
        this.MW = true;
        try {
            if (!this.MT.isClosed()) {
                this.MT.close();
            }
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mPort = com.baidu.tbadk.core.sharedPref.b.rB().getInt("aladin_port", -1);
        if (this.mPort == -1) {
            this.mPort = 6257;
        }
        try {
            init(this.mPort);
            while (true) {
                try {
                    this.MV = true;
                    Socket accept = this.MT.accept();
                    if (accept != null) {
                        if (!com.baidu.tbadk.aladin.b.b.a(accept.getInetAddress())) {
                            try {
                                if (!accept.isClosed()) {
                                    accept.close();
                                }
                            } catch (Throwable th) {
                            }
                        } else {
                            new b(accept, this.MU, this).start();
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        BdLog.detailException(th2);
                        this.MV = false;
                        if (this.MT != null) {
                            try {
                                if (!this.MT.isClosed()) {
                                    this.MT.close();
                                }
                            } catch (Throwable th3) {
                                BdLog.detailException(th3);
                            }
                        }
                        if (!this.MW && this.MU != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.MU.reStartListener();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        this.MV = false;
                        if (this.MT != null) {
                            try {
                                if (!this.MT.isClosed()) {
                                    this.MT.close();
                                }
                            } catch (Throwable th5) {
                                BdLog.detailException(th5);
                            }
                        }
                        if (!this.MW && this.MU != null) {
                            try {
                                Thread.sleep(TbConfig.NOTIFY_SOUND_INTERVAL);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            this.MU.reStartListener();
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            BdLog.detailException(th6);
            TiebaStatic.aladinPortError("", TbErrInfo.ERR_ALADIN_PORT_ERROR, th6.getMessage(), new StringBuilder(String.valueOf(this.mPort)).toString());
            if (this.MU != null) {
                this.MU.stopSelf();
            }
            if (this.MT != null) {
                try {
                    if (!this.MT.isClosed()) {
                        this.MT.close();
                    }
                } catch (Throwable th7) {
                    BdLog.detailException(th7);
                }
            }
        }
    }

    public boolean oG() {
        return this.MV;
    }
}
