package com.baidu.fsg.base.restnet;
/* loaded from: classes4.dex */
public class RestRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6136655840566008535L;

    public RestRuntimeException(String str) {
        super(str);
    }

    public RestRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    private static String buildMessage(String str, Throwable th) {
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str).append("; ");
            }
            sb.append("rest exception is ").append(th);
            return sb.toString();
        }
        return str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return buildMessage(super.getMessage(), getCause());
    }

    public boolean contains(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (cls.isInstance(this)) {
            return true;
        }
        Throwable cause = getCause();
        if (cause == this) {
            return false;
        }
        if (cause instanceof RestRuntimeException) {
            return ((RestRuntimeException) cause).contains(cls);
        }
        while (cause != null) {
            if (cls.isInstance(cause)) {
                return true;
            }
            if (cause.getCause() == cause) {
                break;
            }
            cause = cause.getCause();
        }
        return false;
    }
}
