package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class MultiGraphicTextMsg extends NormalMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<MultiGraphicTextMsg> CREATOR = new Parcelable.Creator<MultiGraphicTextMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiGraphicTextMsg createFromParcel(Parcel parcel) {
            return new MultiGraphicTextMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiGraphicTextMsg[] newArray(int i) {
            return new MultiGraphicTextMsg[i];
        }
    };
    protected Article[] mArticles;

    public MultiGraphicTextMsg() {
        this.mArticles = null;
        setMsgType(9);
    }

    public MultiGraphicTextMsg(Parcel parcel) {
        super(parcel);
        this.mArticles = null;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.mArticles = new Article[readInt];
            parcel.readTypedArray(this.mArticles, Article.CREATOR);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int i2 = 0;
        if (this.mArticles != null) {
            i2 = this.mArticles.length;
        }
        parcel.writeInt(i2);
        if (i2 > 0) {
            parcel.writeTypedArray(this.mArticles, i);
        }
    }

    public Article[] getArticles() {
        return this.mArticles;
    }

    public String getTitle() {
        return (this.mArticles == null || this.mArticles.length <= 0) ? "" : this.mArticles[0].getTitle();
    }

    public boolean setJsonContent(Article[] articleArr) {
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
                jSONObject2.put("cover", article.getCover());
                jSONObject2.put("article_url", article.getArticleUrl());
                jSONObject2.put("schema", article.getSchema());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("articles", jSONArray);
            return setMsgContent(jSONObject.toString());
        } catch (Exception e) {
            LogUtils.e("MultiGraphicTextMsg", "content error!");
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
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
                this.mArticles[i].setCover(jSONObject.optString("cover", ""));
                this.mArticles[i].setArticleUrl(jSONObject.getString("article_url"));
                this.mArticles[i].setSchema(jSONObject.optString("schema"));
            }
            return true;
        } catch (JSONException e) {
            LogUtils.e("GraphicTextMsg", "parseJsonString JSONException", e);
            return false;
        }
    }

    /* loaded from: classes18.dex */
    public static class Article implements Parcelable, NoProGuard {
        public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() { // from class: com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg.Article.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Article createFromParcel(Parcel parcel) {
                return new Article(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Article[] newArray(int i) {
                return new Article[i];
            }
        };
        private String mArticleUrl;
        private String mCover;
        private String mDigest;
        private String mSchema;
        private String mTitle;

        public Article() {
        }

        public Article(Parcel parcel) {
            this.mTitle = parcel.readString();
            this.mDigest = parcel.readString();
            this.mCover = parcel.readString();
            this.mArticleUrl = parcel.readString();
            this.mSchema = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mDigest);
            parcel.writeString(this.mCover);
            parcel.writeString(this.mArticleUrl);
            parcel.writeString(this.mSchema);
        }

        public String getTitle() {
            return this.mTitle;
        }

        public void setTitle(String str) {
            this.mTitle = str;
        }

        public String getDigest() {
            return this.mDigest;
        }

        public void setDigest(String str) {
            this.mDigest = str;
        }

        public String getCover() {
            return this.mCover;
        }

        public void setCover(String str) {
            this.mCover = str;
        }

        public String getArticleUrl() {
            return this.mArticleUrl;
        }

        public void setArticleUrl(String str) {
            this.mArticleUrl = str;
        }

        public String getSchema() {
            return this.mSchema;
        }

        public void setSchema(String str) {
            this.mSchema = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return (this.mArticles == null || this.mArticles.length == 0) ? "" : this.mArticles[0].getTitle();
    }
}
