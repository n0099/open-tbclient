package com.baidu.swan.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static final String SPLASH = File.separator;
    private static final String ezC = "zeus" + SPLASH + "libs" + SPLASH;
    private Method ezE;
    private Context mContext;
    private JSONObject mJson_elf;
    private JSONObject mJson_meta;
    private int mMaxAddr;
    private int mMinAddr;
    private int m7zCount = 0;
    private int m7zTotal = 0;
    private String m7zFile = null;
    private int[] m7zSizes = null;
    private int[] m7zOffsets = null;
    private int[] m7zSzOffsets = null;
    private int mOffset_meta = 0;
    private int mOffset_elf = 0;
    private int mOffset_7z = 0;
    private boolean mHooked = false;
    private String mTempPath = null;
    private boolean ezD = false;

    private void init() {
        try {
            System.load(bgt() + "libzeuslzma.so");
            this.ezD = true;
        } catch (Throwable th) {
        }
    }

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private boolean bgm() {
        try {
            byte[] bArr = new byte[64];
            new FileInputStream(bgs()).read(bArr);
            return new String(bArr, "UTF-8").startsWith("zeusmeta");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean bgn() {
        if (bgm()) {
            if (this.ezD && bgo() && isEnoughSpace(this.m7zTotal)) {
                hook(false);
                return bgp() && bgr() && bgq();
            }
            return false;
        }
        return true;
    }

    private boolean bgo() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String bgs = bgs();
        if (!new File(bgs).exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(bgs);
            try {
                byte[] bArr = new byte[512];
                fileInputStream.read(bArr);
                String str = new String(bArr, "UTF-8");
                this.mOffset_meta = str.indexOf("##") + 2;
                this.mOffset_elf = str.indexOf("##", this.mOffset_meta) + 2;
                this.mOffset_7z = str.indexOf("##", this.mOffset_elf) + 2;
                this.mJson_meta = new JSONObject(str.substring(this.mOffset_meta, this.mOffset_elf - 2));
                this.mJson_elf = new JSONObject(str.substring(this.mOffset_elf, this.mOffset_7z - 2));
                int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                JSONArray jSONArray = this.mJson_elf.getJSONArray("loadable");
                int i2 = 0;
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    int i4 = jSONObject.getInt("vaddr");
                    int i5 = jSONObject.getInt("memsz");
                    if (i4 < i) {
                        i = i4;
                    }
                    if (i4 + i5 > i2) {
                        i2 = i4 + i5;
                    }
                }
                this.mMinAddr = i;
                this.mMaxAddr = i2;
                this.m7zCount = this.mJson_meta.getInt("count");
                this.m7zSizes = new int[this.m7zCount];
                this.m7zOffsets = new int[this.m7zCount];
                this.m7zSzOffsets = new int[this.m7zCount];
                this.m7zFile = bgs();
                JSONArray jSONArray2 = this.mJson_meta.getJSONArray("offsets");
                JSONArray jSONArray3 = this.mJson_meta.getJSONArray("szoffsets");
                this.m7zOffsets[0] = 0;
                for (int i6 = 0; i6 < this.m7zCount; i6++) {
                    this.m7zSizes[i6] = jSONArray2.getInt(i6);
                    if (i6 > 0) {
                        this.m7zOffsets[i6] = this.m7zOffsets[i6 - 1] + this.m7zSizes[i6 - 1];
                    }
                    this.m7zSzOffsets[i6] = jSONArray3.getInt(i6) + this.mOffset_7z;
                }
                this.m7zTotal = this.mJson_meta.getInt("total");
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                    }
                }
                return true;
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    private boolean bgp() {
        File file = new File(bgt());
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    private boolean isEnoughSpace(long j) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return availableBlocks * blockSize > j;
        } catch (Exception e) {
            return true;
        }
    }

    private boolean bgq() {
        if (this.m7zCount > 0 && this.m7zTotal > 0) {
            int i = this.m7zCount;
            int i2 = this.m7zTotal;
            String str = this.m7zFile;
            int[] iArr = this.m7zSizes;
            int[] iArr2 = this.m7zOffsets;
            int[] iArr3 = this.m7zSzOffsets;
            if (!this.mHooked) {
                this.mMinAddr = 0;
                this.mMaxAddr = this.m7zTotal;
            }
            String str2 = bgt() + GlobalConstants.LIB_ZEUS_CHROMIUM;
            String str3 = bgt() + GlobalConstants.LIB_ZEUS_CHROMIUM + ".tmp";
            int doInit = doInit(this.mTempPath, str3, this.m7zTotal, this.mMinAddr, this.mMaxAddr, this.mHooked ? 1 : 0);
            if (doInit != 0) {
                return false;
            }
            for (int i3 = 0; i3 < i; i3++) {
                a(null, str, iArr2[i3], iArr[i3], iArr3[i3]);
            }
            if (!this.mHooked) {
                doInit = bgu();
            }
            File file = new File(str3);
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            if (!file.renameTo(file2)) {
                return false;
            }
            deleteDir(new File(this.mTempPath));
            return doInit == 0;
        }
        return true;
    }

    private boolean bgr() {
        this.mTempPath = bgt() + "temp";
        File file = new File(this.mTempPath);
        return file.exists() ? deleteDir(file) : file.mkdirs();
    }

    private void hook(boolean z) {
        if (!z || (this.mMinAddr == 0 && !isCPU64())) {
            try {
                if (doHook(Build.VERSION.SDK_INT, z) > 0) {
                    this.mHooked = true;
                }
            } catch (UnsatisfiedLinkError e) {
            }
        }
    }

    private String bgs() {
        return bgt() + SPLASH + GlobalConstants.LIB_ZEUS_CHROMIUM;
    }

    private String bgt() {
        return this.mContext.getFilesDir() + SPLASH + ezC;
    }

    private boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    private boolean isCPU64() {
        String property = System.getProperty("os.arch");
        if (TextUtils.isEmpty(property) || !property.endsWith("64")) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.product.cpu.abilist64", "");
                if (str != null) {
                    if (!str.isEmpty()) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
            return false;
        }
        return true;
    }

    private int doInit(String str, String str2, int i, int i2, int i3, int i4) {
        SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
        try {
            Method declaredMethod = SevenZipUtils.class.getDeclaredMethod(OneKeyLoginSdkCall.l, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(sevenZipUtils, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    private void a(AssetManager assetManager, String str, int i, int i2, int i3) {
        SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
        if (this.ezE == null) {
            try {
                this.ezE = SevenZipUtils.class.getDeclaredMethod("decodeAndMerge", AssetManager.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            } catch (Exception e) {
            }
        }
        if (this.ezE != null) {
            try {
                this.ezE.setAccessible(true);
                this.ezE.invoke(sevenZipUtils, assetManager, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception e2) {
            }
        }
    }

    private int doHook(int i, boolean z) {
        SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
        try {
            Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("doHook", Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(sevenZipUtils, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    private int bgu() {
        SevenZipUtils sevenZipUtils = SevenZipUtils.getInstance();
        try {
            Method declaredMethod = SevenZipUtils.class.getDeclaredMethod("submit", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(sevenZipUtils, new Object[0])).intValue();
        } catch (Exception e) {
            return -1;
        }
    }
}
