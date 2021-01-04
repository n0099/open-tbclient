package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3194a = s.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private r f3195b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Message message) {
        if (message.what != 65289) {
            return;
        }
        switch (message.arg1) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 101:
            case 102:
                if (this.f3195b != null) {
                    this.f3195b.a(message.arg1, message.arg2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(r rVar) {
        this.f3195b = rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(r rVar) {
        this.f3195b = null;
    }
}
