package com.baidu.sapi2.passhost.pluginsdk.service;

import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.Switch;
import java.util.List;
/* loaded from: classes.dex */
public interface ISapiConfiguration {
    String getAppId();

    String getAppSignKey();

    String getClientId();

    String getClientIp();

    Switch getConfigurableViewLayout();

    boolean getCustomActionBarEnabled();

    boolean getDebug();

    Domain getEnvironment();

    List<FastLoginFeature> getFastLoginFeatureList();

    boolean getFastRegConfirm();

    String getFastRegConfirmMsg();

    String getFastRegTitleText();

    String getHwAppId();

    Language getLanguage();

    String getMeizuRedirectUri();

    String getMzAppID();

    String getPresetPhoneNumber();

    String getQqAppID();

    boolean getQuickUserEnabled();

    String getRealnameAuthenticateStoken();

    RegistMode getRegistMode();

    boolean getShowRegLink();

    boolean getSilentShareOnUpgrade();

    String getSkin();

    BindType getSocialBindType();

    boolean getSyncCacheOnInit();

    String getTpl();

    boolean getUniteVerify();

    String getWxAppID();

    Long getXiaomiAppID();

    String getXiaomiRedirectUri();
}
