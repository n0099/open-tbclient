package com.baidu.searchbox.live.interfaces.service.player;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.player.DuMediaConstants;
import com.baidu.searchbox.live.interfaces.player.DuMediaView;
import com.baidu.searchbox.live.interfaces.player.IDuMediaPnPController;
import com.baidu.searchbox.live.interfaces.player.LiveDlnaSearchListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/player/IDuMediaService;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/interfaces/player/LiveDlnaSearchListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "dlnaRefresh", "(Lcom/baidu/searchbox/live/interfaces/player/LiveDlnaSearchListener;)V", "dlnaStop", "()V", "", "uuid", "Lcom/baidu/searchbox/live/interfaces/player/IDuMediaPnPController;", "getCtrlPoint", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/IDuMediaPnPController;", "", "width", "height", "getDevicePlayQualityScore", "(II)Ljava/lang/Integer;", "Lcom/baidu/searchbox/live/interfaces/player/DuMediaView;", "getDuMediaView", "()Lcom/baidu/searchbox/live/interfaces/player/DuMediaView;", "Lcom/baidu/searchbox/live/interfaces/player/DuMediaConstants$Key;", "key", "getMediaIntConstant", "(Lcom/baidu/searchbox/live/interfaces/player/DuMediaConstants$Key;)Ljava/lang/Integer;", "installType", "", "isCoreLoaded", "(Ljava/lang/Integer;)Ljava/lang/Boolean;", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IDuMediaService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void dlnaRefresh(LiveDlnaSearchListener liveDlnaSearchListener);

    void dlnaStop();

    IDuMediaPnPController getCtrlPoint(String str);

    Integer getDevicePlayQualityScore(int i, int i2);

    DuMediaView getDuMediaView();

    Integer getMediaIntConstant(DuMediaConstants.Key key);

    Boolean isCoreLoaded(Integer num);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/player/IDuMediaService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.PLAYER.DU_MEDIA);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
