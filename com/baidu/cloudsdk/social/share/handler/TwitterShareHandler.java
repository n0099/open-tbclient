package com.baidu.cloudsdk.social.share.handler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.Build;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.j;
import com.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TwitterShareHandler implements ISocialShareHandler {
    private static final String a = TwitterShareHandler.class.getSimpleName();
    private OAuthConsumer b = null;
    private boolean c;
    private String d;
    private IBaiduListener e;
    protected Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AsyncImageLoader.IAsyncImageLoaderListener {
        private ShareContent b;

        public a(ShareContent shareContent) {
            this.b = shareContent;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
        public void onComplete(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                if (TwitterShareHandler.this.e != null) {
                    TwitterShareHandler.this.e.onError(new BaiduException("failed to load image uri "));
                    return;
                }
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byteArray = bitmap.compress(Bitmap.CompressFormat.PNG, this.b.getCompressDataQuality(), byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
            TwitterShareHandler.this.a(this.b, byteArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AsyncTask {
        DefaultHttpClient a = new DefaultHttpClient();
        private byte[] c;

        public b(byte[] bArr) {
            this.c = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public JSONObject doInBackground(String... strArr) {
            Exception exc;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            Exception exc2;
            JSONObject jSONObject3;
            JSONObject jSONObject4;
            if (this.c == null) {
                try {
                    HttpPost httpPost = new HttpPost("https://api.twitter.com/1.1/statuses/update.json");
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new BasicNameValuePair("status", strArr[0]));
                    httpPost.setEntity(new UrlEncodedFormEntity(linkedList, "UTF-8"));
                    httpPost.setParams(TwitterShareHandler.this.getParams());
                    TwitterShareHandler.this.b.sign(httpPost);
                    jSONObject2 = new JSONObject((String) this.a.execute(httpPost, new BasicResponseHandler()));
                } catch (Exception e) {
                    exc = e;
                    jSONObject = null;
                }
                try {
                    if (Build.DEBUG) {
                        Log.d(TwitterShareHandler.a, jSONObject2.toString());
                    }
                    return jSONObject2;
                } catch (Exception e2) {
                    jSONObject = jSONObject2;
                    exc = e2;
                    if (TwitterShareHandler.this.e != null) {
                        Log.e(TwitterShareHandler.a, exc.getMessage());
                        TwitterShareHandler.this.e.onError(new BaiduException(exc.getMessage()));
                        return jSONObject;
                    }
                    return jSONObject;
                }
            }
            try {
                HttpPost httpPost2 = new HttpPost("https://api.twitter.com/1.1/statuses/update_with_media.json");
                MultipartEntity multipartEntity = new MultipartEntity();
                multipartEntity.addPart("status", new StringBody(strArr[0], Charset.forName("utf-8")));
                multipartEntity.addPart("media", new ByteArrayBody(this.c, "image.png"));
                httpPost2.setEntity(multipartEntity);
                httpPost2.setParams(TwitterShareHandler.this.getParams());
                TwitterShareHandler.this.b.sign(httpPost2);
                jSONObject4 = new JSONObject((String) this.a.execute(httpPost2, new BasicResponseHandler()));
            } catch (Exception e3) {
                exc2 = e3;
                jSONObject3 = null;
            }
            try {
                if (Build.DEBUG) {
                    Log.d(TwitterShareHandler.a, jSONObject4.toString());
                }
                return jSONObject4;
            } catch (Exception e4) {
                jSONObject3 = jSONObject4;
                exc2 = e4;
                Log.e(TwitterShareHandler.a, exc2.getMessage());
                if (TwitterShareHandler.this.e != null) {
                    TwitterShareHandler.this.e.onError(new BaiduException(exc2.getMessage()));
                    return jSONObject3;
                }
                return jSONObject3;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(JSONObject jSONObject) {
            if (jSONObject != null) {
                String str = null;
                try {
                    if (jSONObject.has("error")) {
                        str = jSONObject.getString("error");
                    }
                } catch (JSONException e) {
                }
                if (TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("id")) {
                        try {
                            jSONObject2.put("id", jSONObject.get("id"));
                            jSONObject2.put("mediatype", MediaType.TWITTER.toString());
                        } catch (JSONException e2) {
                        }
                    }
                    if (TwitterShareHandler.this.e != null) {
                        TwitterShareHandler.this.e.onComplete(jSONObject2);
                    }
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }
    }

    public TwitterShareHandler(Context context, String str, boolean z) {
        this.mContext = context;
        this.c = z;
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent) {
        if (shareContent.getImageData() != null) {
            a(shareContent, shareContent.getCompressedImageData());
        } else if (shareContent.getImageUri() != null) {
            ImageManager.getInstance().loadImage(this.mContext, shareContent.getImageUri(), new a(shareContent));
        } else {
            a(shareContent, (byte[]) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent, byte[] bArr) {
        String str = shareContent.getContent() + " " + shareContent.getLinkUrl();
        if (!TextUtils.isEmpty(str)) {
            new b(bArr).execute(str);
        }
        SocialShareStatisticsManager.getInstance(this.mContext).statistics(MediaType.TWITTER.toString(), shareContent);
    }

    public HttpParams getParams() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        return basicHttpParams;
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        this.e = iBaiduListener;
        SocialShareConfig socialShareConfig = SocialShareConfig.getInstance(this.mContext);
        if (!Utils.isNetWorkAvaliable(this.mContext)) {
            Toast.makeText(this.mContext, socialShareConfig.getString("network_not_avaliable_cannotshare"), 0).show();
            if (iBaiduListener != null) {
                iBaiduListener.onError(new BaiduException("Network not avaliable"));
                return;
            }
            return;
        }
        Toast.makeText(this.mContext, socialShareConfig.getString("sharing"), 0).show();
        String clientId = SocialConfig.getInstance(this.mContext).getClientId(MediaType.TWITTER);
        String clientId2 = SocialConfig.getInstance(this.mContext).getClientId(MediaType.TWITTERSECRET);
        SessionManager.Session session = SessionManager.getInstance(this.mContext).get(MediaType.TWITTER.toString());
        if (session != null) {
            this.b = new CommonsHttpOAuthConsumer(clientId, clientId2);
            this.b.setTokenWithSecret(session.getAccessToken(), session.getAccessTokenSecret());
            SocialShareStatisticsManager.getInstance(this.mContext).getBackUrl(shareContent.getLinkUrl(), MediaType.TWITTER.toString(), new j(this, shareContent));
        } else if (!this.c) {
            this.e.onError(new BaiduException("Twitter need authorization"));
        } else {
            k kVar = new k(this, iBaiduListener, shareContent, z);
            Bundle bundle = new Bundle();
            bundle.putString("client_id", this.d);
            bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, MediaType.TWITTER.toString());
            Intent intent = new Intent(this.mContext, SocialOAuthActivity.class);
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            SocialOAuthActivity.setListener(kVar);
            this.mContext.getApplicationContext().startActivity(intent);
        }
    }
}
