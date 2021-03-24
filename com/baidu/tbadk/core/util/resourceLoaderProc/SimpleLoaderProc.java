package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tieba.R;
import d.b.b.e.a.d;
import d.b.b.e.a.f.c;
import d.b.b.e.l.b;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class SimpleLoaderProc extends AbstractImageLoaderProc {
    public boolean mIsForceLoad;
    public boolean mIsFromCDN;
    public boolean mIsNeedFormat;
    public int mProcType;
    public int mSuggestHeight;
    public int mSuggestWidth;

    public SimpleLoaderProc(boolean z, boolean z2, boolean z3, int i) {
        this.mIsFromCDN = z;
        this.mIsNeedFormat = z2;
        this.mIsForceLoad = z3;
        this.mProcType = i;
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        if (i == 13) {
            k = k <= 0 ? 200 : k;
            this.mSuggestWidth = k;
            if (k > 480) {
                this.mSuggestWidth = 480;
            }
            if (this.mSuggestWidth > l.e(TbadkCoreApplication.getInst(), 320.0f)) {
                this.mSuggestWidth = l.e(TbadkCoreApplication.getInst(), 320.0f);
            }
            this.mSuggestHeight = this.mSuggestWidth;
        } else if (i == 17) {
            int min = Math.min(l.e(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
            this.mSuggestWidth = min;
            this.mSuggestHeight = (int) (min * 1.6f);
        } else if (i == 15) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds184);
            this.mSuggestHeight = dimensionPixelSize;
            this.mSuggestWidth = dimensionPixelSize;
        } else if (i == 16) {
            int dimensionPixelSize2 = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.mSuggestHeight = dimensionPixelSize2;
            this.mSuggestWidth = dimensionPixelSize2;
        } else if (i == 21) {
            this.mSuggestHeight = 0;
            this.mSuggestWidth = 0;
        } else if (i == 30) {
            if (k <= 0 || k > 644) {
                this.mSuggestWidth = 644;
            }
            if (this.mSuggestWidth > l.e(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
                this.mSuggestWidth = l.e(TbadkCoreApplication.getInst().getApp(), 430.0f);
            }
            this.mSuggestHeight = (int) (this.mSuggestWidth * 0.43f);
        } else {
            this.mSuggestWidth = k;
            this.mSuggestHeight = i2;
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        return this.mProcType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        return this.mSuggestHeight;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        return this.mSuggestWidth;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.b.e.l.e
    public boolean isNeedLoad() {
        if (this.mIsForceLoad) {
            return true;
        }
        return super.isNeedLoad();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public Bitmap resizeBitmapSize(Bitmap bitmap, int i, int i2) {
        int i3 = this.mProcType;
        return (i3 == 13 || i3 == 17) ? bitmap : super.resizeBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
        if (!booleanValue || booleanValue2) {
            return;
        }
        boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
        c cVar = new c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(bArr);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setGif(booleanValue3);
        cVar.d(this.mIsNeedFormat);
        d.g().a(cVar);
        b bVar = (b) objArr[3];
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(cVar);
            bVar.f41847a = diskCancelWorker;
        }
    }
}
