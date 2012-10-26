package android.support.v4.util;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import java.io.Writer;
/* loaded from: classes.dex */
public class LogWriter extends Writer {
    private StringBuilder mBuilder = new StringBuilder((int) AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
    private final String mTag;

    public LogWriter(String tag) {
        this.mTag = tag;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        flushBuilder();
    }

    @Override // java.io.Writer
    public void write(char[] buf, int offset, int count) {
        for (int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if (c == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c);
            }
        }
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            Log.d(this.mTag, this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }
}
