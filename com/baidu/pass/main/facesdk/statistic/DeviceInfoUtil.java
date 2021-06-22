package com.baidu.pass.main.facesdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class DeviceInfoUtil {
    public static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.baidu.pass.main.facesdk.statistic.DeviceInfoUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i2 = 3; i2 < name.length(); i2++) {
                    if (name.charAt(i2) < '0' || name.charAt(i2) > '9') {
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
        } catch (IOException e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str == null) {
            return 0;
        }
        if (str.contains("aarch64")) {
            return 64;
        }
        return 32;
    }

    public static int getDeviceBasicFrequency() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        IOException e2;
        FileNotFoundException e3;
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
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            try {
                                bufferedReader2.close();
                                return parseInt;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return parseInt;
                            }
                        } catch (FileNotFoundException e6) {
                            e3 = e6;
                            e3.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return 0;
                        } catch (IOException e8) {
                            e2 = e8;
                            e2.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return 0;
                        }
                    } catch (FileNotFoundException e10) {
                        bufferedReader2 = null;
                        e3 = e10;
                    } catch (IOException e11) {
                        bufferedReader2 = null;
                        e2 = e11;
                    } catch (Throwable th) {
                        bufferedReader = null;
                        th = th;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e14) {
                    e14.printStackTrace();
                    return 0;
                }
            } catch (FileNotFoundException e15) {
                bufferedReader2 = null;
                e3 = e15;
                fileReader = null;
            } catch (IOException e16) {
                bufferedReader2 = null;
                e2 = e16;
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
            return new BufferedReader(new FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2)[1];
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
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

    public static String getFieldFromCpuinfo(String str) throws IOException {
        Matcher matcher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
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

    public static String getStorageInfo(Context context, int i2) {
        String storagePath = getStoragePath(context, i2);
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

    public static String getStoragePath(Context context, int i2) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
            if (i2 != 0) {
                if (i2 == 1 && strArr.length > 1) {
                    return strArr[i2];
                }
                return null;
            }
            return strArr[i2];
        } catch (Exception e2) {
            e2.printStackTrace();
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
