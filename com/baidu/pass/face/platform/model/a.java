package com.baidu.pass.face.platform.model;

import com.baidu.pass.face.platform.FaceStatusNewEnum;
/* loaded from: classes2.dex */
public class a {
    public FaceExtInfo[] a;
    public FaceStatusNewEnum b;
    public long c;

    public FaceStatusNewEnum a() {
        return this.b;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(FaceStatusNewEnum faceStatusNewEnum) {
        this.b = faceStatusNewEnum;
    }

    public void a(FaceExtInfo[] faceExtInfoArr) {
        this.a = faceExtInfoArr;
    }

    public FaceExtInfo[] b() {
        return this.a;
    }
}
