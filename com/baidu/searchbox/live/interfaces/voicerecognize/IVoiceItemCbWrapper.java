package com.baidu.searchbox.live.interfaces.voicerecognize;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH&¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\nH&¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/voicerecognize/IVoiceItemCbWrapper;", "Lkotlin/Any;", "", "name", "param", "", "data", "", "offSet", "length", "", "executeVoiceItem", "(Ljava/lang/String;Ljava/lang/String;[BII)V", "reason", "onMicInitializeFailed", "(I)V", "onMicInitializeSuccess", "()V", "onMicInitializingBegin", "onMicReleased", "status", "onRecognationStatusChanged", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface IVoiceItemCbWrapper {
    void executeVoiceItem(String str, String str2, byte[] bArr, int i2, int i3);

    void onMicInitializeFailed(int i2);

    void onMicInitializeSuccess();

    void onMicInitializingBegin();

    void onMicReleased();

    void onRecognationStatusChanged(int i2);
}
