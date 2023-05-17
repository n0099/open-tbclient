package com.baidu.android.common.ui.style;

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
    public static final class anim {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int accelerate_quad = 0x7f01000c;
        public static final int big_pic_toast_enter = 0x7f010046;
        public static final int big_pic_toast_exit = 0x7f010047;
        public static final int bottom_menu_appear = 0x7f01004c;
        public static final int bottom_menu_disappear = 0x7f01004d;
        public static final int brower_menu_close = 0x7f01004e;
        public static final int brower_menu_open = 0x7f01004f;
        public static final int common_menu_popupwindow_grow_fade_in = 0x7f01005f;
        public static final int common_menu_popupwindow_grow_fade_in_from_bottom = 0x7f010060;
        public static final int common_menu_popupwindow_shrink_fade_out = 0x7f010061;
        public static final int common_menu_popupwindow_shrink_fade_out_from_bottom = 0x7f010062;
        public static final int fade_out = 0x7f010064;
        public static final int highlight_toast_show = 0x7f0100a3;
        public static final int hold = 0x7f0100a5;
        public static final int notice_popupwindow_in = 0x7f0100f6;
        public static final int notice_popupwindow_out = 0x7f0100f7;
        public static final int pop_window_dismiss_anim = 0x7f010118;
        public static final int pop_window_show_anim = 0x7f01011a;
        public static final int progress_button_loading_progress = 0x7f010120;
        public static final int rotate_progressbar = 0x7f010136;
        public static final int skin_menu_close = 0x7f010151;
        public static final int skin_menu_open = 0x7f010152;
        public static final int slide_down = 0x7f010153;
        public static final int slide_in_from_bottom = 0x7f010155;
        public static final int slide_in_from_left = 0x7f010156;
        public static final int slide_in_from_right = 0x7f010157;
        public static final int slide_in_from_top = 0x7f010158;
        public static final int slide_out_to_bottom = 0x7f01015b;
        public static final int slide_out_to_left = 0x7f01015c;
        public static final int slide_out_to_right = 0x7f01015d;
        public static final int slide_out_to_right_zadjustment_top = 0x7f01015e;
        public static final int toast_enter = 0x7f010174;
        public static final int toast_exit = 0x7f010175;
        public static final int wallet_base_slide_from_left = 0x7f01013f;
        public static final int wallet_base_slide_from_right = 0x7f010185;
        public static final int wallet_base_slide_to_left = 0x7f010186;
        public static final int wallet_base_slide_to_right = 0x7f010187;
        public transient /* synthetic */ FieldHolder $fh;

        public anim() {
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

    /* loaded from: classes.dex */
    public static final class attr {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int angle = 0x7f04008e;
        public static final int animationDuration = 0x7f040093;
        public static final int auto_start = 0x7f0400af;
        public static final int avatarDiameter = 0x7f0400b0;
        public static final int base_alpha = 0x7f0400cd;
        public static final int bgBorderColor = 0x7f0400df;
        public static final int bgBorderWidth = 0x7f0400e0;
        public static final int bgNormalColor = 0x7f0400e1;
        public static final int bgPressedColor = 0x7f0400e2;
        public static final int border_color = 0x7f0400ef;
        public static final int border_width = 0x7f0400f0;
        public static final int cardBackgroundColor = 0x7f04011f;
        public static final int cardCornerRadius = 0x7f040120;
        public static final int cardElevation = 0x7f040121;
        public static final int cardMaxElevation = 0x7f040123;
        public static final int cardPreventCornerOverlap = 0x7f040124;
        public static final int cardUseCompatPadding = 0x7f040125;
        public static final int circleEndColor = 0x7f040157;
        public static final int circleStartColor = 0x7f040159;
        public static final int circleStrokeWidth = 0x7f04015a;
        public static final int contentPadding = 0x7f040183;
        public static final int contentPaddingBottom = 0x7f040184;
        public static final int contentPaddingLeft = 0x7f040185;
        public static final int contentPaddingRight = 0x7f040186;
        public static final int contentPaddingTop = 0x7f040187;
        public static final int corner_radius = 0x7f0401b8;
        public static final int disabledAlphaScale = 0x7f04025c;
        public static final int dividerArcRadius = 0x7f04025f;
        public static final int dividerLineColor = 0x7f040262;
        public static final int dividerLineHeight = 0x7f040263;
        public static final int down_alpha = 0x7f040266;
        public static final int dropoff = 0x7f04028c;
        public static final int duration = 0x7f04028e;
        public static final int entriesArray = 0x7f0402a4;
        public static final int fixed_height = 0x7f0402da;
        public static final int fixed_width = 0x7f0402db;
        public static final int fontPath = 0x7f0402f7;
        public static final int galleryStyle = 0x7f040306;
        public static final int gravity = 0x7f04030b;
        public static final int hasStickyHeaders = 0x7f04031a;
        public static final int iconFont = 0x7f040353;
        public static final int iconFontColor = 0x7f040354;
        public static final int indicatorHeight = 0x7f040371;
        public static final int intensity = 0x7f040376;
        public static final int isDrawingListUnderStickyHeader = 0x7f040378;
        public static final int label = 0x7f04041b;
        public static final int leftZoneColor = 0x7f040452;
        public static final int leftZoneWidth = 0x7f040453;
        public static final int lineColor = 0x7f04045a;
        public static final int lineSpace = 0x7f04045d;
        public static final int max = 0x7f0404e3;
        public static final int msv_emptyView = 0x7f04050c;
        public static final int msv_errorView = 0x7f04050d;
        public static final int msv_loadingView = 0x7f04050e;
        public static final int msv_viewState = 0x7f04050f;
        public static final int popupAnimationStyle = 0x7f040594;
        public static final int popupBackground = 0x7f040595;
        public static final int pressedAlphaScale = 0x7f04059e;
        public static final int pressedIconFont = 0x7f04059f;
        public static final int pressedIconFontColor = 0x7f0405a0;
        public static final int relative_height = 0x7f0405f8;
        public static final int relative_width = 0x7f0405f9;
        public static final int repeat_count = 0x7f0405fc;
        public static final int repeat_delay = 0x7f0405fd;
        public static final int repeat_mode = 0x7f0405fe;
        public static final int rightImgZone1ImageSrc = 0x7f040607;
        public static final int rightImgZone1Visibility = 0x7f040608;
        public static final int rightImgZone2ImageSrc = 0x7f040609;
        public static final int rightImgZone2Visibility = 0x7f04060a;
        public static final int rightTxtZone1Text = 0x7f040610;
        public static final int rightTxtZone1TxtColor = 0x7f040611;
        public static final int rightTxtZone1TxtShadowColor = 0x7f040612;
        public static final int rightTxtZone1TxtShadowDx = 0x7f040613;
        public static final int rightTxtZone1TxtShadowDy = 0x7f040614;
        public static final int rightTxtZone1TxtShadowRadius = 0x7f040615;
        public static final int rightTxtZone1TxtSize = 0x7f040616;
        public static final int rightTxtZone1Visibility = 0x7f040617;
        public static final int rightZonesVisibility = 0x7f04061a;
        public static final int roundColor = 0x7f040620;
        public static final int roundProgressColor = 0x7f040626;
        public static final int roundWidth = 0x7f04062d;
        public static final int round_background = 0x7f04062e;
        public static final int shadow_left = 0x7f04066a;
        public static final int shadow_right = 0x7f04066b;
        public static final int shape = 0x7f04066d;
        public static final int spacing = 0x7f040697;
        public static final int stickyListHeadersListViewStyle = 0x7f0406b9;
        public static final int style = 0x7f0406bc;
        public static final int tabDistance = 0x7f0406d7;
        public static final int tabLayout_indicatorColor = 0x7f0406e3;
        public static final int tabPadding = 0x7f0406e7;
        public static final int tabPaddingBottom = 0x7f0406e8;
        public static final int tabPaddingEnd = 0x7f0406e9;
        public static final int tabPaddingStart = 0x7f0406ea;
        public static final int tabPaddingTop = 0x7f0406eb;
        public static final int tabTextColors = 0x7f0406f1;
        public static final int tabTextSize = 0x7f0406f2;
        public static final int textColor = 0x7f04074c;
        public static final int textIsDisplayable = 0x7f040756;
        public static final int textSize = 0x7f040759;
        public static final int tilt = 0x7f040779;
        public static final int title = 0x7f04077c;
        public static final int titleAlignment = 0x7f04077d;
        public static final int titleColor = 0x7f04077e;
        public static final int titleText = 0x7f040787;
        public static final int titleTxtShadowColor = 0x7f04078b;
        public static final int titleTxtShadowDx = 0x7f04078c;
        public static final int titleTxtShadowDy = 0x7f04078d;
        public static final int titleTxtShadowRadius = 0x7f04078e;
        public static final int unselectedAlpha = 0x7f0407ca;
        public static final int useNightMode = 0x7f0407cd;
        public static final int vpiDrawablePageIndicatorStyle = 0x7f0407e8;
        public static final int vpi_height = 0x7f0407e9;
        public static final int wheelview_dividerColor = 0x7f0407f0;
        public static final int wheelview_gravity = 0x7f0407f1;
        public static final int wheelview_lineSpacingMultiplier = 0x7f0407f2;
        public static final int wheelview_textColorCenter = 0x7f0407f3;
        public static final int wheelview_textColorOut = 0x7f0407f4;
        public static final int wheelview_textSize = 0x7f0407f5;
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

    /* loaded from: classes.dex */
    public static final class color {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BC137 = 0x7f060003;
        public static final int BC183 = 0x7f060005;
        public static final int BC184 = 0x7f060006;
        public static final int BC185 = 0x7f060007;

        /* renamed from: BC337 */
        public static final int obfuscated = 0x7f060009;
        public static final int BC59 = 0x7f06000a;
        public static final int BC60 = 0x7f06000b;
        public static final int BC64 = 0x7f06000d;
        public static final int BC65 = 0x7f06000e;
        public static final int BC66 = 0x7f06000f;
        public static final int GC1 = 0x7f060187;
        public static final int GC10 = 0x7f060188;
        public static final int GC100 = 0x7f060189;

        /* renamed from: GC101 */
        public static final int obfuscated = 0x7f06018a;

        /* renamed from: GC102 */
        public static final int obfuscated = 0x7f06018b;
        public static final int GC103 = 0x7f06018c;

        /* renamed from: GC104 */
        public static final int obfuscated = 0x7f06018d;

        /* renamed from: GC105 */
        public static final int obfuscated = 0x7f06018e;

        /* renamed from: GC106 */
        public static final int obfuscated = 0x7f06018f;

        /* renamed from: GC107 */
        public static final int obfuscated = 0x7f060190;

        /* renamed from: GC108 */
        public static final int obfuscated = 0x7f060191;

        /* renamed from: GC109 */
        public static final int obfuscated = 0x7f060192;
        public static final int GC11 = 0x7f060193;

        /* renamed from: GC110 */
        public static final int obfuscated = 0x7f060194;

        /* renamed from: GC111 */
        public static final int obfuscated = 0x7f060195;

        /* renamed from: GC113 */
        public static final int obfuscated = 0x7f060196;

        /* renamed from: GC116 */
        public static final int obfuscated = 0x7f060197;

        /* renamed from: GC117 */
        public static final int obfuscated = 0x7f060198;

        /* renamed from: GC118 */
        public static final int obfuscated = 0x7f060199;

        /* renamed from: GC119 */
        public static final int obfuscated = 0x7f06019a;
        public static final int GC12 = 0x7f06019b;

        /* renamed from: GC120 */
        public static final int obfuscated = 0x7f06019c;

        /* renamed from: GC121 */
        public static final int obfuscated = 0x7f06019d;

        /* renamed from: GC122 */
        public static final int obfuscated = 0x7f06019e;

        /* renamed from: GC123 */
        public static final int obfuscated = 0x7f06019f;

        /* renamed from: GC124 */
        public static final int obfuscated = 0x7f0601a0;

        /* renamed from: GC125 */
        public static final int obfuscated = 0x7f0601a1;

        /* renamed from: GC126 */
        public static final int obfuscated = 0x7f0601a2;

        /* renamed from: GC129 */
        public static final int obfuscated = 0x7f0601a3;
        public static final int GC13 = 0x7f0601a4;
        public static final int GC14 = 0x7f0601a5;
        public static final int GC15 = 0x7f0601a6;
        public static final int GC16 = 0x7f0601a7;
        public static final int GC17 = 0x7f0601a8;
        public static final int GC18 = 0x7f0601a9;
        public static final int GC19 = 0x7f0601aa;
        public static final int GC2 = 0x7f0601ab;
        public static final int GC20 = 0x7f0601ac;
        public static final int GC21 = 0x7f0601ad;
        public static final int GC22 = 0x7f0601ae;
        public static final int GC23 = 0x7f0601af;
        public static final int GC24 = 0x7f0601b0;
        public static final int GC25 = 0x7f0601b1;
        public static final int GC26 = 0x7f0601b2;
        public static final int GC27 = 0x7f0601b3;
        public static final int GC28 = 0x7f0601b4;
        public static final int GC29 = 0x7f0601b5;
        public static final int GC3 = 0x7f0601b6;
        public static final int GC30 = 0x7f0601b7;
        public static final int GC31 = 0x7f0601b8;
        public static final int GC32 = 0x7f0601b9;
        public static final int GC33 = 0x7f0601ba;
        public static final int GC34 = 0x7f0601bb;
        public static final int GC35 = 0x7f0601bc;
        public static final int GC36 = 0x7f0601bd;
        public static final int GC37 = 0x7f0601be;
        public static final int GC38 = 0x7f0601bf;
        public static final int GC39 = 0x7f0601c0;
        public static final int GC4 = 0x7f0601c1;
        public static final int GC40 = 0x7f0601c2;
        public static final int GC41 = 0x7f0601c3;
        public static final int GC42 = 0x7f0601c4;
        public static final int GC43 = 0x7f0601c5;
        public static final int GC44 = 0x7f0601c6;
        public static final int GC45 = 0x7f0601c7;
        public static final int GC46 = 0x7f0601c8;
        public static final int GC47 = 0x7f0601c9;
        public static final int GC48 = 0x7f0601ca;
        public static final int GC49 = 0x7f0601cb;
        public static final int GC5 = 0x7f0601cc;
        public static final int GC50 = 0x7f0601cd;
        public static final int GC51 = 0x7f0601ce;
        public static final int GC52 = 0x7f0601cf;
        public static final int GC53 = 0x7f0601d0;
        public static final int GC54 = 0x7f0601d1;
        public static final int GC55 = 0x7f0601d2;
        public static final int GC56 = 0x7f0601d3;
        public static final int GC57 = 0x7f0601d4;
        public static final int GC58 = 0x7f0601d5;
        public static final int GC59 = 0x7f0601d6;
        public static final int GC6 = 0x7f0601d7;
        public static final int GC60 = 0x7f0601d8;
        public static final int GC61 = 0x7f0601d9;
        public static final int GC62 = 0x7f0601da;
        public static final int GC63 = 0x7f0601db;
        public static final int GC64 = 0x7f0601dc;
        public static final int GC65 = 0x7f0601dd;
        public static final int GC66 = 0x7f0601de;
        public static final int GC67 = 0x7f0601df;
        public static final int GC68 = 0x7f0601e0;
        public static final int GC69 = 0x7f0601e1;
        public static final int GC7 = 0x7f0601e2;
        public static final int GC70 = 0x7f0601e3;
        public static final int GC71 = 0x7f0601e4;
        public static final int GC72 = 0x7f0601e5;
        public static final int GC73 = 0x7f0601e6;
        public static final int GC74 = 0x7f0601e7;
        public static final int GC75 = 0x7f0601e8;
        public static final int GC76 = 0x7f0601e9;
        public static final int GC77 = 0x7f0601ea;
        public static final int GC78 = 0x7f0601eb;
        public static final int GC79 = 0x7f0601ec;
        public static final int GC8 = 0x7f0601ed;
        public static final int GC80 = 0x7f0601ee;
        public static final int GC81 = 0x7f0601f0;
        public static final int GC82 = 0x7f0601f1;
        public static final int GC83 = 0x7f0601f2;
        public static final int GC84 = 0x7f0601f3;
        public static final int GC85 = 0x7f0601f4;
        public static final int GC86 = 0x7f0601f5;
        public static final int GC87 = 0x7f0601f6;
        public static final int GC88 = 0x7f0601f7;
        public static final int GC89 = 0x7f0601f8;
        public static final int GC9 = 0x7f0601f9;
        public static final int GC90 = 0x7f0601fa;

        /* renamed from: GC91 */
        public static final int obfuscated = 0x7f0601fb;

        /* renamed from: GC92 */
        public static final int obfuscated = 0x7f0601fc;
        public static final int GC93 = 0x7f0601fd;
        public static final int GC94 = 0x7f0601fe;
        public static final int GC95 = 0x7f0601ff;
        public static final int GC96 = 0x7f060200;
        public static final int GC97 = 0x7f060201;
        public static final int GC98 = 0x7f060202;
        public static final int GC99 = 0x7f060203;
        public static final int UC1 = 0x7f060365;
        public static final int UC10 = 0x7f060366;
        public static final int UC11 = 0x7f060367;
        public static final int UC12 = 0x7f060368;
        public static final int UC13 = 0x7f060369;
        public static final int UC14 = 0x7f06036a;
        public static final int UC15 = 0x7f06036b;
        public static final int UC16 = 0x7f06036d;
        public static final int UC17 = 0x7f06036e;
        public static final int UC18 = 0x7f06036f;
        public static final int UC19 = 0x7f060370;
        public static final int UC2 = 0x7f060371;
        public static final int UC20 = 0x7f060372;
        public static final int UC21 = 0x7f060373;
        public static final int UC22 = 0x7f060374;
        public static final int UC23 = 0x7f060375;
        public static final int UC24 = 0x7f060376;
        public static final int UC25 = 0x7f060377;
        public static final int UC26 = 0x7f060378;
        public static final int UC27 = 0x7f060379;
        public static final int UC28 = 0x7f06037a;
        public static final int UC29 = 0x7f06037b;
        public static final int UC3 = 0x7f06037c;
        public static final int UC30 = 0x7f06037d;
        public static final int UC31 = 0x7f06037e;
        public static final int UC32 = 0x7f06037f;
        public static final int UC33 = 0x7f060380;
        public static final int UC34 = 0x7f060381;
        public static final int UC35 = 0x7f060382;
        public static final int UC36 = 0x7f060383;
        public static final int UC37 = 0x7f060384;
        public static final int UC38 = 0x7f060385;
        public static final int UC39 = 0x7f060386;
        public static final int UC4 = 0x7f060387;
        public static final int UC40 = 0x7f060388;
        public static final int UC41 = 0x7f060389;
        public static final int UC42 = 0x7f06038a;
        public static final int UC43 = 0x7f06038b;
        public static final int UC44 = 0x7f06038c;
        public static final int UC45 = 0x7f06038d;
        public static final int UC46 = 0x7f06038e;
        public static final int UC47 = 0x7f06038f;
        public static final int UC48 = 0x7f060390;
        public static final int UC49 = 0x7f060391;
        public static final int UC5 = 0x7f060392;
        public static final int UC50 = 0x7f060393;
        public static final int UC51 = 0x7f060394;
        public static final int UC52 = 0x7f060395;
        public static final int UC53 = 0x7f060396;
        public static final int UC54 = 0x7f060397;
        public static final int UC55 = 0x7f060398;
        public static final int UC56 = 0x7f060399;
        public static final int UC57 = 0x7f06039a;
        public static final int UC58 = 0x7f06039b;
        public static final int UC59 = 0x7f06039c;
        public static final int UC6 = 0x7f06039d;
        public static final int UC60 = 0x7f06039e;
        public static final int UC61 = 0x7f06039f;
        public static final int UC62 = 0x7f0603a0;
        public static final int UC63 = 0x7f0603a1;
        public static final int UC64 = 0x7f0603a2;
        public static final int UC65 = 0x7f0603a3;
        public static final int UC66 = 0x7f0603a4;
        public static final int UC67 = 0x7f0603a5;
        public static final int UC68 = 0x7f0603a6;
        public static final int UC69 = 0x7f0603a7;
        public static final int UC7 = 0x7f0603a8;
        public static final int UC70 = 0x7f0603a9;
        public static final int UC71 = 0x7f0603aa;
        public static final int UC8 = 0x7f0603ab;
        public static final int UC80 = 0x7f0603ac;
        public static final int UC81 = 0x7f0603ad;
        public static final int UC82 = 0x7f0603ae;
        public static final int UC83 = 0x7f0603af;
        public static final int UC9 = 0x7f0603b0;
        public static final int account_background_color = 0x7f0603cc;
        public static final int action_bar_edit_txt_color = 0x7f0603de;
        public static final int action_bar_edit_txt_color_disable = 0x7f0603df;
        public static final int action_bar_edit_txt_color_pressed = 0x7f0603e0;
        public static final int action_bar_edit_txt_selector = 0x7f0603e1;
        public static final int action_bar_operation_btn_selector = 0x7f0603e2;
        public static final int action_bar_operation_btn_txt_color = 0x7f0603e3;
        public static final int action_bar_title_divider_color = 0x7f0603e4;
        public static final int badge_text_color = 0x7f06047e;
        public static final int bd_place_holder_solid = 0x7f060483;
        public static final int bd_place_holder_solid_night = 0x7f060484;
        public static final int bd_place_holder_stroke = 0x7f060485;
        public static final int black = 0x7f06049c;
        public static final int black_100 = 0x7f06049d;
        public static final int black_40 = 0x7f06049e;
        public static final int black_70 = 0x7f06049f;
        public static final int black_80 = 0x7f0604a0;
        public static final int bomb_comment_text_color = 0x7f0604b5;
        public static final int bookmark_history_group_pressed = 0x7f0604b6;
        public static final int bookmark_tab_indicator = 0x7f0604b7;
        public static final int bookmark_tabhost_bg = 0x7f0604b8;
        public static final int box_dialog_message_text_color = 0x7f0604bb;
        public static final int bubble_link_text_color = 0x7f0604c8;
        public static final int bubble_text_color = 0x7f0604c9;
        public static final int card_remind_timepicker_wheel_background = 0x7f0604ce;
        public static final int cardview_dark_background = 0x7f0604cf;
        public static final int cardview_light_background = 0x7f0604d0;
        public static final int cardview_shadow_end_color = 0x7f0604d1;
        public static final int cardview_shadow_start_color = 0x7f0604d2;
        public static final int comment_detail_content_like_num = 0x7f0604e8;
        public static final int comment_detail_content_unlike_num = 0x7f0604e9;
        public static final int comment_item_like_text_color_selector = 0x7f0604ef;
        public static final int comment_item_unlike_text_color_selector = 0x7f0604f0;
        public static final int comment_popup_bottom_devider = 0x7f0604f1;
        public static final int comment_popup_devider = 0x7f0604f2;
        public static final int comment_popup_item_press_bg = 0x7f0604f3;
        public static final int common_tab_item_textcolor = 0x7f060638;
        public static final int common_tab_text_selected = 0x7f060639;
        public static final int common_tab_text_unselected = 0x7f06063a;
        public static final int context_menu_bg = 0x7f06064b;
        public static final int context_menu_divider_color = 0x7f06064c;
        public static final int context_menu_item_pressed_color = 0x7f06064d;
        public static final int context_menu_item_title_color = 0x7f06064e;
        public static final int custom_blue_btn_bg_color = 0x7f0606d8;
        public static final int custom_blue_btn_bg_color_pressed = 0x7f0606d9;
        public static final int custom_blue_btn_text_color = 0x7f0606da;
        public static final int custom_blue_btn_text_color_pressed = 0x7f0606db;
        public static final int custom_blue_btn_text_color_selector = 0x7f0606dc;
        public static final int custom_dialog_btn_bg_pressed_color = 0x7f0606dd;
        public static final int custom_dialog_btn_bg_selector = 0x7f0606de;
        public static final int dasou_toast_bg_color = 0x7f0606e0;
        public static final int data_picker_color = 0x7f0606e1;
        public static final int delete_disabled = 0x7f0606e2;
        public static final int delete_enabled = 0x7f0606e3;
        public static final int dialog_blue_line = 0x7f06070f;
        public static final int dialog_btn_text_color = 0x7f060710;
        public static final int dialog_gray = 0x7f060711;
        public static final int dialog_night_text = 0x7f060713;
        public static final int dialog_title_text_color = 0x7f060714;
        public static final int dialog_warm_blue = 0x7f060715;
        public static final int discovery_home_menu_item_press_color = 0x7f06071a;
        public static final int discovery_home_menu_text_color = 0x7f06071b;
        public static final int download_item_delete_pressed_color = 0x7f06071f;
        public static final int empty_btn_solid_pressed = 0x7f06072c;
        public static final int empty_btn_stroke_pressed = 0x7f06072d;
        public static final int empty_layout_backgroud = 0x7f06072e;
        public static final int empty_view_btn_text_pressed = 0x7f06072f;
        public static final int emptyview_btn_text_color = 0x7f060730;
        public static final int emptyview_link_text_color = 0x7f060731;
        public static final int emptyview_subtitle_text_color = 0x7f060732;
        public static final int emptyview_title_text_color = 0x7f060733;
        public static final int follow_item_pressed_backgroud = 0x7f060741;
        public static final int gray_333333 = 0x7f060757;
        public static final int gray_F5F5F5 = 0x7f060758;
        public static final int gray_stroke = 0x7f060759;
        public static final int home_empty_view_classic_textcolor = 0x7f06075c;
        public static final int home_menu_separator_color = 0x7f06075d;
        public static final int home_skin_menu_item_pressed_color = 0x7f06075e;
        public static final int home_tab_bubble_tips_text_color = 0x7f06075f;
        public static final int indicator_menu_bg_color = 0x7f060761;
        public static final int indicator_menu_divider_color = 0x7f060762;
        public static final int launcher_title_button_selected = 0x7f0607a3;
        public static final int loading_text_color = 0x7f0607b5;
        public static final int msg_tab_item_textcolor_color = 0x7f0607e8;
        public static final int msg_tab_item_textcolor_state_selected = 0x7f0607e9;
        public static final int network_error_link_text_color = 0x7f0608db;
        public static final int network_error_link_text_color_night = 0x7f0608dc;
        public static final int novel_comment_empty_color = 0x7f0608eb;
        public static final int novel_tabhost_divider = 0x7f0608ec;
        public static final int null_color = 0x7f0608ed;
        public static final int preference_list_fragment_bg = 0x7f060939;
        public static final int progress_button_normal_color = 0x7f060942;
        public static final int progress_button_pressed_color = 0x7f060943;
        public static final int refresh_result_bg_color = 0x7f06094b;
        public static final int scheme_custom_back_view_shape_corner_color = 0x7f060a67;
        public static final int setting_item_divider_color = 0x7f060a71;
        public static final int tab_indicator_color = 0x7f060b1a;
        public static final int tab_item_color = 0x7f060b1b;
        public static final int tab_sub_item_color = 0x7f060b1c;
        public static final int tab_text_selected = 0x7f060b1d;
        public static final int tab_text_unselected = 0x7f060b1e;
        public static final int title_text_color = 0x7f060b2b;
        public static final int toast_bg_color = 0x7f060b2c;
        public static final int toast_bg_stroke_color = 0x7f060b2d;
        public static final int toast_button_bg_enable_color = 0x7f060b2e;
        public static final int toast_button_bg_stroke_color = 0x7f060b2f;
        public static final int toast_button_bg_unable_color = 0x7f060b30;
        public static final int toast_text_color = 0x7f060b31;
        public static final int traffic_mode_settings_item_background_color = 0x7f060b5b;
        public static final int traffic_mode_settings_line_background_color = 0x7f060b5c;
        public static final int traffic_mode_settings_menu_line_background_color = 0x7f060b5d;
        public static final int traffic_mode_settings_subtitle_color = 0x7f060b5e;
        public static final int traffic_mode_settings_title_color = 0x7f060b5f;
        public static final int transparent = 0x7f060b60;
        public static final int ui_cover_layer_color = 0x7f060b6a;
        public static final int video_detail_like_color = 0x7f060b6d;
        public static final int video_detail_tag_stroke = 0x7f060b6e;
        public static final int video_download_item_title_text_color = 0x7f060b6f;
        public static final int video_frame_pop_banner_bg = 0x7f060b70;
        public static final int webview_parent_container_bg_color = 0x7f060b71;
        public static final int white = 0x7f060b72;
        public static final int white_20 = 0x7f060b73;
        public static final int white_70 = 0x7f060b74;
        public static final int white_background = 0x7f060b85;
        public static final int white_pressed = 0x7f060b86;
        public static final int white_text = 0x7f060b87;
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

    /* loaded from: classes.dex */
    public static final class dimen {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int action_bar_left_operation_txt_size = 0x7f0700da;
        public static final int action_bar_operation_image_inner_margin = 0x7f0700db;
        public static final int action_bar_operation_right_margin = 0x7f0700dc;
        public static final int action_bar_operation_txt_margin = 0x7f0700dd;
        public static final int action_bar_operation_txt_size = 0x7f0700de;
        public static final int actionbar_menu_right_padding = 0x7f0700e0;
        public static final int actionbar_menu_top_padding = 0x7f0700e1;
        public static final int bd_action_bar_menu_max_height = 0x7f0701a7;
        public static final int big_pic_toast_view_margin_bottom = 0x7f0701d1;
        public static final int bookmark_actionbar_txt_height = 0x7f0701d6;
        public static final int bookmark_actionbar_txt_width = 0x7f0701d7;
        public static final int bookmark_tab_indicator_height = 0x7f0701d8;
        public static final int bubble_horizontal_arrow_view_height = 0x7f0701da;
        public static final int bubble_horizontal_arrow_view_width = 0x7f0701db;
        public static final int bubble_jump_arrow_width = 0x7f0701dc;
        public static final int bubble_mini_text_size = 0x7f0701dd;
        public static final int bubble_padding_bottom = 0x7f0701de;
        public static final int bubble_padding_left = 0x7f0701df;
        public static final int bubble_padding_right = 0x7f0701e0;
        public static final int bubble_padding_top = 0x7f0701e1;
        public static final int bubble_radius = 0x7f0701e2;
        public static final int bubble_radius_d20 = 0x7f0701e3;
        public static final int bubble_text_line_space = 0x7f0701e4;
        public static final int bubble_text_max_width = 0x7f0701e5;
        public static final int bubble_text_min_width = 0x7f0701e6;
        public static final int bubble_text_size = 0x7f0701e7;
        public static final int bubble_vertical_arrow_view_height = 0x7f0701e9;
        public static final int bubble_vertical_arrow_view_width = 0x7f0701ea;
        public static final int button_toast_bg_stroke_width = 0x7f0701ec;
        public static final int button_toast_btn_corner_radius = 0x7f0701ed;
        public static final int button_toast_btn_height = 0x7f0701ee;
        public static final int button_toast_btn_text_size = 0x7f0701ef;
        public static final int button_toast_btn_width = 0x7f0701f1;
        public static final int button_toast_text_margin_horizon = 0x7f0701f2;
        public static final int button_toast_text_margin_vertical = 0x7f0701f3;
        public static final int button_toast_text_size = 0x7f0701f4;
        public static final int button_toast_view_corner_radius = 0x7f0701f5;
        public static final int button_toast_view_margin_bottom = 0x7f0701f6;
        public static final int cardview_compat_inset_shadow = 0x7f0701fe;
        public static final int cardview_default_elevation = 0x7f0701ff;
        public static final int cardview_default_radius = 0x7f070200;
        public static final int clickable_2_toast_container_margin_h = 0x7f070214;
        public static final int clickable_2_toast_diviver_margin_h = 0x7f070216;
        public static final int clickable_2_toast_lefticon_size = 0x7f070217;
        public static final int clickable_2_toast_lefttext_margin_left = 0x7f070218;
        public static final int clickable_toast_button_margin_left = 0x7f070219;
        public static final int clickable_toast_button_margin_right = 0x7f07021a;
        public static final int clickable_toast_icon_height = 0x7f07021b;
        public static final int clickable_toast_icon_margin_left = 0x7f07021c;
        public static final int clickable_toast_icon_width = 0x7f07021e;
        public static final int clickable_toast_line_padding = 0x7f07021f;
        public static final int clickable_toast_line_width = 0x7f070220;
        public static final int clickable_toast_multi_line_padding = 0x7f070221;
        public static final int clickable_toast_padding_bottom = 0x7f070222;
        public static final int clickable_toast_padding_top = 0x7f070223;
        public static final int clickable_toast_single_line_padding = 0x7f070226;
        public static final int clickable_toast_text_margin_left = 0x7f070227;
        public static final int clickable_toast_text_padding_right = 0x7f070228;
        public static final int clickable_toast_view_margin_bottom = 0x7f070229;
        public static final int clickable_toast_view_shift_start_y = 0x7f07022a;
        public static final int comment_list_item_icon_height = 0x7f070231;
        public static final int comment_list_item_icon_width = 0x7f070232;
        public static final int common_grid_indicator_height = 0x7f07023b;
        public static final int common_grid_indicator_height2 = 0x7f07023c;
        public static final int common_grid_indicator_margin = 0x7f07023d;
        public static final int common_grid_row_margin = 0x7f07023e;
        public static final int common_tool_bar_height = 0x7f070240;
        public static final int context_menu_corner_radius = 0x7f070268;
        public static final int context_menu_item_height = 0x7f070269;
        public static final int context_menu_item_icon_left_margin = 0x7f07026b;
        public static final int context_menu_item_icon_size = 0x7f07026c;
        public static final int context_menu_item_title_left_margin = 0x7f07026d;
        public static final int context_menu_item_title_right_margin = 0x7f07026e;
        public static final int context_menu_item_title_size = 0x7f070270;
        public static final int context_menu_max_width = 0x7f070271;
        public static final int custom_btn_corner_radius = 0x7f07028c;
        public static final int custom_dialog_corner_radius = 0x7f07028d;
        public static final int dasou_toast_view_corner_radius = 0x7f07028e;
        public static final int dasou_toast_view_height = 0x7f07028f;
        public static final int dasou_toast_view_margin_bottom_toolbar_high = 0x7f070290;
        public static final int dasou_toast_view_margin_bottom_toolbar_low = 0x7f070291;
        public static final int dialog_btns_height = 0x7f0702c6;
        public static final int dialog_content_margin_top = 0x7f0702c7;
        public static final int dialog_message_margin_bottom = 0x7f0702c8;
        public static final int dialog_message_normal_margin_bottom = 0x7f0702c9;
        public static final int dialog_message_normal_margin_top = 0x7f0702ca;
        public static final int dialog_text_padding = 0x7f0702cb;
        public static final int dialog_title_height = 0x7f0702cc;
        public static final int dimen_ui_0 = 0x7f0702cd;
        public static final int dimen_ui_1 = 0x7f0702ce;
        public static final int dimen_ui_10 = 0x7f0702cf;
        public static final int dimen_ui_100 = 0x7f0702d0;
        public static final int dimen_ui_11 = 0x7f0702d1;
        public static final int dimen_ui_12 = 0x7f0702d2;
        public static final int dimen_ui_13 = 0x7f0702d3;
        public static final int dimen_ui_14 = 0x7f0702d4;
        public static final int dimen_ui_15 = 0x7f0702d5;
        public static final int dimen_ui_16 = 0x7f0702d6;
        public static final int dimen_ui_17 = 0x7f0702d7;
        public static final int dimen_ui_18 = 0x7f0702d8;
        public static final int dimen_ui_19 = 0x7f0702d9;
        public static final int dimen_ui_2 = 0x7f0702da;
        public static final int dimen_ui_20 = 0x7f0702db;
        public static final int dimen_ui_21 = 0x7f0702dc;
        public static final int dimen_ui_22 = 0x7f0702dd;
        public static final int dimen_ui_23 = 0x7f0702de;
        public static final int dimen_ui_24 = 0x7f0702df;
        public static final int dimen_ui_25 = 0x7f0702e0;
        public static final int dimen_ui_26 = 0x7f0702e1;
        public static final int dimen_ui_27 = 0x7f0702e2;
        public static final int dimen_ui_28 = 0x7f0702e3;
        public static final int dimen_ui_29 = 0x7f0702e4;
        public static final int dimen_ui_3 = 0x7f0702e5;
        public static final int dimen_ui_30 = 0x7f0702e6;
        public static final int dimen_ui_31 = 0x7f0702e7;
        public static final int dimen_ui_32 = 0x7f0702e8;
        public static final int dimen_ui_33 = 0x7f0702e9;
        public static final int dimen_ui_34 = 0x7f0702ea;
        public static final int dimen_ui_35 = 0x7f0702eb;
        public static final int dimen_ui_36 = 0x7f0702ec;
        public static final int dimen_ui_37 = 0x7f0702ed;
        public static final int dimen_ui_38 = 0x7f0702ee;
        public static final int dimen_ui_39 = 0x7f0702ef;
        public static final int dimen_ui_4 = 0x7f0702f0;
        public static final int dimen_ui_40 = 0x7f0702f1;
        public static final int dimen_ui_41 = 0x7f0702f2;
        public static final int dimen_ui_42 = 0x7f0702f3;
        public static final int dimen_ui_43 = 0x7f0702f4;
        public static final int dimen_ui_44 = 0x7f0702f5;
        public static final int dimen_ui_45 = 0x7f0702f6;
        public static final int dimen_ui_46 = 0x7f0702f7;
        public static final int dimen_ui_47 = 0x7f0702f8;
        public static final int dimen_ui_48 = 0x7f0702f9;
        public static final int dimen_ui_49 = 0x7f0702fa;
        public static final int dimen_ui_5 = 0x7f0702fb;
        public static final int dimen_ui_50 = 0x7f0702fc;
        public static final int dimen_ui_51 = 0x7f0702fd;
        public static final int dimen_ui_52 = 0x7f0702fe;
        public static final int dimen_ui_53 = 0x7f0702ff;
        public static final int dimen_ui_54 = 0x7f070300;
        public static final int dimen_ui_55 = 0x7f070301;
        public static final int dimen_ui_56 = 0x7f070302;
        public static final int dimen_ui_57 = 0x7f070303;
        public static final int dimen_ui_58 = 0x7f070304;
        public static final int dimen_ui_59 = 0x7f070305;
        public static final int dimen_ui_6 = 0x7f070306;
        public static final int dimen_ui_60 = 0x7f070307;
        public static final int dimen_ui_61 = 0x7f070308;
        public static final int dimen_ui_62 = 0x7f070309;
        public static final int dimen_ui_63 = 0x7f07030a;
        public static final int dimen_ui_64 = 0x7f07030b;
        public static final int dimen_ui_65 = 0x7f07030c;
        public static final int dimen_ui_66 = 0x7f07030d;
        public static final int dimen_ui_67 = 0x7f07030e;
        public static final int dimen_ui_68 = 0x7f07030f;
        public static final int dimen_ui_69 = 0x7f070310;
        public static final int dimen_ui_7 = 0x7f070311;
        public static final int dimen_ui_70 = 0x7f070312;
        public static final int dimen_ui_71 = 0x7f070313;
        public static final int dimen_ui_72 = 0x7f070314;
        public static final int dimen_ui_73 = 0x7f070315;
        public static final int dimen_ui_74 = 0x7f070316;
        public static final int dimen_ui_75 = 0x7f070317;
        public static final int dimen_ui_76 = 0x7f070318;
        public static final int dimen_ui_77 = 0x7f070319;
        public static final int dimen_ui_78 = 0x7f07031a;
        public static final int dimen_ui_79 = 0x7f07031b;
        public static final int dimen_ui_8 = 0x7f07031c;
        public static final int dimen_ui_80 = 0x7f07031d;
        public static final int dimen_ui_81 = 0x7f07031e;
        public static final int dimen_ui_82 = 0x7f07031f;
        public static final int dimen_ui_83 = 0x7f070320;
        public static final int dimen_ui_84 = 0x7f070321;
        public static final int dimen_ui_85 = 0x7f070322;
        public static final int dimen_ui_86 = 0x7f070323;
        public static final int dimen_ui_87 = 0x7f070324;
        public static final int dimen_ui_88 = 0x7f070325;
        public static final int dimen_ui_89 = 0x7f070326;
        public static final int dimen_ui_9 = 0x7f070327;
        public static final int dimen_ui_90 = 0x7f070328;
        public static final int dimen_ui_91 = 0x7f070329;
        public static final int dimen_ui_92 = 0x7f07032a;
        public static final int dimen_ui_93 = 0x7f07032b;
        public static final int dimen_ui_94 = 0x7f07032c;
        public static final int dimen_ui_95 = 0x7f07032d;
        public static final int dimen_ui_96 = 0x7f07032e;
        public static final int dimen_ui_97 = 0x7f07032f;
        public static final int dimen_ui_98 = 0x7f070330;
        public static final int dimen_ui_99 = 0x7f070331;
        public static final int dimens_21dp = 0x7f070334;
        public static final int dimens_51dp = 0x7f070338;
        public static final int dimens_54dp = 0x7f070339;
        public static final int discovery_feedback_item_height = 0x7f07033d;
        public static final int discovery_feedback_width = 0x7f07033e;
        public static final int download_finish_tip_height_new_double = 0x7f070340;
        public static final int downloaded_appsearch_arrow_margin = 0x7f070341;
        public static final int downloaded_appsearch_bottom = 0x7f070342;
        public static final int downloaded_appsearch_header_height = 0x7f070343;
        public static final int downloaded_appsearch_title_margin = 0x7f070344;
        public static final int downloaded_appsearch_title_text_size = 0x7f070345;
        public static final int downloaded_appsearch_top = 0x7f070346;
        public static final int empty_view_bottom_margin = 0x7f070431;
        public static final int empty_view_bottom_margin_landscape = 0x7f070432;
        public static final int empty_view_bottom_margin_portrait = 0x7f070433;
        public static final int empty_view_icon_size = 0x7f070434;
        public static final int global_toast_view_corner_radius = 0x7f070458;
        public static final int highlight_toast_image_margin_top = 0x7f07045c;
        public static final int highlight_toast_image_size = 0x7f07045d;
        public static final int highlight_toast_view_corner_radius = 0x7f07045e;
        public static final int highlight_toast_view_height = 0x7f07045f;
        public static final int highlight_toast_view_text_margin_top = 0x7f070461;
        public static final int highlight_toast_view_text_size = 0x7f070462;
        public static final int highlight_toast_view_width = 0x7f070463;
        public static final int home_skin_setting_bubble_height = 0x7f070469;
        public static final int home_skin_setting_bubble_width = 0x7f07046a;
        public static final int home_tab_height = 0x7f07046b;
        public static final int indicator_menu_divider_padding = 0x7f070471;
        public static final int indicator_menu_radius = 0x7f070472;
        public static final int message_letter_size = 0x7f070576;
        public static final int normal_base_action_bar_height = 0x7f070720;
        public static final int normal_toast_text_padding_bottom = 0x7f070722;
        public static final int normal_toast_text_padding_left = 0x7f070723;
        public static final int normal_toast_text_padding_right = 0x7f070724;
        public static final int normal_toast_text_padding_top = 0x7f070725;
        public static final int pager_tab_height = 0x7f070736;
        public static final int pager_tab_item_textsize = 0x7f070737;
        public static final int pager_tab_sub_item_textsize = 0x7f070738;
        public static final int picture_loading_text_top_margin = 0x7f070754;
        public static final int progress_bar_dialog_content_horizontal_spacing = 0x7f070757;
        public static final int progress_bar_dialog_content_layout_height = 0x7f070758;
        public static final int progress_bar_dialog_content_progress_bar_size = 0x7f070759;
        public static final int progress_bar_dialog_content_progress_text_size = 0x7f07075a;
        public static final int pulldown_divider_height = 0x7f07076f;
        public static final int scheme_custom_back_view_shape_corner = 0x7f07078f;
        public static final int single_choice_dialog_left_margin = 0x7f0707ab;
        public static final int toast_bg_stroke_width = 0x7f070afd;
        public static final int toast_view_text_size = 0x7f070afe;
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

    /* loaded from: classes.dex */
    public static final class drawable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int SettingsActivityBackGround = 0x7f08005e;
        public static final int account_user_login_img = 0x7f0800c5;
        public static final int action_bar_add_bookmark_selector = 0x7f0800c8;
        public static final int action_bar_add_bookmarkdir_selector = 0x7f0800c9;
        public static final int action_bar_back_normal = 0x7f0800ca;
        public static final int action_bar_back_pressed = 0x7f0800cb;
        public static final int action_bar_back_selector = 0x7f0800cc;
        public static final int action_bar_bg = 0x7f0800cd;
        public static final int action_bar_black_menu_normal = 0x7f0800ce;
        public static final int action_bar_black_menu_normal_pressed = 0x7f0800cf;
        public static final int action_bar_black_menu_normal_selector = 0x7f0800d0;
        public static final int action_bar_menu_normal = 0x7f0800d1;
        public static final int action_bar_menu_normal_pressed = 0x7f0800d2;
        public static final int action_bar_menu_normal_selector = 0x7f0800d3;
        public static final int alertdialog_button_day_bg_all_selector = 0x7f080208;
        public static final int alertdialog_button_day_bg_left_selector = 0x7f080209;
        public static final int alertdialog_button_day_bg_right_selector = 0x7f08020a;
        public static final int alertdialog_button_day_bg_selector = 0x7f08020b;
        public static final int arrow_indicator = 0x7f080212;
        public static final int back_black = 0x7f08021f;
        public static final int back_white = 0x7f080220;
        public static final int bd_wheel_val = 0x7f080257;
        public static final int bdcomment_detail_like = 0x7f080258;
        public static final int bdcomment_detail_like_pressed = 0x7f080259;
        public static final int bdcomment_detail_top_heart_praise_pressed = 0x7f08025a;
        public static final int bdcomment_detail_top_heart_praised = 0x7f08025b;
        public static final int bdcomment_detail_top_heart_unpraise_pressed = 0x7f08025c;
        public static final int bdcomment_detail_top_heart_unpraised = 0x7f08025d;
        public static final int bdcomment_detail_unlike = 0x7f08025e;
        public static final int bdcomment_detail_unlike_pressed = 0x7f08025f;
        public static final int big_pic_toast_btn_bg = 0x7f080367;
        public static final int big_pic_toast_close = 0x7f080368;
        public static final int big_pic_toast_close_clicked = 0x7f080369;
        public static final int big_pic_toast_close_selector = 0x7f08036a;
        public static final int big_pic_toast_left_img = 0x7f08036b;
        public static final int big_pic_toast_right_img = 0x7f08036c;
        public static final int bottom_button_close = 0x7f080386;
        public static final int bottom_menu_item_selector = 0x7f08038b;
        public static final int bubble_bg_d20_drawable = 0x7f08047f;
        public static final int bubble_bg_drawable = 0x7f080480;
        public static final int card_remind_radio_checked = 0x7f0804a9;
        public static final int card_remind_radio_unchecked = 0x7f0804aa;
        public static final int card_remind_radiobtn_selector = 0x7f0804ab;
        public static final int checkbox_checked = 0x7f0804c9;
        public static final int checkbox_checked_disable = 0x7f0804ca;
        public static final int checkbox_checked_disable_close = 0x7f0804cb;
        public static final int checkbox_checked_disable_open = 0x7f0804cc;
        public static final int checkbox_close = 0x7f0804cd;
        public static final int checkbox_disable = 0x7f0804ce;
        public static final int checkbox_normal = 0x7f0804d0;
        public static final int checkbox_normal_disable = 0x7f0804d1;
        public static final int checkbox_normaled = 0x7f0804d2;
        public static final int checkbox_open = 0x7f0804d3;
        public static final int checkbox_private = 0x7f0804d4;
        public static final int checkbox_select = 0x7f0804d5;
        public static final int clickable_circle_toast_view_bg = 0x7f0804dd;
        public static final int clickable_toast_icon = 0x7f0804de;
        public static final int clickable_toast_view_bg = 0x7f0804df;
        public static final int comment_item_heart_praised_selector = 0x7f0804e9;
        public static final int comment_item_heart_unpraised_selector = 0x7f0804ea;
        public static final int comment_item_like_icon_selector = 0x7f0804eb;
        public static final int comment_item_unlike_icon_selector = 0x7f0804ec;
        public static final int common_badge = 0x7f0804ef;
        public static final int common_badge_default_bg = 0x7f0804f0;
        public static final int common_empty_btn_bg = 0x7f0804f3;
        public static final int common_empty_btn_bg_pressed = 0x7f0804f4;
        public static final int common_empty_btn_bg_selector = 0x7f0804f5;
        public static final int common_empty_view_hyperlink_arrow = 0x7f0804f6;
        public static final int common_item_delete_selector = 0x7f0804f7;
        public static final int common_login_head_login = 0x7f0804f9;
        public static final int common_menu_item_day_mode_toast_icon = 0x7f0804fa;
        public static final int common_menu_item_night_mode_toast_icon = 0x7f0804fb;
        public static final int common_right_arrow = 0x7f0804fc;
        public static final int common_scrollbar_horizontal = 0x7f0804fd;
        public static final int common_scrollbar_vertical = 0x7f0804fe;
        public static final int context_menu_bg = 0x7f080529;
        public static final int context_menu_bottom_corner_selector = 0x7f08052a;
        public static final int context_menu_no_corner_selector = 0x7f08052b;
        public static final int context_menu_round_corner_selector = 0x7f08052c;
        public static final int context_menu_top_corner_selector = 0x7f08052d;
        public static final int custom_blue_btn_corner_bg = 0x7f08053f;
        public static final int custom_dialog_btn_corner_bg = 0x7f080540;
        public static final int custom_dialog_btn_corner_bg_selector = 0x7f080541;
        public static final int custom_dialog_btn_left_corner_bg = 0x7f080542;
        public static final int custom_dialog_btn_left_corner_bg_selector = 0x7f080543;
        public static final int custom_dialog_btn_middle_corner_bg = 0x7f080544;
        public static final int custom_dialog_btn_middle_corner_bg_selector = 0x7f080545;
        public static final int custom_dialog_btn_right_corner_bg = 0x7f080546;
        public static final int custom_dialog_btn_right_corner_bg_selector = 0x7f080547;
        public static final int custom_dialog_corner_bg = 0x7f080548;
        public static final int default_placeholder_image = 0x7f080555;
        public static final int dialog_bg_shadow = 0x7f080569;
        public static final int dialog_bg_white = 0x7f08056a;
        public static final int dialog_btn_bg_day_all = 0x7f08056d;
        public static final int dialog_btn_bg_day_left = 0x7f08056e;
        public static final int dialog_btn_bg_day_right = 0x7f08056f;
        public static final int dialog_btn_bg_night_all = 0x7f080570;
        public static final int dialog_btn_bg_pressed_day = 0x7f080573;
        public static final int ding_manager_item_single_bg = 0x7f080592;
        public static final int discovery_feedback_menu_bg = 0x7f080595;
        public static final int download_item_checkbox_selected = 0x7f0805a1;
        public static final int download_item_checkbox_unselected = 0x7f0805a2;
        public static final int download_title_select_selector = 0x7f0805a5;
        public static final int empty_icon_delete = 0x7f0805d0;
        public static final int empty_icon_document = 0x7f0805d1;
        public static final int empty_icon_error = 0x7f0805d2;
        public static final int empty_icon_network = 0x7f0805d3;
        public static final int empty_icon_network_error = 0x7f0805d4;
        public static final int empty_icon_video = 0x7f0805d5;
        public static final int emptyview_btn_bg = 0x7f0805d6;
        public static final int emptyview_btn_bg_default = 0x7f0805d7;
        public static final int emptyview_btn_bg_default_night = 0x7f0805d8;
        public static final int emptyview_btn_bg_night = 0x7f0805d9;
        public static final int emptyview_btn_bg_pressed = 0x7f0805da;
        public static final int emptyview_btn_bg_pressed_night = 0x7f0805db;
        public static final int emptyview_btn_blue_bg = 0x7f0805dc;
        public static final int enter_fullscreen = 0x7f0805eb;
        public static final int exit_fullscreen = 0x7f0805ef;
        public static final int exploded_comment_icon = 0x7f0805fb;
        public static final int favor_item_checkbox_selected = 0x7f08066e;
        public static final int favor_item_checkbox_unselected = 0x7f08066f;
        public static final int feed_loading = 0x7f080670;
        public static final int follow_item_selector = 0x7f080690;
        public static final int highlight_toast_image = 0x7f0806f1;
        public static final int highlight_toast_view_bg = 0x7f0806f3;
        public static final int home_tab_duoli_normal_mix_new_style = 0x7f0806f6;
        public static final int home_tab_duoli_normal_new_style = 0x7f0806f7;
        public static final int home_tab_duoli_pressed_mix_new_style = 0x7f0806f8;
        public static final int home_tab_duoli_pressed_new_style = 0x7f0806f9;
        public static final int home_tab_duoli_selected = 0x7f0806fa;
        public static final int home_tab_duoli_unselect = 0x7f0806fb;
        public static final int home_tab_haokan_video_normal_mix_new_style = 0x7f0806fc;
        public static final int home_tab_haokan_video_normal_new_style = 0x7f0806fd;
        public static final int home_tab_haokan_video_pressed_mix_new_style = 0x7f0806fe;
        public static final int home_tab_haokan_video_pressed_new_style = 0x7f0806ff;
        public static final int home_tab_home_page_normal_mix_new_style = 0x7f080700;
        public static final int home_tab_home_page_normal_new_style = 0x7f080701;
        public static final int home_tab_home_page_pressed_mix_new_style = 0x7f080702;
        public static final int home_tab_home_page_pressed_new_style = 0x7f080703;
        public static final int home_tab_home_selected = 0x7f080704;
        public static final int home_tab_home_unselect = 0x7f080705;
        public static final int home_tab_mini_game_page_normal_mix_new_style = 0x7f080706;
        public static final int home_tab_mini_game_page_normal_new_style = 0x7f080707;
        public static final int home_tab_mini_game_page_pressed_mix_new_style = 0x7f080708;
        public static final int home_tab_mini_game_page_pressed_new_style = 0x7f080709;
        public static final int home_tab_mini_video_page_normal_mix_new_style = 0x7f08070a;
        public static final int home_tab_mini_video_page_normal_new_style = 0x7f08070b;
        public static final int home_tab_mini_video_page_pressed_mix_new_style = 0x7f08070c;
        public static final int home_tab_mini_video_page_pressed_new_style = 0x7f08070d;
        public static final int home_tab_my_selected = 0x7f08070e;
        public static final int home_tab_my_unselect = 0x7f08070f;
        public static final int home_tab_personal_normal_mix_new_style = 0x7f080710;
        public static final int home_tab_personal_normal_new_style = 0x7f080711;
        public static final int home_tab_personal_pressed_mix_new_style = 0x7f080712;
        public static final int home_tab_personal_pressed_new_style = 0x7f080713;
        public static final int home_tab_service_normal_mix_new_style = 0x7f080714;
        public static final int home_tab_service_normal_new_style = 0x7f080715;
        public static final int home_tab_service_pressed_mix_new_style = 0x7f080716;
        public static final int home_tab_service_pressed_new_style = 0x7f080717;
        public static final int home_tab_service_selected = 0x7f080718;
        public static final int home_tab_service_unselect = 0x7f080719;
        public static final int home_tab_shop_normal_mix_new_style = 0x7f08071a;
        public static final int home_tab_shop_normal_new_style = 0x7f08071b;
        public static final int home_tab_shop_pressed_mix_new_style = 0x7f08071c;
        public static final int home_tab_shop_pressed_new_style = 0x7f08071d;
        public static final int home_tab_shop_selected = 0x7f08071e;
        public static final int home_tab_shop_unselect = 0x7f08071f;
        public static final int home_tab_video_normal = 0x7f080720;
        public static final int home_tab_video_pressed = 0x7f080721;
        public static final int home_tab_video_selected = 0x7f080722;
        public static final int home_tab_video_unselect = 0x7f080723;
        public static final int home_tab_xiaoxi_normal_mix_new_style = 0x7f080724;
        public static final int home_tab_xiaoxi_normal_new_style = 0x7f080725;
        public static final int home_tab_xiaoxi_pressed_mix_new_style = 0x7f080726;
        public static final int home_tab_xiaoxi_pressed_new_style = 0x7f080727;
        public static final int home_tab_xiaoxi_selected = 0x7f080728;
        public static final int home_tab_xiaoxi_unselect = 0x7f080729;
        public static final int ic_menu_add_bookmark = 0x7f080798;
        public static final int ic_menu_add_bookmark_pressed = 0x7f080799;
        public static final int ic_menu_add_bookmarkdir = 0x7f08079a;
        public static final int ic_menu_add_bookmarkdir_pressed = 0x7f08079b;
        public static final int icon = 0x7f0807c3;
        public static final int icon_actionbar_bookmark_search_normal = 0x7f0807c5;
        public static final int icon_actionbar_bookmark_search_press = 0x7f0807c6;
        public static final int icon_actionbar_common_search = 0x7f0807c7;
        public static final int icon_double_arrow_down = 0x7f080860;
        public static final int img_stub = 0x7f080db4;
        public static final int img_stub_tale = 0x7f080db5;
        public static final int introduction_half_screen_close = 0x7f080dbc;
        public static final int introduction_half_screen_close_press = 0x7f080dbd;
        public static final int introduction_half_screen_close_selector = 0x7f080dbe;
        public static final int introduction_logo = 0x7f080dbf;
        public static final int loading_progress = 0x7f080f17;
        public static final int loading_progress_animation = 0x7f080f18;
        public static final int menu_bookmark = 0x7f080f3f;
        public static final int menu_bookmark_night = 0x7f080f40;
        public static final int menu_copy_url = 0x7f080f41;
        public static final int menu_copy_url_night = 0x7f080f42;
        public static final int menu_delete = 0x7f080f43;
        public static final int menu_download = 0x7f080f44;
        public static final int menu_download_night = 0x7f080f45;
        public static final int menu_exit = 0x7f080f46;
        public static final int menu_exit_night = 0x7f080f47;
        public static final int menu_fullscreen = 0x7f080f48;
        public static final int menu_fullscreen_exit = 0x7f080f49;
        public static final int menu_fullscreen_night = 0x7f080f4a;
        public static final int menu_fullscreen_night_exit = 0x7f080f4b;
        public static final int menu_image_search = 0x7f080f4c;
        public static final int menu_login_portrait_background = 0x7f080f4f;
        public static final int menu_login_portrait_background_night = 0x7f080f50;
        public static final int menu_mode_night = 0x7f080f51;
        public static final int menu_mode_night_off = 0x7f080f52;
        public static final int menu_mode_night_uninstall = 0x7f080f53;
        public static final int menu_open_image = 0x7f080f54;
        public static final int menu_save_net = 0x7f080f57;
        public static final int menu_share = 0x7f080f58;
        public static final int multi_window_checked_day = 0x7f080f71;
        public static final int multi_window_normal_day = 0x7f080f72;
        public static final int new_dot = 0x7f081044;
        public static final int normal_toast_view_bg = 0x7f081060;
        public static final int novel_loading_bg = 0x7f081076;
        public static final int novel_loading_progress = 0x7f081077;
        public static final int null_drawable = 0x7f081078;
        public static final int pager_sub_tabbar_bg = 0x7f081084;
        public static final int personal_message_dialog = 0x7f08111c;
        public static final int picture_tab_indicator = 0x7f0811c0;
        public static final int pop_transparent_bg = 0x7f0811d0;
        public static final int progress_button_loading_icon = 0x7f0811dc;
        public static final int pull_refresh_loading = 0x7f0811e0;
        public static final int right_button_toast_view_bg = 0x7f081200;
        public static final int save_traffic_check = 0x7f0812be;
        public static final int scroll_bar_thumb_vertical = 0x7f0812c8;
        public static final int searchbox_clear_text = 0x7f0812d4;
        public static final int searchbox_clear_text_fast = 0x7f0812d5;
        public static final int searchbox_clear_text_fast_pressed = 0x7f0812d6;
        public static final int searchbox_clear_text_pressed = 0x7f0812d7;
        public static final int searchbox_loading = 0x7f0812da;
        public static final int selectbox = 0x7f0812de;
        public static final int skin_checkbox_checked = 0x7f081330;
        public static final int skin_checkbox_checked_disable = 0x7f081331;
        public static final int skin_checkbox_normal = 0x7f081332;
        public static final int skin_checkbox_normal_disable = 0x7f081333;
        public static final int skin_home_menu_bg = 0x7f081334;
        public static final int sliding_layout_shadow = 0x7f081335;
        public static final int sub_tab_bg = 0x7f081346;
        public static final int switchbutton = 0x7f08142c;
        public static final int tab_bar_bg = 0x7f08142d;
        public static final int tab_divider = 0x7f08142e;
        public static final int tab_sub_item_normal_background = 0x7f081430;
        public static final int tab_sub_item_selector = 0x7f081431;
        public static final int title_bg = 0x7f08144e;
        public static final int title_button_new_normal = 0x7f08144f;
        public static final int title_button_new_pressed = 0x7f081450;
        public static final int title_button_selector = 0x7f081451;
        public static final int to_tencent_wifi = 0x7f081455;
        public static final int to_tencent_wifi_night = 0x7f081456;
        public static final int toast_button_view_bg = 0x7f081458;
        public static final int transparent_drawable = 0x7f081490;
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

    /* loaded from: classes.dex */
    public static final class id {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FILL = 0x7f09000a;
        public static final int STROKE = 0x7f09001c;
        public static final int badge_view = 0x7f09032d;
        public static final int center = 0x7f09066d;
        public static final int content = 0x7f0907a2;
        public static final int cw_0 = 0x7f09082d;
        public static final int cw_180 = 0x7f09082e;
        public static final int cw_270 = 0x7f09082f;
        public static final int cw_90 = 0x7f090830;
        public static final int empty = 0x7f0909c4;
        public static final int error = 0x7f090a0f;
        public static final int feed_viewpager = 0x7f090ad3;
        public static final int gone = 0x7f090e25;
        public static final int immersion_fragment_root_view = 0x7f0910c8;
        public static final int invisible = 0x7f091135;
        public static final int left = 0x7f091471;
        public static final int lfet = 0x7f0914b1;
        public static final int linear = 0x7f0914d0;
        public static final int loading = 0x7f0915ce;
        public static final int msg_center_tab_title_id = 0x7f09174c;
        public static final int nbsearch_navi_bottom_line = 0x7f091847;
        public static final int nbsearch_navi_tab_view = 0x7f091848;
        public static final int nbsearch_web_loading_progress_bar = 0x7f091849;
        public static final int net_image_badge_container = 0x7f091855;
        public static final int radial = 0x7f091d39;
        public static final int refreshable_view = 0x7f091dc3;
        public static final int restart = 0x7f091e0a;
        public static final int reverse = 0x7f091e0f;
        public static final int right = 0x7f091e26;
        public static final int share_buddle_bg = 0x7f0920a7;
        public static final int share_buddle_content = 0x7f0920a8;
        public static final int toast_over_float_window_view = 0x7f0924d4;
        public static final int visible = 0x7f09289a;
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

    /* loaded from: classes.dex */
    public static final class integer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int common_slide_anim_duration = 0x7f0a0009;
        public static final int common_slide_anim_duration_back = 0x7f0a000a;
        public static final int common_slide_anim_duration_in = 0x7f0a000b;
        public static final int lightapp_slide_anim_duration = 0x7f0a0012;
        public static final int slide_anim_duration = 0x7f0a0029;
        public static final int t9_keyboard_show_duration = 0x7f0a002c;
        public transient /* synthetic */ FieldHolder $fh;

        public integer() {
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

    /* loaded from: classes.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int about_head_about = 0x7f0f0055;
        public static final int big_pic_toast_btn_text = 0x7f0f0349;
        public static final int big_pic_toast_title = 0x7f0f034a;
        public static final int browser_menu_save_image = 0x7f0f0382;
        public static final int browser_menu_save_image_net = 0x7f0f0383;
        public static final int browser_menu_share = 0x7f0f0384;
        public static final int browser_menu_toast_day_mode = 0x7f0f0385;
        public static final int browser_menu_toast_night_mode = 0x7f0f0386;
        public static final int btn_ding_manager_title_bar_refresh = 0x7f0f0390;
        public static final int button_toast_btn_text = 0x7f0f03a5;
        public static final int button_toast_info_text = 0x7f0f03a6;
        public static final int cancel = 0x7f0f03c3;
        public static final int clickable_toast_check_text = 0x7f0f0462;
        public static final int close = 0x7f0f0464;
        public static final int common_big_font_set = 0x7f0f0486;
        public static final int common_big_font_tips = 0x7f0f0487;
        public static final int common_comment_like = 0x7f0f0488;
        public static final int common_comment_ten_thousand = 0x7f0f0489;
        public static final int common_emptyview_detail_text = 0x7f0f048a;
        public static final int common_font_set = 0x7f0f048c;
        public static final int common_font_tips = 0x7f0f048d;
        public static final int contextmenu_download_image = 0x7f0f04c8;
        public static final int contextmenu_openlink = 0x7f0f04c9;
        public static final int contextmenu_search_img = 0x7f0f04ca;
        public static final int del_file = 0x7f0f052b;
        public static final int del_file_info = 0x7f0f052c;
        public static final int delete = 0x7f0f0535;
        public static final int delete_all = 0x7f0f0538;
        public static final int delete_number = 0x7f0f0541;
        public static final int deleting = 0x7f0f0553;
        public static final int dialog_delete_tips = 0x7f0f057f;
        public static final int dialog_nagtive_button_text = 0x7f0f0581;
        public static final int dialog_negative_title_cancel = 0x7f0f0582;
        public static final int dialog_positive_button_text = 0x7f0f0585;
        public static final int dialog_positive_title_ok = 0x7f0f0586;
        public static final int dir_name_empty = 0x7f0f058c;
        public static final int download_confirm = 0x7f0f059d;
        public static final int download_done = 0x7f0f059e;
        public static final int download_err_cannotresume = 0x7f0f059f;
        public static final int download_has_pause = 0x7f0f05af;
        public static final int download_no_sdcard_dlg_title = 0x7f0f05b3;
        public static final int download_pause = 0x7f0f05b4;
        public static final int download_resume = 0x7f0f05b6;
        public static final int download_retry = 0x7f0f05b7;
        public static final int download_sdcard_busy_dlg_title = 0x7f0f05b8;
        public static final int download_select_all = 0x7f0f05b9;
        public static final int download_top_bar_edit = 0x7f0f05bc;
        public static final int downloaded_video_notify_complete_msg = 0x7f0f05c1;
        public static final int downloading = 0x7f0f05c2;
        public static final int emptyview_redirect_hint_novel = 0x7f0f061c;
        public static final int emptyview_redirect_hyperlink_novel = 0x7f0f061d;
        public static final int favors_move = 0x7f0f06d0;
        public static final int feed_cancel_save = 0x7f0f06d2;
        public static final int feed_cancel_save_fail = 0x7f0f06d3;
        public static final int feed_close_tab = 0x7f0f06d4;
        public static final int feed_save_fail = 0x7f0f06d5;
        public static final int feed_save_success = 0x7f0f06d6;
        public static final int hint_label = 0x7f0f0977;
        public static final int history_private_setting = 0x7f0f097e;
        public static final int local_search_setting = 0x7f0f0ba6;
        public static final int magicbox_on_empty_reload = 0x7f0f0bd8;
        public static final int magicbox_on_empty_wait = 0x7f0f0bd9;
        public static final int move = 0x7f0f0c4e;
        public static final int move_failed = 0x7f0f0c4f;
        public static final int move_success = 0x7f0f0c50;
        public static final int moving = 0x7f0f0c52;
        public static final int network_error_link_text = 0x7f0f0db7;
        public static final int no = 0x7f0f0dd0;
        public static final int notification_download_failed = 0x7f0f0e2b;
        public static final int notification_setting_switch = 0x7f0f0e2f;
        public static final int ok = 0x7f0f0e64;
        public static final int open_histroy_private_mode = 0x7f0f0e79;
        public static final int picture_load_image_failed = 0x7f0f103a;
        public static final int plugin_update = 0x7f0f106c;
        public static final int plugin_update_hint_doc = 0x7f0f106d;
        public static final int privacy_policy = 0x7f0f10ba;
        public static final int progress_deleting = 0x7f0f10d1;
        public static final int quicksearch_setting = 0x7f0f112c;
        public static final int radio_accessibility_close = 0x7f0f1131;
        public static final int radio_accessibility_next = 0x7f0f1132;
        public static final int radio_accessibility_pause = 0x7f0f1133;
        public static final int radio_accessibility_play = 0x7f0f1134;
        public static final int radio_accessibility_settings = 0x7f0f1135;
        public static final int save = 0x7f0f1241;
        public static final int save_traffic_mode_settings_menu_title = 0x7f0f124f;
        public static final int search_the_web = 0x7f0f1286;
        public static final int share = 0x7f0f12ed;
        public static final int share_no_primiss_go_system = 0x7f0f1305;
        public static final int share_no_primiss_go_system_des = 0x7f0f1306;
        public static final int share_no_primiss_go_system_text = 0x7f0f1307;
        public static final int skin_menu_auto_skin_switch = 0x7f0f136c;
        public static final int skin_settings_summary = 0x7f0f136d;
        public static final int story_offline = 0x7f0f13db;
        public static final int tip_bad_url = 0x7f0f15e5;
        public static final int tip_dir = 0x7f0f15eb;
        public static final int tip_label = 0x7f0f15f3;
        public static final int tips_new = 0x7f0f1600;
        public static final int traffic_short_title_bigimage = 0x7f0f1635;
        public static final int traffic_short_title_bigimage_toast_title = 0x7f0f1636;
        public static final int traffic_short_title_noimage = 0x7f0f1637;
        public static final int traffic_short_title_noimage_toast_title = 0x7f0f1638;
        public static final int traffic_short_title_noimage_toast_wifi_title = 0x7f0f1639;
        public static final int traffic_short_title_smallimage = 0x7f0f163a;
        public static final int traffic_short_title_smallimage_toast_title = 0x7f0f163b;
        public static final int traffic_short_title_smallimage_toast_wifi_title = 0x7f0f163c;
        public static final int traffic_sub_title_bigimage = 0x7f0f163d;
        public static final int traffic_sub_title_noimage = 0x7f0f163e;
        public static final int traffic_sub_title_smallimage = 0x7f0f163f;
        public static final int traffic_title_bigimage = 0x7f0f1640;
        public static final int traffic_title_noimage = 0x7f0f1641;
        public static final int traffic_title_smallimage = 0x7f0f1642;
        public static final int type_music = 0x7f0f16c9;
        public static final int update_sign_match_failed_hint = 0x7f0f16ff;
        public static final int user_experience_join = 0x7f0f1716;
        public static final int video_dialog_2g3g_message = 0x7f0f1747;
        public static final int video_dialog_2g3g_title = 0x7f0f1748;
        public static final int video_error = 0x7f0f1749;
        public static final int video_favorite_adding_tip = 0x7f0f174b;
        public static final int video_favorite_no_network_tip = 0x7f0f174c;
        public static final int video_favorite_removing_tip = 0x7f0f174d;
        public static final int video_local_start_scan_text = 0x7f0f1755;
        public static final int video_play = 0x7f0f1767;
        public static final int web_setting2 = 0x7f0f17d8;
        public static final int yes = 0x7f0f184f;
        public static final int zeus_install_error_msg = 0x7f0f188f;
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

    /* loaded from: classes.dex */
    public static final class style {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int Base_CardView = 0x7f100016;
        public static final int BdWaitingDialog = 0x7f1000f8;
        public static final int CardView = 0x7f1000fe;
        public static final int CardView_Dark = 0x7f1000ff;
        public static final int CardView_Light = 0x7f100100;
        public static final int Dialog_No_Border = 0x7f10010c;
        public static final int EbpayActivityAnim = 0x7f100112;
        public static final int LightSearchTheme = 0x7f100128;
        public static final int LightSearchThemeHighLevel = 0x7f100129;
        public static final int NoTitle = 0x7f100149;
        public static final int NoTitleDialog = 0x7f10014c;
        public static final int NoTitleNoAnimation = 0x7f10014d;
        public static final int NoTitleWithUpDownAnimation = 0x7f10014e;
        public static final int NoTitle_Background = 0x7f10014a;
        public static final int PopupWindow_DropDownDown = 0x7f100178;
        public static final int PopupWindow_DropDownUp = 0x7f100179;
        public static final int UpDownAnimation = 0x7f1002ce;
        public static final int about_style = 0x7f1003ae;
        public static final int big_pic_animation = 0x7f1003b6;
        public static final int brower_menu = 0x7f1003b8;
        public static final int highlight_toast_animation = 0x7f1003ce;
        public static final int menu_animation = 0x7f1003db;
        public static final int new_tip_text = 0x7f1003ea;
        public static final int notice_popupwindow_anim = 0x7f1003ec;
        public static final int pop_window_anim = 0x7f1003f6;
        public static final int title_bar_title = 0x7f100434;
        public static final int toast_animation = 0x7f100439;
        public static final int user_perience_content = 0x7f100443;
        public transient /* synthetic */ FieldHolder $fh;

        public style() {
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

    /* loaded from: classes.dex */
    public static final class styleable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] AbsSpinner;
        public static final int AbsSpinner_entriesArray = 0x00000000;
        public static final int[] BdActionBar;
        public static final int BdActionBar_rightImgZone1ImageSrc = 0x00000000;
        public static final int BdActionBar_rightImgZone1Visibility = 0x00000001;
        public static final int BdActionBar_rightImgZone2ImageSrc = 0x00000002;
        public static final int BdActionBar_rightImgZone2Visibility = 0x00000003;
        public static final int BdActionBar_rightTxtZone1Text = 0x00000004;
        public static final int BdActionBar_rightTxtZone1TxtColor = 0x00000005;
        public static final int BdActionBar_rightTxtZone1TxtShadowColor = 0x00000006;
        public static final int BdActionBar_rightTxtZone1TxtShadowDx = 0x00000007;
        public static final int BdActionBar_rightTxtZone1TxtShadowDy = 0x00000008;
        public static final int BdActionBar_rightTxtZone1TxtShadowRadius = 0x00000009;
        public static final int BdActionBar_rightTxtZone1TxtSize = 0x0000000a;
        public static final int BdActionBar_rightTxtZone1Visibility = 0x0000000b;
        public static final int BdActionBar_rightZonesVisibility = 0x0000000c;
        public static final int BdActionBar_titleAlignment = 0x0000000d;
        public static final int BdActionBar_titleColor = 0x0000000e;
        public static final int BdActionBar_titleText = 0x0000000f;
        public static final int BdActionBar_titleTxtShadowColor = 0x00000010;
        public static final int BdActionBar_titleTxtShadowDx = 0x00000011;
        public static final int BdActionBar_titleTxtShadowDy = 0x00000012;
        public static final int BdActionBar_titleTxtShadowRadius = 0x00000013;
        public static final int[] BdMultiStateView;
        public static final int BdMultiStateView_msv_emptyView = 0x00000000;
        public static final int BdMultiStateView_msv_errorView = 0x00000001;
        public static final int BdMultiStateView_msv_loadingView = 0x00000002;
        public static final int BdMultiStateView_msv_viewState = 0x00000003;
        public static final int[] ClickableTextView;
        public static final int ClickableTextView_down_alpha = 0x00000000;
        public static final int[] DrawablePageIndicator;
        public static final int DrawablePageIndicator_android_background = 0x00000000;
        public static final int DrawablePageIndicator_android_src = 0x00000001;
        public static final int DrawablePageIndicator_shadow_left = 0x00000002;
        public static final int DrawablePageIndicator_shadow_right = 0x00000003;
        public static final int DrawablePageIndicator_vpi_height = 0x00000004;
        public static final int[] EditTextWrapper;
        public static final int EditTextWrapper_label = 0x00000000;
        public static final int[] Gallery;
        public static final int Gallery_animationDuration = 0x00000000;
        public static final int Gallery_gravity = 0x00000001;
        public static final int Gallery_spacing = 0x00000002;
        public static final int Gallery_swan_gravity = 0x00000003;
        public static final int Gallery_unselectedAlpha = 0x00000004;
        public static final int[] IconFontImageView;
        public static final int IconFontImageView_fontPath = 0x00000000;
        public static final int IconFontImageView_iconFont = 0x00000001;
        public static final int IconFontImageView_iconFontColor = 0x00000002;
        public static final int IconFontImageView_pressedIconFont = 0x00000003;
        public static final int IconFontImageView_pressedIconFontColor = 0x00000004;
        public static final int[] NovelLineEditView;
        public static final int NovelLineEditView_leftZoneColor = 0x00000000;
        public static final int NovelLineEditView_leftZoneWidth = 0x00000001;
        public static final int NovelLineEditView_lineColor = 0x00000002;
        public static final int NovelLineEditView_lineSpace = 0x00000003;
        public static final int[] PartingLineView;
        public static final int PartingLineView_bgBorderColor = 0x00000000;
        public static final int PartingLineView_bgBorderWidth = 0x00000001;
        public static final int PartingLineView_bgNormalColor = 0x00000002;
        public static final int PartingLineView_bgPressedColor = 0x00000003;
        public static final int PartingLineView_dividerArcRadius = 0x00000004;
        public static final int PartingLineView_dividerLineColor = 0x00000005;
        public static final int PartingLineView_dividerLineHeight = 0x00000006;
        public static final int[] PopupWindow;
        public static final int PopupWindow_android_popupAnimationStyle = 0x00000001;
        public static final int PopupWindow_android_popupBackground = 0x00000000;
        public static final int PopupWindow_overlapAnchor = 0x00000002;
        public static final int PopupWindow_popupAnimationStyle = 0x00000003;
        public static final int PopupWindow_popupBackground = 0x00000004;
        public static final int[] RelativeCardView;
        public static final int RelativeCardView_android_minHeight = 0x00000001;
        public static final int RelativeCardView_android_minWidth = 0x00000000;
        public static final int RelativeCardView_cardBackgroundColor = 0x00000002;
        public static final int RelativeCardView_cardCornerRadius = 0x00000003;
        public static final int RelativeCardView_cardElevation = 0x00000004;
        public static final int RelativeCardView_cardMaxElevation = 0x00000005;
        public static final int RelativeCardView_cardPreventCornerOverlap = 0x00000006;
        public static final int RelativeCardView_cardUseCompatPadding = 0x00000007;
        public static final int RelativeCardView_contentPadding = 0x00000008;
        public static final int RelativeCardView_contentPaddingBottom = 0x00000009;
        public static final int RelativeCardView_contentPaddingLeft = 0x0000000a;
        public static final int RelativeCardView_contentPaddingRight = 0x0000000b;
        public static final int RelativeCardView_contentPaddingTop = 0x0000000c;
        public static final int[] RoundProgressBar;
        public static final int RoundProgressBar_max = 0x00000000;
        public static final int RoundProgressBar_reverse = 0x00000001;
        public static final int RoundProgressBar_roundColor = 0x00000002;
        public static final int RoundProgressBar_roundMax = 0x00000003;
        public static final int RoundProgressBar_roundPaintCapRound = 0x00000004;
        public static final int RoundProgressBar_roundProgressColor = 0x00000005;
        public static final int RoundProgressBar_roundProgressEndColor = 0x00000006;
        public static final int RoundProgressBar_roundProgressStartColor = 0x00000007;
        public static final int RoundProgressBar_roundStyle = 0x00000008;
        public static final int RoundProgressBar_roundTextColor = 0x00000009;
        public static final int RoundProgressBar_roundTextIsDisplayable = 0x0000000a;
        public static final int RoundProgressBar_roundTextSize = 0x0000000b;
        public static final int RoundProgressBar_roundWidth = 0x0000000c;
        public static final int RoundProgressBar_style = 0x0000000d;
        public static final int RoundProgressBar_textColor = 0x0000000e;
        public static final int RoundProgressBar_textIsDisplayable = 0x0000000f;
        public static final int RoundProgressBar_textSize = 0x00000010;
        public static final int[] RoundedImageView;
        public static final int RoundedImageView_android_scaleType = 0x00000000;
        public static final int RoundedImageView_border_color = 0x00000001;
        public static final int RoundedImageView_border_width = 0x00000002;
        public static final int RoundedImageView_corner_radius = 0x00000003;
        public static final int RoundedImageView_round_background = 0x00000004;
        public static final int[] SelectorImageButton;
        public static final int SelectorImageButton_disabledAlphaScale = 0x00000000;
        public static final int SelectorImageButton_pressedAlphaScale = 0x00000001;
        public static final int[] ShimmerFrameLayout;
        public static final int ShimmerFrameLayout_angle = 0x00000000;
        public static final int ShimmerFrameLayout_auto_start = 0x00000001;
        public static final int ShimmerFrameLayout_base_alpha = 0x00000002;
        public static final int ShimmerFrameLayout_dropoff = 0x00000003;
        public static final int ShimmerFrameLayout_duration = 0x00000004;
        public static final int ShimmerFrameLayout_fixed_height = 0x00000005;
        public static final int ShimmerFrameLayout_fixed_width = 0x00000006;
        public static final int ShimmerFrameLayout_intensity = 0x00000007;
        public static final int ShimmerFrameLayout_relative_height = 0x00000008;
        public static final int ShimmerFrameLayout_relative_width = 0x00000009;
        public static final int ShimmerFrameLayout_repeat_count = 0x0000000a;
        public static final int ShimmerFrameLayout_repeat_delay = 0x0000000b;
        public static final int ShimmerFrameLayout_repeat_mode = 0x0000000c;
        public static final int ShimmerFrameLayout_shape = 0x0000000d;
        public static final int ShimmerFrameLayout_shimmer_shape = 0x0000000e;
        public static final int ShimmerFrameLayout_tilt = 0x0000000f;
        public static final int[] StickyListHeadersListView;
        public static final int StickyListHeadersListView_android_cacheColorHint = 0x0000000e;
        public static final int StickyListHeadersListView_android_choiceMode = 0x00000011;
        public static final int StickyListHeadersListView_android_clipToPadding = 0x00000008;
        public static final int StickyListHeadersListView_android_divider = 0x0000000f;
        public static final int StickyListHeadersListView_android_dividerHeight = 0x00000010;
        public static final int StickyListHeadersListView_android_drawSelectorOnTop = 0x0000000a;
        public static final int StickyListHeadersListView_android_fadingEdgeLength = 0x00000007;
        public static final int StickyListHeadersListView_android_fastScrollAlwaysVisible = 0x00000014;
        public static final int StickyListHeadersListView_android_fastScrollEnabled = 0x00000012;
        public static final int StickyListHeadersListView_android_listSelector = 0x00000009;
        public static final int StickyListHeadersListView_android_overScrollMode = 0x00000013;
        public static final int StickyListHeadersListView_android_padding = 0x00000001;
        public static final int StickyListHeadersListView_android_paddingBottom = 0x00000005;
        public static final int StickyListHeadersListView_android_paddingLeft = 0x00000002;
        public static final int StickyListHeadersListView_android_paddingRight = 0x00000004;
        public static final int StickyListHeadersListView_android_paddingTop = 0x00000003;
        public static final int StickyListHeadersListView_android_requiresFadingEdge = 0x00000015;
        public static final int StickyListHeadersListView_android_scrollbarStyle = 0x00000000;
        public static final int StickyListHeadersListView_android_scrollbars = 0x00000006;
        public static final int StickyListHeadersListView_android_scrollingCache = 0x0000000c;
        public static final int StickyListHeadersListView_android_stackFromBottom = 0x0000000b;
        public static final int StickyListHeadersListView_android_transcriptMode = 0x0000000d;
        public static final int StickyListHeadersListView_hasStickyHeaders = 0x00000016;
        public static final int StickyListHeadersListView_isDrawingListUnderStickyHeader = 0x00000017;
        public static final int StickyListHeadersListView_stickyListHeadersListViewStyle = 0x00000018;
        public static final int[] TabLayout;
        public static final int TabLayout_indicatorHeight = 0x00000000;
        public static final int TabLayout_tabBackground = 0x00000001;
        public static final int TabLayout_tabContentStart = 0x00000002;
        public static final int TabLayout_tabDistance = 0x00000003;
        public static final int TabLayout_tabGravity = 0x00000004;
        public static final int TabLayout_tabIconTint = 0x00000005;
        public static final int TabLayout_tabIconTintMode = 0x00000006;
        public static final int TabLayout_tabIndicator = 0x00000007;
        public static final int TabLayout_tabIndicatorAnimationDuration = 0x00000008;
        public static final int TabLayout_tabIndicatorColor = 0x00000009;
        public static final int TabLayout_tabIndicatorFullWidth = 0x0000000a;
        public static final int TabLayout_tabIndicatorGravity = 0x0000000b;
        public static final int TabLayout_tabIndicatorHeight = 0x0000000c;
        public static final int TabLayout_tabInlineLabel = 0x0000000d;
        public static final int TabLayout_tabLayout_indicatorColor = 0x0000000e;
        public static final int TabLayout_tabMaxWidth = 0x0000000f;
        public static final int TabLayout_tabMinWidth = 0x00000010;
        public static final int TabLayout_tabMode = 0x00000011;
        public static final int TabLayout_tabPadding = 0x00000012;
        public static final int TabLayout_tabPaddingBottom = 0x00000013;
        public static final int TabLayout_tabPaddingEnd = 0x00000014;
        public static final int TabLayout_tabPaddingStart = 0x00000015;
        public static final int TabLayout_tabPaddingTop = 0x00000016;
        public static final int TabLayout_tabRippleColor = 0x00000017;
        public static final int TabLayout_tabSelectedTextColor = 0x00000018;
        public static final int TabLayout_tabTextAppearance = 0x00000019;
        public static final int TabLayout_tabTextColor = 0x0000001a;
        public static final int TabLayout_tabTextColors = 0x0000001b;
        public static final int TabLayout_tabTextSize = 0x0000001c;
        public static final int TabLayout_tabUnboundedRipple = 0x0000001d;
        public static final int[] ViewPagerIndicator;
        public static final int ViewPagerIndicator_vpiDrawablePageIndicatorStyle = 0x00000000;
        public static final int[] avatarView;
        public static final int avatarView_avatarDiameter = 0x00000000;
        public static final int avatarView_circleEndColor = 0x00000001;
        public static final int avatarView_circleStartColor = 0x00000002;
        public static final int avatarView_circleStrokeWidth = 0x00000003;
        public static final int avatarView_useNightMode = 0x00000004;
        public static final int[] pickerview;
        public static final int pickerview_wheelview_dividerColor = 0x00000000;
        public static final int pickerview_wheelview_gravity = 0x00000001;
        public static final int pickerview_wheelview_lineSpacingMultiplier = 0x00000002;
        public static final int pickerview_wheelview_textColorCenter = 0x00000003;
        public static final int pickerview_wheelview_textColorOut = 0x00000004;
        public static final int pickerview_wheelview_textSize = 0x00000005;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-237109211, "Lcom/baidu/android/common/ui/style/R$styleable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-237109211, "Lcom/baidu/android/common/ui/style/R$styleable;");
                    return;
                }
            }
            AbsSpinner = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0402a4};
            BdActionBar = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040607, com.baidu.tieba.R.attr.obfuscated_res_0x7f040608, com.baidu.tieba.R.attr.obfuscated_res_0x7f040609, com.baidu.tieba.R.attr.obfuscated_res_0x7f04060a, com.baidu.tieba.R.attr.obfuscated_res_0x7f040610, com.baidu.tieba.R.attr.obfuscated_res_0x7f040611, com.baidu.tieba.R.attr.obfuscated_res_0x7f040612, com.baidu.tieba.R.attr.obfuscated_res_0x7f040613, com.baidu.tieba.R.attr.obfuscated_res_0x7f040614, com.baidu.tieba.R.attr.obfuscated_res_0x7f040615, com.baidu.tieba.R.attr.obfuscated_res_0x7f040616, com.baidu.tieba.R.attr.obfuscated_res_0x7f040617, com.baidu.tieba.R.attr.obfuscated_res_0x7f04061a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04077d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04077e, com.baidu.tieba.R.attr.obfuscated_res_0x7f040787, com.baidu.tieba.R.attr.obfuscated_res_0x7f04078b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04078c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04078d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04078e};
            BdMultiStateView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04050c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04050d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04050e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04050f};
            ClickableTextView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040266};
            DrawablePageIndicator = new int[]{16842964, 16843033, com.baidu.tieba.R.attr.obfuscated_res_0x7f04066a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04066b, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407e9};
            EditTextWrapper = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04041b};
            Gallery = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040093, com.baidu.tieba.R.attr.obfuscated_res_0x7f04030b, com.baidu.tieba.R.attr.obfuscated_res_0x7f040697, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406ce, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407ca};
            IconFontImageView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0402f7, com.baidu.tieba.R.attr.obfuscated_res_0x7f040353, com.baidu.tieba.R.attr.obfuscated_res_0x7f040354, com.baidu.tieba.R.attr.obfuscated_res_0x7f04059f, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405a0};
            NovelLineEditView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040452, com.baidu.tieba.R.attr.obfuscated_res_0x7f040453, com.baidu.tieba.R.attr.obfuscated_res_0x7f04045a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04045d};
            PartingLineView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0400df, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400e0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400e1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400e2, com.baidu.tieba.R.attr.obfuscated_res_0x7f04025f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040262, com.baidu.tieba.R.attr.obfuscated_res_0x7f040263};
            PopupWindow = new int[]{16843126, 16843465, com.baidu.tieba.R.attr.obfuscated_res_0x7f040543, com.baidu.tieba.R.attr.obfuscated_res_0x7f040594, com.baidu.tieba.R.attr.obfuscated_res_0x7f040595};
            RelativeCardView = new int[]{16843071, 16843072, com.baidu.tieba.R.attr.obfuscated_res_0x7f04011f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040120, com.baidu.tieba.R.attr.obfuscated_res_0x7f040121, com.baidu.tieba.R.attr.obfuscated_res_0x7f040123, com.baidu.tieba.R.attr.obfuscated_res_0x7f040124, com.baidu.tieba.R.attr.obfuscated_res_0x7f040125, com.baidu.tieba.R.attr.obfuscated_res_0x7f040183, com.baidu.tieba.R.attr.obfuscated_res_0x7f040184, com.baidu.tieba.R.attr.obfuscated_res_0x7f040185, com.baidu.tieba.R.attr.obfuscated_res_0x7f040186, com.baidu.tieba.R.attr.obfuscated_res_0x7f040187};
            RoundProgressBar = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0404e3, com.baidu.tieba.R.attr.obfuscated_res_0x7f040602, com.baidu.tieba.R.attr.obfuscated_res_0x7f040620, com.baidu.tieba.R.attr.obfuscated_res_0x7f040623, com.baidu.tieba.R.attr.obfuscated_res_0x7f040624, com.baidu.tieba.R.attr.obfuscated_res_0x7f040626, com.baidu.tieba.R.attr.obfuscated_res_0x7f040627, com.baidu.tieba.R.attr.obfuscated_res_0x7f040628, com.baidu.tieba.R.attr.obfuscated_res_0x7f040629, com.baidu.tieba.R.attr.roundTextColor, com.baidu.tieba.R.attr.obfuscated_res_0x7f04062b, com.baidu.tieba.R.attr.roundTextSize, com.baidu.tieba.R.attr.obfuscated_res_0x7f04062d, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406bc, com.baidu.tieba.R.attr.obfuscated_res_0x7f04074c, com.baidu.tieba.R.attr.obfuscated_res_0x7f040756, com.baidu.tieba.R.attr.obfuscated_res_0x7f040759};
            RoundedImageView = new int[]{16843037, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400ef, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400f0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401b8, com.baidu.tieba.R.attr.obfuscated_res_0x7f04062e};
            SelectorImageButton = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04025c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04059e};
            ShimmerFrameLayout = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04008e, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400af, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400cd, com.baidu.tieba.R.attr.obfuscated_res_0x7f04028c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04028e, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402da, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402db, com.baidu.tieba.R.attr.obfuscated_res_0x7f040376, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405f8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405f9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405fc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405fd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405fe, com.baidu.tieba.R.attr.obfuscated_res_0x7f04066d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040674, com.baidu.tieba.R.attr.obfuscated_res_0x7f040779};
            StickyListHeadersListView = new int[]{16842879, 16842965, 16842966, 16842967, 16842968, 16842969, 16842974, 16842976, 16842987, 16843003, 16843004, 16843005, 16843006, 16843008, 16843009, 16843049, 16843050, 16843051, 16843302, 16843457, 16843573, 16843685, com.baidu.tieba.R.attr.obfuscated_res_0x7f04031a, com.baidu.tieba.R.attr.obfuscated_res_0x7f040378, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406b9};
            TabLayout = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040371, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406d5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406d6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406d7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406d8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406d9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406da, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406db, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406dc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406dd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406de, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406df, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406ea, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406eb, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406ec, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406ed, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406ef, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f3};
            ViewPagerIndicator = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0407e8};
            avatarView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0400b0, com.baidu.tieba.R.attr.obfuscated_res_0x7f040157, com.baidu.tieba.R.attr.obfuscated_res_0x7f040159, com.baidu.tieba.R.attr.obfuscated_res_0x7f04015a, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407cd};
            pickerview = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0407f0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407f1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407f2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407f3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407f4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407f5};
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
