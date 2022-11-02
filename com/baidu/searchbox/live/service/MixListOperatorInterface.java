package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\nH&¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH&¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/service/MixListOperatorInterface;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "", "key", "", "ext", "", "commonEvent", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lorg/json/JSONObject;", "data", "doJumpNewLiveRoom", "(Lorg/json/JSONObject;)V", "", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "getListData", "()Ljava/util/List;", "", "index", "json", "insertRoom", "(ILorg/json/JSONObject;)V", "reloadLiveRoom", "(Ljava/lang/Object;)V", "reloadSlideList", "removeRoom", "scrollToNextLiveRoom", "()V", "scrollToPreLiveRoom", "", SetImageWatermarkTypeReqMsg.SWITCH, "isFromServer", "switchLiveListScrollable", "(ZZ)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixListOperatorInterface extends IService {
    void commonEvent(String str, Object obj);

    void doJumpNewLiveRoom(JSONObject jSONObject);

    List<LiveContainer.LiveItemModel> getListData();

    void insertRoom(int i, JSONObject jSONObject);

    void reloadLiveRoom(Object obj);

    void reloadSlideList(Object obj);

    void removeRoom(JSONObject jSONObject);

    void scrollToNextLiveRoom();

    void scrollToPreLiveRoom();

    void switchLiveListScrollable(boolean z, boolean z2);
}
