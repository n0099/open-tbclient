package com.baidu.android.pushservice.y.e;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final e k;
    public static Parser<e> l = new a();
    public int a;
    public int b;
    public int c;
    public int d;
    public LazyStringList e;
    public int f;
    public int g;
    public List<c> h;
    public byte i;
    public int j;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<e> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public e parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new e(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<e, b> implements Object {
        public int a;
        public int b;
        public int c;
        public int d;
        public int f;
        public int g;
        public LazyStringList e = LazyStringArrayList.EMPTY;
        public List<c> h = Collections.emptyList();

        public b() {
            j();
        }

        public static /* synthetic */ b a() {
            return f();
        }

        public static b f() {
            return new b();
        }

        public b a(int i) {
            this.a |= 32;
            this.g = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(e eVar) {
            if (eVar == e.c()) {
                return this;
            }
            if (eVar.l()) {
                c(eVar.g());
            }
            if (eVar.k()) {
                b(eVar.f());
            }
            if (eVar.n()) {
                e(eVar.i());
            }
            if (!eVar.e.isEmpty()) {
                if (this.e.isEmpty()) {
                    this.e = eVar.e;
                    this.a &= -9;
                } else {
                    h();
                    this.e.addAll(eVar.e);
                }
            }
            if (eVar.m()) {
                d(eVar.h());
            }
            if (eVar.j()) {
                a(eVar.e());
            }
            if (!eVar.h.isEmpty()) {
                if (this.h.isEmpty()) {
                    this.h = eVar.h;
                    this.a &= -65;
                } else {
                    g();
                    this.h.addAll(eVar.h);
                }
            }
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            e eVar = null;
            try {
                try {
                    e parsePartialFrom = e.l.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    e eVar2 = (e) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        eVar = eVar2;
                        if (eVar != null) {
                            mergeFrom(eVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (eVar != null) {
                }
                throw th;
            }
        }

        public b b(int i) {
            this.a |= 2;
            this.c = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public e build() {
            e buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public b c(int i) {
            this.a |= 1;
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public e buildPartial() {
            e eVar = new e(this);
            int i = this.a;
            int i2 = (i & 1) != 1 ? 0 : 1;
            eVar.b = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            eVar.c = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            eVar.d = this.d;
            if ((this.a & 8) == 8) {
                this.e = new UnmodifiableLazyStringList(this.e);
                this.a &= -9;
            }
            eVar.e = this.e;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            eVar.f = this.f;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            eVar.g = this.g;
            if ((this.a & 64) == 64) {
                this.h = Collections.unmodifiableList(this.h);
                this.a &= -65;
            }
            eVar.h = this.h;
            eVar.a = i2;
            return eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            super.clear();
            this.b = 0;
            int i = this.a & (-2);
            this.a = i;
            this.c = 0;
            int i2 = i & (-3);
            this.a = i2;
            this.d = 0;
            int i3 = i2 & (-5);
            this.a = i3;
            this.e = LazyStringArrayList.EMPTY;
            int i4 = i3 & (-9);
            this.a = i4;
            this.f = 0;
            int i5 = i4 & (-17);
            this.a = i5;
            this.g = 0;
            this.a = i5 & (-33);
            this.h = Collections.emptyList();
            this.a &= -65;
            return this;
        }

        public b d(int i) {
            this.a |= 16;
            this.f = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: e */
        public b mo44clone() {
            return f().mergeFrom(buildPartial());
        }

        public b e(int i) {
            this.a |= 4;
            this.d = i;
            return this;
        }

        public final void g() {
            if ((this.a & 64) != 64) {
                this.h = new ArrayList(this.h);
                this.a |= 64;
            }
        }

        public final void h() {
            if ((this.a & 8) != 8) {
                this.e = new LazyStringArrayList(this.e);
                this.a |= 8;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: i */
        public e getDefaultInstanceForType() {
            return e.c();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public final void j() {
        }
    }

    static {
        e eVar = new e(true);
        k = eVar;
        eVar.o();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<com.baidu.android.pushservice.y.e.c> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.i = (byte) -1;
        this.j = -1;
        o();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (z) {
                break;
            }
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.a |= 1;
                                this.b = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.a |= 2;
                                this.c = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.a |= 4;
                                this.d = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                if (!(z2 & true)) {
                                    this.e = new LazyStringArrayList();
                                    z2 |= true;
                                }
                                this.e.add(codedInputStream.readBytes());
                            } else if (readTag == 40) {
                                this.a |= 8;
                                this.f = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.a |= 16;
                                this.g = codedInputStream.readInt32();
                            } else if (readTag == 58) {
                                if (!(z2 & true)) {
                                    this.h = new ArrayList();
                                    z2 |= true;
                                }
                                this.h.add(codedInputStream.readMessage(c.j, extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                if (z2 & true) {
                    this.e = new UnmodifiableLazyStringList(this.e);
                }
                if (z2 & true) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public e(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.i = (byte) -1;
        this.j = -1;
    }

    public e(boolean z) {
        this.i = (byte) -1;
        this.j = -1;
    }

    public static b c(e eVar) {
        return p().mergeFrom(eVar);
    }

    public static e c() {
        return k;
    }

    public static b p() {
        return b.a();
    }

    public List<c> a() {
        return this.h;
    }

    public List<String> b() {
        return this.e;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: d */
    public e getDefaultInstanceForType() {
        return k;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.b;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<e> getParserForType() {
        return l;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.j;
        if (i != -1) {
            return i;
        }
        int computeUInt32Size = (this.a & 1) == 1 ? CodedOutputStream.computeUInt32Size(1, this.b) + 0 : 0;
        if ((this.a & 2) == 2) {
            computeUInt32Size += CodedOutputStream.computeInt32Size(2, this.c);
        }
        if ((this.a & 4) == 4) {
            computeUInt32Size += CodedOutputStream.computeInt32Size(3, this.d);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            i2 += CodedOutputStream.computeBytesSizeNoTag(this.e.getByteString(i3));
        }
        int size = computeUInt32Size + i2 + (b().size() * 1);
        if ((this.a & 8) == 8) {
            size += CodedOutputStream.computeUInt32Size(5, this.f);
        }
        if ((this.a & 16) == 16) {
            size += CodedOutputStream.computeInt32Size(6, this.g);
        }
        for (int i4 = 0; i4 < this.h.size(); i4++) {
            size += CodedOutputStream.computeMessageSize(7, this.h.get(i4));
        }
        this.j = size;
        return size;
    }

    public int h() {
        return this.f;
    }

    public int i() {
        return this.d;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.i;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.i = (byte) 1;
        return true;
    }

    public boolean j() {
        return (this.a & 16) == 16;
    }

    public boolean k() {
        return (this.a & 2) == 2;
    }

    public boolean l() {
        return (this.a & 1) == 1;
    }

    public boolean m() {
        return (this.a & 8) == 8;
    }

    public boolean n() {
        return (this.a & 4) == 4;
    }

    public final void o() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = LazyStringArrayList.EMPTY;
        this.f = 0;
        this.g = 0;
        this.h = Collections.emptyList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: q */
    public b newBuilderForType() {
        return p();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: r */
    public b toBuilder() {
        return c(this);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.a & 1) == 1) {
            codedOutputStream.writeUInt32(1, this.b);
        }
        if ((this.a & 2) == 2) {
            codedOutputStream.writeInt32(2, this.c);
        }
        if ((this.a & 4) == 4) {
            codedOutputStream.writeInt32(3, this.d);
        }
        for (int i = 0; i < this.e.size(); i++) {
            codedOutputStream.writeBytes(4, this.e.getByteString(i));
        }
        if ((this.a & 8) == 8) {
            codedOutputStream.writeUInt32(5, this.f);
        }
        if ((this.a & 16) == 16) {
            codedOutputStream.writeInt32(6, this.g);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            codedOutputStream.writeMessage(7, this.h.get(i2));
        }
    }
}
