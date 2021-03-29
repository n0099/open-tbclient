package com.baidu.android.pushservice.i.a.a;

import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.google.protobuf.AbstractMessageLite;
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
/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.baidu.android.pushservice.i.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0037a extends GeneratedMessageLite implements b {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<C0037a> f3086a = new AbstractParser<C0037a>() { // from class: com.baidu.android.pushservice.i.a.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public C0037a parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new C0037a(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final C0037a f3087b;

        /* renamed from: c  reason: collision with root package name */
        public int f3088c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3089d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3090e;

        /* renamed from: f  reason: collision with root package name */
        public long f3091f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3092g;

        /* renamed from: h  reason: collision with root package name */
        public long f3093h;
        public byte i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0038a extends GeneratedMessageLite.Builder<C0037a, C0038a> implements b {

            /* renamed from: a  reason: collision with root package name */
            public int f3094a;

            /* renamed from: d  reason: collision with root package name */
            public long f3097d;

            /* renamed from: f  reason: collision with root package name */
            public long f3099f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3095b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3096c = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3098e = "";

            public C0038a() {
                g();
            }

            private void g() {
            }

            public static C0038a h() {
                return new C0038a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0038a clear() {
                super.clear();
                this.f3095b = "";
                int i = this.f3094a & (-2);
                this.f3094a = i;
                this.f3096c = "";
                int i2 = i & (-3);
                this.f3094a = i2;
                this.f3097d = 0L;
                int i3 = i2 & (-5);
                this.f3094a = i3;
                this.f3098e = "";
                int i4 = i3 & (-9);
                this.f3094a = i4;
                this.f3099f = 0L;
                this.f3094a = i4 & (-17);
                return this;
            }

            public C0038a a(long j) {
                this.f3094a |= 4;
                this.f3097d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0038a mergeFrom(C0037a c0037a) {
                if (c0037a == C0037a.a()) {
                    return this;
                }
                if (c0037a.c()) {
                    this.f3094a |= 1;
                    this.f3095b = c0037a.f3089d;
                }
                if (c0037a.e()) {
                    this.f3094a |= 2;
                    this.f3096c = c0037a.f3090e;
                }
                if (c0037a.g()) {
                    a(c0037a.h());
                }
                if (c0037a.i()) {
                    this.f3094a |= 8;
                    this.f3098e = c0037a.f3092g;
                }
                if (c0037a.k()) {
                    b(c0037a.l());
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
            public C0038a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                C0037a c0037a = null;
                try {
                    try {
                        C0037a parsePartialFrom = C0037a.f3086a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        C0037a c0037a2 = (C0037a) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            c0037a = c0037a2;
                            if (c0037a != null) {
                                mergeFrom(c0037a);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0037a != null) {
                    }
                    throw th;
                }
            }

            public C0038a a(String str) {
                if (str != null) {
                    this.f3094a |= 1;
                    this.f3095b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0038a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0038a b(long j) {
                this.f3094a |= 16;
                this.f3099f = j;
                return this;
            }

            public C0038a b(String str) {
                if (str != null) {
                    this.f3094a |= 2;
                    return this;
                }
                throw null;
            }

            public C0038a c(String str) {
                if (str != null) {
                    this.f3094a |= 8;
                    this.f3098e = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public C0037a getDefaultInstanceForType() {
                return C0037a.a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public C0037a build() {
                C0037a buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public C0037a buildPartial() {
                C0037a c0037a = new C0037a(this);
                int i = this.f3094a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c0037a.f3089d = this.f3095b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c0037a.f3090e = this.f3096c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                c0037a.f3091f = this.f3097d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                c0037a.f3092g = this.f3098e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                c0037a.f3093h = this.f3099f;
                c0037a.f3088c = i2;
                return c0037a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            C0037a c0037a = new C0037a();
            f3087b = c0037a;
            c0037a.p();
        }

        public C0037a() {
            this.i = (byte) -1;
            this.j = -1;
        }

        public C0037a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.i = (byte) -1;
            this.j = -1;
            p();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3088c |= 1;
                                    this.f3089d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3088c |= 2;
                                    this.f3090e = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.f3088c |= 4;
                                    this.f3091f = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.f3088c |= 8;
                                    this.f3092g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3088c |= 16;
                                    this.f3093h = codedInputStream.readInt64();
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

        public C0037a(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.i = (byte) -1;
            this.j = -1;
        }

        public static C0038a a(C0037a c0037a) {
            return m().mergeFrom(c0037a);
        }

        public static C0037a a() {
            return f3087b;
        }

        public static C0038a m() {
            return C0038a.h();
        }

        private void p() {
            this.f3089d = "";
            this.f3090e = "";
            this.f3091f = 0L;
            this.f3092g = "";
            this.f3093h = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public C0037a getDefaultInstanceForType() {
            return f3087b;
        }

        public boolean c() {
            return (this.f3088c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3089d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3089d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3088c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3090e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3090e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3088c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<C0037a> getParserForType() {
            return f3086a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.j;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3088c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3088c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3088c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3091f);
            }
            if ((this.f3088c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3088c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3093h);
            }
            this.j = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3091f;
        }

        public boolean i() {
            return (this.f3088c & 8) == 8;
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
            Object obj = this.f3092g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3092g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3088c & 16) == 16;
        }

        public long l() {
            return this.f3093h;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: n */
        public C0038a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: o */
        public C0038a newBuilderForType() {
            return m();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3088c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3088c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3088c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3091f);
            }
            if ((this.f3088c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3088c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3093h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class aa extends GeneratedMessageLite implements ab {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<aa> f3100a = new AbstractParser<aa>() { // from class: com.baidu.android.pushservice.i.a.a.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public aa parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new aa(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final aa f3101b;

        /* renamed from: c  reason: collision with root package name */
        public int f3102c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3103d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3104e;

        /* renamed from: f  reason: collision with root package name */
        public long f3105f;

        /* renamed from: g  reason: collision with root package name */
        public long f3106g;

        /* renamed from: h  reason: collision with root package name */
        public long f3107h;
        public Object i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$aa$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0039a extends GeneratedMessageLite.Builder<aa, C0039a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            public int f3108a;

            /* renamed from: d  reason: collision with root package name */
            public long f3111d;

            /* renamed from: e  reason: collision with root package name */
            public long f3112e;

            /* renamed from: f  reason: collision with root package name */
            public long f3113f;

            /* renamed from: h  reason: collision with root package name */
            public long f3115h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3109b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3110c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3114g = "";

            public C0039a() {
                g();
            }

            private void g() {
            }

            public static C0039a h() {
                return new C0039a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0039a clear() {
                super.clear();
                this.f3109b = "";
                int i = this.f3108a & (-2);
                this.f3108a = i;
                this.f3110c = "";
                int i2 = i & (-3);
                this.f3108a = i2;
                this.f3111d = 0L;
                int i3 = i2 & (-5);
                this.f3108a = i3;
                this.f3112e = 0L;
                int i4 = i3 & (-9);
                this.f3108a = i4;
                this.f3113f = 0L;
                int i5 = i4 & (-17);
                this.f3108a = i5;
                this.f3114g = "";
                int i6 = i5 & (-33);
                this.f3108a = i6;
                this.f3115h = 0L;
                this.f3108a = i6 & (-65);
                return this;
            }

            public C0039a a(long j) {
                this.f3108a |= 4;
                this.f3111d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0039a mergeFrom(aa aaVar) {
                if (aaVar == aa.a()) {
                    return this;
                }
                if (aaVar.c()) {
                    this.f3108a |= 1;
                    this.f3109b = aaVar.f3103d;
                }
                if (aaVar.e()) {
                    this.f3108a |= 2;
                    this.f3110c = aaVar.f3104e;
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
                    this.f3108a |= 32;
                    this.f3114g = aaVar.i;
                }
                if (aaVar.o()) {
                    d(aaVar.p());
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
            public C0039a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                aa aaVar = null;
                try {
                    try {
                        aa parsePartialFrom = aa.f3100a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        aa aaVar2 = (aa) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            aaVar = aaVar2;
                            if (aaVar != null) {
                                mergeFrom(aaVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (aaVar != null) {
                    }
                    throw th;
                }
            }

            public C0039a a(String str) {
                if (str != null) {
                    this.f3108a |= 1;
                    this.f3109b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0039a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0039a b(long j) {
                this.f3108a |= 8;
                this.f3112e = j;
                return this;
            }

            public C0039a b(String str) {
                if (str != null) {
                    this.f3108a |= 2;
                    this.f3110c = str;
                    return this;
                }
                throw null;
            }

            public C0039a c(long j) {
                this.f3108a |= 16;
                this.f3113f = j;
                return this;
            }

            public C0039a c(String str) {
                if (str != null) {
                    this.f3108a |= 32;
                    this.f3114g = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public aa getDefaultInstanceForType() {
                return aa.a();
            }

            public C0039a d(long j) {
                this.f3108a |= 64;
                this.f3115h = j;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public aa buildPartial() {
                aa aaVar = new aa(this);
                int i = this.f3108a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                aaVar.f3103d = this.f3109b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                aaVar.f3104e = this.f3110c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                aaVar.f3105f = this.f3111d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                aaVar.f3106g = this.f3112e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                aaVar.f3107h = this.f3113f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                aaVar.i = this.f3114g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                aaVar.j = this.f3115h;
                aaVar.f3102c = i2;
                return aaVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            aa aaVar = new aa();
            f3101b = aaVar;
            aaVar.t();
        }

        public aa() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public aa(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3102c |= 1;
                                this.f3103d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3102c |= 2;
                                this.f3104e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3102c |= 4;
                                this.f3105f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3102c |= 8;
                                this.f3106g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3102c |= 16;
                                this.f3107h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3102c |= 32;
                                this.i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3102c |= 64;
                                this.j = codedInputStream.readInt64();
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

        public aa(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0039a a(aa aaVar) {
            return q().mergeFrom(aaVar);
        }

        public static aa a() {
            return f3101b;
        }

        public static C0039a q() {
            return C0039a.h();
        }

        private void t() {
            this.f3103d = "";
            this.f3104e = "";
            this.f3105f = 0L;
            this.f3106g = 0L;
            this.f3107h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public aa getDefaultInstanceForType() {
            return f3101b;
        }

        public boolean c() {
            return (this.f3102c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3103d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3103d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3102c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3104e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3104e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3102c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<aa> getParserForType() {
            return f3100a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3102c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3102c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3102c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3105f);
            }
            if ((this.f3102c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3106g);
            }
            if ((this.f3102c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3107h);
            }
            if ((this.f3102c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3102c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3105f;
        }

        public boolean i() {
            return (this.f3102c & 8) == 8;
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
            return this.f3106g;
        }

        public boolean k() {
            return (this.f3102c & 16) == 16;
        }

        public long l() {
            return this.f3107h;
        }

        public boolean m() {
            return (this.f3102c & 32) == 32;
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
            return (this.f3102c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0039a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0039a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3102c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3102c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3102c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3105f);
            }
            if ((this.f3102c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3106g);
            }
            if ((this.f3102c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3107h);
            }
            if ((this.f3102c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3102c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class ac extends GeneratedMessageLite implements ad {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ac> f3116a = new AbstractParser<ac>() { // from class: com.baidu.android.pushservice.i.a.a.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ac parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ac(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ac f3117b;

        /* renamed from: c  reason: collision with root package name */
        public int f3118c;

        /* renamed from: d  reason: collision with root package name */
        public x f3119d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3120e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3121f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3122g;

        /* renamed from: h  reason: collision with root package name */
        public int f3123h;
        public int i;
        public int j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ac$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0040a extends GeneratedMessageLite.Builder<ac, C0040a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            public int f3124a;

            /* renamed from: b  reason: collision with root package name */
            public x f3125b = x.OS_TYPE_UNKNWON;

            /* renamed from: c  reason: collision with root package name */
            public Object f3126c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3127d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3128e = "";

            /* renamed from: f  reason: collision with root package name */
            public int f3129f;

            /* renamed from: g  reason: collision with root package name */
            public int f3130g;

            /* renamed from: h  reason: collision with root package name */
            public int f3131h;

            public C0040a() {
                g();
            }

            private void g() {
            }

            public static C0040a h() {
                return new C0040a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0040a clear() {
                super.clear();
                this.f3125b = x.OS_TYPE_UNKNWON;
                int i = this.f3124a & (-2);
                this.f3124a = i;
                this.f3126c = "";
                int i2 = i & (-3);
                this.f3124a = i2;
                this.f3127d = "";
                int i3 = i2 & (-5);
                this.f3124a = i3;
                this.f3128e = "";
                int i4 = i3 & (-9);
                this.f3124a = i4;
                this.f3129f = 0;
                int i5 = i4 & (-17);
                this.f3124a = i5;
                this.f3130g = 0;
                int i6 = i5 & (-33);
                this.f3124a = i6;
                this.f3131h = 0;
                this.f3124a = i6 & (-65);
                return this;
            }

            public C0040a a(int i) {
                this.f3124a |= 16;
                this.f3129f = i;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0040a mergeFrom(ac acVar) {
                if (acVar == ac.a()) {
                    return this;
                }
                if (acVar.c()) {
                    a(acVar.d());
                }
                if (acVar.e()) {
                    this.f3124a |= 2;
                    this.f3126c = acVar.f3120e;
                }
                if (acVar.g()) {
                    this.f3124a |= 4;
                    this.f3127d = acVar.f3121f;
                }
                if (acVar.i()) {
                    this.f3124a |= 8;
                    this.f3128e = acVar.f3122g;
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
                return this;
            }

            public C0040a a(x xVar) {
                if (xVar != null) {
                    this.f3124a |= 1;
                    this.f3125b = xVar;
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
            public C0040a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ac acVar = null;
                try {
                    try {
                        ac parsePartialFrom = ac.f3116a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        ac acVar2 = (ac) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            acVar = acVar2;
                            if (acVar != null) {
                                mergeFrom(acVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (acVar != null) {
                    }
                    throw th;
                }
            }

            public C0040a a(String str) {
                if (str != null) {
                    this.f3124a |= 2;
                    this.f3126c = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0040a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0040a b(int i) {
                this.f3124a |= 32;
                this.f3130g = i;
                return this;
            }

            public C0040a b(String str) {
                if (str != null) {
                    this.f3124a |= 4;
                    this.f3127d = str;
                    return this;
                }
                throw null;
            }

            public C0040a c(int i) {
                this.f3124a |= 64;
                this.f3131h = i;
                return this;
            }

            public C0040a c(String str) {
                if (str != null) {
                    this.f3124a |= 8;
                    this.f3128e = str;
                    return this;
                }
                throw null;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ac buildPartial() {
                ac acVar = new ac(this);
                int i = this.f3124a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                acVar.f3119d = this.f3125b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                acVar.f3120e = this.f3126c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                acVar.f3121f = this.f3127d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                acVar.f3122g = this.f3128e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                acVar.f3123h = this.f3129f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                acVar.i = this.f3130g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                acVar.j = this.f3131h;
                acVar.f3118c = i2;
                return acVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ac acVar = new ac();
            f3117b = acVar;
            acVar.t();
        }

        public ac() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public ac(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    x a2 = x.a(codedInputStream.readEnum());
                                    if (a2 != null) {
                                        this.f3118c = 1 | this.f3118c;
                                        this.f3119d = a2;
                                    }
                                } else if (readTag == 18) {
                                    this.f3118c |= 2;
                                    this.f3120e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3118c |= 4;
                                    this.f3121f = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.f3118c |= 8;
                                    this.f3122g = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.f3118c |= 16;
                                    this.f3123h = codedInputStream.readInt32();
                                } else if (readTag == 48) {
                                    this.f3118c |= 32;
                                    this.i = codedInputStream.readInt32();
                                } else if (readTag == 56) {
                                    this.f3118c |= 64;
                                    this.j = codedInputStream.readInt32();
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        public ac(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0040a a(ac acVar) {
            return q().mergeFrom(acVar);
        }

        public static ac a() {
            return f3117b;
        }

        public static C0040a q() {
            return C0040a.h();
        }

        private void t() {
            this.f3119d = x.OS_TYPE_UNKNWON;
            this.f3120e = "";
            this.f3121f = "";
            this.f3122g = "";
            this.f3123h = 0;
            this.i = 0;
            this.j = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ac getDefaultInstanceForType() {
            return f3117b;
        }

        public boolean c() {
            return (this.f3118c & 1) == 1;
        }

        public x d() {
            return this.f3119d;
        }

        public boolean e() {
            return (this.f3118c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3120e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3120e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3118c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ac> getParserForType() {
            return f3116a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.f3118c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3119d.getNumber()) : 0;
            if ((this.f3118c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3118c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3118c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3118c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, this.f3123h);
            }
            if ((this.f3118c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeInt32Size(6, this.i);
            }
            if ((this.f3118c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeInt32Size(7, this.j);
            }
            this.l = computeEnumSize;
            return computeEnumSize;
        }

        public ByteString h() {
            Object obj = this.f3121f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3121f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3118c & 8) == 8;
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
            Object obj = this.f3122g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3122g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3118c & 16) == 16;
        }

        public int l() {
            return this.f3123h;
        }

        public boolean m() {
            return (this.f3118c & 32) == 32;
        }

        public int n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3118c & 64) == 64;
        }

        public int p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0040a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0040a newBuilderForType() {
            return q();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3118c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3119d.getNumber());
            }
            if ((this.f3118c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3118c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3118c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3118c & 16) == 16) {
                codedOutputStream.writeInt32(5, this.f3123h);
            }
            if ((this.f3118c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.i);
            }
            if ((this.f3118c & 64) == 64) {
                codedOutputStream.writeInt32(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ad extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class ae extends GeneratedMessageLite implements af {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<ae> f3132a = new AbstractParser<ae>() { // from class: com.baidu.android.pushservice.i.a.a.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public ae parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ae(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final ae f3133b;

        /* renamed from: c  reason: collision with root package name */
        public int f3134c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3135d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3136e;

        /* renamed from: f  reason: collision with root package name */
        public long f3137f;

        /* renamed from: g  reason: collision with root package name */
        public long f3138g;

        /* renamed from: h  reason: collision with root package name */
        public long f3139h;
        public Object i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$ae$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0041a extends GeneratedMessageLite.Builder<ae, C0041a> implements af {

            /* renamed from: a  reason: collision with root package name */
            public int f3140a;

            /* renamed from: d  reason: collision with root package name */
            public long f3143d;

            /* renamed from: e  reason: collision with root package name */
            public long f3144e;

            /* renamed from: f  reason: collision with root package name */
            public long f3145f;

            /* renamed from: h  reason: collision with root package name */
            public long f3147h;

            /* renamed from: b  reason: collision with root package name */
            public Object f3141b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3142c = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3146g = "";

            public C0041a() {
                g();
            }

            private void g() {
            }

            public static C0041a h() {
                return new C0041a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0041a clear() {
                super.clear();
                this.f3141b = "";
                int i = this.f3140a & (-2);
                this.f3140a = i;
                this.f3142c = "";
                int i2 = i & (-3);
                this.f3140a = i2;
                this.f3143d = 0L;
                int i3 = i2 & (-5);
                this.f3140a = i3;
                this.f3144e = 0L;
                int i4 = i3 & (-9);
                this.f3140a = i4;
                this.f3145f = 0L;
                int i5 = i4 & (-17);
                this.f3140a = i5;
                this.f3146g = "";
                int i6 = i5 & (-33);
                this.f3140a = i6;
                this.f3147h = 0L;
                this.f3140a = i6 & (-65);
                return this;
            }

            public C0041a a(long j) {
                this.f3140a |= 4;
                this.f3143d = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0041a mergeFrom(ae aeVar) {
                if (aeVar == ae.a()) {
                    return this;
                }
                if (aeVar.c()) {
                    this.f3140a |= 1;
                    this.f3141b = aeVar.f3135d;
                }
                if (aeVar.e()) {
                    this.f3140a |= 2;
                    this.f3142c = aeVar.f3136e;
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
                    this.f3140a |= 32;
                    this.f3146g = aeVar.i;
                }
                if (aeVar.o()) {
                    d(aeVar.p());
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
            public C0041a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ae aeVar = null;
                try {
                    try {
                        ae parsePartialFrom = ae.f3132a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        ae aeVar2 = (ae) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            aeVar = aeVar2;
                            if (aeVar != null) {
                                mergeFrom(aeVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (aeVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0041a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0041a b(long j) {
                this.f3140a |= 8;
                this.f3144e = j;
                return this;
            }

            public C0041a c(long j) {
                this.f3140a |= 16;
                this.f3145f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public ae getDefaultInstanceForType() {
                return ae.a();
            }

            public C0041a d(long j) {
                this.f3140a |= 64;
                this.f3147h = j;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public ae buildPartial() {
                ae aeVar = new ae(this);
                int i = this.f3140a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                aeVar.f3135d = this.f3141b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                aeVar.f3136e = this.f3142c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                aeVar.f3137f = this.f3143d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                aeVar.f3138g = this.f3144e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                aeVar.f3139h = this.f3145f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                aeVar.i = this.f3146g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                aeVar.j = this.f3147h;
                aeVar.f3134c = i2;
                return aeVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            ae aeVar = new ae();
            f3133b = aeVar;
            aeVar.t();
        }

        public ae() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public ae(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3134c |= 1;
                                this.f3135d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3134c |= 2;
                                this.f3136e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3134c |= 4;
                                this.f3137f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3134c |= 8;
                                this.f3138g = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.f3134c |= 16;
                                this.f3139h = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.f3134c |= 32;
                                this.i = codedInputStream.readBytes();
                            } else if (readTag == 56) {
                                this.f3134c |= 64;
                                this.j = codedInputStream.readInt64();
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

        public ae(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0041a a(ae aeVar) {
            return q().mergeFrom(aeVar);
        }

        public static ae a() {
            return f3133b;
        }

        public static C0041a q() {
            return C0041a.h();
        }

        private void t() {
            this.f3135d = "";
            this.f3136e = "";
            this.f3137f = 0L;
            this.f3138g = 0L;
            this.f3139h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public ae getDefaultInstanceForType() {
            return f3133b;
        }

        public boolean c() {
            return (this.f3134c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3135d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3135d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3134c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3136e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3136e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3134c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ae> getParserForType() {
            return f3132a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3134c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3134c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3134c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3137f);
            }
            if ((this.f3134c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3138g);
            }
            if ((this.f3134c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3139h);
            }
            if ((this.f3134c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3134c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeBytesSize;
            return computeBytesSize;
        }

        public long h() {
            return this.f3137f;
        }

        public boolean i() {
            return (this.f3134c & 8) == 8;
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
            return this.f3138g;
        }

        public boolean k() {
            return (this.f3134c & 16) == 16;
        }

        public long l() {
            return this.f3139h;
        }

        public boolean m() {
            return (this.f3134c & 32) == 32;
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
            return (this.f3134c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0041a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0041a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3134c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3134c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3134c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3137f);
            }
            if ((this.f3134c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3138g);
            }
            if ((this.f3134c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3139h);
            }
            if ((this.f3134c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3134c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface af extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite implements d {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<c> f3148a = new AbstractParser<c>() { // from class: com.baidu.android.pushservice.i.a.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f3149b;

        /* renamed from: c  reason: collision with root package name */
        public int f3150c;

        /* renamed from: d  reason: collision with root package name */
        public e f3151d;

        /* renamed from: e  reason: collision with root package name */
        public ae f3152e;

        /* renamed from: f  reason: collision with root package name */
        public l f3153f;

        /* renamed from: g  reason: collision with root package name */
        public n f3154g;

        /* renamed from: h  reason: collision with root package name */
        public j f3155h;
        public aa i;
        public C0037a j;
        public t k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0042a extends GeneratedMessageLite.Builder<c, C0042a> implements d {

            /* renamed from: a  reason: collision with root package name */
            public int f3156a;

            /* renamed from: b  reason: collision with root package name */
            public e f3157b = e.UI;

            /* renamed from: c  reason: collision with root package name */
            public ae f3158c = ae.a();

            /* renamed from: d  reason: collision with root package name */
            public l f3159d = l.a();

            /* renamed from: e  reason: collision with root package name */
            public n f3160e = n.a();

            /* renamed from: f  reason: collision with root package name */
            public j f3161f = j.a();

            /* renamed from: g  reason: collision with root package name */
            public aa f3162g = aa.a();

            /* renamed from: h  reason: collision with root package name */
            public C0037a f3163h = C0037a.a();
            public t i = t.a();

            public C0042a() {
                g();
            }

            private void g() {
            }

            public static C0042a h() {
                return new C0042a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0042a clear() {
                super.clear();
                this.f3157b = e.UI;
                this.f3156a &= -2;
                this.f3158c = ae.a();
                this.f3156a &= -3;
                this.f3159d = l.a();
                this.f3156a &= -5;
                this.f3160e = n.a();
                this.f3156a &= -9;
                this.f3161f = j.a();
                this.f3156a &= -17;
                this.f3162g = aa.a();
                this.f3156a &= -33;
                this.f3163h = C0037a.a();
                this.f3156a &= -65;
                this.i = t.a();
                this.f3156a &= -129;
                return this;
            }

            public C0042a a(C0037a c0037a) {
                if (c0037a != null) {
                    this.f3163h = c0037a;
                    this.f3156a |= 64;
                    return this;
                }
                throw null;
            }

            public C0042a a(aa aaVar) {
                if (aaVar != null) {
                    this.f3162g = aaVar;
                    this.f3156a |= 32;
                    return this;
                }
                throw null;
            }

            public C0042a a(ae aeVar) {
                if ((this.f3156a & 2) == 2 && this.f3158c != ae.a()) {
                    aeVar = ae.a(this.f3158c).mergeFrom(aeVar).buildPartial();
                }
                this.f3158c = aeVar;
                this.f3156a |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0042a mergeFrom(c cVar) {
                if (cVar == c.a()) {
                    return this;
                }
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
                return this;
            }

            public C0042a a(e eVar) {
                if (eVar != null) {
                    this.f3156a |= 1;
                    this.f3157b = eVar;
                    return this;
                }
                throw null;
            }

            public C0042a a(j jVar) {
                if (jVar != null) {
                    this.f3161f = jVar;
                    this.f3156a |= 16;
                    return this;
                }
                throw null;
            }

            public C0042a a(l lVar) {
                if (lVar != null) {
                    this.f3159d = lVar;
                    this.f3156a |= 4;
                    return this;
                }
                throw null;
            }

            public C0042a a(n nVar) {
                if (nVar != null) {
                    this.f3160e = nVar;
                    this.f3156a |= 8;
                    return this;
                }
                throw null;
            }

            public C0042a a(t tVar) {
                if ((this.f3156a & 128) == 128 && this.i != t.a()) {
                    tVar = t.a(this.i).mergeFrom(tVar).buildPartial();
                }
                this.i = tVar;
                this.f3156a |= 128;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0042a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                c cVar = null;
                try {
                    try {
                        c parsePartialFrom = c.f3148a.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            public C0042a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0042a b(C0037a c0037a) {
                if ((this.f3156a & 64) == 64 && this.f3163h != C0037a.a()) {
                    c0037a = C0037a.a(this.f3163h).mergeFrom(c0037a).buildPartial();
                }
                this.f3163h = c0037a;
                this.f3156a |= 64;
                return this;
            }

            public C0042a b(aa aaVar) {
                if ((this.f3156a & 32) == 32 && this.f3162g != aa.a()) {
                    aaVar = aa.a(this.f3162g).mergeFrom(aaVar).buildPartial();
                }
                this.f3162g = aaVar;
                this.f3156a |= 32;
                return this;
            }

            public C0042a b(j jVar) {
                if ((this.f3156a & 16) == 16 && this.f3161f != j.a()) {
                    jVar = j.a(this.f3161f).mergeFrom(jVar).buildPartial();
                }
                this.f3161f = jVar;
                this.f3156a |= 16;
                return this;
            }

            public C0042a b(l lVar) {
                if ((this.f3156a & 4) == 4 && this.f3159d != l.a()) {
                    lVar = l.a(this.f3159d).mergeFrom(lVar).buildPartial();
                }
                this.f3159d = lVar;
                this.f3156a |= 4;
                return this;
            }

            public C0042a b(n nVar) {
                if ((this.f3156a & 8) == 8 && this.f3160e != n.a()) {
                    nVar = n.a(this.f3160e).mergeFrom(nVar).buildPartial();
                }
                this.f3160e = nVar;
                this.f3156a |= 8;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public c buildPartial() {
                c cVar = new c(this);
                int i = this.f3156a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.f3151d = this.f3157b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.f3152e = this.f3158c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.f3153f = this.f3159d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                cVar.f3154g = this.f3160e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                cVar.f3155h = this.f3161f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                cVar.i = this.f3162g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                cVar.j = this.f3163h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                cVar.k = this.i;
                cVar.f3150c = i2;
                return cVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            c cVar = new c();
            f3149b = cVar;
            cVar.v();
        }

        public c() {
            this.l = (byte) -1;
            this.m = -1;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i;
            int i2;
            this.l = (byte) -1;
            this.m = -1;
            v();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 8) {
                                if (readTag == 18) {
                                    i = 2;
                                    ae.C0041a builder = (this.f3150c & 2) == 2 ? this.f3152e.toBuilder() : null;
                                    ae aeVar = (ae) codedInputStream.readMessage(ae.f3132a, extensionRegistryLite);
                                    this.f3152e = aeVar;
                                    if (builder != null) {
                                        builder.mergeFrom(aeVar);
                                        this.f3152e = builder.buildPartial();
                                    }
                                    i2 = this.f3150c;
                                } else if (readTag == 26) {
                                    i = 4;
                                    l.C0046a builder2 = (this.f3150c & 4) == 4 ? this.f3153f.toBuilder() : null;
                                    l lVar = (l) codedInputStream.readMessage(l.f3216a, extensionRegistryLite);
                                    this.f3153f = lVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(lVar);
                                        this.f3153f = builder2.buildPartial();
                                    }
                                    i2 = this.f3150c;
                                } else if (readTag == 34) {
                                    n.C0047a builder3 = (this.f3150c & 8) == 8 ? this.f3154g.toBuilder() : null;
                                    n nVar = (n) codedInputStream.readMessage(n.f3229a, extensionRegistryLite);
                                    this.f3154g = nVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(nVar);
                                        this.f3154g = builder3.buildPartial();
                                    }
                                    this.f3150c |= 8;
                                } else if (readTag == 42) {
                                    i = 16;
                                    j.C0045a builder4 = (this.f3150c & 16) == 16 ? this.f3155h.toBuilder() : null;
                                    j jVar = (j) codedInputStream.readMessage(j.f3200a, extensionRegistryLite);
                                    this.f3155h = jVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(jVar);
                                        this.f3155h = builder4.buildPartial();
                                    }
                                    i2 = this.f3150c;
                                } else if (readTag == 50) {
                                    i = 32;
                                    aa.C0039a builder5 = (this.f3150c & 32) == 32 ? this.i.toBuilder() : null;
                                    aa aaVar = (aa) codedInputStream.readMessage(aa.f3100a, extensionRegistryLite);
                                    this.i = aaVar;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(aaVar);
                                        this.i = builder5.buildPartial();
                                    }
                                    i2 = this.f3150c;
                                } else if (readTag == 58) {
                                    i = 64;
                                    C0037a.C0038a builder6 = (this.f3150c & 64) == 64 ? this.j.toBuilder() : null;
                                    C0037a c0037a = (C0037a) codedInputStream.readMessage(C0037a.f3086a, extensionRegistryLite);
                                    this.j = c0037a;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(c0037a);
                                        this.j = builder6.buildPartial();
                                    }
                                    i2 = this.f3150c;
                                } else if (readTag == 66) {
                                    i = 128;
                                    t.C0050a builder7 = (this.f3150c & 128) == 128 ? this.k.toBuilder() : null;
                                    t tVar = (t) codedInputStream.readMessage(t.f3265a, extensionRegistryLite);
                                    this.k = tVar;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(tVar);
                                        this.k = builder7.buildPartial();
                                    }
                                    i2 = this.f3150c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3150c = i2 | i;
                            } else {
                                e a2 = e.a(codedInputStream.readEnum());
                                if (a2 != null) {
                                    this.f3150c = 1 | this.f3150c;
                                    this.f3151d = a2;
                                }
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

        public c(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.l = (byte) -1;
            this.m = -1;
        }

        public static C0042a a(c cVar) {
            return s().mergeFrom(cVar);
        }

        public static c a() {
            return f3149b;
        }

        public static C0042a s() {
            return C0042a.h();
        }

        private void v() {
            this.f3151d = e.UI;
            this.f3152e = ae.a();
            this.f3153f = l.a();
            this.f3154g = n.a();
            this.f3155h = j.a();
            this.i = aa.a();
            this.j = C0037a.a();
            this.k = t.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public c getDefaultInstanceForType() {
            return f3149b;
        }

        public boolean c() {
            return (this.f3150c & 1) == 1;
        }

        public e d() {
            return this.f3151d;
        }

        public boolean e() {
            return (this.f3150c & 2) == 2;
        }

        public ae f() {
            return this.f3152e;
        }

        public boolean g() {
            return (this.f3150c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<c> getParserForType() {
            return f3148a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.m;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.f3150c & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f3151d.getNumber()) : 0;
            if ((this.f3150c & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.f3152e);
            }
            if ((this.f3150c & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.f3153f);
            }
            if ((this.f3150c & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeMessageSize(4, this.f3154g);
            }
            if ((this.f3150c & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeMessageSize(5, this.f3155h);
            }
            if ((this.f3150c & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeMessageSize(6, this.i);
            }
            if ((this.f3150c & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, this.j);
            }
            if ((this.f3150c & 128) == 128) {
                computeEnumSize += CodedOutputStream.computeMessageSize(8, this.k);
            }
            this.m = computeEnumSize;
            return computeEnumSize;
        }

        public l h() {
            return this.f3153f;
        }

        public boolean i() {
            return (this.f3150c & 8) == 8;
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
            return this.f3154g;
        }

        public boolean k() {
            return (this.f3150c & 16) == 16;
        }

        public j l() {
            return this.f3155h;
        }

        public boolean m() {
            return (this.f3150c & 32) == 32;
        }

        public aa n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3150c & 64) == 64;
        }

        public C0037a p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3150c & 128) == 128;
        }

        public t r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: t */
        public C0042a newBuilderForType() {
            return s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0042a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3150c & 1) == 1) {
                codedOutputStream.writeEnum(1, this.f3151d.getNumber());
            }
            if ((this.f3150c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.f3152e);
            }
            if ((this.f3150c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f3153f);
            }
            if ((this.f3150c & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f3154g);
            }
            if ((this.f3150c & 16) == 16) {
                codedOutputStream.writeMessage(5, this.f3155h);
            }
            if ((this.f3150c & 32) == 32) {
                codedOutputStream.writeMessage(6, this.i);
            }
            if ((this.f3150c & 64) == 64) {
                codedOutputStream.writeMessage(7, this.j);
            }
            if ((this.f3150c & 128) == 128) {
                codedOutputStream.writeMessage(8, this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public enum e implements Internal.EnumLite {
        UI(101),
        CRASH(201),
        DB(301),
        CONNECTION(401),
        REQUEST(501),
        ACK(601),
        MSG(701);
        

        /* renamed from: h  reason: collision with root package name */
        public final int f3171h;

        e(int i2) {
            this.f3171h = i2;
        }

        public static e a(int i2) {
            if (i2 != 101) {
                if (i2 != 201) {
                    if (i2 != 301) {
                        if (i2 != 401) {
                            if (i2 != 501) {
                                if (i2 != 601) {
                                    if (i2 != 701) {
                                        return null;
                                    }
                                    return MSG;
                                }
                                return ACK;
                            }
                            return REQUEST;
                        }
                        return CONNECTION;
                    }
                    return DB;
                }
                return CRASH;
            }
            return UI;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.f3171h;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends GeneratedMessageLite implements g {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<f> f3172a = new AbstractParser<f>() { // from class: com.baidu.android.pushservice.i.a.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new f(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final f f3173b;

        /* renamed from: c  reason: collision with root package name */
        public int f3174c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3175d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3176e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3177f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3178g;

        /* renamed from: h  reason: collision with root package name */
        public int f3179h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0043a extends GeneratedMessageLite.Builder<f, C0043a> implements g {

            /* renamed from: a  reason: collision with root package name */
            public int f3180a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3181b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3182c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3183d = "";

            public C0043a() {
                g();
            }

            private void g() {
            }

            public static C0043a h() {
                return new C0043a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0043a clear() {
                super.clear();
                this.f3181b = "";
                int i = this.f3180a & (-2);
                this.f3180a = i;
                this.f3182c = "";
                int i2 = i & (-3);
                this.f3180a = i2;
                this.f3183d = "";
                this.f3180a = i2 & (-5);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0043a mergeFrom(f fVar) {
                if (fVar == f.a()) {
                    return this;
                }
                if (fVar.c()) {
                    this.f3180a |= 1;
                    this.f3181b = fVar.f3175d;
                }
                if (fVar.e()) {
                    this.f3180a |= 2;
                    this.f3182c = fVar.f3176e;
                }
                if (fVar.g()) {
                    this.f3180a |= 4;
                    this.f3183d = fVar.f3177f;
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
            public C0043a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                f fVar = null;
                try {
                    try {
                        f parsePartialFrom = f.f3172a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        f fVar2 = (f) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            fVar = fVar2;
                            if (fVar != null) {
                                mergeFrom(fVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fVar != null) {
                    }
                    throw th;
                }
            }

            public C0043a a(String str) {
                if (str != null) {
                    this.f3180a |= 1;
                    this.f3181b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0043a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0043a b(String str) {
                if (str != null) {
                    this.f3180a |= 2;
                    this.f3182c = str;
                    return this;
                }
                throw null;
            }

            public C0043a c(String str) {
                if (str != null) {
                    this.f3180a |= 4;
                    this.f3183d = str;
                    return this;
                }
                throw null;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public f buildPartial() {
                f fVar = new f(this);
                int i = this.f3180a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                fVar.f3175d = this.f3181b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                fVar.f3176e = this.f3182c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                fVar.f3177f = this.f3183d;
                fVar.f3174c = i2;
                return fVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            f fVar = new f();
            f3173b = fVar;
            fVar.l();
        }

        public f() {
            this.f3178g = (byte) -1;
            this.f3179h = -1;
        }

        public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3178g = (byte) -1;
            this.f3179h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3174c |= 1;
                                    this.f3175d = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.f3174c |= 2;
                                    this.f3176e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3174c |= 4;
                                    this.f3177f = codedInputStream.readBytes();
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

        public f(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3178g = (byte) -1;
            this.f3179h = -1;
        }

        public static C0043a a(f fVar) {
            return i().mergeFrom(fVar);
        }

        public static f a() {
            return f3173b;
        }

        public static C0043a i() {
            return C0043a.h();
        }

        private void l() {
            this.f3175d = "";
            this.f3176e = "";
            this.f3177f = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public f getDefaultInstanceForType() {
            return f3173b;
        }

        public boolean c() {
            return (this.f3174c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3175d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3175d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3174c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3176e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3176e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3174c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<f> getParserForType() {
            return f3172a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3179h;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3174c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3174c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3174c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3179h = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3177f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3177f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3178g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3178g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0043a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0043a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3174c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3174c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3174c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class h extends GeneratedMessageLite implements i {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<h> f3184a = new AbstractParser<h>() { // from class: com.baidu.android.pushservice.i.a.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new h(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final h f3185b;

        /* renamed from: c  reason: collision with root package name */
        public int f3186c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3187d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3188e;

        /* renamed from: f  reason: collision with root package name */
        public p f3189f;

        /* renamed from: g  reason: collision with root package name */
        public long f3190g;

        /* renamed from: h  reason: collision with root package name */
        public long f3191h;
        public ac i;
        public f j;
        public v k;
        public byte l;
        public int m;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0044a extends GeneratedMessageLite.Builder<h, C0044a> implements i {

            /* renamed from: a  reason: collision with root package name */
            public int f3192a;

            /* renamed from: e  reason: collision with root package name */
            public long f3196e;

            /* renamed from: f  reason: collision with root package name */
            public long f3197f;

            /* renamed from: b  reason: collision with root package name */
            public Object f3193b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3194c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f3195d = p.a();

            /* renamed from: g  reason: collision with root package name */
            public ac f3198g = ac.a();

            /* renamed from: h  reason: collision with root package name */
            public f f3199h = f.a();
            public v i = v.a();

            public C0044a() {
                j();
            }

            private void j() {
            }

            public static C0044a k() {
                return new C0044a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0044a clear() {
                super.clear();
                this.f3193b = "";
                int i = this.f3192a & (-2);
                this.f3192a = i;
                this.f3194c = "";
                this.f3192a = i & (-3);
                this.f3195d = p.a();
                int i2 = this.f3192a & (-5);
                this.f3192a = i2;
                this.f3196e = 0L;
                int i3 = i2 & (-9);
                this.f3192a = i3;
                this.f3197f = 0L;
                this.f3192a = i3 & (-17);
                this.f3198g = ac.a();
                this.f3192a &= -33;
                this.f3199h = f.a();
                this.f3192a &= -65;
                this.i = v.a();
                this.f3192a &= -129;
                return this;
            }

            public C0044a a(long j) {
                this.f3192a |= 8;
                this.f3196e = j;
                return this;
            }

            public C0044a a(ac acVar) {
                if (acVar != null) {
                    this.f3198g = acVar;
                    this.f3192a |= 32;
                    return this;
                }
                throw null;
            }

            public C0044a a(f fVar) {
                if (fVar != null) {
                    this.f3199h = fVar;
                    this.f3192a |= 64;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0044a mergeFrom(h hVar) {
                if (hVar == h.a()) {
                    return this;
                }
                if (hVar.c()) {
                    this.f3192a |= 1;
                    this.f3193b = hVar.f3187d;
                }
                if (hVar.e()) {
                    this.f3192a |= 2;
                    this.f3194c = hVar.f3188e;
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
                return this;
            }

            public C0044a a(p pVar) {
                if (pVar != null) {
                    this.f3195d = pVar;
                    this.f3192a |= 4;
                    return this;
                }
                throw null;
            }

            public C0044a a(v vVar) {
                if (vVar != null) {
                    this.i = vVar;
                    this.f3192a |= 128;
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
            public C0044a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                h hVar = null;
                try {
                    try {
                        h parsePartialFrom = h.f3184a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        h hVar2 = (h) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            hVar = hVar2;
                            if (hVar != null) {
                                mergeFrom(hVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (hVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0044a clone() {
                return k().mergeFrom(buildPartial());
            }

            public C0044a b(long j) {
                this.f3192a |= 16;
                this.f3197f = j;
                return this;
            }

            public C0044a b(ac acVar) {
                if ((this.f3192a & 32) == 32 && this.f3198g != ac.a()) {
                    acVar = ac.a(this.f3198g).mergeFrom(acVar).buildPartial();
                }
                this.f3198g = acVar;
                this.f3192a |= 32;
                return this;
            }

            public C0044a b(f fVar) {
                if ((this.f3192a & 64) == 64 && this.f3199h != f.a()) {
                    fVar = f.a(this.f3199h).mergeFrom(fVar).buildPartial();
                }
                this.f3199h = fVar;
                this.f3192a |= 64;
                return this;
            }

            public C0044a b(p pVar) {
                if ((this.f3192a & 4) == 4 && this.f3195d != p.a()) {
                    pVar = p.a(this.f3195d).mergeFrom(pVar).buildPartial();
                }
                this.f3195d = pVar;
                this.f3192a |= 4;
                return this;
            }

            public C0044a b(v vVar) {
                if ((this.f3192a & 128) == 128 && this.i != v.a()) {
                    vVar = v.a(this.i).mergeFrom(vVar).buildPartial();
                }
                this.i = vVar;
                this.f3192a |= 128;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public h buildPartial() {
                h hVar = new h(this);
                int i = this.f3192a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                hVar.f3187d = this.f3193b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                hVar.f3188e = this.f3194c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                hVar.f3189f = this.f3195d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                hVar.f3190g = this.f3196e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                hVar.f3191h = this.f3197f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                hVar.i = this.f3198g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                hVar.j = this.f3199h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                hVar.k = this.i;
                hVar.f3186c = i2;
                return hVar;
            }

            public boolean f() {
                return (this.f3192a & 4) == 4;
            }

            public p g() {
                return this.f3195d;
            }

            public boolean h() {
                return (this.f3192a & 8) == 8;
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
            h hVar = new h();
            f3185b = hVar;
            hVar.v();
        }

        public h() {
            this.l = (byte) -1;
            this.m = -1;
        }

        public h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i;
            int i2;
            this.l = (byte) -1;
            this.m = -1;
            v();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3186c |= 1;
                                this.f3187d = codedInputStream.readBytes();
                            } else if (readTag != 18) {
                                if (readTag == 58) {
                                    i = 4;
                                    p.C0048a builder = (this.f3186c & 4) == 4 ? this.f3189f.toBuilder() : null;
                                    p pVar = (p) codedInputStream.readMessage(p.f3245a, extensionRegistryLite);
                                    this.f3189f = pVar;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar);
                                        this.f3189f = builder.buildPartial();
                                    }
                                    i2 = this.f3186c;
                                } else if (readTag == 80) {
                                    this.f3186c |= 8;
                                    this.f3190g = codedInputStream.readInt64();
                                } else if (readTag == 96) {
                                    this.f3186c |= 16;
                                    this.f3191h = codedInputStream.readInt64();
                                } else if (readTag == 162) {
                                    i = 32;
                                    ac.C0040a builder2 = (this.f3186c & 32) == 32 ? this.i.toBuilder() : null;
                                    ac acVar = (ac) codedInputStream.readMessage(ac.f3116a, extensionRegistryLite);
                                    this.i = acVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(acVar);
                                        this.i = builder2.buildPartial();
                                    }
                                    i2 = this.f3186c;
                                } else if (readTag == 170) {
                                    i = 64;
                                    f.C0043a builder3 = (this.f3186c & 64) == 64 ? this.j.toBuilder() : null;
                                    f fVar = (f) codedInputStream.readMessage(f.f3172a, extensionRegistryLite);
                                    this.j = fVar;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(fVar);
                                        this.j = builder3.buildPartial();
                                    }
                                    i2 = this.f3186c;
                                } else if (readTag == 178) {
                                    i = 128;
                                    v.C0051a builder4 = (this.f3186c & 128) == 128 ? this.k.toBuilder() : null;
                                    v vVar = (v) codedInputStream.readMessage(v.f3281a, extensionRegistryLite);
                                    this.k = vVar;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(vVar);
                                        this.k = builder4.buildPartial();
                                    }
                                    i2 = this.f3186c;
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                                this.f3186c = i2 | i;
                            } else {
                                this.f3186c |= 2;
                                this.f3188e = codedInputStream.readBytes();
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

        public h(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.l = (byte) -1;
            this.m = -1;
        }

        public static C0044a a(h hVar) {
            return t().mergeFrom(hVar);
        }

        public static h a() {
            return f3185b;
        }

        public static C0044a t() {
            return C0044a.k();
        }

        private void v() {
            this.f3187d = "";
            this.f3188e = "";
            this.f3189f = p.a();
            this.f3190g = 0L;
            this.f3191h = 0L;
            this.i = ac.a();
            this.j = f.a();
            this.k = v.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public h getDefaultInstanceForType() {
            return f3185b;
        }

        public boolean c() {
            return (this.f3186c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3187d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3187d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3186c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3188e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3188e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3186c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<h> getParserForType() {
            return f3184a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.m;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3186c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3186c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3186c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeMessageSize(7, this.f3189f);
            }
            if ((this.f3186c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(10, this.f3190g);
            }
            if ((this.f3186c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.f3191h);
            }
            if ((this.f3186c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeMessageSize(20, this.i);
            }
            if ((this.f3186c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeMessageSize(21, this.j);
            }
            if ((this.f3186c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.k);
            }
            this.m = computeBytesSize;
            return computeBytesSize;
        }

        public p h() {
            return this.f3189f;
        }

        public boolean i() {
            return (this.f3186c & 8) == 8;
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
            return this.f3190g;
        }

        public boolean k() {
            return (this.f3186c & 16) == 16;
        }

        public long l() {
            return this.f3191h;
        }

        public boolean m() {
            return (this.f3186c & 32) == 32;
        }

        public ac n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3186c & 64) == 64;
        }

        public f p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3186c & 128) == 128;
        }

        public v r() {
            return this.k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0044a newBuilderForType() {
            return t();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: u */
        public C0044a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3186c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3186c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3186c & 4) == 4) {
                codedOutputStream.writeMessage(7, this.f3189f);
            }
            if ((this.f3186c & 8) == 8) {
                codedOutputStream.writeInt64(10, this.f3190g);
            }
            if ((this.f3186c & 16) == 16) {
                codedOutputStream.writeInt64(12, this.f3191h);
            }
            if ((this.f3186c & 32) == 32) {
                codedOutputStream.writeMessage(20, this.i);
            }
            if ((this.f3186c & 64) == 64) {
                codedOutputStream.writeMessage(21, this.j);
            }
            if ((this.f3186c & 128) == 128) {
                codedOutputStream.writeMessage(22, this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class j extends GeneratedMessageLite implements k {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<j> f3200a = new AbstractParser<j>() { // from class: com.baidu.android.pushservice.i.a.a.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public j parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new j(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final j f3201b;

        /* renamed from: c  reason: collision with root package name */
        public int f3202c;

        /* renamed from: d  reason: collision with root package name */
        public long f3203d;

        /* renamed from: e  reason: collision with root package name */
        public long f3204e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3205f;

        /* renamed from: g  reason: collision with root package name */
        public long f3206g;

        /* renamed from: h  reason: collision with root package name */
        public long f3207h;
        public Object i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0045a extends GeneratedMessageLite.Builder<j, C0045a> implements k {

            /* renamed from: a  reason: collision with root package name */
            public int f3208a;

            /* renamed from: b  reason: collision with root package name */
            public long f3209b;

            /* renamed from: c  reason: collision with root package name */
            public long f3210c;

            /* renamed from: e  reason: collision with root package name */
            public long f3212e;

            /* renamed from: f  reason: collision with root package name */
            public long f3213f;

            /* renamed from: h  reason: collision with root package name */
            public long f3215h;

            /* renamed from: d  reason: collision with root package name */
            public Object f3211d = "";

            /* renamed from: g  reason: collision with root package name */
            public Object f3214g = "";

            public C0045a() {
                g();
            }

            private void g() {
            }

            public static C0045a h() {
                return new C0045a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0045a clear() {
                super.clear();
                this.f3209b = 0L;
                int i = this.f3208a & (-2);
                this.f3208a = i;
                this.f3210c = 0L;
                int i2 = i & (-3);
                this.f3208a = i2;
                this.f3211d = "";
                int i3 = i2 & (-5);
                this.f3208a = i3;
                this.f3212e = 0L;
                int i4 = i3 & (-9);
                this.f3208a = i4;
                this.f3213f = 0L;
                int i5 = i4 & (-17);
                this.f3208a = i5;
                this.f3214g = "";
                int i6 = i5 & (-33);
                this.f3208a = i6;
                this.f3215h = 0L;
                this.f3208a = i6 & (-65);
                return this;
            }

            public C0045a a(long j) {
                this.f3208a |= 1;
                this.f3209b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0045a mergeFrom(j jVar) {
                if (jVar == j.a()) {
                    return this;
                }
                if (jVar.c()) {
                    a(jVar.d());
                }
                if (jVar.e()) {
                    b(jVar.f());
                }
                if (jVar.g()) {
                    this.f3208a |= 4;
                    this.f3211d = jVar.f3205f;
                }
                if (jVar.i()) {
                    c(jVar.j());
                }
                if (jVar.k()) {
                    d(jVar.l());
                }
                if (jVar.m()) {
                    this.f3208a |= 32;
                    this.f3214g = jVar.i;
                }
                if (jVar.o()) {
                    e(jVar.p());
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
            public C0045a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                j jVar = null;
                try {
                    try {
                        j parsePartialFrom = j.f3200a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        j jVar2 = (j) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            jVar = jVar2;
                            if (jVar != null) {
                                mergeFrom(jVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jVar != null) {
                    }
                    throw th;
                }
            }

            public C0045a a(String str) {
                if (str != null) {
                    this.f3208a |= 4;
                    this.f3211d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0045a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0045a b(long j) {
                this.f3208a |= 2;
                this.f3210c = j;
                return this;
            }

            public C0045a b(String str) {
                if (str != null) {
                    this.f3208a |= 32;
                    this.f3214g = str;
                    return this;
                }
                throw null;
            }

            public C0045a c(long j) {
                this.f3208a |= 8;
                this.f3212e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public j getDefaultInstanceForType() {
                return j.a();
            }

            public C0045a d(long j) {
                this.f3208a |= 16;
                this.f3213f = j;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public C0045a e(long j) {
                this.f3208a |= 64;
                this.f3215h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public j buildPartial() {
                j jVar = new j(this);
                int i = this.f3208a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                jVar.f3203d = this.f3209b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jVar.f3204e = this.f3210c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                jVar.f3205f = this.f3211d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                jVar.f3206g = this.f3212e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                jVar.f3207h = this.f3213f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                jVar.i = this.f3214g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                jVar.j = this.f3215h;
                jVar.f3202c = i2;
                return jVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            j jVar = new j();
            f3201b = jVar;
            jVar.t();
        }

        public j() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public j(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3202c |= 1;
                                    this.f3203d = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.f3202c |= 2;
                                    this.f3204e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3202c |= 4;
                                    this.f3205f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3202c |= 8;
                                    this.f3206g = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.f3202c |= 16;
                                    this.f3207h = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.f3202c |= 32;
                                    this.i = codedInputStream.readBytes();
                                } else if (readTag == 56) {
                                    this.f3202c |= 64;
                                    this.j = codedInputStream.readInt64();
                                } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        public j(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0045a a(j jVar) {
            return q().mergeFrom(jVar);
        }

        public static j a() {
            return f3201b;
        }

        public static C0045a q() {
            return C0045a.h();
        }

        private void t() {
            this.f3203d = 0L;
            this.f3204e = 0L;
            this.f3205f = "";
            this.f3206g = 0L;
            this.f3207h = 0L;
            this.i = "";
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public j getDefaultInstanceForType() {
            return f3201b;
        }

        public boolean c() {
            return (this.f3202c & 1) == 1;
        }

        public long d() {
            return this.f3203d;
        }

        public boolean e() {
            return (this.f3202c & 2) == 2;
        }

        public long f() {
            return this.f3204e;
        }

        public boolean g() {
            return (this.f3202c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<j> getParserForType() {
            return f3200a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.f3202c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3203d) : 0;
            if ((this.f3202c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.f3204e);
            }
            if ((this.f3202c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3202c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3206g);
            }
            if ((this.f3202c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3207h);
            }
            if ((this.f3202c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, n());
            }
            if ((this.f3202c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public ByteString h() {
            Object obj = this.f3205f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3205f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3202c & 8) == 8;
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
            return this.f3206g;
        }

        public boolean k() {
            return (this.f3202c & 16) == 16;
        }

        public long l() {
            return this.f3207h;
        }

        public boolean m() {
            return (this.f3202c & 32) == 32;
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
            return (this.f3202c & 64) == 64;
        }

        public long p() {
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
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3202c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3203d);
            }
            if ((this.f3202c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3204e);
            }
            if ((this.f3202c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3202c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3206g);
            }
            if ((this.f3202c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3207h);
            }
            if ((this.f3202c & 32) == 32) {
                codedOutputStream.writeBytes(6, n());
            }
            if ((this.f3202c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class l extends GeneratedMessageLite implements m {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<l> f3216a = new AbstractParser<l>() { // from class: com.baidu.android.pushservice.i.a.a.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new l(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final l f3217b;

        /* renamed from: c  reason: collision with root package name */
        public int f3218c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3219d;

        /* renamed from: e  reason: collision with root package name */
        public long f3220e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3221f;

        /* renamed from: g  reason: collision with root package name */
        public long f3222g;

        /* renamed from: h  reason: collision with root package name */
        public byte f3223h;
        public int i;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0046a extends GeneratedMessageLite.Builder<l, C0046a> implements m {

            /* renamed from: a  reason: collision with root package name */
            public int f3224a;

            /* renamed from: c  reason: collision with root package name */
            public long f3226c;

            /* renamed from: e  reason: collision with root package name */
            public long f3228e;

            /* renamed from: b  reason: collision with root package name */
            public Object f3225b = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3227d = "";

            public C0046a() {
                g();
            }

            private void g() {
            }

            public static C0046a h() {
                return new C0046a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0046a clear() {
                super.clear();
                this.f3225b = "";
                int i = this.f3224a & (-2);
                this.f3224a = i;
                this.f3226c = 0L;
                int i2 = i & (-3);
                this.f3224a = i2;
                this.f3227d = "";
                int i3 = i2 & (-5);
                this.f3224a = i3;
                this.f3228e = 0L;
                this.f3224a = i3 & (-9);
                return this;
            }

            public C0046a a(long j) {
                this.f3224a |= 2;
                this.f3226c = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0046a mergeFrom(l lVar) {
                if (lVar == l.a()) {
                    return this;
                }
                if (lVar.c()) {
                    this.f3224a |= 1;
                    this.f3225b = lVar.f3219d;
                }
                if (lVar.e()) {
                    a(lVar.f());
                }
                if (lVar.g()) {
                    this.f3224a |= 4;
                    this.f3227d = lVar.f3221f;
                }
                if (lVar.i()) {
                    b(lVar.j());
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
            public C0046a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                l lVar = null;
                try {
                    try {
                        l parsePartialFrom = l.f3216a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        l lVar2 = (l) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            lVar = lVar2;
                            if (lVar != null) {
                                mergeFrom(lVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (lVar != null) {
                    }
                    throw th;
                }
            }

            public C0046a a(String str) {
                if (str != null) {
                    this.f3224a |= 1;
                    this.f3225b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0046a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0046a b(long j) {
                this.f3224a |= 8;
                this.f3228e = j;
                return this;
            }

            public C0046a b(String str) {
                if (str != null) {
                    this.f3224a |= 4;
                    this.f3227d = str;
                    return this;
                }
                throw null;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public l buildPartial() {
                l lVar = new l(this);
                int i = this.f3224a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                lVar.f3219d = this.f3225b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lVar.f3220e = this.f3226c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                lVar.f3221f = this.f3227d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                lVar.f3222g = this.f3228e;
                lVar.f3218c = i2;
                return lVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            l lVar = new l();
            f3217b = lVar;
            lVar.n();
        }

        public l() {
            this.f3223h = (byte) -1;
            this.i = -1;
        }

        public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3223h = (byte) -1;
            this.i = -1;
            n();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.f3218c |= 1;
                                    this.f3219d = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.f3218c |= 2;
                                    this.f3220e = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.f3218c |= 4;
                                    this.f3221f = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.f3218c |= 8;
                                    this.f3222g = codedInputStream.readInt64();
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

        public l(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3223h = (byte) -1;
            this.i = -1;
        }

        public static C0046a a(l lVar) {
            return k().mergeFrom(lVar);
        }

        public static l a() {
            return f3217b;
        }

        public static C0046a k() {
            return C0046a.h();
        }

        private void n() {
            this.f3219d = "";
            this.f3220e = 0L;
            this.f3221f = "";
            this.f3222g = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public l getDefaultInstanceForType() {
            return f3217b;
        }

        public boolean c() {
            return (this.f3218c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3219d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3219d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3218c & 2) == 2;
        }

        public long f() {
            return this.f3220e;
        }

        public boolean g() {
            return (this.f3218c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<l> getParserForType() {
            return f3216a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.i;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3218c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3218c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt64Size(2, this.f3220e);
            }
            if ((this.f3218c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3218c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3222g);
            }
            this.i = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3221f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3221f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3218c & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3223h;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3223h = (byte) 1;
            return true;
        }

        public long j() {
            return this.f3222g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0046a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0046a newBuilderForType() {
            return k();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3218c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3218c & 2) == 2) {
                codedOutputStream.writeInt64(2, this.f3220e);
            }
            if ((this.f3218c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3218c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3222g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface m extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class n extends GeneratedMessageLite implements o {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<n> f3229a = new AbstractParser<n>() { // from class: com.baidu.android.pushservice.i.a.a.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new n(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final n f3230b;

        /* renamed from: c  reason: collision with root package name */
        public int f3231c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3232d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3233e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3234f;

        /* renamed from: g  reason: collision with root package name */
        public Object f3235g;

        /* renamed from: h  reason: collision with root package name */
        public long f3236h;
        public long i;
        public long j;
        public Object k;
        public long l;
        public byte m;
        public int n;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0047a extends GeneratedMessageLite.Builder<n, C0047a> implements o {

            /* renamed from: a  reason: collision with root package name */
            public int f3237a;

            /* renamed from: f  reason: collision with root package name */
            public long f3242f;

            /* renamed from: g  reason: collision with root package name */
            public long f3243g;

            /* renamed from: h  reason: collision with root package name */
            public long f3244h;
            public long j;

            /* renamed from: b  reason: collision with root package name */
            public Object f3238b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3239c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f3240d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f3241e = "";
            public Object i = "";

            public C0047a() {
                g();
            }

            private void g() {
            }

            public static C0047a h() {
                return new C0047a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0047a clear() {
                super.clear();
                this.f3238b = "";
                int i = this.f3237a & (-2);
                this.f3237a = i;
                this.f3239c = "";
                int i2 = i & (-3);
                this.f3237a = i2;
                this.f3240d = "";
                int i3 = i2 & (-5);
                this.f3237a = i3;
                this.f3241e = "";
                int i4 = i3 & (-9);
                this.f3237a = i4;
                this.f3242f = 0L;
                int i5 = i4 & (-17);
                this.f3237a = i5;
                this.f3243g = 0L;
                int i6 = i5 & (-33);
                this.f3237a = i6;
                this.f3244h = 0L;
                int i7 = i6 & (-65);
                this.f3237a = i7;
                this.i = "";
                int i8 = i7 & (-129);
                this.f3237a = i8;
                this.j = 0L;
                this.f3237a = i8 & (-257);
                return this;
            }

            public C0047a a(long j) {
                this.f3237a |= 16;
                this.f3242f = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0047a mergeFrom(n nVar) {
                if (nVar == n.a()) {
                    return this;
                }
                if (nVar.c()) {
                    this.f3237a |= 1;
                    this.f3238b = nVar.f3232d;
                }
                if (nVar.e()) {
                    this.f3237a |= 2;
                    this.f3239c = nVar.f3233e;
                }
                if (nVar.g()) {
                    this.f3237a |= 4;
                    this.f3240d = nVar.f3234f;
                }
                if (nVar.i()) {
                    this.f3237a |= 8;
                    this.f3241e = nVar.f3235g;
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
                    this.f3237a |= 128;
                    this.i = nVar.k;
                }
                if (nVar.s()) {
                    d(nVar.t());
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
            public C0047a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                n nVar = null;
                try {
                    try {
                        n parsePartialFrom = n.f3229a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        n nVar2 = (n) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            nVar = nVar2;
                            if (nVar != null) {
                                mergeFrom(nVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (nVar != null) {
                    }
                    throw th;
                }
            }

            public C0047a a(String str) {
                if (str != null) {
                    this.f3237a |= 1;
                    this.f3238b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0047a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0047a b(long j) {
                this.f3237a |= 32;
                this.f3243g = j;
                return this;
            }

            public C0047a b(String str) {
                if (str != null) {
                    this.f3237a |= 2;
                    this.f3239c = str;
                    return this;
                }
                throw null;
            }

            public C0047a c(long j) {
                this.f3237a |= 64;
                this.f3244h = j;
                return this;
            }

            public C0047a c(String str) {
                if (str != null) {
                    this.f3237a |= 4;
                    this.f3240d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public n getDefaultInstanceForType() {
                return n.a();
            }

            public C0047a d(long j) {
                this.f3237a |= 256;
                this.j = j;
                return this;
            }

            public C0047a d(String str) {
                if (str != null) {
                    this.f3237a |= 8;
                    this.f3241e = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: d */
            public n build() {
                n buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public C0047a e(String str) {
                if (str != null) {
                    this.f3237a |= 128;
                    this.i = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public n buildPartial() {
                n nVar = new n(this);
                int i = this.f3237a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                nVar.f3232d = this.f3238b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                nVar.f3233e = this.f3239c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                nVar.f3234f = this.f3240d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                nVar.f3235g = this.f3241e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                nVar.f3236h = this.f3242f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                nVar.i = this.f3243g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                nVar.j = this.f3244h;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                nVar.k = this.i;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                nVar.l = this.j;
                nVar.f3231c = i2;
                return nVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            n nVar = new n();
            f3230b = nVar;
            nVar.x();
        }

        public n() {
            this.m = (byte) -1;
            this.n = -1;
        }

        public n(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.m = (byte) -1;
            this.n = -1;
            x();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3231c |= 1;
                                this.f3232d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3231c |= 2;
                                this.f3233e = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.f3231c |= 4;
                                this.f3234f = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.f3231c |= 8;
                                this.f3235g = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.f3231c |= 16;
                                this.f3236h = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.f3231c |= 32;
                                this.i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3231c |= 64;
                                this.j = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.f3231c |= 128;
                                this.k = codedInputStream.readBytes();
                            } else if (readTag == 72) {
                                this.f3231c |= 256;
                                this.l = codedInputStream.readInt64();
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

        public n(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.m = (byte) -1;
            this.n = -1;
        }

        public static C0047a a(n nVar) {
            return u().mergeFrom(nVar);
        }

        public static n a() {
            return f3230b;
        }

        public static C0047a u() {
            return C0047a.h();
        }

        private void x() {
            this.f3232d = "";
            this.f3233e = "";
            this.f3234f = "";
            this.f3235g = "";
            this.f3236h = 0L;
            this.i = 0L;
            this.j = 0L;
            this.k = "";
            this.l = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public n getDefaultInstanceForType() {
            return f3230b;
        }

        public boolean c() {
            return (this.f3231c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3232d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3232d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3231c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3233e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3233e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3231c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<n> getParserForType() {
            return f3229a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.n;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3231c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3231c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3231c & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, h());
            }
            if ((this.f3231c & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, j());
            }
            if ((this.f3231c & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.f3236h);
            }
            if ((this.f3231c & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.i);
            }
            if ((this.f3231c & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.j);
            }
            if ((this.f3231c & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, r());
            }
            if ((this.f3231c & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeInt64Size(9, this.l);
            }
            this.n = computeBytesSize;
            return computeBytesSize;
        }

        public ByteString h() {
            Object obj = this.f3234f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3234f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3231c & 8) == 8;
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
            Object obj = this.f3235g;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3235g = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean k() {
            return (this.f3231c & 16) == 16;
        }

        public long l() {
            return this.f3236h;
        }

        public boolean m() {
            return (this.f3231c & 32) == 32;
        }

        public long n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3231c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        public boolean q() {
            return (this.f3231c & 128) == 128;
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
            return (this.f3231c & 256) == 256;
        }

        public long t() {
            return this.l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: v */
        public C0047a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: w */
        public C0047a newBuilderForType() {
            return u();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3231c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3231c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3231c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
            if ((this.f3231c & 8) == 8) {
                codedOutputStream.writeBytes(4, j());
            }
            if ((this.f3231c & 16) == 16) {
                codedOutputStream.writeInt64(5, this.f3236h);
            }
            if ((this.f3231c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.i);
            }
            if ((this.f3231c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
            if ((this.f3231c & 128) == 128) {
                codedOutputStream.writeBytes(8, r());
            }
            if ((this.f3231c & 256) == 256) {
                codedOutputStream.writeInt64(9, this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface o extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class p extends GeneratedMessageLite implements q {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<p> f3245a = new AbstractParser<p>() { // from class: com.baidu.android.pushservice.i.a.a.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new p(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final p f3246b;

        /* renamed from: c  reason: collision with root package name */
        public int f3247c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3248d;

        /* renamed from: e  reason: collision with root package name */
        public byte f3249e;

        /* renamed from: f  reason: collision with root package name */
        public int f3250f;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0048a extends GeneratedMessageLite.Builder<p, C0048a> implements q {

            /* renamed from: a  reason: collision with root package name */
            public int f3251a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3252b = "";

            public C0048a() {
                h();
            }

            private void h() {
            }

            public static C0048a i() {
                return new C0048a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0048a clear() {
                super.clear();
                this.f3252b = "";
                this.f3251a &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0048a mergeFrom(p pVar) {
                if (pVar != p.a() && pVar.c()) {
                    this.f3251a |= 1;
                    this.f3252b = pVar.f3248d;
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
            public C0048a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                p pVar = null;
                try {
                    try {
                        p parsePartialFrom = p.f3245a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        p pVar2 = (p) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            pVar = pVar2;
                            if (pVar != null) {
                                mergeFrom(pVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (pVar != null) {
                    }
                    throw th;
                }
            }

            public C0048a a(String str) {
                if (str != null) {
                    this.f3251a |= 1;
                    this.f3252b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0048a clone() {
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public p buildPartial() {
                p pVar = new p(this);
                int i = (this.f3251a & 1) != 1 ? 0 : 1;
                pVar.f3248d = this.f3252b;
                pVar.f3247c = i;
                return pVar;
            }

            public boolean f() {
                return (this.f3251a & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return f();
            }
        }

        static {
            p pVar = new p();
            f3246b = pVar;
            pVar.h();
        }

        public p() {
            this.f3249e = (byte) -1;
            this.f3250f = -1;
        }

        public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3249e = (byte) -1;
            this.f3250f = -1;
            h();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 34) {
                                this.f3247c |= 1;
                                this.f3248d = codedInputStream.readBytes();
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

        public p(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3249e = (byte) -1;
            this.f3250f = -1;
        }

        public static C0048a a(p pVar) {
            return e().mergeFrom(pVar);
        }

        public static p a() {
            return f3246b;
        }

        public static C0048a e() {
            return C0048a.i();
        }

        private void h() {
            this.f3248d = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public p getDefaultInstanceForType() {
            return f3246b;
        }

        public boolean c() {
            return (this.f3247c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3248d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3248d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: f */
        public C0048a newBuilderForType() {
            return e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: g */
        public C0048a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<p> getParserForType() {
            return f3245a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3250f;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3247c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, d()) : 0;
            this.f3250f = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3249e;
            if (b2 != -1) {
                return b2 == 1;
            } else if (c()) {
                this.f3249e = (byte) 1;
                return true;
            } else {
                this.f3249e = (byte) 0;
                return false;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3247c & 1) == 1) {
                codedOutputStream.writeBytes(4, d());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface q extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class r extends GeneratedMessageLite implements s {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<r> f3253a = new AbstractParser<r>() { // from class: com.baidu.android.pushservice.i.a.a.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new r(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final r f3254b;

        /* renamed from: c  reason: collision with root package name */
        public int f3255c;

        /* renamed from: d  reason: collision with root package name */
        public int f3256d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3257e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3258f;

        /* renamed from: g  reason: collision with root package name */
        public byte f3259g;

        /* renamed from: h  reason: collision with root package name */
        public int f3260h;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0049a extends GeneratedMessageLite.Builder<r, C0049a> implements s {

            /* renamed from: a  reason: collision with root package name */
            public int f3261a;

            /* renamed from: b  reason: collision with root package name */
            public int f3262b = 7399;

            /* renamed from: c  reason: collision with root package name */
            public Object f3263c = "push_im_client";

            /* renamed from: d  reason: collision with root package name */
            public Object f3264d = "phonebaidu";

            public C0049a() {
                g();
            }

            private void g() {
            }

            public static C0049a h() {
                return new C0049a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0049a clear() {
                super.clear();
                this.f3262b = 7399;
                int i = this.f3261a & (-2);
                this.f3261a = i;
                this.f3263c = "push_im_client";
                int i2 = i & (-3);
                this.f3261a = i2;
                this.f3264d = "phonebaidu";
                this.f3261a = i2 & (-5);
                return this;
            }

            public C0049a a(int i) {
                this.f3261a |= 1;
                this.f3262b = i;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0049a mergeFrom(r rVar) {
                if (rVar == r.a()) {
                    return this;
                }
                if (rVar.c()) {
                    a(rVar.d());
                }
                if (rVar.e()) {
                    this.f3261a |= 2;
                    this.f3263c = rVar.f3257e;
                }
                if (rVar.g()) {
                    this.f3261a |= 4;
                    this.f3264d = rVar.f3258f;
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
            public C0049a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                r rVar = null;
                try {
                    try {
                        r parsePartialFrom = r.f3253a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        r rVar2 = (r) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            rVar = rVar2;
                            if (rVar != null) {
                                mergeFrom(rVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0049a clone() {
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public r buildPartial() {
                r rVar = new r(this);
                int i = this.f3261a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rVar.f3256d = this.f3262b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rVar.f3257e = this.f3263c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rVar.f3258f = this.f3264d;
                rVar.f3255c = i2;
                return rVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            r rVar = new r();
            f3254b = rVar;
            rVar.l();
        }

        public r() {
            this.f3259g = (byte) -1;
            this.f3260h = -1;
        }

        public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3259g = (byte) -1;
            this.f3260h = -1;
            l();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.f3255c |= 1;
                                    this.f3256d = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.f3255c |= 2;
                                    this.f3257e = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.f3255c |= 4;
                                    this.f3258f = codedInputStream.readBytes();
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

        public r(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3259g = (byte) -1;
            this.f3260h = -1;
        }

        public static C0049a a(r rVar) {
            return i().mergeFrom(rVar);
        }

        public static r a() {
            return f3254b;
        }

        public static C0049a i() {
            return C0049a.h();
        }

        private void l() {
            this.f3256d = 7399;
            this.f3257e = "push_im_client";
            this.f3258f = "phonebaidu";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public r getDefaultInstanceForType() {
            return f3254b;
        }

        public boolean c() {
            return (this.f3255c & 1) == 1;
        }

        public int d() {
            return this.f3256d;
        }

        public boolean e() {
            return (this.f3255c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3257e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3257e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3255c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<r> getParserForType() {
            return f3253a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3260h;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.f3255c & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f3256d) : 0;
            if ((this.f3255c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3255c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, h());
            }
            this.f3260h = computeInt32Size;
            return computeInt32Size;
        }

        public ByteString h() {
            Object obj = this.f3258f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3258f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3259g;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3259g = (byte) 1;
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: j */
        public C0049a toBuilder() {
            return a(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: k */
        public C0049a newBuilderForType() {
            return i();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3255c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.f3256d);
            }
            if ((this.f3255c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3255c & 4) == 4) {
                codedOutputStream.writeBytes(3, h());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface s extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class t extends GeneratedMessageLite implements u {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<t> f3265a = new AbstractParser<t>() { // from class: com.baidu.android.pushservice.i.a.a.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new t(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final t f3266b;

        /* renamed from: c  reason: collision with root package name */
        public int f3267c;

        /* renamed from: d  reason: collision with root package name */
        public long f3268d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3269e;

        /* renamed from: f  reason: collision with root package name */
        public long f3270f;

        /* renamed from: g  reason: collision with root package name */
        public long f3271g;

        /* renamed from: h  reason: collision with root package name */
        public Object f3272h;
        public long i;
        public long j;
        public byte k;
        public int l;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$t$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0050a extends GeneratedMessageLite.Builder<t, C0050a> implements u {

            /* renamed from: a  reason: collision with root package name */
            public int f3273a;

            /* renamed from: b  reason: collision with root package name */
            public long f3274b;

            /* renamed from: d  reason: collision with root package name */
            public long f3276d;

            /* renamed from: e  reason: collision with root package name */
            public long f3277e;

            /* renamed from: g  reason: collision with root package name */
            public long f3279g;

            /* renamed from: h  reason: collision with root package name */
            public long f3280h;

            /* renamed from: c  reason: collision with root package name */
            public Object f3275c = "";

            /* renamed from: f  reason: collision with root package name */
            public Object f3278f = "";

            public C0050a() {
                g();
            }

            private void g() {
            }

            public static C0050a h() {
                return new C0050a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0050a clear() {
                super.clear();
                this.f3274b = 0L;
                int i = this.f3273a & (-2);
                this.f3273a = i;
                this.f3275c = "";
                int i2 = i & (-3);
                this.f3273a = i2;
                this.f3276d = 0L;
                int i3 = i2 & (-5);
                this.f3273a = i3;
                this.f3277e = 0L;
                int i4 = i3 & (-9);
                this.f3273a = i4;
                this.f3278f = "";
                int i5 = i4 & (-17);
                this.f3273a = i5;
                this.f3279g = 0L;
                int i6 = i5 & (-33);
                this.f3273a = i6;
                this.f3280h = 0L;
                this.f3273a = i6 & (-65);
                return this;
            }

            public C0050a a(long j) {
                this.f3273a |= 1;
                this.f3274b = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0050a mergeFrom(t tVar) {
                if (tVar == t.a()) {
                    return this;
                }
                if (tVar.c()) {
                    a(tVar.d());
                }
                if (tVar.e()) {
                    this.f3273a |= 2;
                    this.f3275c = tVar.f3269e;
                }
                if (tVar.g()) {
                    b(tVar.h());
                }
                if (tVar.i()) {
                    c(tVar.j());
                }
                if (tVar.k()) {
                    this.f3273a |= 16;
                    this.f3278f = tVar.f3272h;
                }
                if (tVar.m()) {
                    d(tVar.n());
                }
                if (tVar.o()) {
                    e(tVar.p());
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
            public C0050a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                t tVar = null;
                try {
                    try {
                        t parsePartialFrom = t.f3265a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        t tVar2 = (t) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            tVar = tVar2;
                            if (tVar != null) {
                                mergeFrom(tVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (tVar != null) {
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0050a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0050a b(long j) {
                this.f3273a |= 4;
                this.f3276d = j;
                return this;
            }

            public C0050a c(long j) {
                this.f3273a |= 8;
                this.f3277e = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            /* renamed from: c */
            public t getDefaultInstanceForType() {
                return t.a();
            }

            public C0050a d(long j) {
                this.f3273a |= 32;
                this.f3279g = j;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public C0050a e(long j) {
                this.f3273a |= 64;
                this.f3280h = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public t buildPartial() {
                t tVar = new t(this);
                int i = this.f3273a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                tVar.f3268d = this.f3274b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                tVar.f3269e = this.f3275c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                tVar.f3270f = this.f3276d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                tVar.f3271g = this.f3277e;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                tVar.f3272h = this.f3278f;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                tVar.i = this.f3279g;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                tVar.j = this.f3280h;
                tVar.f3267c = i2;
                return tVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            t tVar = new t();
            f3266b = tVar;
            tVar.t();
        }

        public t() {
            this.k = (byte) -1;
            this.l = -1;
        }

        public t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.k = (byte) -1;
            this.l = -1;
            t();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.f3267c |= 1;
                                this.f3268d = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.f3267c |= 2;
                                this.f3269e = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.f3267c |= 4;
                                this.f3270f = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.f3267c |= 8;
                                this.f3271g = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.f3267c |= 16;
                                this.f3272h = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.f3267c |= 32;
                                this.i = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.f3267c |= 64;
                                this.j = codedInputStream.readInt64();
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

        public t(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.k = (byte) -1;
            this.l = -1;
        }

        public static C0050a a(t tVar) {
            return q().mergeFrom(tVar);
        }

        public static t a() {
            return f3266b;
        }

        public static C0050a q() {
            return C0050a.h();
        }

        private void t() {
            this.f3268d = 0L;
            this.f3269e = "";
            this.f3270f = 0L;
            this.f3271g = 0L;
            this.f3272h = "";
            this.i = 0L;
            this.j = 0L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public t getDefaultInstanceForType() {
            return f3266b;
        }

        public boolean c() {
            return (this.f3267c & 1) == 1;
        }

        public long d() {
            return this.f3268d;
        }

        public boolean e() {
            return (this.f3267c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3269e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3269e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean g() {
            return (this.f3267c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<t> getParserForType() {
            return f3265a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.l;
            if (i != -1) {
                return i;
            }
            int computeInt64Size = (this.f3267c & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3268d) : 0;
            if ((this.f3267c & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, f());
            }
            if ((this.f3267c & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.f3270f);
            }
            if ((this.f3267c & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3271g);
            }
            if ((this.f3267c & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, l());
            }
            if ((this.f3267c & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.i);
            }
            if ((this.f3267c & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.j);
            }
            this.l = computeInt64Size;
            return computeInt64Size;
        }

        public long h() {
            return this.f3270f;
        }

        public boolean i() {
            return (this.f3267c & 8) == 8;
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
            return this.f3271g;
        }

        public boolean k() {
            return (this.f3267c & 16) == 16;
        }

        public ByteString l() {
            Object obj = this.f3272h;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3272h = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean m() {
            return (this.f3267c & 32) == 32;
        }

        public long n() {
            return this.i;
        }

        public boolean o() {
            return (this.f3267c & 64) == 64;
        }

        public long p() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: r */
        public C0050a newBuilderForType() {
            return q();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: s */
        public C0050a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3267c & 1) == 1) {
                codedOutputStream.writeInt64(1, this.f3268d);
            }
            if ((this.f3267c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
            if ((this.f3267c & 4) == 4) {
                codedOutputStream.writeInt64(3, this.f3270f);
            }
            if ((this.f3267c & 8) == 8) {
                codedOutputStream.writeInt64(4, this.f3271g);
            }
            if ((this.f3267c & 16) == 16) {
                codedOutputStream.writeBytes(5, l());
            }
            if ((this.f3267c & 32) == 32) {
                codedOutputStream.writeInt64(6, this.i);
            }
            if ((this.f3267c & 64) == 64) {
                codedOutputStream.writeInt64(7, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface u extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public static final class v extends GeneratedMessageLite implements w {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<v> f3281a = new AbstractParser<v>() { // from class: com.baidu.android.pushservice.i.a.a.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new v(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final v f3282b;

        /* renamed from: c  reason: collision with root package name */
        public int f3283c;

        /* renamed from: d  reason: collision with root package name */
        public Object f3284d;

        /* renamed from: e  reason: collision with root package name */
        public Object f3285e;

        /* renamed from: f  reason: collision with root package name */
        public byte f3286f;

        /* renamed from: g  reason: collision with root package name */
        public int f3287g;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$v$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0051a extends GeneratedMessageLite.Builder<v, C0051a> implements w {

            /* renamed from: a  reason: collision with root package name */
            public int f3288a;

            /* renamed from: b  reason: collision with root package name */
            public Object f3289b = "";

            /* renamed from: c  reason: collision with root package name */
            public Object f3290c = "";

            public C0051a() {
                g();
            }

            private void g() {
            }

            public static C0051a h() {
                return new C0051a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0051a clear() {
                super.clear();
                this.f3289b = "";
                int i = this.f3288a & (-2);
                this.f3288a = i;
                this.f3290c = "";
                this.f3288a = i & (-3);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0051a mergeFrom(v vVar) {
                if (vVar == v.a()) {
                    return this;
                }
                if (vVar.c()) {
                    this.f3288a |= 1;
                    this.f3289b = vVar.f3284d;
                }
                if (vVar.e()) {
                    this.f3288a |= 2;
                    this.f3290c = vVar.f3285e;
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
            public C0051a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                v vVar = null;
                try {
                    try {
                        v parsePartialFrom = v.f3281a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        v vVar2 = (v) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            vVar = vVar2;
                            if (vVar != null) {
                                mergeFrom(vVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (vVar != null) {
                    }
                    throw th;
                }
            }

            public C0051a a(String str) {
                if (str != null) {
                    this.f3288a |= 1;
                    this.f3289b = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0051a clone() {
                return h().mergeFrom(buildPartial());
            }

            public C0051a b(String str) {
                if (str != null) {
                    this.f3288a |= 2;
                    this.f3290c = str;
                    return this;
                }
                throw null;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public v buildPartial() {
                v vVar = new v(this);
                int i = this.f3288a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                vVar.f3284d = this.f3289b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                vVar.f3285e = this.f3290c;
                vVar.f3283c = i2;
                return vVar;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }
        }

        static {
            v vVar = new v();
            f3282b = vVar;
            vVar.j();
        }

        public v() {
            this.f3286f = (byte) -1;
            this.f3287g = -1;
        }

        public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.f3286f = (byte) -1;
            this.f3287g = -1;
            j();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.f3283c |= 1;
                                this.f3284d = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.f3283c |= 2;
                                this.f3285e = codedInputStream.readBytes();
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

        public v(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.f3286f = (byte) -1;
            this.f3287g = -1;
        }

        public static C0051a a(v vVar) {
            return g().mergeFrom(vVar);
        }

        public static v a() {
            return f3282b;
        }

        public static C0051a g() {
            return C0051a.h();
        }

        private void j() {
            this.f3284d = "";
            this.f3285e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public v getDefaultInstanceForType() {
            return f3282b;
        }

        public boolean c() {
            return (this.f3283c & 1) == 1;
        }

        public ByteString d() {
            Object obj = this.f3284d;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3284d = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean e() {
            return (this.f3283c & 2) == 2;
        }

        public ByteString f() {
            Object obj = this.f3285e;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3285e = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<v> getParserForType() {
            return f3281a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f3287g;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.f3283c & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, d()) : 0;
            if ((this.f3283c & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, f());
            }
            this.f3287g = computeBytesSize;
            return computeBytesSize;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: h */
        public C0051a newBuilderForType() {
            return g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: i */
        public C0051a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f3286f;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.f3286f = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3283c & 1) == 1) {
                codedOutputStream.writeBytes(1, d());
            }
            if ((this.f3283c & 2) == 2) {
                codedOutputStream.writeBytes(2, f());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface w extends MessageLiteOrBuilder {
    }

    /* loaded from: classes.dex */
    public enum x implements Internal.EnumLite {
        OS_TYPE_UNKNWON(0),
        IOS(1),
        ANDROID(2),
        WINDOWSPHONE(3);
        

        /* renamed from: e  reason: collision with root package name */
        public final int f3296e;

        x(int i) {
            this.f3296e = i;
        }

        public static x a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return WINDOWSPHONE;
                    }
                    return ANDROID;
                }
                return IOS;
            }
            return OS_TYPE_UNKNWON;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.f3296e;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends GeneratedMessageLite implements z {

        /* renamed from: a  reason: collision with root package name */
        public static Parser<y> f3297a = new AbstractParser<y>() { // from class: com.baidu.android.pushservice.i.a.a.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public y parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new y(codedInputStream, extensionRegistryLite);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final y f3298b;

        /* renamed from: c  reason: collision with root package name */
        public int f3299c;

        /* renamed from: d  reason: collision with root package name */
        public r f3300d;

        /* renamed from: e  reason: collision with root package name */
        public h f3301e;

        /* renamed from: f  reason: collision with root package name */
        public Object f3302f;

        /* renamed from: g  reason: collision with root package name */
        public long f3303g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f3304h;
        public byte i;
        public int j;

        /* renamed from: com.baidu.android.pushservice.i.a.a.a$y$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0052a extends GeneratedMessageLite.Builder<y, C0052a> implements z {

            /* renamed from: a  reason: collision with root package name */
            public int f3305a;

            /* renamed from: e  reason: collision with root package name */
            public long f3309e;

            /* renamed from: b  reason: collision with root package name */
            public r f3306b = r.a();

            /* renamed from: c  reason: collision with root package name */
            public h f3307c = h.a();

            /* renamed from: d  reason: collision with root package name */
            public Object f3308d = "";

            /* renamed from: f  reason: collision with root package name */
            public List<c> f3310f = Collections.emptyList();

            public C0052a() {
                i();
            }

            private void i() {
            }

            public static C0052a j() {
                return new C0052a();
            }

            private void k() {
                if ((this.f3305a & 16) != 16) {
                    this.f3310f = new ArrayList(this.f3310f);
                    this.f3305a |= 16;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a */
            public C0052a clear() {
                super.clear();
                this.f3306b = r.a();
                this.f3305a &= -2;
                this.f3307c = h.a();
                int i = this.f3305a & (-3);
                this.f3305a = i;
                this.f3308d = "";
                int i2 = i & (-5);
                this.f3305a = i2;
                this.f3309e = 0L;
                this.f3305a = i2 & (-9);
                this.f3310f = Collections.emptyList();
                this.f3305a &= -17;
                return this;
            }

            public C0052a a(long j) {
                this.f3305a |= 8;
                this.f3309e = j;
                return this;
            }

            public C0052a a(h hVar) {
                if (hVar != null) {
                    this.f3307c = hVar;
                    this.f3305a |= 2;
                    return this;
                }
                throw null;
            }

            public C0052a a(r rVar) {
                if ((this.f3305a & 1) == 1 && this.f3306b != r.a()) {
                    rVar = r.a(this.f3306b).mergeFrom(rVar).buildPartial();
                }
                this.f3306b = rVar;
                this.f3305a |= 1;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public C0052a mergeFrom(y yVar) {
                if (yVar == y.a()) {
                    return this;
                }
                if (yVar.c()) {
                    a(yVar.d());
                }
                if (yVar.e()) {
                    b(yVar.f());
                }
                if (yVar.g()) {
                    this.f3305a |= 4;
                    this.f3308d = yVar.f3302f;
                }
                if (yVar.i()) {
                    a(yVar.j());
                }
                if (!yVar.f3304h.isEmpty()) {
                    if (this.f3310f.isEmpty()) {
                        this.f3310f = yVar.f3304h;
                        this.f3305a &= -17;
                    } else {
                        k();
                        this.f3310f.addAll(yVar.f3304h);
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
            public C0052a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                y yVar = null;
                try {
                    try {
                        y parsePartialFrom = y.f3297a.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        y yVar2 = (y) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            yVar = yVar2;
                            if (yVar != null) {
                                mergeFrom(yVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (yVar != null) {
                    }
                    throw th;
                }
            }

            public C0052a a(Iterable<? extends c> iterable) {
                k();
                AbstractMessageLite.Builder.addAll(iterable, this.f3310f);
                return this;
            }

            public C0052a a(String str) {
                if (str != null) {
                    this.f3305a |= 4;
                    this.f3308d = str;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: b */
            public C0052a clone() {
                return j().mergeFrom(buildPartial());
            }

            public C0052a b(h hVar) {
                if ((this.f3305a & 2) == 2 && this.f3307c != h.a()) {
                    hVar = h.a(this.f3307c).mergeFrom(hVar).buildPartial();
                }
                this.f3307c = hVar;
                this.f3305a |= 2;
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
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            public y buildPartial() {
                y yVar = new y(this);
                int i = this.f3305a;
                int i2 = (i & 1) != 1 ? 0 : 1;
                yVar.f3300d = this.f3306b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                yVar.f3301e = this.f3307c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                yVar.f3302f = this.f3308d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                yVar.f3303g = this.f3309e;
                if ((this.f3305a & 16) == 16) {
                    this.f3310f = Collections.unmodifiableList(this.f3310f);
                    this.f3305a &= -17;
                }
                yVar.f3304h = this.f3310f;
                yVar.f3299c = i2;
                return yVar;
            }

            public boolean f() {
                return (this.f3305a & 2) == 2;
            }

            public h g() {
                return this.f3307c;
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
            y yVar = new y();
            f3298b = yVar;
            yVar.n();
        }

        public y() {
            this.i = (byte) -1;
            this.j = -1;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.util.List<com.baidu.android.pushservice.i.a.a.a$c> */
        /* JADX WARN: Multi-variable type inference failed */
        public y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i;
            this.i = (byte) -1;
            this.j = -1;
            n();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                if (z) {
                    break;
                }
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        int i2 = 1;
                        if (readTag != 0) {
                            if (readTag == 202) {
                                r.C0049a builder = (this.f3299c & 1) == 1 ? this.f3300d.toBuilder() : null;
                                r rVar = (r) codedInputStream.readMessage(r.f3253a, extensionRegistryLite);
                                this.f3300d = rVar;
                                if (builder != null) {
                                    builder.mergeFrom(rVar);
                                    this.f3300d = builder.buildPartial();
                                }
                                i = this.f3299c;
                            } else if (readTag == 330) {
                                i2 = 2;
                                h.C0044a builder2 = (this.f3299c & 2) == 2 ? this.f3301e.toBuilder() : null;
                                h hVar = (h) codedInputStream.readMessage(h.f3184a, extensionRegistryLite);
                                this.f3301e = hVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(hVar);
                                    this.f3301e = builder2.buildPartial();
                                }
                                i = this.f3299c;
                            } else if (readTag == 1042) {
                                this.f3299c |= 4;
                                this.f3302f = codedInputStream.readBytes();
                            } else if (readTag == 1048) {
                                this.f3299c |= 8;
                                this.f3303g = codedInputStream.readInt64();
                            } else if (readTag == 1058) {
                                if (!(z2 & true)) {
                                    this.f3304h = new ArrayList();
                                    z2 |= true;
                                }
                                this.f3304h.add(codedInputStream.readMessage(c.f3148a, extensionRegistryLite));
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                            this.f3299c = i | i2;
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.f3304h = Collections.unmodifiableList(this.f3304h);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public y(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.i = (byte) -1;
            this.j = -1;
        }

        public static C0052a a(y yVar) {
            return k().mergeFrom(yVar);
        }

        public static y a() {
            return f3298b;
        }

        public static C0052a k() {
            return C0052a.j();
        }

        private void n() {
            this.f3300d = r.a();
            this.f3301e = h.a();
            this.f3302f = "";
            this.f3303g = 0L;
            this.f3304h = Collections.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: b */
        public y getDefaultInstanceForType() {
            return f3298b;
        }

        public boolean c() {
            return (this.f3299c & 1) == 1;
        }

        public r d() {
            return this.f3300d;
        }

        public boolean e() {
            return (this.f3299c & 2) == 2;
        }

        public h f() {
            return this.f3301e;
        }

        public boolean g() {
            return (this.f3299c & 4) == 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<y> getParserForType() {
            return f3297a;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.j;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = (this.f3299c & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.f3300d) + 0 : 0;
            if ((this.f3299c & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f3301e);
            }
            if ((this.f3299c & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3299c & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3303g);
            }
            for (int i2 = 0; i2 < this.f3304h.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.f3304h.get(i2));
            }
            this.j = computeMessageSize;
            return computeMessageSize;
        }

        public ByteString h() {
            Object obj = this.f3302f;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.f3302f = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean i() {
            return (this.f3299c & 8) == 8;
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
            return this.f3303g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: l */
        public C0052a newBuilderForType() {
            return k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        /* renamed from: m */
        public C0052a toBuilder() {
            return a(this);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.f3299c & 1) == 1) {
                codedOutputStream.writeMessage(25, this.f3300d);
            }
            if ((this.f3299c & 2) == 2) {
                codedOutputStream.writeMessage(41, this.f3301e);
            }
            if ((this.f3299c & 4) == 4) {
                codedOutputStream.writeBytes(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, h());
            }
            if ((this.f3299c & 8) == 8) {
                codedOutputStream.writeInt64(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, this.f3303g);
            }
            for (int i = 0; i < this.f3304h.size(); i++) {
                codedOutputStream.writeMessage(132, this.f3304h.get(i));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface z extends MessageLiteOrBuilder {
    }
}
