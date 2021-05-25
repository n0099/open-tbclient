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
        public static Parser<C0053a> f3410a = new AbstractParser<C0053a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0053a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0053a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0053a f3411b;

        /* renamed from: c  reason: collision with root package name */
        public int f3412c;

        /* renamed from: d  reason: collision with root package name */
        public long f3413d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3414e;

        /* renamed from: f  reason: collision with root package name */
        public C0054a f3415f;

        /* renamed from: g  reason: collision with root package name */
        public long f3416g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3417h;

        /* renamed from: i  reason: collision with root package name */
        public ByteString f3418i;
        public byte j;
        public int k;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0054a extends GeneratedMessageLite implements b {

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C0054a> f3419a = new AbstractParser<C0054a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public C0054a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new C0054a(codedInputStream, extensionRegistryLite);
                }
            };

            /* renamed from: b  reason: collision with root package name */
            public static final C0054a f3420b;

            /* renamed from: c  reason: collision with root package name */
            public int f3421c;

            /* renamed from: d  reason: collision with root package name */
            public Object f3422d;

            /* renamed from: e  reason: collision with root package name */
            public byte f3423e;

            /* renamed from: f  reason: collision with root package name */
            public int f3424f;

            /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0055a extends GeneratedMessageLite.Builder<C0054a, C0055a> implements b {

                /* renamed from: a  reason: collision with root package name */
                public int f3425a;

                /* renamed from: b  reason: collision with root package name */
                public Object f3426b = "";

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
                    this.f3426b = "";
                    this.f3425a &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C0055a mergeFrom(C0054a c0054a) {
                    if (c0054a != C0054a.a() && c0054a.c()) {
                        this.f3425a |= 1;
                        this.f3426b = c0054a.f3422d;
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
                            C0054a parsePartialFrom = C0054a.f3419a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f3425a |= 1;
                        this.f3426b = str;
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
                    int i2 = (this.f3425a & 1) != 1 ? 0 : 1;
                    c0054a.f3422d = this.f3426b;
                    c0054a.f3421c = i2;
                    return c0054a;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }
            }

            static {
                C0054a c0054a = new C0054a();
                f3420b = c0054a;
                c0054a.h();
            }

            public C0054a() {
                this.f3423e = (byte) -1;
                this.f3424f = -1;
            }

            public C0054a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.f3423e = (byte) -1;
                this.f3424f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3421c |= 1;
                                    this.f3422d = codedInputStream.readBytes();
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
                this.f3423e = (byte) -1;
                this.f3424f = -1;
            }

            public static C0055a a(C0054a c0054a) {
                return e().mergeFrom(c0054a);
            }

            public static C0054a a() {
                return f3420b;
            }

            public static C0055a e() {
                return C0055a.h();
            }

            private void h() {
                this.f3422d = "";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C0054a getDefaultInstanceForType() {
                return f3420b;
            }

            public boolean c() {
                return (this.f3421c & 1) == 1;
            }

            public ByteString d() {
                Object obj = this.f3422d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f3422d = copyFromUtf8;
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
                return f3419a;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i2 = this.f3424f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f3421c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                this.f3424f = computeBytesSize;
                return computeBytesSize;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.f3423e;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f3423e = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.f3421c & 1) == 1) {
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
            public int f3427a;

            /* renamed from: b  reason: collision with root package name */
            public long f3428b;

            /* renamed from: e  reason: collision with root package name */
            public long f3431e;

            /* renamed from: c  reason: collision with root package name */
            public Object f3429c = "";

            /* renamed from: d  reason: collision with root package name */
            public C0054a f3430d = C0054a.a();

            /* renamed from: f  reason: collision with root package name */
            public Object f3432f = "";

            /* renamed from: g  reason: collision with root package name */
            public ByteString f3433g = ByteString.EMPTY;

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
                this.f3428b = 0L;
                int i2 = this.f3427a & (-2);
                this.f3427a = i2;
                this.f3429c = "";
                this.f3427a = i2 & (-3);
                this.f3430d = C0054a.a();
                int i3 = this.f3427a & (-5);
                this.f3427a = i3;
                this.f3431e = 0L;
                int i4 = i3 & (-9);
                this.f3427a = i4;
                this.f3432f = "";
                int i5 = i4 & (-17);
                this.f3427a = i5;
                this.f3433g = ByteString.EMPTY;
                this.f3427a = i5 & (-33);
                return this;
            }

            public c a(long j) {
                this.f3427a |= 1;
                this.f3428b = j;
                return this;
            }

            public c a(C0054a c0054a) {
                if (c0054a != null) {
                    this.f3430d = c0054a;
                    this.f3427a |= 4;
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
                    this.f3427a |= 2;
                    this.f3429c = c0053a.f3414e;
                }
                if (c0053a.g()) {
                    b(c0053a.h());
                }
                if (c0053a.i()) {
                    b(c0053a.j());
                }
                if (c0053a.k()) {
                    this.f3427a |= 16;
                    this.f3432f = c0053a.f3417h;
                }
                if (c0053a.m()) {
                    a(c0053a.n());
                }
                return this;
            }

            public c a(ByteString byteString) {
                if (byteString != null) {
                    this.f3427a |= 32;
                    this.f3433g = byteString;
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
                        C0053a parsePartialFrom = C0053a.f3410a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3427a |= 2;
                    this.f3429c = str;
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
                this.f3427a |= 8;
                this.f3431e = j;
                return this;
            }

            public c b(C0054a c0054a) {
                if ((this.f3427a & 4) == 4 && this.f3430d != C0054a.a()) {
                    c0054a = C0054a.a(this.f3430d).mergeFrom(c0054a).buildPartial();
                }
                this.f3430d = c0054a;
                this.f3427a |= 4;
                return this;
            }

            public c b(String str) {
                if (str != null) {
                    this.f3427a |= 16;
                    this.f3432f = str;
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
                int i2 = this.f3427a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0053a.f3413d = this.f3428b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0053a.f3414e = this.f3429c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                c0053a.f3415f = this.f3430d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                c0053a.f3416g = this.f3431e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                c0053a.f3417h = this.f3432f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                c0053a.f3418i = this.f3433g;
                c0053a.f3412c = i3;
                return c0053a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0053a c0053a = new C0053a();
            f3411b = c0053a;
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
                                this.f3412c |= 1;
                                this.f3413d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3412c |= 2;
                                this.f3414e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                C0054a.C0055a builder = (this.f3412c & 4) == 4 ? this.f3415f.toBuilder() : null;
                                C0054a c0054a = (C0054a) codedInputStream.readMessage(C0054a.f3419a, extensionRegistryLite);
                                this.f3415f = c0054a;
                                if (builder != null) {
                                    builder.mergeFrom(c0054a);
                                    this.f3415f = builder.buildPartial();
                                }
                                this.f3412c |= 4;
                            } else if (readTag == 32) {
                                this.f3412c |= 8;
                                this.f3416g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3412c |= 16;
                                this.f3417h = codedInputStream.readBytes();
                            } else if (readTag == 50) {
                                this.f3412c |= 32;
                                this.f3418i = codedInputStream.readBytes();
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
            return f3411b;
        }

        public static c o() {
            return c.h();
        }

        private void r() {
            this.f3413d = 0L;
            this.f3414e = "";
            this.f3415f = C0054a.a();
            this.f3416g = 0L;
            this.f3417h = "";
            this.f3418i = ByteString.EMPTY;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0053a getDefaultInstanceForType() {
            return f3411b;
        }

        public boolean c() {
            return (this.f3412c & 1) == 1;
        }

        public long d() {
            return this.f3413d;
        }

        public boolean e() {
            return (this.f3412c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3414e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3414e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3412c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0053a> getParserForType() {
            return f3410a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.k;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3412c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3413d) : 0;
            if ((this.f3412c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3412c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.f3415f);
            }
            if ((this.f3412c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3416g);
            }
            if ((this.f3412c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3412c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, this.f3418i);
            }
            this.k = computeInt64Size;
            return computeInt64Size;
        }

        public C0054a h() {
            return this.f3415f;
        }

        public boolean i() {
            return (this.f3412c & 8) == 8;
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
            return this.f3416g;
        }

        public boolean k() {
            return (this.f3412c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3417h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3417h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3412c & 32) == 32;
        }

        public ByteString n() {
            return this.f3418i;
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
            if ((this.f3412c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3413d);
            }
            if ((this.f3412c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3412c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3415f);
            }
            if ((this.f3412c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3416g);
            }
            if ((this.f3412c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3412c & 32) == 32) {
                codedOutputStream.writeBytes(6, this.f3418i);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3434a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.b.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3435b;

        /* renamed from: c  reason: collision with root package name */
        public int f3436c;

        /* renamed from: d  reason: collision with root package name */
        public int f3437d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3438e;

        /* renamed from: f  reason: collision with root package name */
        public long f3439f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3440g;

        /* renamed from: h  reason: collision with root package name */
        public int f3441h;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0056a extends GeneratedMessageLite.Builder<c, C0056a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3442a;

            /* renamed from: b  reason: collision with root package name */
            public int f3443b;

            /* renamed from: c  reason: collision with root package name */
            public Object f3444c = "";

            /* renamed from: d  reason: collision with root package name */
            public long f3445d;

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
                this.f3443b = 0;
                int i2 = this.f3442a & (-2);
                this.f3442a = i2;
                this.f3444c = "";
                int i3 = i2 & (-3);
                this.f3442a = i3;
                this.f3445d = 0L;
                this.f3442a = i3 & (-5);
                return this;
            }

            public C0056a a(int i2) {
                this.f3442a |= 1;
                this.f3443b = i2;
                return this;
            }

            public C0056a a(long j) {
                this.f3442a |= 4;
                this.f3445d = j;
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
                    this.f3442a |= 2;
                    this.f3444c = cVar.f3438e;
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
                        c parsePartialFrom = c.f3434a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                int i2 = this.f3442a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f3437d = this.f3443b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.f3438e = this.f3444c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.f3439f = this.f3445d;
                cVar.f3436c = i3;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3435b = cVar;
            cVar.m();
        }

        public c() {
            this.f3440g = (byte) -1;
            this.f3441h = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3440g = (byte) -1;
            this.f3441h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3436c |= 1;
                                    this.f3437d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3436c |= 2;
                                    this.f3438e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3436c |= 4;
                                    this.f3439f = codedInputStream.readInt64();
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
            this.f3440g = (byte) -1;
            this.f3441h = -1;
        }

        public static C0056a a(c cVar) {
            return j().mergeFrom(cVar);
        }

        public static c a() {
            return f3435b;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return f3434a.parseFrom(bArr);
        }

        public static C0056a j() {
            return C0056a.h();
        }

        private void m() {
            this.f3437d = 0;
            this.f3438e = "";
            this.f3439f = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3435b;
        }

        public boolean c() {
            return (this.f3436c & 1) == 1;
        }

        public int d() {
            return this.f3437d;
        }

        public boolean e() {
            return (this.f3436c & 2) == 2;
        }

        public String f() {
            Object obj = this.f3438e;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f3438e = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString g() {
            Object obj = this.f3438e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3438e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3434a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3441h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.f3436c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3437d) : 0;
            if ((this.f3436c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, g());
            }
            if ((this.f3436c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt64Size(3, this.f3439f);
            }
            this.f3441h = computeInt32Size;
            return computeInt32Size;
        }

        public boolean h() {
            return (this.f3436c & 4) == 4;
        }

        public long i() {
            return this.f3439f;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3440g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3440g = (byte) 1;
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
            if ((this.f3436c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3437d);
            }
            if ((this.f3436c & 2) == 2) {
                codedOutputStream.writeBytes(2, g());
            }
            if ((this.f3436c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3439f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
