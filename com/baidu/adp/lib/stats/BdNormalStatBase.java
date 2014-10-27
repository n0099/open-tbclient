package com.baidu.adp.lib.stats;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class BdNormalStatBase extends BdStatBase {
    private static final long serialVersionUID = 451404975794074498L;
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
        } else if (z && System.currentTimeMillis() - getmLastUploadTime() >= f.er().ex()) {
            z2 = true;
        }
        if (z2) {
            a aVar = new a(this, this.mLogDir, getCurrentLogFile(), this.mLogDir, getUploadingLogFile(), DiskFileOperate.Action.RENAME, this);
            aVar.m(this.mUseSdCard);
            if (this.mCanTrySuccess) {
                aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar.n(3);
            }
            aVar.bF();
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
                bVar.m(this.mUseSdCard);
                bVar.setContent(this.mMemCache.toString());
                clearMemData();
                if (this.mCanTrySuccess) {
                    bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                    bVar.n(3);
                }
                if (!com.baidu.adp.lib.Disk.d.bn().c(bVar)) {
                    this.mFileExceptionCount++;
                }
            } else if (z) {
                f.er().b(this, z);
            }
        }
    }

    private File[] em() {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, null, DiskFileOperate.Action.INFO);
        diskFileOperate.m(this.mUseSdCard);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bn().b(diskFileOperate);
        if (diskFileOperate.bD() != null) {
            return diskFileOperate.bD().listFiles();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void clearLogResource() {
        ArrayList<s> en;
        int i;
        int logFilesMaxSize = getLogFilesMaxSize();
        if (logFilesMaxSize > 0 && (en = en()) != null && en.size() != 0) {
            int i2 = 0;
            Iterator<s> it = en.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = (int) (it.next().mC + i);
            }
            int i3 = i - logFilesMaxSize;
            if (i3 > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                Collections.sort(en, new e(this, null));
                Iterator<s> it2 = en.iterator();
                while (true) {
                    int i4 = i3;
                    if (!it2.hasNext()) {
                        break;
                    }
                    s next = it2.next();
                    arrayList.add(next.mFileName);
                    i3 = (int) (i4 - next.mC);
                    if (i3 <= 0) {
                        break;
                    }
                }
                d(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, str, DiskFileOperate.Action.DELETE);
        diskFileOperate.m(this.mUseSdCard);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bn().c(diskFileOperate);
    }

    private void d(ArrayList<String> arrayList) {
        d dVar = new d(this, this.mLogDir, null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        dVar.m(this.mUseSdCard);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bn().b(dVar);
    }

    private void e(ArrayList<String> arrayList) {
        d dVar = new d(this, this.mLogDir, null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        dVar.m(this.mUseSdCard);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bn().c(dVar);
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public BdUploadingLogInfo getLogFiles() {
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(this.mLogDir, this.mUseSdCard, this.mCanTrySuccess);
        ArrayList<s> en = en();
        if (en != null && en.size() > 0) {
            if (en.size() > 1) {
                Collections.sort(en, new e(this, null));
            }
            long j = 0;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < en.size(); i++) {
                s sVar = en.get(i);
                if (sVar.mC + j <= 102400) {
                    j += sVar.mC;
                    arrayList.add(sVar);
                } else {
                    if (arrayList != null && arrayList.size() > 0) {
                        bdUploadingLogInfo.add(arrayList);
                    }
                    arrayList = new ArrayList();
                    j = sVar.mC;
                    arrayList.add(sVar);
                }
            }
            if (arrayList.size() > 0) {
                bdUploadingLogInfo.add(arrayList);
            }
        }
        return bdUploadingLogInfo;
    }

    private ArrayList<s> en() {
        ArrayList<s> arrayList;
        String name;
        String str = "Uploading" + this.mFileSuffixString;
        String str2 = String.valueOf(this.mFilePrefixString) + "Writing" + this.mFileSuffixString;
        ArrayList<s> arrayList2 = new ArrayList<>();
        File[] em = em();
        if (em != null) {
            for (File file : em) {
                if (file.isFile() && (name = file.getName()) != null && !name.equals(getCurrentLogFile())) {
                    long length = file.length();
                    if (name.endsWith(str) && name.startsWith(this.mFilePrefixString)) {
                        arrayList2.add(new s(name, length, file.lastModified()));
                    } else if (name.startsWith(this.mFilePrefixString) && name.contains("Uploading") && name.endsWith(this.mFileSuffixString)) {
                        if (this.mFilePrefixString == "stat") {
                            arrayList2.add(new s(name, length, file.lastModified()));
                        }
                    } else if (name.startsWith(str2) && this.mFilePrefixString == "stat") {
                        arrayList2.add(new s(name, length, file.lastModified()));
                    }
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<s> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        if (this.mFilePrefixString != "stat") {
            Iterator<s> it = arrayList2.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null) {
                    long j = next.mD;
                    if (j != 0 && j + 259200000 < currentTimeMillis) {
                        arrayList4.add(next.mFileName);
                    } else {
                        arrayList3.add(next);
                    }
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = arrayList2;
        }
        if (arrayList4.size() > 0) {
            e(arrayList4);
        }
        return arrayList;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    protected boolean isLogDataFull() {
        if (this.mMemCacheCount > this.mMaxMemCount) {
            return true;
        }
        return !TextUtils.isEmpty(this.mCurrentLogFile) && this.mCurrentFileSize > 102400;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void uploadSucc(ArrayList<s> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<s> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().mFileName);
        }
        if (arrayList2.size() > 0) {
            e(arrayList2);
        }
        this.mLastUploadTime = System.currentTimeMillis();
    }

    private String ad(String str) {
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e(this.mLogDir, str, DiskFileOperate.Action.READ);
        eVar.m(this.mUseSdCard);
        eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bn().b(eVar);
        if (eVar.isSuccess()) {
            return eVar.getContent();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public ArrayList<String> readLogFile(String str) {
        String ad = ad(str);
        if (!TextUtils.isEmpty(ad)) {
            String[] split = ad.split("\r\n");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : split) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void splitFile() {
        ArrayList<s> en = en();
        if (en != null && en.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<s> it = en.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next.mC > 122880) {
                    arrayList.add(next);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ae(((s) it2.next()).mFileName);
            }
        }
    }

    private void ae(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, str, DiskFileOperate.Action.CUSTOM);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.k(true);
        diskFileOperate.a(new c(this));
        com.baidu.adp.lib.Disk.d.bn().b(diskFileOperate);
    }
}
