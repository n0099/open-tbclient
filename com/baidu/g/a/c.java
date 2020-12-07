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
/* loaded from: classes26.dex */
public final class c extends MessageMicro {
    private boolean asr;
    private boolean ast;
    private String ass = "";
    private String asu = "";
    private List<a> asv = Collections.emptyList();
    private int arM = -1;

    /* loaded from: classes26.dex */
    public static final class a extends MessageMicro {
        private boolean arD;
        private boolean asw;
        private boolean asy;
        private int asx = 0;
        private int asz = 0;
        private String arE = "";
        private int arM = -1;

        public a cc(int i) {
            this.asw = true;
            this.asx = i;
            return this;
        }

        public a cd(int i) {
            this.asy = true;
            this.asz = i;
            return this;
        }

        public a ey(String str) {
            this.arD = true;
            this.arE = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.arM < 0) {
                getSerializedSize();
            }
            return this.arM;
        }

        public String getName() {
            return this.arE;
        }

        public int getOffset() {
            return this.asx;
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
            this.arM = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.arD;
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
                        ey(codedInputStreamMicro.readString());
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
            return this.asw;
        }

        public int wg() {
            return this.asz;
        }

        public boolean wh() {
            return this.asy;
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
            if (this.asv.isEmpty()) {
                this.asv = new ArrayList();
            }
            this.asv.add(aVar);
        }
        return this;
    }

    public a cb(int i) {
        return this.asv.get(i);
    }

    public c ev(String str) {
        this.asr = true;
        this.ass = str;
        return this;
    }

    public c ew(String str) {
        this.ast = true;
        this.asu = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.arM < 0) {
            getSerializedSize();
        }
        return this.arM;
    }

    public String getMd5() {
        return this.ass;
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
                this.arM = i;
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
                    ev(codedInputStreamMicro.readString());
                    break;
                case 18:
                    ew(codedInputStreamMicro.readString());
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
        return this.asr;
    }

    public String wb() {
        return this.asu;
    }

    public boolean wc() {
        return this.ast;
    }

    public List<a> wd() {
        return this.asv;
    }

    public int we() {
        return this.asv.size();
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
