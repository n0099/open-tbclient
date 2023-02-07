package com.baidu.searchbox.crius;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class attr {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int cr_alignContent = 0x7f0401b5;
        public static final int cr_alignItems = 0x7f0401b6;
        public static final int cr_alignSelf = 0x7f0401b7;
        public static final int cr_aspectRatio = 0x7f0401b8;
        public static final int cr_borderAll = 0x7f0401b9;
        public static final int cr_borderBottom = 0x7f0401ba;
        public static final int cr_borderEnd = 0x7f0401bb;
        public static final int cr_borderHorizontal = 0x7f0401bc;
        public static final int cr_borderLeft = 0x7f0401bd;
        public static final int cr_borderRight = 0x7f0401be;
        public static final int cr_borderStart = 0x7f0401bf;
        public static final int cr_borderTop = 0x7f0401c0;
        public static final int cr_borderVertical = 0x7f0401c1;
        public static final int cr_direction = 0x7f0401c2;
        public static final int cr_display = 0x7f0401c3;
        public static final int cr_flex = 0x7f0401c4;
        public static final int cr_flexBasis = 0x7f0401c5;
        public static final int cr_flexDirection = 0x7f0401c6;
        public static final int cr_flexGrow = 0x7f0401c7;
        public static final int cr_flexShrink = 0x7f0401c8;
        public static final int cr_height = 0x7f0401c9;
        public static final int cr_justifyContent = 0x7f0401ca;
        public static final int cr_marginAll = 0x7f0401cb;
        public static final int cr_marginBottom = 0x7f0401cc;
        public static final int cr_marginEnd = 0x7f0401cd;
        public static final int cr_marginHorizontal = 0x7f0401ce;
        public static final int cr_marginLeft = 0x7f0401cf;
        public static final int cr_marginRight = 0x7f0401d0;
        public static final int cr_marginStart = 0x7f0401d1;
        public static final int cr_marginTop = 0x7f0401d2;
        public static final int cr_marginVertical = 0x7f0401d3;
        public static final int cr_maxHeight = 0x7f0401d4;
        public static final int cr_maxWidth = 0x7f0401d5;
        public static final int cr_minHeight = 0x7f0401d6;
        public static final int cr_minWidth = 0x7f0401d7;
        public static final int cr_overflow = 0x7f0401d8;
        public static final int cr_paddingAll = 0x7f0401d9;
        public static final int cr_paddingBottom = 0x7f0401da;
        public static final int cr_paddingEnd = 0x7f0401db;
        public static final int cr_paddingHorizontal = 0x7f0401dc;
        public static final int cr_paddingLeft = 0x7f0401dd;
        public static final int cr_paddingRight = 0x7f0401de;
        public static final int cr_paddingStart = 0x7f0401df;
        public static final int cr_paddingTop = 0x7f0401e0;
        public static final int cr_paddingVertical = 0x7f0401e1;
        public static final int cr_positionAll = 0x7f0401e2;
        public static final int cr_positionBottom = 0x7f0401e3;
        public static final int cr_positionEnd = 0x7f0401e4;
        public static final int cr_positionHorizontal = 0x7f0401e5;
        public static final int cr_positionLeft = 0x7f0401e6;
        public static final int cr_positionRight = 0x7f0401e7;
        public static final int cr_positionStart = 0x7f0401e8;
        public static final int cr_positionTop = 0x7f0401e9;
        public static final int cr_positionType = 0x7f0401ea;
        public static final int cr_positionVertical = 0x7f0401eb;
        public static final int cr_width = 0x7f0401ec;
        public static final int cr_wrap = 0x7f0401ed;
        public transient /* synthetic */ FieldHolder $fh;

        public attr() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class color {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int children_background = 0x7f06045b;
        public static final int children_stroke = 0x7f06045c;
        public static final int children_text = 0x7f06045d;
        public static final int crius_blue = 0x7f0606f4;
        public static final int crius_grey = 0x7f0606f5;
        public static final int crius_swipe_indicator_back_color = 0x7f0606f6;
        public static final int crius_swipe_indicator_default = 0x7f0606f7;
        public static final int crius_swipe_indicator_selected = 0x7f0606f8;
        public static final int crius_white = 0x7f0606f9;
        public static final int transparent = 0x7f060b41;
        public transient /* synthetic */ FieldHolder $fh;

        public color() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class dimen {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int crius_swiper_indicator_bottom_margin = 0x7f0701ea;
        public static final int crius_swiper_indicator_dot_left_margin = 0x7f0701eb;
        public static final int crius_swiper_indicator_dot_size = 0x7f0701ec;
        public static final int crius_swiper_indicator_height = 0x7f0701ed;
        public static final int dimens_1dp = 0x7f070227;
        public static final int dimens_1px = 0x7f070228;
        public static final int dimens_2dp = 0x7f070229;
        public static final int dimens_3dp = 0x7f07022a;
        public static final int dimens_4dp = 0x7f07022b;
        public static final int dimens_5dp = 0x7f07022c;
        public transient /* synthetic */ FieldHolder $fh;

        public dimen() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class drawable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int crius = 0x7f080491;
        public transient /* synthetic */ FieldHolder $fh;

        public drawable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class id {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int absolute = 0x7f090028;
        public static final int auto = 0x7f0902f8;
        public static final int baseline = 0x7f09034f;
        public static final int benchmarkSelect = 0x7f09037c;
        public static final int btn = 0x7f090421;
        public static final int center = 0x7f0905ef;
        public static final int column = 0x7f0906b3;
        public static final int column_reverse = 0x7f0906b4;
        public static final int flex = 0x7f090a6d;
        public static final int flex_end = 0x7f090a6e;
        public static final int flex_start = 0x7f090a6f;
        public static final int hidden = 0x7f090e3e;
        public static final int inherit = 0x7f091009;
        public static final int ltr = 0x7f09154e;
        public static final int no_wrap = 0x7f0917d8;
        public static final int none = 0x7f0917db;
        public static final int relative = 0x7f091ca8;
        public static final int root = 0x7f091d5e;
        public static final int row = 0x7f091d84;
        public static final int row_reverse = 0x7f091d86;
        public static final int rtl = 0x7f091d87;
        public static final int scroll = 0x7f091ebc;
        public static final int space_around = 0x7f09201b;
        public static final int space_between = 0x7f09201c;
        public static final int stretch = 0x7f092094;
        public static final int text = 0x7f092216;
        public static final int visible = 0x7f092703;
        public static final int wrap = 0x7f0927a3;
        public transient /* synthetic */ FieldHolder $fh;

        public id() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class layout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int activity_benchmark = 0x7f0d002d;
        public static final int activity_crius = 0x7f0d0032;
        public static final int activity_crius_flatten = 0x7f0d0033;
        public static final int benchmark_flatten_layout = 0x7f0d0157;
        public static final int benchmark_layout = 0x7f0d0158;
        public transient /* synthetic */ FieldHolder $fh;

        public layout() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int app_name = 0x7f0f029e;
        public static final int bm_child_6_text = 0x7f0f0334;
        public static final int child_1_text = 0x7f0f03e2;
        public static final int child_2_text = 0x7f0f03e3;
        public static final int child_3_text = 0x7f0f03e4;
        public static final int child_4_text = 0x7f0f03e5;
        public static final int child_5_text = 0x7f0f03e6;
        public static final int run_benchmark = 0x7f0f10d9;
        public transient /* synthetic */ FieldHolder $fh;

        public string() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class styleable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] crius;
        public static final int crius_cr_alignContent = 0x00000000;
        public static final int crius_cr_alignItems = 0x00000001;
        public static final int crius_cr_alignSelf = 0x00000002;
        public static final int crius_cr_aspectRatio = 0x00000003;
        public static final int crius_cr_borderAll = 0x00000004;
        public static final int crius_cr_borderBottom = 0x00000005;
        public static final int crius_cr_borderEnd = 0x00000006;
        public static final int crius_cr_borderHorizontal = 0x00000007;
        public static final int crius_cr_borderLeft = 0x00000008;
        public static final int crius_cr_borderRight = 0x00000009;
        public static final int crius_cr_borderStart = 0x0000000a;
        public static final int crius_cr_borderTop = 0x0000000b;
        public static final int crius_cr_borderVertical = 0x0000000c;
        public static final int crius_cr_direction = 0x0000000d;
        public static final int crius_cr_display = 0x0000000e;
        public static final int crius_cr_flex = 0x0000000f;
        public static final int crius_cr_flexBasis = 0x00000010;
        public static final int crius_cr_flexDirection = 0x00000011;
        public static final int crius_cr_flexGrow = 0x00000012;
        public static final int crius_cr_flexShrink = 0x00000013;
        public static final int crius_cr_height = 0x00000014;
        public static final int crius_cr_justifyContent = 0x00000015;
        public static final int crius_cr_marginAll = 0x00000016;
        public static final int crius_cr_marginBottom = 0x00000017;
        public static final int crius_cr_marginEnd = 0x00000018;
        public static final int crius_cr_marginHorizontal = 0x00000019;
        public static final int crius_cr_marginLeft = 0x0000001a;
        public static final int crius_cr_marginRight = 0x0000001b;
        public static final int crius_cr_marginStart = 0x0000001c;
        public static final int crius_cr_marginTop = 0x0000001d;
        public static final int crius_cr_marginVertical = 0x0000001e;
        public static final int crius_cr_maxHeight = 0x0000001f;
        public static final int crius_cr_maxWidth = 0x00000020;
        public static final int crius_cr_minHeight = 0x00000021;
        public static final int crius_cr_minWidth = 0x00000022;
        public static final int crius_cr_overflow = 0x00000023;
        public static final int crius_cr_paddingAll = 0x00000024;
        public static final int crius_cr_paddingBottom = 0x00000025;
        public static final int crius_cr_paddingEnd = 0x00000026;
        public static final int crius_cr_paddingHorizontal = 0x00000027;
        public static final int crius_cr_paddingLeft = 0x00000028;
        public static final int crius_cr_paddingRight = 0x00000029;
        public static final int crius_cr_paddingStart = 0x0000002a;
        public static final int crius_cr_paddingTop = 0x0000002b;
        public static final int crius_cr_paddingVertical = 0x0000002c;
        public static final int crius_cr_positionAll = 0x0000002d;
        public static final int crius_cr_positionBottom = 0x0000002e;
        public static final int crius_cr_positionEnd = 0x0000002f;
        public static final int crius_cr_positionHorizontal = 0x00000030;
        public static final int crius_cr_positionLeft = 0x00000031;
        public static final int crius_cr_positionRight = 0x00000032;
        public static final int crius_cr_positionStart = 0x00000033;
        public static final int crius_cr_positionTop = 0x00000034;
        public static final int crius_cr_positionType = 0x00000035;
        public static final int crius_cr_positionVertical = 0x00000036;
        public static final int crius_cr_width = 0x00000037;
        public static final int crius_cr_wrap = 0x00000038;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1402328621, "Lcom/baidu/searchbox/crius/R$styleable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1402328621, "Lcom/baidu/searchbox/crius/R$styleable;");
                    return;
                }
            }
            crius = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0401b5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401b6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401b7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401b8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401b9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401ba, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401bb, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401bc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401bd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401be, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401bf, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401c9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401ca, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401cb, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401cc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401cd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401ce, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401cf, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401d9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401da, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401db, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401dc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401dd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401de, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401df, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401e9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401ea, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401eb, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401ec, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401ed};
        }

        public styleable() {
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

    public R() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
