package com.alibaba.fastjson;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.runtime.reflect.SignatureImpl;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class PropertyNamingStrategy {
    public static final /* synthetic */ PropertyNamingStrategy[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PropertyNamingStrategy CamelCase;
    public static final PropertyNamingStrategy KebabCase;
    public static final PropertyNamingStrategy NoChange;
    public static final PropertyNamingStrategy PascalCase;
    public static final PropertyNamingStrategy SnakeCase;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(425961216, "Lcom/alibaba/fastjson/PropertyNamingStrategy$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(425961216, "Lcom/alibaba/fastjson/PropertyNamingStrategy$1;");
                    return;
                }
            }
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.NoChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(711057005, "Lcom/alibaba/fastjson/PropertyNamingStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(711057005, "Lcom/alibaba/fastjson/PropertyNamingStrategy;");
                return;
            }
        }
        CamelCase = new PropertyNamingStrategy("CamelCase", 0);
        PascalCase = new PropertyNamingStrategy("PascalCase", 1);
        SnakeCase = new PropertyNamingStrategy("SnakeCase", 2);
        KebabCase = new PropertyNamingStrategy("KebabCase", 3);
        PropertyNamingStrategy propertyNamingStrategy = new PropertyNamingStrategy("NoChange", 4);
        NoChange = propertyNamingStrategy;
        $VALUES = new PropertyNamingStrategy[]{CamelCase, PascalCase, SnakeCase, KebabCase, propertyNamingStrategy};
    }

    public PropertyNamingStrategy(String str, int i2) {
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

    public static PropertyNamingStrategy valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PropertyNamingStrategy) Enum.valueOf(PropertyNamingStrategy.class, str) : (PropertyNamingStrategy) invokeL.objValue;
    }

    public static PropertyNamingStrategy[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PropertyNamingStrategy[]) $VALUES.clone() : (PropertyNamingStrategy[]) invokeV.objValue;
    }

    public String translate(String str) {
        InterceptResult invokeL;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
            int i3 = 0;
            if (i2 == 1) {
                StringBuilder sb = new StringBuilder();
                while (i3 < str.length()) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 >= 'A' && charAt2 <= 'Z') {
                        char c2 = (char) (charAt2 + ' ');
                        if (i3 > 0) {
                            sb.append('_');
                        }
                        sb.append(c2);
                    } else {
                        sb.append(charAt2);
                    }
                    i3++;
                }
                return sb.toString();
            } else if (i2 == 2) {
                StringBuilder sb2 = new StringBuilder();
                while (i3 < str.length()) {
                    char charAt3 = str.charAt(i3);
                    if (charAt3 >= 'A' && charAt3 <= 'Z') {
                        char c3 = (char) (charAt3 + ' ');
                        if (i3 > 0) {
                            sb2.append(SignatureImpl.SEP);
                        }
                        sb2.append(c3);
                    } else {
                        sb2.append(charAt3);
                    }
                    i3++;
                }
                return sb2.toString();
            } else if (i2 != 3) {
                if (i2 == 4 && (charAt = str.charAt(0)) >= 'A' && charAt <= 'Z') {
                    char[] charArray = str.toCharArray();
                    charArray[0] = (char) (charArray[0] + ' ');
                    return new String(charArray);
                }
                return str;
            } else {
                char charAt4 = str.charAt(0);
                if (charAt4 < 'a' || charAt4 > 'z') {
                    return str;
                }
                char[] charArray2 = str.toCharArray();
                charArray2[0] = (char) (charArray2[0] - ' ');
                return new String(charArray2);
            }
        }
        return (String) invokeL.objValue;
    }
}
