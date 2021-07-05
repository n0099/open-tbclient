package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class Layer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LottieComposition composition;
    public final boolean hidden;
    public final List<Keyframe<Float>> inOutKeyframes;
    public final long layerId;
    public final String layerName;
    public final LayerType layerType;
    public final List<Mask> masks;
    public final MatteType matteType;
    public final long parentId;
    public final int preCompHeight;
    public final int preCompWidth;
    @Nullable
    public final String refId;
    public final List<ContentModel> shapes;
    public final int solidColor;
    public final int solidHeight;
    public final int solidWidth;
    public final float startFrame;
    @Nullable
    public final AnimatableTextFrame text;
    @Nullable
    public final AnimatableTextProperties textProperties;
    @Nullable
    public final AnimatableFloatValue timeRemapping;
    public final float timeStretch;
    public final AnimatableTransform transform;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class LayerType {
        public static final /* synthetic */ LayerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LayerType IMAGE;
        public static final LayerType NULL;
        public static final LayerType PRE_COMP;
        public static final LayerType SHAPE;
        public static final LayerType SOLID;
        public static final LayerType TEXT;
        public static final LayerType UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(281506318, "Lcom/airbnb/lottie/model/layer/Layer$LayerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(281506318, "Lcom/airbnb/lottie/model/layer/Layer$LayerType;");
                    return;
                }
            }
            PRE_COMP = new LayerType("PRE_COMP", 0);
            SOLID = new LayerType("SOLID", 1);
            IMAGE = new LayerType("IMAGE", 2);
            NULL = new LayerType("NULL", 3);
            SHAPE = new LayerType("SHAPE", 4);
            TEXT = new LayerType("TEXT", 5);
            LayerType layerType = new LayerType(RomUtils.UNKNOWN, 6);
            UNKNOWN = layerType;
            $VALUES = new LayerType[]{PRE_COMP, SOLID, IMAGE, NULL, SHAPE, TEXT, layerType};
        }

        public LayerType(String str, int i2) {
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

        public static LayerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LayerType) Enum.valueOf(LayerType.class, str) : (LayerType) invokeL.objValue;
        }

        public static LayerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LayerType[]) $VALUES.clone() : (LayerType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class MatteType {
        public static final /* synthetic */ MatteType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MatteType ADD;
        public static final MatteType INVERT;
        public static final MatteType LUMA;
        public static final MatteType LUMA_INVERTED;
        public static final MatteType NONE;
        public static final MatteType UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(16350094, "Lcom/airbnb/lottie/model/layer/Layer$MatteType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(16350094, "Lcom/airbnb/lottie/model/layer/Layer$MatteType;");
                    return;
                }
            }
            NONE = new MatteType("NONE", 0);
            ADD = new MatteType("ADD", 1);
            INVERT = new MatteType("INVERT", 2);
            LUMA = new MatteType("LUMA", 3);
            LUMA_INVERTED = new MatteType("LUMA_INVERTED", 4);
            MatteType matteType = new MatteType(RomUtils.UNKNOWN, 5);
            UNKNOWN = matteType;
            $VALUES = new MatteType[]{NONE, ADD, INVERT, LUMA, LUMA_INVERTED, matteType};
        }

        public MatteType(String str, int i2) {
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

        public static MatteType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MatteType) Enum.valueOf(MatteType.class, str) : (MatteType) invokeL.objValue;
        }

        public static MatteType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MatteType[]) $VALUES.clone() : (MatteType[]) invokeV.objValue;
        }
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, @Nullable AnimatableFloatValue animatableFloatValue, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, lottieComposition, str, Long.valueOf(j), layerType, Long.valueOf(j2), str2, list2, animatableTransform, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i5), Integer.valueOf(i6), animatableTextFrame, animatableTextProperties, list3, matteType, animatableFloatValue, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = str;
        this.layerId = j;
        this.layerType = layerType;
        this.parentId = j2;
        this.refId = str2;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = i2;
        this.solidHeight = i3;
        this.solidColor = i4;
        this.timeStretch = f2;
        this.startFrame = f3;
        this.preCompWidth = i5;
        this.preCompHeight = i6;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType;
        this.timeRemapping = animatableFloatValue;
        this.hidden = z;
    }

    public LottieComposition getComposition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.composition : (LottieComposition) invokeV.objValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.layerId : invokeV.longValue;
    }

    public List<Keyframe<Float>> getInOutKeyframes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.inOutKeyframes : (List) invokeV.objValue;
    }

    public LayerType getLayerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.layerType : (LayerType) invokeV.objValue;
    }

    public List<Mask> getMasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.masks : (List) invokeV.objValue;
    }

    public MatteType getMatteType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.matteType : (MatteType) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.layerName : (String) invokeV.objValue;
    }

    public long getParentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.parentId : invokeV.longValue;
    }

    public int getPreCompHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.preCompHeight : invokeV.intValue;
    }

    public int getPreCompWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.preCompWidth : invokeV.intValue;
    }

    @Nullable
    public String getRefId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.refId : (String) invokeV.objValue;
    }

    public List<ContentModel> getShapes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.shapes : (List) invokeV.objValue;
    }

    public int getSolidColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.solidColor : invokeV.intValue;
    }

    public int getSolidHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.solidHeight : invokeV.intValue;
    }

    public int getSolidWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.solidWidth : invokeV.intValue;
    }

    public float getStartProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.startFrame / this.composition.getDurationFrames() : invokeV.floatValue;
    }

    @Nullable
    public AnimatableTextFrame getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.text : (AnimatableTextFrame) invokeV.objValue;
    }

    @Nullable
    public AnimatableTextProperties getTextProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.textProperties : (AnimatableTextProperties) invokeV.objValue;
    }

    @Nullable
    public AnimatableFloatValue getTimeRemapping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.timeRemapping : (AnimatableFloatValue) invokeV.objValue;
    }

    public float getTimeStretch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.timeStretch : invokeV.floatValue;
    }

    public AnimatableTransform getTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.transform : (AnimatableTransform) invokeV.objValue;
    }

    public boolean isHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.hidden : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? toString("") : (String) invokeV.objValue;
    }

    public String toString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(getName());
            sb.append("\n");
            Layer layerModelForId = this.composition.layerModelForId(getParentId());
            if (layerModelForId != null) {
                sb.append("\t\tParents: ");
                sb.append(layerModelForId.getName());
                Layer layerModelForId2 = this.composition.layerModelForId(layerModelForId.getParentId());
                while (layerModelForId2 != null) {
                    sb.append("->");
                    sb.append(layerModelForId2.getName());
                    layerModelForId2 = this.composition.layerModelForId(layerModelForId2.getParentId());
                }
                sb.append(str);
                sb.append("\n");
            }
            if (!getMasks().isEmpty()) {
                sb.append(str);
                sb.append("\tMasks: ");
                sb.append(getMasks().size());
                sb.append("\n");
            }
            if (getSolidWidth() != 0 && getSolidHeight() != 0) {
                sb.append(str);
                sb.append("\tBackground: ");
                sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(getSolidWidth()), Integer.valueOf(getSolidHeight()), Integer.valueOf(getSolidColor())));
            }
            if (!this.shapes.isEmpty()) {
                sb.append(str);
                sb.append("\tShapes:\n");
                for (ContentModel contentModel : this.shapes) {
                    sb.append(str);
                    sb.append("\t\t");
                    sb.append(contentModel);
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
