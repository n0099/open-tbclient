package com.baidu.android.pushservice.message.a;

import com.baidu.sapi2.SapiSafeFacade;
/* loaded from: classes2.dex */
public enum l {
    MSG_TYPE_INVALID(-1),
    MSG_TYPE_SINGLE_PRIVATE(0),
    MSG_TYPE_MULTI_PRIVATE(1),
    MSG_TYPE_SINGLE_PUBLIC(2),
    MSG_TYPE_MULTI_PUBLIC(3),
    MSG_TYPE_MULTI_PRIVATE_NOTIFICATION(5),
    MSG_TYPE_PRIVATE_MESSAGE(6),
    MSG_TYPE_RICH_MEDIA(7),
    MSG_TYPE_BAIDU_SUPPER(10),
    MSG_TYPE_ALARM_NOTIFICATION(12),
    MSG_TYPE_ALARM_MESSAGE(13),
    MSG_TYPE_ALARM_AD_NOTIFICATION(14),
    MSG_TYPE_INNERBIND(101),
    MSG_TYPE_ULTRON_COMMAND(SapiSafeFacade.SAPIWEBVIEW_BACK),
    MSG_TYPE_LBS_APPLIST_COMMAND(SapiSafeFacade.SAPIWEBVIEW_FINISH),
    MSG_TYPE_APPSTAT_COMMAND(SapiSafeFacade.SAPIWEBVIEW_AUTHORIZATION);
    
    private int q;

    l(int i) {
        this.q = i;
    }

    public static l a(int i) {
        switch (i) {
            case 0:
                return MSG_TYPE_SINGLE_PRIVATE;
            case 1:
                return MSG_TYPE_MULTI_PRIVATE;
            case 2:
                return MSG_TYPE_SINGLE_PUBLIC;
            case 3:
                return MSG_TYPE_MULTI_PUBLIC;
            case 5:
                return MSG_TYPE_MULTI_PRIVATE_NOTIFICATION;
            case 6:
                return MSG_TYPE_PRIVATE_MESSAGE;
            case 7:
                return MSG_TYPE_RICH_MEDIA;
            case 10:
                return MSG_TYPE_BAIDU_SUPPER;
            case 12:
                return MSG_TYPE_ALARM_NOTIFICATION;
            case 13:
                return MSG_TYPE_ALARM_MESSAGE;
            case 14:
                return MSG_TYPE_ALARM_AD_NOTIFICATION;
            case 101:
                return MSG_TYPE_INNERBIND;
            case SapiSafeFacade.SAPIWEBVIEW_BACK /* 102 */:
                return MSG_TYPE_ULTRON_COMMAND;
            case SapiSafeFacade.SAPIWEBVIEW_FINISH /* 103 */:
                return MSG_TYPE_LBS_APPLIST_COMMAND;
            case SapiSafeFacade.SAPIWEBVIEW_AUTHORIZATION /* 104 */:
                return MSG_TYPE_APPSTAT_COMMAND;
            default:
                return MSG_TYPE_INVALID;
        }
    }

    public int a() {
        return this.q;
    }
}
