package androidx.cardview;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class attr {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int cardBackgroundColor = 0x7f04010b;
        public static final int cardCornerRadius = 0x7f04010c;
        public static final int cardElevation = 0x7f04010d;
        public static final int cardMaxElevation = 0x7f04010f;
        public static final int cardPreventCornerOverlap = 0x7f040110;
        public static final int cardUseCompatPadding = 0x7f040111;
        public static final int cardViewStyle = 0x7f040112;
        public static final int contentPadding = 0x7f040169;
        public static final int contentPaddingBottom = 0x7f04016a;
        public static final int contentPaddingLeft = 0x7f04016b;
        public static final int contentPaddingRight = 0x7f04016c;
        public static final int contentPaddingTop = 0x7f04016d;
        public transient /* synthetic */ FieldHolder $fh;

        public attr() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class color {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int cardview_dark_background = 0x7f06036e;
        public static final int cardview_light_background = 0x7f06036f;
        public static final int cardview_shadow_end_color = 0x7f060370;
        public static final int cardview_shadow_start_color = 0x7f060371;
        public transient /* synthetic */ FieldHolder $fh;

        public color() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class dimen {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int cardview_compat_inset_shadow = 0x7f0701a2;
        public static final int cardview_default_elevation = 0x7f0701a3;
        public static final int cardview_default_radius = 0x7f0701a4;
        public transient /* synthetic */ FieldHolder $fh;

        public dimen() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class style {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int Base_CardView = 0x7f100016;
        public static final int CardView = 0x7f1000fc;
        public static final int CardView_Dark = 0x7f1000fe;
        public static final int CardView_Light = 0x7f1000ff;
        public transient /* synthetic */ FieldHolder $fh;

        public style() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class styleable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] CardView;
        public static final int CardView_android_minHeight = 0x00000001;
        public static final int CardView_android_minWidth = 0x00000000;
        public static final int CardView_cardBackgroundColor = 0x00000002;
        public static final int CardView_cardCornerRadius = 0x00000003;
        public static final int CardView_cardElevation = 0x00000004;
        public static final int CardView_cardMaxElevation = 0x00000005;
        public static final int CardView_cardPreventCornerOverlap = 0x00000006;
        public static final int CardView_cardUseCompatPadding = 0x00000007;
        public static final int CardView_contentPadding = 0x00000008;
        public static final int CardView_contentPaddingBottom = 0x00000009;
        public static final int CardView_contentPaddingLeft = 0x0000000a;
        public static final int CardView_contentPaddingRight = 0x0000000b;
        public static final int CardView_contentPaddingTop = 0x0000000c;
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
            CardView = new int[]{16843071, 16843072, com.baidu.tieba.R.attr.cardBackgroundColor, com.baidu.tieba.R.attr.cardCornerRadius, com.baidu.tieba.R.attr.cardElevation, com.baidu.tieba.R.attr.cardMaxElevation, com.baidu.tieba.R.attr.cardPreventCornerOverlap, com.baidu.tieba.R.attr.cardUseCompatPadding, com.baidu.tieba.R.attr.contentPadding, com.baidu.tieba.R.attr.contentPaddingBottom, com.baidu.tieba.R.attr.contentPaddingLeft, com.baidu.tieba.R.attr.contentPaddingRight, com.baidu.tieba.R.attr.contentPaddingTop};
        }

        public styleable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public R() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
