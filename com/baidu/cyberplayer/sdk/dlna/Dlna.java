package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
@Keep
/* loaded from: classes.dex */
public class Dlna {
    private static String a = "com.baidu.media.dlna.DlnaProviderImpl";
    private static DlnaProvider b = null;
    private boolean c;

    /* loaded from: classes.dex */
    public static class a {
        private static final Dlna a = new Dlna();
    }

    private Dlna() {
        this.c = false;
    }

    public static Dlna getInstance() {
        return a.a;
    }

    public static void init(ClassLoader classLoader) {
        try {
            b = (DlnaProvider) Class.forName(a, true, classLoader).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            b = null;
        }
    }

    public PnPController getCtrlPoint(String str) {
        if (b == null || str == null) {
            return null;
        }
        return new PnPController(str, b);
    }

    public void refresh(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        if (b != null) {
            b.stop();
            b.search(dlnaSearchListener);
        }
    }

    public void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        if (b == null || this.c) {
            return;
        }
        this.c = true;
        b.search(dlnaSearchListener);
    }

    public void stop() {
        if (b != null) {
            this.c = false;
            b.stop();
        }
    }
}
