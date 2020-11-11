package com.baidu.android.pushservice.h.b.a;

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
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.baidu.android.pushservice.h.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0065a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0065a> f1139a = new AbstractParser<C0065a>() { // from class: com.baidu.android.pushservice.h.b.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0065a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0065a(codedInputStream, extensionRegistryLite);
            }
        };
        private static final C0065a b = new C0065a();
        private int c;
        private long d;
        private Object e;
        private C0066a f;
        private long g;
        private Object h;
        private ByteString i;
        private byte j;
        private int k;

        /* renamed from: com.baidu.android.pushservice.h.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C0066a extends GeneratedMessageLite implements b {

            /* renamed from: a  reason: collision with root package name */
            public static Parser<C0066a> f1140a = new AbstractParser<C0066a>() { // from class: com.baidu.android.pushservice.h.b.a.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: a */
                public C0066a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new C0066a(codedInputStream, extensionRegistryLite);
                }
            };
            private static final C0066a b = new C0066a();
            private int c;
            private Object d;
            private byte e;
            private int f;

            /* renamed from: com.baidu.android.pushservice.h.b.a.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public static final class C0067a extends GeneratedMessageLite.Builder<C0066a, C0067a> implements b {

                /* renamed from: a  reason: collision with root package name */
                private int f1141a;
                private Object b = "";

                private C0067a() {
                    g();
                }

                private void g() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static C0067a h() {
                    return new C0067a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: a */
                public C0067a clear() {
                    super.clear();
                    this.b = "";
                    this.f1141a &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public C0067a mergeFrom(C0066a c0066a) {
                    if (c0066a != C0066a.a() && c0066a.c()) {
                        this.f1141a |= 1;
                        this.b = c0066a.d;
                    }
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public C0067a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    C0066a c0066a;
                    Throwable th;
                    try {
                        try {
                            C0066a parsePartialFrom = C0066a.f1140a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (Throwable th2) {
                            th = th2;
                            c0066a = null;
                            if (c0066a != null) {
                                mergeFrom(c0066a);
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        C0066a c0066a2 = (C0066a) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            c0066a = c0066a2;
                            th = th3;
                            if (c0066a != null) {
                            }
                            throw th;
                        }
                    }
                }

                public C0067a a(String str) {
                    if (str == null) {
                        throw new NullPointerException();
                    }
                    this.f1141a |= 1;
                    this.b = str;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: b */
                public C0067a clone() {
                    return h().mergeFrom(buildPartial());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                /* renamed from: c */
                public C0066a getDefaultInstanceForType() {
                    return C0066a.a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: d */
                public C0066a build() {
                    C0066a buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: e */
                public C0066a buildPartial() {
                    C0066a c0066a = new C0066a(this);
                    int i = (this.f1141a & 1) != 1 ? 0 : 1;
                    c0066a.d = this.b;
                    c0066a.c = i;
                    return c0066a;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }
            }

            static {
                b.h();
            }

            private C0066a() {
                this.e = (byte) -1;
                this.f = -1;
            }

            private C0066a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.e = (byte) -1;
                this.f = -1;
                h();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z = true;
                                        break;
                                    case 10:
                                        this.c |= 1;
                                        this.d = codedInputStream.readBytes();
                                        break;
                                    default:
                                        if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                            z = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw e.setUnfinishedMessage(this);
                            }
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } finally {
                        makeExtensionsImmutable();
                    }
                }
            }

            private C0066a(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.e = (byte) -1;
                this.f = -1;
            }

            public static C0067a a(C0066a c0066a) {
                return e().mergeFrom(c0066a);
            }

            public static C0066a a() {
                return b;
            }

            public static C0067a e() {
                return C0067a.h();
            }

            private void h() {
                this.d = "";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: b */
            public C0066a getDefaultInstanceForType() {
                return b;
            }

            public boolean c() {
                return (this.c & 1) == 1;
            }

            public ByteString d() {
                Object obj = this.d;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.d = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: f */
            public C0067a newBuilderForType() {
                return e();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            /* renamed from: g */
            public C0067a toBuilder() {
                return a(this);
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<C0066a> getParserForType() {
                return f1140a;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.f;
                if (i == -1) {
                    i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                    this.f = i;
                }
                return i;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.e;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.e = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.c & 1) == 1) {
                    codedOutputStream.writeBytes(1, d());
                }
            }
        }

        /* renamed from: com.baidu.android.pushservice.h.b.a.a$a$b */
        /* loaded from: classes10.dex */
        public interface b extends MessageLiteOrBuilder {
        }

        /* renamed from: com.baidu.android.pushservice.h.b.a.a$a$c */
        /* loaded from: classes10.dex */
        public static final class c extends GeneratedMessageLite.Builder<C0065a, c> implements b {

            /* renamed from: a  reason: collision with root package name */
            private int f1142a;
            private long b;
            private long e;
            private Object c = "";
            private C0066a d = C0066a.a();
            private Object f = "";
            private ByteString g = ByteString.EMPTY;

            private c() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static c h() {
                return new c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public c clear() {
                super.clear();
                this.b = 0L;
                this.f1142a &= -2;
                this.c = "";
                this.f1142a &= -3;
                this.d = C0066a.a();
                this.f1142a &= -5;
                this.e = 0L;
                this.f1142a &= -9;
                this.f = "";
                this.f1142a &= -17;
                this.g = ByteString.EMPTY;
                this.f1142a &= -33;
                return this;
            }

            public c a(long j) {
                this.f1142a |= 1;
                this.b = j;
                return this;
            }

            public c a(C0066a c0066a) {
                if (c0066a == null) {
                    throw new NullPointerException();
                }
                this.d = c0066a;
                this.f1142a |= 4;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public c mergeFrom(C0065a c0065a) {
                if (c0065a != C0065a.a()) {
                    if (c0065a.c()) {
                        a(c0065a.d());
                    }
                    if (c0065a.e()) {
                        this.f1142a |= 2;
                        this.c = c0065a.e;
                    }
                    if (c0065a.g()) {
                        b(c0065a.h());
                    }
                    if (c0065a.i()) {
                        b(c0065a.j());
                    }
                    if (c0065a.k()) {
                        this.f1142a |= 16;
                        this.f = c0065a.h;
                    }
                    if (c0065a.m()) {
                        a(c0065a.n());
                    }
                }
                return this;
            }

            public c a(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f1142a |= 32;
                this.g = byteString;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                C0065a c0065a;
                Throwable th;
                try {
                    try {
                        C0065a parsePartialFrom = C0065a.f1139a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        c0065a = null;
                        if (c0065a != null) {
                            mergeFrom(c0065a);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    C0065a c0065a2 = (C0065a) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        c0065a = c0065a2;
                        th = th3;
                        if (c0065a != null) {
                        }
                        throw th;
                    }
                }
            }

            public c a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1142a |= 2;
                this.c = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public c clone() {
                return h().mergeFrom(buildPartial());
            }

            public c b(long j) {
                this.f1142a |= 8;
                this.e = j;
                return this;
            }

            public c b(C0066a c0066a) {
                if ((this.f1142a & 4) != 4 || this.d == C0066a.a()) {
                    this.d = c0066a;
                } else {
                    this.d = C0066a.a(this.d).mergeFrom(c0066a).buildPartial();
                }
                this.f1142a |= 4;
                return this;
            }

            public c b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1142a |= 16;
                this.f = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C0065a getDefaultInstanceForType() {
                return C0065a.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C0065a build() {
                C0065a buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C0065a buildPartial() {
                C0065a c0065a = new C0065a(this);
                int i = this.f1142a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c0065a.d = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c0065a.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                c0065a.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                c0065a.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                c0065a.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                c0065a.i = this.g;
                c0065a.c = i2;
                return c0065a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            b.r();
        }

        private C0065a() {
            this.j = (byte) -1;
            this.k = -1;
        }

        private C0065a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            this.j = (byte) -1;
            this.k = -1;
            r();
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                continue;
                                z2 = z;
                            case 8:
                                this.c |= 1;
                                this.d = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 18:
                                this.c |= 2;
                                this.e = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 26:
                                C0066a.C0067a builder = (this.c & 4) == 4 ? this.f.toBuilder() : null;
                                this.f = (C0066a) codedInputStream.readMessage(C0066a.f1140a, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.f);
                                    this.f = builder.buildPartial();
                                }
                                this.c |= 4;
                                z = z2;
                                continue;
                                z2 = z;
                            case 32:
                                this.c |= 8;
                                this.g = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 42:
                                this.c |= 16;
                                this.h = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 50:
                                this.c |= 32;
                                this.i = codedInputStream.readBytes();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    continue;
                                    z2 = z;
                                }
                                break;
                        }
                        z = z2;
                        z2 = z;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        private C0065a(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.j = (byte) -1;
            this.k = -1;
        }

        public static c a(C0065a c0065a) {
            return o().mergeFrom(c0065a);
        }

        public static C0065a a() {
            return b;
        }

        public static c o() {
            return c.h();
        }

        private void r() {
            this.d = 0L;
            this.e = "";
            this.f = C0066a.a();
            this.g = 0L;
            this.h = "";
            this.i = ByteString.EMPTY;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0065a getDefaultInstanceForType() {
            return b;
        }

        public boolean c() {
            return (this.c & 1) == 1;
        }

        public long d() {
            return this.d;
        }

        public boolean e() {
            return (this.c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0065a> getParserForType() {
            return f1139a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.k;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.d) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, this.i);
                }
                this.k = i;
            }
            return i;
        }

        public C0066a h() {
            return this.f;
        }

        public boolean i() {
            return (this.c & 8) == 8;
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
            return this.g;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.c & 32) == 32;
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

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeBytes(6, this.i);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes10.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f1143a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.h.b.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };
        private static final c b = new c();
        private int c;
        private int d;
        private Object e;
        private long f;
        private byte g;
        private int h;

        /* renamed from: com.baidu.android.pushservice.h.b.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C0068a extends GeneratedMessageLite.Builder<c, C0068a> implements d {

            /* renamed from: a  reason: collision with root package name */
            private int f1144a;
            private int b;
            private Object c = "";
            private long d;

            private C0068a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0068a h() {
                return new C0068a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0068a clear() {
                super.clear();
                this.b = 0;
                this.f1144a &= -2;
                this.c = "";
                this.f1144a &= -3;
                this.d = 0L;
                this.f1144a &= -5;
                return this;
            }

            public C0068a a(int i) {
                this.f1144a |= 1;
                this.b = i;
                return this;
            }

            public C0068a a(long j) {
                this.f1144a |= 4;
                this.d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0068a mergeFrom(c cVar) {
                if (cVar != c.a()) {
                    if (cVar.c()) {
                        a(cVar.d());
                    }
                    if (cVar.e()) {
                        this.f1144a |= 2;
                        this.c = cVar.e;
                    }
                    if (cVar.h()) {
                        a(cVar.i());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0068a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                c cVar;
                Throwable th;
                try {
                    try {
                        c parsePartialFrom = c.f1143a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        cVar = null;
                        if (cVar != null) {
                            mergeFrom(cVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    c cVar2 = (c) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        cVar = cVar2;
                        th = th3;
                        if (cVar != null) {
                        }
                        throw th;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0068a clone() {
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
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public c buildPartial() {
                c cVar = new c(this);
                int i = this.f1144a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.d = this.b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.f = this.d;
                cVar.c = i2;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            b.m();
        }

        private c() {
            this.g = (byte) -1;
            this.h = -1;
        }

        private c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.g = (byte) -1;
            this.h = -1;
            m();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.c |= 1;
                                    this.d = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.c |= 4;
                                    this.f = codedInputStream.readInt64();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        private c(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.g = (byte) -1;
            this.h = -1;
        }

        public static C0068a a(c cVar) {
            return j().mergeFrom(cVar);
        }

        public static c a() {
            return b;
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return f1143a.parseFrom(bArr);
        }

        public static C0068a j() {
            return C0068a.h();
        }

        private void m() {
            this.d = 0;
            this.e = "";
            this.f = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return b;
        }

        public boolean c() {
            return (this.c & 1) == 1;
        }

        public int d() {
            return this.d;
        }

        public boolean e() {
            return (this.c & 2) == 2;
        }

        public String f() {
            Object obj = this.e;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.e = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString g() {
            Object obj = this.e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f1143a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.h;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.d) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, g());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.f);
                }
                this.h = i;
            }
            return i;
        }

        public boolean h() {
            return (this.c & 4) == 4;
        }

        public long i() {
            return this.f;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0068a newBuilderForType() {
            return j();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0068a toBuilder() {
            return a(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, g());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface d extends MessageLiteOrBuilder {
    }
}
