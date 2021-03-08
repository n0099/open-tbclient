package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2234a = w.class.getSimpleName();
    private v b;

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
                if (this.b != null) {
                    this.b.a(message.arg1, message.arg2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar) {
        this.b = vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(v vVar) {
        this.b = null;
    }
}
