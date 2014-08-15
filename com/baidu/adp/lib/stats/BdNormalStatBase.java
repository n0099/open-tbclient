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
        } else if (z && System.currentTimeMillis() - getmLastUploadTime() >= f.c().g()) {
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
                f.c().a(this, z);
            }
        }
    }

    private File[] a() {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, null, DiskFileOperate.Action.INFO);
        diskFileOperate.e(this.mUseSdCard);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.a().a(diskFileOperate);
        return diskFileOperate.n().listFiles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, str, DiskFileOperate.Action.DELETE);
        diskFileOperate.e(this.mUseSdCard);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.a().b(diskFileOperate);
    }

    private void a(ArrayList<String> arrayList) {
        d dVar = new d(this, this.mLogDir, null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        dVar.e(this.mUseSdCard);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.a().b(dVar);
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public BdUploadingLogInfo getLogFiles() {
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(this.mLogDir, this.mUseSdCard, this.mCanTrySuccess);
        ArrayList<s> b = b();
        if (b != null && b.size() > 0) {
            if (b.size() > 1) {
                Collections.sort(b, new e(this, null));
            }
            long j = 0;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < b.size(); i++) {
                s sVar = b.get(i);
                if (sVar.a + j <= 102400) {
                    j += sVar.a;
                    arrayList.add(sVar);
                } else {
                    if (arrayList != null && arrayList.size() > 0) {
                        bdUploadingLogInfo.add(arrayList);
                    }
                    arrayList = new ArrayList();
                    j = sVar.a;
                    arrayList.add(sVar);
                }
            }
            if (arrayList.size() > 0) {
                bdUploadingLogInfo.add(arrayList);
            }
        }
        return bdUploadingLogInfo;
    }

    private ArrayList<s> b() {
        String name;
        String str = "Uploading" + this.mFileSuffixString;
        String str2 = String.valueOf(this.mFilePrefixString) + "Writing" + this.mFileSuffixString;
        ArrayList<s> arrayList = null;
        File[] a = a();
        if (a != null) {
            ArrayList<s> arrayList2 = new ArrayList<>();
            for (File file : a) {
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
            arrayList = arrayList2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<s> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        if (this.mFilePrefixString != "stat") {
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                long j = next.c;
                if (j != 0 && j + 259200000 < currentTimeMillis) {
                    arrayList4.add(next.b);
                } else {
                    arrayList3.add(next);
                }
            }
            arrayList = arrayList3;
        }
        if (arrayList4.size() > 0) {
            a(arrayList4);
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
            arrayList2.add(it.next().b);
        }
        if (arrayList2.size() > 0) {
            a(arrayList2);
        }
        this.mLastUploadTime = System.currentTimeMillis();
    }

    private String b(String str) {
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e(this.mLogDir, str, DiskFileOperate.Action.READ);
        eVar.e(this.mUseSdCard);
        eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.a().a(eVar);
        if (eVar.g()) {
            return eVar.v();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public ArrayList<String> readLogFile(String str) {
        String b = b(str);
        if (!TextUtils.isEmpty(b)) {
            String[] split = b.split("\r\n");
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
        ArrayList<s> b = b();
        if (b != null && b.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<s> it = b.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next.a > 122880) {
                    arrayList.add(next);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                c(((s) it2.next()).b);
            }
        }
    }

    private void c(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, str, DiskFileOperate.Action.CUSTOM);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.b(true);
        diskFileOperate.a((com.baidu.adp.lib.Disk.g) new c(this));
        com.baidu.adp.lib.Disk.d.a().a(diskFileOperate);
    }
}
