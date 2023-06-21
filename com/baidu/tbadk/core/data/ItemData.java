package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.ug;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ApkDetail;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes4.dex */
public class ItemData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSOCIATED_ITEM_DATA_FORMAT = "#(item,%d,%s)";
    public transient /* synthetic */ FieldHolder $fh;
    public transient ApkDetail apkDetail;
    public String appId;
    public String buttonLink;
    public Integer buttonLinkType;
    public String buttonName;
    public String forumName;
    public long itemId;
    public double mIconSize;
    public String mIconUrl;
    public double mScore;
    public int mStar;
    public List<String> mTags;
    public String mTitle;
    public String pkgName;

    public ItemData() {
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

    public void parseItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbRichTextEvaluateItemInfo) != null) || tbRichTextEvaluateItemInfo == null) {
            return;
        }
        this.mIconUrl = tbRichTextEvaluateItemInfo.getIconUrl();
        this.mTitle = tbRichTextEvaluateItemInfo.getTitle();
        this.mTags = tbRichTextEvaluateItemInfo.getTags();
        this.mScore = tbRichTextEvaluateItemInfo.getScore();
        this.mStar = tbRichTextEvaluateItemInfo.getStar();
        this.mIconSize = tbRichTextEvaluateItemInfo.getIconSize();
    }

    public void parseJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            parseJson(str, true);
        }
    }

    public void parseJson(String str, boolean z) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.itemId = jSONObject.optLong("item_id");
                this.mTitle = jSONObject.optString("item_name");
                this.mIconSize = jSONObject.optDouble("icon_size");
                this.mIconUrl = jSONObject.optString("icon_url");
                this.mScore = jSONObject.optDouble("score");
                this.mStar = jSONObject.optInt("star");
                this.buttonName = jSONObject.optString("button_name");
                this.buttonLink = jSONObject.optString("button_link");
                this.buttonLinkType = Integer.valueOf(jSONObject.optInt("button_link_type"));
                this.forumName = jSONObject.optString("forum_name");
                this.pkgName = jSONObject.optString("apk_name");
                this.appId = jSONObject.optString("item_appid");
                if (z && (optJSONObject = jSONObject.optJSONObject("apk_detail")) != null) {
                    ApkDetail.Builder builder = new ApkDetail.Builder();
                    builder.developer = optJSONObject.optString("developer");
                    builder.publisher = optJSONObject.optString("publisher");
                    builder.version = optJSONObject.optString("version");
                    builder.version_code = Integer.valueOf(optJSONObject.optInt("version_code"));
                    builder.update_time = optJSONObject.optString("update_time");
                    builder.size = optJSONObject.optString("size");
                    builder.need_network = Integer.valueOf(optJSONObject.optInt("need_network"));
                    builder.need_inner_buy = Integer.valueOf(optJSONObject.optInt("need_inner_buy"));
                    builder.authority_url = optJSONObject.optString("authority_url");
                    builder.privacy_url = optJSONObject.optString("privacy_url");
                    builder.pkg_source = Integer.valueOf(optJSONObject.optInt("pkg_source"));
                    this.apkDetail = builder.build(true);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(TaskProcess.keyTags);
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.optString(i));
                    }
                    this.mTags = arrayList;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void parseProto(Item item) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, item) != null) || item == null) {
            return;
        }
        this.mIconUrl = item.icon_url;
        this.mTitle = item.item_name;
        this.mTags = item.tags;
        this.mScore = item.score.doubleValue();
        this.mStar = item.star.intValue();
        this.mIconSize = item.icon_size.doubleValue();
        this.itemId = item.item_id.longValue();
        this.buttonName = item.button_name;
        this.buttonLink = item.button_link;
        this.buttonLinkType = item.button_link_type;
        this.pkgName = item.apk_name;
        this.forumName = item.forum_name;
        this.apkDetail = item.apk_detail;
        this.appId = item.item_appid;
    }

    public void parseProto(ItemInfo itemInfo) {
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, itemInfo) != null) || itemInfo == null) {
            return;
        }
        this.mIconUrl = itemInfo.icon_url;
        this.mTitle = itemInfo.name;
        this.mTags = itemInfo.tags;
        ItemTable itemTable = itemInfo.score;
        if (itemTable != null && (list = itemTable.item_point) != null) {
            Iterator<ItemPoint> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ItemPoint next = it.next();
                if (next != null && "all".equals(next.time_intval)) {
                    this.mScore = next.point.doubleValue();
                    break;
                }
            }
        }
        this.mIconSize = itemInfo.icon_size.doubleValue();
        this.itemId = ug.g(String.valueOf(itemInfo.id), 0L);
        this.buttonName = itemInfo.button_name;
        this.buttonLink = itemInfo.button_link;
        this.buttonLinkType = itemInfo.button_link_type;
        this.pkgName = itemInfo.apk_name;
        this.forumName = itemInfo.forum_name;
        this.apkDetail = itemInfo.apk_detail;
        this.appId = itemInfo.item_appid;
    }

    public void parseProto(TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, tiebaPlusInfo) != null) || tiebaPlusInfo == null) {
            return;
        }
        this.mTitle = tiebaPlusInfo.title;
        this.buttonLink = tiebaPlusInfo.download_url;
        this.pkgName = tiebaPlusInfo.app_package;
        this.appId = tiebaPlusInfo.app_id;
        this.mIconUrl = tiebaPlusInfo.app_icon;
        this.mIconSize = 1.0d;
        this.itemId = ug.g(String.valueOf(tiebaPlusInfo.item_id), 0L);
        ApkDetail.Builder builder = new ApkDetail.Builder();
        builder.version = tiebaPlusInfo.app_version;
        builder.privacy_url = tiebaPlusInfo.app_privacy;
        builder.authority_url = tiebaPlusInfo.app_power;
        builder.developer = tiebaPlusInfo.app_company;
        this.apkDetail = builder.build(true);
    }
}
