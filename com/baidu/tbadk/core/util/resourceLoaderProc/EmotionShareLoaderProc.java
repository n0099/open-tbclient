package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbMd5;
import d.a.c.e.a.d;
import d.a.c.e.l.b;
import d.a.c.e.l.e;
import d.a.c.j.d.a;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionShareLoaderProc implements e<EmotionShare> {
    public final MemeLoaderProc2 impl;

    /* loaded from: classes3.dex */
    public static class EmotionShare {
        public a image;
        public String path;

        public EmotionShare(a aVar, String str) {
            this.image = aVar;
            this.path = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class ForceDeleteFileOperate extends DiskFileOperate implements d.a.c.e.a.a {
        public ForceDeleteFileOperate(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
        }

        @Override // d.a.c.e.a.a
        public boolean compare(File file) {
            return true;
        }
    }

    public EmotionShareLoaderProc() {
        MemeLoaderProc2 memeLoaderProc2 = new MemeLoaderProc2();
        this.impl = memeLoaderProc2;
        memeLoaderProc2.setIsShare(true);
    }

    private DiskFileOperate buildExtractToShareHubDiskOp(a aVar, String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.setSubFolder(true);
        diskFileOperate.setSavedCache(true);
        diskFileOperate.setSdCard(true);
        diskFileOperate.setData(aVar.k());
        return diskFileOperate;
    }

    private void clearShareHub() {
        ForceDeleteFileOperate forceDeleteFileOperate = new ForceDeleteFileOperate(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        forceDeleteFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        forceDeleteFileOperate.setSubFolder(true);
        forceDeleteFileOperate.setSavedCache(true);
        forceDeleteFileOperate.setSdCard(true);
        d.g().d(forceDeleteFileOperate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public EmotionShare m18decodeToResource(byte[] bArr, Object... objArr) {
        return null;
    }

    @Override // d.a.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return this.impl.getAsyncTaskParallel();
    }

    @Override // d.a.c.e.l.e
    public int getAsyncTaskPriority() {
        return this.impl.getAsyncTaskPriority();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public EmotionShare getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        return null;
    }

    @Override // d.a.c.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
    }

    @Override // d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        this.impl.updateMemory(str, obj, i2, i3, objArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public EmotionShare getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        clearShareHub();
        a fromLocal = this.impl.getFromLocal(str, str2, i2, i3, bVar, objArr);
        if (fromLocal == null || fromLocal.k() == null) {
            return null;
        }
        DiskFileOperate buildExtractToShareHubDiskOp = buildExtractToShareHubDiskOp(fromLocal, str2);
        if (!d.g().d(buildExtractToShareHubDiskOp) || buildExtractToShareHubDiskOp.getFileInfo() == null) {
            return null;
        }
        return new EmotionShare(fromLocal, buildExtractToShareHubDiskOp.getFileInfo().getAbsolutePath());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public EmotionShare getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        clearShareHub();
        a fromRemote = this.impl.getFromRemote(str, str2, i2, i3, bVar, objArr);
        if (fromRemote == null || fromRemote.k() == null) {
            return null;
        }
        DiskFileOperate buildExtractToShareHubDiskOp = buildExtractToShareHubDiskOp(fromRemote, str2);
        if (!d.g().d(buildExtractToShareHubDiskOp) || buildExtractToShareHubDiskOp.getFileInfo() == null) {
            return null;
        }
        return new EmotionShare(fromRemote, buildExtractToShareHubDiskOp.getFileInfo().getAbsolutePath());
    }
}
