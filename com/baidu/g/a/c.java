package com.baidu.g.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public final class c extends MessageMicro {
    private boolean asN;
    private boolean asP;
    private String asO = "";
    private String asQ = "";
    private List<a> asR = Collections.emptyList();
    private int asi = -1;

    /* loaded from: classes15.dex */
    public static final class a extends MessageMicro {
        private boolean arZ;
        private boolean asS;
        private boolean asU;
        private int asT = 0;
        private int asV = 0;
        private String asa = "";
        private int asi = -1;

        public a cc(int i) {
            this.asS = true;
            this.asT = i;
            return this;
        }

        public a cd(int i) {
            this.asU = true;
            this.asV = i;
            return this;
        }

        public a ei(String str) {
            this.arZ = true;
            this.asa = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.asi < 0) {
                getSerializedSize();
            }
            return this.asi;
        }

        public String getName() {
            return this.asa;
        }

        public int getOffset() {
            return this.asT;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = vw() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset()) : 0;
            if (vy()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, vx());
            }
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            this.asi = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.arZ;
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
                        cc(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        cd(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        ei(codedInputStreamMicro.readString());
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

        public boolean vw() {
            return this.asS;
        }

        public int vx() {
            return this.asV;
        }

        public boolean vy() {
            return this.asU;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (vw()) {
                codedOutputStreamMicro.writeInt32(1, getOffset());
            }
            if (vy()) {
                codedOutputStreamMicro.writeInt32(2, vx());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
        }
    }

    public static c t(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (c) new c().mergeFrom(bArr);
    }

    public c a(a aVar) {
        if (aVar != null) {
            if (this.asR.isEmpty()) {
                this.asR = new ArrayList();
            }
            this.asR.add(aVar);
        }
        return this;
    }

    public a cb(int i) {
        return this.asR.get(i);
    }

    public c eg(String str) {
        this.asN = true;
        this.asO = str;
        return this;
    }

    public c eh(String str) {
        this.asP = true;
        this.asQ = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.asi < 0) {
            getSerializedSize();
        }
        return this.asi;
    }

    public String getMd5() {
        return this.asO;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeStringSize = vr() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getMd5()) : 0;
        if (vt()) {
            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, vs());
        }
        Iterator<a> it = vu().iterator();
        while (true) {
            int i = computeStringSize;
            if (!it.hasNext()) {
                this.asi = i;
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
                    eg(codedInputStreamMicro.readString());
                    break;
                case 18:
                    eh(codedInputStreamMicro.readString());
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

    public boolean vr() {
        return this.asN;
    }

    public String vs() {
        return this.asQ;
    }

    public boolean vt() {
        return this.asP;
    }

    public List<a> vu() {
        return this.asR;
    }

    public int vv() {
        return this.asR.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vr()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        if (vt()) {
            codedOutputStreamMicro.writeString(2, vs());
        }
        for (a aVar : vu()) {
            codedOutputStreamMicro.writeMessage(3, aVar);
        }
    }
}
