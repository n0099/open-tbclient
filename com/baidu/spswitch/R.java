package com.baidu.spswitch;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class anim {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int abc_fade_in = 0x7f010000;
        public static final int abc_fade_out = 0x7f010001;
        public static final int abc_grow_fade_in_from_bottom = 0x7f010002;
        public static final int abc_popup_enter = 0x7f010003;
        public static final int abc_popup_exit = 0x7f010004;
        public static final int abc_shrink_fade_out_from_bottom = 0x7f010005;
        public static final int abc_slide_in_bottom = 0x7f010006;
        public static final int abc_slide_in_top = 0x7f010007;
        public static final int abc_slide_out_bottom = 0x7f010008;
        public static final int abc_slide_out_top = 0x7f010009;
        public static final int abc_tooltip_enter = 0x7f01000a;
        public static final int abc_tooltip_exit = 0x7f01000b;
        public static final int btn_checkbox_to_checked_box_inner_merged_animation = 0x7f010049;
        public static final int btn_checkbox_to_checked_box_outer_merged_animation = 0x7f01004a;
        public static final int btn_checkbox_to_checked_icon_null_animation = 0x7f01004b;
        public static final int btn_checkbox_to_unchecked_box_inner_merged_animation = 0x7f01004c;
        public static final int btn_checkbox_to_unchecked_check_path_merged_animation = 0x7f01004d;
        public static final int btn_checkbox_to_unchecked_icon_null_animation = 0x7f01004e;
        public static final int btn_radio_to_off_mtrl_dot_group_animation = 0x7f01004f;
        public static final int btn_radio_to_off_mtrl_ring_outer_animation = 0x7f010050;
        public static final int btn_radio_to_off_mtrl_ring_outer_path_animation = 0x7f010051;
        public static final int btn_radio_to_on_mtrl_dot_group_animation = 0x7f010052;
        public static final int btn_radio_to_on_mtrl_ring_outer_animation = 0x7f010053;
        public static final int btn_radio_to_on_mtrl_ring_outer_path_animation = 0x7f010054;
        public static final int emotion_long_pressed_entry = 0x7f010071;
        public static final int emotion_long_pressed_exit = 0x7f010072;
        public static final int fade_out = 0x7f010064;
        public static final int hold = 0x7f010094;
        public static final int novel_loading_progress = 0x7f0100c5;
        public static final int slide_down = 0x7f010135;
        public static final int slide_up = 0x7f01013b;
        public static final int wallet_base_slide_from_left = 0x7f01013f;
        public static final int wallet_base_slide_from_right = 0x7f01015e;
        public static final int wallet_base_slide_to_left = 0x7f01015f;
        public static final int wallet_base_slide_to_right = 0x7f010160;
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

    /* loaded from: classes3.dex */
    public static final class attr {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int actionBarDivider = 0x7f04004a;
        public static final int actionBarItemBackground = 0x7f04004b;
        public static final int actionBarPopupTheme = 0x7f04004c;
        public static final int actionBarSize = 0x7f04004d;
        public static final int actionBarSplitStyle = 0x7f04004e;
        public static final int actionBarStyle = 0x7f04004f;
        public static final int actionBarTabBarStyle = 0x7f040050;
        public static final int actionBarTabStyle = 0x7f040051;
        public static final int actionBarTabTextStyle = 0x7f040052;
        public static final int actionBarTheme = 0x7f040053;
        public static final int actionBarWidgetTheme = 0x7f040054;
        public static final int actionButtonStyle = 0x7f040055;
        public static final int actionDropDownStyle = 0x7f040056;
        public static final int actionLayout = 0x7f040057;
        public static final int actionMenuTextAppearance = 0x7f040058;
        public static final int actionMenuTextColor = 0x7f040059;
        public static final int actionModeBackground = 0x7f04005b;
        public static final int actionModeCloseButtonStyle = 0x7f04005d;
        public static final int actionModeCloseDrawable = 0x7f04005e;
        public static final int actionModeCopyDrawable = 0x7f04005f;
        public static final int actionModeCutDrawable = 0x7f040060;
        public static final int actionModeFindDrawable = 0x7f040061;
        public static final int actionModePasteDrawable = 0x7f040062;
        public static final int actionModePopupWindowStyle = 0x7f040063;
        public static final int actionModeSelectAllDrawable = 0x7f040064;
        public static final int actionModeShareDrawable = 0x7f040065;
        public static final int actionModeSplitBackground = 0x7f040066;
        public static final int actionModeStyle = 0x7f040067;
        public static final int actionModeWebSearchDrawable = 0x7f040068;
        public static final int actionOverflowButtonStyle = 0x7f040069;
        public static final int actionOverflowMenuStyle = 0x7f04006a;
        public static final int actionProviderClass = 0x7f04006b;
        public static final int actionViewClass = 0x7f04006f;
        public static final int activityChooserViewStyle = 0x7f040070;
        public static final int alertDialogButtonGroupStyle = 0x7f040085;
        public static final int alertDialogCenterButtons = 0x7f040086;
        public static final int alertDialogStyle = 0x7f040087;
        public static final int alertDialogTheme = 0x7f040088;
        public static final int allowStacking = 0x7f040089;
        public static final int alpha = 0x7f04008a;
        public static final int alphabeticModifiers = 0x7f04008b;

        /* renamed from: angle */
        public static final int obfuscated = 0x7f04008e;
        public static final int animationDuration = 0x7f040093;
        public static final int arrowHeadLength = 0x7f04009b;
        public static final int arrowShaftLength = 0x7f04009c;
        public static final int autoCompleteTextViewStyle = 0x7f0400a5;
        public static final int autoSizeMaxTextSize = 0x7f0400a8;
        public static final int autoSizeMinTextSize = 0x7f0400a9;
        public static final int autoSizePresetSizes = 0x7f0400aa;
        public static final int autoSizeStepGranularity = 0x7f0400ab;
        public static final int autoSizeTextType = 0x7f0400ac;
        public static final int auto_start = 0x7f0400af;
        public static final int background = 0x7f0400b0;
        public static final int backgroundSplit = 0x7f0400b7;
        public static final int backgroundStacked = 0x7f0400b8;
        public static final int backgroundTint = 0x7f0400b9;
        public static final int backgroundTintMode = 0x7f0400ba;
        public static final int barLength = 0x7f0400c4;
        public static final int base_alpha = 0x7f0400cc;

        /* renamed from: bgBorderColor */
        public static final int obfuscated = 0x7f0400de;
        public static final int bgBorderWidth = 0x7f0400df;

        /* renamed from: bgNormalColor */
        public static final int obfuscated = 0x7f0400e0;
        public static final int bgPressedColor = 0x7f0400e1;
        public static final int border_color = 0x7f0400ee;
        public static final int border_width = 0x7f0400ef;
        public static final int borderlessButtonStyle = 0x7f0400f0;
        public static final int buttonBarButtonStyle = 0x7f04011d;
        public static final int buttonBarNegativeButtonStyle = 0x7f04011e;
        public static final int buttonBarNeutralButtonStyle = 0x7f040122;
        public static final int buttonBarPositiveButtonStyle = 0x7f040126;
        public static final int buttonBarStyle = 0x7f040127;
        public static final int buttonCompat = 0x7f040128;
        public static final int buttonGravity = 0x7f040129;
        public static final int buttonIconDimen = 0x7f04012a;
        public static final int buttonPanelSideLayout = 0x7f04012b;
        public static final int buttonStyle = 0x7f04012c;
        public static final int buttonStyleSmall = 0x7f04012d;
        public static final int buttonTint = 0x7f04012e;
        public static final int buttonTintMode = 0x7f04012f;
        public static final int cardBackgroundColor = 0x7f04011f;
        public static final int cardCornerRadius = 0x7f040120;
        public static final int cardElevation = 0x7f040121;
        public static final int cardMaxElevation = 0x7f040123;
        public static final int cardPreventCornerOverlap = 0x7f040124;
        public static final int cardUseCompatPadding = 0x7f040125;
        public static final int checkboxStyle = 0x7f040135;
        public static final int checkedTextViewStyle = 0x7f04013c;
        public static final int closeIcon = 0x7f04015d;
        public static final int closeItemLayout = 0x7f040166;
        public static final int collapseContentDescription = 0x7f040167;
        public static final int collapseIcon = 0x7f040168;
        public static final int color = 0x7f04016c;
        public static final int colorAccent = 0x7f04016d;
        public static final int colorBackgroundFloating = 0x7f04016e;
        public static final int colorButtonNormal = 0x7f04016f;
        public static final int colorControlActivated = 0x7f040170;
        public static final int colorControlHighlight = 0x7f040171;
        public static final int colorControlNormal = 0x7f040172;
        public static final int colorError = 0x7f040173;
        public static final int colorPrimary = 0x7f04017a;
        public static final int colorPrimaryDark = 0x7f04017b;
        public static final int colorSwitchThumbNormal = 0x7f040181;
        public static final int commitIcon = 0x7f040189;
        public static final int contentDescription = 0x7f040193;
        public static final int contentInsetEnd = 0x7f040194;
        public static final int contentInsetEndWithActions = 0x7f040195;
        public static final int contentInsetLeft = 0x7f040196;
        public static final int contentInsetRight = 0x7f040197;
        public static final int contentInsetStart = 0x7f040198;
        public static final int contentInsetStartWithNavigation = 0x7f040199;
        public static final int contentPadding = 0x7f040183;
        public static final int contentPaddingBottom = 0x7f040184;
        public static final int contentPaddingLeft = 0x7f040185;
        public static final int contentPaddingRight = 0x7f040186;
        public static final int contentPaddingTop = 0x7f040187;
        public static final int controlBackground = 0x7f04019d;
        public static final int corner_radius = 0x7f0401ad;
        public static final int customNavigationLayout = 0x7f0401fb;
        public static final int defaultQueryHint = 0x7f040207;
        public static final int dialogCornerRadius = 0x7f040211;
        public static final int dialogPreferredPadding = 0x7f040212;
        public static final int dialogTheme = 0x7f040213;
        public static final int displayOptions = 0x7f040215;
        public static final int divider = 0x7f040216;

        /* renamed from: dividerArcRadius */
        public static final int obfuscated = 0x7f040217;
        public static final int dividerHorizontal = 0x7f040219;

        /* renamed from: dividerLineColor */
        public static final int obfuscated = 0x7f04021a;
        public static final int dividerLineHeight = 0x7f04021b;
        public static final int dividerPadding = 0x7f04021c;
        public static final int dividerVertical = 0x7f04021d;
        public static final int drawableBottomCompat = 0x7f040259;
        public static final int drawableEndCompat = 0x7f04025a;
        public static final int drawableLeftCompat = 0x7f04025b;
        public static final int drawableRightCompat = 0x7f04025c;
        public static final int drawableSize = 0x7f04025d;
        public static final int drawableStartCompat = 0x7f04025e;
        public static final int drawableTint = 0x7f04025f;
        public static final int drawableTintMode = 0x7f040260;
        public static final int drawableTopCompat = 0x7f040261;
        public static final int drawerArrowStyle = 0x7f040262;
        public static final int dropDownListViewStyle = 0x7f040266;
        public static final int dropdownListPreferredItemHeight = 0x7f040268;

        /* renamed from: dropoff */
        public static final int obfuscated = 0x7f040269;
        public static final int duration = 0x7f04026b;
        public static final int editTextBackground = 0x7f04026d;
        public static final int editTextColor = 0x7f04026e;
        public static final int editTextStyle = 0x7f04026f;
        public static final int elevation = 0x7f040270;

        /* renamed from: entriesArray */
        public static final int obfuscated = 0x7f04028a;
        public static final int expandActivityOverflowButtonDrawable = 0x7f040293;
        public static final int fastScrollEnabled = 0x7f0402af;
        public static final int fastScrollHorizontalThumbDrawable = 0x7f0402b0;
        public static final int fastScrollHorizontalTrackDrawable = 0x7f0402b1;
        public static final int fastScrollVerticalThumbDrawable = 0x7f0402b2;
        public static final int fastScrollVerticalTrackDrawable = 0x7f0402b3;
        public static final int firstBaselineToTopHeight = 0x7f0402b7;
        public static final int fixed_height = 0x7f0402b9;
        public static final int fixed_width = 0x7f0402ba;
        public static final int font = 0x7f0402da;
        public static final int fontFamily = 0x7f0402db;
        public static final int fontProviderAuthority = 0x7f0402dc;
        public static final int fontProviderCerts = 0x7f0402dd;
        public static final int fontProviderFetchStrategy = 0x7f0402de;
        public static final int fontProviderFetchTimeout = 0x7f0402df;
        public static final int fontProviderPackage = 0x7f0402e0;
        public static final int fontProviderQuery = 0x7f0402e1;
        public static final int fontStyle = 0x7f0402e3;
        public static final int fontVariationSettings = 0x7f0402e4;
        public static final int fontWeight = 0x7f0402e5;

        /* renamed from: galleryStyle */
        public static final int obfuscated = 0x7f0402ea;
        public static final int gapBetweenBars = 0x7f0402eb;
        public static final int goIcon = 0x7f0402ee;
        public static final int height = 0x7f0402ff;
        public static final int hideOnContentScroll = 0x7f040309;
        public static final int homeAsUpIndicator = 0x7f040326;
        public static final int homeLayout = 0x7f040327;
        public static final int icon = 0x7f04032c;
        public static final int iconTint = 0x7f040334;
        public static final int iconTintMode = 0x7f040335;
        public static final int iconifiedByDefault = 0x7f040337;
        public static final int imageButtonStyle = 0x7f04033a;
        public static final int indeterminateProgressStyle = 0x7f040342;
        public static final int initialActivityCount = 0x7f040343;

        /* renamed from: intensity */
        public static final int obfuscated = 0x7f040347;
        public static final int isLightTheme = 0x7f04034a;
        public static final int itemPadding = 0x7f04036f;
        public static final int lastBaselineToBottomHeight = 0x7f040407;
        public static final int layout = 0x7f040409;
        public static final int layoutManager = 0x7f04040f;

        /* renamed from: lineColor */
        public static final int obfuscated = 0x7f040434;
        public static final int lineHeight = 0x7f040435;
        public static final int listChoiceBackgroundIndicator = 0x7f040439;
        public static final int listChoiceIndicatorMultipleAnimated = 0x7f04043a;
        public static final int listChoiceIndicatorSingleAnimated = 0x7f04043b;
        public static final int listDividerAlertDialog = 0x7f04043c;
        public static final int listItemLayout = 0x7f04043d;
        public static final int listLayout = 0x7f04043e;
        public static final int listMenuViewStyle = 0x7f04043f;
        public static final int listPopupWindowStyle = 0x7f040440;
        public static final int listPreferredItemHeight = 0x7f040441;
        public static final int listPreferredItemHeightLarge = 0x7f040442;
        public static final int listPreferredItemHeightSmall = 0x7f040443;
        public static final int listPreferredItemPaddingEnd = 0x7f040444;
        public static final int listPreferredItemPaddingLeft = 0x7f040445;
        public static final int listPreferredItemPaddingRight = 0x7f040446;
        public static final int listPreferredItemPaddingStart = 0x7f040447;
        public static final int logo = 0x7f04049b;
        public static final int logoDescription = 0x7f04049c;
        public static final int max = 0x7f0404bc;
        public static final int maxButtonHeight = 0x7f0404bf;
        public static final int measureWithLargestChild = 0x7f0404cd;
        public static final int menu = 0x7f0404cf;
        public static final int multiChoiceItemLayout = 0x7f0404e5;
        public static final int navigationContentDescription = 0x7f0404fd;
        public static final int navigationIcon = 0x7f0404fe;
        public static final int navigationMode = 0x7f0404ff;
        public static final int numericModifiers = 0x7f04050c;
        public static final int overlapAnchor = 0x7f040518;
        public static final int paddingBottomNoButtons = 0x7f04051c;
        public static final int paddingEnd = 0x7f04051e;
        public static final int paddingStart = 0x7f040523;
        public static final int paddingTopNoTitle = 0x7f040525;
        public static final int panelBackground = 0x7f040527;
        public static final int panelMenuListTheme = 0x7f040528;
        public static final int panelMenuListWidth = 0x7f040529;
        public static final int popupAnimationStyle = 0x7f040561;
        public static final int popupBackground = 0x7f040562;
        public static final int popupMenuStyle = 0x7f040564;
        public static final int popupTheme = 0x7f040565;
        public static final int popupWindowStyle = 0x7f040566;
        public static final int preserveIconSpacing = 0x7f04056a;
        public static final int progressBarPadding = 0x7f04056e;
        public static final int progressBarStyle = 0x7f04056f;
        public static final int queryBackground = 0x7f0405a0;
        public static final int queryHint = 0x7f0405a1;
        public static final int radioButtonStyle = 0x7f0405af;
        public static final int ratingBarStyle = 0x7f0405b7;
        public static final int ratingBarStyleIndicator = 0x7f0405b8;
        public static final int ratingBarStyleSmall = 0x7f0405b9;
        public static final int recyclerViewStyle = 0x7f0405bb;
        public static final int relative_height = 0x7f0405c2;
        public static final int relative_width = 0x7f0405c3;
        public static final int repeat_count = 0x7f0405c6;
        public static final int repeat_delay = 0x7f0405c7;
        public static final int repeat_mode = 0x7f0405c8;
        public static final int reverseLayout = 0x7f0405cd;
        public static final int roundColor = 0x7f0405dd;
        public static final int roundProgressColor = 0x7f0405e3;
        public static final int roundWidth = 0x7f0405e8;
        public static final int round_background = 0x7f0405e9;
        public static final int searchHintIcon = 0x7f040611;
        public static final int searchIcon = 0x7f040612;
        public static final int searchViewStyle = 0x7f040613;
        public static final int seekBarStyle = 0x7f040615;
        public static final int selectableItemBackground = 0x7f040618;
        public static final int selectableItemBackgroundBorderless = 0x7f040619;
        public static final int showAsAction = 0x7f04062e;
        public static final int showDividers = 0x7f04062f;
        public static final int showText = 0x7f040634;
        public static final int showTitle = 0x7f040635;
        public static final int singleChoiceItemLayout = 0x7f04063b;
        public static final int spacing = 0x7f04064f;
        public static final int spanCount = 0x7f040654;
        public static final int spinBars = 0x7f040657;
        public static final int spinnerDropDownItemStyle = 0x7f040658;
        public static final int spinnerStyle = 0x7f040659;
        public static final int splitTrack = 0x7f04065b;
        public static final int srcCompat = 0x7f04065d;
        public static final int stackFromEnd = 0x7f04065f;
        public static final int state_above_anchor = 0x7f040667;

        /* renamed from: style */
        public static final int obfuscated = 0x7f040673;
        public static final int subMenuArrow = 0x7f040674;
        public static final int submitBackground = 0x7f040675;
        public static final int subtitle = 0x7f040676;
        public static final int subtitleTextAppearance = 0x7f040677;
        public static final int subtitleTextColor = 0x7f040678;
        public static final int subtitleTextStyle = 0x7f040679;
        public static final int suggestionRowLayout = 0x7f04067d;
        public static final int switchMinWidth = 0x7f040688;
        public static final int switchPadding = 0x7f040689;
        public static final int switchStyle = 0x7f04068a;
        public static final int switchTextAppearance = 0x7f04068b;
        public static final int tabPadding = 0x7f04069c;
        public static final int tabPaddingBottom = 0x7f04069d;
        public static final int tabPaddingEnd = 0x7f04069e;
        public static final int tabPaddingStart = 0x7f04069f;
        public static final int tabPaddingTop = 0x7f0406a0;
        public static final int textAllCaps = 0x7f0406e8;
        public static final int textAppearanceLargePopupMenu = 0x7f0406f3;
        public static final int textAppearanceListItem = 0x7f0406f5;
        public static final int textAppearanceListItemSecondary = 0x7f0406f6;
        public static final int textAppearanceListItemSmall = 0x7f0406f7;
        public static final int textAppearancePopupMenuHeader = 0x7f0406f9;
        public static final int textAppearanceSearchResultSubtitle = 0x7f0406fa;
        public static final int textAppearanceSearchResultTitle = 0x7f0406fb;
        public static final int textAppearanceSmallPopupMenu = 0x7f0406fc;
        public static final int textColor = 0x7f0406ff;
        public static final int textColorAlertDialogListItem = 0x7f040700;
        public static final int textColorSearchUrl = 0x7f040703;
        public static final int textIsDisplayable = 0x7f040709;
        public static final int textLocale = 0x7f04070a;
        public static final int textSize = 0x7f04070c;
        public static final int theme = 0x7f040713;
        public static final int thickness = 0x7f040716;
        public static final int thumbTextPadding = 0x7f040720;
        public static final int thumbTint = 0x7f040721;
        public static final int thumbTintMode = 0x7f040722;
        public static final int tickMark = 0x7f040728;
        public static final int tickMarkTint = 0x7f040729;
        public static final int tickMarkTintMode = 0x7f04072a;

        /* renamed from: tilt */
        public static final int obfuscated = 0x7f04072c;
        public static final int tint = 0x7f04072d;
        public static final int tintMode = 0x7f04072e;
        public static final int title = 0x7f04072f;
        public static final int titleMargin = 0x7f040732;
        public static final int titleMarginBottom = 0x7f040733;
        public static final int titleMarginEnd = 0x7f040734;
        public static final int titleMarginStart = 0x7f040735;
        public static final int titleMarginTop = 0x7f040736;
        public static final int titleMargins = 0x7f040737;
        public static final int titleText = 0x7f040738;
        public static final int titleTextAppearance = 0x7f040739;
        public static final int titleTextColor = 0x7f04073a;
        public static final int titleTextStyle = 0x7f04073b;
        public static final int titleTxtShadowColor = 0x7f04073c;
        public static final int titleTxtShadowDx = 0x7f04073d;
        public static final int titleTxtShadowDy = 0x7f04073e;
        public static final int titleTxtShadowRadius = 0x7f04073f;
        public static final int toolbarNavigationButtonStyle = 0x7f040741;
        public static final int toolbarStyle = 0x7f040742;
        public static final int tooltipForegroundColor = 0x7f040743;
        public static final int tooltipFrameBackground = 0x7f040744;
        public static final int tooltipText = 0x7f040746;
        public static final int track = 0x7f04074f;
        public static final int trackTint = 0x7f040754;
        public static final int trackTintMode = 0x7f040755;
        public static final int ttcIndex = 0x7f040766;
        public static final int unselectedAlpha = 0x7f040778;
        public static final int viewInflaterClass = 0x7f040790;
        public static final int voiceIcon = 0x7f040793;
        public static final int wheelview_dividerColor = 0x7f04079a;
        public static final int wheelview_gravity = 0x7f04079b;
        public static final int wheelview_lineSpacingMultiplier = 0x7f04079c;
        public static final int wheelview_textColorCenter = 0x7f04079d;
        public static final int wheelview_textColorOut = 0x7f04079e;
        public static final int wheelview_textSize = 0x7f04079f;
        public static final int windowActionBar = 0x7f0407a3;
        public static final int windowActionBarOverlay = 0x7f0407a4;
        public static final int windowActionModeOverlay = 0x7f0407a5;
        public static final int windowFixedHeightMajor = 0x7f0407a6;
        public static final int windowFixedHeightMinor = 0x7f0407a7;
        public static final int windowFixedWidthMajor = 0x7f0407a8;
        public static final int windowFixedWidthMinor = 0x7f0407a9;
        public static final int windowMinWidthMajor = 0x7f0407aa;
        public static final int windowMinWidthMinor = 0x7f0407ab;
        public static final int windowNoTitle = 0x7f0407ac;
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

    /* loaded from: classes3.dex */
    public static final class bool {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int abc_action_bar_embed_tabs = 0x7f050000;
        public static final int abc_allow_stacked_button_bar = 0x7f050001;
        public static final int abc_config_actionMenuItemAllCaps = 0x7f050002;
        public transient /* synthetic */ FieldHolder $fh;

        public bool() {
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

    /* loaded from: classes3.dex */
    public static final class color {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: GC1 */
        public static final int obfuscated = 0x7f060177;

        /* renamed from: GC10 */
        public static final int obfuscated = 0x7f060178;

        /* renamed from: GC11 */
        public static final int obfuscated = 0x7f060179;

        /* renamed from: GC12 */
        public static final int obfuscated = 0x7f06017a;

        /* renamed from: GC13 */
        public static final int obfuscated = 0x7f06017b;

        /* renamed from: GC14 */
        public static final int obfuscated = 0x7f06017c;

        /* renamed from: GC15 */
        public static final int obfuscated = 0x7f06017d;

        /* renamed from: GC16 */
        public static final int obfuscated = 0x7f06017e;

        /* renamed from: GC18 */
        public static final int obfuscated = 0x7f06017f;

        /* renamed from: GC19 */
        public static final int obfuscated = 0x7f060180;

        /* renamed from: GC2 */
        public static final int obfuscated = 0x7f060181;

        /* renamed from: GC21 */
        public static final int obfuscated = 0x7f060182;

        /* renamed from: GC22 */
        public static final int obfuscated = 0x7f060183;

        /* renamed from: GC24 */
        public static final int obfuscated = 0x7f060184;

        /* renamed from: GC26 */
        public static final int obfuscated = 0x7f060185;

        /* renamed from: GC28 */
        public static final int obfuscated = 0x7f060186;

        /* renamed from: GC3 */
        public static final int obfuscated = 0x7f060187;

        /* renamed from: GC30 */
        public static final int obfuscated = 0x7f060188;

        /* renamed from: GC33 */
        public static final int obfuscated = 0x7f060189;

        /* renamed from: GC34 */
        public static final int obfuscated = 0x7f06018a;

        /* renamed from: GC35 */
        public static final int obfuscated = 0x7f06018b;

        /* renamed from: GC36 */
        public static final int obfuscated = 0x7f06018c;

        /* renamed from: GC37 */
        public static final int obfuscated = 0x7f06018d;

        /* renamed from: GC38 */
        public static final int obfuscated = 0x7f06018e;

        /* renamed from: GC39 */
        public static final int obfuscated = 0x7f06018f;

        /* renamed from: GC4 */
        public static final int obfuscated = 0x7f060190;

        /* renamed from: GC42 */
        public static final int obfuscated = 0x7f060191;

        /* renamed from: GC43 */
        public static final int obfuscated = 0x7f060192;

        /* renamed from: GC48 */
        public static final int obfuscated = 0x7f060193;

        /* renamed from: GC49 */
        public static final int obfuscated = 0x7f060194;

        /* renamed from: GC5 */
        public static final int obfuscated = 0x7f060195;

        /* renamed from: GC51 */
        public static final int obfuscated = 0x7f060196;

        /* renamed from: GC52 */
        public static final int obfuscated = 0x7f060197;

        /* renamed from: GC53 */
        public static final int obfuscated = 0x7f060198;

        /* renamed from: GC54 */
        public static final int obfuscated = 0x7f060199;

        /* renamed from: GC55 */
        public static final int obfuscated = 0x7f06019a;

        /* renamed from: GC56 */
        public static final int obfuscated = 0x7f06019b;

        /* renamed from: GC57 */
        public static final int obfuscated = 0x7f06019c;

        /* renamed from: GC58 */
        public static final int obfuscated = 0x7f06019d;

        /* renamed from: GC59 */
        public static final int obfuscated = 0x7f06019e;

        /* renamed from: GC6 */
        public static final int obfuscated = 0x7f06019f;

        /* renamed from: GC60 */
        public static final int obfuscated = 0x7f0601a0;

        /* renamed from: GC62 */
        public static final int obfuscated = 0x7f0601a1;

        /* renamed from: GC63 */
        public static final int obfuscated = 0x7f0601a2;

        /* renamed from: GC66 */
        public static final int obfuscated = 0x7f0601a3;

        /* renamed from: GC67 */
        public static final int obfuscated = 0x7f0601a4;

        /* renamed from: GC68 */
        public static final int obfuscated = 0x7f0601a5;

        /* renamed from: GC69 */
        public static final int obfuscated = 0x7f0601a6;

        /* renamed from: GC7 */
        public static final int obfuscated = 0x7f0601a7;

        /* renamed from: GC72 */
        public static final int obfuscated = 0x7f0601a8;

        /* renamed from: GC73 */
        public static final int obfuscated = 0x7f0601a9;

        /* renamed from: GC74 */
        public static final int obfuscated = 0x7f0601aa;

        /* renamed from: GC77 */
        public static final int obfuscated = 0x7f0601ab;

        /* renamed from: GC79 */
        public static final int obfuscated = 0x7f0601ac;

        /* renamed from: GC8 */
        public static final int obfuscated = 0x7f0601ad;

        /* renamed from: GC84 */
        public static final int obfuscated = 0x7f0601ae;

        /* renamed from: GC85 */
        public static final int obfuscated = 0x7f0601af;

        /* renamed from: GC86 */
        public static final int obfuscated = 0x7f0601b0;

        /* renamed from: GC88 */
        public static final int obfuscated = 0x7f0601b1;

        /* renamed from: GC9 */
        public static final int obfuscated = 0x7f0601b2;

        /* renamed from: GC90 */
        public static final int obfuscated = 0x7f0601b3;
        public static final int abc_background_cache_hint_selector_material_dark = 0x7f0602b2;
        public static final int abc_background_cache_hint_selector_material_light = 0x7f0602b3;
        public static final int abc_btn_colored_borderless_text_material = 0x7f0602b4;
        public static final int abc_btn_colored_text_material = 0x7f0602b5;
        public static final int abc_color_highlight_material = 0x7f0602b6;
        public static final int abc_hint_foreground_material_dark = 0x7f0602b9;
        public static final int abc_hint_foreground_material_light = 0x7f0602ba;
        public static final int abc_primary_text_disable_only_material_dark = 0x7f0602bb;
        public static final int abc_primary_text_disable_only_material_light = 0x7f0602bc;
        public static final int abc_primary_text_material_dark = 0x7f0602bd;
        public static final int abc_primary_text_material_light = 0x7f0602be;
        public static final int abc_search_url_text = 0x7f0602bf;
        public static final int abc_search_url_text_normal = 0x7f0602c0;
        public static final int abc_search_url_text_pressed = 0x7f0602c1;
        public static final int abc_search_url_text_selected = 0x7f0602c2;
        public static final int abc_secondary_text_material_dark = 0x7f0602c3;
        public static final int abc_secondary_text_material_light = 0x7f0602c4;
        public static final int abc_tint_btn_checkable = 0x7f0602c5;
        public static final int abc_tint_default = 0x7f0602c6;
        public static final int abc_tint_edittext = 0x7f0602c7;
        public static final int abc_tint_seek_thumb = 0x7f0602c8;
        public static final int abc_tint_spinner = 0x7f0602c9;
        public static final int abc_tint_switch_track = 0x7f0602ca;
        public static final int accent_material_dark = 0x7f0602cb;
        public static final int accent_material_light = 0x7f0602cc;
        public static final int androidx_core_ripple_material_light = 0x7f060355;
        public static final int androidx_core_secondary_text_default_material_light = 0x7f060356;
        public static final int background_floating_material_dark = 0x7f060360;
        public static final int background_floating_material_light = 0x7f060361;
        public static final int background_material_dark = 0x7f060362;
        public static final int background_material_light = 0x7f060363;
        public static final int black = 0x7f06037f;
        public static final int bright_foreground_disabled_material_dark = 0x7f060396;
        public static final int bright_foreground_disabled_material_light = 0x7f060397;
        public static final int bright_foreground_inverse_material_dark = 0x7f060398;
        public static final int bright_foreground_inverse_material_light = 0x7f060399;
        public static final int bright_foreground_material_dark = 0x7f06039a;
        public static final int bright_foreground_material_light = 0x7f06039b;
        public static final int button_material_dark = 0x7f0603a2;
        public static final int button_material_light = 0x7f0603a3;
        public static final int cardview_dark_background = 0x7f0603a6;
        public static final int cardview_light_background = 0x7f0603a7;
        public static final int cardview_shadow_end_color = 0x7f0603a8;
        public static final int cardview_shadow_start_color = 0x7f0603a9;
        public static final int comment_emotion_bag_bg = 0x7f0603bf;
        public static final int comment_emotion_circle_indicator = 0x7f0603c0;
        public static final int comment_emotion_circle_indicator_highlight = 0x7f0603c1;
        public static final int comment_emotion_type_layout_bg = 0x7f0603c2;
        public static final int comment_emotion_type_placeholder_bg = 0x7f0603c3;
        public static final int dim_foreground_disabled_material_dark = 0x7f0605c3;
        public static final int dim_foreground_disabled_material_light = 0x7f0605c4;
        public static final int dim_foreground_material_dark = 0x7f0605c5;
        public static final int dim_foreground_material_light = 0x7f0605c6;
        public static final int error_color_material_dark = 0x7f0605d8;
        public static final int error_color_material_light = 0x7f0605d9;
        public static final int foreground_material_dark = 0x7f0605df;
        public static final int foreground_material_light = 0x7f0605e0;
        public static final int highlighted_text_material_dark = 0x7f0605f4;
        public static final int highlighted_text_material_light = 0x7f0605f5;
        public static final int invoice_bg_border_color = 0x7f0605f7;
        public static final int invoice_bg_divider_line_color = 0x7f0605f8;
        public static final int invoice_bg_normal_color = 0x7f0605f9;
        public static final int invoice_bg_pressed_color = 0x7f0605fa;
        public static final int invoice_bottom_text = 0x7f0605fb;
        public static final int invoice_info_content = 0x7f060602;
        public static final int invoice_info_content_hint = 0x7f060603;
        public static final int invoice_info_desc = 0x7f060604;
        public static final int invoice_info_item_divider_line = 0x7f060605;
        public static final int invoice_top_tag_color = 0x7f060607;
        public static final int invoice_top_tax_number_color = 0x7f060608;
        public static final int invoice_top_title_color = 0x7f060609;
        public static final int invoice_type = 0x7f06060a;
        public static final int invoice_type_company = 0x7f06060b;
        public static final int invoice_type_personal = 0x7f06060c;
        public static final int loading_text_color = 0x7f060642;
        public static final int material_blue_grey_800 = 0x7f06064a;
        public static final int material_blue_grey_900 = 0x7f06064b;
        public static final int material_blue_grey_950 = 0x7f06064c;
        public static final int material_deep_teal_200 = 0x7f06064d;
        public static final int material_deep_teal_500 = 0x7f06064e;
        public static final int material_grey_100 = 0x7f06064f;
        public static final int material_grey_300 = 0x7f060650;
        public static final int material_grey_50 = 0x7f060651;
        public static final int material_grey_600 = 0x7f060652;
        public static final int material_grey_800 = 0x7f060653;
        public static final int material_grey_850 = 0x7f060654;
        public static final int material_grey_900 = 0x7f060655;
        public static final int notification_action_color_filter = 0x7f06076f;
        public static final int notification_icon_bg_color = 0x7f060770;
        public static final int primary_dark_material_dark = 0x7f0607c2;
        public static final int primary_dark_material_light = 0x7f0607c3;
        public static final int primary_material_dark = 0x7f0607c4;
        public static final int primary_material_light = 0x7f0607c5;
        public static final int primary_text_default_material_dark = 0x7f0607c6;
        public static final int primary_text_default_material_light = 0x7f0607c7;
        public static final int primary_text_disabled_material_dark = 0x7f0607c8;
        public static final int primary_text_disabled_material_light = 0x7f0607c9;
        public static final int ripple_material_dark = 0x7f0607d9;
        public static final int ripple_material_light = 0x7f0607da;
        public static final int secondary_text_default_material_dark = 0x7f0608f0;
        public static final int secondary_text_default_material_light = 0x7f0608f1;
        public static final int secondary_text_disabled_material_dark = 0x7f0608f2;
        public static final int secondary_text_disabled_material_light = 0x7f0608f3;
        public static final int switch_thumb_disabled_material_dark = 0x7f060996;
        public static final int switch_thumb_disabled_material_light = 0x7f060997;
        public static final int switch_thumb_material_dark = 0x7f060998;
        public static final int switch_thumb_material_light = 0x7f060999;
        public static final int switch_thumb_normal_material_dark = 0x7f06099a;
        public static final int switch_thumb_normal_material_light = 0x7f06099b;
        public static final int tooltip_background_dark = 0x7f0609a8;
        public static final int tooltip_background_light = 0x7f0609a9;
        public static final int transparent = 0x7f0609cd;
        public static final int white = 0x7f0609d9;
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

    /* loaded from: classes3.dex */
    public static final class dimen {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int abc_action_bar_content_inset_material = 0x7f07008b;
        public static final int abc_action_bar_content_inset_with_nav = 0x7f07008c;
        public static final int abc_action_bar_default_height_material = 0x7f07008d;
        public static final int abc_action_bar_default_padding_end_material = 0x7f07008e;
        public static final int abc_action_bar_default_padding_start_material = 0x7f07008f;
        public static final int abc_action_bar_elevation_material = 0x7f070090;
        public static final int abc_action_bar_icon_vertical_padding_material = 0x7f070091;
        public static final int abc_action_bar_overflow_padding_end_material = 0x7f070092;
        public static final int abc_action_bar_overflow_padding_start_material = 0x7f070093;
        public static final int abc_action_bar_stacked_max_height = 0x7f070094;
        public static final int abc_action_bar_stacked_tab_max_width = 0x7f070095;
        public static final int abc_action_bar_subtitle_bottom_margin_material = 0x7f070096;
        public static final int abc_action_bar_subtitle_top_margin_material = 0x7f070097;
        public static final int abc_action_button_min_height_material = 0x7f070098;
        public static final int abc_action_button_min_width_material = 0x7f070099;
        public static final int abc_action_button_min_width_overflow_material = 0x7f07009a;
        public static final int abc_alert_dialog_button_bar_height = 0x7f07009b;
        public static final int abc_alert_dialog_button_dimen = 0x7f07009c;
        public static final int abc_button_inset_horizontal_material = 0x7f07009d;
        public static final int abc_button_inset_vertical_material = 0x7f07009e;
        public static final int abc_button_padding_horizontal_material = 0x7f07009f;
        public static final int abc_button_padding_vertical_material = 0x7f0700a0;
        public static final int abc_cascading_menus_min_smallest_width = 0x7f0700a1;
        public static final int abc_config_prefDialogWidth = 0x7f0700a2;
        public static final int abc_control_corner_material = 0x7f0700a3;
        public static final int abc_control_inset_material = 0x7f0700a4;
        public static final int abc_control_padding_material = 0x7f0700a5;
        public static final int abc_dialog_corner_radius_material = 0x7f0700a6;
        public static final int abc_dialog_fixed_height_major = 0x7f0700a7;
        public static final int abc_dialog_fixed_height_minor = 0x7f0700a8;
        public static final int abc_dialog_fixed_width_major = 0x7f0700a9;
        public static final int abc_dialog_fixed_width_minor = 0x7f0700aa;
        public static final int abc_dialog_list_padding_bottom_no_buttons = 0x7f0700ab;
        public static final int abc_dialog_list_padding_top_no_title = 0x7f0700ac;
        public static final int abc_dialog_min_width_major = 0x7f0700ad;
        public static final int abc_dialog_min_width_minor = 0x7f0700ae;
        public static final int abc_dialog_padding_material = 0x7f0700af;
        public static final int abc_dialog_padding_top_material = 0x7f0700b0;
        public static final int abc_dialog_title_divider_material = 0x7f0700b1;
        public static final int abc_disabled_alpha_material_dark = 0x7f0700b2;
        public static final int abc_disabled_alpha_material_light = 0x7f0700b3;
        public static final int abc_dropdownitem_icon_width = 0x7f0700b4;
        public static final int abc_dropdownitem_text_padding_left = 0x7f0700b5;
        public static final int abc_dropdownitem_text_padding_right = 0x7f0700b6;
        public static final int abc_edit_text_inset_bottom_material = 0x7f0700b7;
        public static final int abc_edit_text_inset_horizontal_material = 0x7f0700b8;
        public static final int abc_edit_text_inset_top_material = 0x7f0700b9;
        public static final int abc_floating_window_z = 0x7f0700ba;
        public static final int abc_list_item_height_large_material = 0x7f0700bb;
        public static final int abc_list_item_height_material = 0x7f0700bc;
        public static final int abc_list_item_height_small_material = 0x7f0700bd;
        public static final int abc_list_item_padding_horizontal_material = 0x7f0700be;
        public static final int abc_panel_menu_list_width = 0x7f0700bf;
        public static final int abc_progress_bar_height_material = 0x7f0700c0;
        public static final int abc_search_view_preferred_height = 0x7f0700c1;
        public static final int abc_search_view_preferred_width = 0x7f0700c2;
        public static final int abc_seekbar_track_background_height_material = 0x7f0700c3;
        public static final int abc_seekbar_track_progress_height_material = 0x7f0700c4;
        public static final int abc_select_dialog_padding_start_material = 0x7f0700c5;
        public static final int abc_switch_padding = 0x7f0700c6;
        public static final int abc_text_size_body_1_material = 0x7f0700c7;
        public static final int abc_text_size_body_2_material = 0x7f0700c8;
        public static final int abc_text_size_button_material = 0x7f0700c9;
        public static final int abc_text_size_caption_material = 0x7f0700ca;
        public static final int abc_text_size_display_1_material = 0x7f0700cb;
        public static final int abc_text_size_display_2_material = 0x7f0700cc;
        public static final int abc_text_size_display_3_material = 0x7f0700cd;
        public static final int abc_text_size_display_4_material = 0x7f0700ce;
        public static final int abc_text_size_headline_material = 0x7f0700cf;
        public static final int abc_text_size_large_material = 0x7f0700d0;
        public static final int abc_text_size_medium_material = 0x7f0700d1;
        public static final int abc_text_size_menu_header_material = 0x7f0700d2;
        public static final int abc_text_size_menu_material = 0x7f0700d3;
        public static final int abc_text_size_small_material = 0x7f0700d4;
        public static final int abc_text_size_subhead_material = 0x7f0700d5;
        public static final int abc_text_size_subtitle_material_toolbar = 0x7f0700d6;
        public static final int abc_text_size_title_material = 0x7f0700d7;
        public static final int abc_text_size_title_material_toolbar = 0x7f0700d8;
        public static final int cardview_compat_inset_shadow = 0x7f0701b3;
        public static final int cardview_default_elevation = 0x7f0701b4;
        public static final int cardview_default_radius = 0x7f0701b5;
        public static final int common_grid_indicator_height = 0x7f0701c6;
        public static final int common_grid_indicator_height2 = 0x7f0701c7;
        public static final int common_grid_indicator_margin = 0x7f0701c8;
        public static final int common_grid_row_margin = 0x7f0701c9;
        public static final int compat_button_inset_horizontal_material = 0x7f0701ca;
        public static final int compat_button_inset_vertical_material = 0x7f0701cb;
        public static final int compat_button_padding_horizontal_material = 0x7f0701cc;
        public static final int compat_button_padding_vertical_material = 0x7f0701cd;
        public static final int compat_control_corner_material = 0x7f0701ce;
        public static final int compat_notification_large_icon_max_height = 0x7f0701cf;
        public static final int compat_notification_large_icon_max_width = 0x7f0701d0;
        public static final int disabled_alpha_material_dark = 0x7f07022d;
        public static final int disabled_alpha_material_light = 0x7f07022e;
        public static final int expression_all_title_padding_top = 0x7f070321;
        public static final int expression_bottom_padding_height = 0x7f070322;
        public static final int expression_common_title_padding_top = 0x7f070323;
        public static final int expression_cross_section_fixed_height = 0x7f070324;
        public static final int expression_left_right_margin = 0x7f070325;
        public static final int expression_row_height = 0x7f070326;
        public static final int expression_title_size = 0x7f070327;
        public static final int fastscroll_default_thickness = 0x7f070328;
        public static final int fastscroll_margin = 0x7f070329;
        public static final int fastscroll_minimum_range = 0x7f07032a;
        public static final int highlight_alpha_material_colored = 0x7f07033f;
        public static final int highlight_alpha_material_dark = 0x7f070340;
        public static final int highlight_alpha_material_light = 0x7f070341;
        public static final int hint_alpha_material_dark = 0x7f070342;
        public static final int hint_alpha_material_light = 0x7f070343;
        public static final int hint_pressed_alpha_material_dark = 0x7f070344;
        public static final int hint_pressed_alpha_material_light = 0x7f070345;
        public static final int invoice_bg_border_width = 0x7f07034a;
        public static final int invoice_bg_divider_arc_radius = 0x7f07034b;
        public static final int invoice_bg_divider_line_height = 0x7f07034c;
        public static final int invoice_bottom_img_size = 0x7f07034d;
        public static final int invoice_bottom_text_size = 0x7f07034e;
        public static final int invoice_bottom_view_height = 0x7f07034f;
        public static final int invoice_info_content = 0x7f070350;
        public static final int invoice_info_desc = 0x7f070351;
        public static final int invoice_top_text_size = 0x7f070353;
        public static final int invoice_type = 0x7f070354;
        public static final int invoice_type_company = 0x7f070355;
        public static final int invoice_type_personal = 0x7f070356;
        public static final int item_touch_helper_max_drag_scroll_per_frame = 0x7f070357;
        public static final int item_touch_helper_swipe_escape_max_velocity = 0x7f070358;
        public static final int item_touch_helper_swipe_escape_velocity = 0x7f070359;
        public static final int max_panel_height = 0x7f07042e;
        public static final int max_softinput_height = 0x7f07042f;
        public static final int min_panel_height = 0x7f070431;
        public static final int min_softinput_height = 0x7f070432;
        public static final int notification_action_icon_size = 0x7f0705ea;
        public static final int notification_action_text_size = 0x7f0705eb;
        public static final int notification_big_circle_margin = 0x7f0705ec;
        public static final int notification_content_margin_start = 0x7f0705ed;
        public static final int notification_large_icon_height = 0x7f0705ef;
        public static final int notification_large_icon_width = 0x7f0705f0;
        public static final int notification_main_column_padding_top = 0x7f0705f1;
        public static final int notification_media_narrow_margin = 0x7f0705f2;
        public static final int notification_right_icon_size = 0x7f0705f3;
        public static final int notification_right_side_padding_top = 0x7f0705f4;
        public static final int notification_small_icon_background_padding = 0x7f0705f5;
        public static final int notification_small_icon_size_as_large = 0x7f0705f6;
        public static final int notification_subtext_size = 0x7f0705f7;
        public static final int notification_top_pad = 0x7f0705f8;
        public static final int notification_top_pad_large_text = 0x7f0705f9;
        public static final int tooltip_corner_radius = 0x7f0709ad;
        public static final int tooltip_horizontal_padding = 0x7f0709ae;
        public static final int tooltip_margin = 0x7f0709af;
        public static final int tooltip_precise_anchor_extra_offset = 0x7f0709b0;
        public static final int tooltip_precise_anchor_threshold = 0x7f0709b1;
        public static final int tooltip_vertical_padding = 0x7f0709b2;
        public static final int tooltip_y_offset_non_touch = 0x7f0709b3;
        public static final int tooltip_y_offset_touch = 0x7f0709b4;
        public static final int window_horizontal_padding = 0x7f0709c7;
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

    /* loaded from: classes3.dex */
    public static final class drawable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int abc_ab_share_pack_mtrl_alpha = 0x7f08005f;
        public static final int abc_action_bar_item_background_material = 0x7f080060;
        public static final int abc_btn_borderless_material = 0x7f080061;
        public static final int abc_btn_check_material = 0x7f080062;
        public static final int abc_btn_check_material_anim = 0x7f080063;
        public static final int abc_btn_check_to_on_mtrl_000 = 0x7f080064;
        public static final int abc_btn_check_to_on_mtrl_015 = 0x7f080065;
        public static final int abc_btn_colored_material = 0x7f080066;
        public static final int abc_btn_default_mtrl_shape = 0x7f080067;
        public static final int abc_btn_radio_material = 0x7f080068;
        public static final int abc_btn_radio_material_anim = 0x7f080069;
        public static final int abc_btn_radio_to_on_mtrl_000 = 0x7f08006a;
        public static final int abc_btn_radio_to_on_mtrl_015 = 0x7f08006b;
        public static final int abc_btn_switch_to_on_mtrl_00001 = 0x7f08006c;
        public static final int abc_btn_switch_to_on_mtrl_00012 = 0x7f08006d;
        public static final int abc_cab_background_internal_bg = 0x7f08006e;
        public static final int abc_cab_background_top_material = 0x7f08006f;
        public static final int abc_cab_background_top_mtrl_alpha = 0x7f080070;
        public static final int abc_control_background_material = 0x7f080071;
        public static final int abc_dialog_material_background = 0x7f080072;
        public static final int abc_edit_text_material = 0x7f080073;
        public static final int abc_ic_ab_back_material = 0x7f080074;
        public static final int abc_ic_arrow_drop_right_black_24dp = 0x7f080075;
        public static final int abc_ic_clear_material = 0x7f080076;
        public static final int abc_ic_commit_search_api_mtrl_alpha = 0x7f080077;
        public static final int abc_ic_go_search_api_material = 0x7f080078;
        public static final int abc_ic_menu_copy_mtrl_am_alpha = 0x7f080079;
        public static final int abc_ic_menu_cut_mtrl_alpha = 0x7f08007a;
        public static final int abc_ic_menu_overflow_material = 0x7f08007b;
        public static final int abc_ic_menu_paste_mtrl_am_alpha = 0x7f08007c;
        public static final int abc_ic_menu_selectall_mtrl_alpha = 0x7f08007d;
        public static final int abc_ic_menu_share_mtrl_alpha = 0x7f08007e;
        public static final int abc_ic_search_api_material = 0x7f08007f;
        public static final int abc_ic_star_black_16dp = 0x7f080080;
        public static final int abc_ic_star_black_36dp = 0x7f080081;
        public static final int abc_ic_star_black_48dp = 0x7f080082;
        public static final int abc_ic_star_half_black_16dp = 0x7f080083;
        public static final int abc_ic_star_half_black_36dp = 0x7f080084;
        public static final int abc_ic_star_half_black_48dp = 0x7f080085;
        public static final int abc_ic_voice_search_api_material = 0x7f080086;
        public static final int abc_item_background_holo_dark = 0x7f080087;
        public static final int abc_item_background_holo_light = 0x7f080088;
        public static final int abc_list_divider_material = 0x7f080089;
        public static final int abc_list_divider_mtrl_alpha = 0x7f08008a;
        public static final int abc_list_focused_holo = 0x7f08008b;
        public static final int abc_list_longpressed_holo = 0x7f08008c;
        public static final int abc_list_pressed_holo_dark = 0x7f08008d;
        public static final int abc_list_pressed_holo_light = 0x7f08008e;
        public static final int abc_list_selector_background_transition_holo_dark = 0x7f08008f;
        public static final int abc_list_selector_background_transition_holo_light = 0x7f080090;
        public static final int abc_list_selector_disabled_holo_dark = 0x7f080091;
        public static final int abc_list_selector_disabled_holo_light = 0x7f080092;
        public static final int abc_list_selector_holo_dark = 0x7f080093;
        public static final int abc_list_selector_holo_light = 0x7f080094;
        public static final int abc_menu_hardkey_panel_mtrl_mult = 0x7f080095;
        public static final int abc_popup_background_mtrl_mult = 0x7f080096;
        public static final int abc_ratingbar_indicator_material = 0x7f080097;
        public static final int abc_ratingbar_material = 0x7f080098;
        public static final int abc_ratingbar_small_material = 0x7f080099;
        public static final int abc_scrubber_control_off_mtrl_alpha = 0x7f08009a;
        public static final int abc_scrubber_control_to_pressed_mtrl_000 = 0x7f08009b;
        public static final int abc_scrubber_control_to_pressed_mtrl_005 = 0x7f08009c;
        public static final int abc_scrubber_primary_mtrl_alpha = 0x7f08009d;
        public static final int abc_scrubber_track_mtrl_alpha = 0x7f08009e;
        public static final int abc_seekbar_thumb_material = 0x7f08009f;
        public static final int abc_seekbar_tick_mark_material = 0x7f0800a0;
        public static final int abc_seekbar_track_material = 0x7f0800a1;
        public static final int abc_spinner_mtrl_am_alpha = 0x7f0800a2;
        public static final int abc_spinner_textfield_background_material = 0x7f0800a3;
        public static final int abc_switch_thumb_material = 0x7f0800a4;
        public static final int abc_switch_track_mtrl_alpha = 0x7f0800a5;
        public static final int abc_tab_indicator_material = 0x7f0800a6;
        public static final int abc_tab_indicator_mtrl_alpha = 0x7f0800a7;
        public static final int abc_text_cursor_material = 0x7f0800a8;
        public static final int abc_text_select_handle_left_mtrl_dark = 0x7f0800a9;
        public static final int abc_text_select_handle_left_mtrl_light = 0x7f0800aa;
        public static final int abc_text_select_handle_middle_mtrl_dark = 0x7f0800ab;
        public static final int abc_text_select_handle_middle_mtrl_light = 0x7f0800ac;
        public static final int abc_text_select_handle_right_mtrl_dark = 0x7f0800ad;
        public static final int abc_text_select_handle_right_mtrl_light = 0x7f0800ae;
        public static final int abc_textfield_activated_mtrl_alpha = 0x7f0800af;
        public static final int abc_textfield_default_mtrl_alpha = 0x7f0800b0;
        public static final int abc_textfield_search_activated_mtrl_alpha = 0x7f0800b1;
        public static final int abc_textfield_search_default_mtrl_alpha = 0x7f0800b2;
        public static final int abc_textfield_search_material = 0x7f0800b3;
        public static final int abc_vector_test = 0x7f0800b4;
        public static final int bdcomment_emotion = 0x7f080218;
        public static final int btn_checkbox_checked_mtrl = 0x7f08037d;
        public static final int btn_checkbox_checked_to_unchecked_mtrl_animation = 0x7f08037e;
        public static final int btn_checkbox_unchecked_mtrl = 0x7f08037f;
        public static final int btn_checkbox_unchecked_to_checked_mtrl_animation = 0x7f080380;
        public static final int btn_radio_off_mtrl = 0x7f0803f2;
        public static final int btn_radio_off_to_on_mtrl_animation = 0x7f0803f3;
        public static final int btn_radio_on_mtrl = 0x7f0803f4;
        public static final int btn_radio_on_to_off_mtrl_animation = 0x7f0803f5;
        public static final int common_scrollbar_vertical = 0x7f080484;
        public static final int default_ptr_rotate = 0x7f0804a3;
        public static final int edit_text_cursor = 0x7f0804eb;
        public static final int emotion_del_btn_bg = 0x7f0804f0;
        public static final int emotion_delete = 0x7f0804f1;
        public static final int emotion_icon_selector = 0x7f0804f4;
        public static final int emotion_inputbox_background = 0x7f0804f5;
        public static final int emotion_vertical_long_pressed_bg = 0x7f0804fe;
        public static final int empty_icon_document = 0x7f0804ff;
        public static final int face_bottom = 0x7f080584;
        public static final int face_delete = 0x7f080586;
        public static final int invoice_default_select = 0x7f080c65;
        public static final int invoice_edit_img = 0x7f080c66;
        public static final int loading_progress = 0x7f080db8;
        public static final int loading_progress_animation = 0x7f080db9;
        public static final int menu_delete = 0x7f080de0;
        public static final int notification_action_background = 0x7f080eec;
        public static final int notification_bg = 0x7f080eed;
        public static final int notification_bg_low = 0x7f080eee;
        public static final int notification_bg_low_normal = 0x7f080eef;
        public static final int notification_bg_low_pressed = 0x7f080ef0;
        public static final int notification_bg_normal = 0x7f080ef1;
        public static final int notification_bg_normal_pressed = 0x7f080ef2;
        public static final int notification_icon_background = 0x7f080ef3;
        public static final int notification_template_icon_bg = 0x7f080ef4;
        public static final int notification_template_icon_low_bg = 0x7f080ef5;
        public static final int notification_tile_bg = 0x7f080ef6;
        public static final int notify_panel_notification_icon_bg = 0x7f080ef8;
        public static final int novel_loading_bg = 0x7f080efb;
        public static final int radio_button_checked = 0x7f08105f;
        public static final int radio_button_selector = 0x7f081060;
        public static final int radio_button_un_checked = 0x7f081061;
        public static final int tooltip_frame_dark = 0x7f0812ae;
        public static final int tooltip_frame_light = 0x7f0812af;
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

    /* loaded from: classes3.dex */
    public static final class id {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FILL = 0x7f09000a;
        public static final int STROKE = 0x7f09001c;
        public static final int accessibility_action_clickable_span = 0x7f090034;
        public static final int accessibility_custom_action_0 = 0x7f090035;
        public static final int accessibility_custom_action_1 = 0x7f090036;
        public static final int accessibility_custom_action_10 = 0x7f090037;
        public static final int accessibility_custom_action_11 = 0x7f090038;
        public static final int accessibility_custom_action_12 = 0x7f090039;
        public static final int accessibility_custom_action_13 = 0x7f09003a;
        public static final int accessibility_custom_action_14 = 0x7f09003b;
        public static final int accessibility_custom_action_15 = 0x7f09003c;
        public static final int accessibility_custom_action_16 = 0x7f09003d;
        public static final int accessibility_custom_action_17 = 0x7f09003e;
        public static final int accessibility_custom_action_18 = 0x7f09003f;
        public static final int accessibility_custom_action_19 = 0x7f090040;
        public static final int accessibility_custom_action_2 = 0x7f090041;
        public static final int accessibility_custom_action_20 = 0x7f090042;
        public static final int accessibility_custom_action_21 = 0x7f090043;
        public static final int accessibility_custom_action_22 = 0x7f090044;
        public static final int accessibility_custom_action_23 = 0x7f090045;
        public static final int accessibility_custom_action_24 = 0x7f090046;
        public static final int accessibility_custom_action_25 = 0x7f090047;
        public static final int accessibility_custom_action_26 = 0x7f090048;
        public static final int accessibility_custom_action_27 = 0x7f090049;
        public static final int accessibility_custom_action_28 = 0x7f09004a;
        public static final int accessibility_custom_action_29 = 0x7f09004b;
        public static final int accessibility_custom_action_3 = 0x7f09004c;
        public static final int accessibility_custom_action_30 = 0x7f09004d;
        public static final int accessibility_custom_action_31 = 0x7f09004e;
        public static final int accessibility_custom_action_4 = 0x7f09004f;
        public static final int accessibility_custom_action_5 = 0x7f090050;
        public static final int accessibility_custom_action_6 = 0x7f090051;
        public static final int accessibility_custom_action_7 = 0x7f090052;
        public static final int accessibility_custom_action_8 = 0x7f090053;
        public static final int accessibility_custom_action_9 = 0x7f090054;
        public static final int action_bar = 0x7f09005f;
        public static final int action_bar_activity_content = 0x7f090060;
        public static final int action_bar_container = 0x7f090061;
        public static final int action_bar_root = 0x7f090062;
        public static final int action_bar_spinner = 0x7f090063;
        public static final int action_bar_subtitle = 0x7f090064;
        public static final int action_bar_title = 0x7f090065;
        public static final int action_container = 0x7f090067;
        public static final int action_context_bar = 0x7f090068;
        public static final int action_divider = 0x7f090069;
        public static final int action_image = 0x7f09006b;
        public static final int action_menu_divider = 0x7f09006e;
        public static final int action_menu_presenter = 0x7f09006f;
        public static final int action_mode_bar = 0x7f090070;
        public static final int action_mode_bar_stub = 0x7f090071;
        public static final int action_mode_close_button = 0x7f090072;
        public static final int action_text = 0x7f090073;
        public static final int actions = 0x7f090074;
        public static final int activity_chooser_view_content = 0x7f090078;
        public static final int add = 0x7f090116;
        public static final int alertTitle = 0x7f09026a;
        public static final int async = 0x7f0902cd;
        public static final int blocking = 0x7f0903f7;
        public static final int buttonPanel = 0x7f0904f5;
        public static final int center = 0x7f090653;
        public static final int checkbox = 0x7f0906b0;
        public static final int checked = 0x7f0906b5;
        public static final int chronometer = 0x7f0906dd;
        public static final int content = 0x7f090782;
        public static final int contentPanel = 0x7f09078b;
        public static final int custom = 0x7f0907fa;
        public static final int customPanel = 0x7f0907fb;
        public static final int cw_0 = 0x7f09080d;
        public static final int cw_180 = 0x7f09080e;
        public static final int cw_270 = 0x7f09080f;
        public static final int cw_90 = 0x7f090810;
        public static final int decor_content_parent = 0x7f090826;
        public static final int default_activity_button = 0x7f090829;
        public static final int delete_btn = 0x7f090836;
        public static final int dialog_button = 0x7f090865;
        public static final int edit_query = 0x7f09093b;
        public static final int emotion_title = 0x7f090994;
        public static final int emotion_type_layout = 0x7f09093d;
        public static final int emotion_type_placeholer = 0x7f09093e;

        /* renamed from: empty */
        public static final int obfuscated = 0x7f09099c;

        /* renamed from: error */
        public static final int obfuscated = 0x7f0909e4;
        public static final int expand_activities_button = 0x7f090a40;
        public static final int expanded_menu = 0x7f090a4d;
        public static final int forever = 0x7f090b3e;
        public static final int gone = 0x7f090def;
        public static final int group_divider = 0x7f090e42;
        public static final int home = 0x7f090eda;
        public static final int icon = 0x7f090f68;
        public static final int icon_group = 0x7f090f70;
        public static final int icon_list = 0x7f090f74;
        public static final int image = 0x7f090fed;
        public static final int img_item = 0x7f09104d;
        public static final int immersion_fragment_root_view = 0x7f091081;

        /* renamed from: indicator */
        public static final int obfuscated = 0x7f09108a;
        public static final int info = 0x7f09108c;
        public static final int invisible = 0x7f0910ee;
        public static final int italic = 0x7f0910fc;
        public static final int item_touch_helper_previous_elevation = 0x7f09114b;
        public static final int left = 0x7f091428;
        public static final int line1 = 0x7f091478;
        public static final int line3 = 0x7f09147a;
        public static final int linear = 0x7f091486;
        public static final int listMode = 0x7f091494;
        public static final int list_item = 0x7f091499;

        /* renamed from: loading */
        public static final int obfuscated = 0x7f091583;
        public static final int message = 0x7f09168f;
        public static final int multiply = 0x7f09172f;
        public static final int none = 0x7f091876;
        public static final int normal = 0x7f09187c;
        public static final int notification_background = 0x7f091895;
        public static final int notification_main_column = 0x7f091897;
        public static final int notification_main_column_container = 0x7f091898;
        public static final int off = 0x7f0918ab;
        public static final int on = 0x7f0918c1;
        public static final int panel_root = 0x7f091920;
        public static final int parentPanel = 0x7f091923;
        public static final int progress_circular = 0x7f091c3f;
        public static final int progress_horizontal = 0x7f091c41;
        public static final int radial = 0x7f091cd5;
        public static final int radio = 0x7f091cd6;
        public static final int recycler_list = 0x7f091d4e;
        public static final int restart = 0x7f091da0;
        public static final int reverse = 0x7f091da5;
        public static final int right = 0x7f091dbc;
        public static final int right_icon = 0x7f091dd5;
        public static final int right_side = 0x7f091ddc;
        public static final int screen = 0x7f091f71;
        public static final int scrollIndicatorDown = 0x7f091f7b;
        public static final int scrollIndicatorUp = 0x7f091f7c;
        public static final int scrollView = 0x7f091f7d;
        public static final int search_badge = 0x7f091f8e;
        public static final int search_bar = 0x7f091f8f;
        public static final int search_button = 0x7f091f95;
        public static final int search_close_btn = 0x7f091f96;
        public static final int search_edit_frame = 0x7f091f99;
        public static final int search_go_btn = 0x7f091fa4;
        public static final int search_mag_icon = 0x7f091fb4;
        public static final int search_plate = 0x7f091fb6;
        public static final int search_src_text = 0x7f091fbf;
        public static final int search_voice_btn = 0x7f091fc9;
        public static final int select_dialog_listview = 0x7f091fef;
        public static final int shortcut = 0x7f092079;
        public static final int spacer = 0x7f0920e2;
        public static final int split_action_bar = 0x7f0920f9;
        public static final int src_atop = 0x7f09212e;
        public static final int src_in = 0x7f09212f;
        public static final int src_over = 0x7f092130;
        public static final int submenuarrow = 0x7f092173;
        public static final int submit_area = 0x7f092174;
        public static final int tabMode = 0x7f0921dc;
        public static final int tag_accessibility_actions = 0x7f092205;
        public static final int tag_accessibility_clickable_spans = 0x7f092206;
        public static final int tag_accessibility_heading = 0x7f092207;
        public static final int tag_accessibility_pane_title = 0x7f092208;
        public static final int tag_screen_reader_focusable = 0x7f09225c;
        public static final int tag_transition_group = 0x7f09226c;
        public static final int tag_unhandled_key_event_manager = 0x7f09226e;
        public static final int tag_unhandled_key_listeners = 0x7f09226f;
        public static final int text = 0x7f0922ef;
        public static final int text2 = 0x7f0922f0;
        public static final int textSpacerNoButtons = 0x7f0922f4;
        public static final int textSpacerNoTitle = 0x7f0922f5;
        public static final int time = 0x7f0923bd;
        public static final int title = 0x7f0923f2;
        public static final int titleDividerNoCustom = 0x7f0923f4;
        public static final int title_template = 0x7f09241d;
        public static final int topPanel = 0x7f092465;
        public static final int unchecked = 0x7f09265a;
        public static final int uniform = 0x7f09265f;
        public static final int up = 0x7f092667;
        public static final int view_pager = 0x7f0927ce;
        public static final int visible = 0x7f09280e;
        public static final int vp_emotion_type = 0x7f091fad;
        public static final int wrap_content = 0x7f0928b2;
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

    /* loaded from: classes3.dex */
    public static final class integer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int abc_config_activityDefaultDur = 0x7f0a0000;
        public static final int abc_config_activityShortDur = 0x7f0a0001;
        public static final int cancel_button_image_alpha = 0x7f0a0008;
        public static final int common_slide_anim_duration_back = 0x7f0a0009;
        public static final int common_slide_anim_duration_in = 0x7f0a000a;
        public static final int config_tooltipAnimTime = 0x7f0a000b;
        public static final int status_bar_notification_info_maxnum = 0x7f0a0027;
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

    /* loaded from: classes3.dex */
    public static final class interpolator {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int btn_checkbox_checked_mtrl_animation_interpolator_0 = 0x7f0c0000;
        public static final int btn_checkbox_checked_mtrl_animation_interpolator_1 = 0x7f0c0001;
        public static final int btn_checkbox_unchecked_mtrl_animation_interpolator_0 = 0x7f0c0002;
        public static final int btn_checkbox_unchecked_mtrl_animation_interpolator_1 = 0x7f0c0003;
        public static final int btn_radio_to_off_mtrl_animation_interpolator_0 = 0x7f0c0004;
        public static final int btn_radio_to_on_mtrl_animation_interpolator_0 = 0x7f0c0005;
        public static final int fast_out_slow_in = 0x7f0c0006;
        public transient /* synthetic */ FieldHolder $fh;

        public interpolator() {
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

    /* loaded from: classes3.dex */
    public static final class layout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int abc_action_bar_title_item = 0x7f0d0000;
        public static final int abc_action_bar_up_container = 0x7f0d0001;
        public static final int abc_action_menu_item_layout = 0x7f0d0002;
        public static final int abc_action_menu_layout = 0x7f0d0003;
        public static final int abc_action_mode_bar = 0x7f0d0004;
        public static final int abc_action_mode_close_item_material = 0x7f0d0005;
        public static final int abc_activity_chooser_view = 0x7f0d0006;
        public static final int abc_activity_chooser_view_list_item = 0x7f0d0007;
        public static final int abc_alert_dialog_button_bar_material = 0x7f0d0008;
        public static final int abc_alert_dialog_material = 0x7f0d0009;
        public static final int abc_alert_dialog_title_material = 0x7f0d000a;
        public static final int abc_cascading_menu_item_layout = 0x7f0d000b;
        public static final int abc_dialog_title_material = 0x7f0d000c;
        public static final int abc_expanded_menu_layout = 0x7f0d000d;
        public static final int abc_list_menu_item_checkbox = 0x7f0d000e;
        public static final int abc_list_menu_item_icon = 0x7f0d000f;
        public static final int abc_list_menu_item_layout = 0x7f0d0010;
        public static final int abc_list_menu_item_radio = 0x7f0d0011;
        public static final int abc_popup_menu_header_item_layout = 0x7f0d0012;
        public static final int abc_popup_menu_item_layout = 0x7f0d0013;
        public static final int abc_screen_content_include = 0x7f0d0014;
        public static final int abc_screen_simple = 0x7f0d0015;
        public static final int abc_screen_simple_overlay_action_mode = 0x7f0d0016;
        public static final int abc_screen_toolbar = 0x7f0d0017;
        public static final int abc_search_dropdown_item_icons_2line = 0x7f0d0018;
        public static final int abc_search_view = 0x7f0d0019;
        public static final int abc_select_dialog_material = 0x7f0d001a;
        public static final int abc_tooltip = 0x7f0d001b;
        public static final int bd_emotion_panel = 0x7f0d014e;
        public static final int custom_dialog = 0x7f0d021b;
        public static final int emotion_grid_item = 0x7f0d026e;
        public static final int emotion_only_include_panel_linearlayout = 0x7f0d0279;
        public static final int emotion_vertical_grid_item = 0x7f0d0284;
        public static final int emotion_vertical_long_pressed_layout = 0x7f0d0285;
        public static final int emotion_vertical_panel_icon = 0x7f0d0286;
        public static final int emotion_vertical_panel_page1_root = 0x7f0d0287;
        public static final int emotion_vertical_panel_root = 0x7f0d0288;
        public static final int emotion_vertical_panel_title = 0x7f0d0289;
        public static final int im_plugin_emotion_root_layout = 0x7f0d03ee;
        public static final int notification_action = 0x7f0d06bf;
        public static final int notification_action_tombstone = 0x7f0d06c0;
        public static final int notification_template_custom_big = 0x7f0d06c7;
        public static final int notification_template_icon_group = 0x7f0d06c8;
        public static final int notification_template_part_chronometer = 0x7f0d06cc;
        public static final int notification_template_part_time = 0x7f0d06cd;
        public static final int select_dialog_item_material = 0x7f0d0808;
        public static final int select_dialog_multichoice_material = 0x7f0d0809;
        public static final int select_dialog_singlechoice_material = 0x7f0d080a;
        public static final int support_simple_spinner_dropdown_item = 0x7f0d0875;
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

    /* loaded from: classes3.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int abc_action_bar_home_description = 0x7f0f003b;
        public static final int abc_action_bar_up_description = 0x7f0f003c;
        public static final int abc_action_menu_overflow_description = 0x7f0f003d;
        public static final int abc_action_mode_done = 0x7f0f003e;
        public static final int abc_activity_chooser_view_see_all = 0x7f0f003f;
        public static final int abc_activitychooserview_choose_application = 0x7f0f0040;
        public static final int abc_capital_off = 0x7f0f0041;
        public static final int abc_capital_on = 0x7f0f0042;
        public static final int abc_menu_alt_shortcut_label = 0x7f0f0043;
        public static final int abc_menu_ctrl_shortcut_label = 0x7f0f0044;
        public static final int abc_menu_delete_shortcut_label = 0x7f0f0045;
        public static final int abc_menu_enter_shortcut_label = 0x7f0f0046;
        public static final int abc_menu_function_shortcut_label = 0x7f0f0047;
        public static final int abc_menu_meta_shortcut_label = 0x7f0f0048;
        public static final int abc_menu_shift_shortcut_label = 0x7f0f0049;
        public static final int abc_menu_space_shortcut_label = 0x7f0f004a;
        public static final int abc_menu_sym_shortcut_label = 0x7f0f004b;
        public static final int abc_prepend_shortcut_label = 0x7f0f004c;
        public static final int abc_search_hint = 0x7f0f004d;
        public static final int abc_searchview_description_clear = 0x7f0f004e;
        public static final int abc_searchview_description_query = 0x7f0f004f;
        public static final int abc_searchview_description_search = 0x7f0f0050;
        public static final int abc_searchview_description_submit = 0x7f0f0051;
        public static final int abc_searchview_description_voice = 0x7f0f0052;
        public static final int abc_shareactionprovider_share_with = 0x7f0f0053;
        public static final int abc_shareactionprovider_share_with_application = 0x7f0f0054;
        public static final int abc_toolbar_collapse_description = 0x7f0f0055;
        public static final int activity_not_found = 0x7f0f0090;
        public static final int all_zone_title_default = 0x7f0f027d;
        public static final int app_name = 0x7f0f029e;
        public static final int cancel = 0x7f0f038d;
        public static final int close = 0x7f0f0421;
        public static final int delete = 0x7f0f04d9;
        public static final int deleting = 0x7f0f04f5;
        public static final int dialog_nagtive_button_text = 0x7f0f051f;
        public static final int dialog_positive_button_text = 0x7f0f0522;
        public static final int download_cancel = 0x7f0f0537;
        public static final int downloading = 0x7f0f0551;
        public static final int history_aiapp_tag = 0x7f0f08f7;
        public static final int invoice_bottom_edit = 0x7f0f0a1a;
        public static final int invoice_current_use = 0x7f0f0a1c;
        public static final int invoice_desc_bank = 0x7f0f0a1d;
        public static final int invoice_desc_bank_account = 0x7f0f0a1e;
        public static final int invoice_desc_company_address = 0x7f0f0a1f;
        public static final int invoice_desc_mobile = 0x7f0f0a20;
        public static final int invoice_desc_name = 0x7f0f0a21;
        public static final int invoice_desc_tax_number = 0x7f0f0a22;
        public static final int invoice_err_msg_name = 0x7f0f0a28;
        public static final int invoice_err_msg_personal_name = 0x7f0f0a29;
        public static final int invoice_err_msg_tax_number = 0x7f0f0a2a;
        public static final int invoice_hint_bank = 0x7f0f0a2c;
        public static final int invoice_hint_bank_account = 0x7f0f0a2d;
        public static final int invoice_hint_company_address = 0x7f0f0a2e;
        public static final int invoice_hint_mobile = 0x7f0f0a2f;
        public static final int invoice_hint_name = 0x7f0f0a30;
        public static final int invoice_hint_personal_name = 0x7f0f0a31;
        public static final int invoice_hint_tax_number = 0x7f0f0a32;
        public static final int invoice_top_company_tag = 0x7f0f0a37;
        public static final int invoice_top_personage_tag = 0x7f0f0a38;
        public static final int invoice_top_tax_number = 0x7f0f0a39;
        public static final int invoice_type = 0x7f0f0a3a;
        public static final int invoice_type_company = 0x7f0f0a3b;
        public static final int invoice_type_personal = 0x7f0f0a3c;
        public static final int liveshow_teletext_time_day_before = 0x7f0f0af7;
        public static final int liveshow_teletext_time_hour_before = 0x7f0f0af8;
        public static final int liveshow_teletext_time_min_before = 0x7f0f0af9;
        public static final int liveshow_teletext_time_sec_before = 0x7f0f0afa;
        public static final int often_zone_title_default = 0x7f0f0dc0;
        public static final int ok = 0x7f0f0dc1;
        public static final int picture_image_loading = 0x7f0f0f68;
        public static final int privacy_policy = 0x7f0f0fe2;
        public static final int save = 0x7f0f1161;
        public static final int search_menu_title = 0x7f0f11a1;
        public static final int share = 0x7f0f1208;
        public static final int status_bar_notification_info_overflow = 0x7f0f12dd;
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

    /* loaded from: classes3.dex */
    public static final class style {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AlertDialog_AppCompat = 0x7f100003;
        public static final int AlertDialog_AppCompat_Light = 0x7f100004;
        public static final int Animation_AppCompat_Dialog = 0x7f100006;
        public static final int Animation_AppCompat_DropDownUp = 0x7f100007;
        public static final int Animation_AppCompat_Tooltip = 0x7f100008;
        public static final int Base_AlertDialog_AppCompat = 0x7f100011;
        public static final int Base_AlertDialog_AppCompat_Light = 0x7f100012;
        public static final int Base_Animation_AppCompat_Dialog = 0x7f100013;
        public static final int Base_Animation_AppCompat_DropDownUp = 0x7f100014;
        public static final int Base_Animation_AppCompat_Tooltip = 0x7f100015;
        public static final int Base_CardView = 0x7f100016;
        public static final int Base_DialogWindowTitleBackground_AppCompat = 0x7f100018;
        public static final int Base_DialogWindowTitle_AppCompat = 0x7f100017;
        public static final int Base_TextAppearance_AppCompat = 0x7f10001c;
        public static final int Base_TextAppearance_AppCompat_Body1 = 0x7f10001d;
        public static final int Base_TextAppearance_AppCompat_Body2 = 0x7f10001e;
        public static final int Base_TextAppearance_AppCompat_Button = 0x7f10001f;
        public static final int Base_TextAppearance_AppCompat_Caption = 0x7f100020;
        public static final int Base_TextAppearance_AppCompat_Display1 = 0x7f100021;
        public static final int Base_TextAppearance_AppCompat_Display2 = 0x7f100022;
        public static final int Base_TextAppearance_AppCompat_Display3 = 0x7f100023;
        public static final int Base_TextAppearance_AppCompat_Display4 = 0x7f100024;
        public static final int Base_TextAppearance_AppCompat_Headline = 0x7f100025;
        public static final int Base_TextAppearance_AppCompat_Inverse = 0x7f100026;
        public static final int Base_TextAppearance_AppCompat_Large = 0x7f100027;
        public static final int Base_TextAppearance_AppCompat_Large_Inverse = 0x7f100028;
        public static final int Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Large = 0x7f100029;
        public static final int Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Small = 0x7f10002a;
        public static final int Base_TextAppearance_AppCompat_Medium = 0x7f10002b;
        public static final int Base_TextAppearance_AppCompat_Medium_Inverse = 0x7f10002c;
        public static final int Base_TextAppearance_AppCompat_Menu = 0x7f10002d;
        public static final int Base_TextAppearance_AppCompat_SearchResult = 0x7f10002e;
        public static final int Base_TextAppearance_AppCompat_SearchResult_Subtitle = 0x7f10002f;
        public static final int Base_TextAppearance_AppCompat_SearchResult_Title = 0x7f100030;
        public static final int Base_TextAppearance_AppCompat_Small = 0x7f100031;
        public static final int Base_TextAppearance_AppCompat_Small_Inverse = 0x7f100032;
        public static final int Base_TextAppearance_AppCompat_Subhead = 0x7f100033;
        public static final int Base_TextAppearance_AppCompat_Subhead_Inverse = 0x7f100034;
        public static final int Base_TextAppearance_AppCompat_Title = 0x7f100035;
        public static final int Base_TextAppearance_AppCompat_Title_Inverse = 0x7f100036;
        public static final int Base_TextAppearance_AppCompat_Tooltip = 0x7f100037;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Menu = 0x7f100038;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle = 0x7f100039;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse = 0x7f10003a;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Title = 0x7f10003b;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse = 0x7f10003c;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionMode_Subtitle = 0x7f10003d;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionMode_Title = 0x7f10003e;
        public static final int Base_TextAppearance_AppCompat_Widget_Button = 0x7f10003f;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Borderless_Colored = 0x7f100040;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Colored = 0x7f100041;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Inverse = 0x7f100042;
        public static final int Base_TextAppearance_AppCompat_Widget_DropDownItem = 0x7f100043;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Header = 0x7f100044;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Large = 0x7f100045;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Small = 0x7f100046;
        public static final int Base_TextAppearance_AppCompat_Widget_Switch = 0x7f100047;
        public static final int Base_TextAppearance_AppCompat_Widget_TextView_SpinnerItem = 0x7f100048;
        public static final int Base_TextAppearance_Widget_AppCompat_ExpandedMenu_Item = 0x7f10004d;
        public static final int Base_TextAppearance_Widget_AppCompat_Toolbar_Subtitle = 0x7f10004e;
        public static final int Base_TextAppearance_Widget_AppCompat_Toolbar_Title = 0x7f10004f;
        public static final int Base_ThemeOverlay_AppCompat = 0x7f100071;
        public static final int Base_ThemeOverlay_AppCompat_ActionBar = 0x7f100072;
        public static final int Base_ThemeOverlay_AppCompat_Dark = 0x7f100073;
        public static final int Base_ThemeOverlay_AppCompat_Dark_ActionBar = 0x7f100074;
        public static final int Base_ThemeOverlay_AppCompat_Dialog = 0x7f100075;
        public static final int Base_ThemeOverlay_AppCompat_Dialog_Alert = 0x7f100076;
        public static final int Base_ThemeOverlay_AppCompat_Light = 0x7f100077;
        public static final int Base_Theme_AppCompat = 0x7f100050;
        public static final int Base_Theme_AppCompat_CompactMenu = 0x7f100051;
        public static final int Base_Theme_AppCompat_Dialog = 0x7f100052;
        public static final int Base_Theme_AppCompat_DialogWhenLarge = 0x7f100056;
        public static final int Base_Theme_AppCompat_Dialog_Alert = 0x7f100053;
        public static final int Base_Theme_AppCompat_Dialog_FixedSize = 0x7f100054;
        public static final int Base_Theme_AppCompat_Dialog_MinWidth = 0x7f100055;
        public static final int Base_Theme_AppCompat_Light = 0x7f100057;
        public static final int Base_Theme_AppCompat_Light_DarkActionBar = 0x7f100058;
        public static final int Base_Theme_AppCompat_Light_Dialog = 0x7f100059;
        public static final int Base_Theme_AppCompat_Light_DialogWhenLarge = 0x7f10005d;
        public static final int Base_Theme_AppCompat_Light_Dialog_Alert = 0x7f10005a;
        public static final int Base_Theme_AppCompat_Light_Dialog_FixedSize = 0x7f10005b;
        public static final int Base_Theme_AppCompat_Light_Dialog_MinWidth = 0x7f10005c;
        public static final int Base_V21_ThemeOverlay_AppCompat_Dialog = 0x7f100091;
        public static final int Base_V21_Theme_AppCompat = 0x7f100089;
        public static final int Base_V21_Theme_AppCompat_Dialog = 0x7f10008a;
        public static final int Base_V21_Theme_AppCompat_Light = 0x7f10008b;
        public static final int Base_V21_Theme_AppCompat_Light_Dialog = 0x7f10008c;
        public static final int Base_V22_Theme_AppCompat = 0x7f100092;
        public static final int Base_V22_Theme_AppCompat_Light = 0x7f100093;
        public static final int Base_V23_Theme_AppCompat = 0x7f100094;
        public static final int Base_V23_Theme_AppCompat_Light = 0x7f100095;
        public static final int Base_V26_Theme_AppCompat = 0x7f100096;
        public static final int Base_V26_Theme_AppCompat_Light = 0x7f100097;
        public static final int Base_V26_Widget_AppCompat_Toolbar = 0x7f100098;
        public static final int Base_V28_Theme_AppCompat = 0x7f100099;
        public static final int Base_V28_Theme_AppCompat_Light = 0x7f10009a;
        public static final int Base_V7_ThemeOverlay_AppCompat_Dialog = 0x7f10009f;
        public static final int Base_V7_Theme_AppCompat = 0x7f10009b;
        public static final int Base_V7_Theme_AppCompat_Dialog = 0x7f10009c;
        public static final int Base_V7_Theme_AppCompat_Light = 0x7f10009d;
        public static final int Base_V7_Theme_AppCompat_Light_Dialog = 0x7f10009e;
        public static final int Base_V7_Widget_AppCompat_AutoCompleteTextView = 0x7f1000a0;
        public static final int Base_V7_Widget_AppCompat_EditText = 0x7f1000a1;
        public static final int Base_V7_Widget_AppCompat_Toolbar = 0x7f1000a2;
        public static final int Base_Widget_AppCompat_ActionBar = 0x7f1000a3;
        public static final int Base_Widget_AppCompat_ActionBar_Solid = 0x7f1000a4;
        public static final int Base_Widget_AppCompat_ActionBar_TabBar = 0x7f1000a5;
        public static final int Base_Widget_AppCompat_ActionBar_TabText = 0x7f1000a6;
        public static final int Base_Widget_AppCompat_ActionBar_TabView = 0x7f1000a7;
        public static final int Base_Widget_AppCompat_ActionButton = 0x7f1000a8;
        public static final int Base_Widget_AppCompat_ActionButton_CloseMode = 0x7f1000a9;
        public static final int Base_Widget_AppCompat_ActionButton_Overflow = 0x7f1000aa;
        public static final int Base_Widget_AppCompat_ActionMode = 0x7f1000ab;
        public static final int Base_Widget_AppCompat_ActivityChooserView = 0x7f1000ac;
        public static final int Base_Widget_AppCompat_AutoCompleteTextView = 0x7f1000ad;
        public static final int Base_Widget_AppCompat_Button = 0x7f1000ae;
        public static final int Base_Widget_AppCompat_ButtonBar = 0x7f1000b4;
        public static final int Base_Widget_AppCompat_ButtonBar_AlertDialog = 0x7f1000b5;
        public static final int Base_Widget_AppCompat_Button_Borderless = 0x7f1000af;
        public static final int Base_Widget_AppCompat_Button_Borderless_Colored = 0x7f1000b0;
        public static final int Base_Widget_AppCompat_Button_ButtonBar_AlertDialog = 0x7f1000b1;
        public static final int Base_Widget_AppCompat_Button_Colored = 0x7f1000b2;
        public static final int Base_Widget_AppCompat_Button_Small = 0x7f1000b3;
        public static final int Base_Widget_AppCompat_CompoundButton_CheckBox = 0x7f1000b6;
        public static final int Base_Widget_AppCompat_CompoundButton_RadioButton = 0x7f1000b7;
        public static final int Base_Widget_AppCompat_CompoundButton_Switch = 0x7f1000b8;
        public static final int Base_Widget_AppCompat_DrawerArrowToggle = 0x7f1000b9;
        public static final int Base_Widget_AppCompat_DrawerArrowToggle_Common = 0x7f1000ba;
        public static final int Base_Widget_AppCompat_DropDownItem_Spinner = 0x7f1000bb;
        public static final int Base_Widget_AppCompat_EditText = 0x7f1000bc;
        public static final int Base_Widget_AppCompat_ImageButton = 0x7f1000bd;
        public static final int Base_Widget_AppCompat_Light_ActionBar = 0x7f1000be;
        public static final int Base_Widget_AppCompat_Light_ActionBar_Solid = 0x7f1000bf;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabBar = 0x7f1000c0;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabText = 0x7f1000c1;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabText_Inverse = 0x7f1000c2;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabView = 0x7f1000c3;
        public static final int Base_Widget_AppCompat_Light_PopupMenu = 0x7f1000c4;
        public static final int Base_Widget_AppCompat_Light_PopupMenu_Overflow = 0x7f1000c5;
        public static final int Base_Widget_AppCompat_ListMenuView = 0x7f1000c6;
        public static final int Base_Widget_AppCompat_ListPopupWindow = 0x7f1000c7;
        public static final int Base_Widget_AppCompat_ListView = 0x7f1000c8;
        public static final int Base_Widget_AppCompat_ListView_DropDown = 0x7f1000c9;
        public static final int Base_Widget_AppCompat_ListView_Menu = 0x7f1000ca;
        public static final int Base_Widget_AppCompat_PopupMenu = 0x7f1000cb;
        public static final int Base_Widget_AppCompat_PopupMenu_Overflow = 0x7f1000cc;
        public static final int Base_Widget_AppCompat_PopupWindow = 0x7f1000cd;
        public static final int Base_Widget_AppCompat_ProgressBar = 0x7f1000ce;
        public static final int Base_Widget_AppCompat_ProgressBar_Horizontal = 0x7f1000cf;
        public static final int Base_Widget_AppCompat_RatingBar = 0x7f1000d0;
        public static final int Base_Widget_AppCompat_RatingBar_Indicator = 0x7f1000d1;
        public static final int Base_Widget_AppCompat_RatingBar_Small = 0x7f1000d2;
        public static final int Base_Widget_AppCompat_SearchView = 0x7f1000d3;
        public static final int Base_Widget_AppCompat_SearchView_ActionBar = 0x7f1000d5;
        public static final int Base_Widget_AppCompat_SeekBar = 0x7f1000d8;
        public static final int Base_Widget_AppCompat_SeekBar_Discrete = 0x7f1000da;
        public static final int Base_Widget_AppCompat_Spinner = 0x7f1000db;
        public static final int Base_Widget_AppCompat_Spinner_Underlined = 0x7f1000dc;
        public static final int Base_Widget_AppCompat_TextView = 0x7f1000de;
        public static final int Base_Widget_AppCompat_TextView_SpinnerItem = 0x7f1000df;
        public static final int Base_Widget_AppCompat_Toolbar = 0x7f1000e0;
        public static final int Base_Widget_AppCompat_Toolbar_Button_Navigation = 0x7f1000e1;
        public static final int BdWaitingDialog = 0x7f1000f8;
        public static final int CardView = 0x7f1000fe;
        public static final int CardView_Dark = 0x7f1000ff;
        public static final int CardView_Light = 0x7f100100;
        public static final int EbpayActivityAnim = 0x7f100110;

        /* renamed from: Panel */
        public static final int obfuscated_res_0x7f1000fd = 0x7f1000fd;
        public static final int Platform_AppCompat = 0x7f10015e;
        public static final int Platform_AppCompat_Light = 0x7f10015f;
        public static final int Platform_ThemeOverlay_AppCompat = 0x7f100164;
        public static final int Platform_ThemeOverlay_AppCompat_Dark = 0x7f100165;
        public static final int Platform_ThemeOverlay_AppCompat_Light = 0x7f100166;
        public static final int Platform_V21_AppCompat = 0x7f100167;
        public static final int Platform_V21_AppCompat_Light = 0x7f100168;
        public static final int Platform_V25_AppCompat = 0x7f100169;
        public static final int Platform_V25_AppCompat_Light = 0x7f10016a;
        public static final int Platform_Widget_AppCompat_Spinner = 0x7f10016b;

        /* renamed from: PopupWindow_DropDownDown */
        public static final int obfuscated_res_0x7f10016e = 0x7f10016e;

        /* renamed from: PopupWindow_DropDownUp */
        public static final int obfuscated_res_0x7f10016f = 0x7f10016f;
        public static final int RtlOverlay_DialogWindowTitle_AppCompat = 0x7f100171;
        public static final int RtlOverlay_Widget_AppCompat_ActionBar_TitleItem = 0x7f100172;
        public static final int RtlOverlay_Widget_AppCompat_DialogTitle_Icon = 0x7f100173;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem = 0x7f100174;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_InternalGroup = 0x7f100175;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_Shortcut = 0x7f100176;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_SubmenuArrow = 0x7f100177;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_Text = 0x7f100178;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_Title = 0x7f100179;
        public static final int RtlOverlay_Widget_AppCompat_SearchView_MagIcon = 0x7f10017f;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown = 0x7f10017a;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Icon1 = 0x7f10017b;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Icon2 = 0x7f10017c;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Query = 0x7f10017d;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Text = 0x7f10017e;
        public static final int RtlUnderlay_Widget_AppCompat_ActionButton = 0x7f100180;
        public static final int RtlUnderlay_Widget_AppCompat_ActionButton_Overflow = 0x7f100181;
        public static final int TextAppearance_AppCompat = 0x7f1001c2;
        public static final int TextAppearance_AppCompat_Body1 = 0x7f1001c3;
        public static final int TextAppearance_AppCompat_Body2 = 0x7f1001c4;
        public static final int TextAppearance_AppCompat_Button = 0x7f1001c5;
        public static final int TextAppearance_AppCompat_Caption = 0x7f1001c6;
        public static final int TextAppearance_AppCompat_Display1 = 0x7f1001c7;
        public static final int TextAppearance_AppCompat_Display2 = 0x7f1001c8;
        public static final int TextAppearance_AppCompat_Display3 = 0x7f1001c9;
        public static final int TextAppearance_AppCompat_Display4 = 0x7f1001ca;
        public static final int TextAppearance_AppCompat_Headline = 0x7f1001cb;
        public static final int TextAppearance_AppCompat_Inverse = 0x7f1001cc;
        public static final int TextAppearance_AppCompat_Large = 0x7f1001cd;
        public static final int TextAppearance_AppCompat_Large_Inverse = 0x7f1001ce;
        public static final int TextAppearance_AppCompat_Light_SearchResult_Subtitle = 0x7f1001cf;
        public static final int TextAppearance_AppCompat_Light_SearchResult_Title = 0x7f1001d0;
        public static final int TextAppearance_AppCompat_Light_Widget_PopupMenu_Large = 0x7f1001d1;
        public static final int TextAppearance_AppCompat_Light_Widget_PopupMenu_Small = 0x7f1001d3;
        public static final int TextAppearance_AppCompat_Medium = 0x7f1001d4;
        public static final int TextAppearance_AppCompat_Medium_Inverse = 0x7f1001d5;
        public static final int TextAppearance_AppCompat_Menu = 0x7f1001d6;
        public static final int TextAppearance_AppCompat_SearchResult_Subtitle = 0x7f1001d7;
        public static final int TextAppearance_AppCompat_SearchResult_Title = 0x7f1001d8;
        public static final int TextAppearance_AppCompat_Small = 0x7f1001d9;
        public static final int TextAppearance_AppCompat_Small_Inverse = 0x7f1001da;
        public static final int TextAppearance_AppCompat_Subhead = 0x7f1001db;
        public static final int TextAppearance_AppCompat_Subhead_Inverse = 0x7f1001dc;
        public static final int TextAppearance_AppCompat_Title = 0x7f1001dd;
        public static final int TextAppearance_AppCompat_Title_Inverse = 0x7f1001de;
        public static final int TextAppearance_AppCompat_Tooltip = 0x7f1001df;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Menu = 0x7f1001e0;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Subtitle = 0x7f1001e1;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse = 0x7f1001e2;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Title = 0x7f1001e3;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse = 0x7f1001e4;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Subtitle = 0x7f1001e5;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Subtitle_Inverse = 0x7f1001e6;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Title = 0x7f1001e9;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Title_Inverse = 0x7f1001ea;
        public static final int TextAppearance_AppCompat_Widget_Button = 0x7f1001eb;
        public static final int TextAppearance_AppCompat_Widget_Button_Borderless_Colored = 0x7f1001ec;
        public static final int TextAppearance_AppCompat_Widget_Button_Colored = 0x7f1001ed;
        public static final int TextAppearance_AppCompat_Widget_Button_Inverse = 0x7f1001ee;
        public static final int TextAppearance_AppCompat_Widget_DropDownItem = 0x7f1001ef;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Header = 0x7f1001f0;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Large = 0x7f1001f1;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Small = 0x7f1001f2;
        public static final int TextAppearance_AppCompat_Widget_Switch = 0x7f1001f3;
        public static final int TextAppearance_AppCompat_Widget_TextView_SpinnerItem = 0x7f1001f4;
        public static final int TextAppearance_Compat_Notification = 0x7f1001f5;
        public static final int TextAppearance_Compat_Notification_Info = 0x7f1001f6;
        public static final int TextAppearance_Compat_Notification_Line2 = 0x7f1001f8;
        public static final int TextAppearance_Compat_Notification_Time = 0x7f1001fb;
        public static final int TextAppearance_Compat_Notification_Title = 0x7f1001fd;
        public static final int TextAppearance_Widget_AppCompat_ExpandedMenu_Item = 0x7f10021d;
        public static final int TextAppearance_Widget_AppCompat_Toolbar_Subtitle = 0x7f10021e;
        public static final int TextAppearance_Widget_AppCompat_Toolbar_Title = 0x7f10021f;
        public static final int ThemeOverlay_AppCompat = 0x7f100276;
        public static final int ThemeOverlay_AppCompat_ActionBar = 0x7f100277;
        public static final int ThemeOverlay_AppCompat_Dark = 0x7f100278;
        public static final int ThemeOverlay_AppCompat_Dark_ActionBar = 0x7f100279;
        public static final int ThemeOverlay_AppCompat_DayNight = 0x7f10027a;
        public static final int ThemeOverlay_AppCompat_DayNight_ActionBar = 0x7f10027b;
        public static final int ThemeOverlay_AppCompat_Dialog = 0x7f10027c;
        public static final int ThemeOverlay_AppCompat_Dialog_Alert = 0x7f10027d;
        public static final int ThemeOverlay_AppCompat_Light = 0x7f10027e;
        public static final int Theme_AppCompat = 0x7f100221;
        public static final int Theme_AppCompat_CompactMenu = 0x7f100222;
        public static final int Theme_AppCompat_DayNight = 0x7f100223;
        public static final int Theme_AppCompat_DayNight_DarkActionBar = 0x7f100224;
        public static final int Theme_AppCompat_DayNight_Dialog = 0x7f100225;
        public static final int Theme_AppCompat_DayNight_DialogWhenLarge = 0x7f100228;
        public static final int Theme_AppCompat_DayNight_Dialog_Alert = 0x7f100226;
        public static final int Theme_AppCompat_DayNight_Dialog_MinWidth = 0x7f100227;
        public static final int Theme_AppCompat_DayNight_NoActionBar = 0x7f100229;
        public static final int Theme_AppCompat_Dialog = 0x7f10022a;
        public static final int Theme_AppCompat_DialogWhenLarge = 0x7f10022e;
        public static final int Theme_AppCompat_Dialog_Alert = 0x7f10022b;
        public static final int Theme_AppCompat_Dialog_MinWidth = 0x7f10022d;
        public static final int Theme_AppCompat_Light = 0x7f100230;
        public static final int Theme_AppCompat_Light_DarkActionBar = 0x7f100231;
        public static final int Theme_AppCompat_Light_Dialog = 0x7f100232;
        public static final int Theme_AppCompat_Light_DialogWhenLarge = 0x7f100235;
        public static final int Theme_AppCompat_Light_Dialog_Alert = 0x7f100233;
        public static final int Theme_AppCompat_Light_Dialog_MinWidth = 0x7f100234;
        public static final int Theme_AppCompat_Light_NoActionBar = 0x7f100236;
        public static final int Theme_AppCompat_NoActionBar = 0x7f100237;
        public static final int Widget_AppCompat_ActionBar = 0x7f1002c4;
        public static final int Widget_AppCompat_ActionBar_Solid = 0x7f1002c7;
        public static final int Widget_AppCompat_ActionBar_TabBar = 0x7f1002c8;
        public static final int Widget_AppCompat_ActionBar_TabText = 0x7f1002c9;
        public static final int Widget_AppCompat_ActionBar_TabView = 0x7f1002ca;
        public static final int Widget_AppCompat_ActionButton = 0x7f1002cb;
        public static final int Widget_AppCompat_ActionButton_CloseMode = 0x7f1002cc;
        public static final int Widget_AppCompat_ActionButton_Overflow = 0x7f1002cd;
        public static final int Widget_AppCompat_ActionMode = 0x7f1002ce;
        public static final int Widget_AppCompat_ActivityChooserView = 0x7f1002cf;
        public static final int Widget_AppCompat_AutoCompleteTextView = 0x7f1002d0;
        public static final int Widget_AppCompat_Button = 0x7f1002d1;
        public static final int Widget_AppCompat_ButtonBar = 0x7f1002dc;
        public static final int Widget_AppCompat_ButtonBar_AlertDialog = 0x7f1002dd;
        public static final int Widget_AppCompat_Button_Borderless = 0x7f1002d6;
        public static final int Widget_AppCompat_Button_Borderless_Colored = 0x7f1002d7;
        public static final int Widget_AppCompat_Button_ButtonBar_AlertDialog = 0x7f1002d8;
        public static final int Widget_AppCompat_Button_Colored = 0x7f1002da;
        public static final int Widget_AppCompat_Button_Small = 0x7f1002db;
        public static final int Widget_AppCompat_CompoundButton_CheckBox = 0x7f1002de;
        public static final int Widget_AppCompat_CompoundButton_RadioButton = 0x7f1002df;
        public static final int Widget_AppCompat_CompoundButton_Switch = 0x7f1002e0;
        public static final int Widget_AppCompat_DrawerArrowToggle = 0x7f1002e1;
        public static final int Widget_AppCompat_DropDownItem_Spinner = 0x7f1002e2;
        public static final int Widget_AppCompat_EditText = 0x7f1002e3;
        public static final int Widget_AppCompat_ImageButton = 0x7f1002e4;
        public static final int Widget_AppCompat_Light_ActionBar = 0x7f1002e5;
        public static final int Widget_AppCompat_Light_ActionBar_Solid = 0x7f1002e6;
        public static final int Widget_AppCompat_Light_ActionBar_Solid_Inverse = 0x7f1002e7;
        public static final int Widget_AppCompat_Light_ActionBar_TabBar = 0x7f1002e8;
        public static final int Widget_AppCompat_Light_ActionBar_TabBar_Inverse = 0x7f1002e9;
        public static final int Widget_AppCompat_Light_ActionBar_TabText = 0x7f1002ea;
        public static final int Widget_AppCompat_Light_ActionBar_TabText_Inverse = 0x7f1002eb;
        public static final int Widget_AppCompat_Light_ActionBar_TabView = 0x7f1002ec;
        public static final int Widget_AppCompat_Light_ActionBar_TabView_Inverse = 0x7f1002ed;
        public static final int Widget_AppCompat_Light_ActionButton = 0x7f1002ee;
        public static final int Widget_AppCompat_Light_ActionButton_CloseMode = 0x7f1002ef;
        public static final int Widget_AppCompat_Light_ActionButton_Overflow = 0x7f1002f0;
        public static final int Widget_AppCompat_Light_ActionMode_Inverse = 0x7f1002f1;
        public static final int Widget_AppCompat_Light_ActivityChooserView = 0x7f1002f2;
        public static final int Widget_AppCompat_Light_AutoCompleteTextView = 0x7f1002f3;
        public static final int Widget_AppCompat_Light_DropDownItem_Spinner = 0x7f100310;
        public static final int Widget_AppCompat_Light_ListPopupWindow = 0x7f100311;
        public static final int Widget_AppCompat_Light_ListView_DropDown = 0x7f100312;
        public static final int Widget_AppCompat_Light_PopupMenu = 0x7f100313;
        public static final int Widget_AppCompat_Light_PopupMenu_Overflow = 0x7f100314;
        public static final int Widget_AppCompat_Light_SearchView = 0x7f100315;
        public static final int Widget_AppCompat_Light_Spinner_DropDown_ActionBar = 0x7f100316;
        public static final int Widget_AppCompat_ListMenuView = 0x7f100317;
        public static final int Widget_AppCompat_ListPopupWindow = 0x7f100318;
        public static final int Widget_AppCompat_ListView = 0x7f100319;
        public static final int Widget_AppCompat_ListView_DropDown = 0x7f10031a;
        public static final int Widget_AppCompat_ListView_Menu = 0x7f10031b;
        public static final int Widget_AppCompat_PopupMenu = 0x7f10031c;
        public static final int Widget_AppCompat_PopupMenu_Overflow = 0x7f10031d;
        public static final int Widget_AppCompat_PopupWindow = 0x7f10031e;
        public static final int Widget_AppCompat_ProgressBar = 0x7f10031f;
        public static final int Widget_AppCompat_ProgressBar_Horizontal = 0x7f100320;
        public static final int Widget_AppCompat_RatingBar = 0x7f100321;
        public static final int Widget_AppCompat_RatingBar_Indicator = 0x7f100322;
        public static final int Widget_AppCompat_RatingBar_Small = 0x7f100323;
        public static final int Widget_AppCompat_SearchView = 0x7f100324;
        public static final int Widget_AppCompat_SearchView_ActionBar = 0x7f100325;
        public static final int Widget_AppCompat_SeekBar = 0x7f100326;
        public static final int Widget_AppCompat_SeekBar_Discrete = 0x7f100327;
        public static final int Widget_AppCompat_Spinner = 0x7f100329;
        public static final int Widget_AppCompat_Spinner_DropDown = 0x7f10032a;
        public static final int Widget_AppCompat_Spinner_DropDown_ActionBar = 0x7f10032b;
        public static final int Widget_AppCompat_Spinner_Underlined = 0x7f100330;
        public static final int Widget_AppCompat_TextView = 0x7f100331;
        public static final int Widget_AppCompat_TextView_SpinnerItem = 0x7f100332;
        public static final int Widget_AppCompat_Toolbar = 0x7f100333;
        public static final int Widget_AppCompat_Toolbar_Button_Navigation = 0x7f100334;
        public static final int Widget_Compat_NotificationActionContainer = 0x7f100335;
        public static final int Widget_Compat_NotificationActionText = 0x7f100336;

        /* renamed from: big_pic_animation */
        public static final int obfuscated_res_0x7f1003aa = 0x7f1003aa;

        /* renamed from: highlight_toast_animation */
        public static final int obfuscated_res_0x7f1003c0 = 0x7f1003c0;
        public static final int pop_window_anim = 0x7f1003e3;
        public static final int toast_animation = 0x7f100425;
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

    /* loaded from: classes3.dex */
    public static final class styleable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] AbsSpinner;
        public static final int AbsSpinner_entriesArray = 0x00000000;
        public static final int[] ActionBar;
        public static final int[] ActionBarLayout;
        public static final int ActionBarLayout_android_layout_gravity = 0x00000000;
        public static final int ActionBar_background = 0x00000000;
        public static final int ActionBar_backgroundSplit = 0x00000001;
        public static final int ActionBar_backgroundStacked = 0x00000002;
        public static final int ActionBar_contentInsetEnd = 0x00000003;
        public static final int ActionBar_contentInsetEndWithActions = 0x00000004;
        public static final int ActionBar_contentInsetLeft = 0x00000005;
        public static final int ActionBar_contentInsetRight = 0x00000006;
        public static final int ActionBar_contentInsetStart = 0x00000007;
        public static final int ActionBar_contentInsetStartWithNavigation = 0x00000008;
        public static final int ActionBar_customNavigationLayout = 0x00000009;
        public static final int ActionBar_displayOptions = 0x0000000a;
        public static final int ActionBar_divider = 0x0000000b;
        public static final int ActionBar_elevation = 0x0000000c;
        public static final int ActionBar_height = 0x0000000d;
        public static final int ActionBar_hideOnContentScroll = 0x0000000e;
        public static final int ActionBar_homeAsUpIndicator = 0x0000000f;
        public static final int ActionBar_homeLayout = 0x00000010;
        public static final int ActionBar_icon = 0x00000011;
        public static final int ActionBar_indeterminateProgressStyle = 0x00000012;
        public static final int ActionBar_itemPadding = 0x00000013;
        public static final int ActionBar_logo = 0x00000014;
        public static final int ActionBar_navigationMode = 0x00000015;
        public static final int ActionBar_popupTheme = 0x00000016;
        public static final int ActionBar_progressBarPadding = 0x00000017;
        public static final int ActionBar_progressBarStyle = 0x00000018;
        public static final int ActionBar_subtitle = 0x00000019;
        public static final int ActionBar_subtitleTextStyle = 0x0000001a;
        public static final int ActionBar_title = 0x0000001b;
        public static final int ActionBar_titleTextStyle = 0x0000001c;
        public static final int[] ActionMenuItemView;
        public static final int ActionMenuItemView_android_minWidth = 0x00000000;
        public static final int[] ActionMenuView;
        public static final int[] ActionMode;
        public static final int ActionMode_background = 0x00000000;
        public static final int ActionMode_backgroundSplit = 0x00000001;
        public static final int ActionMode_closeItemLayout = 0x00000002;
        public static final int ActionMode_height = 0x00000003;
        public static final int ActionMode_subtitleTextStyle = 0x00000004;
        public static final int ActionMode_titleTextStyle = 0x00000005;
        public static final int[] ActivityChooserView;
        public static final int ActivityChooserView_expandActivityOverflowButtonDrawable = 0x00000000;
        public static final int ActivityChooserView_initialActivityCount = 0x00000001;
        public static final int[] AlertDialog;
        public static final int AlertDialog_android_layout = 0x00000000;
        public static final int AlertDialog_buttonIconDimen = 0x00000001;
        public static final int AlertDialog_buttonPanelSideLayout = 0x00000002;
        public static final int AlertDialog_listItemLayout = 0x00000003;
        public static final int AlertDialog_listLayout = 0x00000004;
        public static final int AlertDialog_multiChoiceItemLayout = 0x00000005;
        public static final int AlertDialog_showTitle = 0x00000006;
        public static final int AlertDialog_singleChoiceItemLayout = 0x00000007;
        public static final int[] AnimatedStateListDrawableCompat;
        public static final int AnimatedStateListDrawableCompat_android_constantSize = 0x00000003;
        public static final int AnimatedStateListDrawableCompat_android_dither = 0x00000000;
        public static final int AnimatedStateListDrawableCompat_android_enterFadeDuration = 0x00000004;
        public static final int AnimatedStateListDrawableCompat_android_exitFadeDuration = 0x00000005;
        public static final int AnimatedStateListDrawableCompat_android_variablePadding = 0x00000002;
        public static final int AnimatedStateListDrawableCompat_android_visible = 0x00000001;
        public static final int[] AnimatedStateListDrawableItem;
        public static final int AnimatedStateListDrawableItem_android_drawable = 0x00000001;
        public static final int AnimatedStateListDrawableItem_android_id = 0x00000000;
        public static final int[] AnimatedStateListDrawableTransition;
        public static final int AnimatedStateListDrawableTransition_android_drawable = 0x00000000;
        public static final int AnimatedStateListDrawableTransition_android_fromId = 0x00000002;
        public static final int AnimatedStateListDrawableTransition_android_reversible = 0x00000003;
        public static final int AnimatedStateListDrawableTransition_android_toId = 0x00000001;
        public static final int[] AppCompatImageView;
        public static final int AppCompatImageView_android_src = 0x00000000;
        public static final int AppCompatImageView_srcCompat = 0x00000001;
        public static final int AppCompatImageView_tint = 0x00000002;
        public static final int AppCompatImageView_tintMode = 0x00000003;
        public static final int[] AppCompatSeekBar;
        public static final int AppCompatSeekBar_android_thumb = 0x00000000;
        public static final int AppCompatSeekBar_tickMark = 0x00000001;
        public static final int AppCompatSeekBar_tickMarkTint = 0x00000002;
        public static final int AppCompatSeekBar_tickMarkTintMode = 0x00000003;
        public static final int[] AppCompatTextHelper;
        public static final int AppCompatTextHelper_android_drawableBottom = 0x00000002;
        public static final int AppCompatTextHelper_android_drawableEnd = 0x00000006;
        public static final int AppCompatTextHelper_android_drawableLeft = 0x00000003;
        public static final int AppCompatTextHelper_android_drawableRight = 0x00000004;
        public static final int AppCompatTextHelper_android_drawableStart = 0x00000005;
        public static final int AppCompatTextHelper_android_drawableTop = 0x00000001;
        public static final int AppCompatTextHelper_android_textAppearance = 0x00000000;
        public static final int[] AppCompatTextView;
        public static final int AppCompatTextView_android_textAppearance = 0x00000000;
        public static final int AppCompatTextView_autoSizeMaxTextSize = 0x00000001;
        public static final int AppCompatTextView_autoSizeMinTextSize = 0x00000002;
        public static final int AppCompatTextView_autoSizePresetSizes = 0x00000003;
        public static final int AppCompatTextView_autoSizeStepGranularity = 0x00000004;
        public static final int AppCompatTextView_autoSizeTextType = 0x00000005;
        public static final int AppCompatTextView_drawableBottomCompat = 0x00000006;
        public static final int AppCompatTextView_drawableEndCompat = 0x00000007;
        public static final int AppCompatTextView_drawableLeftCompat = 0x00000008;
        public static final int AppCompatTextView_drawableRightCompat = 0x00000009;
        public static final int AppCompatTextView_drawableStartCompat = 0x0000000a;
        public static final int AppCompatTextView_drawableTint = 0x0000000b;
        public static final int AppCompatTextView_drawableTintMode = 0x0000000c;
        public static final int AppCompatTextView_drawableTopCompat = 0x0000000d;
        public static final int AppCompatTextView_firstBaselineToTopHeight = 0x0000000e;
        public static final int AppCompatTextView_fontFamily = 0x0000000f;
        public static final int AppCompatTextView_fontVariationSettings = 0x00000010;
        public static final int AppCompatTextView_lastBaselineToBottomHeight = 0x00000011;
        public static final int AppCompatTextView_lineHeight = 0x00000012;
        public static final int AppCompatTextView_textAllCaps = 0x00000013;
        public static final int AppCompatTextView_textLocale = 0x00000014;
        public static final int[] AppCompatTheme;
        public static final int AppCompatTheme_actionBarDivider = 0x00000002;
        public static final int AppCompatTheme_actionBarItemBackground = 0x00000003;
        public static final int AppCompatTheme_actionBarPopupTheme = 0x00000004;
        public static final int AppCompatTheme_actionBarSize = 0x00000005;
        public static final int AppCompatTheme_actionBarSplitStyle = 0x00000006;
        public static final int AppCompatTheme_actionBarStyle = 0x00000007;
        public static final int AppCompatTheme_actionBarTabBarStyle = 0x00000008;
        public static final int AppCompatTheme_actionBarTabStyle = 0x00000009;
        public static final int AppCompatTheme_actionBarTabTextStyle = 0x0000000a;
        public static final int AppCompatTheme_actionBarTheme = 0x0000000b;
        public static final int AppCompatTheme_actionBarWidgetTheme = 0x0000000c;
        public static final int AppCompatTheme_actionButtonStyle = 0x0000000d;
        public static final int AppCompatTheme_actionDropDownStyle = 0x0000000e;
        public static final int AppCompatTheme_actionMenuTextAppearance = 0x0000000f;
        public static final int AppCompatTheme_actionMenuTextColor = 0x00000010;
        public static final int AppCompatTheme_actionModeBackground = 0x00000011;
        public static final int AppCompatTheme_actionModeCloseButtonStyle = 0x00000012;
        public static final int AppCompatTheme_actionModeCloseDrawable = 0x00000013;
        public static final int AppCompatTheme_actionModeCopyDrawable = 0x00000014;
        public static final int AppCompatTheme_actionModeCutDrawable = 0x00000015;
        public static final int AppCompatTheme_actionModeFindDrawable = 0x00000016;
        public static final int AppCompatTheme_actionModePasteDrawable = 0x00000017;
        public static final int AppCompatTheme_actionModePopupWindowStyle = 0x00000018;
        public static final int AppCompatTheme_actionModeSelectAllDrawable = 0x00000019;
        public static final int AppCompatTheme_actionModeShareDrawable = 0x0000001a;
        public static final int AppCompatTheme_actionModeSplitBackground = 0x0000001b;
        public static final int AppCompatTheme_actionModeStyle = 0x0000001c;
        public static final int AppCompatTheme_actionModeWebSearchDrawable = 0x0000001d;
        public static final int AppCompatTheme_actionOverflowButtonStyle = 0x0000001e;
        public static final int AppCompatTheme_actionOverflowMenuStyle = 0x0000001f;
        public static final int AppCompatTheme_activityChooserViewStyle = 0x00000020;
        public static final int AppCompatTheme_alertDialogButtonGroupStyle = 0x00000021;
        public static final int AppCompatTheme_alertDialogCenterButtons = 0x00000022;
        public static final int AppCompatTheme_alertDialogStyle = 0x00000023;
        public static final int AppCompatTheme_alertDialogTheme = 0x00000024;
        public static final int AppCompatTheme_android_windowAnimationStyle = 0x00000001;
        public static final int AppCompatTheme_android_windowIsFloating = 0x00000000;
        public static final int AppCompatTheme_autoCompleteTextViewStyle = 0x00000025;
        public static final int AppCompatTheme_borderlessButtonStyle = 0x00000026;
        public static final int AppCompatTheme_buttonBarButtonStyle = 0x00000027;
        public static final int AppCompatTheme_buttonBarNegativeButtonStyle = 0x00000028;
        public static final int AppCompatTheme_buttonBarNeutralButtonStyle = 0x00000029;
        public static final int AppCompatTheme_buttonBarPositiveButtonStyle = 0x0000002a;
        public static final int AppCompatTheme_buttonBarStyle = 0x0000002b;
        public static final int AppCompatTheme_buttonStyle = 0x0000002c;
        public static final int AppCompatTheme_buttonStyleSmall = 0x0000002d;
        public static final int AppCompatTheme_checkboxStyle = 0x0000002e;
        public static final int AppCompatTheme_checkedTextViewStyle = 0x0000002f;
        public static final int AppCompatTheme_colorAccent = 0x00000030;
        public static final int AppCompatTheme_colorBackgroundFloating = 0x00000031;
        public static final int AppCompatTheme_colorButtonNormal = 0x00000032;
        public static final int AppCompatTheme_colorControlActivated = 0x00000033;
        public static final int AppCompatTheme_colorControlHighlight = 0x00000034;
        public static final int AppCompatTheme_colorControlNormal = 0x00000035;
        public static final int AppCompatTheme_colorError = 0x00000036;
        public static final int AppCompatTheme_colorPrimary = 0x00000037;
        public static final int AppCompatTheme_colorPrimaryDark = 0x00000038;
        public static final int AppCompatTheme_colorSwitchThumbNormal = 0x00000039;
        public static final int AppCompatTheme_controlBackground = 0x0000003a;
        public static final int AppCompatTheme_dialogCornerRadius = 0x0000003b;
        public static final int AppCompatTheme_dialogPreferredPadding = 0x0000003c;
        public static final int AppCompatTheme_dialogTheme = 0x0000003d;
        public static final int AppCompatTheme_dividerHorizontal = 0x0000003e;
        public static final int AppCompatTheme_dividerVertical = 0x0000003f;
        public static final int AppCompatTheme_dropDownListViewStyle = 0x00000040;
        public static final int AppCompatTheme_dropdownListPreferredItemHeight = 0x00000041;
        public static final int AppCompatTheme_editTextBackground = 0x00000042;
        public static final int AppCompatTheme_editTextColor = 0x00000043;
        public static final int AppCompatTheme_editTextStyle = 0x00000044;
        public static final int AppCompatTheme_homeAsUpIndicator = 0x00000045;
        public static final int AppCompatTheme_imageButtonStyle = 0x00000046;
        public static final int AppCompatTheme_listChoiceBackgroundIndicator = 0x00000047;
        public static final int AppCompatTheme_listChoiceIndicatorMultipleAnimated = 0x00000048;
        public static final int AppCompatTheme_listChoiceIndicatorSingleAnimated = 0x00000049;
        public static final int AppCompatTheme_listDividerAlertDialog = 0x0000004a;
        public static final int AppCompatTheme_listMenuViewStyle = 0x0000004b;
        public static final int AppCompatTheme_listPopupWindowStyle = 0x0000004c;
        public static final int AppCompatTheme_listPreferredItemHeight = 0x0000004d;
        public static final int AppCompatTheme_listPreferredItemHeightLarge = 0x0000004e;
        public static final int AppCompatTheme_listPreferredItemHeightSmall = 0x0000004f;
        public static final int AppCompatTheme_listPreferredItemPaddingEnd = 0x00000050;
        public static final int AppCompatTheme_listPreferredItemPaddingLeft = 0x00000051;
        public static final int AppCompatTheme_listPreferredItemPaddingRight = 0x00000052;
        public static final int AppCompatTheme_listPreferredItemPaddingStart = 0x00000053;
        public static final int AppCompatTheme_panelBackground = 0x00000054;
        public static final int AppCompatTheme_panelMenuListTheme = 0x00000055;
        public static final int AppCompatTheme_panelMenuListWidth = 0x00000056;
        public static final int AppCompatTheme_popupMenuStyle = 0x00000057;
        public static final int AppCompatTheme_popupWindowStyle = 0x00000058;
        public static final int AppCompatTheme_radioButtonStyle = 0x00000059;
        public static final int AppCompatTheme_ratingBarStyle = 0x0000005a;
        public static final int AppCompatTheme_ratingBarStyleIndicator = 0x0000005b;
        public static final int AppCompatTheme_ratingBarStyleSmall = 0x0000005c;
        public static final int AppCompatTheme_searchViewStyle = 0x0000005d;
        public static final int AppCompatTheme_seekBarStyle = 0x0000005e;
        public static final int AppCompatTheme_selectableItemBackground = 0x0000005f;
        public static final int AppCompatTheme_selectableItemBackgroundBorderless = 0x00000060;
        public static final int AppCompatTheme_spinnerDropDownItemStyle = 0x00000061;
        public static final int AppCompatTheme_spinnerStyle = 0x00000062;
        public static final int AppCompatTheme_switchStyle = 0x00000063;
        public static final int AppCompatTheme_textAppearanceLargePopupMenu = 0x00000064;
        public static final int AppCompatTheme_textAppearanceListItem = 0x00000065;
        public static final int AppCompatTheme_textAppearanceListItemSecondary = 0x00000066;
        public static final int AppCompatTheme_textAppearanceListItemSmall = 0x00000067;
        public static final int AppCompatTheme_textAppearancePopupMenuHeader = 0x00000068;
        public static final int AppCompatTheme_textAppearanceSearchResultSubtitle = 0x00000069;
        public static final int AppCompatTheme_textAppearanceSearchResultTitle = 0x0000006a;
        public static final int AppCompatTheme_textAppearanceSmallPopupMenu = 0x0000006b;
        public static final int AppCompatTheme_textColorAlertDialogListItem = 0x0000006c;
        public static final int AppCompatTheme_textColorSearchUrl = 0x0000006d;
        public static final int AppCompatTheme_toolbarNavigationButtonStyle = 0x0000006e;
        public static final int AppCompatTheme_toolbarStyle = 0x0000006f;
        public static final int AppCompatTheme_tooltipForegroundColor = 0x00000070;
        public static final int AppCompatTheme_tooltipFrameBackground = 0x00000071;
        public static final int AppCompatTheme_viewInflaterClass = 0x00000072;
        public static final int AppCompatTheme_windowActionBar = 0x00000073;
        public static final int AppCompatTheme_windowActionBarOverlay = 0x00000074;
        public static final int AppCompatTheme_windowActionModeOverlay = 0x00000075;
        public static final int AppCompatTheme_windowFixedHeightMajor = 0x00000076;
        public static final int AppCompatTheme_windowFixedHeightMinor = 0x00000077;
        public static final int AppCompatTheme_windowFixedWidthMajor = 0x00000078;
        public static final int AppCompatTheme_windowFixedWidthMinor = 0x00000079;
        public static final int AppCompatTheme_windowMinWidthMajor = 0x0000007a;
        public static final int AppCompatTheme_windowMinWidthMinor = 0x0000007b;
        public static final int AppCompatTheme_windowNoTitle = 0x0000007c;
        public static final int[] ButtonBarLayout;
        public static final int ButtonBarLayout_allowStacking = 0x00000000;
        public static final int[] ColorStateListItem;
        public static final int ColorStateListItem_alpha = 0x00000002;
        public static final int ColorStateListItem_android_alpha = 0x00000001;
        public static final int ColorStateListItem_android_color = 0x00000000;
        public static final int[] CompoundButton;
        public static final int CompoundButton_android_button = 0x00000000;
        public static final int CompoundButton_buttonCompat = 0x00000001;
        public static final int CompoundButton_buttonTint = 0x00000002;
        public static final int CompoundButton_buttonTintMode = 0x00000003;
        public static final int[] DrawerArrowToggle;
        public static final int DrawerArrowToggle_arrowHeadLength = 0x00000000;
        public static final int DrawerArrowToggle_arrowShaftLength = 0x00000001;
        public static final int DrawerArrowToggle_barLength = 0x00000002;
        public static final int DrawerArrowToggle_color = 0x00000003;
        public static final int DrawerArrowToggle_drawableSize = 0x00000004;
        public static final int DrawerArrowToggle_gapBetweenBars = 0x00000005;
        public static final int DrawerArrowToggle_spinBars = 0x00000006;
        public static final int DrawerArrowToggle_thickness = 0x00000007;
        public static final int[] FontFamily;
        public static final int[] FontFamilyFont;
        public static final int FontFamilyFont_android_font = 0x00000000;
        public static final int FontFamilyFont_android_fontStyle = 0x00000002;
        public static final int FontFamilyFont_android_fontVariationSettings = 0x00000004;
        public static final int FontFamilyFont_android_fontWeight = 0x00000001;
        public static final int FontFamilyFont_android_ttcIndex = 0x00000003;
        public static final int FontFamilyFont_font = 0x00000005;
        public static final int FontFamilyFont_fontStyle = 0x00000006;
        public static final int FontFamilyFont_fontVariationSettings = 0x00000007;
        public static final int FontFamilyFont_fontWeight = 0x00000008;
        public static final int FontFamilyFont_ttcIndex = 0x00000009;
        public static final int FontFamily_fontProviderAuthority = 0x00000000;
        public static final int FontFamily_fontProviderCerts = 0x00000001;
        public static final int FontFamily_fontProviderFetchStrategy = 0x00000002;
        public static final int FontFamily_fontProviderFetchTimeout = 0x00000003;
        public static final int FontFamily_fontProviderPackage = 0x00000004;
        public static final int FontFamily_fontProviderQuery = 0x00000005;
        public static final int FontFamily_fontProviderSystemFontFamily = 0x00000006;
        public static final int[] Gallery;
        public static final int Gallery_animationDuration = 0x00000000;
        public static final int Gallery_spacing = 0x00000001;
        public static final int Gallery_swan_gravity = 0x00000002;
        public static final int Gallery_unselectedAlpha = 0x00000003;
        public static final int[] GradientColor;
        public static final int[] GradientColorItem;
        public static final int GradientColorItem_android_color = 0x00000000;
        public static final int GradientColorItem_android_offset = 0x00000001;
        public static final int GradientColor_android_centerColor = 0x00000007;
        public static final int GradientColor_android_centerX = 0x00000003;
        public static final int GradientColor_android_centerY = 0x00000004;
        public static final int GradientColor_android_endColor = 0x00000001;
        public static final int GradientColor_android_endX = 0x0000000a;
        public static final int GradientColor_android_endY = 0x0000000b;
        public static final int GradientColor_android_gradientRadius = 0x00000005;
        public static final int GradientColor_android_startColor = 0x00000000;
        public static final int GradientColor_android_startX = 0x00000008;
        public static final int GradientColor_android_startY = 0x00000009;
        public static final int GradientColor_android_tileMode = 0x00000006;
        public static final int GradientColor_android_type = 0x00000002;
        public static final int[] LinearLayoutCompat;
        public static final int[] LinearLayoutCompat_Layout;
        public static final int LinearLayoutCompat_Layout_android_layout_gravity = 0x00000000;
        public static final int LinearLayoutCompat_Layout_android_layout_height = 0x00000002;
        public static final int LinearLayoutCompat_Layout_android_layout_weight = 0x00000003;
        public static final int LinearLayoutCompat_Layout_android_layout_width = 0x00000001;
        public static final int LinearLayoutCompat_android_baselineAligned = 0x00000002;
        public static final int LinearLayoutCompat_android_baselineAlignedChildIndex = 0x00000003;
        public static final int LinearLayoutCompat_android_gravity = 0x00000000;
        public static final int LinearLayoutCompat_android_orientation = 0x00000001;
        public static final int LinearLayoutCompat_android_weightSum = 0x00000004;
        public static final int LinearLayoutCompat_divider = 0x00000005;
        public static final int LinearLayoutCompat_dividerPadding = 0x00000006;
        public static final int LinearLayoutCompat_measureWithLargestChild = 0x00000007;
        public static final int LinearLayoutCompat_showDividers = 0x00000008;
        public static final int[] ListPopupWindow;
        public static final int ListPopupWindow_android_dropDownHorizontalOffset = 0x00000000;
        public static final int ListPopupWindow_android_dropDownVerticalOffset = 0x00000001;
        public static final int[] MenuGroup;
        public static final int MenuGroup_android_checkableBehavior = 0x00000005;
        public static final int MenuGroup_android_enabled = 0x00000000;
        public static final int MenuGroup_android_id = 0x00000001;
        public static final int MenuGroup_android_menuCategory = 0x00000003;
        public static final int MenuGroup_android_orderInCategory = 0x00000004;
        public static final int MenuGroup_android_visible = 0x00000002;
        public static final int[] MenuItem;
        public static final int MenuItem_actionLayout = 0x0000000d;
        public static final int MenuItem_actionProviderClass = 0x0000000e;
        public static final int MenuItem_actionViewClass = 0x0000000f;
        public static final int MenuItem_alphabeticModifiers = 0x00000010;
        public static final int MenuItem_android_alphabeticShortcut = 0x00000009;
        public static final int MenuItem_android_checkable = 0x0000000b;
        public static final int MenuItem_android_checked = 0x00000003;
        public static final int MenuItem_android_enabled = 0x00000001;
        public static final int MenuItem_android_icon = 0x00000000;
        public static final int MenuItem_android_id = 0x00000002;
        public static final int MenuItem_android_menuCategory = 0x00000005;
        public static final int MenuItem_android_numericShortcut = 0x0000000a;
        public static final int MenuItem_android_onClick = 0x0000000c;
        public static final int MenuItem_android_orderInCategory = 0x00000006;
        public static final int MenuItem_android_title = 0x00000007;
        public static final int MenuItem_android_titleCondensed = 0x00000008;
        public static final int MenuItem_android_visible = 0x00000004;
        public static final int MenuItem_contentDescription = 0x00000011;
        public static final int MenuItem_iconTint = 0x00000012;
        public static final int MenuItem_iconTintMode = 0x00000013;
        public static final int MenuItem_numericModifiers = 0x00000014;
        public static final int MenuItem_showAsAction = 0x00000015;
        public static final int MenuItem_tooltipText = 0x00000016;
        public static final int[] MenuView;
        public static final int MenuView_android_headerBackground = 0x00000004;
        public static final int MenuView_android_horizontalDivider = 0x00000002;
        public static final int MenuView_android_itemBackground = 0x00000005;
        public static final int MenuView_android_itemIconDisabledAlpha = 0x00000006;
        public static final int MenuView_android_itemTextAppearance = 0x00000001;
        public static final int MenuView_android_verticalDivider = 0x00000003;
        public static final int MenuView_android_windowAnimationStyle = 0x00000000;
        public static final int MenuView_preserveIconSpacing = 0x00000007;
        public static final int MenuView_subMenuArrow = 0x00000008;
        public static final int[] PartingLineView;
        public static final int PartingLineView_bgBorderColor = 0x00000000;
        public static final int PartingLineView_bgBorderWidth = 0x00000001;
        public static final int PartingLineView_bgNormalColor = 0x00000002;
        public static final int PartingLineView_bgPressedColor = 0x00000003;
        public static final int PartingLineView_dividerArcRadius = 0x00000004;
        public static final int PartingLineView_dividerLineColor = 0x00000005;
        public static final int PartingLineView_dividerLineHeight = 0x00000006;
        public static final int[] PopupWindow;
        public static final int[] PopupWindowBackgroundState;
        public static final int PopupWindowBackgroundState_state_above_anchor = 0x00000000;
        public static final int PopupWindow_android_popupAnimationStyle = 0x00000001;
        public static final int PopupWindow_android_popupBackground = 0x00000000;
        public static final int PopupWindow_overlapAnchor = 0x00000002;
        public static final int PopupWindow_popupAnimationStyle = 0x00000003;
        public static final int PopupWindow_popupBackground = 0x00000004;
        public static final int[] RecycleListView;
        public static final int RecycleListView_paddingBottomNoButtons = 0x00000000;
        public static final int RecycleListView_paddingTopNoTitle = 0x00000001;
        public static final int[] RecyclerView;
        public static final int RecyclerView_android_clipToPadding = 0x00000001;
        public static final int RecyclerView_android_descendantFocusability = 0x00000002;
        public static final int RecyclerView_android_orientation = 0x00000000;
        public static final int RecyclerView_fastScrollEnabled = 0x00000003;
        public static final int RecyclerView_fastScrollHorizontalThumbDrawable = 0x00000004;
        public static final int RecyclerView_fastScrollHorizontalTrackDrawable = 0x00000005;
        public static final int RecyclerView_fastScrollVerticalThumbDrawable = 0x00000006;
        public static final int RecyclerView_fastScrollVerticalTrackDrawable = 0x00000007;
        public static final int RecyclerView_layoutManager = 0x00000008;
        public static final int RecyclerView_reverseLayout = 0x00000009;
        public static final int RecyclerView_spanCount = 0x0000000a;
        public static final int RecyclerView_stackFromEnd = 0x0000000b;
        public static final int[] RoundProgressBar;
        public static final int RoundProgressBar_roundColor = 0x00000000;
        public static final int RoundProgressBar_roundMax = 0x00000001;
        public static final int RoundProgressBar_roundProgressColor = 0x00000002;
        public static final int RoundProgressBar_roundStyle = 0x00000003;
        public static final int RoundProgressBar_roundTextColor = 0x00000004;
        public static final int RoundProgressBar_roundTextIsDisplayable = 0x00000005;
        public static final int RoundProgressBar_roundTextSize = 0x00000006;
        public static final int RoundProgressBar_roundWidth = 0x00000007;
        public static final int RoundProgressBar_style = 0x00000008;
        public static final int RoundProgressBar_textIsDisplayable = 0x00000009;
        public static final int[] RoundedImageView;
        public static final int RoundedImageView_android_scaleType = 0x00000000;
        public static final int RoundedImageView_border_color = 0x00000001;
        public static final int RoundedImageView_border_width = 0x00000002;
        public static final int RoundedImageView_corner_radius = 0x00000003;
        public static final int RoundedImageView_round_background = 0x00000004;
        public static final int[] SearchView;
        public static final int SearchView_android_focusable = 0x00000000;
        public static final int SearchView_android_imeOptions = 0x00000003;
        public static final int SearchView_android_inputType = 0x00000002;
        public static final int SearchView_android_maxWidth = 0x00000001;
        public static final int SearchView_closeIcon = 0x00000004;
        public static final int SearchView_commitIcon = 0x00000005;
        public static final int SearchView_defaultQueryHint = 0x00000006;
        public static final int SearchView_goIcon = 0x00000007;
        public static final int SearchView_iconifiedByDefault = 0x00000008;
        public static final int SearchView_layout = 0x00000009;
        public static final int SearchView_queryBackground = 0x0000000a;
        public static final int SearchView_queryHint = 0x0000000b;
        public static final int SearchView_searchHintIcon = 0x0000000c;
        public static final int SearchView_searchIcon = 0x0000000d;
        public static final int SearchView_submitBackground = 0x0000000e;
        public static final int SearchView_suggestionRowLayout = 0x0000000f;
        public static final int SearchView_voiceIcon = 0x00000010;
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
        public static final int ShimmerFrameLayout_shimmer_shape = 0x0000000d;
        public static final int ShimmerFrameLayout_tilt = 0x0000000e;
        public static final int[] Spinner;
        public static final int Spinner_android_dropDownWidth = 0x00000003;
        public static final int Spinner_android_entries = 0x00000000;
        public static final int Spinner_android_popupBackground = 0x00000001;
        public static final int Spinner_android_prompt = 0x00000002;
        public static final int Spinner_popupTheme = 0x00000004;
        public static final int[] StateListDrawable;
        public static final int[] StateListDrawableItem;
        public static final int StateListDrawableItem_android_drawable = 0x00000000;
        public static final int StateListDrawable_android_constantSize = 0x00000003;
        public static final int StateListDrawable_android_dither = 0x00000000;
        public static final int StateListDrawable_android_enterFadeDuration = 0x00000004;
        public static final int StateListDrawable_android_exitFadeDuration = 0x00000005;
        public static final int StateListDrawable_android_variablePadding = 0x00000002;
        public static final int StateListDrawable_android_visible = 0x00000001;
        public static final int[] SwitchCompat;
        public static final int SwitchCompat_android_textOff = 0x00000001;
        public static final int SwitchCompat_android_textOn = 0x00000000;
        public static final int SwitchCompat_android_thumb = 0x00000002;
        public static final int SwitchCompat_showText = 0x00000003;
        public static final int SwitchCompat_splitTrack = 0x00000004;
        public static final int SwitchCompat_switchMinWidth = 0x00000005;
        public static final int SwitchCompat_switchPadding = 0x00000006;
        public static final int SwitchCompat_switchTextAppearance = 0x00000007;
        public static final int SwitchCompat_thumbTextPadding = 0x00000008;
        public static final int SwitchCompat_thumbTint = 0x00000009;
        public static final int SwitchCompat_thumbTintMode = 0x0000000a;
        public static final int SwitchCompat_track = 0x0000000b;
        public static final int SwitchCompat_trackTint = 0x0000000c;
        public static final int SwitchCompat_trackTintMode = 0x0000000d;
        public static final int[] TabLayout;
        public static final int TabLayout_tabBackground = 0x00000000;
        public static final int TabLayout_tabContentStart = 0x00000001;
        public static final int TabLayout_tabGravity = 0x00000002;
        public static final int TabLayout_tabIconTint = 0x00000003;
        public static final int TabLayout_tabIconTintMode = 0x00000004;
        public static final int TabLayout_tabIndicator = 0x00000005;
        public static final int TabLayout_tabIndicatorAnimationDuration = 0x00000006;
        public static final int TabLayout_tabIndicatorColor = 0x00000007;
        public static final int TabLayout_tabIndicatorFullWidth = 0x00000008;
        public static final int TabLayout_tabIndicatorGravity = 0x00000009;
        public static final int TabLayout_tabIndicatorHeight = 0x0000000a;
        public static final int TabLayout_tabInlineLabel = 0x0000000b;
        public static final int TabLayout_tabMaxWidth = 0x0000000c;
        public static final int TabLayout_tabMinWidth = 0x0000000d;
        public static final int TabLayout_tabMode = 0x0000000e;
        public static final int TabLayout_tabPadding = 0x0000000f;
        public static final int TabLayout_tabPaddingBottom = 0x00000010;
        public static final int TabLayout_tabPaddingEnd = 0x00000011;
        public static final int TabLayout_tabPaddingStart = 0x00000012;
        public static final int TabLayout_tabPaddingTop = 0x00000013;
        public static final int TabLayout_tabRippleColor = 0x00000014;
        public static final int TabLayout_tabSelectedTextColor = 0x00000015;
        public static final int TabLayout_tabTextAppearance = 0x00000016;
        public static final int TabLayout_tabTextColor = 0x00000017;
        public static final int TabLayout_tabUnboundedRipple = 0x00000018;
        public static final int[] TextAppearance;
        public static final int TextAppearance_android_fontFamily = 0x0000000a;
        public static final int TextAppearance_android_shadowColor = 0x00000006;
        public static final int TextAppearance_android_shadowDx = 0x00000007;
        public static final int TextAppearance_android_shadowDy = 0x00000008;
        public static final int TextAppearance_android_shadowRadius = 0x00000009;
        public static final int TextAppearance_android_textColor = 0x00000003;
        public static final int TextAppearance_android_textColorHint = 0x00000004;
        public static final int TextAppearance_android_textColorLink = 0x00000005;
        public static final int TextAppearance_android_textFontWeight = 0x0000000b;
        public static final int TextAppearance_android_textSize = 0x00000000;
        public static final int TextAppearance_android_textStyle = 0x00000002;
        public static final int TextAppearance_android_typeface = 0x00000001;
        public static final int TextAppearance_fontFamily = 0x0000000c;
        public static final int TextAppearance_fontVariationSettings = 0x0000000d;
        public static final int TextAppearance_textAllCaps = 0x0000000e;
        public static final int TextAppearance_textLocale = 0x0000000f;
        public static final int[] Toolbar;
        public static final int Toolbar_android_gravity = 0x00000000;
        public static final int Toolbar_android_minHeight = 0x00000001;
        public static final int Toolbar_buttonGravity = 0x00000002;
        public static final int Toolbar_collapseContentDescription = 0x00000003;
        public static final int Toolbar_collapseIcon = 0x00000004;
        public static final int Toolbar_contentInsetEnd = 0x00000005;
        public static final int Toolbar_contentInsetEndWithActions = 0x00000006;
        public static final int Toolbar_contentInsetLeft = 0x00000007;
        public static final int Toolbar_contentInsetRight = 0x00000008;
        public static final int Toolbar_contentInsetStart = 0x00000009;
        public static final int Toolbar_contentInsetStartWithNavigation = 0x0000000a;
        public static final int Toolbar_logo = 0x0000000b;
        public static final int Toolbar_logoDescription = 0x0000000c;
        public static final int Toolbar_maxButtonHeight = 0x0000000d;
        public static final int Toolbar_menu = 0x0000000e;
        public static final int Toolbar_navigationContentDescription = 0x0000000f;
        public static final int Toolbar_navigationIcon = 0x00000010;
        public static final int Toolbar_popupTheme = 0x00000011;
        public static final int Toolbar_subtitle = 0x00000012;
        public static final int Toolbar_subtitleTextAppearance = 0x00000013;
        public static final int Toolbar_subtitleTextColor = 0x00000014;
        public static final int Toolbar_title = 0x00000015;
        public static final int Toolbar_titleMargin = 0x00000016;
        public static final int Toolbar_titleMarginBottom = 0x00000017;
        public static final int Toolbar_titleMarginEnd = 0x00000018;
        public static final int Toolbar_titleMarginStart = 0x00000019;
        public static final int Toolbar_titleMarginTop = 0x0000001a;
        public static final int Toolbar_titleMargins = 0x0000001b;
        public static final int Toolbar_titleTextAppearance = 0x0000001c;
        public static final int Toolbar_titleTextColor = 0x0000001d;
        public static final int[] View;
        public static final int[] ViewBackgroundHelper;
        public static final int ViewBackgroundHelper_android_background = 0x00000000;
        public static final int ViewBackgroundHelper_backgroundTint = 0x00000001;
        public static final int ViewBackgroundHelper_backgroundTintMode = 0x00000002;
        public static final int[] ViewStubCompat;
        public static final int ViewStubCompat_android_id = 0x00000000;
        public static final int ViewStubCompat_android_inflatedId = 0x00000002;
        public static final int ViewStubCompat_android_layout = 0x00000001;
        public static final int View_accessibilityFocusable = 0x00000002;
        public static final int View_alpha = 0x00000003;
        public static final int View_android_focusable = 0x00000001;
        public static final int View_android_theme = 0x00000000;
        public static final int View_clickable = 0x00000004;
        public static final int View_contentDescription = 0x00000005;
        public static final int View_drawingCacheQuality = 0x00000006;
        public static final int View_duplicateParentState = 0x00000007;
        public static final int View_fadeScrollbars = 0x00000008;
        public static final int View_fadingEdge = 0x00000009;
        public static final int View_fadingEdgeLength = 0x0000000a;
        public static final int View_filterTouchesWhenObscured = 0x0000000b;
        public static final int View_fitsSystemWindows = 0x0000000c;
        public static final int View_focusable = 0x0000000d;
        public static final int View_focusableInTouchMode = 0x0000000e;
        public static final int View_hapticFeedbackEnabled = 0x0000000f;
        public static final int View_id = 0x00000010;
        public static final int View_importantForAccessibility = 0x00000011;
        public static final int View_isScrollContainer = 0x00000012;
        public static final int View_keepScreenOn = 0x00000013;
        public static final int View_layerType = 0x00000014;
        public static final int View_layoutDirection = 0x00000015;
        public static final int View_longClickable = 0x00000018;
        public static final int View_minHeight = 0x00000016;
        public static final int View_minWidth = 0x00000017;
        public static final int View_nextFocusDown = 0x00000019;
        public static final int View_nextFocusForward = 0x0000001a;
        public static final int View_nextFocusLeft = 0x0000001b;
        public static final int View_nextFocusRight = 0x0000001c;
        public static final int View_nextFocusUp = 0x0000001d;
        public static final int View_onClick = 0x0000001e;
        public static final int View_overScrollMode = 0x0000001f;
        public static final int View_padding = 0x00000020;
        public static final int View_paddingBottom = 0x00000021;
        public static final int View_paddingEnd = 0x00000022;
        public static final int View_paddingLeft = 0x00000023;
        public static final int View_paddingRight = 0x00000024;
        public static final int View_paddingStart = 0x00000025;
        public static final int View_paddingTop = 0x00000026;
        public static final int View_requiresFadingEdge = 0x00000027;
        public static final int View_rotation = 0x00000028;
        public static final int View_rotationX = 0x00000029;
        public static final int View_rotationY = 0x0000002a;
        public static final int View_saveEnabled = 0x0000002b;
        public static final int View_scaleX = 0x0000002c;
        public static final int View_scaleY = 0x0000002d;
        public static final int View_scrollX = 0x0000002e;
        public static final int View_scrollY = 0x0000002f;
        public static final int View_scrollbarAlwaysDrawHorizontalTrack = 0x00000030;
        public static final int View_scrollbarAlwaysDrawVerticalTrack = 0x00000031;
        public static final int View_scrollbarDefaultDelayBeforeFade = 0x00000032;
        public static final int View_scrollbarFadeDuration = 0x00000033;
        public static final int View_scrollbarSize = 0x00000034;
        public static final int View_scrollbarStyle = 0x00000035;
        public static final int View_scrollbarThumbHorizontal = 0x00000036;
        public static final int View_scrollbarThumbVertical = 0x00000037;
        public static final int View_scrollbarTrackHorizontal = 0x00000038;
        public static final int View_scrollbarTrackVertical = 0x00000039;
        public static final int View_scrollbars = 0x0000003a;
        public static final int View_soundEffectsEnabled = 0x0000003b;
        public static final int View_tag = 0x0000003c;
        public static final int View_textAlignment = 0x0000003d;
        public static final int View_textDirection = 0x0000003e;
        public static final int View_theme = 0x0000003f;
        public static final int View_transformPivotX = 0x00000040;
        public static final int View_transformPivotY = 0x00000041;
        public static final int View_translationX = 0x00000042;
        public static final int View_translationY = 0x00000043;
        public static final int View_verticalScrollbarPosition = 0x00000044;
        public static final int View_visibility = 0x00000045;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1321397714, "Lcom/baidu/spswitch/R$styleable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1321397714, "Lcom/baidu/spswitch/R$styleable;");
                    return;
                }
            }
            AbsSpinner = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04028a};
            ActionBar = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0400b0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400b7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400b8, com.baidu.tieba.R.attr.obfuscated_res_0x7f040194, com.baidu.tieba.R.attr.obfuscated_res_0x7f040195, com.baidu.tieba.R.attr.obfuscated_res_0x7f040196, com.baidu.tieba.R.attr.obfuscated_res_0x7f040197, com.baidu.tieba.R.attr.obfuscated_res_0x7f040198, com.baidu.tieba.R.attr.obfuscated_res_0x7f040199, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401fb, com.baidu.tieba.R.attr.obfuscated_res_0x7f040215, com.baidu.tieba.R.attr.obfuscated_res_0x7f040216, com.baidu.tieba.R.attr.obfuscated_res_0x7f040270, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ff, com.baidu.tieba.R.attr.obfuscated_res_0x7f040309, com.baidu.tieba.R.attr.obfuscated_res_0x7f040326, com.baidu.tieba.R.attr.obfuscated_res_0x7f040327, com.baidu.tieba.R.attr.obfuscated_res_0x7f04032c, com.baidu.tieba.R.attr.obfuscated_res_0x7f040342, com.baidu.tieba.R.attr.obfuscated_res_0x7f04036f, com.baidu.tieba.R.attr.obfuscated_res_0x7f04049b, com.baidu.tieba.R.attr.obfuscated_res_0x7f0404ff, com.baidu.tieba.R.attr.obfuscated_res_0x7f040565, com.baidu.tieba.R.attr.obfuscated_res_0x7f04056e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04056f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040676, com.baidu.tieba.R.attr.obfuscated_res_0x7f040679, com.baidu.tieba.R.attr.obfuscated_res_0x7f04072f, com.baidu.tieba.R.attr.obfuscated_res_0x7f04073b};
            ActionBarLayout = new int[]{16842931};
            ActionMenuItemView = new int[]{16843071};
            ActionMenuView = new int[0];
            ActionMode = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0400b0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400b7, com.baidu.tieba.R.attr.obfuscated_res_0x7f040166, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ff, com.baidu.tieba.R.attr.obfuscated_res_0x7f040679, com.baidu.tieba.R.attr.obfuscated_res_0x7f04073b};
            ActivityChooserView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040293, com.baidu.tieba.R.attr.obfuscated_res_0x7f040343};
            AlertDialog = new int[]{16842994, com.baidu.tieba.R.attr.obfuscated_res_0x7f04012a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04012b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04043d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04043e, com.baidu.tieba.R.attr.obfuscated_res_0x7f0404e5, com.baidu.tieba.R.attr.obfuscated_res_0x7f040635, com.baidu.tieba.R.attr.obfuscated_res_0x7f04063b};
            AnimatedStateListDrawableCompat = new int[]{16843036, 16843156, 16843157, 16843158, 16843532, 16843533};
            AnimatedStateListDrawableItem = new int[]{16842960, 16843161};
            AnimatedStateListDrawableTransition = new int[]{16843161, 16843849, 16843850, 16843851};
            AppCompatImageView = new int[]{16843033, com.baidu.tieba.R.attr.obfuscated_res_0x7f04065d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04072d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04072e};
            AppCompatSeekBar = new int[]{16843074, com.baidu.tieba.R.attr.obfuscated_res_0x7f040728, com.baidu.tieba.R.attr.obfuscated_res_0x7f040729, com.baidu.tieba.R.attr.obfuscated_res_0x7f04072a};
            AppCompatTextHelper = new int[]{16842804, 16843117, 16843118, 16843119, 16843120, 16843666, 16843667};
            AppCompatTextView = new int[]{16842804, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400a8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400a9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400aa, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400ab, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400ac, com.baidu.tieba.R.attr.obfuscated_res_0x7f040259, com.baidu.tieba.R.attr.obfuscated_res_0x7f04025a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04025b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04025c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04025e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04025f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040260, com.baidu.tieba.R.attr.obfuscated_res_0x7f040261, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402b7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402db, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e4, com.baidu.tieba.R.attr.obfuscated_res_0x7f040407, com.baidu.tieba.R.attr.obfuscated_res_0x7f040435, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e8, com.baidu.tieba.R.attr.obfuscated_res_0x7f04070a};
            AppCompatTheme = new int[]{16842839, 16842926, com.baidu.tieba.R.attr.obfuscated_res_0x7f04004a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04004b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04004c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04004d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04004e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04004f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040050, com.baidu.tieba.R.attr.obfuscated_res_0x7f040051, com.baidu.tieba.R.attr.obfuscated_res_0x7f040052, com.baidu.tieba.R.attr.obfuscated_res_0x7f040053, com.baidu.tieba.R.attr.obfuscated_res_0x7f040054, com.baidu.tieba.R.attr.obfuscated_res_0x7f040055, com.baidu.tieba.R.attr.obfuscated_res_0x7f040056, com.baidu.tieba.R.attr.obfuscated_res_0x7f040058, com.baidu.tieba.R.attr.obfuscated_res_0x7f040059, com.baidu.tieba.R.attr.obfuscated_res_0x7f04005b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04005d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04005e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04005f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040060, com.baidu.tieba.R.attr.obfuscated_res_0x7f040061, com.baidu.tieba.R.attr.obfuscated_res_0x7f040062, com.baidu.tieba.R.attr.obfuscated_res_0x7f040063, com.baidu.tieba.R.attr.obfuscated_res_0x7f040064, com.baidu.tieba.R.attr.obfuscated_res_0x7f040065, com.baidu.tieba.R.attr.obfuscated_res_0x7f040066, com.baidu.tieba.R.attr.obfuscated_res_0x7f040067, com.baidu.tieba.R.attr.obfuscated_res_0x7f040068, com.baidu.tieba.R.attr.obfuscated_res_0x7f040069, com.baidu.tieba.R.attr.obfuscated_res_0x7f04006a, com.baidu.tieba.R.attr.obfuscated_res_0x7f040070, com.baidu.tieba.R.attr.obfuscated_res_0x7f040085, com.baidu.tieba.R.attr.obfuscated_res_0x7f040086, com.baidu.tieba.R.attr.obfuscated_res_0x7f040087, com.baidu.tieba.R.attr.obfuscated_res_0x7f040088, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400a5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400f0, com.baidu.tieba.R.attr.obfuscated_res_0x7f04011d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04011e, com.baidu.tieba.R.attr.obfuscated_res_0x7f040122, com.baidu.tieba.R.attr.obfuscated_res_0x7f040126, com.baidu.tieba.R.attr.obfuscated_res_0x7f040127, com.baidu.tieba.R.attr.obfuscated_res_0x7f04012c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04012d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040135, com.baidu.tieba.R.attr.obfuscated_res_0x7f04013c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04016d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04016e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04016f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040170, com.baidu.tieba.R.attr.obfuscated_res_0x7f040171, com.baidu.tieba.R.attr.obfuscated_res_0x7f040172, com.baidu.tieba.R.attr.obfuscated_res_0x7f040173, com.baidu.tieba.R.attr.obfuscated_res_0x7f04017a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04017b, com.baidu.tieba.R.attr.obfuscated_res_0x7f040181, com.baidu.tieba.R.attr.obfuscated_res_0x7f04019d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040211, com.baidu.tieba.R.attr.obfuscated_res_0x7f040212, com.baidu.tieba.R.attr.obfuscated_res_0x7f040213, com.baidu.tieba.R.attr.obfuscated_res_0x7f040219, com.baidu.tieba.R.attr.obfuscated_res_0x7f04021d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040266, com.baidu.tieba.R.attr.obfuscated_res_0x7f040268, com.baidu.tieba.R.attr.obfuscated_res_0x7f04026d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04026e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04026f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040326, com.baidu.tieba.R.attr.obfuscated_res_0x7f04033a, com.baidu.tieba.R.attr.obfuscated_res_0x7f040439, com.baidu.tieba.R.attr.obfuscated_res_0x7f04043a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04043b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04043c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04043f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040440, com.baidu.tieba.R.attr.obfuscated_res_0x7f040441, com.baidu.tieba.R.attr.obfuscated_res_0x7f040442, com.baidu.tieba.R.attr.obfuscated_res_0x7f040443, com.baidu.tieba.R.attr.obfuscated_res_0x7f040444, com.baidu.tieba.R.attr.obfuscated_res_0x7f040445, com.baidu.tieba.R.attr.obfuscated_res_0x7f040446, com.baidu.tieba.R.attr.obfuscated_res_0x7f040447, com.baidu.tieba.R.attr.obfuscated_res_0x7f040527, com.baidu.tieba.R.attr.obfuscated_res_0x7f040528, com.baidu.tieba.R.attr.obfuscated_res_0x7f040529, com.baidu.tieba.R.attr.obfuscated_res_0x7f040564, com.baidu.tieba.R.attr.obfuscated_res_0x7f040566, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405af, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405b7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405b8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405b9, com.baidu.tieba.R.attr.obfuscated_res_0x7f040613, com.baidu.tieba.R.attr.obfuscated_res_0x7f040615, com.baidu.tieba.R.attr.obfuscated_res_0x7f040618, com.baidu.tieba.R.attr.obfuscated_res_0x7f040619, com.baidu.tieba.R.attr.obfuscated_res_0x7f040658, com.baidu.tieba.R.attr.obfuscated_res_0x7f040659, com.baidu.tieba.R.attr.obfuscated_res_0x7f04068a, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406f9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406fa, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406fb, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406fc, com.baidu.tieba.R.attr.obfuscated_res_0x7f040700, com.baidu.tieba.R.attr.obfuscated_res_0x7f040703, com.baidu.tieba.R.attr.obfuscated_res_0x7f040741, com.baidu.tieba.R.attr.obfuscated_res_0x7f040742, com.baidu.tieba.R.attr.obfuscated_res_0x7f040743, com.baidu.tieba.R.attr.obfuscated_res_0x7f040744, com.baidu.tieba.R.attr.obfuscated_res_0x7f040790, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407a3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407a4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407a5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407a6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407a7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407a8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407a9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407aa, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407ab, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407ac};
            ButtonBarLayout = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040089};
            ColorStateListItem = new int[]{16843173, 16843551, com.baidu.tieba.R.attr.obfuscated_res_0x7f04008a};
            CompoundButton = new int[]{16843015, com.baidu.tieba.R.attr.obfuscated_res_0x7f040128, com.baidu.tieba.R.attr.obfuscated_res_0x7f04012e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04012f};
            DrawerArrowToggle = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04009b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04009c, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400c4, com.baidu.tieba.R.attr.obfuscated_res_0x7f04016c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04025d, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402eb, com.baidu.tieba.R.attr.obfuscated_res_0x7f040657, com.baidu.tieba.R.attr.obfuscated_res_0x7f040716};
            FontFamily = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0402dc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402dd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402de, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402df, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e2};
            FontFamilyFont = new int[]{16844082, 16844083, 16844095, 16844143, 16844144, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402da, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e5, com.baidu.tieba.R.attr.obfuscated_res_0x7f040766};
            Gallery = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040093, com.baidu.tieba.R.attr.obfuscated_res_0x7f04064f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040685, com.baidu.tieba.R.attr.unselectedAlpha};
            GradientColor = new int[]{16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051};
            GradientColorItem = new int[]{16843173, 16844052};
            LinearLayoutCompat = new int[]{16842927, 16842948, 16843046, 16843047, 16843048, com.baidu.tieba.R.attr.obfuscated_res_0x7f040216, com.baidu.tieba.R.attr.obfuscated_res_0x7f04021c, com.baidu.tieba.R.attr.obfuscated_res_0x7f0404cd, com.baidu.tieba.R.attr.obfuscated_res_0x7f04062f};
            LinearLayoutCompat_Layout = new int[]{16842931, 16842996, 16842997, 16843137};
            ListPopupWindow = new int[]{16843436, 16843437};
            MenuGroup = new int[]{16842766, 16842960, 16843156, 16843230, 16843231, 16843232};
            MenuItem = new int[]{16842754, 16842766, 16842960, 16843014, 16843156, 16843230, 16843231, 16843233, 16843234, 16843235, 16843236, 16843237, 16843375, com.baidu.tieba.R.attr.obfuscated_res_0x7f040057, com.baidu.tieba.R.attr.obfuscated_res_0x7f04006b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04006f, com.baidu.tieba.R.attr.obfuscated_res_0x7f04008b, com.baidu.tieba.R.attr.obfuscated_res_0x7f040193, com.baidu.tieba.R.attr.obfuscated_res_0x7f040334, com.baidu.tieba.R.attr.obfuscated_res_0x7f040335, com.baidu.tieba.R.attr.obfuscated_res_0x7f04050c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04062e, com.baidu.tieba.R.attr.obfuscated_res_0x7f040746};
            MenuView = new int[]{16842926, 16843052, 16843053, 16843054, 16843055, 16843056, 16843057, com.baidu.tieba.R.attr.obfuscated_res_0x7f04056a, com.baidu.tieba.R.attr.obfuscated_res_0x7f040674};
            PartingLineView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0400de, com.baidu.tieba.R.attr.bgBorderWidth, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400e0, com.baidu.tieba.R.attr.bgPressedColor, com.baidu.tieba.R.attr.obfuscated_res_0x7f040217, com.baidu.tieba.R.attr.obfuscated_res_0x7f04021a, com.baidu.tieba.R.attr.dividerLineHeight};
            PopupWindow = new int[]{16843126, 16843465, com.baidu.tieba.R.attr.obfuscated_res_0x7f040518, com.baidu.tieba.R.attr.popupAnimationStyle, com.baidu.tieba.R.attr.popupBackground};
            PopupWindowBackgroundState = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040667};
            RecycleListView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04051c, com.baidu.tieba.R.attr.obfuscated_res_0x7f040525};
            RecyclerView = new int[]{16842948, 16842987, 16842993, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402af, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402b0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402b1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402b2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402b3, com.baidu.tieba.R.attr.obfuscated_res_0x7f04040f, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405cd, com.baidu.tieba.R.attr.obfuscated_res_0x7f040654, com.baidu.tieba.R.attr.obfuscated_res_0x7f04065f};
            RoundProgressBar = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0405dd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405e0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405e3, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405e4, com.baidu.tieba.R.attr.roundTextColor, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405e6, com.baidu.tieba.R.attr.roundTextSize, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405e8, com.baidu.tieba.R.attr.obfuscated_res_0x7f040673, com.baidu.tieba.R.attr.obfuscated_res_0x7f040709};
            RoundedImageView = new int[]{16843037, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400ee, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400ef, com.baidu.tieba.R.attr.obfuscated_res_0x7f0401ad, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405e9};
            SearchView = new int[]{16842970, 16843039, 16843296, 16843364, com.baidu.tieba.R.attr.obfuscated_res_0x7f04015d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040189, com.baidu.tieba.R.attr.obfuscated_res_0x7f040207, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ee, com.baidu.tieba.R.attr.obfuscated_res_0x7f040337, com.baidu.tieba.R.attr.obfuscated_res_0x7f040409, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405a0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405a1, com.baidu.tieba.R.attr.obfuscated_res_0x7f040611, com.baidu.tieba.R.attr.obfuscated_res_0x7f040612, com.baidu.tieba.R.attr.obfuscated_res_0x7f040675, com.baidu.tieba.R.attr.obfuscated_res_0x7f04067d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040793};
            ShimmerFrameLayout = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04008e, com.baidu.tieba.R.attr.auto_start, com.baidu.tieba.R.attr.base_alpha, com.baidu.tieba.R.attr.obfuscated_res_0x7f040269, com.baidu.tieba.R.attr.obfuscated_res_0x7f04026b, com.baidu.tieba.R.attr.fixed_height, com.baidu.tieba.R.attr.fixed_width, com.baidu.tieba.R.attr.obfuscated_res_0x7f040347, com.baidu.tieba.R.attr.relative_height, com.baidu.tieba.R.attr.relative_width, com.baidu.tieba.R.attr.repeat_count, com.baidu.tieba.R.attr.repeat_delay, com.baidu.tieba.R.attr.repeat_mode, com.baidu.tieba.R.attr.obfuscated_res_0x7f04062c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04072c};
            Spinner = new int[]{16842930, 16843126, 16843131, 16843362, com.baidu.tieba.R.attr.obfuscated_res_0x7f040565};
            StateListDrawable = new int[]{16843036, 16843156, 16843157, 16843158, 16843532, 16843533};
            StateListDrawableItem = new int[]{16843161};
            SwitchCompat = new int[]{16843044, 16843045, 16843074, com.baidu.tieba.R.attr.obfuscated_res_0x7f040634, com.baidu.tieba.R.attr.obfuscated_res_0x7f04065b, com.baidu.tieba.R.attr.obfuscated_res_0x7f040688, com.baidu.tieba.R.attr.obfuscated_res_0x7f040689, com.baidu.tieba.R.attr.obfuscated_res_0x7f04068b, com.baidu.tieba.R.attr.obfuscated_res_0x7f040720, com.baidu.tieba.R.attr.obfuscated_res_0x7f040721, com.baidu.tieba.R.attr.obfuscated_res_0x7f040722, com.baidu.tieba.R.attr.obfuscated_res_0x7f04074f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040754, com.baidu.tieba.R.attr.obfuscated_res_0x7f040755};
            TabLayout = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04068c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04068d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04068e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04068f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040690, com.baidu.tieba.R.attr.obfuscated_res_0x7f040691, com.baidu.tieba.R.attr.obfuscated_res_0x7f040692, com.baidu.tieba.R.attr.obfuscated_res_0x7f040693, com.baidu.tieba.R.attr.obfuscated_res_0x7f040694, com.baidu.tieba.R.attr.obfuscated_res_0x7f040695, com.baidu.tieba.R.attr.obfuscated_res_0x7f040696, com.baidu.tieba.R.attr.obfuscated_res_0x7f040698, com.baidu.tieba.R.attr.obfuscated_res_0x7f040699, com.baidu.tieba.R.attr.obfuscated_res_0x7f04069a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04069b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04069c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04069d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04069e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04069f, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406a0, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406a1, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406a2, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406a4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406a5, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406a6};
            TextAppearance = new int[]{16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402db, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402e4, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e8, com.baidu.tieba.R.attr.obfuscated_res_0x7f04070a};
            Toolbar = new int[]{16842927, 16843072, com.baidu.tieba.R.attr.obfuscated_res_0x7f040129, com.baidu.tieba.R.attr.obfuscated_res_0x7f040167, com.baidu.tieba.R.attr.obfuscated_res_0x7f040168, com.baidu.tieba.R.attr.obfuscated_res_0x7f040194, com.baidu.tieba.R.attr.obfuscated_res_0x7f040195, com.baidu.tieba.R.attr.obfuscated_res_0x7f040196, com.baidu.tieba.R.attr.obfuscated_res_0x7f040197, com.baidu.tieba.R.attr.obfuscated_res_0x7f040198, com.baidu.tieba.R.attr.obfuscated_res_0x7f040199, com.baidu.tieba.R.attr.obfuscated_res_0x7f04049b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04049c, com.baidu.tieba.R.attr.obfuscated_res_0x7f0404bf, com.baidu.tieba.R.attr.obfuscated_res_0x7f0404cf, com.baidu.tieba.R.attr.obfuscated_res_0x7f0404fd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0404fe, com.baidu.tieba.R.attr.obfuscated_res_0x7f040565, com.baidu.tieba.R.attr.obfuscated_res_0x7f040676, com.baidu.tieba.R.attr.obfuscated_res_0x7f040677, com.baidu.tieba.R.attr.obfuscated_res_0x7f040678, com.baidu.tieba.R.attr.obfuscated_res_0x7f04072f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040732, com.baidu.tieba.R.attr.obfuscated_res_0x7f040733, com.baidu.tieba.R.attr.obfuscated_res_0x7f040734, com.baidu.tieba.R.attr.obfuscated_res_0x7f040735, com.baidu.tieba.R.attr.obfuscated_res_0x7f040736, com.baidu.tieba.R.attr.obfuscated_res_0x7f040737, com.baidu.tieba.R.attr.obfuscated_res_0x7f040739, com.baidu.tieba.R.attr.obfuscated_res_0x7f04073a};
            View = new int[]{16842752, 16842970, com.baidu.tieba.R.attr.obfuscated_res_0x7f040049, com.baidu.tieba.R.attr.obfuscated_res_0x7f04008a, com.baidu.tieba.R.attr.obfuscated_res_0x7f040158, com.baidu.tieba.R.attr.obfuscated_res_0x7f040193, com.baidu.tieba.R.attr.obfuscated_res_0x7f040265, com.baidu.tieba.R.attr.obfuscated_res_0x7f04026a, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ab, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ac, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ad, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402b6, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402b8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402d8, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402d9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fb, com.baidu.tieba.R.attr.obfuscated_res_0x7f040338, com.baidu.tieba.R.attr.obfuscated_res_0x7f04033c, com.baidu.tieba.R.attr.obfuscated_res_0x7f040353, com.baidu.tieba.R.attr.obfuscated_res_0x7f04037f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040408, com.baidu.tieba.R.attr.obfuscated_res_0x7f04040c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04042a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04042e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04049d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040503, com.baidu.tieba.R.attr.obfuscated_res_0x7f040504, com.baidu.tieba.R.attr.obfuscated_res_0x7f040505, com.baidu.tieba.R.attr.obfuscated_res_0x7f040506, com.baidu.tieba.R.attr.obfuscated_res_0x7f040507, com.baidu.tieba.R.attr.obfuscated_res_0x7f04050d, com.baidu.tieba.R.attr.obfuscated_res_0x7f040517, com.baidu.tieba.R.attr.obfuscated_res_0x7f04051a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04051b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04051e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04051f, com.baidu.tieba.R.attr.obfuscated_res_0x7f040521, com.baidu.tieba.R.attr.obfuscated_res_0x7f040523, com.baidu.tieba.R.attr.obfuscated_res_0x7f040524, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405ca, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405d9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405da, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405db, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405f7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405f9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405fa, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405fe, com.baidu.tieba.R.attr.obfuscated_res_0x7f0405ff, com.baidu.tieba.R.attr.obfuscated_res_0x7f040600, com.baidu.tieba.R.attr.obfuscated_res_0x7f040601, com.baidu.tieba.R.attr.obfuscated_res_0x7f040602, com.baidu.tieba.R.attr.obfuscated_res_0x7f040603, com.baidu.tieba.R.attr.obfuscated_res_0x7f040604, com.baidu.tieba.R.attr.obfuscated_res_0x7f040605, com.baidu.tieba.R.attr.obfuscated_res_0x7f040606, com.baidu.tieba.R.attr.obfuscated_res_0x7f040607, com.baidu.tieba.R.attr.obfuscated_res_0x7f040608, com.baidu.tieba.R.attr.obfuscated_res_0x7f040609, com.baidu.tieba.R.attr.obfuscated_res_0x7f04060a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04064d, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406a7, com.baidu.tieba.R.attr.obfuscated_res_0x7f0406e7, com.baidu.tieba.R.attr.obfuscated_res_0x7f040704, com.baidu.tieba.R.attr.obfuscated_res_0x7f040713, com.baidu.tieba.R.attr.obfuscated_res_0x7f04075a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04075b, com.baidu.tieba.R.attr.obfuscated_res_0x7f040761, com.baidu.tieba.R.attr.obfuscated_res_0x7f040762, com.baidu.tieba.R.attr.obfuscated_res_0x7f04078a, com.baidu.tieba.R.attr.obfuscated_res_0x7f040791};
            ViewBackgroundHelper = new int[]{16842964, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400b9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0400ba};
            ViewStubCompat = new int[]{16842960, 16842994, 16842995};
            pickerview = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f04079a, com.baidu.tieba.R.attr.obfuscated_res_0x7f04079b, com.baidu.tieba.R.attr.obfuscated_res_0x7f04079c, com.baidu.tieba.R.attr.obfuscated_res_0x7f04079d, com.baidu.tieba.R.attr.obfuscated_res_0x7f04079e, com.baidu.tieba.R.attr.obfuscated_res_0x7f04079f};
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
