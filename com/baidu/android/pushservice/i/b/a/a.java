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
    public static final class C0053a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0053a> f3372a = new AbstractParser<C0053a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0053a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0053a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0053a f3373b;

        /* renamed from: c  reason: collision with root package name */
        public int f3374c;

        /* renamed from: d  reason: collision with root package name */
        public long f3375d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3376e;

        /* renamed from: f  reason: collision with root package name */
        public C0054a f3377f;

        /* renamed from: g  reason: collision with root package name */
        public long f3378g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3379h;
        public ByteString i;
        public byte j;
        public int k;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0054a extends GeneratedMessageLite implements b {

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C0054a> f3380a = new AbstractParser<C0054a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public C0054a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new C0054a(codedInputStream, extensionRegistryLite);
                }
            };

            /* renamed from: b  reason: collision with root package name */
            public static final C0054a f3381b;

            /* renamed from: c  reason: collision with root package name */
            public int f3382c;

            /* renamed from: d  reason: collision with root package name */
            public Object f3383d;

            /* renamed from: e  reason: collision with root package name */
            public byte f3384e;

            /* renamed from: f  reason: collision with root package name */
            public int f3385f;

            /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0055a extends GeneratedMessageLite.Builder<C0054a, C0055a> implements b {

                /* renamed from: a  reason: collision with root package name */
                public int f3386a;

                /* renamed from: b  reason: collision with root package name */
                public Object f3387b = "";

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
                    this.f3387b = "";
                    this.f3386a &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C0055a mergeFrom(C0054a c0054a) {
                    if (c0054a != C0054a.a() && c0054a.c()) {
                        this.f3386a |= 1;
                        this.f3387b = c0054a.f3383d;
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
                    C0054a c0054a = null;
                    try {
                        try {
                            C0054a parsePartialFrom = C0054a.f3380a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C0054a c0054a2 = (C0054a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c0054a = c0054a2;
                                if (c0054a != null) {
                                    mergeFrom(c0054a);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c0054a != null) {
                        }
                        throw th;
                    }
                }

                public C0055a a(String str) {
                    if (str != null) {
                        this.f3386a |= 1;
                        this.f3387b = str;
                        return this;
                    }
                    throw null;
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
                public C0054a getDefaultInstanceForType() {
                    return C0054a.a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: d */
                public C0054a build() {
                    C0054a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: e */
                public C0054a buildPartial() {
                    C0054a c0054a = new C0054a(this);
                    int i = (this.f3386a & 1) != 1 ? 0 : 1;
                    c0054a.f3383d = this.f3387b;
                    c0054a.f3382c = i;
                    return c0054a;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }
            }

            static {
                C0054a c0054a = new C0054a();
                f3381b = c0054a;
                c0054a.h();
            }

            public C0054a() {
                this.f3384e = (byte) -1;
                this.f3385f = -1;
            }

            public C0054a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.f3384e = (byte) -1;
                this.f3385f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3382c |= 1;
                                    this.f3383d = codedInputStream.readBytes();
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

            public C0054a(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.f3384e = (byte) -1;
                this.f3385f = -1;
            }

            public static C0055a a(C0054a c0054a) {
                return e().mergeFrom(c0054a);
            }

            public static C0054a a() {
                return f3381b;
            }

            public static C0055a e() {
                return C0055a.h();
            }

            private void h() {
                this.f3383d = "";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C0054a getDefaultInstanceForType() {
                return f3381b;
            }

            public boolean c() {
                return (this.f3382c & 1) == 1;
            }

            public ByteString d() {
                Object obj = this.f3383d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f3383d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: f */
            public C0055a newBuilderForType() {
                return e();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: g */
            public C0055a toBuilder() {
                return a(this);
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<C0054a> getParserForType() {
                return f3380a;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.f3385f;
                if (i != -1) {
                    return i;
                }
                int computeBytesSize = (this.f3382c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                this.f3385f = computeBytesSize;
                return computeBytesSize;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.f3384e;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f3384e = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.f3382c & 1) == 1) {
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
        public static final class c extends GeneratedMessageLite.Builder<C0053a, c> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3388a;

            /* renamed from: b  reason: collision with root package name */
            public long f3389b;

            /* renamed from: e  reason: collision with root package name */
            public long f3392e;

            /* renamed from: c  reason: collision with root package name */
            public Object f3390c = "";

            /* renamed from: d  reason: collision with root package name */
            public C0054a f3391d = C0054a.a();

            /* renamed from: f  reason: collision with root package name */
            public Object f3393f = "";

            /* renamed from: g  reason: collision with root package name */
            public ByteString f3394g = ByteString.EMPTY;

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
                this.f3389b = 0L;
                int i = this.f3388a & (-2);
                this.f3388a = i;
                this.f3390c = "";
                this.f3388a = i & (-3);
                this.f3391d = C0054a.a();
                int i2 = this.f3388a & (-5);
                this.f3388a = i2;
                this.f3392e = 0L;
                int i3 = i2 & (-9);
                this.f3388a = i3;
                this.f3393f = "";
                int i4 = i3 & (-17);
                this.f3388a = i4;
                this.f3394g = ByteString.EMPTY;
                this.f3388a = i4 & (-33);
                return this;
            }

            public c a(long j) {
                this.f3388a |= 1;
                this.f3389b = j;
                return this;
            }

            public c a(C0054a c0054a) {
                if (c0054a != null) {
                    this.f3391d = c0054a;
                    this.f3388a |= 4;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public c mergeFrom(C0053a c0053a) {
                if (c0053a == C0053a.a()) {
                    return this;
                }
                if (c0053a.c()) {
                    a(c0053a.d());
                }
                if (c0053a.e()) {
                    this.f3388a |= 2;
                    this.f3390c = c0053a.f3376e;
                }
                if (c0053a.g()) {
                    b(c0053a.h());
                }
                if (c0053a.i()) {
                    b(c0053a.j());
                }
                if (c0053a.k()) {
                    this.f3388a |= 16;
                    this.f3393f = c0053a.f3379h;
                }
                if (c0053a.m()) {
                    a(c0053a.n());
                }
                return this;
            }

            public c a(ByteString byteString) {
                if (byteString != null) {
                    this.f3388a |= 32;
                    this.f3394g = byteString;
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
                C0053a c0053a = null;
                try {
                    try {
                        C0053a parsePartialFrom = C0053a.f3372a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public c a(String str) {
                if (str != null) {
                    this.f3388a |= 2;
                    this.f3390c = str;
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
                this.f3388a |= 8;
                this.f3392e = j;
                return this;
            }

            public c b(C0054a c0054a) {
                if ((this.f3388a & 4) == 4 && this.f3391d != C0054a.a()) {
                    c0054a = C0054a.a(this.f3391d).mergeFrom(c0054a).buildPartial();
                }
                this.f3391d = c0054a;
                this.f3388a |= 4;
                return this;
            }

            public c b(String str) {
                if (str != null) {
                    this.f3388a |= 16;
                    this.f3393f = str;
                    return this;
                }
                throw null;
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
                int i = this.f3388a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c0053a.f3375d = this.f3389b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c0053a.f3376e = this.f3390c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                c0053a.f3377f = this.f3391d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                c0053a.f3378g = this.f3392e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                c0053a.f3379h = this.f3393f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                c0053a.i = this.f3394g;
                c0053a.f3374c = i2;
                return c0053a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0053a c0053a = new C0053a();
            f3373b = c0053a;
            c0053a.r();
        }

        public C0053a() {
            this.j = (byte) -1;
            this.k = -1;
        }

        public C0053a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.f3374c |= 1;
                                this.f3375d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3374c |= 2;
                                this.f3376e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                C0054a.C0055a builder = (this.f3374c & 4) == 4 ? this.f3377f.toBuilder() : null;
                                C0054a c0054a = (C0054a) codedInputStream.readMessage(C0054a.f3380a, extensionRegistryLite);
                                this.f3377f = c0054a;
                                if (builder != null) {
                                    builder.mergeFrom(c0054a);
                                    this.f3377f = builder.buildPartial();
                                }
                                this.f3374c |= 4;
                            } else if (readTag == 32) {
                                this.f3374c |= 8;
                                this.f3378g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3374c |= 16;
                                this.f3379h = codedInputStream.readBytes();
                            } else if (readTag == 50) {
                                this.f3374c |= 32;
                                this.i = codedInputStream.readBytes();
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
            this.j = (byte) -1;
            this.k = -1;
        }

        public static c a(C0053a c0053a) {
            return o().mergeFrom(c0053a);
        }

        public static C0053a a() {
            return f3373b;
        }

        public static c o() {
            return c.h();
        }

        private void r() {
            this.f3375d = 0L;
            this.f3376e = "";
            this.f3377f = C0054a.a();
            this.f3378g = 0L;
            this.f3379h = "";
            this.i = ByteString.EMPTY;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0053a getDefaultInstanceForType() {
            return f3373b;
        }

        public boolean c() {
            return (this.f3374c & 1) == 1;
        }

        public long d() {
            return this.f3375d;
        }

        public boolean e() {
            return (this.f3374c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3376e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3376e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3374c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0053a> getParserForType() {
            return f3372a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.k;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.f3374c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3375d) : 0;
            if ((this.f3374c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3374c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.f3377f);
            }
            if ((this.f3374c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3378g);
            }
            if ((this.f3374c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3374c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, this.i);
            }
            this.k = computeInt64Size;
            return computeInt64Size;
        }

        public C0054a h() {
            return this.f3377f;
        }

        public boolean i() {
            return (this.f3374c & 8) == 8;
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
            return this.f3378g;
        }

        public boolean k() {
            return (this.f3374c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3379h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3379h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3374c & 32) == 32;
        }

        public ByteString n() {
            return this.i;
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
            if ((this.f3374c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3375d);
            }
            if ((this.f3374c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3374c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3377f);
            }
            if ((this.f3374c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3378g);
            }
            if ((this.f3374c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3374c & 32) == 32) {
                codedOutputStream.writeBytes(6, this.i);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3395a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.b.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3396b;

        /* renamed from: c  reason: collision with root package name */
        public int f3397c;

        /* renamed from: d  reason: collision with root package name */
        public int f3398d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3399e;

        /* renamed from: f  reason: collision with root package name */
        public long f3400f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3401g;

        /* renamed from: h  reason: collision with root package name */
        public int f3402h;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0056a extends GeneratedMessageLite.Builder<c, C0056a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3403a;

            /* renamed from: b  reason: collision with root package name */
            public int f3404b;

            /* renamed from: c  reason: collision with root package name */
            public Object f3405c = "";

            /* renamed from: d  reason: collision with root package name */
            public long f3406d;

            public C0056a() {
                g();
            }

            private void g() {
            }

            public static C0056a h() {
                return new C0056a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0056a clear() {
                super.clear();
                this.f3404b = 0;
                int i = this.f3403a & (-2);
                this.f3403a = i;
                this.f3405c = "";
                int i2 = i & (-3);
                this.f3403a = i2;
                this.f3406d = 0L;
                this.f3403a = i2 & (-5);
                return this;
            }

            public C0056a a(int i) {
                this.f3403a |= 1;
                this.f3404b = i;
                return this;
            }

            public C0056a a(long j) {
                this.f3403a |= 4;
                this.f3406d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0056a mergeFrom(c cVar) {
                if (cVar == c.a()) {
                    return this;
                }
                if (cVar.c()) {
                    a(cVar.d());
                }
                if (cVar.e()) {
                    this.f3403a |= 2;
                    this.f3405c = cVar.f3399e;
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
            public C0056a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f3395a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0056a clone() {
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
                int i = this.f3403a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.f3398d = this.f3404b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.f3399e = this.f3405c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.f3400f = this.f3406d;
                cVar.f3397c = i2;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3396b = cVar;
            cVar.m();
        }

        public c() {
            this.f3401g = (byte) -1;
            this.f3402h = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3401g = (byte) -1;
            this.f3402h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3397c |= 1;
                                    this.f3398d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3397c |= 2;
                                    this.f3399e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3397c |= 4;
                                    this.f3400f = codedInputStream.readInt64();
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
            this.f3401g = (byte) -1;
            this.f3402h = -1;
        }

        public static C0056a a(c cVar) {
            return j().mergeFrom(cVar);
        }

        public static c a() {
            return f3396b;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return f3395a.parseFrom(bArr);
        }

        public static C0056a j() {
            return C0056a.h();
        }

        private void m() {
            this.f3398d = 0;
            this.f3399e = "";
            this.f3400f = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3396b;
        }

        public boolean c() {
            return (this.f3397c & 1) == 1;
        }

        public int d() {
            return this.f3398d;
        }

        public boolean e() {
            return (this.f3397c & 2) == 2;
        }

        public String f() {
            Object obj = this.f3399e;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f3399e = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString g() {
            Object obj = this.f3399e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3399e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3395a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3402h;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.f3397c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3398d) : 0;
            if ((this.f3397c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, g());
            }
            if ((this.f3397c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt64Size(3, this.f3400f);
            }
            this.f3402h = computeInt32Size;
            return computeInt32Size;
        }

        public boolean h() {
            return (this.f3397c & 4) == 4;
        }

        public long i() {
            return this.f3400f;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3401g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3401g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0056a newBuilderForType() {
            return j();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0056a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3397c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3398d);
            }
            if ((this.f3397c & 2) == 2) {
                codedOutputStream.writeBytes(2, g());
            }
            if ((this.f3397c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3400f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
