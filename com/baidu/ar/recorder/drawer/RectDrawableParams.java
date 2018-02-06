package com.baidu.ar.recorder.drawer;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class RectDrawableParams implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RectDrawableParams> CREATOR = new Parcelable.Creator<RectDrawableParams>() { // from class: com.baidu.ar.recorder.drawer.RectDrawableParams.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RectDrawableParams createFromParcel(Parcel parcel) {
            return new RectDrawableParams(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RectDrawableParams[] newArray(int i) {
            return new RectDrawableParams[i];
        }
    };
    private int a;
    private int b;
    private int c;
    private int d;
    private Rect e;
    private int f;
    private int g;
    private boolean h;
    private float i;
    private float j;
    private int k;

    public RectDrawableParams() {
        this.a = 720;
        this.b = 1280;
        this.c = 720;
        this.d = 1280;
        this.e = new Rect(0, 0, this.c, this.d);
        this.f = 2;
        this.g = 0;
        this.h = false;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = 0;
    }

    protected RectDrawableParams(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readByte() != 0;
        this.i = parcel.readFloat();
        this.j = parcel.readFloat();
        this.k = parcel.readInt();
    }

    public int a() {
        return this.a;
    }

    public void a(float f) {
        this.i = f;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(Rect rect) {
        this.e = rect;
    }

    public int b() {
        return this.b;
    }

    public void b(float f) {
        this.j = f;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public Object clone() {
        RectDrawableParams rectDrawableParams;
        try {
            rectDrawableParams = (RectDrawableParams) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            rectDrawableParams = null;
        }
        rectDrawableParams.a(new Rect(this.e));
        return rectDrawableParams;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f;
    }

    public void e(int i) {
        this.g = i;
    }

    public int f() {
        return this.g;
    }

    public float g() {
        return this.i;
    }

    public float h() {
        return this.j;
    }

    public int i() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.i);
        parcel.writeFloat(this.j);
        parcel.writeInt(this.k);
    }
}
