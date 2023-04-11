package com.baidu.tbadk.core.data;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BdToastData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARSE_TOAST_DATA_KEY = "toast";
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName(NotificationCompat.WearableExtender.KEY_BACKGROUND)
    public String background;
    @SerializedName("content")
    public List<ContentBean> content;
    @SerializedName("hud_width")
    public int hudWidth;
    @SerializedName("icon_height")
    public int iconHeight;
    @SerializedName("icon_type")
    public int iconType;
    @SerializedName("icon_url")
    public String iconUrl;
    @SerializedName("icon_url_dark")
    public String iconUrlDark;
    @SerializedName("icon_width")
    public int iconWidth;
    @SerializedName("task_ids")
    public int[] taskIds;
    @SerializedName("url")
    public String url;

    /* loaded from: classes3.dex */
    public static class ContentBean implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("has_color")
        public int hasColor;
        @SerializedName("text")
        public String text;
        @SerializedName(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR)
        public String textColor;
        @SerializedName("text_color_dark")
        public String textColorDark;

        public ContentBean() {
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

        public int getHasColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.hasColor;
            }
            return invokeV.intValue;
        }

        public String getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.text;
            }
            return (String) invokeV.objValue;
        }

        public String getTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.textColor;
            }
            return (String) invokeV.objValue;
        }

        public String getTextColorDark() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.textColorDark;
            }
            return (String) invokeV.objValue;
        }

        public void setHasColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.hasColor = i;
            }
        }

        public void setText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.text = str;
            }
        }

        public void setTextColor(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.textColor = str;
            }
        }

        public void setTextColorDark(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.textColorDark = str;
            }
        }
    }

    public BdToastData() {
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

    public String getBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.background;
        }
        return (String) invokeV.objValue;
    }

    public List<ContentBean> getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.content;
        }
        return (List) invokeV.objValue;
    }

    public int getHudWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.hudWidth;
        }
        return invokeV.intValue;
    }

    public int getIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.iconHeight;
        }
        return invokeV.intValue;
    }

    public int getIconType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.iconType;
        }
        return invokeV.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getIconUrlDark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.iconUrlDark;
        }
        return (String) invokeV.objValue;
    }

    public int getIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.iconWidth;
        }
        return invokeV.intValue;
    }

    public int[] getTaskIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.taskIds;
        }
        return (int[]) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            try {
                return new JSONObject(new Gson().toJson(this));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || str == null) {
            return;
        }
        try {
            parserJson(new JSONObject(str).optJSONObject("toast"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setBackground(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.background = str;
        }
    }

    public void setContent(List<ContentBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.content = list;
        }
    }

    public void setHudWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.hudWidth = i;
        }
    }

    public void setIconHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.iconHeight = i;
        }
    }

    public void setIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.iconType = i;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.iconUrl = str;
        }
    }

    public void setIconUrlDark(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.iconUrlDark = str;
        }
    }

    public void setIconWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.iconWidth = i;
        }
    }

    public void setTaskIds(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, iArr) == null) {
            this.taskIds = iArr;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.url = str;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.iconType = jSONObject.optInt("icon_type", 0);
            this.iconUrl = jSONObject.optString("icon_url");
            this.iconUrlDark = jSONObject.optString("icon_url_dark");
            this.iconWidth = jSONObject.optInt("icon_width");
            this.iconHeight = jSONObject.optInt("icon_height");
            this.hudWidth = jSONObject.optInt("hud_width");
            JSONArray optJSONArray = jSONObject.optJSONArray("task_ids");
            if (optJSONArray != null) {
                this.taskIds = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.taskIds[i] = optJSONArray.optInt(i);
                }
            } else {
                this.taskIds = new int[0];
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("content");
            if (optJSONArray2 != null) {
                this.content = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject != null) {
                        ContentBean contentBean = new ContentBean();
                        contentBean.setText(optJSONObject.optString("text"));
                        contentBean.setHasColor(optJSONObject.optInt("has_color", 0));
                        contentBean.setTextColor(optJSONObject.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR));
                        contentBean.setTextColorDark(optJSONObject.optString("text_color_dark"));
                        this.content.add(contentBean);
                    }
                }
            }
            this.url = jSONObject.optString("url");
            this.background = jSONObject.optString(NotificationCompat.WearableExtender.KEY_BACKGROUND);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
