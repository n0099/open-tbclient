package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;
/* loaded from: classes2.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7731a = "w";

    /* renamed from: b  reason: collision with root package name */
    public v f7732b;

    public void a(Message message) {
        if (message.what != 65289) {
            return;
        }
        int i2 = message.arg1;
        if (i2 != 12 && i2 != 101 && i2 != 102) {
            switch (i2) {
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
                    break;
                default:
                    return;
            }
        }
        v vVar = this.f7732b;
        if (vVar != null) {
            vVar.a(message.arg1, message.arg2);
        }
    }

    public void a(v vVar) {
        this.f7732b = vVar;
    }

    public void b(v vVar) {
        this.f7732b = null;
    }
}
