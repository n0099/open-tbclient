package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class TBAlertConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class OperateBtnStyle {
        public static final /* synthetic */ OperateBtnStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OperateBtnStyle ALERT;
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
            OperateBtnStyle operateBtnStyle = new OperateBtnStyle("ALERT", 3);
            ALERT = operateBtnStyle;
            $VALUES = new OperateBtnStyle[]{MAIN, FORCE, SECONDARY, operateBtnStyle};
        }

        public OperateBtnStyle(String str, int i2) {
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

        public static OperateBtnStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OperateBtnStyle) Enum.valueOf(OperateBtnStyle.class, str) : (OperateBtnStyle) invokeL.objValue;
        }

        public static OperateBtnStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OperateBtnStyle[]) $VALUES.clone() : (OperateBtnStyle[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
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

        public OperateType(String str, int i2) {
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

        public static OperateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OperateType) Enum.valueOf(OperateType.class, str) : (OperateType) invokeL.objValue;
        }

        public static OperateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OperateType[]) $VALUES.clone() : (OperateType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public OperateBtnStyle f40195b;

        /* renamed from: c  reason: collision with root package name */
        public View.OnClickListener f40196c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NonNull String str, @NonNull OperateBtnStyle operateBtnStyle) {
            this(str, operateBtnStyle, (View.OnClickListener) null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, operateBtnStyle};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (OperateBtnStyle) objArr2[1], (View.OnClickListener) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public void a(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.f40196c = onClickListener;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@StringRes int i2, @NonNull OperateBtnStyle operateBtnStyle) {
            this(i2, operateBtnStyle, (View.OnClickListener) null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), operateBtnStyle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (OperateBtnStyle) objArr2[1], (View.OnClickListener) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(@NonNull String str, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, operateBtnStyle, onClickListener};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f40195b = operateBtnStyle;
            this.f40196c = onClickListener;
        }

        public a(@StringRes int i2, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), operateBtnStyle, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = TbadkCoreApplication.getInst().getResources().getString(i2);
            this.f40195b = operateBtnStyle;
            this.f40196c = onClickListener;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final OperateType a;

        /* renamed from: b  reason: collision with root package name */
        public a f40197b;

        /* renamed from: c  reason: collision with root package name */
        public a f40198c;

        /* renamed from: d  reason: collision with root package name */
        public a f40199d;

        public b(OperateType operateType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operateType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                bVar.f40197b = aVar;
                return bVar;
            }
            return (b) invokeL.objValue;
        }

        public static b b(a aVar, a aVar2, a aVar3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, aVar, aVar2, aVar3)) == null) {
                b bVar = new b(OperateType.THREE);
                bVar.f40197b = aVar;
                bVar.f40198c = aVar2;
                bVar.f40199d = aVar3;
                return bVar;
            }
            return (b) invokeLLL.objValue;
        }

        public static b c(a aVar, a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aVar, aVar2)) == null) {
                b bVar = new b(OperateType.TWO);
                bVar.f40197b = aVar;
                bVar.f40198c = aVar2;
                return bVar;
            }
            return (b) invokeLL.objValue;
        }
    }

    public static b a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) ? b.a(aVar) : (b) invokeL.objValue;
    }

    public static b b(a aVar, a aVar2, a aVar3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, aVar, aVar2, aVar3)) == null) ? b.b(aVar, aVar2, aVar3) : (b) invokeLLL.objValue;
    }

    public static b c(a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, aVar2)) == null) ? b.c(aVar, aVar2) : (b) invokeLL.objValue;
    }
}
