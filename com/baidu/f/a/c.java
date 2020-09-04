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
    private boolean aqa;
    private boolean aqc;
    private String aqb = "";
    private String aqd = "";
    private List<a> aqe = Collections.emptyList();
    private int apw = -1;

    /* loaded from: classes20.dex */
    public static final class a extends MessageMicro {
        private boolean apm;
        private boolean aqf;
        private boolean aqh;
        private int aqg = 0;
        private int aqi = 0;
        private String apn = "";
        private int apw = -1;

        public a bW(int i) {
            this.aqf = true;
            this.aqg = i;
            return this;
        }

        public a bX(int i) {
            this.aqh = true;
            this.aqi = i;
            return this;
        }

        public a ek(String str) {
            this.apm = true;
            this.apn = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.apw < 0) {
                getSerializedSize();
            }
            return this.apw;
        }

        public String getName() {
            return this.apn;
        }

        public int getOffset() {
            return this.aqg;
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
            this.apw = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.apm;
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
                        ek(codedInputStreamMicro.readString());
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
            return this.aqf;
        }

        public int vS() {
            return this.aqi;
        }

        public boolean vT() {
            return this.aqh;
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
            if (this.aqe.isEmpty()) {
                this.aqe = new ArrayList();
            }
            this.aqe.add(aVar);
        }
        return this;
    }

    public a bV(int i) {
        return this.aqe.get(i);
    }

    public c ei(String str) {
        this.aqa = true;
        this.aqb = str;
        return this;
    }

    public c ej(String str) {
        this.aqc = true;
        this.aqd = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apw < 0) {
            getSerializedSize();
        }
        return this.apw;
    }

    public String getMd5() {
        return this.aqb;
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
                this.apw = i;
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
                    ei(codedInputStreamMicro.readString());
                    break;
                case 18:
                    ej(codedInputStreamMicro.readString());
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
        return this.aqa;
    }

    public String vN() {
        return this.aqd;
    }

    public boolean vO() {
        return this.aqc;
    }

    public List<a> vP() {
        return this.aqe;
    }

    public int vQ() {
        return this.aqe.size();
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
