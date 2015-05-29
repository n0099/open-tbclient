package com.baidu.sapi2.result;

import java.util.List;
/* loaded from: classes.dex */
public class GetPopularPortraitsInfoResult extends SapiResult {
    public List<PopularPortraitsInfo> popularPortraitsInfoList;

    /* loaded from: classes.dex */
    public class PopularPortraitsInfo {
        public int myItem;
        public int num;
        public String series;
        public String url;
    }
}
