package cn.jingling.lib.file;
/* loaded from: classes.dex */
public class SDCardFullException extends Exception {
    private static final long serialVersionUID = -1387209667953537584L;

    public SDCardFullException() {
    }

    public SDCardFullException(String str) {
        super(str);
    }

    public SDCardFullException(String str, Throwable th) {
        super(str, th);
    }

    public SDCardFullException(Throwable th) {
        super(th);
    }
}
