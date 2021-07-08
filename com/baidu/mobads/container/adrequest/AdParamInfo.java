package com.baidu.mobads.container.adrequest;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AdParamInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface AdClickActionInt {
        public static final int ACTION_TYPE_APO = 512;
        public static final int ACTION_TYPE_CALL = 32;
        public static final int ACTION_TYPE_DL = 2;
        public static final int ACTION_TYPE_LP = 1;
        public static final int ACTION_TYPE_MAIL = 16;
        public static final int ACTION_TYPE_MAP = 4;
        public static final int ACTION_TYPE_PLAY_VIDEO = 64;
        public static final int ACTION_TYPE_RICH_MEDIA = 128;
        public static final int ACTION_TYPE_SMS = 8;
    }

    /* loaded from: classes2.dex */
    public interface AdClickActionString {
        public static final String AD_CLICK_ACTION_APO = "APO";
        public static final String AD_CLICK_ACTION_DL = "DL";
        public static final String AD_CLICK_ACTION_LP = "LP";
        public static final String AD_CLICK_ACTION_MAIL = "MAIL";
        public static final String AD_CLICK_ACTION_MAP = "MAP";
        public static final String AD_CLICK_ACTION_NA = "NA";
        public static final String AD_CLICK_ACTION_PHONE = "PHONE";
        public static final String AD_CLICK_ACTION_RM = "RM";
        public static final String AD_CLICK_ACTION_SMS = "SMS";
        public static final String AD_CLICK_ACTION_VIDEO = "VIDEO";
    }

    /* loaded from: classes2.dex */
    public interface AdCreativeType {
        public static final int AD_CREATIVE_IMAGE = 2;
        public static final int AD_CREATIVE_RICHMEDIA = 16;
        public static final int AD_CREATIVE_TEXT = 1;
        public static final int AD_CREATIVE_VIDEO = 8;
    }

    /* loaded from: classes2.dex */
    public interface AdMateFormat {
        public static final String GIF = "gif";
        public static final String HTML = "html";
        public static final String HYBRID = "hybrid";
        public static final String NONE = "none";
        public static final String RM = "rich_media";
        public static final String STATIC_IMAGE = "static_image";
        public static final String TEXT = "text";
        public static final String VIDEO = "video";
    }

    /* loaded from: classes2.dex */
    public interface AdProdType {
        public static final String BANNER = "banner";
        public static final String CONTENT = "content";
        public static final String CPU = "cpu";
        public static final String CPU_URL = "cpu_h5";
        public static final String FEEDS = "feed";
        public static final String FULLSCREENVIDEO = "fvideo";
        public static final String INSITE = "insite";
        public static final String INTERSTITIAL = "int";
        public static final String JSSDK = "jssdk";
        public static final String PORTRAITVIDEO = "pvideo";
        public static final String PREROLL = "preroll";
        public static final String REWARDVIDEO = "rvideo";
        public static final String SPLASH = "rsplash";
        public static final String SUG = "sug";
        public static final String VIDEO = "video";
    }

    public AdParamInfo() {
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
