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
        } else if (z && System.currentTimeMillis() - getmLastUploadTime() >= f.eq().ew()) {
            z2 = true;
        }
        if (z2) {
            a aVar = new a(this, this.mLogDir, getCurrentLogFile(), this.mLogDir, getUploadingLogFile(), DiskFileOperate.Action.RENAME, this);
            aVar.q(this.mUseSdCard);
            if (this.mCanTrySuccess) {
                aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar.E(3);
            }
            aVar.ce();
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
                bVar.q(this.mUseSdCard);
                bVar.setContent(this.mMemCache.toString());
                clearMemData();
                if (this.mCanTrySuccess) {
                    bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                    bVar.E(3);
                }
                if (!com.baidu.adp.lib.Disk.d.bM().c(bVar)) {
                    this.mFileExceptionCount++;
                }
            } else if (z) {
                f.eq().b(this, z);
            }
        }
    }

    private File[] el() {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, null, DiskFileOperate.Action.INFO);
        diskFileOperate.q(this.mUseSdCard);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bM().b(diskFileOperate);
        if (diskFileOperate.cc() != null) {
            return diskFileOperate.cc().listFiles();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public void clearLogResource() {
        ArrayList<s> em;
        int i;
        int logFilesMaxSize = getLogFilesMaxSize();
        if (logFilesMaxSize > 0 && (em = em()) != null && em.size() != 0) {
            int i2 = 0;
            Iterator<s> it = em.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = (int) (it.next().mD + i);
            }
            int i3 = i - logFilesMaxSize;
            if (i3 > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                Collections.sort(em, new e(this, null));
                Iterator<s> it2 = em.iterator();
                while (true) {
                    int i4 = i3;
                    if (!it2.hasNext()) {
                        break;
                    }
                    s next = it2.next();
                    arrayList.add(next.mFileName);
                    i3 = (int) (i4 - next.mD);
                    if (i3 <= 0) {
                        break;
                    }
                }
                g(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, str, DiskFileOperate.Action.DELETE);
        diskFileOperate.q(this.mUseSdCard);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bM().c(diskFileOperate);
    }

    private void g(ArrayList<String> arrayList) {
        d dVar = new d(this, this.mLogDir, null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        dVar.q(this.mUseSdCard);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bM().b(dVar);
    }

    private void h(ArrayList<String> arrayList) {
        d dVar = new d(this, this.mLogDir, null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        dVar.q(this.mUseSdCard);
        dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bM().c(dVar);
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public BdUploadingLogInfo getLogFiles() {
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(this.mLogDir, this.mUseSdCard, this.mCanTrySuccess);
        ArrayList<s> em = em();
        if (em != null && em.size() > 0) {
            if (em.size() > 1) {
                Collections.sort(em, new e(this, null));
            }
            long j = 0;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < em.size(); i++) {
                s sVar = em.get(i);
                if (sVar.mD + j <= 102400) {
                    j += sVar.mD;
                    arrayList.add(sVar);
                } else {
                    if (arrayList != null && arrayList.size() > 0) {
                        bdUploadingLogInfo.add(arrayList);
                    }
                    arrayList = new ArrayList();
                    j = sVar.mD;
                    arrayList.add(sVar);
                }
            }
            if (arrayList.size() > 0) {
                bdUploadingLogInfo.add(arrayList);
            }
        }
        return bdUploadingLogInfo;
    }

    private ArrayList<s> em() {
        ArrayList<s> arrayList;
        String name;
        String str = "Uploading" + this.mFileSuffixString;
        String str2 = String.valueOf(this.mFilePrefixString) + "Writing" + this.mFileSuffixString;
        ArrayList<s> arrayList2 = new ArrayList<>();
        File[] el = el();
        if (el != null) {
            for (File file : el) {
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
                    long j = next.mE;
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
            h(arrayList4);
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
            h(arrayList2);
        }
        this.mLastUploadTime = System.currentTimeMillis();
    }

    private String ah(String str) {
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e(this.mLogDir, str, DiskFileOperate.Action.READ);
        eVar.q(this.mUseSdCard);
        eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.bM().b(eVar);
        if (eVar.isSuccess()) {
            return eVar.getContent();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.BdStatBase
    public ArrayList<String> readLogFile(String str) {
        String ah = ah(str);
        if (!TextUtils.isEmpty(ah)) {
            String[] split = ah.split("\r\n");
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
        ArrayList<s> em = em();
        if (em != null && em.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<s> it = em.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next.mD > 122880) {
                    arrayList.add(next);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ai(((s) it2.next()).mFileName);
            }
        }
    }

    private void ai(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.mLogDir, str, DiskFileOperate.Action.CUSTOM);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.o(true);
        diskFileOperate.a(new c(this));
        com.baidu.adp.lib.Disk.d.bM().b(diskFileOperate);
    }
}
