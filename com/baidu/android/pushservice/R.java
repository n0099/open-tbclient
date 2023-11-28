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
        public static final int nestedScrollViewStyle = 0x7f040540;
        public static final int queryPatterns = 0x7f0405ec;

        /* renamed from: roundConner */
        public static final int obfuscated = 0x7f040635;
        public static final int shortcutMatchRequired = 0x7f040691;
        public static final int ttcIndex = 0x7f04084a;
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
        public static final int androidx_core_ripple_material_light = 0x7f06047c;
        public static final int androidx_core_secondary_text_default_material_light = 0x7f06047d;
        public static final int bd_push_bd_push_red_point = 0x7f060494;
        public static final int bd_push_double_icon_button_bg = 0x7f060495;
        public static final int bd_push_double_icon_msg_import = 0x7f060496;
        public static final int bd_push_float_banner_bg = 0x7f060497;
        public static final int bd_push_float_banner_bg_night = 0x7f060498;
        public static final int bd_push_float_banner_desc_text_color = 0x7f060499;
        public static final int bd_push_float_banner_desc_text_color_night = 0x7f06049a;
        public static final int bd_push_float_banner_title_text_color = 0x7f06049b;
        public static final int bd_push_float_banner_title_text_color_night = 0x7f06049c;
        public static final int bd_push_red_envelope_background = 0x7f06049d;
        public static final int bd_push_red_envelope_line = 0x7f06049e;
        public static final int bd_push_white = 0x7f06049f;
        public static final int notification_action_color_filter = 0x7f06090d;
        public static final int notification_icon_bg_color = 0x7f06090e;
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
        public static final int notification_action_icon_size = 0x7f070759;
        public static final int notification_action_text_size = 0x7f07075a;
        public static final int notification_big_circle_margin = 0x7f07075b;
        public static final int notification_content_margin_start = 0x7f07075c;
        public static final int notification_large_icon_height = 0x7f07075d;
        public static final int notification_large_icon_width = 0x7f07075e;
        public static final int notification_main_column_padding_top = 0x7f07075f;
        public static final int notification_media_narrow_margin = 0x7f070760;
        public static final int notification_right_icon_size = 0x7f070761;
        public static final int notification_right_side_padding_top = 0x7f070762;
        public static final int notification_small_icon_background_padding = 0x7f070763;
        public static final int notification_small_icon_size_as_large = 0x7f070764;
        public static final int notification_subtext_size = 0x7f070765;
        public static final int notification_top_pad = 0x7f070766;
        public static final int notification_top_pad_large_text = 0x7f070767;
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
        public static final int bd_push_double_icon_button_bg = 0x7f08025c;
        public static final int bd_push_double_icon_red_point = 0x7f08025d;
        public static final int bd_push_notification_banner_bg = 0x7f08025e;
        public static final int bd_push_notification_banner_bg_night = 0x7f08025f;
        public static final int bd_push_notification_button_bottom_bg = 0x7f080260;
        public static final int bd_push_notification_button_end_bg = 0x7f080261;
        public static final int bd_push_notification_corner_button_bg = 0x7f080262;
        public static final int bd_push_notification_goods_content_bg = 0x7f080263;
        public static final int bd_push_notification_red_env_bg = 0x7f080264;
        public static final int bd_push_red_envelope_icon = 0x7f080265;
        public static final int notification_action_background = 0x7f081143;
        public static final int notification_bg = 0x7f081144;
        public static final int notification_bg_low = 0x7f081145;
        public static final int notification_bg_low_normal = 0x7f081146;
        public static final int notification_bg_low_pressed = 0x7f081147;
        public static final int notification_bg_normal = 0x7f081148;
        public static final int notification_bg_normal_pressed = 0x7f081149;
        public static final int notification_icon_background = 0x7f08114a;
        public static final int notification_template_icon_bg = 0x7f08114b;
        public static final int notification_template_icon_low_bg = 0x7f08114c;
        public static final int notification_tile_bg = 0x7f08114d;
        public static final int notify_panel_notification_icon_bg = 0x7f081150;
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
        public static final int accessibility_action_clickable_span = 0x7f090054;
        public static final int accessibility_custom_action_0 = 0x7f090055;
        public static final int accessibility_custom_action_1 = 0x7f090056;
        public static final int accessibility_custom_action_10 = 0x7f090057;
        public static final int accessibility_custom_action_11 = 0x7f090058;
        public static final int accessibility_custom_action_12 = 0x7f090059;
        public static final int accessibility_custom_action_13 = 0x7f09005a;
        public static final int accessibility_custom_action_14 = 0x7f09005b;
        public static final int accessibility_custom_action_15 = 0x7f09005c;
        public static final int accessibility_custom_action_16 = 0x7f09005d;
        public static final int accessibility_custom_action_17 = 0x7f09005e;
        public static final int accessibility_custom_action_18 = 0x7f09005f;
        public static final int accessibility_custom_action_19 = 0x7f090060;
        public static final int accessibility_custom_action_2 = 0x7f090061;
        public static final int accessibility_custom_action_20 = 0x7f090062;
        public static final int accessibility_custom_action_21 = 0x7f090063;
        public static final int accessibility_custom_action_22 = 0x7f090064;
        public static final int accessibility_custom_action_23 = 0x7f090065;
        public static final int accessibility_custom_action_24 = 0x7f090066;
        public static final int accessibility_custom_action_25 = 0x7f090067;
        public static final int accessibility_custom_action_26 = 0x7f090068;
        public static final int accessibility_custom_action_27 = 0x7f090069;
        public static final int accessibility_custom_action_28 = 0x7f09006a;
        public static final int accessibility_custom_action_29 = 0x7f09006b;
        public static final int accessibility_custom_action_3 = 0x7f09006c;
        public static final int accessibility_custom_action_30 = 0x7f09006d;
        public static final int accessibility_custom_action_31 = 0x7f09006e;
        public static final int accessibility_custom_action_4 = 0x7f09006f;
        public static final int accessibility_custom_action_5 = 0x7f090070;
        public static final int accessibility_custom_action_6 = 0x7f090071;
        public static final int accessibility_custom_action_7 = 0x7f090072;
        public static final int accessibility_custom_action_8 = 0x7f090073;
        public static final int accessibility_custom_action_9 = 0x7f090074;
        public static final int action_container = 0x7f090087;
        public static final int action_divider = 0x7f090089;
        public static final int action_image = 0x7f09008b;
        public static final int action_text = 0x7f090093;
        public static final int actions = 0x7f090094;
        public static final int async = 0x7f090308;
        public static final int bd_push_banner_app_icon = 0x7f0903ac;
        public static final int bd_push_banner_app_name = 0x7f0903ad;
        public static final int bd_push_banner_content = 0x7f0903ae;
        public static final int bd_push_banner_desc = 0x7f0903af;
        public static final int bd_push_banner_header = 0x7f0903b0;
        public static final int bd_push_banner_right_icon = 0x7f0903b1;
        public static final int bd_push_banner_root = 0x7f0903b2;
        public static final int bd_push_banner_time = 0x7f0903b3;
        public static final int bd_push_banner_title = 0x7f0903b4;
        public static final int bd_push_btn_end = 0x7f0903b5;
        public static final int bd_push_btn_right = 0x7f0903b6;
        public static final int bd_push_btn_start = 0x7f0903b7;
        public static final int bd_push_container = 0x7f0903b8;
        public static final int bd_push_container_shape = 0x7f0903b9;
        public static final int bd_push_icon = 0x7f0903ba;
        public static final int bd_push_im_btn_bg = 0x7f0903bb;
        public static final int bd_push_img_bg = 0x7f0903bc;
        public static final int bd_push_img_btn_bottom_bg = 0x7f0903bd;
        public static final int bd_push_img_btn_right_bg = 0x7f0903be;
        public static final int bd_push_img_goods = 0x7f0903bf;
        public static final int bd_push_img_icon = 0x7f0903c0;
        public static final int bd_push_iv_bg = 0x7f0903c1;
        public static final int bd_push_iv_big_image = 0x7f0903c2;
        public static final int bd_push_iv_button_red_dot = 0x7f0903c3;
        public static final int bd_push_iv_title_red_dot = 0x7f0903c4;
        public static final int bd_push_left_icon = 0x7f0903c5;
        public static final int bd_push_line = 0x7f0903c6;
        public static final int bd_push_lyt_btn_bottom = 0x7f0903c7;
        public static final int bd_push_lyt_btn_right = 0x7f0903c8;
        public static final int bd_push_lyt_button = 0x7f0903c9;
        public static final int bd_push_lyt_detail1 = 0x7f0903ca;
        public static final int bd_push_lyt_detail2 = 0x7f0903cb;
        public static final int bd_push_lyt_goods = 0x7f0903cc;
        public static final int bd_push_lyt_goods_content = 0x7f0903cd;
        public static final int bd_push_lyt_goods_price2 = 0x7f0903ce;
        public static final int bd_push_lyt_head = 0x7f0903cf;
        public static final int bd_push_lyt_notification_custom_head = 0x7f0903d0;
        public static final int bd_push_lyt_title_value = 0x7f0903d1;
        public static final int bd_push_right_icon = 0x7f0903d2;
        public static final int bd_push_rl_core = 0x7f0903d3;
        public static final int bd_push_rl_right_area = 0x7f0903d4;
        public static final int bd_push_title = 0x7f0903d5;
        public static final int bd_push_tv_app_name = 0x7f0903d6;
        public static final int bd_push_tv_btn_txt = 0x7f0903d7;
        public static final int bd_push_tv_content = 0x7f0903d8;
        public static final int bd_push_tv_msg = 0x7f0903d9;
        public static final int bd_push_tv_msg_hl = 0x7f0903da;
        public static final int bd_push_tv_title = 0x7f0903db;
        public static final int bd_push_txt_title_name = 0x7f0903dc;
        public static final int bd_push_txv_app_name = 0x7f0903dd;
        public static final int bd_push_txv_btn_bottom_text = 0x7f0903de;
        public static final int bd_push_txv_content_title = 0x7f0903df;
        public static final int bd_push_txv_detail1_name = 0x7f0903e0;
        public static final int bd_push_txv_detail1_value = 0x7f0903e1;
        public static final int bd_push_txv_detail2_name = 0x7f0903e2;
        public static final int bd_push_txv_detail2_value = 0x7f0903e3;
        public static final int bd_push_txv_goods_desc = 0x7f0903e4;
        public static final int bd_push_txv_goods_price1 = 0x7f0903e5;
        public static final int bd_push_txv_goods_price2 = 0x7f0903e6;
        public static final int bd_push_txv_title_value = 0x7f0903e7;
        public static final int blocking = 0x7f09043c;
        public static final int chronometer = 0x7f09075e;
        public static final int dialog_button = 0x7f0908f0;
        public static final int forever = 0x7f090c00;
        public static final int icon = 0x7f09106a;
        public static final int icon_group = 0x7f091073;
        public static final int info = 0x7f0911a2;
        public static final int italic = 0x7f091217;
        public static final int line1 = 0x7f0915eb;
        public static final int line3 = 0x7f0915ed;
        public static final int normal = 0x7f091a85;
        public static final int notification_background = 0x7f091a9d;
        public static final int notification_main_column = 0x7f091a9f;
        public static final int notification_main_column_container = 0x7f091aa0;
        public static final int right_icon = 0x7f092019;
        public static final int right_side = 0x7f092021;
        public static final int tag_accessibility_actions = 0x7f09248c;
        public static final int tag_accessibility_clickable_spans = 0x7f09248d;
        public static final int tag_accessibility_heading = 0x7f09248e;
        public static final int tag_accessibility_pane_title = 0x7f09248f;
        public static final int tag_on_apply_window_listener = 0x7f0924c9;
        public static final int tag_on_receive_content_listener = 0x7f0924ca;
        public static final int tag_on_receive_content_mime_types = 0x7f0924cb;
        public static final int tag_screen_reader_focusable = 0x7f0924e6;
        public static final int tag_state_description = 0x7f0924ef;
        public static final int tag_transition_group = 0x7f0924f6;
        public static final int tag_unhandled_key_event_manager = 0x7f0924f8;
        public static final int tag_unhandled_key_listeners = 0x7f0924f9;
        public static final int tag_window_insets_animation_callback = 0x7f092508;
        public static final int text = 0x7f09257a;
        public static final int text2 = 0x7f09257c;
        public static final int time = 0x7f09264c;
        public static final int title = 0x7f092683;
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
        public static final int bd_push_layout_customs_goods_card = 0x7f0d0166;
        public static final int bd_push_layout_customs_notification_goods_card = 0x7f0d0167;
        public static final int bd_push_layout_customs_notification_head = 0x7f0d0168;
        public static final int bd_push_layout_customs_notification_pay_card = 0x7f0d0169;
        public static final int bd_push_layout_customs_notification_picture = 0x7f0d016a;
        public static final int bd_push_notification_banner = 0x7f0d016b;
        public static final int bd_push_notification_banner_night = 0x7f0d016c;
        public static final int bd_push_notification_big_image = 0x7f0d016d;
        public static final int bd_push_notification_big_image_heads_up = 0x7f0d016e;
        public static final int bd_push_notification_double_icon = 0x7f0d016f;
        public static final int bd_push_notification_red_env_style = 0x7f0d0170;
        public static final int bd_push_notification_red_env_style_vivo = 0x7f0d0171;
        public static final int custom_dialog = 0x7f0d024b;
        public static final int notification_action = 0x7f0d0765;
        public static final int notification_action_tombstone = 0x7f0d0766;
        public static final int notification_template_custom_big = 0x7f0d076d;
        public static final int notification_template_icon_group = 0x7f0d076e;
        public static final int notification_template_part_chronometer = 0x7f0d0772;
        public static final int notification_template_part_time = 0x7f0d0773;
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
        public static final int bd_push_red_envelope = 0x7f0f0349;
        public static final int status_bar_notification_info_overflow = 0x7f0f14b6;
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
        public static final int obfuscated_res_0x7f1003bb = 0x7f1003bb;
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
            Capability = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0405ec, com.baidu.tieba.R.attr.obfuscated_res_0x7f040691};
            ColorStateListItem = new int[]{16843173, 16843551, com.baidu.tieba.R.attr.obfuscated_res_0x7f04008a};
            FontFamily = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f0402f9, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fa, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fb, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fc, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fd, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402fe, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402ff};
            FontFamilyFont = new int[]{16844082, 16844083, 16844095, 16844143, 16844144, com.baidu.tieba.R.attr.obfuscated_res_0x7f0402f6, com.baidu.tieba.R.attr.obfuscated_res_0x7f040300, com.baidu.tieba.R.attr.obfuscated_res_0x7f040301, com.baidu.tieba.R.attr.obfuscated_res_0x7f040302, com.baidu.tieba.R.attr.obfuscated_res_0x7f04084a};
            GradientColor = new int[]{16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051};
            GradientColorItem = new int[]{16843173, 16844052};
            RoundConnerImageView = new int[]{com.baidu.tieba.R.attr.obfuscated_res_0x7f040635};
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
