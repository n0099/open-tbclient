package com.baidu.searchbox.live.interfaces.storage;

import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController;", "Lkotlin/Any;", "", "type", "", "getInfos", "(Ljava/lang/String;)Ljava/util/Map;", "", "getMediaProportion", "()D", "", "getNormalQuota", "(Ljava/lang/String;)J", "getVipQuota", "", "onEnterYY", "()V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IYYStorageController {
    public static final Companion Companion = Companion.$$INSTANCE;

    Map<String, String> getInfos(String str);

    double getMediaProportion();

    long getNormalQuota(String str);

    long getVipQuota(String str);

    void onEnterYY();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController$Companion;", "", "TYPE_MEDIA", "Ljava/lang/String;", "getTYPE_MEDIA", "()Ljava/lang/String;", "TYPE_YY", "getTYPE_YY", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String TYPE_MEDIA = "media";
        public static final String TYPE_YY = "yy";

        public final String getTYPE_MEDIA() {
            return TYPE_MEDIA;
        }

        public final String getTYPE_YY() {
            return TYPE_YY;
        }
    }
}
