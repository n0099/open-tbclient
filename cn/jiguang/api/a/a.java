package cn.jiguang.api.a;

import cn.jiguang.api.h;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(ByteBuffer byteBuffer, h hVar) {
        try {
            return byteBuffer.getInt();
        } catch (BufferOverflowException e) {
            a(e.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
                hVar.code = 10000;
            }
            return -1;
        } catch (BufferUnderflowException e2) {
            a(e2.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return -1;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return -1;
        }
    }

    private static String a(Throwable th, h hVar, ByteBuffer byteBuffer) {
        StringBuilder sb = new StringBuilder();
        if (hVar != null) {
            sb.append(hVar.toString());
            sb.append("|bytebuffer:" + (byteBuffer == null ? "byteBuffer is null" : byteBuffer.toString()));
        }
        cn.jiguang.e.c.d("ByteBufferUtils", "byteBuffer info:" + sb.toString());
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            cn.jiguang.e.c.d("ByteBufferUtils", "parse data error stackTrace:" + stringWriter.toString());
        } catch (Exception e) {
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ByteBuffer a(ByteBuffer byteBuffer, byte[] bArr, h hVar) {
        try {
            return byteBuffer.get(bArr);
        } catch (BufferOverflowException e) {
            a(e.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
                hVar.code = 10000;
            }
            return null;
        } catch (BufferUnderflowException e2) {
            a(e2.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return null;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static short b(ByteBuffer byteBuffer, h hVar) {
        try {
            return byteBuffer.getShort();
        } catch (BufferOverflowException e) {
            a(e.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
                hVar.code = 10000;
            }
            return (short) -1;
        } catch (BufferUnderflowException e2) {
            a(e2.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return (short) -1;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return (short) -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Byte c(ByteBuffer byteBuffer, h hVar) {
        try {
            return Byte.valueOf(byteBuffer.get());
        } catch (BufferOverflowException e) {
            a(e.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
                hVar.code = 10000;
            }
            return null;
        } catch (BufferUnderflowException e2) {
            a(e2.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return null;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long d(ByteBuffer byteBuffer, h hVar) {
        try {
            return byteBuffer.getLong();
        } catch (BufferOverflowException e) {
            a(e.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
                hVar.code = 10000;
            }
            return 0L;
        } catch (BufferUnderflowException e2) {
            a(e2.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return 0L;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), hVar, byteBuffer);
            if (hVar != null) {
            }
            return 0L;
        }
    }
}
