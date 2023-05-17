package com.baidu.searchbox.ui.animview.base;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IResourceProvider extends IResourcePackage {
    boolean containPackage(String str);

    List<PackageInfo> getPackageList();

    PraiseConfigInfo getPraiseConfigInfo();

    IResourcePackage.LottieResource getPraiseGuideLottie();

    File[] getPraiseIconById(String str, boolean z);

    void loadResource(String... strArr);

    void onlyLoadPraiseIcon();

    void setCurrentPackage(String str);

    /* loaded from: classes4.dex */
    public static class PackageInfo {
        public String mPkgPath;
        public String mPkgTag;
        public IResourcePackage mResPkg;

        public PackageInfo(String str, String str2, IResourcePackage iResourcePackage) {
            this.mPkgTag = str;
            this.mPkgPath = str2;
            this.mResPkg = iResourcePackage;
        }
    }

    /* loaded from: classes4.dex */
    public static class PraiseConfigInfo {
        public Set<PraiseLevelConfig> mLevelConfigSet;

        public PraiseConfigInfo(Set<PraiseLevelConfig> set) {
            this.mLevelConfigSet = set;
        }

        public static PraiseConfigInfo valueOf(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new PraiseConfigInfo(PraiseLevelConfig.setOf(new JSONObject(str)));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class PraiseLevelConfig {
        public static final String JSON_KEY_BOUND = "bound";
        public static final String JSON_KEY_LEVEL_IMG_INDEX = "android_img_index";
        public static final String JSON_KEY_LIST = "levelList";
        public static final String JSON_KEY_TXT_CNT = "textCount";
        public final long mBound;
        public final int mLevelImgIndex;
        public final int mTextCount;

        public PraiseLevelConfig(long j, int i, int i2) {
            this.mBound = j;
            this.mTextCount = i;
            this.mLevelImgIndex = i2;
        }

        /* loaded from: classes4.dex */
        public static class DefaultComparator implements Comparator<PraiseLevelConfig> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(PraiseLevelConfig praiseLevelConfig, PraiseLevelConfig praiseLevelConfig2) {
                if (praiseLevelConfig == praiseLevelConfig2) {
                    return 0;
                }
                if (praiseLevelConfig == null) {
                    return -1;
                }
                if (praiseLevelConfig2 == null) {
                    return 1;
                }
                return (int) (praiseLevelConfig.mBound - praiseLevelConfig2.mBound);
            }
        }

        public static Set<PraiseLevelConfig> setOf(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(JSON_KEY_LIST);
                int i = 0;
                TreeSet treeSet = null;
                while (jSONArray != null) {
                    if (i >= jSONArray.length()) {
                        break;
                    }
                    PraiseLevelConfig valueOf = valueOf(jSONArray.getJSONObject(i));
                    if (valueOf != null) {
                        if (treeSet == null) {
                            treeSet = new TreeSet(new DefaultComparator());
                        }
                        treeSet.add(valueOf);
                    }
                    i++;
                }
                return treeSet;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static PraiseLevelConfig valueOf(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new PraiseLevelConfig(jSONObject.optLong(JSON_KEY_BOUND, -1L), jSONObject.optInt(JSON_KEY_TXT_CNT, -1), jSONObject.optInt(JSON_KEY_LEVEL_IMG_INDEX, -1));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PraiseLevelConfig.class != obj.getClass()) {
                return false;
            }
            PraiseLevelConfig praiseLevelConfig = (PraiseLevelConfig) obj;
            if (this.mTextCount == praiseLevelConfig.mTextCount && this.mBound == praiseLevelConfig.mBound && this.mLevelImgIndex == praiseLevelConfig.mLevelImgIndex) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 19) {
                return Objects.hash(Integer.valueOf(this.mTextCount), Long.valueOf(this.mBound), Integer.valueOf(this.mLevelImgIndex));
            }
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.mTextCount), Long.valueOf(this.mBound), Integer.valueOf(this.mLevelImgIndex)});
        }
    }
}
