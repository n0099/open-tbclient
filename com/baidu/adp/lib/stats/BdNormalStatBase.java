package com.baidu.adp.lib.stats;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public abstract class BdNormalStatBase extends BdStatBase {
    private static final long serialVersionUID = 451404975794074498L;
    private final String CONST_UPLOADING;
    private final String CONST_WRITING;
    protected boolean mCanTrySuccess;
    private long mCurrentFileSize;
    protected String mFilePrefixString;
    protected String mFileSuffixString;
    protected boolean mUseSdCard;

    public BdNormalStatBase(Context context, String str, boolean z) {
        super(context, str, z);
        this.mUseSdCard = true;
        this.mCanTrySuccess = true;
        this.mCurrentFileSize = 0L;
        this.CONST_WRITING = "Writing";
        this.CONST_UPLOADING = "Uploading";
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public boolean checkToSendSaveMessage(boolean z) {
        return z || isNeedRefreshFile();
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public String getCurrentLogFile() {
        if (this.mCurrentLogFile == null) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.mFilePrefixString);
            sb.append(mProcessNameMd5);
            sb.append("Writing");
            sb.append(this.mFileSuffixString);
            this.mCurrentLogFile = sb.toString();
        }
        return this.mCurrentLogFile;
    }

    public String getUploadingLogFile() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.mFilePrefixString);
        sb.append(System.currentTimeMillis());
        sb.append(mProcessNameMd5);
        sb.append("Uploading");
        sb.append(this.mFileSuffixString);
        return sb.toString();
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public boolean checkToSendUploadMessage(boolean z) {
        boolean z2 = false;
        if (isLogDataFull()) {
            z2 = true;
        } else if (z && System.currentTimeMillis() - getmLastUploadTime() >= d.b().g()) {
            z2 = true;
        }
        if (z2) {
            a aVar = new a(this, this.mLogDir, getCurrentLogFile(), this.mLogDir, getUploadingLogFile(), DiskFileOperate.Action.RENAME, this);
            aVar.e(this.mUseSdCard);
            if (this.mCanTrySuccess) {
                aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar.a(3);
            }
            aVar.q();
        }
        return true;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void changeUser(String str) {
        this.mUid = str;
        this.mCurrentLogFile = null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public String getPostFileName() {
        return "omp";
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public boolean checkFileFailed() {
        return this.mFileExceptionCount > 5;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void clearLogs() {
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void refreshFile(boolean z) {
        if (!checkFileFailed()) {
            if (this.mMemCacheCount > 0) {
                b bVar = new b(this, this.mLogDir, getCurrentLogFile(), DiskFileOperate.Action.APPEND, this, z);
                bVar.e(this.mUseSdCard);
                bVar.a(this.mMemCache.toString());
                clearMemData();
                if (this.mCanTrySuccess) {
                    bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                    bVar.a(3);
                }
                if (!com.baidu.adp.lib.Disk.d.a().b(bVar)) {
                    this.mFileExceptionCount++;
                }
            } else if (z) {
                d.b().a(this, z);
            }
        }
    }

    private File[] a() {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, null, DiskFileOperate.Action.INFO);
        diskFileOperate.e(this.mUseSdCard);
        if (this.mCanTrySuccess) {
            diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskFileOperate.a(3);
        }
        com.baidu.adp.lib.Disk.d.a().a(diskFileOperate);
        return diskFileOperate.n().listFiles();
    }

    private void a(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, str, DiskFileOperate.Action.DELETE);
        diskFileOperate.e(this.mUseSdCard);
        if (this.mCanTrySuccess) {
            diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskFileOperate.a(3);
        }
        com.baidu.adp.lib.Disk.d.a().b(diskFileOperate);
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public BdUploadingLogInfo getLogFiles() {
        ArrayList arrayList;
        String name;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = new ArrayList();
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(this.mLogDir, this.mUseSdCard, this.mCanTrySuccess);
        File[] a = a();
        String str = "Uploading" + this.mFileSuffixString;
        String str2 = String.valueOf(this.mFilePrefixString) + "Writing" + this.mFileSuffixString;
        if (a != null) {
            ArrayList arrayList4 = new ArrayList();
            for (File file : a) {
                if (file.isFile() && (name = file.getName()) != null && !name.equals(getCurrentLogFile())) {
                    long length = file.length();
                    if (name.endsWith(str) && name.startsWith(this.mFilePrefixString)) {
                        arrayList4.add(new q(name, length, file.lastModified()));
                    } else if (name.startsWith(this.mFilePrefixString) && name.contains("Uploading") && name.endsWith(this.mFileSuffixString)) {
                        if (this.mFilePrefixString == "stat") {
                            arrayList4.add(new q(name, length, file.lastModified()));
                        }
                    } else if (name.startsWith(str2) && this.mFilePrefixString == "stat") {
                        arrayList4.add(new q(name, length, file.lastModified()));
                    }
                }
            }
            arrayList2 = arrayList4;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mFilePrefixString != "stat") {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                q qVar = (q) it.next();
                long j = qVar.c;
                if (j != 0 && j + 259200000 < currentTimeMillis) {
                    a(qVar.b);
                } else {
                    arrayList3.add(qVar);
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = arrayList2;
        }
        if (arrayList != null && arrayList.size() > 0) {
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, new c(this, null));
            }
            long j2 = 0;
            ArrayList arrayList5 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                q qVar2 = (q) arrayList.get(i);
                if (qVar2.a + j2 <= 102400) {
                    j2 += qVar2.a;
                    arrayList5.add(qVar2);
                } else {
                    if (arrayList5 != null && arrayList5.size() > 0) {
                        bdUploadingLogInfo.add(arrayList5);
                    }
                    arrayList5 = new ArrayList();
                    j2 = qVar2.a;
                    arrayList5.add(qVar2);
                }
            }
            if (arrayList5.size() > 0) {
                bdUploadingLogInfo.add(arrayList5);
            }
        }
        return bdUploadingLogInfo;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    protected boolean isLogDataFull() {
        if (this.mMemCacheCount > this.mMaxMemCount) {
            return true;
        }
        return !TextUtils.isEmpty(this.mCurrentLogFile) && this.mCurrentFileSize > 102400;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void uploadSucc(ArrayList<q> arrayList) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next().b);
        }
        this.mLastUploadTime = System.currentTimeMillis();
    }

    private String b(String str) {
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e(this.mLogDir, str, DiskFileOperate.Action.READ);
        eVar.e(this.mUseSdCard);
        if (this.mCanTrySuccess) {
            eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            eVar.a(3);
        }
        com.baidu.adp.lib.Disk.d.a().a(eVar);
        if (eVar.g()) {
            return eVar.u();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public ArrayList<String> readLogFile(String str) {
        String b = b(str);
        if (!TextUtils.isEmpty(b)) {
            String[] split = b.split(IOUtils.LINE_SEPARATOR_WINDOWS);
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : split) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        return null;
    }
}
