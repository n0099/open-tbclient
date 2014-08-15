package com.baidu.android.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/* loaded from: classes.dex */
class SimpleFormatter extends Formatter {
    private static String format = "{0,date} {0,time}";
    private MessageFormat formatter;
    Date dat = new Date();
    private Object[] args = new Object[1];

    @Override // java.util.logging.Formatter
    public synchronized String format(LogRecord logRecord) {
        int i;
        String str;
        String stringBuffer;
        String str2 = null;
        synchronized (this) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            boolean z = false;
            while (true) {
                if (i2 >= length) {
                    i = 0;
                    str = null;
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (stackTraceElement.getClassName().startsWith(Log.class.getName())) {
                    z = true;
                } else if (z) {
                    str2 = stackTraceElement.getClassName();
                    str = stackTraceElement.getMethodName();
                    i = stackTraceElement.getLineNumber();
                    break;
                }
                i2++;
            }
            logRecord.setSourceClassName(str2);
            logRecord.setSourceMethodName(str);
            StringBuffer stringBuffer2 = new StringBuffer();
            this.dat.setTime(logRecord.getMillis());
            this.args[0] = this.dat;
            StringBuffer stringBuffer3 = new StringBuffer();
            if (this.formatter == null) {
                this.formatter = new MessageFormat(format);
            }
            this.formatter.format(this.args, stringBuffer3, (FieldPosition) null);
            stringBuffer2.append(stringBuffer3);
            stringBuffer2.append("." + (logRecord.getMillis() % 1000));
            stringBuffer2.append(" ");
            if (logRecord.getSourceClassName() != null) {
                stringBuffer2.append(logRecord.getSourceClassName());
            } else {
                stringBuffer2.append(logRecord.getLoggerName());
            }
            if (logRecord.getSourceMethodName() != null) {
                stringBuffer2.append(" ");
                stringBuffer2.append(logRecord.getSourceMethodName());
            }
            stringBuffer2.append(" ");
            stringBuffer2.append(i);
            stringBuffer2.append(" ");
            String formatMessage = formatMessage(logRecord);
            stringBuffer2.append(logRecord.getLevel().getLocalizedName());
            stringBuffer2.append(": ");
            stringBuffer2.append(formatMessage);
            stringBuffer2.append("\n");
            if (logRecord.getThrown() != null) {
                try {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    logRecord.getThrown().printStackTrace(printWriter);
                    printWriter.close();
                    stringBuffer2.append(stringWriter.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }
}
