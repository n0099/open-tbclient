package com.baidu.mobad.nativevideo;

import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.nativevideo.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements a.InterfaceC0103a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PatchVideoNative f8061a;

    public b(PatchVideoNative patchVideoNative) {
        this.f8061a = patchVideoNative;
    }

    @Override // com.baidu.mobad.nativevideo.a.InterfaceC0103a
    public void a(List<e> list) {
        if (list != null && list.size() > 0) {
            this.f8061a.f8053g = list.get(0);
            this.f8061a.a();
            return;
        }
        this.f8061a.a(NativeErrorCode.LOAD_AD_FAILED);
    }

    @Override // com.baidu.mobad.nativevideo.a.InterfaceC0103a
    public void a(NativeErrorCode nativeErrorCode) {
        this.f8061a.a(nativeErrorCode);
    }
}
