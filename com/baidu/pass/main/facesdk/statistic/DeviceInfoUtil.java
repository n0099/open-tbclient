package com.baidu.pass.main.facesdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.kuaishou.weapon.p0.bk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class DeviceInfoUtil {
    public static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.baidu.pass.main.facesdk.statistic.DeviceInfoUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
    public static final String CurPath = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    public static Integer getCPUBit() {
        String str;
        try {
            str = getFieldFromCpuinfo("Processor");
        } catch (IOException e) {
            e.printStackTrace();
            str = null;
        }
        if (str != null) {
            return Integer.valueOf(str.contains("aarch64") ? 64 : 32);
        }
        return 0;
    }

    public static int getDeviceBasicFrequency() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        IOException e;
        FileNotFoundException e2;
        try {
            try {
                try {
                    fileReader = new FileReader(CurPath);
                    try {
                        bufferedReader2 = new BufferedReader(fileReader);
                        try {
                            int parseInt = Integer.parseInt(bufferedReader2.readLine().trim());
                            try {
                                fileReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            try {
                                bufferedReader2.close();
                                return parseInt;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return parseInt;
                            }
                        } catch (FileNotFoundException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return 0;
                        } catch (IOException e7) {
                            e = e7;
                            e.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return 0;
                        }
                    } catch (FileNotFoundException e9) {
                        bufferedReader2 = null;
                        e2 = e9;
                    } catch (IOException e10) {
                        bufferedReader2 = null;
                        e = e10;
                    } catch (Throwable th) {
                        bufferedReader = null;
                        th = th;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e13.printStackTrace();
                    return 0;
                }
            } catch (FileNotFoundException e14) {
                bufferedReader2 = null;
                e2 = e14;
                fileReader = null;
            } catch (IOException e15) {
                bufferedReader2 = null;
                e = e15;
                fileReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
                fileReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String getDeviceBoard() {
        return Build.BOARD;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceProcessor() {
        try {
            String[] split = new BufferedReader(new FileReader(bk.a)).readLine().split(":\\s+", 2);
            for (int i = 0; i < split.length; i++) {
            }
            return split[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getDeviceProduct() {
        return Build.PRODUCT;
    }

    public static int getDeviceSDK() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getFieldFromCpuinfo(String str) {
        Matcher matcher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(bk.a));
        Pattern compile = Pattern.compile(str + "\\s*:\\s*(.*)");
        do {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return null;
                }
                matcher = compile.matcher(readLine);
            } finally {
                bufferedReader.close();
            }
        } while (!matcher.matches());
        return matcher.group(1);
    }

    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return 0;
        }
    }

    public static long getRamInfo(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String getStorageInfo(Context context, int i) {
        String storagePath = getStoragePath(context, i);
        if (!isSDCardMount() || storagePath == null || storagePath.toString().equals("")) {
            return "无外置SD卡";
        }
        StatFs statFs = new StatFs(new File(storagePath).getPath());
        long blockCountLong = statFs.getBlockCountLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        long j = blockCountLong * blockSizeLong;
        long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
        return "可用/总共：" + Long.toString(availableBlocksLong) + "/" + Long.toString(j);
    }

    public static String getStoragePath(Context context, int i) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
            if (i != 0) {
                if (i == 1 && strArr.length > 1) {
                    return strArr[i];
                }
                return null;
            }
            return strArr[i];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static boolean isSDCardMount() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
