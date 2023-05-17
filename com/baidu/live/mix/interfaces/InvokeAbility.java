package com.baidu.live.mix.interfaces;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/baidu/live/mix/interfaces/InvokeAbility;", "Lkotlin/Any;", "", "key", "Lorg/json/JSONObject;", "json", "", "eventDispatcher", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Lcom/baidu/live/mix/interfaces/MixShellServiceCenter;", "getMixShellServiceCenter", "()Lcom/baidu/live/mix/interfaces/MixShellServiceCenter;", "Lcom/baidu/live/mix/interfaces/MixPagerInfoService;", "getPagerInfoService", "()Lcom/baidu/live/mix/interfaces/MixPagerInfoService;", "", "index", "insertRoom", "(ILorg/json/JSONObject;)V", "loadFinish", "()V", "removeRoom", "(Lorg/json/JSONObject;)V", "scrollToNextLiveRoom", "scrollToPreLiveRoom", "", SetImageWatermarkTypeReqMsg.SWITCH, "switchLiveListScrollable", "(Z)V", "switchScreenAutoRotate", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface InvokeAbility {
    void eventDispatcher(String str, JSONObject jSONObject);

    MixShellServiceCenter getMixShellServiceCenter();

    MixPagerInfoService getPagerInfoService();

    void insertRoom(int i, JSONObject jSONObject);

    void loadFinish();

    void removeRoom(JSONObject jSONObject);

    void scrollToNextLiveRoom();

    void scrollToPreLiveRoom();

    void switchLiveListScrollable(boolean z);

    void switchScreenAutoRotate(boolean z);
}
