package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class FrsVideoTabPlayActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM = "from";
    public static final String FROM_DEFAULT = "from_default";
    public static final String FROM_FRS = "frs";
    public static final String FROM_MAINTAB_CONCERN = "concern_tab";
    public static final String FROM_MAINTAB_DAILY = "daily_tab";
    public static final String FROM_MAINTAB_RECOMMEND = "index";
    public static final String FROM_MAINTAB_VIDEO = "video_tab";
    public static final String FROM_NANI_VIDEO = "from_nani_video";
    public static final String FROM_VIDEO_ACCOUNT_ATTENTION_TAB = "video_attention_tab";
    public static final String FROM_VIDEO_ACCOUNT_TAB = "video_channel_tab";
    public static final String FROM_VIDEO_MIDDLE_VIDEO = "from_video_middle_video";
    public static final String IS_FROM_BJH_PB = "is_from_bjh_pb";
    public static final String IS_SHOW_PB_COMMENT_FLOAT = "is_show_pb_comment_float";
    public static final String KEY_FPS_MIDDLE_VIDEO = "FrsToVideoMiddle_middle_video_tran";
    public static final String KEY_FPS_MIDDLE_VIDEO_FROM = "FrsToVideoMiddle";
    public static final String KEY_FPS_MIDDLE_VIDEO_PAGE = "middle_video";
    public static final String KEY_FPS_MIDDLE_VIDEO_TYPE = "tran";
    public static final String KEY_NID = "key_nid";
    public static final String OBJ_ID = "obj_id";
    public static final String PAGE_FIRST_IN = "page_first_in";
    public static final String PAGE_FROM = "page_from";
    public static final String PARAM_IS_VERTAIL = "is_vertail";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";
    public static final String SOURCE_FROM = "source_from";
    public static final String VIDEO_ATTENTION_LIST = "video_attention_list";
    public static final String VIDEO_ATTENTION_SHOWWORD = "video_attention_showword";
    public static final String VIDEO_COVER_RECT = "video_cover_rect";
    public static final String VIDEO_DATA = "video_data";
    public static final String VIDEO_INDEX = "video_index";
    public static final String VIDEO_LIST = "video_list";
    public static final String VIDEO_SHOW_INDEX = "video_show_index";
    public static Map<String, Integer> frsPageCountMap;
    public static Map<String, List<VideoItemData>> frsVideoTabListMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(257035740, "Lcom/baidu/tbadk/core/atomData/FrsVideoTabPlayActivityConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(257035740, "Lcom/baidu/tbadk/core/atomData/FrsVideoTabPlayActivityConfig;");
                return;
            }
        }
        frsVideoTabListMap = new HashMap();
        frsPageCountMap = new HashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoTabPlayActivityConfig(Context context, List<VideoItemData> list, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i2);
    }

    public static void addFrsPageCount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            if (frsPageCountMap == null) {
                frsPageCountMap = new HashMap();
            }
            if (!frsPageCountMap.containsKey(str)) {
                frsPageCountMap.put(str, 0);
            }
            frsPageCountMap.put(str, Integer.valueOf(getSafeInteger(frsPageCountMap.get(str)) + 1));
        }
    }

    public static int getSafeInteger(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, num)) == null) {
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public static List<VideoItemData> getVideoTabListByFid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            int safeInteger = getSafeInteger(frsPageCountMap.get(str));
            initVideoTabListByFid(str);
            Map<String, List<VideoItemData>> map = frsVideoTabListMap;
            return map.get(str + "_" + safeInteger);
        }
        return (List) invokeL.objValue;
    }

    public static void initVideoTabListByFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            int safeInteger = getSafeInteger(frsPageCountMap.get(str));
            if (frsVideoTabListMap == null) {
                frsVideoTabListMap = new HashMap();
            }
            Map<String, List<VideoItemData>> map = frsVideoTabListMap;
            if (map.containsKey(str + "_" + safeInteger)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Map<String, List<VideoItemData>> map2 = frsVideoTabListMap;
            map2.put(str + "_" + safeInteger, arrayList);
        }
    }

    public static void putVideoTabListByFid(String str, List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, list) == null) {
            int safeInteger = getSafeInteger(frsPageCountMap.get(str));
            initVideoTabListByFid(str);
            Map<String, List<VideoItemData>> map = frsVideoTabListMap;
            map.put(str + "_" + safeInteger, list);
        }
    }

    public static void removeVideoTabListByFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            int safeInteger = getSafeInteger(frsPageCountMap.get(str));
            Map<String, List<VideoItemData>> map = frsVideoTabListMap;
            if (map != null) {
                map.remove(str + "_" + safeInteger);
            }
        }
    }

    public static void subtractFrsPageCount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            if (frsPageCountMap == null) {
                frsPageCountMap = new HashMap();
            }
            if (frsPageCountMap.containsKey(str)) {
                int safeInteger = getSafeInteger(frsPageCountMap.get(str)) - 1;
                if (safeInteger > 0) {
                    frsPageCountMap.put(str, Integer.valueOf(safeInteger));
                } else {
                    frsPageCountMap.remove(str);
                }
            }
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("forum_id", str);
    }

    public void setIsFromBjhPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            getIntent().putExtra("is_from_bjh_pb", z);
        }
    }

    public void setIsShowPbCommentFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("is_show_pb_comment_float", z);
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("key_nid", str);
    }

    public void setParamIsVertail(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("is_vertail", z);
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, uri) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(IntentConfig.KEY_URI, uri);
    }

    public void setVideoShowIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            getIntent().putExtra("video_show_index", i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoTabPlayActivityConfig(Context context, List<VideoItemData> list, int i2, Rect rect, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i2), rect, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i2);
        getIntent().putExtra("from", str);
        getIntent().setSourceBounds(rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoTabPlayActivityConfig(Context context, List<VideoItemData> list, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, str2};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("from", str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoTabPlayActivityConfig(Context context, List<VideoItemData> list, int i2, Rect rect, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i2), rect, str, str2, str3, str4};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i2);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("st_type", str2);
        getIntent().putExtra("yuelaou_locate", str3);
        getIntent().putExtra("from", str4);
        getIntent().setSourceBounds(rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoTabPlayActivityConfig(Context context, List<VideoItemData> list, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i2), rect, str, str2, str3, str4, str5};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i2);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("st_type", str2);
        getIntent().putExtra("yuelaou_locate", str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra("source_from", str5);
        getIntent().setSourceBounds(rect);
    }
}
