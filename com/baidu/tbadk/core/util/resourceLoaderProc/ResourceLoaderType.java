package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ResourceLoaderType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_DISTRIBUTE = 30;
    public static final int APP_DISTRIBUTE_NO_CDN = 31;
    public static final int BIGDAY_IMAGE = 41;
    public static final int BIG_IMAGE = 27;
    public static final int EMOTIONS = 20;
    public static final int EMOTION_SHARE = 34;
    public static final int FLUTTER_SIMPLE = 44;
    public static final int FRS_ABSTRACT = 13;
    public static final int FRS_ABSTRACT_NO_CDN = 14;
    public static final int FRS_HEADER_ICON = 15;
    public static final int FRS_STAR_HEADER_ICON = 16;
    public static final int GAME_HOT_RANK_ENTRY = 48;
    public static final int ICONS = 21;
    public static final int ICONS_MEMORY_FOREVER = 45;
    public static final int LOCAL_FILE_FIT_IMAGE = 36;
    public static final int LOCAL_FILE_IMAGE_WITH_WH = 43;
    public static final int LOCAL_FILE_PIC = 32;
    public static final int LOCAL_FILE_THUMB = 35;
    public static final int LOCAL_PIC_DRAWABLE = 24;
    public static final int LOCAL_VIDEO_THUMB = 37;
    public static final int NET_MEME = 33;
    public static final int NINE_PATCH = 19;
    public static final int NORMAL_IMAGE = 38;
    public static final int PB = 17;
    public static final int PB_NO_CDN = 18;
    public static final int PORTRAIT = 12;
    public static final int PORTRAIT_BIG = 25;
    public static final int PORTRAIT_BLUR = 40;
    public static final int PORTRAIT_FORCELOAD = 26;
    public static final int PORTRAIT_SETTING = 28;
    public static final int SCREEN_2_3 = 46;
    public static final int SCREEN_2_3_NO_CDN = 47;
    public static final int SIMPLE = 10;
    public static final int SIMPLE_BLUR = 39;
    public static final int SIMPLE_FOREVER = 29;
    public static final int SIMPLE_NO_CDN = 11;
    public static final int SIMPLE_NO_FORMAT = 42;
    public static final int VOICE = 23;
    public transient /* synthetic */ FieldHolder $fh;

    public ResourceLoaderType() {
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
