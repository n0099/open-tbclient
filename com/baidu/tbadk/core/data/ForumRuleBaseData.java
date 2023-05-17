package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ForumRuleBaseData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ForumRuleItemData> list;
    public List<ForumRuleItemPbData> pbDataList;
    public String preface;
    public String title;

    /* loaded from: classes4.dex */
    public static class ForumRuleItemData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String status;
        public String title;

        public ForumRuleItemData() {
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

        public String getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.content;
            }
            return (String) invokeV.objValue;
        }

        public String getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.status;
            }
            return (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public JSONObject makeJSONObject() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", this.title);
                    jSONObject.put("content", this.content);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public void setContent(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.content = str;
            }
        }

        public void setStatus(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.status = str;
            }
        }

        public void setTitle(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.title = str;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ForumRuleItemPbContentData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String href;
        public String tag;
        public String target;
        public String value;

        public ForumRuleItemPbContentData() {
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

    /* loaded from: classes4.dex */
    public static class ForumRuleItemPbData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ForumRuleItemPbContentData> mContent;
        public String status;
        public String title;

        public ForumRuleItemPbData() {
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

    public ForumRuleBaseData() {
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

    public List<ForumRuleItemData> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.list;
        }
        return (List) invokeV.objValue;
    }

    public List<ForumRuleItemPbData> getPbDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.pbDataList;
        }
        return (List) invokeV.objValue;
    }

    public String getPreface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.preface;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public void parserData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) && jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.preface = jSONObject.optString("preface");
            JSONArray optJSONArray = jSONObject.optJSONArray("rules");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        ForumRuleItemPbData forumRuleItemPbData = new ForumRuleItemPbData();
                        forumRuleItemPbData.title = optJSONObject.optString("title");
                        forumRuleItemPbData.status = optJSONObject.optString("status");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("content");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleItemPbContentData();
                                    forumRuleItemPbContentData.tag = optJSONObject2.optString("tag");
                                    forumRuleItemPbContentData.href = optJSONObject2.optString(NativeConstants.HREF);
                                    forumRuleItemPbContentData.target = optJSONObject2.optString("target");
                                    if ("a".equals(forumRuleItemPbContentData.tag)) {
                                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray("value");
                                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                            forumRuleItemPbContentData.value = optJSONArray3.optJSONObject(0).optString("value");
                                        }
                                    } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                        forumRuleItemPbContentData.value = optJSONObject2.optString("value");
                                    }
                                    arrayList2.add(forumRuleItemPbContentData);
                                }
                            }
                        }
                        forumRuleItemPbData.mContent = arrayList2;
                        arrayList.add(forumRuleItemPbData);
                    }
                }
            }
            this.pbDataList = arrayList;
        }
    }

    public void setList(List<ForumRuleItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.list = list;
        }
    }

    public void setPbDataList(List<ForumRuleItemPbData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.pbDataList = list;
        }
    }

    public void setPreface(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.preface = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.title = str;
        }
    }
}
