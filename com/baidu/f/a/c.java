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
/* loaded from: classes3.dex */
public final class c extends MessageMicro {
    private boolean aqC;
    private boolean aqE;
    private String aqD = "";
    private String aqF = "";
    private List<a> aqG = Collections.emptyList();
    private int apY = -1;

    /* loaded from: classes3.dex */
    public static final class a extends MessageMicro {
        private boolean apP;
        private boolean aqH;
        private boolean aqJ;
        private int aqI = 0;
        private int aqK = 0;
        private String apQ = "";
        private int apY = -1;

        public a ca(int i) {
            this.aqH = true;
            this.aqI = i;
            return this;
        }

        public a cb(int i) {
            this.aqJ = true;
            this.aqK = i;
            return this;
        }

        public a em(String str) {
            this.apP = true;
            this.apQ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apY < 0) {
                getSerializedSize();
            }
            return this.apY;
        }

        public String getName() {
            return this.apQ;
        }

        public int getOffset() {
            return this.aqI;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = wf() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset()) : 0;
            if (wh()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, wg());
            }
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            this.apY = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.apP;
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
                        em(codedInputStreamMicro.readString());
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

        public boolean wf() {
            return this.aqH;
        }

        public int wg() {
            return this.aqK;
        }

        public boolean wh() {
            return this.aqJ;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (wf()) {
                codedOutputStreamMicro.writeInt32(1, getOffset());
            }
            if (wh()) {
                codedOutputStreamMicro.writeInt32(2, wg());
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
            if (this.aqG.isEmpty()) {
                this.aqG = new ArrayList();
            }
            this.aqG.add(aVar);
        }
        return this;
    }

    public a bZ(int i) {
        return this.aqG.get(i);
    }

    public c ek(String str) {
        this.aqC = true;
        this.aqD = str;
        return this;
    }

    public c el(String str) {
        this.aqE = true;
        this.aqF = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apY < 0) {
            getSerializedSize();
        }
        return this.apY;
    }

    public String getMd5() {
        return this.aqD;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeStringSize = wa() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getMd5()) : 0;
        if (wc()) {
            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wb());
        }
        Iterator<a> it = wd().iterator();
        while (true) {
            int i = computeStringSize;
            if (!it.hasNext()) {
                this.apY = i;
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
                    ek(codedInputStreamMicro.readString());
                    break;
                case 18:
                    el(codedInputStreamMicro.readString());
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

    public boolean wa() {
        return this.aqC;
    }

    public String wb() {
        return this.aqF;
    }

    public boolean wc() {
        return this.aqE;
    }

    public List<a> wd() {
        return this.aqG;
    }

    public int we() {
        return this.aqG.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (wa()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        if (wc()) {
            codedOutputStreamMicro.writeString(2, wb());
        }
        for (a aVar : wd()) {
            codedOutputStreamMicro.writeMessage(3, aVar);
        }
    }
}
