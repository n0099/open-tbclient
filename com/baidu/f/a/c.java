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
    private boolean arl;
    private boolean arn;
    private String arm = "";
    private String aro = "";
    private List<a> arp = Collections.emptyList();
    private int aqH = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqy;
        private boolean arq;
        private boolean ars;
        private int arr = 0;
        private int art = 0;
        private String aqz = "";
        private int aqH = -1;

        public a ca(int i) {
            this.arq = true;
            this.arr = i;
            return this;
        }

        public a cb(int i) {
            this.ars = true;
            this.art = i;
            return this;
        }

        public a er(String str) {
            this.aqy = true;
            this.aqz = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqH < 0) {
                getSerializedSize();
            }
            return this.aqH;
        }

        public String getName() {
            return this.aqz;
        }

        public int getOffset() {
            return this.arr;
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
            this.aqH = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.aqy;
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
            return this.arq;
        }

        public int wp() {
            return this.art;
        }

        public boolean wq() {
            return this.ars;
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
            if (this.arp.isEmpty()) {
                this.arp = new ArrayList();
            }
            this.arp.add(aVar);
        }
        return this;
    }

    public a bZ(int i) {
        return this.arp.get(i);
    }

    public c ep(String str) {
        this.arl = true;
        this.arm = str;
        return this;
    }

    public c eq(String str) {
        this.arn = true;
        this.aro = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqH < 0) {
            getSerializedSize();
        }
        return this.aqH;
    }

    public String getMd5() {
        return this.arm;
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
                this.aqH = i;
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
        return this.arl;
    }

    public String wk() {
        return this.aro;
    }

    public boolean wl() {
        return this.arn;
    }

    public List<a> wm() {
        return this.arp;
    }

    public int wn() {
        return this.arp.size();
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
