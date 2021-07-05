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
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MultiGraphicTextMsg extends NormalMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MultiGraphicTextMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public Article[] mArticles;

    /* loaded from: classes.dex */
    public static class Article implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<Article> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mArticleUrl;
        public String mCover;
        public String mDigest;
        public String mSchema;
        public String mTitle;

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
            CREATOR = new Parcelable.Creator<Article>() { // from class: com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg.Article.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Article createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new Article(parcel) : (Article) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Article[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new Article[i2] : (Article[]) invokeI.objValue;
                }
            };
        }

        public Article() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public String getArticleUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mArticleUrl : (String) invokeV.objValue;
        }

        public String getCover() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCover : (String) invokeV.objValue;
        }

        public String getDigest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDigest : (String) invokeV.objValue;
        }

        public String getSchema() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSchema : (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTitle : (String) invokeV.objValue;
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
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i2) == null) {
                parcel.writeString(this.mTitle);
                parcel.writeString(this.mDigest);
                parcel.writeString(this.mCover);
                parcel.writeString(this.mArticleUrl);
                parcel.writeString(this.mSchema);
            }
        }

        public Article(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        CREATOR = new Parcelable.Creator<MultiGraphicTextMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MultiGraphicTextMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new MultiGraphicTextMsg(parcel) : (MultiGraphicTextMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MultiGraphicTextMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new MultiGraphicTextMsg[i2] : (MultiGraphicTextMsg[]) invokeI.objValue;
            }
        };
    }

    public MultiGraphicTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mArticles = null;
        setMsgType(9);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public Article[] getArticles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mArticles : (Article[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Article[] articleArr = this.mArticles;
            return (articleArr == null || articleArr.length == 0) ? "" : articleArr[0].getTitle();
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Article[] articleArr = this.mArticles;
            return (articleArr == null || articleArr.length <= 0) ? "" : articleArr[0].getTitle();
        }
        return (String) invokeV.objValue;
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
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                    this.mArticles[i2] = new Article();
                    this.mArticles[i2].setTitle(jSONObject.getString("title"));
                    this.mArticles[i2].setDigest(jSONObject.optString(LightappBusinessClient.MTD_DIGEST, ""));
                    this.mArticles[i2].setCover(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, ""));
                    this.mArticles[i2].setArticleUrl(jSONObject.getString("article_url"));
                    this.mArticles[i2].setSchema(jSONObject.optString("schema"));
                }
                return true;
            } catch (JSONException e2) {
                LogUtils.e("GraphicTextMsg", "parseJsonString JSONException", e2);
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
                    jSONObject2.put(LightappBusinessClient.MTD_DIGEST, article.getDigest());
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
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            Article[] articleArr = this.mArticles;
            int length = articleArr != null ? articleArr.length : 0;
            parcel.writeInt(length);
            if (length > 0) {
                parcel.writeTypedArray(this.mArticles, i2);
            }
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
