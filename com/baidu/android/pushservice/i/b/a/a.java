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
    public static final class C0054a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0054a> f3429a = new AbstractParser<C0054a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0054a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0054a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0054a f3430b;

        /* renamed from: c  reason: collision with root package name */
        public int f3431c;

        /* renamed from: d  reason: collision with root package name */
        public long f3432d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3433e;

        /* renamed from: f  reason: collision with root package name */
        public C0055a f3434f;

        /* renamed from: g  reason: collision with root package name */
        public long f3435g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3436h;

        /* renamed from: i  reason: collision with root package name */
        public ByteString f3437i;
        public byte j;
        public int k;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0055a extends GeneratedMessageLite implements b {

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C0055a> f3438a = new AbstractParser<C0055a>() { // from class: com.baidu.android.pushservice.i.b.a.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public C0055a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new C0055a(codedInputStream, extensionRegistryLite);
                }
            };

            /* renamed from: b  reason: collision with root package name */
            public static final C0055a f3439b;

            /* renamed from: c  reason: collision with root package name */
            public int f3440c;

            /* renamed from: d  reason: collision with root package name */
            public Object f3441d;

            /* renamed from: e  reason: collision with root package name */
            public byte f3442e;

            /* renamed from: f  reason: collision with root package name */
            public int f3443f;

            /* renamed from: com.baidu.android.pushservice.i.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0056a extends GeneratedMessageLite.Builder<C0055a, C0056a> implements b {

                /* renamed from: a  reason: collision with root package name */
                public int f3444a;

                /* renamed from: b  reason: collision with root package name */
                public Object f3445b = "";

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
                    this.f3445b = "";
                    this.f3444a &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C0056a mergeFrom(C0055a c0055a) {
                    if (c0055a != C0055a.a() && c0055a.c()) {
                        this.f3444a |= 1;
                        this.f3445b = c0055a.f3441d;
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
                    C0055a c0055a = null;
                    try {
                        try {
                            C0055a parsePartialFrom = C0055a.f3438a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            C0055a c0055a2 = (C0055a) e2.getUnfinishedMessage();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                c0055a = c0055a2;
                                if (c0055a != null) {
                                    mergeFrom(c0055a);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c0055a != null) {
                        }
                        throw th;
                    }
                }

                public C0056a a(String str) {
                    if (str != null) {
                        this.f3444a |= 1;
                        this.f3445b = str;
                        return this;
                    }
                    throw null;
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
                public C0055a getDefaultInstanceForType() {
                    return C0055a.a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: d */
                public C0055a build() {
                    C0055a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: e */
                public C0055a buildPartial() {
                    C0055a c0055a = new C0055a(this);
                    int i2 = (this.f3444a & 1) != 1 ? 0 : 1;
                    c0055a.f3441d = this.f3445b;
                    c0055a.f3440c = i2;
                    return c0055a;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }
            }

            static {
                C0055a c0055a = new C0055a();
                f3439b = c0055a;
                c0055a.h();
            }

            public C0055a() {
                this.f3442e = (byte) -1;
                this.f3443f = -1;
            }

            public C0055a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.f3442e = (byte) -1;
                this.f3443f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3440c |= 1;
                                    this.f3441d = codedInputStream.readBytes();
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

            public C0055a(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.f3442e = (byte) -1;
                this.f3443f = -1;
            }

            public static C0056a a(C0055a c0055a) {
                return e().mergeFrom(c0055a);
            }

            public static C0055a a() {
                return f3439b;
            }

            public static C0056a e() {
                return C0056a.h();
            }

            private void h() {
                this.f3441d = "";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C0055a getDefaultInstanceForType() {
                return f3439b;
            }

            public boolean c() {
                return (this.f3440c & 1) == 1;
            }

            public ByteString d() {
                Object obj = this.f3441d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.f3441d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: f */
            public C0056a newBuilderForType() {
                return e();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: g */
            public C0056a toBuilder() {
                return a(this);
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<C0055a> getParserForType() {
                return f3438a;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i2 = this.f3443f;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.f3440c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                this.f3443f = computeBytesSize;
                return computeBytesSize;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.f3442e;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.f3442e = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.f3440c & 1) == 1) {
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
        public static final class c extends GeneratedMessageLite.Builder<C0054a, c> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3446a;

            /* renamed from: b  reason: collision with root package name */
            public long f3447b;

            /* renamed from: e  reason: collision with root package name */
            public long f3450e;

            /* renamed from: c  reason: collision with root package name */
            public Object f3448c = "";

            /* renamed from: d  reason: collision with root package name */
            public C0055a f3449d = C0055a.a();

            /* renamed from: f  reason: collision with root package name */
            public Object f3451f = "";

            /* renamed from: g  reason: collision with root package name */
            public ByteString f3452g = ByteString.EMPTY;

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
                this.f3447b = 0L;
                int i2 = this.f3446a & (-2);
                this.f3446a = i2;
                this.f3448c = "";
                this.f3446a = i2 & (-3);
                this.f3449d = C0055a.a();
                int i3 = this.f3446a & (-5);
                this.f3446a = i3;
                this.f3450e = 0L;
                int i4 = i3 & (-9);
                this.f3446a = i4;
                this.f3451f = "";
                int i5 = i4 & (-17);
                this.f3446a = i5;
                this.f3452g = ByteString.EMPTY;
                this.f3446a = i5 & (-33);
                return this;
            }

            public c a(long j) {
                this.f3446a |= 1;
                this.f3447b = j;
                return this;
            }

            public c a(C0055a c0055a) {
                if (c0055a != null) {
                    this.f3449d = c0055a;
                    this.f3446a |= 4;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public c mergeFrom(C0054a c0054a) {
                if (c0054a == C0054a.a()) {
                    return this;
                }
                if (c0054a.c()) {
                    a(c0054a.d());
                }
                if (c0054a.e()) {
                    this.f3446a |= 2;
                    this.f3448c = c0054a.f3433e;
                }
                if (c0054a.g()) {
                    b(c0054a.h());
                }
                if (c0054a.i()) {
                    b(c0054a.j());
                }
                if (c0054a.k()) {
                    this.f3446a |= 16;
                    this.f3451f = c0054a.f3436h;
                }
                if (c0054a.m()) {
                    a(c0054a.n());
                }
                return this;
            }

            public c a(ByteString byteString) {
                if (byteString != null) {
                    this.f3446a |= 32;
                    this.f3452g = byteString;
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
                C0054a c0054a = null;
                try {
                    try {
                        C0054a parsePartialFrom = C0054a.f3429a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            public c a(String str) {
                if (str != null) {
                    this.f3446a |= 2;
                    this.f3448c = str;
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
                this.f3446a |= 8;
                this.f3450e = j;
                return this;
            }

            public c b(C0055a c0055a) {
                if ((this.f3446a & 4) == 4 && this.f3449d != C0055a.a()) {
                    c0055a = C0055a.a(this.f3449d).mergeFrom(c0055a).buildPartial();
                }
                this.f3449d = c0055a;
                this.f3446a |= 4;
                return this;
            }

            public c b(String str) {
                if (str != null) {
                    this.f3446a |= 16;
                    this.f3451f = str;
                    return this;
                }
                throw null;
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
                int i2 = this.f3446a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0054a.f3432d = this.f3447b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0054a.f3433e = this.f3448c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                c0054a.f3434f = this.f3449d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                c0054a.f3435g = this.f3450e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                c0054a.f3436h = this.f3451f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                c0054a.f3437i = this.f3452g;
                c0054a.f3431c = i3;
                return c0054a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0054a c0054a = new C0054a();
            f3430b = c0054a;
            c0054a.r();
        }

        public C0054a() {
            this.j = (byte) -1;
            this.k = -1;
        }

        public C0054a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.f3431c |= 1;
                                this.f3432d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3431c |= 2;
                                this.f3433e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                C0055a.C0056a builder = (this.f3431c & 4) == 4 ? this.f3434f.toBuilder() : null;
                                C0055a c0055a = (C0055a) codedInputStream.readMessage(C0055a.f3438a, extensionRegistryLite);
                                this.f3434f = c0055a;
                                if (builder != null) {
                                    builder.mergeFrom(c0055a);
                                    this.f3434f = builder.buildPartial();
                                }
                                this.f3431c |= 4;
                            } else if (readTag == 32) {
                                this.f3431c |= 8;
                                this.f3435g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3431c |= 16;
                                this.f3436h = codedInputStream.readBytes();
                            } else if (readTag == 50) {
                                this.f3431c |= 32;
                                this.f3437i = codedInputStream.readBytes();
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
            this.j = (byte) -1;
            this.k = -1;
        }

        public static c a(C0054a c0054a) {
            return o().mergeFrom(c0054a);
        }

        public static C0054a a() {
            return f3430b;
        }

        public static c o() {
            return c.h();
        }

        private void r() {
            this.f3432d = 0L;
            this.f3433e = "";
            this.f3434f = C0055a.a();
            this.f3435g = 0L;
            this.f3436h = "";
            this.f3437i = ByteString.EMPTY;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0054a getDefaultInstanceForType() {
            return f3430b;
        }

        public boolean c() {
            return (this.f3431c & 1) == 1;
        }

        public long d() {
            return this.f3432d;
        }

        public boolean e() {
            return (this.f3431c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3433e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3433e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3431c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0054a> getParserForType() {
            return f3429a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.k;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.f3431c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3432d) : 0;
            if ((this.f3431c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3431c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.f3434f);
            }
            if ((this.f3431c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3435g);
            }
            if ((this.f3431c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3431c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, this.f3437i);
            }
            this.k = computeInt64Size;
            return computeInt64Size;
        }

        public C0055a h() {
            return this.f3434f;
        }

        public boolean i() {
            return (this.f3431c & 8) == 8;
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
            return this.f3435g;
        }

        public boolean k() {
            return (this.f3431c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3436h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3436h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3431c & 32) == 32;
        }

        public ByteString n() {
            return this.f3437i;
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
            if ((this.f3431c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3432d);
            }
            if ((this.f3431c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3431c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3434f);
            }
            if ((this.f3431c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3435g);
            }
            if ((this.f3431c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3431c & 32) == 32) {
                codedOutputStream.writeBytes(6, this.f3437i);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3453a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.b.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3454b;

        /* renamed from: c  reason: collision with root package name */
        public int f3455c;

        /* renamed from: d  reason: collision with root package name */
        public int f3456d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3457e;

        /* renamed from: f  reason: collision with root package name */
        public long f3458f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3459g;

        /* renamed from: h  reason: collision with root package name */
        public int f3460h;

        /* renamed from: com.baidu.android.pushservice.i.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0057a extends GeneratedMessageLite.Builder<c, C0057a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3461a;

            /* renamed from: b  reason: collision with root package name */
            public int f3462b;

            /* renamed from: c  reason: collision with root package name */
            public Object f3463c = "";

            /* renamed from: d  reason: collision with root package name */
            public long f3464d;

            public C0057a() {
                g();
            }

            private void g() {
            }

            public static C0057a h() {
                return new C0057a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0057a clear() {
                super.clear();
                this.f3462b = 0;
                int i2 = this.f3461a & (-2);
                this.f3461a = i2;
                this.f3463c = "";
                int i3 = i2 & (-3);
                this.f3461a = i3;
                this.f3464d = 0L;
                this.f3461a = i3 & (-5);
                return this;
            }

            public C0057a a(int i2) {
                this.f3461a |= 1;
                this.f3462b = i2;
                return this;
            }

            public C0057a a(long j) {
                this.f3461a |= 4;
                this.f3464d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0057a mergeFrom(c cVar) {
                if (cVar == c.a()) {
                    return this;
                }
                if (cVar.c()) {
                    a(cVar.d());
                }
                if (cVar.e()) {
                    this.f3461a |= 2;
                    this.f3463c = cVar.f3457e;
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
            public C0057a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f3453a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0057a clone() {
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
                int i2 = this.f3461a;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f3456d = this.f3462b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.f3457e = this.f3463c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.f3458f = this.f3464d;
                cVar.f3455c = i3;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3454b = cVar;
            cVar.m();
        }

        public c() {
            this.f3459g = (byte) -1;
            this.f3460h = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3459g = (byte) -1;
            this.f3460h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3455c |= 1;
                                    this.f3456d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3455c |= 2;
                                    this.f3457e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3455c |= 4;
                                    this.f3458f = codedInputStream.readInt64();
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
            this.f3459g = (byte) -1;
            this.f3460h = -1;
        }

        public static C0057a a(c cVar) {
            return j().mergeFrom(cVar);
        }

        public static c a() {
            return f3454b;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return f3453a.parseFrom(bArr);
        }

        public static C0057a j() {
            return C0057a.h();
        }

        private void m() {
            this.f3456d = 0;
            this.f3457e = "";
            this.f3458f = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3454b;
        }

        public boolean c() {
            return (this.f3455c & 1) == 1;
        }

        public int d() {
            return this.f3456d;
        }

        public boolean e() {
            return (this.f3455c & 2) == 2;
        }

        public String f() {
            Object obj = this.f3457e;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f3457e = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString g() {
            Object obj = this.f3457e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3457e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3453a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.f3460h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.f3455c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3456d) : 0;
            if ((this.f3455c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, g());
            }
            if ((this.f3455c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt64Size(3, this.f3458f);
            }
            this.f3460h = computeInt32Size;
            return computeInt32Size;
        }

        public boolean h() {
            return (this.f3455c & 4) == 4;
        }

        public long i() {
            return this.f3458f;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3459g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3459g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0057a newBuilderForType() {
            return j();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0057a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3455c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3456d);
            }
            if ((this.f3455c & 2) == 2) {
                codedOutputStream.writeBytes(2, g());
            }
            if ((this.f3455c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3458f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
