package com.baidu.live.tbadk.widget.lottie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.tb.airbnb.lottie.b;
import com.tb.airbnb.lottie.g;
/* loaded from: classes2.dex */
public class TBImageAssetDelegate implements b {
    private static final String DIR_ANIMATION = "animation";
    public static final String INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private boolean isFirstLoadInternal = false;
    private String mPath;

    @Override // com.tb.airbnb.lottie.b
    public Bitmap fetchBitmap(g gVar) {
        if (StringHelper.isEmpty(this.mPath)) {
            return null;
        }
        return BitmapFactory.decodeFile(this.mPath + gVar.bw().replace("/", "") + "/" + gVar.getFileName());
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
