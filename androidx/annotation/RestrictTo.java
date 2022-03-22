package androidx.annotation;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface RestrictTo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Scope {
        public static final /* synthetic */ Scope[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        @Deprecated
        public static final Scope GROUP_ID;
        public static final Scope LIBRARY;
        public static final Scope LIBRARY_GROUP;
        public static final Scope LIBRARY_GROUP_PREFIX;
        public static final Scope SUBCLASSES;
        public static final Scope TESTS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1594267662, "Landroidx/annotation/RestrictTo$Scope;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1594267662, "Landroidx/annotation/RestrictTo$Scope;");
                    return;
                }
            }
            LIBRARY = new Scope("LIBRARY", 0);
            LIBRARY_GROUP = new Scope("LIBRARY_GROUP", 1);
            LIBRARY_GROUP_PREFIX = new Scope("LIBRARY_GROUP_PREFIX", 2);
            GROUP_ID = new Scope("GROUP_ID", 3);
            TESTS = new Scope("TESTS", 4);
            Scope scope = new Scope("SUBCLASSES", 5);
            SUBCLASSES = scope;
            $VALUES = new Scope[]{LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, GROUP_ID, TESTS, scope};
        }

        public Scope(String str, int i) {
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

        public static Scope valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Scope) Enum.valueOf(Scope.class, str) : (Scope) invokeL.objValue;
        }

        public static Scope[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Scope[]) $VALUES.clone() : (Scope[]) invokeV.objValue;
        }
    }

    Scope[] value();
}
