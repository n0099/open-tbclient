package com.baidu.searchbox.player.model;

import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.pms.constants.PmsConstant;
/* loaded from: classes4.dex */
public class ClaritySelectModel {
    public int selectClarity;
    public String selectStrategy;
    public int selectType;

    /* loaded from: classes4.dex */
    public enum Strategy {
        USER("user"),
        VIDEO_INFP_BIND("vinfo_bind"),
        DEGRADE(PmsConstant.Statistic.STATISTIC_DEGRADE),
        RULE("rule"),
        RULE_WIFI_HIGH("rule_wifi_high"),
        RULE_WIFI_LOW("rule_wifi_low"),
        RULE_MOBILE("rule_mobile"),
        SMART("smart"),
        SMART_MOBILE("smart_mobile"),
        SMART_LOW("smart_low"),
        SMART_HIGH("smart_high"),
        NET("net"),
        RES_PREFERRED_CLARITY("res_preferred_clarity"),
        REDIRECT_CLARITY("clarity_redirect"),
        UNKNOW(DownloadStatisticConstants.UBC_VALUE_UNKNOW);
        
        public final String value;

        Strategy(String str) {
            this.value = str;
        }
    }
}
