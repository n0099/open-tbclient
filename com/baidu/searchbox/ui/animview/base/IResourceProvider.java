package com.baidu.searchbox.ui.animview.base;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public interface IResourceProvider extends IResourcePackage {

    /* loaded from: classes7.dex */
    public static class PackageInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mPkgPath;
        public String mPkgTag;
        public IResourcePackage mResPkg;

        public PackageInfo(String str, String str2, IResourcePackage iResourcePackage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, iResourcePackage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPkgTag = str;
            this.mPkgPath = str2;
            this.mResPkg = iResourcePackage;
        }
    }

    /* loaded from: classes7.dex */
    public static class PraiseConfigInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Set<PraiseLevelConfig> mLevelConfigSet;

        public PraiseConfigInfo(Set<PraiseLevelConfig> set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLevelConfigSet = set;
        }

        public static PraiseConfigInfo valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    return new PraiseConfigInfo(PraiseLevelConfig.setOf(new JSONObject(str)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (PraiseConfigInfo) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class PraiseLevelConfig {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String JSON_KEY_BOUND = "bound";
        public static final String JSON_KEY_LEVEL_IMG_INDEX = "android_img_index";
        public static final String JSON_KEY_LIST = "levelList";
        public static final String JSON_KEY_TXT_CNT = "textCount";
        public transient /* synthetic */ FieldHolder $fh;
        public final long mBound;
        public final int mLevelImgIndex;
        public final int mTextCount;

        /* loaded from: classes7.dex */
        public static class DefaultComparator implements Comparator<PraiseLevelConfig> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DefaultComparator() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(PraiseLevelConfig praiseLevelConfig, PraiseLevelConfig praiseLevelConfig2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, praiseLevelConfig, praiseLevelConfig2)) == null) {
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
                return invokeLL.intValue;
            }
        }

        public PraiseLevelConfig(long j, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBound = j;
            this.mTextCount = i2;
            this.mLevelImgIndex = i3;
        }

        public static Set<PraiseLevelConfig> setOf(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(JSON_KEY_LIST);
                    int i2 = 0;
                    TreeSet treeSet = null;
                    while (jSONArray != null) {
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        PraiseLevelConfig valueOf = valueOf(jSONArray.getJSONObject(i2));
                        if (valueOf != null) {
                            if (treeSet == null) {
                                treeSet = new TreeSet(new DefaultComparator());
                            }
                            treeSet.add(valueOf);
                        }
                        i2++;
                    }
                    return treeSet;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (Set) invokeL.objValue;
        }

        public static PraiseLevelConfig valueOf(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                return new PraiseLevelConfig(jSONObject.optLong(JSON_KEY_BOUND, -1L), jSONObject.optInt(JSON_KEY_TXT_CNT, -1), jSONObject.optInt(JSON_KEY_LEVEL_IMG_INDEX, -1));
            }
            return (PraiseLevelConfig) invokeL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || PraiseLevelConfig.class != obj.getClass()) {
                    return false;
                }
                PraiseLevelConfig praiseLevelConfig = (PraiseLevelConfig) obj;
                return this.mTextCount == praiseLevelConfig.mTextCount && this.mBound == praiseLevelConfig.mBound && this.mLevelImgIndex == praiseLevelConfig.mLevelImgIndex;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Build.VERSION.SDK_INT >= 19 ? Objects.hash(Integer.valueOf(this.mTextCount), Long.valueOf(this.mBound), Integer.valueOf(this.mLevelImgIndex)) : Arrays.hashCode(new Object[]{Integer.valueOf(this.mTextCount), Long.valueOf(this.mBound), Integer.valueOf(this.mLevelImgIndex)}) : invokeV.intValue;
        }
    }

    boolean containPackage(String str);

    List<PackageInfo> getPackageList();

    PraiseConfigInfo getPraiseConfigInfo();

    IResourcePackage.LottieResource getPraiseGuideLottie();

    File[] getPraiseIconById(String str, boolean z);

    void loadResource(String... strArr);

    void onlyLoadPraiseIcon();

    void setCurrentPackage(String str);
}
