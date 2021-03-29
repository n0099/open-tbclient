package com.baidu.android.common.logging;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class Log {
    public static final int FILE_LIMETE = 10485760;
    public static final int FILE_NUMBER = 2;
    public static Logger sFilelogger = null;
    public static boolean sLog2File = false;
    public static boolean sLogEnabled = true;

    public static void d(String str, String str2) {
        Logger logger;
        if (sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.INFO;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        Logger logger;
        if (sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.SEVERE;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.e(str, str2);
        }
    }

    public static String getLogFileName() {
        String processNameForPid = getProcessNameForPid(Process.myPid());
        if (TextUtils.isEmpty(processNameForPid)) {
            processNameForPid = "BaiduFileLog";
        }
        return processNameForPid.replace(':', '_');
    }

    public static String getProcessNameForPid(int i) {
        String str = "/proc/" + i + "/cmdline";
        String str2 = "/proc/" + i + "/status";
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                str3 = readLine.substring(0, readLine.indexOf(0));
            } else {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(str2)));
                String readLine2 = bufferedReader2.readLine();
                while (true) {
                    if (readLine2 == null) {
                        break;
                    } else if (readLine2.startsWith("Name:")) {
                        int indexOf = readLine2.indexOf(TrackUI.SEPERATOR);
                        if (indexOf >= 0) {
                            str3 = readLine2.substring(indexOf + 1);
                        }
                    } else {
                        readLine2 = bufferedReader2.readLine();
                    }
                }
                bufferedReader = bufferedReader2;
            }
            bufferedReader.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str3;
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void i(String str, String str2) {
        Logger logger;
        if (sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.INFO;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.i(str, str2);
        }
    }

    public static void setLog2File(boolean z) {
        sLog2File = z;
        if (z && sFilelogger == null) {
            String logFileName = getLogFileName();
            String absolutePath = new File(Environment.getExternalStorageDirectory(), logFileName).getAbsolutePath();
            try {
                FileHandler fileHandler = new FileHandler(absolutePath + "_%g.log", 10485760, 2, true);
                fileHandler.setFormatter(new SimpleFormatter());
                Logger logger = Logger.getLogger(logFileName);
                sFilelogger = logger;
                logger.setLevel(Level.ALL);
                sFilelogger.addHandler(fileHandler);
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (SecurityException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void setLogEnabled(boolean z) {
        sLogEnabled = z;
    }

    public static void v(String str, String str2) {
        Logger logger;
        if (sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.INFO;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        Logger logger;
        if (sLogEnabled) {
            if (sLog2File && (logger = sFilelogger) != null) {
                Level level = Level.WARNING;
                logger.log(level, str + ": " + str2);
                return;
            }
            android.util.Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        d(str, str2 + '\n' + getStackTraceString(th));
    }

    public static void e(String str, Throwable th) {
        e(str, getStackTraceString(th));
    }

    public static void i(String str, String str2, Throwable th) {
        i(str, str2 + '\n' + getStackTraceString(th));
    }

    public static void v(String str, String str2, Throwable th) {
        v(str, str2 + '\n' + getStackTraceString(th));
    }

    public static void w(String str, String str2, Throwable th) {
        w(str, str2 + '\n' + getStackTraceString(th));
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, str2 + '\n' + getStackTraceString(th));
    }
}
