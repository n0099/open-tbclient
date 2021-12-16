package com.baidu.nadcore.widget.bubble;

import android.view.View;
import c.a.c0.h0.b0.c.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BubbleManager extends c.a.c0.h0.b0.d.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class BubbleStyle {
        public static final /* synthetic */ BubbleStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BubbleStyle TextOnly;
        public static final BubbleStyle TextWithJumpArrow;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(273337150, "Lcom/baidu/nadcore/widget/bubble/BubbleManager$BubbleStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(273337150, "Lcom/baidu/nadcore/widget/bubble/BubbleManager$BubbleStyle;");
                    return;
                }
            }
            TextOnly = new BubbleStyle("TextOnly", 0);
            BubbleStyle bubbleStyle = new BubbleStyle("TextWithJumpArrow", 1);
            TextWithJumpArrow = bubbleStyle;
            $VALUES = new BubbleStyle[]{TextOnly, bubbleStyle};
        }

        public BubbleStyle(String str, int i2) {
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

        public static BubbleStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BubbleStyle) Enum.valueOf(BubbleStyle.class, str) : (BubbleStyle) invokeL.objValue;
        }

        public static BubbleStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BubbleStyle[]) $VALUES.clone() : (BubbleStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a();

        void b();

        void c();
    }

    public static <T> T t(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cls)) == null) {
            if (cls == c.class || cls == c.a.c0.h0.b0.c.b.class) {
                try {
                    return cls.newInstance();
                } catch (Exception e2) {
                    c.a.c0.f.a.b("BubbleManager", "", e2);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeL.objValue;
    }
}
