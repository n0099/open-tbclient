package com.baidu.android.common.logging;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes8.dex */
public class SimpleFormatter extends Formatter {
    public static /* synthetic */ Interceptable $ic = null;
    public static String format = "{0,date} {0,time}";
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] args;
    public Date dat;
    public MessageFormat formatter;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1778734583, "Lcom/baidu/android/common/logging/SimpleFormatter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1778734583, "Lcom/baidu/android/common/logging/SimpleFormatter;");
        }
    }

    public SimpleFormatter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dat = new Date();
        this.args = new Object[1];
    }

    @Override // java.util.logging.Formatter
    public synchronized String format(LogRecord logRecord) {
        InterceptResult invokeL;
        String str;
        String str2;
        int i2;
        String stringBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logRecord)) == null) {
            synchronized (this) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                int length = stackTrace.length;
                int i3 = 0;
                boolean z = false;
                while (true) {
                    if (i3 >= length) {
                        str = null;
                        str2 = null;
                        i2 = 0;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i3];
                    if (stackTraceElement.getClassName().startsWith(Log.class.getName())) {
                        z = true;
                    } else if (z) {
                        str = stackTraceElement.getClassName();
                        str2 = stackTraceElement.getMethodName();
                        i2 = stackTraceElement.getLineNumber();
                        break;
                    }
                    i3++;
                }
                logRecord.setSourceClassName(str);
                logRecord.setSourceMethodName(str2);
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
                stringBuffer2.append(i2);
                stringBuffer2.append(" ");
                String formatMessage = formatMessage(logRecord);
                stringBuffer2.append(logRecord.getLevel().getLocalizedName());
                stringBuffer2.append(": ");
                stringBuffer2.append(formatMessage);
                stringBuffer2.append(StringUtils.LF);
                if (logRecord.getThrown() != null) {
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        logRecord.getThrown().printStackTrace(printWriter);
                        printWriter.close();
                        stringBuffer2.append(stringWriter.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                stringBuffer = stringBuffer2.toString();
            }
            return stringBuffer;
        }
        return (String) invokeL.objValue;
    }
}
