package com.baidu.sapi2;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.sapi2.utils.enums.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class SapiConfiguration {
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CHINA_MOBILE_OAUTH = 5;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FACE_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    private final LoginShareStrategy a;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public final String appId;
    public final String appSignKey;
    public final String bdOauthAppId;
    public String chinaMobileAppID;
    public String chinaMobileAppKey;
    public String chinaTelecomAppKey;
    public String chinaTelecomAppSecret;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public final boolean customActionBarEnabled;
    public final boolean debug;
    public boolean disableVoiceVerify;
    public final boolean enableShare;
    public final Domain environment;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public final boolean fastRegConfirm;
    public final String fastRegConfirmMsg;
    public final String fastRegTitleText;
    public boolean forbidPresetPhoneNumber;
    public final boolean forbidSslErrorDialog;
    public final String hwAppId;
    public final String hwLoginChannelId;
    public boolean isNightMode;
    public final Language language;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public boolean needOpenid;
    public String presetPhoneNumber;
    public final String processName;
    public final String qqAppID;
    public final String realnameAuthenticateStoken;
    public final RegistMode registMode;
    public boolean rimSDKEnable;
    public boolean showCloseBtn;
    public boolean showPmnRationaleDialog;
    public String sidValue;
    public final boolean silentShareOnUpgrade;
    public final String sinaAppId;
    public final String sinaRedirectUri;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public boolean supportFaceLogin;
    public boolean supportGuestAccountLogin;
    public final boolean supportPhoto;
    public boolean supportSpecialLogin;
    public final boolean syncCacheOnInit;
    public final String tpl;
    public final boolean uniteVerify;
    public final String userAgent;
    public final String wxAppID;
    public final Long xiaomiAppID;
    public final String xiaomiRedirectUri;

    private SapiConfiguration(Builder builder) {
        this.context = builder.b;
        this.tpl = builder.c;
        this.appId = builder.d;
        this.appSignKey = builder.e;
        this.environment = builder.g;
        this.language = builder.j;
        this.socialBindType = builder.h;
        this.registMode = builder.i;
        this.a = builder.k;
        this.fastLoginFeatureList = builder.l;
        this.hwLoginChannelId = builder.m;
        this.wxAppID = builder.n;
        this.hwAppId = builder.o;
        this.qqAppID = builder.p;
        this.xiaomiAppID = builder.q;
        this.mzAppID = builder.r;
        this.sinaAppId = builder.s;
        this.bdOauthAppId = builder.t;
        this.xiaomiRedirectUri = builder.z;
        this.meizuRedirectUri = builder.A;
        this.sinaRedirectUri = builder.B;
        this.chinaMobileAppID = builder.u;
        this.chinaMobileAppKey = builder.v;
        this.chinaTelecomAppKey = builder.w;
        this.chinaTelecomAppSecret = builder.x;
        this.sofireAppKey = builder.C;
        this.sofireSecKey = builder.D;
        this.sofireHostID = builder.E;
        this.realnameAuthenticateStoken = builder.y;
        this.fastRegConfirm = builder.F;
        this.fastRegConfirmMsg = builder.G;
        this.skin = builder.H;
        this.presetPhoneNumber = builder.I;
        this.forbidPresetPhoneNumber = builder.J;
        this.customActionBarEnabled = builder.K;
        this.configurableViewLayout = builder.M;
        this.fastRegTitleText = builder.N;
        this.debug = builder.O;
        this.smsLoginConfig = builder.P;
        this.uniteVerify = builder.Q;
        this.syncCacheOnInit = builder.R;
        this.silentShareOnUpgrade = builder.S;
        this.accountCenterRealAutnen = builder.T;
        this.forbidSslErrorDialog = builder.U;
        this.enableShare = builder.V;
        this.supportPhoto = builder.W;
        this.processName = builder.X;
        this.isNightMode = builder.Z;
        this.showCloseBtn = builder.a;
        this.supportSpecialLogin = builder.aa;
        this.userAgent = builder.Y;
        this.activityOpenAnimId = builder.ab;
        this.activityExitAnimId = builder.ac;
        this.showPmnRationaleDialog = builder.ad;
        this.disableVoiceVerify = builder.af;
        this.needOpenid = builder.ag;
        this.rimSDKEnable = builder.ai;
        this.supportFaceLogin = builder.ah;
    }

    public String getTpl() {
        return this.tpl;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppSignKey() {
        return this.appSignKey;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public Domain getEnvironment() {
        return this.environment;
    }

    public BindType getSocialBindType() {
        return this.socialBindType;
    }

    public RegistMode getRegistMode() {
        return this.registMode;
    }

    public Language getLanguage() {
        return this.language;
    }

    public List<FastLoginFeature> getFastLoginFeatureList() {
        return this.fastLoginFeatureList;
    }

    public String getWxAppID() {
        return this.wxAppID;
    }

    public String getHwAppId() {
        return this.hwAppId;
    }

    public String getQqAppID() {
        return this.qqAppID;
    }

    public Long getXiaomiAppID() {
        return this.xiaomiAppID;
    }

    public String getMzAppID() {
        return this.mzAppID;
    }

    public String getXiaomiRedirectUri() {
        return this.xiaomiRedirectUri;
    }

    public String getRealnameAuthenticateStoken() {
        return this.realnameAuthenticateStoken;
    }

    public String getMeizuRedirectUri() {
        return this.meizuRedirectUri;
    }

    public boolean getFastRegConfirm() {
        return this.fastRegConfirm;
    }

    public String getFastRegConfirmMsg() {
        return this.fastRegConfirmMsg;
    }

    public String getSkin() {
        return this.skin;
    }

    public String getPresetPhoneNumber() {
        return this.presetPhoneNumber;
    }

    public boolean getCustomActionBarEnabled() {
        return this.customActionBarEnabled;
    }

    public Switch getConfigurableViewLayout() {
        return this.configurableViewLayout;
    }

    public String getFastRegTitleText() {
        return this.fastRegTitleText;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public boolean getUniteVerify() {
        return this.uniteVerify;
    }

    public boolean getSyncCacheOnInit() {
        return this.syncCacheOnInit;
    }

    public boolean getSilentShareOnUpgrade() {
        return this.silentShareOnUpgrade;
    }

    public boolean getForbidSslErrorDialog() {
        return this.forbidSslErrorDialog;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String A;
        private String B;
        private String C;
        private String D;
        private String G;
        private String H;
        private String I;
        private boolean J;
        private String N;
        private SmsLoginConfig P;
        private String X;
        private String Y;
        private boolean ag;
        private Context b;
        private String c;
        private String d;
        private String e;
        private String f;
        private Domain g;
        private BindType h;
        private RegistMode i;
        private Language j;
        private LoginShareStrategy k;
        private List<FastLoginFeature> l;
        private String m;
        private String n;
        private String o;
        private String p;
        private Long q;
        private String r;
        private String s;
        private String t;
        private String u;
        private String v;
        private String w;
        private String x;
        private String y;
        private String z;
        private int E = -1;
        private boolean F = false;
        private boolean K = false;
        private boolean L = true;
        private Switch M = Switch.OFF;
        private boolean O = false;
        private boolean Q = false;
        private boolean R = true;
        private boolean S = true;
        private boolean T = true;
        private boolean U = false;
        private boolean V = true;
        private boolean W = true;
        private boolean Z = false;
        public boolean a = false;
        private boolean aa = true;
        private int ab = 0;
        private int ac = 0;
        private boolean ad = false;
        private boolean ae = false;
        private boolean af = true;
        private boolean ah = true;
        private boolean ai = false;

        public Builder(Context context) {
            this.b = context.getApplicationContext();
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.e = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(Domain domain) {
            this.g = domain;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.h = bindType;
            return this;
        }

        public Builder registMode(RegistMode registMode) {
            this.i = registMode;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.I = str;
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.J = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.L = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.M = r1;
            return this;
        }

        public Builder fastRegTitleText(String str) {
            this.N = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.O = z;
            return this;
        }

        public Builder syncCacheOnInit(boolean z) {
            this.R = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.S = z;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.k = loginShareStrategy;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            this.l = new ArrayList();
            if (fastLoginFeatureArr != null) {
                Collections.addAll(this.l, fastLoginFeatureArr);
            }
            return this;
        }

        public Builder wxAppID(String str) {
            this.n = str;
            return this;
        }

        public Builder hwAppID(String str) {
            this.o = str;
            return this;
        }

        public Builder hwLoginChannelId(String str) {
            this.m = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.p = str;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.s = str;
            this.B = str2;
            return this;
        }

        public Builder bdOauthAppId(String str) {
            this.t = str;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }

        public Builder xiaomiLoginConfig(Long l, String str) {
            this.q = l;
            this.z = str;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.r = str;
            this.A = str2;
            return this;
        }

        public Builder chinaMobileOauthConfig(String str, String str2) {
            this.u = str;
            this.v = str2;
            return this;
        }

        public Builder chinaTelecomOauthConfig(String str, String str2) {
            this.w = str;
            this.x = str2;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.y = str;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.C = str;
            this.D = str2;
            this.E = i;
            return this;
        }

        public Builder fastRegConfirm(boolean z) {
            this.F = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.G = str;
            return this;
        }

        public Builder skin(String str) {
            this.H = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.K = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.P = smsLoginConfig;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.Q = z;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.ah = z;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            return this;
        }

        public Builder setNeedOpenid(boolean z) {
            this.ag = z;
            SapiContext.MAX_SHARE_ACCOUNTS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            return this;
        }

        public Builder setProcessName(String str) {
            boolean z;
            if (!TextUtils.isEmpty(str)) {
                Iterator<String> it = SapiOptions.g().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (str.matches(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.X = str;
                }
            }
            return this;
        }

        public Builder setLanguage(Language language) {
            this.j = language;
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.T = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.W = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.U = z;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.V = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.Y = str;
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.Z = z;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setSupSpecialLogin(boolean z) {
            this.aa = z;
            return this;
        }

        public Builder setActivityAnim(int i, int i2) {
            this.ab = i;
            this.ac = i2;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.ad = z;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            this.ae = z;
            return this;
        }

        public Builder setDisableVoiceVerify(boolean z) {
            this.af = z;
            return this;
        }

        public Builder rimSDKEnable(boolean z) {
            this.ai = z;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            if (this.g == null) {
                this.g = Domain.DOMAIN_ONLINE;
            }
            if (this.j == null) {
                this.j = Language.CHINESE;
            }
            if (this.h == null) {
                this.h = BindType.BIND_MOBILE;
            }
            if (this.i == null) {
                this.i = RegistMode.NORMAL;
            }
            if (this.k == null) {
                this.k = LoginShareStrategy.getDefault();
            }
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (this.P == null) {
                this.P = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.M == null) {
                this.M = Switch.OFF;
            }
            Log.enable(this.O);
            return new SapiConfiguration(this);
        }
    }

    /* loaded from: classes.dex */
    public static class SmsLoginConfig {
        public Switch flagHideExtraEntry;
        public Switch flagLoginBtnType;
        public Switch flagShowFastRegLink;
        public Switch flagShowLoginLink;
        public Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch r2, Switch r3, @Deprecated Switch r4) {
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            r4 = r4 == null ? Switch.OFF : r4;
            this.flagShowLoginLink = r2;
            this.flagShowSmsLoginLink = r3;
            this.flagLoginBtnType = r4;
            this.flagShowFastRegLink = Switch.OFF;
            this.flagHideExtraEntry = Switch.OFF;
        }

        public SmsLoginConfig(Switch r1, Switch r2, Switch r3, @Deprecated Switch r4, Switch r5) {
            r1 = r1 == null ? Switch.OFF : r1;
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            r4 = r4 == null ? Switch.OFF : r4;
            r5 = r5 == null ? Switch.OFF : r5;
            this.flagHideExtraEntry = r1;
            this.flagShowLoginLink = r2;
            this.flagShowSmsLoginLink = r3;
            this.flagLoginBtnType = r4;
            this.flagShowFastRegLink = r5;
        }
    }

    public LoginShareStrategy loginShareStrategy() {
        SapiOptions sapiOptions = SapiContext.getInstance(this.context).getSapiOptions();
        LoginShareStrategy loginShareStrategy = sapiOptions.getSpecificShareStrategy().get(this.tpl);
        if (loginShareStrategy == null) {
            if (sapiOptions.getGlobalShareStrategy() != null) {
                return sapiOptions.getGlobalShareStrategy();
            }
            return this.a;
        }
        return loginShareStrategy;
    }

    public String loginShareDirection() {
        String str = SapiContext.getInstance(this.context).getSapiOptions().shareDirection.get(this.tpl);
        if (TextUtils.isEmpty(str)) {
            return ShareDirectionType.BOTH;
        }
        return str;
    }

    public Context getContext() {
        return this.context;
    }
}
