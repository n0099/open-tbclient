package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MultiGraphicTextMsg extends NormalMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public Article[] mArticles;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes.dex */
    public class Article implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mArticleUrl;
        public String mCover;
        public String mDigest;
        public String mSchema;
        public String mTitle;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-91832512, "Lcom/baidu/android/imsdk/chatmessage/messages/MultiGraphicTextMsg$Article;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-91832512, "Lcom/baidu/android/imsdk/chatmessage/messages/MultiGraphicTextMsg$Article;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg.Article.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Article createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Article(parcel);
                    }
                    return (Article) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Article[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Article[i];
                    }
                    return (Article[]) invokeI.objValue;
                }
            };
        }

        public Article() {
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

        public String getArticleUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mArticleUrl;
            }
            return (String) invokeV.objValue;
        }

        public String getCover() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mCover;
            }
            return (String) invokeV.objValue;
        }

        public String getDigest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mDigest;
            }
            return (String) invokeV.objValue;
        }

        public String getSchema() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mSchema;
            }
            return (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mTitle;
            }
            return (String) invokeV.objValue;
        }

        public Article(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mTitle = parcel.readString();
            this.mDigest = parcel.readString();
            this.mCover = parcel.readString();
            this.mArticleUrl = parcel.readString();
            this.mSchema = parcel.readString();
        }

        public void setArticleUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mArticleUrl = str;
            }
        }

        public void setCover(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.mCover = str;
            }
        }

        public void setDigest(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.mDigest = str;
            }
        }

        public void setSchema(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.mSchema = str;
            }
        }

        public void setTitle(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.mTitle = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i) == null) {
                parcel.writeString(this.mTitle);
                parcel.writeString(this.mDigest);
                parcel.writeString(this.mCover);
                parcel.writeString(this.mArticleUrl);
                parcel.writeString(this.mSchema);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1480076238, "Lcom/baidu/android/imsdk/chatmessage/messages/MultiGraphicTextMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1480076238, "Lcom/baidu/android/imsdk/chatmessage/messages/MultiGraphicTextMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public MultiGraphicTextMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new MultiGraphicTextMsg(parcel);
                }
                return (MultiGraphicTextMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public MultiGraphicTextMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new MultiGraphicTextMsg[i];
                }
                return (MultiGraphicTextMsg[]) invokeI.objValue;
            }
        };
    }

    public MultiGraphicTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mArticles = null;
        setMsgType(9);
    }

    public Article[] getArticles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mArticles;
        }
        return (Article[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Article[] articleArr = this.mArticles;
            if (articleArr != null && articleArr.length != 0) {
                return articleArr[0].getTitle();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Article[] articleArr = this.mArticles;
            if (articleArr != null && articleArr.length > 0) {
                return articleArr[0].getTitle();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiGraphicTextMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mArticles = null;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            Article[] articleArr = new Article[readInt];
            this.mArticles = articleArr;
            parcel.readTypedArray(articleArr, Article.CREATOR);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                JSONArray optJSONArray = new JSONObject(getJsonContent()).optJSONArray("articles");
                if (optJSONArray == null) {
                    return false;
                }
                int length = optJSONArray.length();
                if (length > 0) {
                    this.mArticles = new Article[length];
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    this.mArticles[i] = new Article();
                    this.mArticles[i].setTitle(jSONObject.getString("title"));
                    this.mArticles[i].setDigest(jSONObject.optString("digest", ""));
                    this.mArticles[i].setCover(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, ""));
                    this.mArticles[i].setArticleUrl(jSONObject.getString("article_url"));
                    this.mArticles[i].setSchema(jSONObject.optString("schema"));
                }
                return true;
            } catch (JSONException e) {
                LogUtils.e("GraphicTextMsg", "parseJsonString JSONException", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean setJsonContent(Article[] articleArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, articleArr)) == null) {
            if (articleArr == null || articleArr.length == 0) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (Article article : articleArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", article.getTitle());
                    jSONObject2.put("digest", article.getDigest());
                    jSONObject2.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, article.getCover());
                    jSONObject2.put("article_url", article.getArticleUrl());
                    jSONObject2.put("schema", article.getSchema());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("articles", jSONArray);
                return setMsgContent(jSONObject.toString());
            } catch (Exception unused) {
                LogUtils.e("MultiGraphicTextMsg", "content error!");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            Article[] articleArr = this.mArticles;
            if (articleArr != null) {
                i2 = articleArr.length;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (i2 > 0) {
                parcel.writeTypedArray(this.mArticles, i);
            }
        }
    }
}
