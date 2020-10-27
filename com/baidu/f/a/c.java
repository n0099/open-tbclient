package com.baidu.f.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class c extends MessageMicro {
    private boolean arm;
    private boolean aro;
    private String arn = "";
    private String arp = "";
    private List<a> arq = Collections.emptyList();
    private int aqI = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqz;
        private boolean arr;
        private boolean art;
        private int ars = 0;
        private int aru = 0;
        private String aqA = "";
        private int aqI = -1;

        public a ca(int i) {
            this.arr = true;
            this.ars = i;
            return this;
        }

        public a cb(int i) {
            this.art = true;
            this.aru = i;
            return this;
        }

        public a er(String str) {
            this.aqz = true;
            this.aqA = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqI < 0) {
                getSerializedSize();
            }
            return this.aqI;
        }

        public String getName() {
            return this.aqA;
        }

        public int getOffset() {
            return this.ars;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = wo() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset()) : 0;
            if (wq()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, wp());
            }
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            this.aqI = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.aqz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.MessageMicro
        /* renamed from: i */
        public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        ca(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        cb(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        er(codedInputStreamMicro.readString());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public boolean wo() {
            return this.arr;
        }

        public int wp() {
            return this.aru;
        }

        public boolean wq() {
            return this.art;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (wo()) {
                codedOutputStreamMicro.writeInt32(1, getOffset());
            }
            if (wq()) {
                codedOutputStreamMicro.writeInt32(2, wp());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
        }
    }

    public static c w(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (c) new c().mergeFrom(bArr);
    }

    public c a(a aVar) {
        if (aVar != null) {
            if (this.arq.isEmpty()) {
                this.arq = new ArrayList();
            }
            this.arq.add(aVar);
        }
        return this;
    }

    public a bZ(int i) {
        return this.arq.get(i);
    }

    public c ep(String str) {
        this.arm = true;
        this.arn = str;
        return this;
    }

    public c eq(String str) {
        this.aro = true;
        this.arp = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqI < 0) {
            getSerializedSize();
        }
        return this.aqI;
    }

    public String getMd5() {
        return this.arn;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeStringSize = wj() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getMd5()) : 0;
        if (wl()) {
            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wk());
        }
        Iterator<a> it = wm().iterator();
        while (true) {
            int i = computeStringSize;
            if (!it.hasNext()) {
                this.aqI = i;
                return i;
            }
            computeStringSize = CodedOutputStreamMicro.computeMessageSize(3, it.next()) + i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.micro.MessageMicro
    /* renamed from: h */
    public c mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    ep(codedInputStreamMicro.readString());
                    break;
                case 18:
                    eq(codedInputStreamMicro.readString());
                    break;
                case 26:
                    a aVar = new a();
                    codedInputStreamMicro.readMessage(aVar);
                    a(aVar);
                    break;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    public boolean wj() {
        return this.arm;
    }

    public String wk() {
        return this.arp;
    }

    public boolean wl() {
        return this.aro;
    }

    public List<a> wm() {
        return this.arq;
    }

    public int wn() {
        return this.arq.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (wj()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        if (wl()) {
            codedOutputStreamMicro.writeString(2, wk());
        }
        for (a aVar : wm()) {
            codedOutputStreamMicro.writeMessage(3, aVar);
        }
    }
}
