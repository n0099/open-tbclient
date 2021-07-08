package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MergePaths implements ContentModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean hidden;
    public final MergePathsMode mode;
    public final String name;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class MergePathsMode {
        public static final /* synthetic */ MergePathsMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MergePathsMode ADD;
        public static final MergePathsMode EXCLUDE_INTERSECTIONS;
        public static final MergePathsMode INTERSECT;
        public static final MergePathsMode MERGE;
        public static final MergePathsMode SUBTRACT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-988713481, "Lcom/airbnb/lottie/model/content/MergePaths$MergePathsMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-988713481, "Lcom/airbnb/lottie/model/content/MergePaths$MergePathsMode;");
                    return;
                }
            }
            MERGE = new MergePathsMode("MERGE", 0);
            ADD = new MergePathsMode("ADD", 1);
            SUBTRACT = new MergePathsMode("SUBTRACT", 2);
            INTERSECT = new MergePathsMode("INTERSECT", 3);
            MergePathsMode mergePathsMode = new MergePathsMode("EXCLUDE_INTERSECTIONS", 4);
            EXCLUDE_INTERSECTIONS = mergePathsMode;
            $VALUES = new MergePathsMode[]{MERGE, ADD, SUBTRACT, INTERSECT, mergePathsMode};
        }

        public MergePathsMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MergePathsMode forId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return MERGE;
                                }
                                return EXCLUDE_INTERSECTIONS;
                            }
                            return INTERSECT;
                        }
                        return SUBTRACT;
                    }
                    return ADD;
                }
                return MERGE;
            }
            return (MergePathsMode) invokeI.objValue;
        }

        public static MergePathsMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (MergePathsMode) Enum.valueOf(MergePathsMode.class, str) : (MergePathsMode) invokeL.objValue;
        }

        public static MergePathsMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (MergePathsMode[]) $VALUES.clone() : (MergePathsMode[]) invokeV.objValue;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mergePathsMode, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.name = str;
        this.mode = mergePathsMode;
        this.hidden = z;
    }

    public MergePathsMode getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mode : (MergePathsMode) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public boolean isHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hidden : invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, lottieDrawable, baseLayer)) == null) {
            if (!lottieDrawable.enableMergePathsForKitKatAndAbove()) {
                Logger.warning("Animation contains merge paths but they are disabled.");
                return null;
            }
            return new MergePathsContent(this);
        }
        return (Content) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "MergePaths{mode=" + this.mode + '}';
        }
        return (String) invokeV.objValue;
    }
}
