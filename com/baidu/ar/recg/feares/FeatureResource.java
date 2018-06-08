package com.baidu.ar.recg.feares;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class FeatureResource implements Parcelable {
    public static final Parcelable.Creator<FeatureResource> CREATOR = new Parcelable.Creator<FeatureResource>() { // from class: com.baidu.ar.recg.feares.FeatureResource.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FeatureResource createFromParcel(Parcel parcel) {
            FeatureResource featureResource = new FeatureResource();
            featureResource.a = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.b = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.c = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.d = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.e = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.f = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.g = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.h = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.i = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.j = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.k = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.l = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.m = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.n = (String) parcel.readValue(String.class.getClassLoader());
            featureResource.o = (String) parcel.readValue(String.class.getClassLoader());
            return featureResource;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FeatureResource[] newArray(int i) {
            return new FeatureResource[i];
        }
    };
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public void h(String str) {
        this.h = str;
    }

    public void i(String str) {
        this.i = str;
    }

    public void j(String str) {
        this.j = str;
    }

    public void k(String str) {
        this.k = str;
    }

    public void l(String str) {
        this.l = str;
    }

    public void m(String str) {
        this.m = str;
    }

    public void n(String str) {
        this.n = str;
    }

    public void o(String str) {
        this.o = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.a);
        parcel.writeValue(this.b);
        parcel.writeValue(this.c);
        parcel.writeValue(this.d);
        parcel.writeValue(this.e);
        parcel.writeValue(this.f);
        parcel.writeValue(this.g);
        parcel.writeValue(this.h);
        parcel.writeValue(this.i);
        parcel.writeValue(this.j);
        parcel.writeValue(this.k);
        parcel.writeValue(this.l);
        parcel.writeValue(this.m);
        parcel.writeValue(this.n);
        parcel.writeValue(this.o);
    }
}
