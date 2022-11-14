package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.s71;
import com.baidu.tieba.t71;
import com.baidu.tieba.v71;
import com.baidu.tieba.xj0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BubbleManager extends v71 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public BubbleStyle(String str, int i) {
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

        public static BubbleStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BubbleStyle) Enum.valueOf(BubbleStyle.class, str);
            }
            return (BubbleStyle) invokeL.objValue;
        }

        public static BubbleStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BubbleStyle[]) $VALUES.clone();
            }
            return (BubbleStyle[]) invokeV.objValue;
        }
    }

    public static <T> T t(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cls)) == null) {
            if (cls != t71.class && cls != s71.class) {
                return null;
            }
            try {
                return cls.newInstance();
            } catch (Exception e) {
                xj0.b("BubbleManager", "", e);
                return null;
            }
        }
        return (T) invokeL.objValue;
    }
}
