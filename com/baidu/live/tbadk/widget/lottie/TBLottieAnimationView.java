package com.baidu.live.tbadk.widget.lottie;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.h.a.a;
import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.live.adp.lib.util.BdStringHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader;
import com.tb.airbnb.lottie.LottieAnimationView;
import com.tb.airbnb.lottie.d;
import com.tb.airbnb.lottie.e;
import com.tb.airbnb.lottie.h;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    private static final String DIR_ANIMATION = "animation";
    public static final String JSON_FILE = "data.json";
    private boolean isFirstLoadInternal;
    private boolean isSettingForPlay;
    private TBLottieAnimationLoader.OnLoadedCallback mLoadCallback;
    private TBLottieAnimationLoader mLoader;
    private String mUrl;

    public TBLottieAnimationView(Context context) {
        super(context);
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mLoadCallback = new TBLottieAnimationLoader.OnLoadedCallback() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader.OnLoadedCallback
            public void onLoaded(boolean z, String str) {
                if (z && !StringHelper.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mLoadCallback = new TBLottieAnimationLoader.OnLoadedCallback() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader.OnLoadedCallback
            public void onLoaded(boolean z, String str) {
                if (z && !StringHelper.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mLoadCallback = new TBLottieAnimationLoader.OnLoadedCallback() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader.OnLoadedCallback
            public void onLoaded(boolean z, String str) {
                if (z && !StringHelper.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str);
                }
            }
        };
    }

    public static String getAnimationPath() {
        return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/" + DIR_ANIMATION + "/";
    }

    public static boolean checkInternalTempDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public static InputStream getAnimationInputStream(String str, String str2) {
        String animationPath = getAnimationPath();
        if (checkInternalTempDir(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return BdFileHelper.getInStreamFromFile(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void setAnimationUrl(String str) {
        if (!StringHelper.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.mLoader = new TBLottieAnimationLoader(getAnimationPath(), str, this.mLoadCallback);
            this.mLoader.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str) {
        if (!StringHelper.isEmpty(str)) {
            dealImageAsset(str);
            dealJsonFile(str);
        }
    }

    private void dealImageAsset(String str) {
        if (!StringHelper.isEmpty(str)) {
            TBImageAssetDelegate tBImageAssetDelegate = new TBImageAssetDelegate();
            tBImageAssetDelegate.setPath(str);
            tBImageAssetDelegate.setFirstLoadInternal(getFristLoadInternal());
            setImageAssetDelegate(tBImageAssetDelegate);
        }
    }

    private void dealJsonFile(String str) {
        if (!StringHelper.isEmpty(str)) {
            final boolean z = this.isSettingForPlay;
            cancelAnimation();
            InputStream animationInputStream = getAnimationInputStream(str, JSON_FILE);
            if (animationInputStream != null) {
                e.h(animationInputStream, str).a(new h<d>() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.tb.airbnb.lottie.h
                    public void onResult(d dVar) {
                        if (dVar != null) {
                            TBLottieAnimationView.this.setComposition(dVar);
                            if (z) {
                                TBLottieAnimationView.this.playAnimation();
                            }
                        }
                    }
                });
            }
        }
    }

    private boolean checkPermission() {
        return a.checkPermissionGranted(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.tb.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        super.playAnimation();
        this.isSettingForPlay = true;
    }

    @Override // com.tb.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        super.pauseAnimation();
        this.isSettingForPlay = false;
    }

    @Override // com.tb.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.isSettingForPlay = false;
    }

    @Override // com.tb.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        super.resumeAnimation();
        this.isSettingForPlay = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.isFirstLoadInternal = z;
    }

    public boolean getFristLoadInternal() {
        return this.isFirstLoadInternal;
    }
}
