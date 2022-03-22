package androidx.cardview;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$styleable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] CardView;
    public static final int CardView_android_minHeight = 1;
    public static final int CardView_android_minWidth = 0;
    public static final int CardView_cardBackgroundColor = 2;
    public static final int CardView_cardCornerRadius = 3;
    public static final int CardView_cardElevation = 4;
    public static final int CardView_cardMaxElevation = 5;
    public static final int CardView_cardPreventCornerOverlap = 6;
    public static final int CardView_cardUseCompatPadding = 7;
    public static final int CardView_contentPadding = 8;
    public static final int CardView_contentPaddingBottom = 9;
    public static final int CardView_contentPaddingLeft = 10;
    public static final int CardView_contentPaddingRight = 11;
    public static final int CardView_contentPaddingTop = 12;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(515618402, "Landroidx/cardview/R$styleable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(515618402, "Landroidx/cardview/R$styleable;");
                return;
            }
        }
        CardView = new int[]{16843071, 16843072, R.attr.cardBackgroundColor, R.attr.cardCornerRadius, R.attr.cardElevation, R.attr.cardMaxElevation, R.attr.cardPreventCornerOverlap, R.attr.cardUseCompatPadding, R.attr.contentPadding, R.attr.contentPaddingBottom, R.attr.contentPaddingLeft, R.attr.contentPaddingRight, R.attr.contentPaddingTop};
    }

    public R$styleable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
