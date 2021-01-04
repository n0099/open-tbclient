package com.baidu.mobads.utils;

import android.util.Log;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
/* loaded from: classes3.dex */
public class m implements IXAdLogger {

    /* renamed from: a  reason: collision with root package name */
    private static volatile m f3543a = null;

    public static m a() {
        if (f3543a == null) {
            synchronized (m.class) {
                if (f3543a == null) {
                    f3543a = new m();
                }
            }
        }
        return f3543a;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public boolean isLoggable(String str, int i) {
        return i >= com.baidu.mobads.a.a.f3336b;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public boolean isLoggable(int i) {
        return isLoggable(IXAdLogger.TAG, i);
    }

    private String a(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj).append(' ');
        }
        return sb.toString();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int d(Object... objArr) {
        if (isLoggable(3)) {
            return d(a(objArr));
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int d(String str) {
        return d(IXAdLogger.TAG, str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int d(String str, String str2) {
        if (isLoggable(3)) {
            try {
                return Log.d(str, str2);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int d(Throwable th) {
        return d("", th);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int d(String str, Throwable th) {
        if (isLoggable(3)) {
            try {
                return Log.d(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int w(String str) {
        if (isLoggable(5)) {
            try {
                return Log.w(IXAdLogger.TAG, str);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int w(Object... objArr) {
        if (isLoggable(5)) {
            return w(a(objArr));
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int w(String str, Throwable th) {
        if (isLoggable(5)) {
            try {
                return Log.w(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int w(Throwable th) {
        return w("", th);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int e(Object... objArr) {
        if (isLoggable(6)) {
            return e(a(objArr));
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int e(String str) {
        if (isLoggable(6)) {
            try {
                return Log.e(IXAdLogger.TAG, str);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int e(Throwable th) {
        return e("", th);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int e(String str, Throwable th) {
        if (isLoggable(6)) {
            try {
                return Log.e(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int i(String str) {
        return i(IXAdLogger.TAG, str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int i(String str, String str2) {
        if (isLoggable(4)) {
            try {
                return Log.i(str, str2);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int i(Object... objArr) {
        if (isLoggable(4)) {
            return i(a(objArr));
        }
        return -1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdLogger
    public int i(String str, Throwable th) {
        if (isLoggable(4)) {
            try {
                return Log.i(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }
}
