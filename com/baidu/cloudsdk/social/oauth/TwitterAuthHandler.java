package com.baidu.cloudsdk.social.oauth;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.av;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.share.uiwithlayout.SocialOAuthDialogTwitter;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
/* loaded from: classes.dex */
public class TwitterAuthHandler extends av {
    public static final String TWITTER_ACCESS_TOKEN_URL = "https://api.twitter.com/oauth/access_token";
    public static final String TWITTER_AUTHORIZE_URL = "https://api.twitter.com/oauth/authorize";
    public static final String TWITTER_REQUEST_TOKEN_URL = "https://api.twitter.com/oauth/request_token";
    private static final String a = TwitterAuthHandler.class.getSimpleName();
    private SocialOAuthDialogTwitter b;
    private OAuthConsumer c;
    private OAuthProvider d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AsyncTask {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            try {
                return TwitterAuthHandler.this.d.retrieveRequestToken(TwitterAuthHandler.this.c, "baidusocialshare://twitter", new String[0]);
            } catch (Exception e) {
                Log.e(TwitterAuthHandler.a, "BeginOAuthTask", e);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TwitterAuthHandler.this.b = new SocialOAuthDialogTwitter(TwitterAuthHandler.this.mActivity, str, TwitterAuthHandler.this.c, TwitterAuthHandler.this.d, TwitterAuthHandler.this.mListener);
            TwitterAuthHandler.this.b.show();
        }
    }

    public TwitterAuthHandler(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, MediaType.TWITTER.toString(), iBaiduListener);
        this.c = null;
        this.d = null;
    }

    private void b() {
        this.c = new CommonsHttpOAuthConsumer(SocialConfig.getInstance(this.mActivity).getClientId(MediaType.TWITTER), SocialConfig.getInstance(this.mActivity).getClientId(MediaType.TWITTERSECRET));
        this.d = new CommonsHttpOAuthProvider(TWITTER_REQUEST_TOKEN_URL, TWITTER_ACCESS_TOKEN_URL, TWITTER_AUTHORIZE_URL);
        this.d.setOAuth10a(true);
        try {
            new a().execute(new Void[0]);
        } catch (Exception e) {
            this.mListener.onError(new BaiduException(e.getMessage()));
        }
    }

    @Override // com.av
    public /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.av
    public void onDestroy() {
        if (this.b == null || !this.b.isShowing()) {
            return;
        }
        this.b.dismiss();
    }

    @Override // com.av
    public void startAuthorize() {
        b();
    }
}
