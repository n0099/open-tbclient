package com.baidu.mobad.nativevideo;

import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.nativevideo.a;
import java.util.List;
/* loaded from: classes4.dex */
class b implements a.InterfaceC0267a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PatchVideoNative f2331a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PatchVideoNative patchVideoNative) {
        this.f2331a = patchVideoNative;
    }

    @Override // com.baidu.mobad.nativevideo.a.InterfaceC0267a
    public void a(List<e> list) {
        if (list == null || list.size() <= 0) {
            this.f2331a.a(NativeErrorCode.LOAD_AD_FAILED);
            return;
        }
        this.f2331a.g = list.get(0);
        this.f2331a.a();
    }

    @Override // com.baidu.mobad.nativevideo.a.InterfaceC0267a
    public void a(NativeErrorCode nativeErrorCode) {
        this.f2331a.a(nativeErrorCode);
    }
}
