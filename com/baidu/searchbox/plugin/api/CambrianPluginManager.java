package com.baidu.searchbox.plugin.api;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class CambrianPluginManager {

    /* loaded from: classes3.dex */
    public static class PluginChatMsg implements Parcelable {
        public static final Parcelable.Creator<PluginChatMsg> CREATOR = new Parcelable.Creator<PluginChatMsg>() { // from class: com.baidu.searchbox.plugin.api.CambrianPluginManager.PluginChatMsg.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PluginChatMsg createFromParcel(Parcel parcel) {
                return new PluginChatMsg(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PluginChatMsg[] newArray(int i) {
                return new PluginChatMsg[i];
            }
        };
        private String A;
        private String B;
        private String C;
        protected String a;
        protected String b;
        public String c;
        protected String d;
        private int e;
        private long f;
        private long g;
        private long h;
        private int i;
        private long j;
        private int k;
        private long l;
        private int m;
        private int n;
        private long o;
        private long p;
        private int q;
        private int r;
        private String s;
        private String t;
        private boolean u;
        private boolean v;
        private long w;
        private String x;
        private int y;
        private int z;

        public PluginChatMsg() {
            this.e = 0;
            this.f = 0L;
            this.g = 0L;
            this.h = 0L;
            this.i = 0;
            this.j = 0L;
            this.k = 1;
            this.l = -1L;
            this.m = 0;
            this.n = -1;
            this.o = -1L;
            this.p = -1L;
            this.q = -1;
            this.r = 0;
            this.s = "";
            this.t = "";
            this.u = false;
            this.v = false;
            this.w = -1L;
            this.x = "";
            this.y = -1;
            this.z = 1;
        }

        protected PluginChatMsg(Parcel parcel) {
            this.e = 0;
            this.f = 0L;
            this.g = 0L;
            this.h = 0L;
            this.i = 0;
            this.j = 0L;
            this.k = 1;
            this.l = -1L;
            this.m = 0;
            this.n = -1;
            this.o = -1L;
            this.p = -1L;
            this.q = -1;
            this.r = 0;
            this.s = "";
            this.t = "";
            this.u = false;
            this.v = false;
            this.w = -1L;
            this.x = "";
            this.y = -1;
            this.z = 1;
            this.f = parcel.readLong();
            this.g = parcel.readLong();
            this.h = parcel.readLong();
            this.n = parcel.readInt();
            this.i = parcel.readInt();
            this.e = parcel.readInt();
            this.k = parcel.readInt();
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.l = parcel.readLong();
            this.m = parcel.readInt();
            this.n = parcel.readInt();
            this.o = parcel.readLong();
            this.q = parcel.readInt();
            this.r = parcel.readInt();
            this.s = parcel.readString();
            this.u = parcel.readInt() == 1;
            this.v = parcel.readInt() == 1;
            this.w = parcel.readLong();
            this.x = parcel.readString();
            this.y = parcel.readInt();
            this.z = parcel.readInt();
            this.c = parcel.readString();
            this.A = parcel.readString();
            this.B = parcel.readString();
            this.C = parcel.readString();
            this.p = parcel.readLong();
            this.d = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f);
            parcel.writeLong(this.g);
            parcel.writeLong(this.h);
            parcel.writeInt(this.n);
            parcel.writeInt(this.i);
            parcel.writeInt(this.e);
            parcel.writeInt(this.k);
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeLong(this.l);
            parcel.writeInt(this.m);
            parcel.writeInt(this.n);
            parcel.writeLong(this.o);
            parcel.writeInt(this.q);
            parcel.writeInt(this.r);
            parcel.writeString(this.s);
            parcel.writeInt(this.u ? 1 : 0);
            parcel.writeInt(this.v ? 1 : 0);
            parcel.writeLong(this.w);
            parcel.writeString(this.x);
            parcel.writeInt(this.y);
            parcel.writeInt(this.z);
            parcel.writeString(this.c);
            parcel.writeString(this.A);
            parcel.writeString(this.B);
            parcel.writeString(this.C);
            parcel.writeLong(this.p);
            parcel.writeString(this.d);
        }
    }

    /* loaded from: classes3.dex */
    public static class PluginPaInfo implements Parcelable {
        public static final Parcelable.Creator<PluginPaInfo> CREATOR = new Parcelable.Creator<PluginPaInfo>() { // from class: com.baidu.searchbox.plugin.api.CambrianPluginManager.PluginPaInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PluginPaInfo createFromParcel(Parcel parcel) {
                return new PluginPaInfo(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PluginPaInfo[] newArray(int i) {
                return new PluginPaInfo[i];
            }
        };
        private long a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private int f;
        private String g;
        private long h;
        private String i;
        private String j;
        private long k;
        private int l;
        private int m;
        private String n;
        private String o;
        private int p;
        private String q;

        public PluginPaInfo() {
        }

        protected PluginPaInfo(Parcel parcel) {
            this.a = parcel.readLong();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readByte() != 0;
            this.f = parcel.readInt();
            this.g = parcel.readString();
            this.h = parcel.readLong();
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readLong();
            this.l = parcel.readInt();
            this.m = parcel.readInt();
            this.n = parcel.readString();
            this.o = parcel.readString();
            this.p = parcel.readInt();
            this.q = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeInt(this.e ? 1 : 0);
            parcel.writeString(this.d);
            parcel.writeString(this.g);
            parcel.writeLong(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeLong(this.k);
            parcel.writeInt(this.f);
            parcel.writeInt(this.l);
            parcel.writeInt(this.m);
            parcel.writeString(this.n);
            parcel.writeString(this.o);
            parcel.writeInt(this.p);
            parcel.writeString(this.q);
        }
    }
}
