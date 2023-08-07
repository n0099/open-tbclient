package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class TBAlertConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class OperateBtnConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String btnText;
        public int btnTextColor;
        public View.OnClickListener listener;
        public String[] mBgGradientColor;
        public String mBgGradientDirection;
        public OperateBtnStyle style;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public OperateBtnConfig(@StringRes int i, @NonNull OperateBtnStyle operateBtnStyle) {
            this(i, operateBtnStyle, (View.OnClickListener) null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), operateBtnStyle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (OperateBtnStyle) objArr2[1], (View.OnClickListener) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public OperateBtnConfig(@StringRes int i, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), operateBtnStyle, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.btnText = TbadkCoreApplication.getInst().getResources().getString(i);
            this.style = operateBtnStyle;
            this.listener = onClickListener;
        }

        public OperateBtnConfig(@NonNull String str, int i, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), operateBtnStyle, onClickListener};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.btnText = str;
            this.btnTextColor = i;
            this.style = operateBtnStyle;
            this.listener = onClickListener;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public OperateBtnConfig(@NonNull String str, @NonNull OperateBtnStyle operateBtnStyle) {
            this(str, operateBtnStyle, (View.OnClickListener) null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, operateBtnStyle};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (OperateBtnStyle) objArr2[1], (View.OnClickListener) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public OperateBtnConfig(@NonNull String str, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
            this(str, 0, operateBtnStyle, onClickListener);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, operateBtnStyle, onClickListener};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (OperateBtnStyle) objArr2[2], (View.OnClickListener) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
        }

        public OperateBtnConfig setBgGradientColor(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.mBgGradientColor = strArr;
                return this;
            }
            return (OperateBtnConfig) invokeL.objValue;
        }

        public OperateBtnConfig setBgGradientDirection(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.mBgGradientDirection = str;
                return this;
            }
            return (OperateBtnConfig) invokeL.objValue;
        }

        public void setListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.listener = onClickListener;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class OperateBtnStyle {
        public static final /* synthetic */ OperateBtnStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OperateBtnStyle ALERT;
        public static final OperateBtnStyle BG_GRADIENT;
        public static final OperateBtnStyle FORCE;
        public static final OperateBtnStyle MAIN;
        public static final OperateBtnStyle SECONDARY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1084105424, "Lcom/baidu/tbadk/core/dialog/TBAlertConfig$OperateBtnStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1084105424, "Lcom/baidu/tbadk/core/dialog/TBAlertConfig$OperateBtnStyle;");
                    return;
                }
            }
            MAIN = new OperateBtnStyle("MAIN", 0);
            FORCE = new OperateBtnStyle("FORCE", 1);
            SECONDARY = new OperateBtnStyle("SECONDARY", 2);
            ALERT = new OperateBtnStyle("ALERT", 3);
            OperateBtnStyle operateBtnStyle = new OperateBtnStyle("BG_GRADIENT", 4);
            BG_GRADIENT = operateBtnStyle;
            $VALUES = new OperateBtnStyle[]{MAIN, FORCE, SECONDARY, ALERT, operateBtnStyle};
        }

        public OperateBtnStyle(String str, int i) {
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

        public static OperateBtnStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (OperateBtnStyle) Enum.valueOf(OperateBtnStyle.class, str);
            }
            return (OperateBtnStyle) invokeL.objValue;
        }

        public static OperateBtnStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (OperateBtnStyle[]) $VALUES.clone();
            }
            return (OperateBtnStyle[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class OperateType {
        public static final /* synthetic */ OperateType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OperateType ONE;
        public static final OperateType THREE;
        public static final OperateType TWO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1874629099, "Lcom/baidu/tbadk/core/dialog/TBAlertConfig$OperateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1874629099, "Lcom/baidu/tbadk/core/dialog/TBAlertConfig$OperateType;");
                    return;
                }
            }
            ONE = new OperateType("ONE", 0);
            TWO = new OperateType("TWO", 1);
            OperateType operateType = new OperateType("THREE", 2);
            THREE = operateType;
            $VALUES = new OperateType[]{ONE, TWO, operateType};
        }

        public OperateType(String str, int i) {
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

        public static OperateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (OperateType) Enum.valueOf(OperateType.class, str);
            }
            return (OperateType) invokeL.objValue;
        }

        public static OperateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (OperateType[]) $VALUES.clone();
            }
            return (OperateType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final OperateType a;
        public OperateBtnConfig b;
        public OperateBtnConfig c;
        public OperateBtnConfig d;

        public a(OperateType operateType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operateType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = operateType;
        }

        public static a a(OperateBtnConfig operateBtnConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, operateBtnConfig)) == null) {
                a aVar = new a(OperateType.ONE);
                aVar.b = operateBtnConfig;
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a b(OperateBtnConfig operateBtnConfig, OperateBtnConfig operateBtnConfig2, OperateBtnConfig operateBtnConfig3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, operateBtnConfig, operateBtnConfig2, operateBtnConfig3)) == null) {
                a aVar = new a(OperateType.THREE);
                aVar.b = operateBtnConfig;
                aVar.c = operateBtnConfig2;
                aVar.d = operateBtnConfig3;
                return aVar;
            }
            return (a) invokeLLL.objValue;
        }

        public static a c(OperateBtnConfig operateBtnConfig, OperateBtnConfig operateBtnConfig2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, operateBtnConfig, operateBtnConfig2)) == null) {
                a aVar = new a(OperateType.TWO);
                aVar.b = operateBtnConfig;
                aVar.c = operateBtnConfig2;
                return aVar;
            }
            return (a) invokeLL.objValue;
        }
    }

    public static a a(OperateBtnConfig operateBtnConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, operateBtnConfig)) == null) {
            return a.a(operateBtnConfig);
        }
        return (a) invokeL.objValue;
    }

    public static a b(OperateBtnConfig operateBtnConfig, OperateBtnConfig operateBtnConfig2, OperateBtnConfig operateBtnConfig3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, operateBtnConfig, operateBtnConfig2, operateBtnConfig3)) == null) {
            return a.b(operateBtnConfig, operateBtnConfig2, operateBtnConfig3);
        }
        return (a) invokeLLL.objValue;
    }

    public static a c(OperateBtnConfig operateBtnConfig, OperateBtnConfig operateBtnConfig2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, operateBtnConfig, operateBtnConfig2)) == null) {
            return a.c(operateBtnConfig, operateBtnConfig2);
        }
        return (a) invokeLL.objValue;
    }
}
