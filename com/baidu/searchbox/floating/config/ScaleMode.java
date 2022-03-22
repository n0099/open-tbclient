package com.baidu.searchbox.floating.config;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0002\u001a\u00020\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0000H&¢\u0006\u0004\b\u0004\u0010\u0003J+\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/floating/config/ScaleMode;", "Ljava/lang/Enum;", "next", "()Lcom/baidu/searchbox/floating/config/ScaleMode;", "pre", "", "x", "y", "Lkotlin/Pair;", AnimationProperty.SCALE, "(II)Lkotlin/Pair;", "<init>", "(Ljava/lang/String;I)V", "S", "M", "L", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public abstract class ScaleMode {
    public static final /* synthetic */ ScaleMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ScaleMode L;
    public static final ScaleMode M;
    public static final ScaleMode S;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(257258892, "Lcom/baidu/searchbox/floating/config/ScaleMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(257258892, "Lcom/baidu/searchbox/floating/config/ScaleMode;");
                return;
            }
        }
        ScaleMode scaleMode = new ScaleMode("S", 0) { // from class: com.baidu.searchbox.floating.config.ScaleMode.S
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10, null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (DefaultConstructorMarker) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public ScaleMode next() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? ScaleMode.M : (ScaleMode) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public ScaleMode pre() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ScaleMode.M : (ScaleMode) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public Pair<Integer, Integer> scale(int i, int i2) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) ? new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)) : (Pair) invokeII.objValue;
            }
        };
        S = scaleMode;
        ScaleMode scaleMode2 = new ScaleMode("M", 1) { // from class: com.baidu.searchbox.floating.config.ScaleMode.M
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10, null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (DefaultConstructorMarker) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public ScaleMode next() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? ScaleMode.L : (ScaleMode) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public ScaleMode pre() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ScaleMode.S : (ScaleMode) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public Pair<Integer, Integer> scale(int i, int i2) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) ? new Pair<>(Integer.valueOf((int) (i * 1.25d)), Integer.valueOf((int) (i2 * 1.25d))) : (Pair) invokeII.objValue;
            }
        };
        M = scaleMode2;
        ScaleMode scaleMode3 = new ScaleMode("L", 2) { // from class: com.baidu.searchbox.floating.config.ScaleMode.L
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10, null);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (DefaultConstructorMarker) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public ScaleMode next() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? ScaleMode.M : (ScaleMode) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public ScaleMode pre() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ScaleMode.M : (ScaleMode) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.floating.config.ScaleMode
            public Pair<Integer, Integer> scale(int i, int i2) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) ? new Pair<>(Integer.valueOf((int) (i * 1.5d)), Integer.valueOf((int) (i2 * 1.5d))) : (Pair) invokeII.objValue;
            }
        };
        L = scaleMode3;
        $VALUES = new ScaleMode[]{scaleMode, scaleMode2, scaleMode3};
    }

    public ScaleMode(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ScaleMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ScaleMode) Enum.valueOf(ScaleMode.class, str) : (ScaleMode) invokeL.objValue;
    }

    public static ScaleMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ScaleMode[]) $VALUES.clone() : (ScaleMode[]) invokeV.objValue;
    }

    public abstract ScaleMode next();

    public abstract ScaleMode pre();

    public abstract Pair<Integer, Integer> scale(int i, int i2);

    public /* synthetic */ ScaleMode(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
