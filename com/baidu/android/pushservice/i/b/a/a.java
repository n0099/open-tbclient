package com.baidu.android.pushservice.i.b.a;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.baidu.android.pushservice.i.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0052a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0052a> f3407a = new AbstractParser<C0052a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0052a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0052a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0052a f3408b;

        /* renamed from: c  reason: collision with root package name */
        public int f3409c;

        /* renamed from: d  reason: collision with root package name */
        public long f3410d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3411e;

        /* renamed from: f  reason: collision with root package name */
        public C0053a f3412f;

        /* renamed from: g  reason: collision with root package name */
        public long f3413g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3414h;

        /* renamed from: i  reason: collision with root package name */
        public ByteString f3415i;
        public byte j;
        public int k;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0053a extends GeneratedMessageLite implements b {

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C0053a> f3416a = new AbstractParser<C0053a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public C0053a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new C0053a(codedInputStream, extensionRegistryLite);
                }
            };

            /* renamed from: b  reason: collision with root package name */
            public static final C0053a f3417b;

            /* renamed from: c  reason: collision with root package name */
            public int f3418c;

            /* renamed from: d  reason: collision with root package name */
            public Object f3419d;

            /* renamed from: e  reason: collision with root package name */
            public byte f3420e;

            /* renamed from: f  reason: collision with root package name */
            public int f3421f;

            /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0054a extends GeneratedMessageLite.Builder<C0053a, C0054a> implements b {

                /* renamed from: a  reason: collision with root package name */
                public int f3422a;

                /* renamed from: b  reason: collision with root package name */
                public Object f3423b = "";

                public C0054a() {
                    g();
                }

                private void g() {
                }

                public static C0054a h() {
                    return new C0054a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: a */
                public C0054a clear() {
                    super.clear();
                    this.f3423b = "";
                    this.f3422a &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C0054a mergeFrom(C0053a c0053a) {
                    if (c0053a != C0053a.a() && c0053a.c()) {
                        this.f3422a |= 1;
                        this.f3423b = c0053a.f3419d;
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
                public C0054a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    C0053a c0053a = null;
                    try {
                        try {
                            C0053a parsePartialFrom = C0053a.f3416a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C0053a c0053a2 = (C0053a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c0053a = c0053a2;
                                if (c0053a != null) {
                                    mergeFrom(c0053a);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c0053a != null) {
                        }
                        throw th;
                    }
                }

                public C0054a a(String str) {
                    if (str != null) {
                        this.f3422a |= 1;
                        this.f3423b = str;
                        return this;
                    }
                    throw null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: b */
                public C0054a clone() {
                    return h().mergeFrom(buildPartial());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                /* renamed from: c */
                public C0053a getDefaultInstanceForType() {
                    return C0053a.a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: d */
                public C0053a build() {
                    C0053a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: e */
                public C0053a buildPartial() {
                    C0053a c0053a = new C0053a(this);
                    int i2 = (this.f3422a & 1) != 1 ? 0 : 1;
                    c0053a.f3419d = this.f3423b;
                    c0053a.f3418c = i2;
                    return c0053a;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }
            }

            static {
                C0053a c0053a = new C0053a();
                f3417b = c0053a;
                c0053a.h();
            }

            public C0053a() {
                this.f3420e = (byte) -1;
                this.f3421f = -1;
            }

            public C0053a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.f3420e = (byte) -1;
                this.f3421f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3418c |= 1;
                                    this.f3419d = codedInputStream.readBytes();
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        } catch (IOException e3) {
                            throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                        }
                    } finally {
                        makeExtensionsImmutable();
                    }
                }
            }

            public C0053a(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.f3420e = (byte) -1;
                this.f3421f = -1;
            }

            public static C0054a a(C0053a c0053a) {
                return e().mergeFrom(c0053a);
            }

            public static C0053a a() {
                return f3417b;
            }

            public static C0054a e() {
                return C0054a.h();
            }

            private void h() {
                this.f3419d = "";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C0053a getDefaultInstanceForType() {
                return f3417b;
            }

            public boolean c() {
                return (this.f3418c & 1) == 1;
            }

            public ByteString d() {
                Object obj = this.f3419d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f3419d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: f */
            public C0054a newBuilderForType() {
                return e();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: g */
            public C0054a toBuilder() {
                return a(this);
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<C0053a> getParserForType() {
                return f3416a;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i2 = this.f3421f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f3418c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                this.f3421f = computeBytesSize;
                return computeBytesSize;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.f3420e;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f3420e = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.f3418c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
            }
        }

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$b */
        /* loaded from: classes.dex */
        public interface b extends MessageLiteOrBuilder {
        }

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$c */
        /* loaded from: classes.dex */
        public static final class c extends GeneratedMessageLite.Builder<C0052a, c> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3424a;

            /* renamed from: b  reason: collision with root package name */
            public long f3425b;

            /* renamed from: e  reason: collision with root package name */
            public long f3428e;

            /* renamed from: c  reason: collision with root package name */
            public Object f3426c = "";

            /* renamed from: d  reason: collision with root package name */
            public C0053a f3427d = C0053a.a();

            /* renamed from: f  reason: collision with root package name */
            public Object f3429f = "";

            /* renamed from: g  reason: collision with root package name */
            public ByteString f3430g = ByteString.EMPTY;

            public c() {
                g();
            }

            private void g() {
            }

            public static c h() {
                return new c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public c clear() {
                super.clear();
                this.f3425b = 0L;
                int i2 = this.f3424a & (-2);
                this.f3424a = i2;
                this.f3426c = "";
                this.f3424a = i2 & (-3);
                this.f3427d = C0053a.a();
                int i3 = this.f3424a & (-5);
                this.f3424a = i3;
                this.f3428e = 0L;
                int i4 = i3 & (-9);
                this.f3424a = i4;
                this.f3429f = "";
                int i5 = i4 & (-17);
                this.f3424a = i5;
                this.f3430g = ByteString.EMPTY;
                this.f3424a = i5 & (-33);
                return this;
            }

            public c a(long j) {
                this.f3424a |= 1;
                this.f3425b = j;
                return this;
            }

            public c a(C0053a c0053a) {
                if (c0053a != null) {
                    this.f3427d = c0053a;
                    this.f3424a |= 4;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public c mergeFrom(C0052a c0052a) {
                if (c0052a == C0052a.a()) {
                    return this;
                }
                if (c0052a.c()) {
                    a(c0052a.d());
                }
                if (c0052a.e()) {
                    this.f3424a |= 2;
                    this.f3426c = c0052a.f3411e;
                }
                if (c0052a.g()) {
                    b(c0052a.h());
                }
                if (c0052a.i()) {
                    b(c0052a.j());
                }
                if (c0052a.k()) {
                    this.f3424a |= 16;
                    this.f3429f = c0052a.f3414h;
                }
                if (c0052a.m()) {
                    a(c0052a.n());
                }
                return this;
            }

            public c a(ByteString byteString) {
                if (byteString != null) {
                    this.f3424a |= 32;
                    this.f3430g = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                C0052a c0052a = null;
                try {
                    try {
                        C0052a parsePartialFrom = C0052a.f3407a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        C0052a c0052a2 = (C0052a) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            c0052a = c0052a2;
                            if (c0052a != null) {
                                mergeFrom(c0052a);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0052a != null) {
                    }
                    throw th;
                }
            }

            public c a(String str) {
                if (str != null) {
                    this.f3424a |= 2;
                    this.f3426c = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public c clone() {
                return h().mergeFrom(buildPartial());
            }

            public c b(long j) {
                this.f3424a |= 8;
                this.f3428e = j;
                return this;
            }

            public c b(C0053a c0053a) {
                if ((this.f3424a & 4) == 4 && this.f3427d != C0053a.a()) {
                    c0053a = C0053a.a(this.f3427d).mergeFrom(c0053a).buildPartial();
                }
                this.f3427d = c0053a;
                this.f3424a |= 4;
                return this;
            }

            public c b(String str) {
                if (str != null) {
                    this.f3424a |= 16;
                    this.f3429f = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C0052a getDefaultInstanceForType() {
                return C0052a.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C0052a build() {
                C0052a buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C0052a buildPartial() {
                C0052a c0052a = new C0052a(this);
                int i2 = this.f3424a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0052a.f3410d = this.f3425b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0052a.f3411e = this.f3426c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                c0052a.f3412f = this.f3427d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                c0052a.f3413g = this.f3428e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                c0052a.f3414h = this.f3429f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                c0052a.f3415i = this.f3430g;
                c0052a.f3409c = i3;
                return c0052a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0052a c0052a = new C0052a();
            f3408b = c0052a;
            c0052a.r();
        }

        public C0052a() {
            this.j = (byte) -1;
            this.k = -1;
        }

        public C0052a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.j = (byte) -1;
            this.k = -1;
            r();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f3409c |= 1;
                                this.f3410d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3409c |= 2;
                                this.f3411e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                C0053a.C0054a builder = (this.f3409c & 4) == 4 ? this.f3412f.toBuilder() : null;
                                C0053a c0053a = (C0053a) codedInputStream.readMessage(C0053a.f3416a, extensionRegistryLite);
                                this.f3412f = c0053a;
                                if (builder != null) {
                                    builder.mergeFrom(c0053a);
                                    this.f3412f = builder.buildPartial();
                                }
                                this.f3409c |= 4;
                            } else if (readTag == 32) {
                                this.f3409c |= 8;
                                this.f3413g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3409c |= 16;
                                this.f3414h = codedInputStream.readBytes();
                            } else if (readTag == 50) {
                                this.f3409c |= 32;
                                this.f3415i = codedInputStream.readBytes();
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        public C0052a(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.j = (byte) -1;
            this.k = -1;
        }

        public static c a(C0052a c0052a) {
            return o().mergeFrom(c0052a);
        }

        public static C0052a a() {
            return f3408b;
        }

        public static c o() {
            return c.h();
        }

        private void r() {
            this.f3410d = 0L;
            this.f3411e = "";
            this.f3412f = C0053a.a();
            this.f3413g = 0L;
            this.f3414h = "";
            this.f3415i = ByteString.EMPTY;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0052a getDefaultInstanceForType() {
            return f3408b;
        }

        public boolean c() {
            return (this.f3409c & 1) == 1;
        }

        public long d() {
            return this.f3410d;
        }

        public boolean e() {
            return (this.f3409c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3411e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3411e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3409c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0052a> getParserForType() {
            return f3407a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.k;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3409c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3410d) : 0;
            if ((this.f3409c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3409c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.f3412f);
            }
            if ((this.f3409c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3413g);
            }
            if ((this.f3409c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3409c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, this.f3415i);
            }
            this.k = computeInt64Size;
            return computeInt64Size;
        }

        public C0053a h() {
            return this.f3412f;
        }

        public boolean i() {
            return (this.f3409c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.j;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.j = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3413g;
        }

        public boolean k() {
            return (this.f3409c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3414h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3414h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3409c & 32) == 32;
        }

        public ByteString n() {
            return this.f3415i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: p */
        public c newBuilderForType() {
            return o();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: q */
        public c toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3409c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3410d);
            }
            if ((this.f3409c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3409c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3412f);
            }
            if ((this.f3409c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3413g);
            }
            if ((this.f3409c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3409c & 32) == 32) {
                codedOutputStream.writeBytes(6, this.f3415i);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3431a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.b.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3432b;

        /* renamed from: c  reason: collision with root package name */
        public int f3433c;

        /* renamed from: d  reason: collision with root package name */
        public int f3434d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3435e;

        /* renamed from: f  reason: collision with root package name */
        public long f3436f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3437g;

        /* renamed from: h  reason: collision with root package name */
        public int f3438h;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0055a extends GeneratedMessageLite.Builder<c, C0055a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3439a;

            /* renamed from: b  reason: collision with root package name */
            public int f3440b;

            /* renamed from: c  reason: collision with root package name */
            public Object f3441c = "";

            /* renamed from: d  reason: collision with root package name */
            public long f3442d;

            public C0055a() {
                g();
            }

            private void g() {
            }

            public static C0055a h() {
                return new C0055a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0055a clear() {
                super.clear();
                this.f3440b = 0;
                int i2 = this.f3439a & (-2);
                this.f3439a = i2;
                this.f3441c = "";
                int i3 = i2 & (-3);
                this.f3439a = i3;
                this.f3442d = 0L;
                this.f3439a = i3 & (-5);
                return this;
            }

            public C0055a a(int i2) {
                this.f3439a |= 1;
                this.f3440b = i2;
                return this;
            }

            public C0055a a(long j) {
                this.f3439a |= 4;
                this.f3442d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0055a mergeFrom(c cVar) {
                if (cVar == c.a()) {
                    return this;
                }
                if (cVar.c()) {
                    a(cVar.d());
                }
                if (cVar.e()) {
                    this.f3439a |= 2;
                    this.f3441c = cVar.f3435e;
                }
                if (cVar.h()) {
                    a(cVar.i());
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
            public C0055a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f3431a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        c cVar2 = (c) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            cVar = cVar2;
                            if (cVar != null) {
                                mergeFrom(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0055a clone() {
                return h().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public c getDefaultInstanceForType() {
                return c.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public c build() {
                c buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public c buildPartial() {
                c cVar = new c(this);
                int i2 = this.f3439a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f3434d = this.f3440b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.f3435e = this.f3441c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.f3436f = this.f3442d;
                cVar.f3433c = i3;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3432b = cVar;
            cVar.m();
        }

        public c() {
            this.f3437g = (byte) -1;
            this.f3438h = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3437g = (byte) -1;
            this.f3438h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3433c |= 1;
                                    this.f3434d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3433c |= 2;
                                    this.f3435e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3433c |= 4;
                                    this.f3436f = codedInputStream.readInt64();
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        public c(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3437g = (byte) -1;
            this.f3438h = -1;
        }

        public static C0055a a(c cVar) {
            return j().mergeFrom(cVar);
        }

        public static c a() {
            return f3432b;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return f3431a.parseFrom(bArr);
        }

        public static C0055a j() {
            return C0055a.h();
        }

        private void m() {
            this.f3434d = 0;
            this.f3435e = "";
            this.f3436f = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3432b;
        }

        public boolean c() {
            return (this.f3433c & 1) == 1;
        }

        public int d() {
            return this.f3434d;
        }

        public boolean e() {
            return (this.f3433c & 2) == 2;
        }

        public String f() {
            Object obj = this.f3435e;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f3435e = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString g() {
            Object obj = this.f3435e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3435e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3431a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3438h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.f3433c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3434d) : 0;
            if ((this.f3433c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, g());
            }
            if ((this.f3433c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt64Size(3, this.f3436f);
            }
            this.f3438h = computeInt32Size;
            return computeInt32Size;
        }

        public boolean h() {
            return (this.f3433c & 4) == 4;
        }

        public long i() {
            return this.f3436f;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3437g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3437g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0055a newBuilderForType() {
            return j();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0055a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3433c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3434d);
            }
            if ((this.f3433c & 2) == 2) {
                codedOutputStream.writeBytes(2, g());
            }
            if ((this.f3433c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3436f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
