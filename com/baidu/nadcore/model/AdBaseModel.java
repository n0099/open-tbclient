package com.baidu.nadcore.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.p.b;
import c.a.b0.p.c;
import c.a.b0.p.f;
import c.a.b0.p.h;
import c.a.b0.p.j;
import c.a.b0.p.l;
import c.a.b0.p.o;
import c.a.b0.p.p;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37572b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37573c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f37574d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final b f37575e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final AdOperator f37576f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final p f37577g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final l f37578h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final c f37579i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public h f37580j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public f f37581k;
    public o l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class STYLE {
        public static final /* synthetic */ STYLE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final STYLE BIG_IMAGE;
        public static final STYLE FLOAT;
        public static final STYLE PORTRAIT_VIDEO;
        public static final STYLE SMALL_IMAGE;
        public static final STYLE THREE_IMAGE;
        public static final STYLE VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1666764588, "Lcom/baidu/nadcore/model/AdBaseModel$STYLE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1666764588, "Lcom/baidu/nadcore/model/AdBaseModel$STYLE;");
                    return;
                }
            }
            BIG_IMAGE = new STYLE("BIG_IMAGE", 0, "big_image");
            SMALL_IMAGE = new STYLE("SMALL_IMAGE", 1, "small_image");
            THREE_IMAGE = new STYLE("THREE_IMAGE", 2, "three_image");
            VIDEO = new STYLE("VIDEO", 3, "video");
            PORTRAIT_VIDEO = new STYLE("PORTRAIT_VIDEO", 4, "portrait_video");
            STYLE style = new STYLE("FLOAT", 5, ShaderParams.VALUE_TYPE_FLOAT);
            FLOAT = style;
            $VALUES = new STYLE[]{BIG_IMAGE, SMALL_IMAGE, THREE_IMAGE, VIDEO, PORTRAIT_VIDEO, style};
        }

        public STYLE(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static STYLE from(String str) {
            InterceptResult invokeL;
            STYLE[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (STYLE style : values()) {
                    if (style.value.equals(str)) {
                        return style;
                    }
                }
                throw new EnumConstantNotPresentException(STYLE.class, str);
            }
            return (STYLE) invokeL.objValue;
        }

        public static int getStyleCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? values().length : invokeV.intValue;
        }

        public static STYLE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (STYLE) Enum.valueOf(STYLE.class, str) : (STYLE) invokeL.objValue;
        }

        public static STYLE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (STYLE[]) $VALUES.clone() : (STYLE[]) invokeV.objValue;
        }
    }
}
