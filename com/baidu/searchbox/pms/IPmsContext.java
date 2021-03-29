package com.baidu.searchbox.pms;

import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.StatisticCallback;
import java.util.List;
/* loaded from: classes2.dex */
public interface IPmsContext {
    public static final IPmsContext EMPTY = new IPmsContext() { // from class: com.baidu.searchbox.pms.IPmsContext.1
        @Override // com.baidu.searchbox.pms.IPmsContext
        public boolean checkChannelAllow(String str, String str2) {
            return true;
        }

        @Override // com.baidu.searchbox.pms.IPmsContext
        public List<RequestParams.Channel> getLongConnectParams() {
            return null;
        }

        @Override // com.baidu.searchbox.pms.IPmsContext
        public RequestParams getRegisterParams(String str) {
            return null;
        }

        @Override // com.baidu.searchbox.pms.IPmsContext
        public StatisticCallback getStatisticCallback() {
            return null;
        }
    };

    boolean checkChannelAllow(String str, String str2);

    List<RequestParams.Channel> getLongConnectParams();

    RequestParams getRegisterParams(String str);

    StatisticCallback getStatisticCallback();
}
