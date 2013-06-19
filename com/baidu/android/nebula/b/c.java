package com.baidu.android.nebula.b;

import com.baidu.android.common.logging.Log;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends com.baidu.android.nebula.c.c {
    private ByteBuffer a;
    private StringBuilder b;
    private a c;
    private int d = -1;
    private boolean e = false;

    public static int a(String str) {
        if (str.startsWith("GET")) {
            return 0;
        }
        if (str.startsWith("POST")) {
            return 1;
        }
        return str.startsWith("HEAD") ? 2 : 0;
    }

    public static int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i = 0;
        if (byteBuffer != null && byteBuffer2 != null) {
            while (true) {
                if (byteBuffer.remaining() >= 4 && byteBuffer2.remaining() >= 4) {
                    byteBuffer2.putInt(byteBuffer.getInt());
                    i += 4;
                } else if (byteBuffer.remaining() <= 0 || byteBuffer2.remaining() <= 0) {
                    break;
                } else {
                    byteBuffer2.put(byteBuffer.get());
                    i++;
                }
            }
        }
        return i;
    }

    @Override // com.baidu.android.nebula.c.c
    public int a(ByteBuffer byteBuffer) {
        int remaining;
        if (!this.e && (remaining = byteBuffer.remaining()) > 0) {
            if (this.b == null) {
                this.b = new StringBuilder();
            }
            this.b.append(new String(byteBuffer.array(), byteBuffer.position(), remaining));
            return remaining;
        }
        return 0;
    }

    public a a() {
        return this.c;
    }

    public void a(b bVar) {
        this.a = ByteBuffer.wrap(bVar.toString().getBytes());
        this.a.rewind();
    }

    @Override // com.baidu.android.nebula.c.c
    public int b(ByteBuffer byteBuffer) {
        if (this.e) {
            return 0;
        }
        return a(this.a, byteBuffer);
    }

    @Override // com.baidu.android.nebula.c.c
    public boolean b() {
        int indexOf;
        if (this.e) {
            return true;
        }
        if (this.b == null) {
            return false;
        }
        String sb = this.b.toString();
        if (this.d == -1) {
            this.d = a(sb);
            if (this.d == -1) {
                return false;
            }
        }
        if (this.d == 0 || this.d == 2) {
            if (sb.endsWith("\r\n\r\n")) {
                this.c = new a(this.b.toString());
                return true;
            }
        } else if (this.d == 1) {
            if (this.c == null && (indexOf = sb.indexOf("\r\n\r\n")) != -1) {
                String substring = sb.substring(0, indexOf + 1);
                this.c = new a(substring);
                this.b.delete(0, substring.getBytes().length);
            }
            if (this.c != null) {
                try {
                    if (this.b.length() >= Integer.parseInt(this.c.a(HttpUtils.HEADER_NAME_CONTENT_LENGTH))) {
                        this.c.a(this.b.toString().getBytes());
                        this.b = new StringBuilder();
                        return true;
                    }
                } catch (NumberFormatException e) {
                    Log.e("HttpSession", "Content-Length Parse Error ：", e);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.baidu.android.nebula.c.c
    public boolean c() {
        if (this.e) {
            return true;
        }
        return (this.a == null || this.a.hasRemaining()) ? false : true;
    }
}
