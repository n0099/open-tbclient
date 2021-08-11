package com.baidu.tbadk.core.util;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class TagTextHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class HotTopicTag {
        public static final /* synthetic */ HotTopicTag[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HotTopicTag BAO;
        public static final HotTopicTag FEI;
        public static final HotTopicTag HOT;
        public static final HotTopicTag NEW;
        public static final HotTopicTag REC;
        public transient /* synthetic */ FieldHolder $fh;
        @ColorRes
        public int tagColorRes;
        @StringRes
        public int tagStrRes;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1745103026, "Lcom/baidu/tbadk/core/util/TagTextHelper$HotTopicTag;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1745103026, "Lcom/baidu/tbadk/core/util/TagTextHelper$HotTopicTag;");
                    return;
                }
            }
            NEW = new HotTopicTag("NEW", 0, R.string.tag_str_new, R.color.CAM_X0305);
            HOT = new HotTopicTag("HOT", 1, R.string.tag_str_hot, R.color.CAM_X0301);
            REC = new HotTopicTag("REC", 2, R.string.tag_str_rec, R.color.CAM_X0306);
            BAO = new HotTopicTag("BAO", 3, R.string.tag_str_bao, R.color.CAM_X0308);
            HotTopicTag hotTopicTag = new HotTopicTag("FEI", 4, R.string.tag_str_fei, R.color.CAM_X0317);
            FEI = hotTopicTag;
            $VALUES = new HotTopicTag[]{NEW, HOT, REC, BAO, hotTopicTag};
        }

        public HotTopicTag(@StringRes String str, @ColorRes int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.tagStrRes = i3;
            this.tagColorRes = i4;
        }

        public static HotTopicTag getHotTopicTag(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return null;
                                }
                                return FEI;
                            }
                            return BAO;
                        }
                        return REC;
                    }
                    return HOT;
                }
                return NEW;
            }
            return (HotTopicTag) invokeI.objValue;
        }

        public static HotTopicTag valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (HotTopicTag) Enum.valueOf(HotTopicTag.class, str) : (HotTopicTag) invokeL.objValue;
        }

        public static HotTopicTag[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (HotTopicTag[]) $VALUES.clone() : (HotTopicTag[]) invokeV.objValue;
        }
    }

    public TagTextHelper() {
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

    @ColorRes
    public static int getHotTopicTagColorRes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i2);
            if (hotTopicTag != null) {
                return hotTopicTag.tagColorRes;
            }
            return R.color.transparent;
        }
        return invokeI.intValue;
    }

    public static String getHotTopicTagStr(@NonNull Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) {
            HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i2);
            return hotTopicTag != null ? context.getString(hotTopicTag.tagStrRes) : "";
        }
        return (String) invokeLI.objValue;
    }

    @ColorRes
    public static int getIndexTextColorRes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return R.color.CAM_X0315;
                    }
                    return R.color.CAM_X0305;
                }
                return R.color.CAM_X0319;
            }
            return R.color.CAM_X0301;
        }
        return invokeI.intValue;
    }
}
