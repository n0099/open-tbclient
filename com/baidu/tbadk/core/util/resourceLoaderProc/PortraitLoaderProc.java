package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.l.b;
import d.b.c.j.d.a;
import d.b.i0.a0.c;
/* loaded from: classes3.dex */
public class PortraitLoaderProc extends AbstractImageLoaderProc {
    public static BdAsyncTaskParallel mBdAsyncTaskTwo;
    public boolean mForceDownload;
    public int proType;
    public String serverAddr;
    public int size;

    public PortraitLoaderProc(boolean z, boolean z2, int i) {
        this.serverAddr = null;
        this.size = 0;
        this.mForceDownload = false;
        this.proType = 0;
        float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.mForceDownload = z;
        this.proType = i;
        if (f2 < 2.0f) {
            this.serverAddr = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.serverAddr = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.serverAddr = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.serverAddr = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        if (mBdAsyncTaskTwo == null) {
            mBdAsyncTaskTwo = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return mBdAsyncTaskTwo;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        return this.proType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public String getUrlbyClientServerAddr(String str, int i, int i2) {
        if (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://"))) {
            return this.serverAddr + str;
        }
        return str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.u()) {
                aVar.A(i);
                aVar.z(i2);
                c.k().b(str, aVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public a getFromLocal(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        if (this.mForceDownload) {
            return null;
        }
        return super.getFromLocal(str, str2, i, i2, bVar, objArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        if (this.mForceDownload) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a l = c.k().l(str);
        if (z) {
            d.b.c.e.l.a.i(l != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return l;
    }
}
