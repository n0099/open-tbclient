package com.baidu.android.pushservice;

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
        public static final int bd_push_anim_banner_slide_in_from_top = 0x7f010043;
        public static final int bd_push_anim_banner_slide_out_to_top = 0x7f010044;
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
        public static final int alpha = 0x7f04008a;
        public static final int font = 0x7f0402f6;
        public static final int fontProviderAuthority = 0x7f0402f9;
        public static final int fontProviderCerts = 0x7f0402fa;
        public static final int fontProviderFetchStrategy = 0x7f0402fb;
        public static final int fontProviderFetchTimeout = 0x7f0402fc;
        public static final int fontProviderPackage = 0x7f0402fd;
        public static final int fontProviderQuery = 0x7f0402fe;
        public static final int fontProviderSystemFontFamily = 0x7f0402ff;
        public static final int fontStyle = 0x7f040300;
        public static final int fontVariationSettings = 0x7f040301;
        public static final int fontWeight = 0x7f040302;
        public static final int nestedScrollViewStyle = 0x7f04052f;
        public static final int queryPatterns = 0x7f0405db;

        /* renamed from: roundConner */
        public static final int obfuscated = 0x7f040624;
        public static final int shortcutMatchRequired = 0x7f040680;
        public static final int ttcIndex = 0x7f0407c3;
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
        public static final int androidx_core_ripple_material_light = 0x7f060478;
        public static final int androidx_core_secondary_text_default_material_light = 0x7f060479;
        public static final int bd_push_bd_push_red_point = 0x7f060490;
        public static final int bd_push_double_icon_button_bg = 0x7f060491;
        public static final int bd_push_double_icon_msg_import = 0x7f060492;
        public static final int bd_push_float_banner_bg = 0x7f060493;
        public static final int bd_push_float_banner_bg_night = 0x7f060494;
        public static final int bd_push_float_banner_desc_text_color = 0x7f060495;
        public static final int bd_push_float_banner_desc_text_color_night = 0x7f060496;
        public static final int bd_push_float_banner_title_text_color = 0x7f060497;
        public static final int bd_push_float_banner_title_text_color_night = 0x7f060498;
        public static final int bd_push_red_envelope_background = 0x7f060499;
        public static final int bd_push_red_envelope_line = 0x7f06049a;
        public static final int bd_push_white = 0x7f06049b;
        public static final int notification_action_color_filter = 0x7f060903;
        public static final int notification_icon_bg_color = 0x7f060904;
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
        public static final int compat_button_inset_horizontal_material = 0x7f07026d;
        public static final int compat_button_inset_vertical_material = 0x7f07026e;
        public static final int compat_button_padding_horizontal_material = 0x7f070270;
        public static final int compat_button_padding_vertical_material = 0x7f070271;
        public static final int compat_control_corner_material = 0x7f070272;
        public static final int compat_notification_large_icon_max_height = 0x7f070273;
        public static final int compat_notification_large_icon_max_width = 0x7f070274;
        public static final int notification_action_icon_size = 0x7f070745;
        public static final int notification_action_text_size = 0x7f070746;
        public static final int notification_big_circle_margin = 0x7f070747;
        public static final int notification_content_margin_start = 0x7f070748;
        public static final int notification_large_icon_height = 0x7f070749;
        public static final int notification_large_icon_width = 0x7f07074a;
        public static final int notification_main_column_padding_top = 0x7f07074b;
        public static final int notification_media_narrow_margin = 0x7f07074c;
        public static final int notification_right_icon_size = 0x7f07074d;
        public static final int notification_right_side_padding_top = 0x7f07074e;
        public static final int notification_small_icon_background_padding = 0x7f07074f;
        public static final int notification_small_icon_size_as_large = 0x7f070750;
        public static final int notification_subtext_size = 0x7f070751;
        public static final int notification_top_pad = 0x7f070752;
        public static final int notification_top_pad_large_text = 0x7f070753;
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
        public static final int bd_push_double_icon_button_bg = 0x7f080250;
        public static final int bd_push_double_icon_red_point = 0x7f080251;
        public static final int bd_push_notification_banner_bg = 0x7f080252;
        public static final int bd_push_notification_banner_bg_night = 0x7f080253;
        public static final int bd_push_notification_button_bottom_bg = 0x7f080254;
        public static final int bd_push_notification_button_end_bg = 0x7f080255;
        public static final int bd_push_notification_corner_button_bg = 0x7f080256;
        public static final int bd_push_notification_goods_content_bg = 0x7f080257;
        public static final int bd_push_notification_red_env_bg = 0x7f080258;
        public static final int bd_push_red_envelope_icon = 0x7f080259;
        public static final int notification_action_background = 0x7f0810f2;
        public static final int notification_bg = 0x7f0810f3;
        public static final int notification_bg_low = 0x7f0810f4;
        public static final int notification_bg_low_normal = 0x7f0810f5;
        public static final int notification_bg_low_pressed = 0x7f0810f6;
        public static final int notification_bg_normal = 0x7f0810f7;
        public static final int notification_bg_normal_pressed = 0x7f0810f8;
        public static final int notification_icon_background = 0x7f0810f9;
        public static final int notification_template_icon_bg = 0x7f0810fa;
        public static final int notification_template_icon_low_bg = 0x7f0810fb;
        public static final int notification_tile_bg = 0x7f0810fc;
        public static final int notify_panel_notification_icon_bg = 0x7f0810ff;
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
        public static final int accessibility_action_clickable_span = 0x7f090041;
        public static final int accessibility_custom_action_0 = 0x7f090042;
        public static final int accessibility_custom_action_1 = 0x7f090043;
        public static final int accessibility_custom_action_10 = 0x7f090044;
        public static final int accessibility_custom_action_11 = 0x7f090045;
        public static final int accessibility_custom_action_12 = 0x7f090046;
        public static final int accessibility_custom_action_13 = 0x7f090047;
        public static final int accessibility_custom_action_14 = 0x7f090048;
        public static final int accessibility_custom_action_15 = 0x7f090049;
        public static final int accessibility_custom_action_16 = 0x7f09004a;
        public static final int accessibility_custom_action_17 = 0x7f09004b;
        public static final int accessibility_custom_action_18 = 0x7f09004c;
        public static final int accessibility_custom_action_19 = 0x7f09004d;
        public static final int accessibility_custom_action_2 = 0x7f09004e;
        public static final int accessibility_custom_action_20 = 0x7f09004f;
        public static final int accessibility_custom_action_21 = 0x7f090050;
        public static final int accessibility_custom_action_22 = 0x7f090051;
        public static final int accessibility_custom_action_23 = 0x7f090052;
        public static final int accessibility_custom_action_24 = 0x7f090053;
        public static final int accessibility_custom_action_25 = 0x7f090054;
        public static final int accessibility_custom_action_26 = 0x7f090055;
        public static final int accessibility_custom_action_27 = 0x7f090056;
        public static final int accessibility_custom_action_28 = 0x7f090057;
        public static final int accessibility_custom_action_29 = 0x7f090058;
        public static final int accessibility_custom_action_3 = 0x7f090059;
        public static final int accessibility_custom_action_30 = 0x7f09005a;
        public static final int accessibility_custom_action_31 = 0x7f09005b;
        public static final int accessibility_custom_action_4 = 0x7f09005c;
        public static final int accessibility_custom_action_5 = 0x7f09005d;
        public static final int accessibility_custom_action_6 = 0x7f09005e;
        public static final int accessibility_custom_action_7 = 0x7f09005f;
        public static final int accessibility_custom_action_8 = 0x7f090060;
        public static final int accessibility_custom_action_9 = 0x7f090061;
        public static final int action_container = 0x7f090074;
        public static final int action_divider = 0x7f090076;
        public static final int action_image = 0x7f090078;
        public static final int action_text = 0x7f090080;
        public static final int actions = 0x7f090081;
        public static final int async = 0x7f0902da;
        public static final int bd_push_banner_app_icon = 0x7f09037d;
        public static final int bd_push_banner_app_name = 0x7f09037e;
        public static final int bd_push_banner_content = 0x7f09037f;
        public static final int bd_push_banner_desc = 0x7f090380;
        public static final int bd_push_banner_header = 0x7f090381;
        public static final int bd_push_banner_right_icon = 0x7f090382;
        public static final int bd_push_banner_root = 0x7f090383;
        public static final int bd_push_banner_time = 0x7f090384;
        public static final int bd_push_banner_title = 0x7f090385;
        public static final int bd_push_btn_end = 0x7f090386;
        public static final int bd_push_btn_right = 0x7f090387;
        public static final int bd_push_btn_start = 0x7f090388;
        public static final int bd_push_container = 0x7f090389;
        public static final int bd_push_container_shape = 0x7f09038a;
        public static final int bd_push_icon = 0x7f09038b;
        public static final int bd_push_im_btn_bg = 0x7f09038c;
        public static final int bd_push_img_bg = 0x7f09038d;
        public static final int bd_push_img_btn_bottom_bg = 0x7f09038e;
        public static final int bd_push_img_btn_right_bg = 0x7f09038f;
        public static final int bd_push_img_goods = 0x7f090390;
        public static final int bd_push_img_icon = 0x7f090391;
        public static final int bd_push_iv_bg = 0x7f090392;
        public static final int bd_push_iv_big_image = 0x7f090393;
        public static final int bd_push_iv_button_red_dot = 0x7f090394;
        public static final int bd_push_iv_title_red_dot = 0x7f090395;
        public static final int bd_push_left_icon = 0x7f090396;
        public static final int bd_push_line = 0x7f090397;
        public static final int bd_push_lyt_btn_bottom = 0x7f090398;
        public static final int bd_push_lyt_btn_right = 0x7f090399;
        public static final int bd_push_lyt_button = 0x7f09039a;
        public static final int bd_push_lyt_detail1 = 0x7f09039b;
        public static final int bd_push_lyt_detail2 = 0x7f09039c;
        public static final int bd_push_lyt_goods = 0x7f09039d;
        public static final int bd_push_lyt_goods_content = 0x7f09039e;
        public static final int bd_push_lyt_goods_price2 = 0x7f09039f;
        public static final int bd_push_lyt_head = 0x7f0903a0;
        public static final int bd_push_lyt_notification_custom_head = 0x7f0903a1;
        public static final int bd_push_lyt_title_value = 0x7f0903a2;
        public static final int bd_push_right_icon = 0x7f0903a3;
        public static final int bd_push_rl_core = 0x7f0903a4;
        public static final int bd_push_rl_right_area = 0x7f0903a5;
        public static final int bd_push_title = 0x7f0903a6;
        public static final int bd_push_tv_app_name = 0x7f0903a7;
        public static final int bd_push_tv_btn_txt = 0x7f0903a8;
        public static final int bd_push_tv_content = 0x7f0903a9;
        public static final int bd_push_tv_msg = 0x7f0903aa;
        public static final int bd_push_tv_msg_hl = 0x7f0903ab;
        public static final int bd_push_tv_title = 0x7f0903ac;
        public static final int bd_push_txt_title_name = 0x7f0903ad;
        public static final int bd_push_txv_app_name = 0x7f0903ae;
        public static final int bd_push_txv_btn_bottom_text = 0x7f0903af;
        public static final int bd_push_txv_content_title = 0x7f0903b0;
        public static final int bd_push_txv_detail1_name = 0x7f0903b1;
        public static final int bd_push_txv_detail1_value = 0x7f0903b2;
        public static final int bd_push_txv_detail2_name = 0x7f0903b3;
        public static final int bd_push_txv_detail2_value = 0x7f0903b4;
        public static final int bd_push_txv_goods_desc = 0x7f0903b5;
        public static final int bd_push_txv_goods_price1 = 0x7f0903b6;
        public static final int bd_push_txv_goods_price2 = 0x7f0903b7;
        public static final int bd_push_txv_title_value = 0x7f0903b8;
        public static final int blocking = 0x7f09040e;
        public static final int chronometer = 0x7f09071b;
        public static final int dialog_button = 0x7f0908aa;
        public static final int forever = 0x7f090bb3;
        public static final int icon = 0x7f090ffd;
        public static final int icon_group = 0x7f091007;
        public static final int info = 0x7f091132;
        public static final int italic = 0x7f0911a1;
        public static final int line1 = 0x7f09152e;
        public static final int line3 = 0x7f091530;
        public static final int normal = 0x7f09199a;
        public static final int notification_background = 0x7f0919b2;
        public static final int notification_main_column = 0x7f0919b4;
        public static final int notification_main_column_container = 0x7f0919b5;
        public static final int right_icon = 0x7f091f47;
        public static final int right_side = 0x7f091f4f;
        public static final int tag_accessibility_actions = 0x7f09239e;
        public static final int tag_accessibility_clickable_spans = 0x7f09239f;
        public static final int tag_accessibility_heading = 0x7f0923a0;
        public static final int tag_accessibility_pane_title = 0x7f0923a1;
        public static final int tag_on_apply_window_listener = 0x7f0923da;
        public static final int tag_on_receive_content_listener = 0x7f0923db;
        public static final int tag_on_receive_content_mime_types = 0x7f0923dc;
        public static final int tag_screen_reader_focusable = 0x7f0923f6;
        public static final int tag_state_description = 0x7f0923ff;
        public static final int tag_transition_group = 0x7f092406;
        public static final int tag_unhandled_key_event_manager = 0x7f092408;
        public static final int tag_unhandled_key_listeners = 0x7f092409;
        public static final int tag_window_insets_animation_callback = 0x7f092416;
        public static final int text = 0x7f092488;
        public static final int text2 = 0x7f09248a;
        public static final int time = 0x7f092559;
        public static final int title = 0x7f09258f;
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
        public static final int status_bar_notification_info_maxnum = 0x7f0a002b;
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
    public static final class layout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int bd_push_layout_customs_goods_card = 0x7f0d015d;
        public static final int bd_push_layout_customs_notification_goods_card = 0x7f0d015e;
        public static final int bd_push_layout_customs_notification_head = 0x7f0d015f;
        public static final int bd_push_layout_customs_notification_pay_card = 0x7f0d0160;
        public static final int bd_push_layout_customs_notification_picture = 0x7f0d0161;
        public static final int bd_push_notification_banner = 0x7f0d0162;
        public static final int bd_push_notification_banner_night = 0x7f0d0163;
        public static final int bd_push_notification_big_image = 0x7f0d0164;
        public static final int bd_push_notification_big_image_heads_up = 0x7f0d0165;
        public static final int bd_push_notification_double_icon = 0x7f0d0166;
        public static final int bd_push_notification_red_env_style = 0x7f0d0167;
        public static final int bd_push_notification_red_env_style_vivo = 0x7f0d0168;
        public static final int custom_dialog = 0x7f0d023e;
        public static final int notification_action = 0x7f0d0732;
        public static final int notification_action_tombstone = 0x7f0d0733;
        public static final int notification_template_custom_big = 0x7f0d073a;
        public static final int notification_template_icon_group = 0x7f0d073b;
        public static final int notification_template_part_chronometer = 0x7f0d073f;
        public static final int notification_template_part_time = 0x7f0d0740;
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

    /* loaded from: classes.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int bd_push_red_envelope = 0x7f0f033e;
        public static final int status_bar_notification_info_overflow = 0x7f0f1462;
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
        public static final int TextAppearance_Compat_Notification = 0x7f100202;
        public static final int TextAppearance_Compat_Notification_Info = 0x7f100203;
        public static final int TextAppearance_Compat_Notification_Line2 = 0x7f100205;
        public static final int TextAppearance_Compat_Notification_Time = 0x7f100208;
        public static final int TextAppearance_Compat_Notification_Title = 0x7f10020a;
        public static final int Widget_Compat_NotificationActionContainer = 0x7f100343;
        public static final int Widget_Compat_NotificationActionText = 0x7f100344;

        /* renamed from: bd_push_banner_window_notify_style */
        public static final int obfuscated_res_0x7f1003b6 = 0x7f1003b6;
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
        public static final int[] Capability;
        public static final int Capability_queryPatterns = 0x00000000;
        public static final int Capability_shortcutMatchRequired = 0x00000001;
        public static final int[] ColorStateListItem;
        public static final int ColorStateListItem_alpha = 0x00000002;
        public static final int ColorStateListItem_android_alpha = 0x00000001;
        public static final int ColorStateListItem_android_color = 0x00000000;
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
        public static final int[] RoundConnerImageView;
        public static final int RoundConnerImageView_roundConner = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-531377020, "Lcom/baidu/android/pushservice/R$styleable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-531377020, "Lcom/baidu/android/pushservice/R$styleable;");
                    return;
                }
            }
            Capability = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0405db, com.baidu.tieba.R.attr.obfuscated_res_0x7f040680};
            ColorStateListItem = new int[]{16843173, 16843551, com.baidu.tieba.R.attr.obfuscated_res_0x7f04008a};
            FontFamily = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0402f9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fa, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fb, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fe, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ff};
            FontFamilyFont = new int[]{16844082, 16844083, 16844095, 16844143, 16844144, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402f6, com.baidu.tieba.R.attr.obfuscated_res_0x7f040300, com.baidu.tieba.R.attr.obfuscated_res_0x7f040301, com.baidu.tieba.R.attr.obfuscated_res_0x7f040302, com.baidu.tieba.R.attr.obfuscated_res_0x7f0407c3};
            GradientColor = new int[]{16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051};
            GradientColorItem = new int[]{16843173, 16844052};
            RoundConnerImageView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040624};
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
