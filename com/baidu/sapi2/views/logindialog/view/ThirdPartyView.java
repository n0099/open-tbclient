package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ThirdPartyView extends LinearLayout implements View.OnClickListener {
    public Context a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public LinearLayout k;
    public ILoginConfirmCallback l;
    public QuickLoginType m;
    public QuickLoginType n;

    public void a() {
    }

    /* loaded from: classes3.dex */
    public class a extends ThirdLoginCallback {
        public final /* synthetic */ long a;

        public a(long j) {
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            com.baidu.sapi2.views.logindialog.utils.a.a(ThirdPartyView.this.m.getValue(), System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
            if (ThirdPartyView.this.l == null) {
                Log.e(QuickLoginDialog.STAG, "thirdlogin onFailure mWebAuthListener is null");
                return;
            }
            QuickLoginResult quickLoginResult = new QuickLoginResult();
            quickLoginResult.setResultCode(webAuthResult.getResultCode());
            quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
            quickLoginResult.mLoginType = ThirdPartyView.this.m;
            ThirdPartyView.this.l.onFailure(quickLoginResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            com.baidu.sapi2.views.logindialog.utils.a.a(ThirdPartyView.this.m.getValue(), System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
            if (ThirdPartyView.this.l == null) {
                Log.e(QuickLoginDialog.STAG, "thirdlogin onSuccess mWebAuthListener is null");
                return;
            }
            QuickLoginResult quickLoginResult = new QuickLoginResult();
            quickLoginResult.setResultCode(webAuthResult.getResultCode());
            quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
            quickLoginResult.mLoginType = ThirdPartyView.this.m;
            ThirdPartyView.this.l.onSuccess(quickLoginResult);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends WebAuthListener {
        public final /* synthetic */ long a;

        public b(long j) {
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            com.baidu.sapi2.views.logindialog.utils.a.a("more_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
            if (ThirdPartyView.this.l == null) {
                Log.e(QuickLoginDialog.STAG, "otherlogin onSuccess mWebAuthListener is null");
                return;
            }
            QuickLoginResult quickLoginResult = new QuickLoginResult();
            quickLoginResult.setResultCode(webAuthResult.getResultCode());
            quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
            quickLoginResult.mLoginType = ThirdPartyView.this.m;
            ThirdPartyView.this.l.onFailure(quickLoginResult);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            com.baidu.sapi2.views.logindialog.utils.a.a("more_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
            if (ThirdPartyView.this.l == null) {
                Log.e(QuickLoginDialog.STAG, "otherlogin onSuccess mWebAuthListener is null");
                return;
            }
            QuickLoginResult quickLoginResult = new QuickLoginResult();
            quickLoginResult.setResultCode(webAuthResult.getResultCode());
            quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
            quickLoginResult.mLoginType = ThirdPartyView.this.m;
            ThirdPartyView.this.l.onSuccess(quickLoginResult);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[QuickLoginType.values().length];
            a = iArr;
            try {
                iArr[QuickLoginType.HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[QuickLoginType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[QuickLoginType.ONEKEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ThirdPartyView(Context context) {
        this(context, null);
    }

    public void setDialogLoginType(QuickLoginType quickLoginType) {
        this.n = quickLoginType;
    }

    public void setLoginCallback(ILoginConfirmCallback iLoginConfirmCallback) {
        this.l = iLoginConfirmCallback;
    }

    public ThirdPartyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThirdPartyView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        d();
    }

    private void a(WebSocialLoginDTO webSocialLoginDTO) {
        ILoginConfirmCallback iLoginConfirmCallback = this.l;
        if (iLoginConfirmCallback == null) {
            Log.e(QuickLoginDialog.STAG, "thirdLogin mWebAuthListener is null");
        } else if (!iLoginConfirmCallback.onPreStart(false)) {
            Log.e(QuickLoginDialog.STAG, "thirdLogin privacy is not agree");
        } else {
            CoreViewRouter.getInstance().loadThirdPartyLogin(new a(System.currentTimeMillis()), webSocialLoginDTO);
        }
    }

    private void d() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_threepatry, this);
        this.b = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_wechat);
        this.c = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_qq);
        this.d = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_sina);
        this.e = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_yy);
        this.f = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_huawei);
        this.g = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_honor);
        this.h = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_xiaomi);
        this.i = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_meizu);
        this.j = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_more);
        this.k = (LinearLayout) findViewById(R.id.sapi_sdk_ll_other_login_type_tip);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        List<FastLoginFeature> thirdPartyConfig = getThirdPartyConfig();
        int min = Math.min(thirdPartyConfig.size(), 5);
        for (int i = 0; i < min; i++) {
            FastLoginFeature fastLoginFeature = thirdPartyConfig.get(i);
            if (fastLoginFeature == FastLoginFeature.TX_WEIXIN_SSO) {
                this.b.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.TX_QQ_SSO) {
                this.c.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.SINA_WEIBO_SSO) {
                this.d.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.YY_SSO) {
                this.e.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.HUAWEI_LOGIN) {
                this.f.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.XIAOMI_SSO) {
                this.h.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.MEIZU_SSO) {
                this.i.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.HONOR_LOGIN) {
                this.g.setVisibility(0);
            }
        }
    }

    private void e() {
        if (this.l == null) {
            Log.e(QuickLoginDialog.STAG, "otherlogin mWebAuthListener is null");
            return;
        }
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.config = null;
        QuickLoginType quickLoginType = this.n;
        if (quickLoginType != null) {
            int i = c.a[quickLoginType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        webLoginDTO.excludeTypes = LoginTypes.ONE_KEY_LOGIN;
                    }
                } else {
                    webLoginDTO.excludeTypes = LoginTypes.SHARE;
                }
            } else {
                webLoginDTO.excludeTypes = LoginTypes.HISTORY;
            }
        }
        CoreViewRouter.getInstance().startLogin(new b(System.currentTimeMillis()), webLoginDTO);
    }

    private List<FastLoginFeature> getThirdPartyConfig() {
        ArrayList arrayList = new ArrayList();
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        if (sapiAccountManager == null) {
            return arrayList;
        }
        SapiConfiguration confignation = sapiAccountManager.getConfignation();
        if (confignation == null) {
            return arrayList;
        }
        arrayList.addAll(confignation.fastLoginFeatureList);
        return arrayList;
    }

    public void b() {
        this.k.setVisibility(8);
    }

    public void c() {
        this.k.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        if (view2.getId() == R.id.sapi_sdk_iv_third_party_wechat) {
            this.m = QuickLoginType.WECHAT;
            webSocialLoginDTO.socialType = SocialType.WEIXIN;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_qq) {
            this.m = QuickLoginType.QQ;
            webSocialLoginDTO.socialType = SocialType.QQ_SSO;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_yy) {
            this.m = QuickLoginType.YY;
            webSocialLoginDTO.socialType = SocialType.YY;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_sina) {
            this.m = QuickLoginType.SINA;
            webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_huawei) {
            this.m = QuickLoginType.HUAWEI;
            webSocialLoginDTO.socialType = SocialType.HUAWEI;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_honor) {
            this.m = QuickLoginType.HONOR;
            webSocialLoginDTO.socialType = SocialType.HONOR;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_xiaomi) {
            this.m = QuickLoginType.XIAOMI;
            webSocialLoginDTO.socialType = SocialType.XIAOMI;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_meizu) {
            this.m = QuickLoginType.MEIZU;
            webSocialLoginDTO.socialType = SocialType.MEIZU;
            a(webSocialLoginDTO);
        } else if (view2.getId() == R.id.sapi_sdk_iv_third_party_more) {
            this.m = QuickLoginType.FULL_SCREEN;
            e();
        }
    }
}
