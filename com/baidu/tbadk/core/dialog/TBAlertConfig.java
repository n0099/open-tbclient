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
        public String a;
        public int b;
        public String[] c;
        public String d;
        public OperateBtnStyle e;
        public View.OnClickListener f;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@StringRes int i, @NonNull OperateBtnStyle operateBtnStyle) {
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

        public a(@StringRes int i, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
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
            this.a = TbadkCoreApplication.getInst().getResources().getString(i);
            this.e = operateBtnStyle;
            this.f = onClickListener;
        }

        public a(@NonNull String str, int i, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
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
            this.a = str;
            this.b = i;
            this.e = operateBtnStyle;
            this.f = onClickListener;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NonNull String str, @NonNull OperateBtnStyle operateBtnStyle) {
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
        public a(@NonNull String str, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
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

        public a a(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.c = strArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public void c(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f = onClickListener;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final OperateType a;
        public a b;
        public a c;
        public a d;

        public b(OperateType operateType) {
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

        public static b a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
                b bVar = new b(OperateType.ONE);
                bVar.b = aVar;
                return bVar;
            }
            return (b) invokeL.objValue;
        }

        public static b b(a aVar, a aVar2, a aVar3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, aVar, aVar2, aVar3)) == null) {
                b bVar = new b(OperateType.THREE);
                bVar.b = aVar;
                bVar.c = aVar2;
                bVar.d = aVar3;
                return bVar;
            }
            return (b) invokeLLL.objValue;
        }

        public static b c(a aVar, a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aVar, aVar2)) == null) {
                b bVar = new b(OperateType.TWO);
                bVar.b = aVar;
                bVar.c = aVar2;
                return bVar;
            }
            return (b) invokeLL.objValue;
        }
    }

    public static b a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            return b.a(aVar);
        }
        return (b) invokeL.objValue;
    }

    public static b b(a aVar, a aVar2, a aVar3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, aVar, aVar2, aVar3)) == null) {
            return b.b(aVar, aVar2, aVar3);
        }
        return (b) invokeLLL.objValue;
    }

    public static b c(a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, aVar2)) == null) {
            return b.c(aVar, aVar2);
        }
        return (b) invokeLL.objValue;
    }
}
