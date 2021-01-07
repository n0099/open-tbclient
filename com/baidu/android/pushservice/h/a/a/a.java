package com.baidu.android.pushservice.h.a.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.baidu.android.pushservice.h.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0042a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0042a> f1315a = new AbstractParser<C0042a>() { // from class: com.baidu.android.pushservice.h.a.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0042a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0042a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final C0042a f1316b = new C0042a();
        private int c;
        private Object d;
        private Object e;
        private long f;
        private Object g;
        private long h;
        private byte i;
        private int j;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0043a extends GeneratedMessageLite.Builder<C0042a, C0043a> implements b {

            /* renamed from: a  reason: collision with root package name */
            private int f1317a;
            private long d;
            private long f;

            /* renamed from: b  reason: collision with root package name */
            private Object f1318b = "";
            private Object c = "";
            private Object e = "";

            private C0043a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0043a h() {
                return new C0043a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0043a clear() {
                super.clear();
                this.f1318b = "";
                this.f1317a &= -2;
                this.c = "";
                this.f1317a &= -3;
                this.d = 0L;
                this.f1317a &= -5;
                this.e = "";
                this.f1317a &= -9;
                this.f = 0L;
                this.f1317a &= -17;
                return this;
            }

            public C0043a a(long j) {
                this.f1317a |= 4;
                this.d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0043a mergeFrom(C0042a c0042a) {
                if (c0042a != C0042a.a()) {
                    if (c0042a.c()) {
                        this.f1317a |= 1;
                        this.f1318b = c0042a.d;
                    }
                    if (c0042a.e()) {
                        this.f1317a |= 2;
                        this.c = c0042a.e;
                    }
                    if (c0042a.g()) {
                        a(c0042a.h());
                    }
                    if (c0042a.i()) {
                        this.f1317a |= 8;
                        this.e = c0042a.g;
                    }
                    if (c0042a.k()) {
                        b(c0042a.l());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0043a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                C0042a c0042a = null;
                try {
                    try {
                        C0042a parsePartialFrom = C0042a.f1315a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (c0042a != null) {
                            mergeFrom(c0042a);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    C0042a c0042a2 = (C0042a) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        c0042a = c0042a2;
                        if (c0042a != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0043a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1317a |= 1;
                this.f1318b = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0043a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0043a b(long j) {
                this.f1317a |= 16;
                this.f = j;
                return this;
            }

            public C0043a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1317a |= 2;
                return this;
            }

            public C0043a c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1317a |= 8;
                this.e = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C0042a getDefaultInstanceForType() {
                return C0042a.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C0042a build() {
                C0042a buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C0042a buildPartial() {
                C0042a c0042a = new C0042a(this);
                int i = this.f1317a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c0042a.d = this.f1318b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c0042a.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                c0042a.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                c0042a.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                c0042a.h = this.f;
                c0042a.c = i2;
                return c0042a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1316b.p();
        }

        private C0042a() {
            this.i = (byte) -1;
            this.j = -1;
        }

        private C0042a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.i = (byte) -1;
            this.j = -1;
            p();
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
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.c |= 4;
                                    this.f = codedInputStream.readInt64();
                                    break;
                                case 34:
                                    this.c |= 8;
                                    this.g = codedInputStream.readBytes();
                                    break;
                                case 40:
                                    this.c |= 16;
                                    this.h = codedInputStream.readInt64();
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

        private C0042a(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.i = (byte) -1;
            this.j = -1;
        }

        public static C0043a a(C0042a c0042a) {
            return m().mergeFrom(c0042a);
        }

        public static C0042a a() {
            return f1316b;
        }

        public static C0043a m() {
            return C0043a.h();
        }

        private void p() {
            this.d = "";
            this.e = "";
            this.f = 0L;
            this.g = "";
            this.h = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0042a getDefaultInstanceForType() {
            return f1316b;
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
        public Parser<C0042a> getParserForType() {
            return f1315a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.j;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.h);
                }
                this.j = i;
            }
            return i;
        }

        public long h() {
            return this.f;
        }

        public boolean i() {
            return (this.c & 8) == 8;
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

        public ByteString j() {
            Object obj = this.g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public long l() {
            return this.h;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C0043a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C0043a newBuilderForType() {
            return m();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class aa extends GeneratedMessageLite implements ab {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f1319a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.h.a.a.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new aa(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final aa f1320b = new aa();
        private int c;
        private Object d;
        private Object e;
        private long f;
        private long g;
        private long h;
        private Object i;
        private long j;
        private byte k;
        private int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0044a extends GeneratedMessageLite.Builder<aa, C0044a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            private int f1321a;
            private long d;
            private long e;
            private long f;
            private long h;

            /* renamed from: b  reason: collision with root package name */
            private Object f1322b = "";
            private Object c = "";
            private Object g = "";

            private C0044a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0044a h() {
                return new C0044a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0044a clear() {
                super.clear();
                this.f1322b = "";
                this.f1321a &= -2;
                this.c = "";
                this.f1321a &= -3;
                this.d = 0L;
                this.f1321a &= -5;
                this.e = 0L;
                this.f1321a &= -9;
                this.f = 0L;
                this.f1321a &= -17;
                this.g = "";
                this.f1321a &= -33;
                this.h = 0L;
                this.f1321a &= -65;
                return this;
            }

            public C0044a a(long j) {
                this.f1321a |= 4;
                this.d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0044a mergeFrom(aa aaVar) {
                if (aaVar != aa.a()) {
                    if (aaVar.c()) {
                        this.f1321a |= 1;
                        this.f1322b = aaVar.d;
                    }
                    if (aaVar.e()) {
                        this.f1321a |= 2;
                        this.c = aaVar.e;
                    }
                    if (aaVar.g()) {
                        a(aaVar.h());
                    }
                    if (aaVar.i()) {
                        b(aaVar.j());
                    }
                    if (aaVar.k()) {
                        c(aaVar.l());
                    }
                    if (aaVar.m()) {
                        this.f1321a |= 32;
                        this.g = aaVar.i;
                    }
                    if (aaVar.o()) {
                        d(aaVar.p());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0044a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                aa aaVar = null;
                try {
                    try {
                        aa parsePartialFrom = aa.f1319a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (aaVar != null) {
                            mergeFrom(aaVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    aa aaVar2 = (aa) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        aaVar = aaVar2;
                        if (aaVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0044a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1321a |= 1;
                this.f1322b = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0044a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0044a b(long j) {
                this.f1321a |= 8;
                this.e = j;
                return this;
            }

            public C0044a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1321a |= 2;
                this.c = str;
                return this;
            }

            public C0044a c(long j) {
                this.f1321a |= 16;
                this.f = j;
                return this;
            }

            public C0044a c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1321a |= 32;
                this.g = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public aa getDefaultInstanceForType() {
                return aa.a();
            }

            public C0044a d(long j) {
                this.f1321a |= 64;
                this.h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public aa build() {
                aa buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public aa buildPartial() {
                aa aaVar = new aa(this);
                int i = this.f1321a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                aaVar.d = this.f1322b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                aaVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                aaVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                aaVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                aaVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                aaVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                aaVar.j = this.h;
                aaVar.c = i2;
                return aaVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1320b.t();
        }

        private aa() {
            this.k = (byte) -1;
            this.l = -1;
        }

        private aa(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
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
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.c |= 4;
                                    this.f = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.c |= 8;
                                    this.g = codedInputStream.readInt64();
                                    break;
                                case 40:
                                    this.c |= 16;
                                    this.h = codedInputStream.readInt64();
                                    break;
                                case 50:
                                    this.c |= 32;
                                    this.i = codedInputStream.readBytes();
                                    break;
                                case 56:
                                    this.c |= 64;
                                    this.j = codedInputStream.readInt64();
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

        private aa(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0044a a(aa aaVar) {
            return q().mergeFrom(aaVar);
        }

        public static aa a() {
            return f1320b;
        }

        public static C0044a q() {
            return C0044a.h();
        }

        private void t() {
            this.d = "";
            this.e = "";
            this.f = 0L;
            this.g = 0L;
            this.h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            return f1320b;
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
        public Parser<aa> getParserForType() {
            return f1319a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.j);
                }
                this.l = i;
            }
            return i;
        }

        public long h() {
            return this.f;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public long j() {
            return this.g;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public long l() {
            return this.h;
        }

        public boolean m() {
            return (this.c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0044a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0044a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.h);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class ac extends GeneratedMessageLite implements ad {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ac> f1323a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.h.a.a.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ac(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final ac f1324b = new ac();
        private int c;
        private x d;
        private Object e;
        private Object f;
        private Object g;
        private int h;
        private int i;
        private int j;
        private byte k;
        private int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0045a extends GeneratedMessageLite.Builder<ac, C0045a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            private int f1325a;

            /* renamed from: b  reason: collision with root package name */
            private x f1326b = x.OS_TYPE_UNKNWON;
            private Object c = "";
            private Object d = "";
            private Object e = "";
            private int f;
            private int g;
            private int h;

            private C0045a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0045a h() {
                return new C0045a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0045a clear() {
                super.clear();
                this.f1326b = x.OS_TYPE_UNKNWON;
                this.f1325a &= -2;
                this.c = "";
                this.f1325a &= -3;
                this.d = "";
                this.f1325a &= -5;
                this.e = "";
                this.f1325a &= -9;
                this.f = 0;
                this.f1325a &= -17;
                this.g = 0;
                this.f1325a &= -33;
                this.h = 0;
                this.f1325a &= -65;
                return this;
            }

            public C0045a a(int i) {
                this.f1325a |= 16;
                this.f = i;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0045a mergeFrom(ac acVar) {
                if (acVar != ac.a()) {
                    if (acVar.c()) {
                        a(acVar.d());
                    }
                    if (acVar.e()) {
                        this.f1325a |= 2;
                        this.c = acVar.e;
                    }
                    if (acVar.g()) {
                        this.f1325a |= 4;
                        this.d = acVar.f;
                    }
                    if (acVar.i()) {
                        this.f1325a |= 8;
                        this.e = acVar.g;
                    }
                    if (acVar.k()) {
                        a(acVar.l());
                    }
                    if (acVar.m()) {
                        b(acVar.n());
                    }
                    if (acVar.o()) {
                        c(acVar.p());
                    }
                }
                return this;
            }

            public C0045a a(x xVar) {
                if (xVar == null) {
                    throw new NullPointerException();
                }
                this.f1325a |= 1;
                this.f1326b = xVar;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0045a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ac acVar = null;
                try {
                    try {
                        ac parsePartialFrom = ac.f1323a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (acVar != null) {
                            mergeFrom(acVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    ac acVar2 = (ac) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        acVar = acVar2;
                        if (acVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0045a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1325a |= 2;
                this.c = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0045a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0045a b(int i) {
                this.f1325a |= 32;
                this.g = i;
                return this;
            }

            public C0045a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1325a |= 4;
                this.d = str;
                return this;
            }

            public C0045a c(int i) {
                this.f1325a |= 64;
                this.h = i;
                return this;
            }

            public C0045a c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1325a |= 8;
                this.e = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ac getDefaultInstanceForType() {
                return ac.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public ac build() {
                ac buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ac buildPartial() {
                ac acVar = new ac(this);
                int i = this.f1325a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                acVar.d = this.f1326b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                acVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                acVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                acVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                acVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                acVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                acVar.j = this.h;
                acVar.c = i2;
                return acVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1324b.t();
        }

        private ac() {
            this.k = (byte) -1;
            this.l = -1;
        }

        private ac(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                x a2 = x.a(codedInputStream.readEnum());
                                if (a2 == null) {
                                    break;
                                } else {
                                    this.c |= 1;
                                    this.d = a2;
                                    break;
                                }
                            case 18:
                                this.c |= 2;
                                this.e = codedInputStream.readBytes();
                                break;
                            case 26:
                                this.c |= 4;
                                this.f = codedInputStream.readBytes();
                                break;
                            case 34:
                                this.c |= 8;
                                this.g = codedInputStream.readBytes();
                                break;
                            case 40:
                                this.c |= 16;
                                this.h = codedInputStream.readInt32();
                                break;
                            case 48:
                                this.c |= 32;
                                this.i = codedInputStream.readInt32();
                                break;
                            case 56:
                                this.c |= 64;
                                this.j = codedInputStream.readInt32();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        private ac(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0045a a(ac acVar) {
            return q().mergeFrom(acVar);
        }

        public static ac a() {
            return f1324b;
        }

        public static C0045a q() {
            return C0045a.h();
        }

        private void t() {
            this.d = x.OS_TYPE_UNKNWON;
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = 0;
            this.i = 0;
            this.j = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            return f1324b;
        }

        public boolean c() {
            return (this.c & 1) == 1;
        }

        public x d() {
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
        public Parser<ac> getParserForType() {
            return f1323a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.d.getNumber()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(6, this.i);
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeInt32Size(7, this.j);
                }
                this.l = i;
            }
            return i;
        }

        public ByteString h() {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public int l() {
            return this.h;
        }

        public boolean m() {
            return (this.c & 32) == 32;
        }

        public int n() {
            return this.i;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public int p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0045a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0045a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.d.getNumber());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt32(5, this.h);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.i);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt32(7, this.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class ae extends GeneratedMessageLite implements af {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ae> f1327a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.h.a.a.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ae(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final ae f1328b = new ae();
        private int c;
        private Object d;
        private Object e;
        private long f;
        private long g;
        private long h;
        private Object i;
        private long j;
        private byte k;
        private int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0046a extends GeneratedMessageLite.Builder<ae, C0046a> implements af {

            /* renamed from: a  reason: collision with root package name */
            private int f1329a;
            private long d;
            private long e;
            private long f;
            private long h;

            /* renamed from: b  reason: collision with root package name */
            private Object f1330b = "";
            private Object c = "";
            private Object g = "";

            private C0046a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0046a h() {
                return new C0046a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0046a clear() {
                super.clear();
                this.f1330b = "";
                this.f1329a &= -2;
                this.c = "";
                this.f1329a &= -3;
                this.d = 0L;
                this.f1329a &= -5;
                this.e = 0L;
                this.f1329a &= -9;
                this.f = 0L;
                this.f1329a &= -17;
                this.g = "";
                this.f1329a &= -33;
                this.h = 0L;
                this.f1329a &= -65;
                return this;
            }

            public C0046a a(long j) {
                this.f1329a |= 4;
                this.d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0046a mergeFrom(ae aeVar) {
                if (aeVar != ae.a()) {
                    if (aeVar.c()) {
                        this.f1329a |= 1;
                        this.f1330b = aeVar.d;
                    }
                    if (aeVar.e()) {
                        this.f1329a |= 2;
                        this.c = aeVar.e;
                    }
                    if (aeVar.g()) {
                        a(aeVar.h());
                    }
                    if (aeVar.i()) {
                        b(aeVar.j());
                    }
                    if (aeVar.k()) {
                        c(aeVar.l());
                    }
                    if (aeVar.m()) {
                        this.f1329a |= 32;
                        this.g = aeVar.i;
                    }
                    if (aeVar.o()) {
                        d(aeVar.p());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0046a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ae aeVar = null;
                try {
                    try {
                        ae parsePartialFrom = ae.f1327a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (aeVar != null) {
                            mergeFrom(aeVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    ae aeVar2 = (ae) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        aeVar = aeVar2;
                        if (aeVar != null) {
                        }
                        throw th;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0046a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0046a b(long j) {
                this.f1329a |= 8;
                this.e = j;
                return this;
            }

            public C0046a c(long j) {
                this.f1329a |= 16;
                this.f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                return ae.a();
            }

            public C0046a d(long j) {
                this.f1329a |= 64;
                this.h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public ae build() {
                ae buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ae buildPartial() {
                ae aeVar = new ae(this);
                int i = this.f1329a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                aeVar.d = this.f1330b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                aeVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                aeVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                aeVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                aeVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                aeVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                aeVar.j = this.h;
                aeVar.c = i2;
                return aeVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1328b.t();
        }

        private ae() {
            this.k = (byte) -1;
            this.l = -1;
        }

        private ae(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
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
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.c |= 4;
                                    this.f = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.c |= 8;
                                    this.g = codedInputStream.readInt64();
                                    break;
                                case 40:
                                    this.c |= 16;
                                    this.h = codedInputStream.readInt64();
                                    break;
                                case 50:
                                    this.c |= 32;
                                    this.i = codedInputStream.readBytes();
                                    break;
                                case 56:
                                    this.c |= 64;
                                    this.j = codedInputStream.readInt64();
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

        private ae(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0046a a(ae aeVar) {
            return q().mergeFrom(aeVar);
        }

        public static ae a() {
            return f1328b;
        }

        public static C0046a q() {
            return C0046a.h();
        }

        private void t() {
            this.d = "";
            this.e = "";
            this.f = 0L;
            this.g = 0L;
            this.h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            return f1328b;
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
        public Parser<ae> getParserForType() {
            return f1327a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.j);
                }
                this.l = i;
            }
            return i;
        }

        public long h() {
            return this.f;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public long j() {
            return this.g;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public long l() {
            return this.h;
        }

        public boolean m() {
            return (this.c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0046a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0046a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.h);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f1331a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.h.a.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final c f1332b = new c();
        private int c;
        private e d;
        private ae e;
        private l f;
        private n g;
        private j h;
        private aa i;
        private C0042a j;
        private t k;
        private byte l;
        private int m;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0047a extends GeneratedMessageLite.Builder<c, C0047a> implements d {

            /* renamed from: a  reason: collision with root package name */
            private int f1333a;

            /* renamed from: b  reason: collision with root package name */
            private e f1334b = e.UI;
            private ae c = ae.a();
            private l d = l.a();
            private n e = n.a();
            private j f = j.a();
            private aa g = aa.a();
            private C0042a h = C0042a.a();
            private t i = t.a();

            private C0047a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0047a h() {
                return new C0047a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0047a clear() {
                super.clear();
                this.f1334b = e.UI;
                this.f1333a &= -2;
                this.c = ae.a();
                this.f1333a &= -3;
                this.d = l.a();
                this.f1333a &= -5;
                this.e = n.a();
                this.f1333a &= -9;
                this.f = j.a();
                this.f1333a &= -17;
                this.g = aa.a();
                this.f1333a &= -33;
                this.h = C0042a.a();
                this.f1333a &= -65;
                this.i = t.a();
                this.f1333a &= -129;
                return this;
            }

            public C0047a a(C0042a c0042a) {
                if (c0042a == null) {
                    throw new NullPointerException();
                }
                this.h = c0042a;
                this.f1333a |= 64;
                return this;
            }

            public C0047a a(aa aaVar) {
                if (aaVar == null) {
                    throw new NullPointerException();
                }
                this.g = aaVar;
                this.f1333a |= 32;
                return this;
            }

            public C0047a a(ae aeVar) {
                if ((this.f1333a & 2) != 2 || this.c == ae.a()) {
                    this.c = aeVar;
                } else {
                    this.c = ae.a(this.c).mergeFrom(aeVar).buildPartial();
                }
                this.f1333a |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0047a mergeFrom(c cVar) {
                if (cVar != c.a()) {
                    if (cVar.c()) {
                        a(cVar.d());
                    }
                    if (cVar.e()) {
                        a(cVar.f());
                    }
                    if (cVar.g()) {
                        b(cVar.h());
                    }
                    if (cVar.i()) {
                        b(cVar.j());
                    }
                    if (cVar.k()) {
                        b(cVar.l());
                    }
                    if (cVar.m()) {
                        b(cVar.n());
                    }
                    if (cVar.o()) {
                        b(cVar.p());
                    }
                    if (cVar.q()) {
                        a(cVar.r());
                    }
                }
                return this;
            }

            public C0047a a(e eVar) {
                if (eVar == null) {
                    throw new NullPointerException();
                }
                this.f1333a |= 1;
                this.f1334b = eVar;
                return this;
            }

            public C0047a a(j jVar) {
                if (jVar == null) {
                    throw new NullPointerException();
                }
                this.f = jVar;
                this.f1333a |= 16;
                return this;
            }

            public C0047a a(l lVar) {
                if (lVar == null) {
                    throw new NullPointerException();
                }
                this.d = lVar;
                this.f1333a |= 4;
                return this;
            }

            public C0047a a(n nVar) {
                if (nVar == null) {
                    throw new NullPointerException();
                }
                this.e = nVar;
                this.f1333a |= 8;
                return this;
            }

            public C0047a a(t tVar) {
                if ((this.f1333a & 128) != 128 || this.i == t.a()) {
                    this.i = tVar;
                } else {
                    this.i = t.a(this.i).mergeFrom(tVar).buildPartial();
                }
                this.f1333a |= 128;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0047a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f1331a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (cVar != null) {
                            mergeFrom(cVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    c cVar2 = (c) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        cVar = cVar2;
                        if (cVar != null) {
                        }
                        throw th;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0047a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0047a b(C0042a c0042a) {
                if ((this.f1333a & 64) != 64 || this.h == C0042a.a()) {
                    this.h = c0042a;
                } else {
                    this.h = C0042a.a(this.h).mergeFrom(c0042a).buildPartial();
                }
                this.f1333a |= 64;
                return this;
            }

            public C0047a b(aa aaVar) {
                if ((this.f1333a & 32) != 32 || this.g == aa.a()) {
                    this.g = aaVar;
                } else {
                    this.g = aa.a(this.g).mergeFrom(aaVar).buildPartial();
                }
                this.f1333a |= 32;
                return this;
            }

            public C0047a b(j jVar) {
                if ((this.f1333a & 16) != 16 || this.f == j.a()) {
                    this.f = jVar;
                } else {
                    this.f = j.a(this.f).mergeFrom(jVar).buildPartial();
                }
                this.f1333a |= 16;
                return this;
            }

            public C0047a b(l lVar) {
                if ((this.f1333a & 4) != 4 || this.d == l.a()) {
                    this.d = lVar;
                } else {
                    this.d = l.a(this.d).mergeFrom(lVar).buildPartial();
                }
                this.f1333a |= 4;
                return this;
            }

            public C0047a b(n nVar) {
                if ((this.f1333a & 8) != 8 || this.e == n.a()) {
                    this.e = nVar;
                } else {
                    this.e = n.a(this.e).mergeFrom(nVar).buildPartial();
                }
                this.f1333a |= 8;
                return this;
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
                int i = this.f1333a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.d = this.f1334b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                cVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                cVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                cVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                cVar.j = this.h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                cVar.k = this.i;
                cVar.c = i2;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1332b.v();
        }

        private c() {
            this.l = (byte) -1;
            this.m = -1;
        }

        private c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            this.l = (byte) -1;
            this.m = -1;
            v();
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
                                e a2 = e.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.c |= 1;
                                    this.d = a2;
                                    z = z2;
                                    continue;
                                    z2 = z;
                                }
                                break;
                            case 18:
                                ae.C0046a builder = (this.c & 2) == 2 ? this.e.toBuilder() : null;
                                this.e = (ae) codedInputStream.readMessage(ae.f1327a, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.e);
                                    this.e = builder.buildPartial();
                                }
                                this.c |= 2;
                                z = z2;
                                continue;
                                z2 = z;
                            case 26:
                                l.C0051a builder2 = (this.c & 4) == 4 ? this.f.toBuilder() : null;
                                this.f = (l) codedInputStream.readMessage(l.f1349a, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.f);
                                    this.f = builder2.buildPartial();
                                }
                                this.c |= 4;
                                z = z2;
                                continue;
                                z2 = z;
                            case 34:
                                n.C0052a builder3 = (this.c & 8) == 8 ? this.g.toBuilder() : null;
                                this.g = (n) codedInputStream.readMessage(n.f1353a, extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.g);
                                    this.g = builder3.buildPartial();
                                }
                                this.c |= 8;
                                z = z2;
                                continue;
                                z2 = z;
                            case 42:
                                j.C0050a builder4 = (this.c & 16) == 16 ? this.h.toBuilder() : null;
                                this.h = (j) codedInputStream.readMessage(j.f1345a, extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom(this.h);
                                    this.h = builder4.buildPartial();
                                }
                                this.c |= 16;
                                z = z2;
                                continue;
                                z2 = z;
                            case 50:
                                aa.C0044a builder5 = (this.c & 32) == 32 ? this.i.toBuilder() : null;
                                this.i = (aa) codedInputStream.readMessage(aa.f1319a, extensionRegistryLite);
                                if (builder5 != null) {
                                    builder5.mergeFrom(this.i);
                                    this.i = builder5.buildPartial();
                                }
                                this.c |= 32;
                                z = z2;
                                continue;
                                z2 = z;
                            case 58:
                                C0042a.C0043a builder6 = (this.c & 64) == 64 ? this.j.toBuilder() : null;
                                this.j = (C0042a) codedInputStream.readMessage(C0042a.f1315a, extensionRegistryLite);
                                if (builder6 != null) {
                                    builder6.mergeFrom(this.j);
                                    this.j = builder6.buildPartial();
                                }
                                this.c |= 64;
                                z = z2;
                                continue;
                                z2 = z;
                            case 66:
                                t.C0055a builder7 = (this.c & 128) == 128 ? this.k.toBuilder() : null;
                                this.k = (t) codedInputStream.readMessage(t.f1365a, extensionRegistryLite);
                                if (builder7 != null) {
                                    builder7.mergeFrom(this.k);
                                    this.k = builder7.buildPartial();
                                }
                                this.c |= 128;
                                z = z2;
                                continue;
                                z2 = z;
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

        private c(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.l = (byte) -1;
            this.m = -1;
        }

        public static C0047a a(c cVar) {
            return s().mergeFrom(cVar);
        }

        public static c a() {
            return f1332b;
        }

        public static C0047a s() {
            return C0047a.h();
        }

        private void v() {
            this.d = e.UI;
            this.e = ae.a();
            this.f = l.a();
            this.g = n.a();
            this.h = j.a();
            this.i = aa.a();
            this.j = C0042a.a();
            this.k = t.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f1332b;
        }

        public boolean c() {
            return (this.c & 1) == 1;
        }

        public e d() {
            return this.d;
        }

        public boolean e() {
            return (this.c & 2) == 2;
        }

        public ae f() {
            return this.e;
        }

        public boolean g() {
            return (this.c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f1331a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.m;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.d.getNumber()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(2, this.e);
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeMessageSize(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeMessageSize(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeMessageSize(6, this.i);
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeMessageSize(7, this.j);
                }
                if ((this.c & 128) == 128) {
                    i += CodedOutputStream.computeMessageSize(8, this.k);
                }
                this.m = i;
            }
            return i;
        }

        public l h() {
            return this.f;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.l;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.l = (byte) 1;
            return true;
        }

        public n j() {
            return this.g;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public j l() {
            return this.h;
        }

        public boolean m() {
            return (this.c & 32) == 32;
        }

        public aa n() {
            return this.i;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public C0042a p() {
            return this.j;
        }

        public boolean q() {
            return (this.c & 128) == 128;
        }

        public t r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C0047a newBuilderForType() {
            return s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0047a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.d.getNumber());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeMessage(4, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeMessage(5, this.h);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeMessage(6, this.i);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeMessage(7, this.j);
            }
            if ((this.c & 128) == 128) {
                codedOutputStream.writeMessage(8, this.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public enum e implements Internal.EnumLite {
        UI(101),
        CRASH(201),
        DB(301),
        CONNECTION(401),
        REQUEST(501),
        ACK(601),
        MSG(701);
        
        private final int h;

        e(int i2) {
            this.h = i2;
        }

        public static e a(int i2) {
            switch (i2) {
                case 101:
                    return UI;
                case 201:
                    return CRASH;
                case 301:
                    return DB;
                case 401:
                    return CONNECTION;
                case 501:
                    return REQUEST;
                case 601:
                    return ACK;
                case 701:
                    return MSG;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.h;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends GeneratedMessageLite implements g {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f1337a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.h.a.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new f(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final f f1338b = new f();
        private int c;
        private Object d;
        private Object e;
        private Object f;
        private byte g;
        private int h;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0048a extends GeneratedMessageLite.Builder<f, C0048a> implements g {

            /* renamed from: a  reason: collision with root package name */
            private int f1339a;

            /* renamed from: b  reason: collision with root package name */
            private Object f1340b = "";
            private Object c = "";
            private Object d = "";

            private C0048a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0048a h() {
                return new C0048a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0048a clear() {
                super.clear();
                this.f1340b = "";
                this.f1339a &= -2;
                this.c = "";
                this.f1339a &= -3;
                this.d = "";
                this.f1339a &= -5;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0048a mergeFrom(f fVar) {
                if (fVar != f.a()) {
                    if (fVar.c()) {
                        this.f1339a |= 1;
                        this.f1340b = fVar.d;
                    }
                    if (fVar.e()) {
                        this.f1339a |= 2;
                        this.c = fVar.e;
                    }
                    if (fVar.g()) {
                        this.f1339a |= 4;
                        this.d = fVar.f;
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0048a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                f fVar = null;
                try {
                    try {
                        f parsePartialFrom = f.f1337a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (fVar != null) {
                            mergeFrom(fVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    f fVar2 = (f) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        fVar = fVar2;
                        if (fVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0048a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1339a |= 1;
                this.f1340b = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0048a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0048a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1339a |= 2;
                this.c = str;
                return this;
            }

            public C0048a c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1339a |= 4;
                this.d = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public f getDefaultInstanceForType() {
                return f.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public f build() {
                f buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public f buildPartial() {
                f fVar = new f(this);
                int i = this.f1339a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                fVar.d = this.f1340b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                fVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                fVar.f = this.d;
                fVar.c = i2;
                return fVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1338b.l();
        }

        private f() {
            this.g = (byte) -1;
            this.h = -1;
        }

        private f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.g = (byte) -1;
            this.h = -1;
            l();
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
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.c |= 4;
                                    this.f = codedInputStream.readBytes();
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

        private f(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.g = (byte) -1;
            this.h = -1;
        }

        public static C0048a a(f fVar) {
            return i().mergeFrom(fVar);
        }

        public static f a() {
            return f1338b;
        }

        public static C0048a i() {
            return C0048a.h();
        }

        private void l() {
            this.d = "";
            this.e = "";
            this.f = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            return f1338b;
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
        public Parser<f> getParserForType() {
            return f1337a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.h;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, h());
                }
                this.h = i;
            }
            return i;
        }

        public ByteString h() {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
        /* renamed from: j */
        public C0048a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0048a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class h extends GeneratedMessageLite implements i {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<h> f1341a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.h.a.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new h(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final h f1342b = new h();
        private int c;
        private Object d;
        private Object e;
        private p f;
        private long g;
        private long h;
        private ac i;
        private f j;
        private v k;
        private byte l;
        private int m;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0049a extends GeneratedMessageLite.Builder<h, C0049a> implements i {

            /* renamed from: a  reason: collision with root package name */
            private int f1343a;
            private long e;
            private long f;

            /* renamed from: b  reason: collision with root package name */
            private Object f1344b = "";
            private Object c = "";
            private p d = p.a();
            private ac g = ac.a();
            private f h = f.a();
            private v i = v.a();

            private C0049a() {
                j();
            }

            private void j() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0049a k() {
                return new C0049a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0049a clear() {
                super.clear();
                this.f1344b = "";
                this.f1343a &= -2;
                this.c = "";
                this.f1343a &= -3;
                this.d = p.a();
                this.f1343a &= -5;
                this.e = 0L;
                this.f1343a &= -9;
                this.f = 0L;
                this.f1343a &= -17;
                this.g = ac.a();
                this.f1343a &= -33;
                this.h = f.a();
                this.f1343a &= -65;
                this.i = v.a();
                this.f1343a &= -129;
                return this;
            }

            public C0049a a(long j) {
                this.f1343a |= 8;
                this.e = j;
                return this;
            }

            public C0049a a(ac acVar) {
                if (acVar == null) {
                    throw new NullPointerException();
                }
                this.g = acVar;
                this.f1343a |= 32;
                return this;
            }

            public C0049a a(f fVar) {
                if (fVar == null) {
                    throw new NullPointerException();
                }
                this.h = fVar;
                this.f1343a |= 64;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0049a mergeFrom(h hVar) {
                if (hVar != h.a()) {
                    if (hVar.c()) {
                        this.f1343a |= 1;
                        this.f1344b = hVar.d;
                    }
                    if (hVar.e()) {
                        this.f1343a |= 2;
                        this.c = hVar.e;
                    }
                    if (hVar.g()) {
                        b(hVar.h());
                    }
                    if (hVar.i()) {
                        a(hVar.j());
                    }
                    if (hVar.k()) {
                        b(hVar.l());
                    }
                    if (hVar.m()) {
                        b(hVar.n());
                    }
                    if (hVar.o()) {
                        b(hVar.p());
                    }
                    if (hVar.q()) {
                        b(hVar.r());
                    }
                }
                return this;
            }

            public C0049a a(p pVar) {
                if (pVar == null) {
                    throw new NullPointerException();
                }
                this.d = pVar;
                this.f1343a |= 4;
                return this;
            }

            public C0049a a(v vVar) {
                if (vVar == null) {
                    throw new NullPointerException();
                }
                this.i = vVar;
                this.f1343a |= 128;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0049a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                h hVar = null;
                try {
                    try {
                        h parsePartialFrom = h.f1341a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (hVar != null) {
                            mergeFrom(hVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    h hVar2 = (h) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        hVar = hVar2;
                        if (hVar != null) {
                        }
                        throw th;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0049a clone() {
                return k().mergeFrom(buildPartial());
            }

            public C0049a b(long j) {
                this.f1343a |= 16;
                this.f = j;
                return this;
            }

            public C0049a b(ac acVar) {
                if ((this.f1343a & 32) != 32 || this.g == ac.a()) {
                    this.g = acVar;
                } else {
                    this.g = ac.a(this.g).mergeFrom(acVar).buildPartial();
                }
                this.f1343a |= 32;
                return this;
            }

            public C0049a b(f fVar) {
                if ((this.f1343a & 64) != 64 || this.h == f.a()) {
                    this.h = fVar;
                } else {
                    this.h = f.a(this.h).mergeFrom(fVar).buildPartial();
                }
                this.f1343a |= 64;
                return this;
            }

            public C0049a b(p pVar) {
                if ((this.f1343a & 4) != 4 || this.d == p.a()) {
                    this.d = pVar;
                } else {
                    this.d = p.a(this.d).mergeFrom(pVar).buildPartial();
                }
                this.f1343a |= 4;
                return this;
            }

            public C0049a b(v vVar) {
                if ((this.f1343a & 128) != 128 || this.i == v.a()) {
                    this.i = vVar;
                } else {
                    this.i = v.a(this.i).mergeFrom(vVar).buildPartial();
                }
                this.f1343a |= 128;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public h getDefaultInstanceForType() {
                return h.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public h build() {
                h buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public h buildPartial() {
                h hVar = new h(this);
                int i = this.f1343a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                hVar.d = this.f1344b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                hVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                hVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                hVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                hVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                hVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                hVar.j = this.h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                hVar.k = this.i;
                hVar.c = i2;
                return hVar;
            }

            public boolean f() {
                return (this.f1343a & 4) == 4;
            }

            public p g() {
                return this.d;
            }

            public boolean h() {
                return (this.f1343a & 8) == 8;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (h()) {
                    if (f()) {
                        return g().isInitialized();
                    }
                    return true;
                }
                return false;
            }
        }

        static {
            f1342b.v();
        }

        private h() {
            this.l = (byte) -1;
            this.m = -1;
        }

        private h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            this.l = (byte) -1;
            this.m = -1;
            v();
            boolean z2 = false;
            while (!z2) {
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
                                z = z2;
                                break;
                            case 18:
                                this.c |= 2;
                                this.e = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 58:
                                p.C0053a builder = (this.c & 4) == 4 ? this.f.toBuilder() : null;
                                this.f = (p) codedInputStream.readMessage(p.f1357a, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.f);
                                    this.f = builder.buildPartial();
                                }
                                this.c |= 4;
                                z = z2;
                                break;
                            case 80:
                                this.c |= 8;
                                this.g = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 96:
                                this.c |= 16;
                                this.h = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 162:
                                ac.C0045a builder2 = (this.c & 32) == 32 ? this.i.toBuilder() : null;
                                this.i = (ac) codedInputStream.readMessage(ac.f1323a, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.i);
                                    this.i = builder2.buildPartial();
                                }
                                this.c |= 32;
                                z = z2;
                                break;
                            case Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID /* 170 */:
                                f.C0048a builder3 = (this.c & 64) == 64 ? this.j.toBuilder() : null;
                                this.j = (f) codedInputStream.readMessage(f.f1337a, extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.j);
                                    this.j = builder3.buildPartial();
                                }
                                this.c |= 64;
                                z = z2;
                                break;
                            case Opcodes.GETSTATIC /* 178 */:
                                v.C0056a builder4 = (this.c & 128) == 128 ? this.k.toBuilder() : null;
                                this.k = (v) codedInputStream.readMessage(v.f1369a, extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom(this.k);
                                    this.k = builder4.buildPartial();
                                }
                                this.c |= 128;
                                z = z2;
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    break;
                                } else {
                                    z = z2;
                                    break;
                                }
                        }
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

        private h(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.l = (byte) -1;
            this.m = -1;
        }

        public static C0049a a(h hVar) {
            return t().mergeFrom(hVar);
        }

        public static h a() {
            return f1342b;
        }

        public static C0049a t() {
            return C0049a.k();
        }

        private void v() {
            this.d = "";
            this.e = "";
            this.f = p.a();
            this.g = 0L;
            this.h = 0L;
            this.i = ac.a();
            this.j = f.a();
            this.k = v.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            return f1342b;
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
        public Parser<h> getParserForType() {
            return f1341a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.m;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(7, this.f);
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(10, this.g);
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(12, this.h);
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeMessageSize(20, this.i);
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeMessageSize(21, this.j);
                }
                if ((this.c & 128) == 128) {
                    i += CodedOutputStream.computeMessageSize(22, this.k);
                }
                this.m = i;
            }
            return i;
        }

        public p h() {
            return this.f;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.l;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!i()) {
                this.l = (byte) 0;
                return false;
            } else if (!g() || h().isInitialized()) {
                this.l = (byte) 1;
                return true;
            } else {
                this.l = (byte) 0;
                return false;
            }
        }

        public long j() {
            return this.g;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public long l() {
            return this.h;
        }

        public boolean m() {
            return (this.c & 32) == 32;
        }

        public ac n() {
            return this.i;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public f p() {
            return this.j;
        }

        public boolean q() {
            return (this.c & 128) == 128;
        }

        public v r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0049a newBuilderForType() {
            return t();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0049a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeMessage(7, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(10, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt64(12, this.h);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeMessage(20, this.i);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeMessage(21, this.j);
            }
            if ((this.c & 128) == 128) {
                codedOutputStream.writeMessage(22, this.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class j extends GeneratedMessageLite implements k {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<j> f1345a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.h.a.a.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new j(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final j f1346b = new j();
        private int c;
        private long d;
        private long e;
        private Object f;
        private long g;
        private long h;
        private Object i;
        private long j;
        private byte k;
        private int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0050a extends GeneratedMessageLite.Builder<j, C0050a> implements k {

            /* renamed from: a  reason: collision with root package name */
            private int f1347a;

            /* renamed from: b  reason: collision with root package name */
            private long f1348b;
            private long c;
            private long e;
            private long f;
            private long h;
            private Object d = "";
            private Object g = "";

            private C0050a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0050a h() {
                return new C0050a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0050a clear() {
                super.clear();
                this.f1348b = 0L;
                this.f1347a &= -2;
                this.c = 0L;
                this.f1347a &= -3;
                this.d = "";
                this.f1347a &= -5;
                this.e = 0L;
                this.f1347a &= -9;
                this.f = 0L;
                this.f1347a &= -17;
                this.g = "";
                this.f1347a &= -33;
                this.h = 0L;
                this.f1347a &= -65;
                return this;
            }

            public C0050a a(long j) {
                this.f1347a |= 1;
                this.f1348b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0050a mergeFrom(j jVar) {
                if (jVar != j.a()) {
                    if (jVar.c()) {
                        a(jVar.d());
                    }
                    if (jVar.e()) {
                        b(jVar.f());
                    }
                    if (jVar.g()) {
                        this.f1347a |= 4;
                        this.d = jVar.f;
                    }
                    if (jVar.i()) {
                        c(jVar.j());
                    }
                    if (jVar.k()) {
                        d(jVar.l());
                    }
                    if (jVar.m()) {
                        this.f1347a |= 32;
                        this.g = jVar.i;
                    }
                    if (jVar.o()) {
                        e(jVar.p());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0050a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                j jVar = null;
                try {
                    try {
                        j parsePartialFrom = j.f1345a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (jVar != null) {
                            mergeFrom(jVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    j jVar2 = (j) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        jVar = jVar2;
                        if (jVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0050a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1347a |= 4;
                this.d = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0050a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0050a b(long j) {
                this.f1347a |= 2;
                this.c = j;
                return this;
            }

            public C0050a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1347a |= 32;
                this.g = str;
                return this;
            }

            public C0050a c(long j) {
                this.f1347a |= 8;
                this.e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                return j.a();
            }

            public C0050a d(long j) {
                this.f1347a |= 16;
                this.f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public j build() {
                j buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public C0050a e(long j) {
                this.f1347a |= 64;
                this.h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                j jVar = new j(this);
                int i = this.f1347a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                jVar.d = this.f1348b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                jVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                jVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                jVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                jVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                jVar.j = this.h;
                jVar.c = i2;
                return jVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1346b.t();
        }

        private j() {
            this.k = (byte) -1;
            this.l = -1;
        }

        private j(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
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
                                    this.d = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.c |= 2;
                                    this.e = codedInputStream.readInt64();
                                    break;
                                case 26:
                                    this.c |= 4;
                                    this.f = codedInputStream.readBytes();
                                    break;
                                case 32:
                                    this.c |= 8;
                                    this.g = codedInputStream.readInt64();
                                    break;
                                case 40:
                                    this.c |= 16;
                                    this.h = codedInputStream.readInt64();
                                    break;
                                case 50:
                                    this.c |= 32;
                                    this.i = codedInputStream.readBytes();
                                    break;
                                case 56:
                                    this.c |= 64;
                                    this.j = codedInputStream.readInt64();
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

        private j(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0050a a(j jVar) {
            return q().mergeFrom(jVar);
        }

        public static j a() {
            return f1346b;
        }

        public static C0050a q() {
            return C0050a.h();
        }

        private void t() {
            this.d = 0L;
            this.e = 0L;
            this.f = "";
            this.g = 0L;
            this.h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            return f1346b;
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

        public long f() {
            return this.e;
        }

        public boolean g() {
            return (this.c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            return f1345a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.d) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.e);
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, n());
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.j);
                }
                this.l = i;
            }
            return i;
        }

        public ByteString h() {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
            return true;
        }

        public long j() {
            return this.g;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public long l() {
            return this.h;
        }

        public boolean m() {
            return (this.c & 32) == 32;
        }

        public ByteString n() {
            Object obj = this.i;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.i = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0050a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0050a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.h);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class l extends GeneratedMessageLite implements m {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<l> f1349a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.h.a.a.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new l(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final l f1350b = new l();
        private int c;
        private Object d;
        private long e;
        private Object f;
        private long g;
        private byte h;
        private int i;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0051a extends GeneratedMessageLite.Builder<l, C0051a> implements m {

            /* renamed from: a  reason: collision with root package name */
            private int f1351a;
            private long c;
            private long e;

            /* renamed from: b  reason: collision with root package name */
            private Object f1352b = "";
            private Object d = "";

            private C0051a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0051a h() {
                return new C0051a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0051a clear() {
                super.clear();
                this.f1352b = "";
                this.f1351a &= -2;
                this.c = 0L;
                this.f1351a &= -3;
                this.d = "";
                this.f1351a &= -5;
                this.e = 0L;
                this.f1351a &= -9;
                return this;
            }

            public C0051a a(long j) {
                this.f1351a |= 2;
                this.c = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0051a mergeFrom(l lVar) {
                if (lVar != l.a()) {
                    if (lVar.c()) {
                        this.f1351a |= 1;
                        this.f1352b = lVar.d;
                    }
                    if (lVar.e()) {
                        a(lVar.f());
                    }
                    if (lVar.g()) {
                        this.f1351a |= 4;
                        this.d = lVar.f;
                    }
                    if (lVar.i()) {
                        b(lVar.j());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0051a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                l lVar = null;
                try {
                    try {
                        l parsePartialFrom = l.f1349a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (lVar != null) {
                            mergeFrom(lVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    l lVar2 = (l) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        lVar = lVar2;
                        if (lVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0051a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1351a |= 1;
                this.f1352b = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0051a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0051a b(long j) {
                this.f1351a |= 8;
                this.e = j;
                return this;
            }

            public C0051a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1351a |= 4;
                this.d = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public l getDefaultInstanceForType() {
                return l.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public l build() {
                l buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public l buildPartial() {
                l lVar = new l(this);
                int i = this.f1351a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                lVar.d = this.f1352b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                lVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                lVar.g = this.e;
                lVar.c = i2;
                return lVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1350b.n();
        }

        private l() {
            this.h = (byte) -1;
            this.i = -1;
        }

        private l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.h = (byte) -1;
            this.i = -1;
            n();
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
                                case 16:
                                    this.c |= 2;
                                    this.e = codedInputStream.readInt64();
                                    break;
                                case 26:
                                    this.c |= 4;
                                    this.f = codedInputStream.readBytes();
                                    break;
                                case 32:
                                    this.c |= 8;
                                    this.g = codedInputStream.readInt64();
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

        private l(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.h = (byte) -1;
            this.i = -1;
        }

        public static C0051a a(l lVar) {
            return k().mergeFrom(lVar);
        }

        public static l a() {
            return f1350b;
        }

        public static C0051a k() {
            return C0051a.h();
        }

        private void n() {
            this.d = "";
            this.e = 0L;
            this.f = "";
            this.g = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            return f1350b;
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

        public boolean e() {
            return (this.c & 2) == 2;
        }

        public long f() {
            return this.e;
        }

        public boolean g() {
            return (this.c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            return f1349a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.i;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.e);
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.g);
                }
                this.i = i;
            }
            return i;
        }

        public ByteString h() {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.h;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.h = (byte) 1;
            return true;
        }

        public long j() {
            return this.g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0051a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0051a newBuilderForType() {
            return k();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class n extends GeneratedMessageLite implements o {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f1353a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.h.a.a.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new n(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final n f1354b = new n();
        private int c;
        private Object d;
        private Object e;
        private Object f;
        private Object g;
        private long h;
        private long i;
        private long j;
        private Object k;
        private long l;
        private byte m;
        private int n;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0052a extends GeneratedMessageLite.Builder<n, C0052a> implements o {

            /* renamed from: a  reason: collision with root package name */
            private int f1355a;
            private long f;
            private long g;
            private long h;
            private long j;

            /* renamed from: b  reason: collision with root package name */
            private Object f1356b = "";
            private Object c = "";
            private Object d = "";
            private Object e = "";
            private Object i = "";

            private C0052a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0052a h() {
                return new C0052a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0052a clear() {
                super.clear();
                this.f1356b = "";
                this.f1355a &= -2;
                this.c = "";
                this.f1355a &= -3;
                this.d = "";
                this.f1355a &= -5;
                this.e = "";
                this.f1355a &= -9;
                this.f = 0L;
                this.f1355a &= -17;
                this.g = 0L;
                this.f1355a &= -33;
                this.h = 0L;
                this.f1355a &= -65;
                this.i = "";
                this.f1355a &= -129;
                this.j = 0L;
                this.f1355a &= -257;
                return this;
            }

            public C0052a a(long j) {
                this.f1355a |= 16;
                this.f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0052a mergeFrom(n nVar) {
                if (nVar != n.a()) {
                    if (nVar.c()) {
                        this.f1355a |= 1;
                        this.f1356b = nVar.d;
                    }
                    if (nVar.e()) {
                        this.f1355a |= 2;
                        this.c = nVar.e;
                    }
                    if (nVar.g()) {
                        this.f1355a |= 4;
                        this.d = nVar.f;
                    }
                    if (nVar.i()) {
                        this.f1355a |= 8;
                        this.e = nVar.g;
                    }
                    if (nVar.k()) {
                        a(nVar.l());
                    }
                    if (nVar.m()) {
                        b(nVar.n());
                    }
                    if (nVar.o()) {
                        c(nVar.p());
                    }
                    if (nVar.q()) {
                        this.f1355a |= 128;
                        this.i = nVar.k;
                    }
                    if (nVar.s()) {
                        d(nVar.t());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0052a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                n nVar = null;
                try {
                    try {
                        n parsePartialFrom = n.f1353a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (nVar != null) {
                            mergeFrom(nVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    n nVar2 = (n) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        nVar = nVar2;
                        if (nVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0052a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1355a |= 1;
                this.f1356b = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0052a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0052a b(long j) {
                this.f1355a |= 32;
                this.g = j;
                return this;
            }

            public C0052a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1355a |= 2;
                this.c = str;
                return this;
            }

            public C0052a c(long j) {
                this.f1355a |= 64;
                this.h = j;
                return this;
            }

            public C0052a c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1355a |= 4;
                this.d = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public n getDefaultInstanceForType() {
                return n.a();
            }

            public C0052a d(long j) {
                this.f1355a |= 256;
                this.j = j;
                return this;
            }

            public C0052a d(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1355a |= 8;
                this.e = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public n build() {
                n buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public C0052a e(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1355a |= 128;
                this.i = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                n nVar = new n(this);
                int i = this.f1355a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                nVar.d = this.f1356b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                nVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                nVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                nVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                nVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                nVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                nVar.j = this.h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                nVar.k = this.i;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                nVar.l = this.j;
                nVar.c = i2;
                return nVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1354b.x();
        }

        private n() {
            this.m = (byte) -1;
            this.n = -1;
        }

        private n(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.m = (byte) -1;
            this.n = -1;
            x();
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
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.c |= 4;
                                    this.f = codedInputStream.readBytes();
                                    break;
                                case 34:
                                    this.c |= 8;
                                    this.g = codedInputStream.readBytes();
                                    break;
                                case 40:
                                    this.c |= 16;
                                    this.h = codedInputStream.readInt64();
                                    break;
                                case 48:
                                    this.c |= 32;
                                    this.i = codedInputStream.readInt64();
                                    break;
                                case 56:
                                    this.c |= 64;
                                    this.j = codedInputStream.readInt64();
                                    break;
                                case 66:
                                    this.c |= 128;
                                    this.k = codedInputStream.readBytes();
                                    break;
                                case 72:
                                    this.c |= 256;
                                    this.l = codedInputStream.readInt64();
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

        private n(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.m = (byte) -1;
            this.n = -1;
        }

        public static C0052a a(n nVar) {
            return u().mergeFrom(nVar);
        }

        public static n a() {
            return f1354b;
        }

        public static C0052a u() {
            return C0052a.h();
        }

        private void x() {
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = 0L;
            this.i = 0L;
            this.j = 0L;
            this.k = "";
            this.l = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            return f1354b;
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
        public Parser<n> getParserForType() {
            return f1353a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.n;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, h());
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, j());
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeInt64Size(6, this.i);
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.j);
                }
                if ((this.c & 128) == 128) {
                    i += CodedOutputStream.computeBytesSize(8, r());
                }
                if ((this.c & 256) == 256) {
                    i += CodedOutputStream.computeInt64Size(9, this.l);
                }
                this.n = i;
            }
            return i;
        }

        public ByteString h() {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.m = (byte) 1;
            return true;
        }

        public ByteString j() {
            Object obj = this.g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.c & 16) == 16;
        }

        public long l() {
            return this.h;
        }

        public boolean m() {
            return (this.c & 32) == 32;
        }

        public long n() {
            return this.i;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        public boolean q() {
            return (this.c & 128) == 128;
        }

        public ByteString r() {
            Object obj = this.k;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.k = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean s() {
            return (this.c & 256) == 256;
        }

        public long t() {
            return this.l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C0052a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C0052a newBuilderForType() {
            return u();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.h);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.i);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
            if ((this.c & 128) == 128) {
                codedOutputStream.writeBytes(8, r());
            }
            if ((this.c & 256) == 256) {
                codedOutputStream.writeInt64(9, this.l);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class p extends GeneratedMessageLite implements q {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<p> f1357a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.h.a.a.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new p(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final p f1358b = new p();
        private int c;
        private Object d;
        private byte e;
        private int f;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0053a extends GeneratedMessageLite.Builder<p, C0053a> implements q {

            /* renamed from: a  reason: collision with root package name */
            private int f1359a;

            /* renamed from: b  reason: collision with root package name */
            private Object f1360b = "";

            private C0053a() {
                h();
            }

            private void h() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0053a i() {
                return new C0053a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0053a clear() {
                super.clear();
                this.f1360b = "";
                this.f1359a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0053a mergeFrom(p pVar) {
                if (pVar != p.a() && pVar.c()) {
                    this.f1359a |= 1;
                    this.f1360b = pVar.d;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0053a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                p pVar = null;
                try {
                    try {
                        p parsePartialFrom = p.f1357a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (pVar != null) {
                            mergeFrom(pVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    p pVar2 = (p) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        pVar = pVar2;
                        if (pVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0053a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1359a |= 1;
                this.f1360b = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0053a clone() {
                return i().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public p getDefaultInstanceForType() {
                return p.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public p build() {
                p buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public p buildPartial() {
                p pVar = new p(this);
                int i = (this.f1359a & 1) != 1 ? 0 : 1;
                pVar.d = this.f1360b;
                pVar.c = i;
                return pVar;
            }

            public boolean f() {
                return (this.f1359a & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return f();
            }
        }

        static {
            f1358b.h();
        }

        private p() {
            this.e = (byte) -1;
            this.f = -1;
        }

        private p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                case 34:
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

        private p(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.e = (byte) -1;
            this.f = -1;
        }

        public static C0053a a(p pVar) {
            return e().mergeFrom(pVar);
        }

        public static p a() {
            return f1358b;
        }

        public static C0053a e() {
            return C0053a.i();
        }

        private void h() {
            this.d = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            return f1358b;
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
        public C0053a newBuilderForType() {
            return e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C0053a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            return f1357a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
                this.f = i;
            }
            return i;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.e;
            if (b2 != -1) {
                return b2 == 1;
            } else if (c()) {
                this.e = (byte) 1;
                return true;
            } else {
                this.e = (byte) 0;
                return false;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(4, d());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class r extends GeneratedMessageLite implements s {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<r> f1361a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.h.a.a.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new r(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final r f1362b = new r();
        private int c;
        private int d;
        private Object e;
        private Object f;
        private byte g;
        private int h;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0054a extends GeneratedMessageLite.Builder<r, C0054a> implements s {

            /* renamed from: a  reason: collision with root package name */
            private int f1363a;

            /* renamed from: b  reason: collision with root package name */
            private int f1364b = 7399;
            private Object c = "push_im_client";
            private Object d = "phonebaidu";

            private C0054a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0054a h() {
                return new C0054a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0054a clear() {
                super.clear();
                this.f1364b = 7399;
                this.f1363a &= -2;
                this.c = "push_im_client";
                this.f1363a &= -3;
                this.d = "phonebaidu";
                this.f1363a &= -5;
                return this;
            }

            public C0054a a(int i) {
                this.f1363a |= 1;
                this.f1364b = i;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0054a mergeFrom(r rVar) {
                if (rVar != r.a()) {
                    if (rVar.c()) {
                        a(rVar.d());
                    }
                    if (rVar.e()) {
                        this.f1363a |= 2;
                        this.c = rVar.e;
                    }
                    if (rVar.g()) {
                        this.f1363a |= 4;
                        this.d = rVar.f;
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0054a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                r rVar = null;
                try {
                    try {
                        r parsePartialFrom = r.f1361a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (rVar != null) {
                            mergeFrom(rVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    r rVar2 = (r) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        rVar = rVar2;
                        if (rVar != null) {
                        }
                        throw th;
                    }
                }
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
            public r getDefaultInstanceForType() {
                return r.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public r build() {
                r buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public r buildPartial() {
                r rVar = new r(this);
                int i = this.f1363a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rVar.d = this.f1364b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rVar.f = this.d;
                rVar.c = i2;
                return rVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1362b.l();
        }

        private r() {
            this.g = (byte) -1;
            this.h = -1;
        }

        private r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.g = (byte) -1;
            this.h = -1;
            l();
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
                                case 26:
                                    this.c |= 4;
                                    this.f = codedInputStream.readBytes();
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

        private r(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.g = (byte) -1;
            this.h = -1;
        }

        public static C0054a a(r rVar) {
            return i().mergeFrom(rVar);
        }

        public static r a() {
            return f1362b;
        }

        public static C0054a i() {
            return C0054a.h();
        }

        private void l() {
            this.d = 7399;
            this.e = "push_im_client";
            this.f = "phonebaidu";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            return f1362b;
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
        public Parser<r> getParserForType() {
            return f1361a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.h;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.d) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, h());
                }
                this.h = i;
            }
            return i;
        }

        public ByteString h() {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
        /* renamed from: j */
        public C0054a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0054a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class t extends GeneratedMessageLite implements u {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<t> f1365a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.h.a.a.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new t(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final t f1366b = new t();
        private int c;
        private long d;
        private Object e;
        private long f;
        private long g;
        private Object h;
        private long i;
        private long j;
        private byte k;
        private int l;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0055a extends GeneratedMessageLite.Builder<t, C0055a> implements u {

            /* renamed from: a  reason: collision with root package name */
            private int f1367a;

            /* renamed from: b  reason: collision with root package name */
            private long f1368b;
            private long d;
            private long e;
            private long g;
            private long h;
            private Object c = "";
            private Object f = "";

            private C0055a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0055a h() {
                return new C0055a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0055a clear() {
                super.clear();
                this.f1368b = 0L;
                this.f1367a &= -2;
                this.c = "";
                this.f1367a &= -3;
                this.d = 0L;
                this.f1367a &= -5;
                this.e = 0L;
                this.f1367a &= -9;
                this.f = "";
                this.f1367a &= -17;
                this.g = 0L;
                this.f1367a &= -33;
                this.h = 0L;
                this.f1367a &= -65;
                return this;
            }

            public C0055a a(long j) {
                this.f1367a |= 1;
                this.f1368b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0055a mergeFrom(t tVar) {
                if (tVar != t.a()) {
                    if (tVar.c()) {
                        a(tVar.d());
                    }
                    if (tVar.e()) {
                        this.f1367a |= 2;
                        this.c = tVar.e;
                    }
                    if (tVar.g()) {
                        b(tVar.h());
                    }
                    if (tVar.i()) {
                        c(tVar.j());
                    }
                    if (tVar.k()) {
                        this.f1367a |= 16;
                        this.f = tVar.h;
                    }
                    if (tVar.m()) {
                        d(tVar.n());
                    }
                    if (tVar.o()) {
                        e(tVar.p());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0055a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                t tVar = null;
                try {
                    try {
                        t parsePartialFrom = t.f1365a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (tVar != null) {
                            mergeFrom(tVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    t tVar2 = (t) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        tVar = tVar2;
                        if (tVar != null) {
                        }
                        throw th;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0055a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0055a b(long j) {
                this.f1367a |= 4;
                this.d = j;
                return this;
            }

            public C0055a c(long j) {
                this.f1367a |= 8;
                this.e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                return t.a();
            }

            public C0055a d(long j) {
                this.f1367a |= 32;
                this.g = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public t build() {
                t buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public C0055a e(long j) {
                this.f1367a |= 64;
                this.h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                t tVar = new t(this);
                int i = this.f1367a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                tVar.d = this.f1368b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                tVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                tVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                tVar.g = this.e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                tVar.h = this.f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                tVar.i = this.g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                tVar.j = this.h;
                tVar.c = i2;
                return tVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1366b.t();
        }

        private t() {
            this.k = (byte) -1;
            this.l = -1;
        }

        private t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
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
                                    this.d = codedInputStream.readInt64();
                                    break;
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.c |= 4;
                                    this.f = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.c |= 8;
                                    this.g = codedInputStream.readInt64();
                                    break;
                                case 42:
                                    this.c |= 16;
                                    this.h = codedInputStream.readBytes();
                                    break;
                                case 48:
                                    this.c |= 32;
                                    this.i = codedInputStream.readInt64();
                                    break;
                                case 56:
                                    this.c |= 64;
                                    this.j = codedInputStream.readInt64();
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

        private t(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0055a a(t tVar) {
            return q().mergeFrom(tVar);
        }

        public static t a() {
            return f1366b;
        }

        public static C0055a q() {
            return C0055a.h();
        }

        private void t() {
            this.d = 0L;
            this.e = "";
            this.f = 0L;
            this.g = 0L;
            this.h = "";
            this.i = 0L;
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            return f1366b;
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
        public Parser<t> getParserForType() {
            return f1365a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.d) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                if ((this.c & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, l());
                }
                if ((this.c & 32) == 32) {
                    i += CodedOutputStream.computeInt64Size(6, this.i);
                }
                if ((this.c & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.j);
                }
                this.l = i;
            }
            return i;
        }

        public long h() {
            return this.f;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.k = (byte) 1;
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

        public long n() {
            return this.i;
        }

        public boolean o() {
            return (this.c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0055a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0055a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
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
                codedOutputStream.writeInt64(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.i);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public static final class v extends GeneratedMessageLite implements w {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<v> f1369a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.h.a.a.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new v(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final v f1370b = new v();
        private int c;
        private Object d;
        private Object e;
        private byte f;
        private int g;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0056a extends GeneratedMessageLite.Builder<v, C0056a> implements w {

            /* renamed from: a  reason: collision with root package name */
            private int f1371a;

            /* renamed from: b  reason: collision with root package name */
            private Object f1372b = "";
            private Object c = "";

            private C0056a() {
                g();
            }

            private void g() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0056a h() {
                return new C0056a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0056a clear() {
                super.clear();
                this.f1372b = "";
                this.f1371a &= -2;
                this.c = "";
                this.f1371a &= -3;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0056a mergeFrom(v vVar) {
                if (vVar != v.a()) {
                    if (vVar.c()) {
                        this.f1371a |= 1;
                        this.f1372b = vVar.d;
                    }
                    if (vVar.e()) {
                        this.f1371a |= 2;
                        this.c = vVar.e;
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0056a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                v vVar = null;
                try {
                    try {
                        v parsePartialFrom = v.f1369a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (vVar != null) {
                            mergeFrom(vVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    v vVar2 = (v) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        vVar = vVar2;
                        if (vVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0056a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1371a |= 1;
                this.f1372b = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0056a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0056a b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1371a |= 2;
                this.c = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public v getDefaultInstanceForType() {
                return v.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public v build() {
                v buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public v buildPartial() {
                v vVar = new v(this);
                int i = this.f1371a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                vVar.d = this.f1372b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                vVar.e = this.c;
                vVar.c = i2;
                return vVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f1370b.j();
        }

        private v() {
            this.f = (byte) -1;
            this.g = -1;
        }

        private v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f = (byte) -1;
            this.g = -1;
            j();
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
                                case 18:
                                    this.c |= 2;
                                    this.e = codedInputStream.readBytes();
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

        private v(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f = (byte) -1;
            this.g = -1;
        }

        public static C0056a a(v vVar) {
            return g().mergeFrom(vVar);
        }

        public static v a() {
            return f1370b;
        }

        public static C0056a g() {
            return C0056a.h();
        }

        private void j() {
            this.d = "";
            this.e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            return f1370b;
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

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            return f1369a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.g;
            if (i == -1) {
                i = (this.c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
                if ((this.c & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, f());
                }
                this.g = i;
            }
            return i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C0056a newBuilderForType() {
            return g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C0056a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public enum x implements Internal.EnumLite {
        OS_TYPE_UNKNWON(0),
        IOS(1),
        ANDROID(2),
        WINDOWSPHONE(3);
        
        private final int e;

        x(int i) {
            this.e = i;
        }

        public static x a(int i) {
            switch (i) {
                case 0:
                    return OS_TYPE_UNKNWON;
                case 1:
                    return IOS;
                case 2:
                    return ANDROID;
                case 3:
                    return WINDOWSPHONE;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.e;
        }
    }

    /* loaded from: classes3.dex */
    public static final class y extends GeneratedMessageLite implements z {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f1375a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.h.a.a.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new y(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final y f1376b = new y();
        private int c;
        private r d;
        private h e;
        private Object f;
        private long g;
        private List<c> h;
        private byte i;
        private int j;

        /* renamed from: com.baidu.android.pushservice.h.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0057a extends GeneratedMessageLite.Builder<y, C0057a> implements z {

            /* renamed from: a  reason: collision with root package name */
            private int f1377a;
            private long e;

            /* renamed from: b  reason: collision with root package name */
            private r f1378b = r.a();
            private h c = h.a();
            private Object d = "";
            private List<c> f = Collections.emptyList();

            private C0057a() {
                i();
            }

            private void i() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0057a j() {
                return new C0057a();
            }

            private void k() {
                if ((this.f1377a & 16) != 16) {
                    this.f = new ArrayList(this.f);
                    this.f1377a |= 16;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0057a clear() {
                super.clear();
                this.f1378b = r.a();
                this.f1377a &= -2;
                this.c = h.a();
                this.f1377a &= -3;
                this.d = "";
                this.f1377a &= -5;
                this.e = 0L;
                this.f1377a &= -9;
                this.f = Collections.emptyList();
                this.f1377a &= -17;
                return this;
            }

            public C0057a a(long j) {
                this.f1377a |= 8;
                this.e = j;
                return this;
            }

            public C0057a a(h hVar) {
                if (hVar == null) {
                    throw new NullPointerException();
                }
                this.c = hVar;
                this.f1377a |= 2;
                return this;
            }

            public C0057a a(r rVar) {
                if ((this.f1377a & 1) != 1 || this.f1378b == r.a()) {
                    this.f1378b = rVar;
                } else {
                    this.f1378b = r.a(this.f1378b).mergeFrom(rVar).buildPartial();
                }
                this.f1377a |= 1;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0057a mergeFrom(y yVar) {
                if (yVar != y.a()) {
                    if (yVar.c()) {
                        a(yVar.d());
                    }
                    if (yVar.e()) {
                        b(yVar.f());
                    }
                    if (yVar.g()) {
                        this.f1377a |= 4;
                        this.d = yVar.f;
                    }
                    if (yVar.i()) {
                        a(yVar.j());
                    }
                    if (!yVar.h.isEmpty()) {
                        if (this.f.isEmpty()) {
                            this.f = yVar.h;
                            this.f1377a &= -17;
                        } else {
                            k();
                            this.f.addAll(yVar.h);
                        }
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0057a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                y yVar = null;
                try {
                    try {
                        y parsePartialFrom = y.f1375a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (yVar != null) {
                            mergeFrom(yVar);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    y yVar2 = (y) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        yVar = yVar2;
                        if (yVar != null) {
                        }
                        throw th;
                    }
                }
            }

            public C0057a a(Iterable<? extends c> iterable) {
                k();
                addAll(iterable, this.f);
                return this;
            }

            public C0057a a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1377a |= 4;
                this.d = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0057a clone() {
                return j().mergeFrom(buildPartial());
            }

            public C0057a b(h hVar) {
                if ((this.f1377a & 2) != 2 || this.c == h.a()) {
                    this.c = hVar;
                } else {
                    this.c = h.a(this.c).mergeFrom(hVar).buildPartial();
                }
                this.f1377a |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public y getDefaultInstanceForType() {
                return y.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public y build() {
                y buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public y buildPartial() {
                y yVar = new y(this);
                int i = this.f1377a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                yVar.d = this.f1378b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                yVar.e = this.c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                yVar.f = this.d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                yVar.g = this.e;
                if ((this.f1377a & 16) == 16) {
                    this.f = Collections.unmodifiableList(this.f);
                    this.f1377a &= -17;
                }
                yVar.h = this.f;
                yVar.c = i2;
                return yVar;
            }

            public boolean f() {
                return (this.f1377a & 2) == 2;
            }

            public h g() {
                return this.c;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (f()) {
                    return g().isInitialized();
                }
                return false;
            }
        }

        static {
            f1376b.n();
        }

        private y() {
            this.i = (byte) -1;
            this.j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: java.util.List<com.baidu.android.pushservice.h.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        private y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            this.i = (byte) -1;
            this.j = -1;
            n();
            boolean z2 = false;
            boolean z3 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                continue;
                                z2 = z;
                            case 202:
                                r.C0054a builder = (this.c & 1) == 1 ? this.d.toBuilder() : null;
                                this.d = (r) codedInputStream.readMessage(r.f1361a, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.d);
                                    this.d = builder.buildPartial();
                                }
                                this.c |= 1;
                                z = z2;
                                continue;
                                z2 = z;
                            case 330:
                                h.C0049a builder2 = (this.c & 2) == 2 ? this.e.toBuilder() : null;
                                this.e = (h) codedInputStream.readMessage(h.f1341a, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.e);
                                    this.e = builder2.buildPartial();
                                }
                                this.c |= 2;
                                z = z2;
                                continue;
                                z2 = z;
                            case 1042:
                                this.c |= 4;
                                this.f = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 1048:
                                this.c |= 8;
                                this.g = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 1058:
                                if (!(z3 & true)) {
                                    this.h = new ArrayList();
                                    z3 |= true;
                                }
                                this.h.add(codedInputStream.readMessage(c.f1331a, extensionRegistryLite));
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
                    if (z3 & true) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        private y(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.i = (byte) -1;
            this.j = -1;
        }

        public static C0057a a(y yVar) {
            return k().mergeFrom(yVar);
        }

        public static y a() {
            return f1376b;
        }

        public static C0057a k() {
            return C0057a.j();
        }

        private void n() {
            this.d = r.a();
            this.e = h.a();
            this.f = "";
            this.g = 0L;
            this.h = Collections.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            return f1376b;
        }

        public boolean c() {
            return (this.c & 1) == 1;
        }

        public r d() {
            return this.d;
        }

        public boolean e() {
            return (this.c & 2) == 2;
        }

        public h f() {
            return this.e;
        }

        public boolean g() {
            return (this.c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            return f1375a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = 0;
            int i2 = this.j;
            if (i2 == -1) {
                int computeMessageSize = (this.c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.d) + 0 : 0;
                if ((this.c & 2) == 2) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(41, this.e);
                }
                if ((this.c & 4) == 4) {
                    computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
                }
                if ((this.c & 8) == 8) {
                    computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.g);
                }
                while (true) {
                    i2 = computeMessageSize;
                    if (i >= this.h.size()) {
                        break;
                    }
                    computeMessageSize = CodedOutputStream.computeMessageSize(IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, this.h.get(i)) + i2;
                    i++;
                }
                this.j = i2;
            }
            return i2;
        }

        public ByteString h() {
            Object obj = this.f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!e()) {
                this.i = (byte) 0;
                return false;
            } else if (f().isInitialized()) {
                this.i = (byte) 1;
                return true;
            } else {
                this.i = (byte) 0;
                return false;
            }
        }

        public long j() {
            return this.g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0057a newBuilderForType() {
            return k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0057a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeMessage(25, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeMessage(41, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.g);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.h.size()) {
                    return;
                }
                codedOutputStream.writeMessage(IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, this.h.get(i2));
                i = i2 + 1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
