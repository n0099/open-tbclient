package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import java.util.List;
/* loaded from: classes3.dex */
public class GetPopularPortraitsInfoResult extends SapiResult implements NoProguard {
    public List<PopularPortraitsInfo> popularPortraitsInfoList;

    /* loaded from: classes3.dex */
    public static class PopularPortraitsInfo implements NoProguard {
        public int myItem;
        public int num;
        public String series;
        public String url;
    }
}
