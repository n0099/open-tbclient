package com.baidu.searchbox.live.interfaces.service.ext;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ext/ExtLiveLogService;", "Lkotlin/Any;", "", "key", "", "", "map", "", "onLivePluginEvent", "(Ljava/lang/String;Ljava/util/Map;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ExtLiveLogService {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String KEY_AUTHOR_ID = "author_id";
    public static final String KEY_END_TIME = "end_time";
    public static final String KEY_FEED_ID = "feed_id";
    public static final String KEY_LIVE_ID = "live_id";
    public static final String KEY_OTHER_PARAMS = "other_params";
    public static final String KEY_START_TIME = "start_time";
    public static final String LIVE_EXTRA_OTHER_PARAM_EXT_KEY_BDUID = "bduid";
    public static final String LIVE_EXTRA_OTHER_PARAM_KEY_LIVE_EXT = "live_ext";
    public static final String LIVE_EXTRA_OTHER_PARAM_KEY_SOURCE = "source";
    public static final String LIVE_EXTRA_OTHER_PARAM_KEY_TAB = "tab";
    public static final String LIVE_STATIC_PLAYTIME_END = "live_playtime_end";
    public static final String LIVE_STATIC_PLAYTIME_START = "live_playtime_start";

    void onLivePluginEvent(String str, Map<String, ? extends Object> map);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ext/ExtLiveLogService$Companion;", "", "KEY_AUTHOR_ID", "Ljava/lang/String;", "KEY_END_TIME", "KEY_FEED_ID", "KEY_LIVE_ID", "KEY_OTHER_PARAMS", "KEY_START_TIME", "LIVE_EXTRA_OTHER_PARAM_EXT_KEY_BDUID", "LIVE_EXTRA_OTHER_PARAM_KEY_LIVE_EXT", "LIVE_EXTRA_OTHER_PARAM_KEY_SOURCE", "LIVE_EXTRA_OTHER_PARAM_KEY_TAB", "LIVE_STATIC_PLAYTIME_END", "LIVE_STATIC_PLAYTIME_START", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final String KEY_AUTHOR_ID = "author_id";
        public static final String KEY_END_TIME = "end_time";
        public static final String KEY_FEED_ID = "feed_id";
        public static final String KEY_LIVE_ID = "live_id";
        public static final String KEY_OTHER_PARAMS = "other_params";
        public static final String KEY_START_TIME = "start_time";
        public static final String LIVE_EXTRA_OTHER_PARAM_EXT_KEY_BDUID = "bduid";
        public static final String LIVE_EXTRA_OTHER_PARAM_KEY_LIVE_EXT = "live_ext";
        public static final String LIVE_EXTRA_OTHER_PARAM_KEY_SOURCE = "source";
        public static final String LIVE_EXTRA_OTHER_PARAM_KEY_TAB = "tab";
        public static final String LIVE_STATIC_PLAYTIME_END = "live_playtime_end";
        public static final String LIVE_STATIC_PLAYTIME_START = "live_playtime_start";
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.EXT.EXT_LIVE_LOG);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
