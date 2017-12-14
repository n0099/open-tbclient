package com.baidu.sapi2.passhost.pluginsdk.service;
/* loaded from: classes.dex */
public class IEventCenterService extends Observable {

    /* loaded from: classes.dex */
    public static class EventId {

        /* loaded from: classes.dex */
        public static class EventBase {
            public static final int EventBaseEnd = 10000;
            public static final int FREQUENCE_1DAY = 12;
            public static final int FREQUENCE_1HOUR = 11;
            public static final int FREQUENCE_1MONTH = 15;
            public static final int FREQUENCE_3DAY = 13;
            public static final int FREQUENCE_3MONTH = 16;
            public static final int FREQUENCE_7DAY = 14;
            public static final int NETWORK_CHANGE = 1;
            public static final int NETWORK_CHANGE_TO_2G = 4;
            public static final int NETWORK_CHANGE_TO_3G = 5;
            public static final int NETWORK_CHANGE_TO_4G = 6;
            public static final int NETWORK_CHANGE_TO_AVALIABLE = 2;
            public static final int NETWORK_CHANGE_TO_WIFI = 3;
            public static final int SYSTEM_PRESENT = 32;
            public static final int SYSTEM_SCREEN_OFF = 31;
            public static final int SYSTEM_SCREEN_ON = 30;
        }

        /* loaded from: classes.dex */
        public static class EventMode {
            public static final int APP_INTO_MAINUI = 10002;
            public static final int APP_PROCESS_START = 10001;
            public static final int SAPIACCOUNT_CAPTCHA = 12008;
            public static final int SAPIACCOUNT_DYNAMICPWD_LOGIN = 12001;
            public static final int SAPIACCOUNT_FACE_CHECK = 12002;
            public static final int SAPIACCOUNT_FACE_DEL = 12003;
            public static final int SAPIACCOUNT_FACE_LOGIN = 12004;
            public static final int SAPIACCOUNT_FACE_MODIFY = 12005;
            public static final int SAPIACCOUNT_FACE_REG = 12006;
            public static final int SAPIACCOUNT_FILL_USENAME = 12007;
            public static final int SAPIACCOUNT_GET_DYNAMIC_PWD = 12009;
            public static final int SAPIACCOUNT_GET_LOGIN_PROXY_RESULT = 12010;
            public static final int SAPIACCOUNT_GET_QR_CODE_IMAGE = 12031;
            public static final int SAPIACCOUNT_GET_QR_LOGIN_RESULT = 12033;
            public static final int SAPIACCOUNT_GET_REG_CODE = 12011;
            public static final int SAPIACCOUNT_GET_TPL_STOKEN = 12013;
            public static final int SAPIACCOUNT_GET_USERINFO = 12014;
            public static final int SAPIACCOUNT_LOGIN = 12015;
            public static final int SAPIACCOUNT_OAUTH = 12016;
            public static final int SAPIACCOUNT_PHONE_REG = 12017;
            public static final int SAPIACCOUNT_QR_APP_LOGIN = 12018;
            public static final int SAPIACCOUNT_QR_LOGIN_STATUS_CHECK = 12032;
            public static final int SAPIACCOUNT_QR_PC_LOGIN = 12019;
            public static final int SAPIACCOUNT_QUICK_USER_REG = 12020;
            public static final int SAPIACCOUNT_RECURSIVE_FAST_REG = 12021;
            public static final int SAPIACCOUNT_RELOGIN = 12022;
            public static final int SAPIACCOUNT_SP_CHANGE = 12100;
            public static final int SAPIACCOUNT_THROUGH_SERVER = 12012;
            public static final int SAPIACCOUNT_VOICE_CHECK = 12023;
            public static final int SAPIACCOUNT_VOICE_CODESET = 12026;
            public static final int SAPIACCOUNT_VOICE_LOGIN = 12024;
            public static final int SAPIACCOUNT_VOICE_REG = 12025;
            public static final int SAPIACCOUNT_VOICE_SWITCHSET = 12027;
            public static final int SAPIACCOUNT_VOICE_VERIFY = 12028;
            public static final int SAPIACCOUNT_WAP_SSO_CONFIRM = 12029;
            public static final int SAPIACCOUNT_WEB_2_NATIVE_LOGIN = 12030;
            public static final int SAPIWEBVIEW_AUTHORIZATION = 11005;
            public static final int SAPIWEBVIEW_BACK = 11003;
            public static final int SAPIWEBVIEW_BIND_WIDGET = 11013;
            public static final int SAPIWEBVIEW_CHANGE_PWD = 11007;
            public static final int SAPIWEBVIEW_FAST_REG = 11012;
            public static final int SAPIWEBVIEW_FINISH = 11004;
            public static final int SAPIWEBVIEW_INITED = 11002;
            public static final int SAPIWEBVIEW_LOGIN = 11009;
            public static final int SAPIWEBVIEW_REALNAME_AUTHENTICATE = 11006;
            public static final int SAPIWEBVIEW_REG = 11011;
            public static final int SAPIWEBVIEW_SMS_LOGIN = 11010;
            public static final int SAPIWEBVIEW_UNITEVERIFY = 11008;
        }
    }

    /* loaded from: classes.dex */
    public static class EventResult {

        /* loaded from: classes.dex */
        public enum PHASE {
            START,
            FINISH,
            SUCCESS,
            FAILURE
        }
    }
}
