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
/* loaded from: classes3.dex */
public final class TagTextHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            NEW = new HotTopicTag("NEW", 0, R.string.obfuscated_res_0x7f0f1333, R.color.CAM_X0305);
            HOT = new HotTopicTag("HOT", 1, R.string.obfuscated_res_0x7f0f1332, R.color.CAM_X0301);
            REC = new HotTopicTag("REC", 2, R.string.obfuscated_res_0x7f0f1334, R.color.CAM_X0306);
            BAO = new HotTopicTag("BAO", 3, R.string.obfuscated_res_0x7f0f1330, R.color.CAM_X0308);
            HotTopicTag hotTopicTag = new HotTopicTag("FEI", 4, R.string.obfuscated_res_0x7f0f1331, R.color.CAM_X0317);
            FEI = hotTopicTag;
            $VALUES = new HotTopicTag[]{NEW, HOT, REC, BAO, hotTopicTag};
        }

        public HotTopicTag(@StringRes String str, @ColorRes int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.tagStrRes = i2;
            this.tagColorRes = i3;
        }

        public static HotTopicTag getHotTopicTag(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @ColorRes
    public static int getHotTopicTagColorRes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
            return hotTopicTag != null ? hotTopicTag.tagColorRes : R.color.transparent;
        }
        return invokeI.intValue;
    }

    public static String getHotTopicTagStr(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i)) == null) {
            HotTopicTag hotTopicTag = HotTopicTag.getHotTopicTag(i);
            return hotTopicTag != null ? context.getString(hotTopicTag.tagStrRes) : "";
        }
        return (String) invokeLI.objValue;
    }

    @ColorRes
    public static int getIndexTextColorRes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i != 1 ? i != 2 ? i != 3 ? R.color.CAM_X0315 : R.color.CAM_X0305 : R.color.CAM_X0319 : R.color.CAM_X0301 : invokeI.intValue;
    }
}
