package com.baidu.searchbox.live.action;

import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/action/MixMediaEvent;", "Lcom/baidu/searchbox/live/action/AbstractEvent;", "<init>", "()V", MixConstants.KEY_YYGoBackPopUp, "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public class MixMediaEvent extends AbstractEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/live/action/MixMediaEvent$YYGoBackPopUp;", "Lcom/baidu/searchbox/live/action/MixMediaEvent;", "", "component1", "()Ljava/lang/String;", "roomId", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;)Lcom/baidu/searchbox/live/action/MixMediaEvent$YYGoBackPopUp;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getRoomId", "<init>", "(Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class YYGoBackPopUp extends MixMediaEvent {
        public final String roomId;

        public static /* synthetic */ YYGoBackPopUp copy$default(YYGoBackPopUp yYGoBackPopUp, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = yYGoBackPopUp.roomId;
            }
            return yYGoBackPopUp.copy(str);
        }

        public final String component1() {
            return this.roomId;
        }

        public final YYGoBackPopUp copy(String str) {
            return new YYGoBackPopUp(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof YYGoBackPopUp) && Intrinsics.areEqual(this.roomId, ((YYGoBackPopUp) obj).roomId);
            }
            return true;
        }

        public int hashCode() {
            String str = this.roomId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "YYGoBackPopUp(roomId=" + this.roomId + SmallTailInfo.EMOTION_SUFFIX;
        }

        public YYGoBackPopUp(String str) {
            this.roomId = str;
        }

        public final String getRoomId() {
            return this.roomId;
        }
    }
}
