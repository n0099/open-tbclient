package com.baidu.f.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class a extends MessageMicro {
    private boolean aqB;
    private boolean aqD;
    private boolean aqF;
    private boolean aqu;
    private boolean aqw;
    private boolean aqy;
    private boolean aqz;
    private int aqv = 0;
    private String aqx = "";
    private int level_ = 0;
    private String aqA = "";
    private boolean aqC = false;
    private boolean aqE = false;
    private String aqG = "";
    private List<Integer> aqH = Collections.emptyList();
    private int aqI = -1;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.micro.MessageMicro
    /* renamed from: a */
    public a mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    bJ(codedInputStreamMicro.readInt32());
                    break;
                case 18:
                    eh(codedInputStreamMicro.readString());
                    break;
                case 24:
                    bK(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    ei(codedInputStreamMicro.readString());
                    break;
                case 40:
                    aS(codedInputStreamMicro.readBool());
                    break;
                case 48:
                    aT(codedInputStreamMicro.readBool());
                    break;
                case 58:
                    ej(codedInputStreamMicro.readString());
                    break;
                case 64:
                    bL(codedInputStreamMicro.readSInt32());
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

    public a aS(boolean z) {
        this.aqB = true;
        this.aqC = z;
        return this;
    }

    public a aT(boolean z) {
        this.aqD = true;
        this.aqE = z;
        return this;
    }

    public a bJ(int i) {
        this.aqu = true;
        this.aqv = i;
        return this;
    }

    public a bK(int i) {
        this.aqy = true;
        this.level_ = i;
        return this;
    }

    public a bL(int i) {
        if (this.aqH.isEmpty()) {
            this.aqH = new ArrayList();
        }
        this.aqH.add(Integer.valueOf(i));
        return this;
    }

    public a eh(String str) {
        this.aqw = true;
        this.aqx = str;
        return this;
    }

    public a ei(String str) {
        this.aqz = true;
        this.aqA = str;
        return this;
    }

    public a ej(String str) {
        this.aqF = true;
        this.aqG = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqI < 0) {
            getSerializedSize();
        }
        return this.aqI;
    }

    public int getCode() {
        return this.aqv;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.aqA;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = vE() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0 : 0;
        if (vG()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, vF());
        }
        if (hasLevel()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        if (vI()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, vH());
        }
        if (vK()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, vJ());
        }
        int computeStringSize = vL() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : computeInt32Size;
        for (Integer num : vM()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
        }
        int size = computeStringSize + i + (vM().size() * 1);
        this.aqI = size;
        return size;
    }

    public String getUid() {
        return this.aqG;
    }

    public boolean hasLevel() {
        return this.aqy;
    }

    public boolean hasName() {
        return this.aqz;
    }

    public boolean vE() {
        return this.aqu;
    }

    public String vF() {
        return this.aqx;
    }

    public boolean vG() {
        return this.aqw;
    }

    public boolean vH() {
        return this.aqC;
    }

    public boolean vI() {
        return this.aqB;
    }

    public boolean vJ() {
        return this.aqE;
    }

    public boolean vK() {
        return this.aqD;
    }

    public boolean vL() {
        return this.aqF;
    }

    public List<Integer> vM() {
        return this.aqH;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vE()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (vG()) {
            codedOutputStreamMicro.writeString(2, vF());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(4, getName());
        }
        if (vI()) {
            codedOutputStreamMicro.writeBool(5, vH());
        }
        if (vK()) {
            codedOutputStreamMicro.writeBool(6, vJ());
        }
        if (vL()) {
            codedOutputStreamMicro.writeString(7, getUid());
        }
        for (Integer num : vM()) {
            codedOutputStreamMicro.writeSInt32(8, num.intValue());
        }
    }
}
