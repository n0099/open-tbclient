package com.baidu.android.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/* loaded from: classes.dex */
public class SimpleFormatter extends Formatter {
    public static String format = "{0,date} {0,time}";
    public MessageFormat formatter;
    public Date dat = new Date();
    public Object[] args = new Object[1];

    @Override // java.util.logging.Formatter
    public synchronized String format(LogRecord logRecord) {
        String str;
        String str2;
        int i;
        StringBuffer stringBuffer;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= length) {
                str = null;
                str2 = null;
                i = 0;
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (stackTraceElement.getClassName().startsWith(Log.class.getName())) {
                z = true;
            } else if (z) {
                str = stackTraceElement.getClassName();
                str2 = stackTraceElement.getMethodName();
                i = stackTraceElement.getLineNumber();
                break;
            }
            i2++;
        }
        logRecord.setSourceClassName(str);
        logRecord.setSourceMethodName(str2);
        stringBuffer = new StringBuffer();
        this.dat.setTime(logRecord.getMillis());
        this.args[0] = this.dat;
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.formatter == null) {
            this.formatter = new MessageFormat(format);
        }
        this.formatter.format(this.args, stringBuffer2, (FieldPosition) null);
        stringBuffer.append(stringBuffer2);
        stringBuffer.append("." + (logRecord.getMillis() % 1000));
        stringBuffer.append(" ");
        if (logRecord.getSourceClassName() != null) {
            stringBuffer.append(logRecord.getSourceClassName());
        } else {
            stringBuffer.append(logRecord.getLoggerName());
        }
        if (logRecord.getSourceMethodName() != null) {
            stringBuffer.append(" ");
            stringBuffer.append(logRecord.getSourceMethodName());
        }
        stringBuffer.append(" ");
        stringBuffer.append(i);
        stringBuffer.append(" ");
        String formatMessage = formatMessage(logRecord);
        stringBuffer.append(logRecord.getLevel().getLocalizedName());
        stringBuffer.append(": ");
        stringBuffer.append(formatMessage);
        stringBuffer.append("\n");
        if (logRecord.getThrown() != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                logRecord.getThrown().printStackTrace(printWriter);
                printWriter.close();
                stringBuffer.append(stringWriter.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
