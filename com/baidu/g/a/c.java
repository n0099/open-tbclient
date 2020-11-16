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
/* loaded from: classes7.dex */
public final class c extends MessageMicro {
    private boolean ars;
    private boolean aru;
    private String art = "";
    private String arv = "";
    private List<a> arw = Collections.emptyList();
    private int aqO = -1;

    /* loaded from: classes7.dex */
    public static final class a extends MessageMicro {
        private boolean aqF;
        private boolean arx;
        private boolean arz;
        private int ary = 0;
        private int arA = 0;
        private String aqG = "";
        private int aqO = -1;

        public a bY(int i) {
            this.arx = true;
            this.ary = i;
            return this;
        }

        public a bZ(int i) {
            this.arz = true;
            this.arA = i;
            return this;
        }

        public a et(String str) {
            this.aqF = true;
            this.aqG = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.aqO < 0) {
                getSerializedSize();
            }
            return this.aqO;
        }

        public String getName() {
            return this.aqG;
        }

        public int getOffset() {
            return this.ary;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = wn() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset()) : 0;
            if (wp()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, wo());
            }
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            this.aqO = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasName() {
            return this.aqF;
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
                        bY(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        bZ(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        et(codedInputStreamMicro.readString());
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

        public boolean wn() {
            return this.arx;
        }

        public int wo() {
            return this.arA;
        }

        public boolean wp() {
            return this.arz;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (wn()) {
                codedOutputStreamMicro.writeInt32(1, getOffset());
            }
            if (wp()) {
                codedOutputStreamMicro.writeInt32(2, wo());
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
            if (this.arw.isEmpty()) {
                this.arw = new ArrayList();
            }
            this.arw.add(aVar);
        }
        return this;
    }

    public a bX(int i) {
        return this.arw.get(i);
    }

    public c er(String str) {
        this.ars = true;
        this.art = str;
        return this;
    }

    public c es(String str) {
        this.aru = true;
        this.arv = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqO < 0) {
            getSerializedSize();
        }
        return this.aqO;
    }

    public String getMd5() {
        return this.art;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeStringSize = wi() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getMd5()) : 0;
        if (wk()) {
            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, wj());
        }
        Iterator<a> it = wl().iterator();
        while (true) {
            int i = computeStringSize;
            if (!it.hasNext()) {
                this.aqO = i;
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
                    er(codedInputStreamMicro.readString());
                    break;
                case 18:
                    es(codedInputStreamMicro.readString());
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

    public boolean wi() {
        return this.ars;
    }

    public String wj() {
        return this.arv;
    }

    public boolean wk() {
        return this.aru;
    }

    public List<a> wl() {
        return this.arw;
    }

    public int wm() {
        return this.arw.size();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (wi()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        if (wk()) {
            codedOutputStreamMicro.writeString(2, wj());
        }
        for (a aVar : wl()) {
            codedOutputStreamMicro.writeMessage(3, aVar);
        }
    }
}
