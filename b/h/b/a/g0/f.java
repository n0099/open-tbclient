package b.h.b.a.g0;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] AspectRatioFrameLayout;
    public static final int AspectRatioFrameLayout_resize_mode = 0;
    public static final int[] DefaultTimeBar;
    public static final int DefaultTimeBar_ad_marker_color = 0;
    public static final int DefaultTimeBar_ad_marker_width = 1;
    public static final int DefaultTimeBar_bar_height = 2;
    public static final int DefaultTimeBar_buffered_color = 3;
    public static final int DefaultTimeBar_played_ad_marker_color = 4;
    public static final int DefaultTimeBar_played_color = 5;
    public static final int DefaultTimeBar_scrubber_color = 6;
    public static final int DefaultTimeBar_scrubber_disabled_size = 7;
    public static final int DefaultTimeBar_scrubber_dragged_size = 8;
    public static final int DefaultTimeBar_scrubber_drawable = 9;
    public static final int DefaultTimeBar_scrubber_enabled_size = 10;
    public static final int DefaultTimeBar_touch_target_height = 11;
    public static final int DefaultTimeBar_unplayed_color = 12;
    public static final int[] PlaybackControlView;
    public static final int PlaybackControlView_controller_layout_id = 0;
    public static final int PlaybackControlView_fastforward_increment = 1;
    public static final int PlaybackControlView_repeat_toggle_modes = 2;
    public static final int PlaybackControlView_rewind_increment = 3;
    public static final int PlaybackControlView_show_shuffle_button = 4;
    public static final int PlaybackControlView_show_timeout = 5;
    public static final int[] SimpleExoPlayerView;
    public static final int SimpleExoPlayerView_auto_show = 0;
    public static final int SimpleExoPlayerView_controller_layout_id = 1;
    public static final int SimpleExoPlayerView_default_artwork = 2;
    public static final int SimpleExoPlayerView_fastforward_increment = 3;
    public static final int SimpleExoPlayerView_hide_on_touch = 4;
    public static final int SimpleExoPlayerView_player_layout_id = 5;
    public static final int SimpleExoPlayerView_resize_mode = 6;
    public static final int SimpleExoPlayerView_rewind_increment = 7;
    public static final int SimpleExoPlayerView_show_timeout = 8;
    public static final int SimpleExoPlayerView_shutter_background_color = 9;
    public static final int SimpleExoPlayerView_surface_type = 10;
    public static final int SimpleExoPlayerView_use_artwork = 11;
    public static final int SimpleExoPlayerView_use_controller = 12;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1371410432, "Lb/h/b/a/g0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1371410432, "Lb/h/b/a/g0/f;");
                return;
            }
        }
        AspectRatioFrameLayout = new int[]{R.attr.resize_mode};
        DefaultTimeBar = new int[]{R.attr.ad_marker_color, R.attr.ad_marker_width, R.attr.bar_height, R.attr.buffered_color, R.attr.played_ad_marker_color, R.attr.played_color, R.attr.scrubber_color, R.attr.scrubber_disabled_size, R.attr.scrubber_dragged_size, R.attr.scrubber_drawable, R.attr.scrubber_enabled_size, R.attr.touch_target_height, R.attr.unplayed_color};
        PlaybackControlView = new int[]{R.attr.controller_layout_id, R.attr.fastforward_increment, R.attr.repeat_toggle_modes, R.attr.rewind_increment, R.attr.show_shuffle_button, R.attr.show_timeout};
        SimpleExoPlayerView = new int[]{R.attr.auto_show, R.attr.controller_layout_id, R.attr.default_artwork, R.attr.fastforward_increment, R.attr.hide_on_touch, R.attr.player_layout_id, R.attr.resize_mode, R.attr.rewind_increment, R.attr.show_timeout, R.attr.shutter_background_color, R.attr.surface_type, R.attr.use_artwork, R.attr.use_controller};
    }
}
