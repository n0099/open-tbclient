package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.McnAdInfo;
import tbclient.ThreadPicList;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class JsonTransHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonTransHelper() {
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

    public static ActionControl parseActionControlFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ActionControl.Builder builder = new ActionControl.Builder();
            builder.url = jSONObject.optString("url");
            builder.name = jSONObject.optString("name");
            builder.text_color = jSONObject.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
            builder.text_color_pressed = jSONObject.optString("text_color_pressed");
            return builder.build(false);
        }
        return (ActionControl) invokeL.objValue;
    }

    public static VideoDesc parseVideoDescFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            VideoDesc.Builder builder = new VideoDesc.Builder();
            builder.video_id = Integer.valueOf(jSONObject.optInt("video_id"));
            builder.video_md5 = jSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
            builder.video_url = jSONObject.optString("video_url");
            builder.video_width = jSONObject.optString("video_width");
            builder.video_height = jSONObject.optString("video_height");
            return builder.build(false);
        }
        return (VideoDesc) invokeL.objValue;
    }

    public static JSONObject toMcnAdInfoJson(McnAdInfo mcnAdInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, mcnAdInfo)) == null) {
            if (mcnAdInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ad_start_time", mcnAdInfo.ad_start_time);
                jSONObject.put("ad_end_time", mcnAdInfo.ad_end_time);
                jSONObject.put("pic_url", mcnAdInfo.pic_url);
                jSONObject.put(BigdayActivityConfig.JUMP_URL, mcnAdInfo.jump_url);
                jSONObject.put("card_title", mcnAdInfo.card_title);
                jSONObject.put("button_title", mcnAdInfo.button_title);
                jSONObject.put("effect_time", mcnAdInfo.effect_time);
                jSONObject.put("expire_time", mcnAdInfo.expire_time);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject toVideoDescJson(VideoDesc videoDesc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, videoDesc)) == null) {
            if (videoDesc == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("video_id", videoDesc.video_id);
                jSONObject.put(VideoFinishResult.KEY_VIDEO_MD5, videoDesc.video_md5);
                jSONObject.put("video_url", videoDesc.video_url);
                jSONObject.put("video_width", videoDesc.video_width);
                jSONObject.put("video_height", videoDesc.video_height);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static AdCloseInfo parseAdCloseInfoFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            AdCloseInfo.Builder builder = new AdCloseInfo.Builder();
            builder.support_close = Integer.valueOf(jSONObject.optInt("support_close"));
            builder.title = jSONObject.optString("title");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("reasons");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        arrayList.add(optJSONArray.getString(i));
                    } catch (Exception unused) {
                    }
                }
                builder.reasons = arrayList;
            }
            builder.reasons = arrayList;
            builder.confirm_title = jSONObject.optString("confirm_title");
            builder.action_control = parseActionControlFromJson(jSONObject.optJSONObject("action_control"));
            return builder.build(false);
        }
        return (AdCloseInfo) invokeL.objValue;
    }

    public static McnAdInfo parseMcnAdInfoFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            McnAdInfo.Builder builder = new McnAdInfo.Builder();
            builder.ad_start_time = Long.valueOf(jSONObject.optLong("ad_start_time"));
            builder.ad_end_time = Long.valueOf(jSONObject.optLong("ad_end_time"));
            builder.pic_url = jSONObject.optString("pic_url");
            builder.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            builder.card_title = jSONObject.optString("card_title");
            builder.button_title = jSONObject.optString("button_title");
            builder.effect_time = Long.valueOf(jSONObject.optLong("effect_time"));
            builder.expire_time = Long.valueOf(jSONObject.optLong("expire_time"));
            return builder.build(false);
        }
        return (McnAdInfo) invokeL.objValue;
    }

    public static JSONObject toAdCloseInfoJson(AdCloseInfo adCloseInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adCloseInfo)) == null) {
            if (adCloseInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("support_close", adCloseInfo.support_close);
                jSONObject.put("title", adCloseInfo.title);
                JSONArray jSONArray = new JSONArray();
                for (String str : adCloseInfo.reasons) {
                    jSONArray.put(str);
                }
                jSONObject.put("reasons", jSONArray);
                jSONObject.put("confirm_title", adCloseInfo.confirm_title);
                jSONObject.put("action_control", toActionControlJson(adCloseInfo.action_control));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static App parseAppFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            App.Builder builder = new App.Builder();
            builder.type = Integer.valueOf(jSONObject.optInt("type"));
            builder.pos = Integer.valueOf(jSONObject.optInt("pos"));
            builder.icon_url = jSONObject.optString("icon_url");
            builder.icon_link = jSONObject.optString("icon_link");
            builder.app_name = jSONObject.optString("app_name");
            builder.app_desc = jSONObject.optString("app_desc");
            builder.p_name = jSONObject.optString("p_name");
            builder.p_url = jSONObject.optString("p_url");
            builder.img_url = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            builder.app_time = Integer.valueOf(jSONObject.optInt("app_time"));
            builder.web_url = jSONObject.optString("web_url");
            builder.ad_id = jSONObject.optString(LegoListActivityConfig.AD_ID);
            builder.id = jSONObject.optString("id");
            builder.name = jSONObject.optString("name");
            builder.url_type = Integer.valueOf(jSONObject.optInt("url_type"));
            builder.url = jSONObject.optString("url");
            builder.ios_url = jSONObject.optString("ios_url");
            builder.apk_url = jSONObject.optString("apk_url");
            builder.apk_name = jSONObject.optString("apk_name");
            builder.pos_name = jSONObject.optString("pos_name");
            builder.first_name = jSONObject.optString("first_name");
            builder.second_name = jSONObject.optString("second_name");
            builder.cpid = Integer.valueOf(jSONObject.optInt("cpid"));
            builder.abtest = jSONObject.optString("abtest");
            builder.plan_id = Integer.valueOf(jSONObject.optInt("plan_id"));
            builder.user_id = jSONObject.optString("user_id");
            builder.price = jSONObject.optString("price");
            builder.verify = jSONObject.optString(SmsLoginView.f.j);
            builder.ext_info = jSONObject.optString(MigrateStatisticUtils.EXT_INFO);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("goods_info");
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(parseGoodsFromJson(optJSONArray.optJSONObject(i)));
            }
            builder.goods_info = arrayList;
            builder.loc_code = jSONObject.optString("loc_code");
            builder.deep_url = jSONObject.optString("deep_url");
            return builder.build(false);
        }
        return (App) invokeL.objValue;
    }

    public static GoodsInfo parseGoodsFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            GoodsInfo.Builder builder = new GoodsInfo.Builder();
            builder.id = Integer.valueOf(jSONObject.optInt("id"));
            builder.user_name = jSONObject.optString("user_name");
            builder.user_portrait = jSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
            builder.thread_title = jSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            builder.thread_pic = jSONObject.optString("thread_pic");
            builder.pop_window_text = jSONObject.optString("pop_window_text");
            builder.goods_style = Integer.valueOf(jSONObject.optInt("goods_style"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(parseThreadPicListFromJson(optJSONArray.optJSONObject(i)));
            }
            builder.thread_pic_list = arrayList;
            builder.label_visible = Integer.valueOf(jSONObject.optInt("label_visible"));
            builder.label_text = jSONObject.optString("label_text");
            builder.rank_level = Integer.valueOf(jSONObject.optInt("rank_level"));
            builder.thread_type = jSONObject.optString("thread_type");
            builder.button_text = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            builder.card_desc = jSONObject.optString("card_desc");
            builder.card_tag = jSONObject.optString("card_tag");
            builder.width = Integer.valueOf(jSONObject.optInt("width"));
            builder.height = Integer.valueOf(jSONObject.optInt("height"));
            builder.label_measure = Integer.valueOf(jSONObject.optInt("label_measure"));
            builder.thread_content = jSONObject.optString("thread_content");
            builder.lego_card = jSONObject.optString("lego_card");
            builder.video_info = parseVideoInfoFromJson(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
            builder.tag_name = jSONObject.optString(PushConstants.SUB_TAGS_STATUS_NAME);
            builder.button_url = jSONObject.optString("button_url");
            builder.ad_source = jSONObject.optString("ad_source");
            builder.tag_name_url = jSONObject.optString("tag_name_url");
            builder.tag_name_wh = jSONObject.optString("tag_name_wh");
            builder.brand_icon = jSONObject.optString("brand_icon");
            builder.brand_icon_wh = jSONObject.optString("brand_icon_wh");
            builder.close_info = parseAdCloseInfoFromJson(jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO));
            return builder.build(false);
        }
        return (GoodsInfo) invokeL.objValue;
    }

    public static JSONObject toAppJson(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, app)) == null) {
            if (app == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", app.type);
                jSONObject.put("pos", app.pos);
                jSONObject.put("icon_url", app.icon_url);
                jSONObject.put("icon_link", app.icon_link);
                jSONObject.put("app_name", app.app_name);
                jSONObject.put("app_desc", app.app_desc);
                jSONObject.put("p_name", app.p_name);
                jSONObject.put("p_url", app.p_url);
                jSONObject.put(BigdayActivityConfig.IMG_URL, app.img_url);
                jSONObject.put("app_time", app.app_time);
                jSONObject.put("web_url", app.web_url);
                jSONObject.put(LegoListActivityConfig.AD_ID, app.ad_id);
                jSONObject.put("id", app.id);
                jSONObject.put("name", app.name);
                jSONObject.put("url_type", app.url_type);
                jSONObject.put("url", app.url);
                jSONObject.put("ios_url", app.ios_url);
                jSONObject.put("apk_url", app.apk_url);
                jSONObject.put("apk_name", app.apk_name);
                jSONObject.put("pos_name", app.pos_name);
                jSONObject.put("first_name", app.first_name);
                jSONObject.put("second_name", app.second_name);
                jSONObject.put("cpid", app.cpid);
                jSONObject.put("abtest", app.abtest);
                jSONObject.put("plan_id", app.plan_id);
                jSONObject.put("user_id", app.user_id);
                jSONObject.put("price", app.price);
                jSONObject.put(SmsLoginView.f.j, app.verify);
                jSONObject.put(MigrateStatisticUtils.EXT_INFO, app.ext_info);
                JSONArray jSONArray = new JSONArray();
                for (GoodsInfo goodsInfo : app.goods_info) {
                    jSONArray.put(toGoodsInfoJson(goodsInfo));
                }
                jSONObject.put("goods_info", jSONArray);
                jSONObject.put("loc_code", app.loc_code);
                jSONObject.put("deep_url", app.deep_url);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static ThreadPicList parseThreadPicListFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ThreadPicList.Builder builder = new ThreadPicList.Builder();
            builder.pic = jSONObject.optString(pic.f);
            return builder.build(false);
        }
        return (ThreadPicList) invokeL.objValue;
    }

    public static JSONObject toThreadPicListJson(ThreadPicList threadPicList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, threadPicList)) == null) {
            if (threadPicList == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(pic.f, threadPicList.pic);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static VideoInfo parseVideoInfoFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = jSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
            builder.video_url = jSONObject.optString("video_url");
            builder.video_duration = Integer.valueOf(jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION));
            builder.video_width = Integer.valueOf(jSONObject.optInt("video_width"));
            builder.video_height = Integer.valueOf(jSONObject.optInt("video_height"));
            builder.thumbnail_url = jSONObject.optString("thumbnail_url");
            builder.thumbnail_width = Integer.valueOf(jSONObject.optInt("thumbnail_width"));
            builder.thumbnail_height = Integer.valueOf(jSONObject.optInt("thumbnail_height"));
            builder.video_length = Integer.valueOf(jSONObject.optInt("video_length"));
            builder.play_count = Integer.valueOf(jSONObject.optInt("play_count"));
            builder.media_subtitle = jSONObject.optString("media_subtitle");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("video_desc");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(parseVideoDescFromJson(optJSONArray.optJSONObject(i)));
                }
                builder.video_desc = arrayList;
            }
            builder.video_select_flag = Integer.valueOf(jSONObject.optInt("video_select_flag"));
            builder.video_type = Integer.valueOf(jSONObject.optInt("video_type"));
            builder.is_vertical = Integer.valueOf(jSONObject.optInt(TiebaStatic.Params.IS_VERTICAL));
            builder.video_h265 = parseVideoDescFromJson(jSONObject.optJSONObject("video_h265"));
            builder.mcn_lead_page = jSONObject.optString("mcn_lead_page");
            builder.mcn_ad_card = parseMcnAdInfoFromJson(jSONObject.optJSONObject("mcn_ad_card"));
            builder.wth_mid_loc = Double.valueOf(jSONObject.optDouble("wth_mid_loc"));
            builder.hth_mid_loc = Double.valueOf(jSONObject.optDouble("hth_mid_loc"));
            return builder.build(false);
        }
        return (VideoInfo) invokeL.objValue;
    }

    public static JSONObject toGoodsInfoJson(GoodsInfo goodsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, goodsInfo)) == null) {
            if (goodsInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", goodsInfo.id);
                jSONObject.put("user_name", goodsInfo.user_name);
                jSONObject.put(RecommendDetailActivityConfig.USER_PORTRAIT, goodsInfo.user_portrait);
                jSONObject.put(MissonDetailsActivityConfig.THREAD_TITLE, goodsInfo.thread_title);
                jSONObject.put("thread_pic", goodsInfo.thread_pic);
                jSONObject.put("pop_window_text", goodsInfo.pop_window_text);
                jSONObject.put("goods_style", goodsInfo.goods_style);
                JSONArray jSONArray = new JSONArray();
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    jSONArray.put(toThreadPicListJson(threadPicList));
                }
                jSONObject.put("thread_pic_list", jSONArray);
                jSONObject.put("label_visible", goodsInfo.label_visible);
                jSONObject.put("label_text", goodsInfo.label_text);
                jSONObject.put("rank_level", goodsInfo.rank_level);
                jSONObject.put("thread_type", goodsInfo.thread_type);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, goodsInfo.button_text);
                jSONObject.put("card_desc", goodsInfo.card_desc);
                jSONObject.put("card_tag", goodsInfo.card_tag);
                jSONObject.put("width", goodsInfo.width);
                jSONObject.put("height", goodsInfo.height);
                jSONObject.put("label_measure", goodsInfo.label_measure);
                jSONObject.put("thread_content", goodsInfo.thread_content);
                jSONObject.put("lego_card", goodsInfo.lego_card);
                jSONObject.put(WriteActivityConfig.VIDEO_INFO, toVideoInfoJson(goodsInfo.video_info));
                jSONObject.put(PushConstants.SUB_TAGS_STATUS_NAME, goodsInfo.tag_name);
                jSONObject.put("button_url", goodsInfo.button_url);
                jSONObject.put("ad_source", goodsInfo.ad_source);
                jSONObject.put("tag_name_url", goodsInfo.tag_name_url);
                jSONObject.put("tag_name_wh", goodsInfo.tag_name_wh);
                jSONObject.put("brand_icon", goodsInfo.brand_icon);
                jSONObject.put("brand_icon_wh", goodsInfo.brand_icon_wh);
                jSONObject.put(GameGuideConfigInfo.KEY_CLOSE_INFO, toAdCloseInfoJson(goodsInfo.close_info));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject toVideoInfoJson(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, videoInfo)) == null) {
            if (videoInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(VideoFinishResult.KEY_VIDEO_MD5, videoInfo.video_md5);
                jSONObject.put("video_url", videoInfo.video_url);
                jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration);
                jSONObject.put("video_width", videoInfo.video_width);
                jSONObject.put("video_height", videoInfo.video_height);
                jSONObject.put("thumbnail_url", videoInfo.thumbnail_url);
                jSONObject.put("thumbnail_width", videoInfo.thumbnail_width);
                jSONObject.put("thumbnail_height", videoInfo.thumbnail_height);
                jSONObject.put("video_length", videoInfo.video_length);
                jSONObject.put("play_count", videoInfo.play_count);
                jSONObject.put("media_subtitle", videoInfo.media_subtitle);
                JSONArray jSONArray = new JSONArray();
                for (VideoDesc videoDesc : videoInfo.video_desc) {
                    jSONArray.put(toVideoDescJson(videoDesc));
                }
                jSONObject.put("video_desc", jSONArray);
                jSONObject.put("video_select_flag", videoInfo.video_select_flag);
                jSONObject.put("video_type", videoInfo.video_type);
                jSONObject.put(TiebaStatic.Params.IS_VERTICAL, videoInfo.is_vertical);
                jSONObject.put("video_h265", toVideoDescJson(videoInfo.video_h265));
                jSONObject.put("mcn_lead_page", videoInfo.mcn_lead_page);
                jSONObject.put("mcn_ad_card", toMcnAdInfoJson(videoInfo.mcn_ad_card));
                jSONObject.put("wth_mid_loc", videoInfo.wth_mid_loc);
                jSONObject.put("hth_mid_loc", videoInfo.hth_mid_loc);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject toActionControlJson(ActionControl actionControl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, actionControl)) == null) {
            if (actionControl == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", actionControl.url);
                jSONObject.put("name", actionControl.name);
                jSONObject.put(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, actionControl.text_color);
                jSONObject.put("text_color_pressed", actionControl.text_color_pressed);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
