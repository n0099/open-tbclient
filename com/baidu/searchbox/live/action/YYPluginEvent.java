package com.baidu.searchbox.live.action;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/action/YYPluginEvent;", "Lcom/baidu/searchbox/live/action/AbstractEvent;", "<init>", "()V", "Companion", "LoadYYPluginRes", "StartLoadYYPluginEvent", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class YYPluginEvent extends AbstractEvent {
    public static final Companion Companion = new Companion(null);
    public static final int LOAD_YY_PLUGIN_FAIL = 3;
    public static final int LOAD_YY_PLUGIN_NOT_NEEDED = 1;
    public static final int LOAD_YY_PLUGIN_SUCCESS = 2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/action/YYPluginEvent$StartLoadYYPluginEvent;", "Lcom/baidu/searchbox/live/action/YYPluginEvent;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class StartLoadYYPluginEvent extends YYPluginEvent {
        public static final StartLoadYYPluginEvent INSTANCE = new StartLoadYYPluginEvent();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/action/YYPluginEvent$Companion;", "", "LOAD_YY_PLUGIN_FAIL", "I", "LOAD_YY_PLUGIN_NOT_NEEDED", "LOAD_YY_PLUGIN_SUCCESS", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/live/action/YYPluginEvent$LoadYYPluginRes;", "Lcom/baidu/searchbox/live/action/YYPluginEvent;", "", "component1", "()I", UriUtil.LOCAL_RESOURCE_SCHEME, "copy", "(I)Lcom/baidu/searchbox/live/action/YYPluginEvent$LoadYYPluginRes;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "", "toString", "()Ljava/lang/String;", "I", "getRes", "<init>", "(I)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class LoadYYPluginRes extends YYPluginEvent {
        public final int res;

        public static /* synthetic */ LoadYYPluginRes copy$default(LoadYYPluginRes loadYYPluginRes, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadYYPluginRes.res;
            }
            return loadYYPluginRes.copy(i);
        }

        public final int component1() {
            return this.res;
        }

        public final LoadYYPluginRes copy(int i) {
            return new LoadYYPluginRes(i);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof LoadYYPluginRes) && this.res == ((LoadYYPluginRes) obj).res;
            }
            return true;
        }

        public int hashCode() {
            return this.res;
        }

        public String toString() {
            return "LoadYYPluginRes(res=" + this.res + SmallTailInfo.EMOTION_SUFFIX;
        }

        public LoadYYPluginRes(int i) {
            this.res = i;
        }

        public final int getRes() {
            return this.res;
        }
    }
}
