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
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.baidu.android.pushservice.i.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0053a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0053a> f3336a = new AbstractParser<C0053a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0053a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0053a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0053a f3337b;

        /* renamed from: c  reason: collision with root package name */
        public int f3338c;

        /* renamed from: d  reason: collision with root package name */
        public long f3339d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3340e;

        /* renamed from: f  reason: collision with root package name */
        public C0054a f3341f;

        /* renamed from: g  reason: collision with root package name */
        public long f3342g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3343h;
        public ByteString i;
        public byte j;
        public int k;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0054a extends GeneratedMessageLite implements b {

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C0054a> f3344a = new AbstractParser<C0054a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public C0054a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new C0054a(codedInputStream, extensionRegistryLite);
                }
            };

            /* renamed from: b  reason: collision with root package name */
            public static final C0054a f3345b;

            /* renamed from: c  reason: collision with root package name */
            public int f3346c;

            /* renamed from: d  reason: collision with root package name */
            public Object f3347d;

            /* renamed from: e  reason: collision with root package name */
            public byte f3348e;

            /* renamed from: f  reason: collision with root package name */
            public int f3349f;

            /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0055a extends GeneratedMessageLite.Builder<C0054a, C0055a> implements b {

                /* renamed from: a  reason: collision with root package name */
                public int f3350a;

                /* renamed from: b  reason: collision with root package name */
                public Object f3351b = "";

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
                    this.f3351b = "";
                    this.f3350a &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C0055a mergeFrom(C0054a c0054a) {
                    if (c0054a != C0054a.a() && c0054a.c()) {
                        this.f3350a |= 1;
                        this.f3351b = c0054a.f3347d;
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
                            C0054a parsePartialFrom = C0054a.f3344a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                        this.f3350a |= 1;
                        this.f3351b = str;
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
                    int i = (this.f3350a & 1) != 1 ? 0 : 1;
                    c0054a.f3347d = this.f3351b;
                    c0054a.f3346c = i;
                    return c0054a;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }
            }

            static {
                C0054a c0054a = new C0054a();
                f3345b = c0054a;
                c0054a.h();
            }

            public C0054a() {
                this.f3348e = (byte) -1;
                this.f3349f = -1;
            }

            public C0054a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.f3348e = (byte) -1;
                this.f3349f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3346c |= 1;
                                    this.f3347d = codedInputStream.readBytes();
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
                this.f3348e = (byte) -1;
                this.f3349f = -1;
            }

            public static C0055a a(C0054a c0054a) {
                return e().mergeFrom(c0054a);
            }

            public static C0054a a() {
                return f3345b;
            }

            public static C0055a e() {
                return C0055a.h();
            }

            private void h() {
                this.f3347d = "";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C0054a getDefaultInstanceForType() {
                return f3345b;
            }

            public boolean c() {
                return (this.f3346c & 1) == 1;
            }

            public ByteString d() {
                Object obj = this.f3347d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f3347d = copyFromUtf8;
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
                return f3344a;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.f3349f;
                if (i != -1) {
                    return i;
                }
                int computeBytesSize = (this.f3346c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                this.f3349f = computeBytesSize;
                return computeBytesSize;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.f3348e;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f3348e = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.f3346c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
            }
        }

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$b */
        /* loaded from: classes2.dex */
        public interface b extends MessageLiteOrBuilder {
        }

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$c */
        /* loaded from: classes2.dex */
        public static final class c extends GeneratedMessageLite.Builder<C0053a, c> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3352a;

            /* renamed from: b  reason: collision with root package name */
            public long f3353b;

            /* renamed from: e  reason: collision with root package name */
            public long f3356e;

            /* renamed from: c  reason: collision with root package name */
            public Object f3354c = "";

            /* renamed from: d  reason: collision with root package name */
            public C0054a f3355d = C0054a.a();

            /* renamed from: f  reason: collision with root package name */
            public Object f3357f = "";

            /* renamed from: g  reason: collision with root package name */
            public ByteString f3358g = ByteString.EMPTY;

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
                this.f3353b = 0L;
                int i = this.f3352a & (-2);
                this.f3352a = i;
                this.f3354c = "";
                this.f3352a = i & (-3);
                this.f3355d = C0054a.a();
                int i2 = this.f3352a & (-5);
                this.f3352a = i2;
                this.f3356e = 0L;
                int i3 = i2 & (-9);
                this.f3352a = i3;
                this.f3357f = "";
                int i4 = i3 & (-17);
                this.f3352a = i4;
                this.f3358g = ByteString.EMPTY;
                this.f3352a = i4 & (-33);
                return this;
            }

            public c a(long j) {
                this.f3352a |= 1;
                this.f3353b = j;
                return this;
            }

            public c a(C0054a c0054a) {
                if (c0054a != null) {
                    this.f3355d = c0054a;
                    this.f3352a |= 4;
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
                    this.f3352a |= 2;
                    this.f3354c = c0053a.f3340e;
                }
                if (c0053a.g()) {
                    b(c0053a.h());
                }
                if (c0053a.i()) {
                    b(c0053a.j());
                }
                if (c0053a.k()) {
                    this.f3352a |= 16;
                    this.f3357f = c0053a.f3343h;
                }
                if (c0053a.m()) {
                    a(c0053a.n());
                }
                return this;
            }

            public c a(ByteString byteString) {
                if (byteString != null) {
                    this.f3352a |= 32;
                    this.f3358g = byteString;
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
                        C0053a parsePartialFrom = C0053a.f3336a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                    this.f3352a |= 2;
                    this.f3354c = str;
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
                this.f3352a |= 8;
                this.f3356e = j;
                return this;
            }

            public c b(C0054a c0054a) {
                if ((this.f3352a & 4) == 4 && this.f3355d != C0054a.a()) {
                    c0054a = C0054a.a(this.f3355d).mergeFrom(c0054a).buildPartial();
                }
                this.f3355d = c0054a;
                this.f3352a |= 4;
                return this;
            }

            public c b(String str) {
                if (str != null) {
                    this.f3352a |= 16;
                    this.f3357f = str;
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
                int i = this.f3352a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c0053a.f3339d = this.f3353b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c0053a.f3340e = this.f3354c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                c0053a.f3341f = this.f3355d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                c0053a.f3342g = this.f3356e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                c0053a.f3343h = this.f3357f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                c0053a.i = this.f3358g;
                c0053a.f3338c = i2;
                return c0053a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0053a c0053a = new C0053a();
            f3337b = c0053a;
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
                                this.f3338c |= 1;
                                this.f3339d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3338c |= 2;
                                this.f3340e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                C0054a.C0055a builder = (this.f3338c & 4) == 4 ? this.f3341f.toBuilder() : null;
                                C0054a c0054a = (C0054a) codedInputStream.readMessage(C0054a.f3344a, extensionRegistryLite);
                                this.f3341f = c0054a;
                                if (builder != null) {
                                    builder.mergeFrom(c0054a);
                                    this.f3341f = builder.buildPartial();
                                }
                                this.f3338c |= 4;
                            } else if (readTag == 32) {
                                this.f3338c |= 8;
                                this.f3342g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3338c |= 16;
                                this.f3343h = codedInputStream.readBytes();
                            } else if (readTag == 50) {
                                this.f3338c |= 32;
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
            return f3337b;
        }

        public static c o() {
            return c.h();
        }

        private void r() {
            this.f3339d = 0L;
            this.f3340e = "";
            this.f3341f = C0054a.a();
            this.f3342g = 0L;
            this.f3343h = "";
            this.i = ByteString.EMPTY;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0053a getDefaultInstanceForType() {
            return f3337b;
        }

        public boolean c() {
            return (this.f3338c & 1) == 1;
        }

        public long d() {
            return this.f3339d;
        }

        public boolean e() {
            return (this.f3338c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3340e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3340e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3338c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0053a> getParserForType() {
            return f3336a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.k;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.f3338c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3339d) : 0;
            if ((this.f3338c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3338c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.f3341f);
            }
            if ((this.f3338c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3342g);
            }
            if ((this.f3338c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3338c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, this.i);
            }
            this.k = computeInt64Size;
            return computeInt64Size;
        }

        public C0054a h() {
            return this.f3341f;
        }

        public boolean i() {
            return (this.f3338c & 8) == 8;
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
            return this.f3342g;
        }

        public boolean k() {
            return (this.f3338c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3343h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3343h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3338c & 32) == 32;
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
            if ((this.f3338c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3339d);
            }
            if ((this.f3338c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3338c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3341f);
            }
            if ((this.f3338c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3342g);
            }
            if ((this.f3338c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3338c & 32) == 32) {
                codedOutputStream.writeBytes(6, this.i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes2.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3359a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.b.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3360b;

        /* renamed from: c  reason: collision with root package name */
        public int f3361c;

        /* renamed from: d  reason: collision with root package name */
        public int f3362d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3363e;

        /* renamed from: f  reason: collision with root package name */
        public long f3364f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3365g;

        /* renamed from: h  reason: collision with root package name */
        public int f3366h;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0056a extends GeneratedMessageLite.Builder<c, C0056a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3367a;

            /* renamed from: b  reason: collision with root package name */
            public int f3368b;

            /* renamed from: c  reason: collision with root package name */
            public Object f3369c = "";

            /* renamed from: d  reason: collision with root package name */
            public long f3370d;

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
                this.f3368b = 0;
                int i = this.f3367a & (-2);
                this.f3367a = i;
                this.f3369c = "";
                int i2 = i & (-3);
                this.f3367a = i2;
                this.f3370d = 0L;
                this.f3367a = i2 & (-5);
                return this;
            }

            public C0056a a(int i) {
                this.f3367a |= 1;
                this.f3368b = i;
                return this;
            }

            public C0056a a(long j) {
                this.f3367a |= 4;
                this.f3370d = j;
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
                    this.f3367a |= 2;
                    this.f3369c = cVar.f3363e;
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
                        c parsePartialFrom = c.f3359a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
                int i = this.f3367a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.f3362d = this.f3368b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.f3363e = this.f3369c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.f3364f = this.f3370d;
                cVar.f3361c = i2;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3360b = cVar;
            cVar.m();
        }

        public c() {
            this.f3365g = (byte) -1;
            this.f3366h = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3365g = (byte) -1;
            this.f3366h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3361c |= 1;
                                    this.f3362d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3361c |= 2;
                                    this.f3363e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3361c |= 4;
                                    this.f3364f = codedInputStream.readInt64();
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
            this.f3365g = (byte) -1;
            this.f3366h = -1;
        }

        public static C0056a a(c cVar) {
            return j().mergeFrom(cVar);
        }

        public static c a() {
            return f3360b;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return f3359a.parseFrom(bArr);
        }

        public static C0056a j() {
            return C0056a.h();
        }

        private void m() {
            this.f3362d = 0;
            this.f3363e = "";
            this.f3364f = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3360b;
        }

        public boolean c() {
            return (this.f3361c & 1) == 1;
        }

        public int d() {
            return this.f3362d;
        }

        public boolean e() {
            return (this.f3361c & 2) == 2;
        }

        public String f() {
            Object obj = this.f3363e;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f3363e = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString g() {
            Object obj = this.f3363e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3363e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3359a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3366h;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.f3361c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3362d) : 0;
            if ((this.f3361c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, g());
            }
            if ((this.f3361c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt64Size(3, this.f3364f);
            }
            this.f3366h = computeInt32Size;
            return computeInt32Size;
        }

        public boolean h() {
            return (this.f3361c & 4) == 4;
        }

        public long i() {
            return this.f3364f;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3365g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3365g = (byte) 1;
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
            if ((this.f3361c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3362d);
            }
            if ((this.f3361c & 2) == 2) {
                codedOutputStream.writeBytes(2, g());
            }
            if ((this.f3361c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3364f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
