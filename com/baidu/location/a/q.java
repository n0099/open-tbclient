package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes6.dex */
public class q {
    private static Object a = new Object();
    private static q aeq = null;
    private HandlerThread c;
    private Handler d;
    private boolean e = false;

    q() {
    }

    public static q tw() {
        q qVar;
        synchronized (a) {
            if (aeq == null) {
                aeq = new q();
            }
            qVar = aeq;
        }
        return qVar;
    }

    public void a(Location location, int i) {
        if (!this.e || location == null) {
            return;
        }
        try {
            if (this.d != null) {
                Message obtainMessage = this.d.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        if (this.e) {
            try {
                if (this.d != null) {
                    this.d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.e) {
            try {
                if (this.d != null) {
                    this.d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.e) {
            try {
                if (this.d != null) {
                    this.d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.c == null) {
            this.c = new HandlerThread("LocUploadThreadManager");
            this.c.start();
            this.d = new Handler(this.c.getLooper()) { // from class: com.baidu.location.a.q.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    boolean z = true;
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            try {
                                Location location = (Location) data.getParcelable("loc");
                                data.getInt("satnum");
                                if (location != null) {
                                    e.tj().a(location);
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        case 2:
                            p.a(n.ts(), com.baidu.location.e.f.tU().tW(), n.tt(), n.a());
                            return;
                        case 3:
                            p.a(n.ts(), null, n.tt(), a.tf().c());
                            return;
                        case 4:
                            boolean j = com.baidu.location.e.f.j();
                            if (!j) {
                                z = j;
                            } else if (g.tk().d() == 1) {
                                z = false;
                            }
                            if (z) {
                                if (com.baidu.location.b.c.tz().e()) {
                                    com.baidu.location.d.d.tI().m();
                                    com.baidu.location.d.d.tI().i();
                                }
                                com.baidu.location.b.f.tC().c();
                                if (com.baidu.location.b.c.tz().e()) {
                                    p.tv().c();
                                }
                            }
                            try {
                                if (q.this.d != null) {
                                    q.this.d.sendEmptyMessageDelayed(4, com.baidu.location.g.g.Q);
                                    return;
                                }
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        case 5:
                            com.baidu.location.b.f.tC().b();
                            return;
                        case 6:
                        default:
                            return;
                        case 7:
                            p.tv().c();
                            com.baidu.location.b.f.tC().c();
                            return;
                        case 8:
                            message.getData();
                            return;
                    }
                }
            };
        }
        try {
            if (this.d != null) {
                this.d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d != null) {
                this.d.sendEmptyMessageDelayed(4, com.baidu.location.g.g.Q);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        if (this.e) {
            e.tj().b();
            try {
                if (this.d != null) {
                    this.d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.d = null;
            try {
                if (this.c != null) {
                    this.c.quit();
                    this.c.interrupt();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c = null;
            this.e = false;
        }
    }
}
