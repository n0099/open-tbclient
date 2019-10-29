package com.baidu.mobads.openad.e;

import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class a implements IOAdTimer {
    private static String c = "OAdTimer";
    protected int a;
    private IOAdTimer.EventHandler b;
    private int d;
    private int e;
    private int f;
    private Timer g;
    private AtomicInteger h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int f(a aVar) {
        int i = aVar.e;
        aVar.e = i - 1;
        return i;
    }

    public a(int i) {
        this(i, 300);
    }

    public a(int i, int i2) {
        this.a = 300;
        this.a = i2;
        int i3 = i / this.a;
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(c, "RendererTimer(duration=" + i3 + ")");
        this.d = i3;
        this.e = i3;
        this.g = new Timer();
        this.h = new AtomicInteger(-1);
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public void setEventHandler(IOAdTimer.EventHandler eventHandler) {
        this.b = eventHandler;
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public void start() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(c, "start");
        this.h.set(0);
        this.g.scheduleAtFixedRate(new b(this), 0L, this.a);
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public void stop() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(c, "stop");
        this.h.set(2);
        synchronized (this) {
            if (this.g != null) {
                this.g.purge();
                this.g.cancel();
                this.g = null;
            }
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public void pause() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(c, "pause");
        this.h.set(1);
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public void resume() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(c, "resume");
        this.h.set(0);
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public int getCurrentCount() {
        return this.f;
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public int getRepeatCount() {
        return this.d;
    }

    @Override // com.baidu.mobads.openad.interfaces.utils.IOAdTimer
    public void reset() {
        XAdSDKFoundationFacade.getInstance().getAdLogger().i(c, "reset");
        this.h.set(-1);
        this.e = this.d;
    }
}
