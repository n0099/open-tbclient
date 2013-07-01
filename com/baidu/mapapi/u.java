package com.baidu.mapapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f569a;

    public u() {
    }

    public u(byte[] bArr) {
        try {
            this.f569a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public Bitmap a() {
        return this.f569a;
    }
}
