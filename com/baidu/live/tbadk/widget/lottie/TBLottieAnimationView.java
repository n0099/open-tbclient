package com.baidu.live.tbadk.widget.lottie;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.live.adp.lib.util.BdStringHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader;
import com.tb.airbnb.lottie.LottieAnimationView;
import com.tb.airbnb.lottie.a;
import com.tb.airbnb.lottie.e;
import com.tb.airbnb.lottie.h;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    private static final String DIR_ANIMATION = "animation";
    public static final String JSON_FILE = "data.json";
    private LottieAnimationView.CacheStrategy defaultCacheStrategy;
    private boolean isFirstLoadInternal;
    private boolean isSettingForPlay;
    private LottieAnimationView.CacheStrategy mCacheStrategy;
    private a mCompositionLoader;
    private TBLottieAnimationLoader.OnLoadedCallback mLoadCallback;
    private TBLottieAnimationLoader mLoader;
    private String mUrl;
    private static final Map<String, e> REMOTE_STRONG_REF_CACHE = new HashMap();
    private static final Map<String, WeakReference<e>> REMOTE_WEAK_REF_CACHE = new HashMap();
    public static final String INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.defaultCacheStrategy = LottieAnimationView.CacheStrategy.Weak;
        this.mCacheStrategy = this.defaultCacheStrategy;
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mLoadCallback = new TBLottieAnimationLoader.OnLoadedCallback() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader.OnLoadedCallback
            public void onLoaded(boolean z, String str) {
                if (z && !StringHelper.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.mCacheStrategy);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.defaultCacheStrategy = LottieAnimationView.CacheStrategy.Weak;
        this.mCacheStrategy = this.defaultCacheStrategy;
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mLoadCallback = new TBLottieAnimationLoader.OnLoadedCallback() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader.OnLoadedCallback
            public void onLoaded(boolean z, String str) {
                if (z && !StringHelper.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.mCacheStrategy);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultCacheStrategy = LottieAnimationView.CacheStrategy.Weak;
        this.mCacheStrategy = this.defaultCacheStrategy;
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mLoadCallback = new TBLottieAnimationLoader.OnLoadedCallback() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.live.tbadk.widget.lottie.TBLottieAnimationLoader.OnLoadedCallback
            public void onLoaded(boolean z, String str) {
                if (z && !StringHelper.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.mCacheStrategy);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.defaultCacheStrategy);
    }

    public static String getAnimationPath() {
        return INTERNEL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + DIR_ANIMATION + "/";
    }

    public static boolean checkInternalTempDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", ".", "CheckTempDir", HanziToPinyin.Token.SEPARATOR, str));
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

    public void setAnimationUrl(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!StringHelper.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.mCacheStrategy = cacheStrategy;
            this.mLoader = new TBLottieAnimationLoader(getAnimationPath(), str, this.mLoadCallback);
            this.mLoader.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!StringHelper.isEmpty(str)) {
            dealImageAsset(str);
            dealJsonFile(str, cacheStrategy);
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

    private void dealJsonFile(final String str, final LottieAnimationView.CacheStrategy cacheStrategy) {
        e eVar;
        if (!StringHelper.isEmpty(str)) {
            if (REMOTE_WEAK_REF_CACHE.containsKey(str)) {
                e eVar2 = REMOTE_WEAK_REF_CACHE.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (REMOTE_STRONG_REF_CACHE.containsKey(str) && (eVar = REMOTE_STRONG_REF_CACHE.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.isSettingForPlay;
            cancelAnimation();
            cancelCompositionLoader();
            InputStream animationInputStream = getAnimationInputStream(str, JSON_FILE);
            if (animationInputStream != null) {
                this.mCompositionLoader = e.a.a(getContext(), animationInputStream, new h() { // from class: com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.tb.airbnb.lottie.h
                    public void onCompositionLoaded(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.REMOTE_WEAK_REF_CACHE.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.REMOTE_STRONG_REF_CACHE.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.playAnimation();
                            }
                        }
                    }
                });
            }
        }
    }

    private void cancelCompositionLoader() {
        if (this.mCompositionLoader != null) {
            this.mCompositionLoader.cancel();
            this.mCompositionLoader = null;
        }
    }

    private boolean checkPermission() {
        return com.baidu.k.a.a.checkPermissionGranted(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
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
