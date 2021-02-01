package com.baidu.live.tbadk.widget.lottie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.live.lottie.c;
import com.baidu.live.lottie.i;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes11.dex */
public class TBImageAssetDelegate implements c {
    private static final String DIR_ANIMATION = "animation";
    public static final String INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private boolean isFirstLoadInternal = false;
    private String mPath;

    @Override // com.baidu.live.lottie.c
    public Bitmap fetchBitmap(i iVar) {
        if (StringHelper.isEmpty(this.mPath)) {
            return null;
        }
        return BitmapFactory.decodeFile(this.mPath + iVar.ik().replace("/", "") + "/" + iVar.getFileName());
    }

    public void setPath(String str) {
        this.mPath = getAnimationPath() + str + "/";
    }

    public static String getAnimationPath() {
        return INTERNEL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + DIR_ANIMATION + "/";
    }

    public void setFirstLoadInternal(boolean z) {
        this.isFirstLoadInternal = z;
    }

    public boolean getFristLoadInternal() {
        return this.isFirstLoadInternal;
    }
}
