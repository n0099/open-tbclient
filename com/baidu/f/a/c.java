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
/* loaded from: classes20.dex */
public final class c extends MessageMicro {
    private boolean apY;
    private boolean aqa;
    private String apZ = "";
    private String aqb = "";
    private List<a> aqc = Collections.emptyList();
    private int apu = -1;

    /* loaded from: classes20.dex */
    public static final class a extends MessageMicro {
        private boolean apj;
        private boolean aqd;
        private boolean aqf;
        private int aqe = 0;
        private int aqg = 0;
        private String apl = "";
        private int apu = -1;

        public a bW(int i) {
            this.aqd = true;
            this.aqe = i;
            return this;
        }

        public a bX(int i) {
            this.aqf = true;
            this.aqg = i;
            return this;
        }

        public a ej(String str) {
            this.apj = true;
            this.apl = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apu < 0) {
                getSerializedSize();
            }
            return this.apu;
        }

        public String getName() {
            return this.apl;
        }

        public int getOffset() {
            return this.aqe;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = vR() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset()) : 0;
            if (vT()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, vS());
            }
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            this.apu = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.apj;
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
                        bW(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bX(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        ej(codedInputStreamMicro.readString());
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

        public boolean vR() {
            return this.aqd;
        }

        public int vS() {
            return this.aqg;
        }

        public boolean vT() {
            return this.aqf;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vR()) {
                codedOutputStreamMicro.writeInt32(1, getOffset());
            }
            if (vT()) {
                codedOutputStreamMicro.writeInt32(2, vS());
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
            if (this.aqc.isEmpty()) {
                this.aqc = new ArrayList();
            }
            this.aqc.add(aVar);
        }
        return this;
    }

    public a bV(int i) {
        return this.aqc.get(i);
    }

    public c eh(String str) {
        this.apY = true;
        this.apZ = str;
        return this;
    }

    public c ei(String str) {
        this.aqa = true;
        this.aqb = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apu < 0) {
            getSerializedSize();
        }
        return this.apu;
    }

    public String getMd5() {
        return this.apZ;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeStringSize = vM() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getMd5()) : 0;
        if (vO()) {
            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, vN());
        }
        Iterator<a> it = vP().iterator();
        while (true) {
            int i = computeStringSize;
            if (!it.hasNext()) {
                this.apu = i;
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
                    eh(codedInputStreamMicro.readString());
                    break;
                case 18:
                    ei(codedInputStreamMicro.readString());
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

    public boolean vM() {
        return this.apY;
    }

    public String vN() {
        return this.aqb;
    }

    public boolean vO() {
        return this.aqa;
    }

    public List<a> vP() {
        return this.aqc;
    }

    public int vQ() {
        return this.aqc.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vM()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        if (vO()) {
            codedOutputStreamMicro.writeString(2, vN());
        }
        for (a aVar : vP()) {
            codedOutputStreamMicro.writeMessage(3, aVar);
        }
    }
}
