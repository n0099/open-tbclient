package com.baidu.apollon.restnet;
/* loaded from: classes.dex */
public class RestRuntimeException extends RuntimeException {
    public static final long serialVersionUID = -6136655840566008535L;

    public RestRuntimeException(String str) {
        super(str);
    }

    public static String buildMessage(String str, Throwable th) {
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str);
                sb.append("; ");
            }
            sb.append("rest exception is ");
            sb.append(th);
            return sb.toString();
        }
        return str;
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

    @Override // java.lang.Throwable
    public String getMessage() {
        return buildMessage(super.getMessage(), getCause());
    }

    public RestRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
