package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3075a = w.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private v f3076b;

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
                if (this.f3076b != null) {
                    this.f3076b.a(message.arg1, message.arg2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar) {
        this.f3076b = vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(v vVar) {
        this.f3076b = null;
    }
}
