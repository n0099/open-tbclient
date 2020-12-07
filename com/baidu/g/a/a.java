package com.baidu.g.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes26.dex */
public final class a extends MessageMicro {
    private boolean arA;
    private boolean arC;
    private boolean arD;
    private boolean arF;
    private boolean arH;
    private boolean arJ;
    private boolean ary;
    private int arz = 0;
    private String arB = "";
    private int level_ = 0;
    private String arE = "";
    private boolean arG = false;
    private boolean arI = false;
    private String arK = "";
    private List<Integer> arL = Collections.emptyList();
    private int arM = -1;

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
                    bL(codedInputStreamMicro.readInt32());
                    break;
                case 18:
                    en(codedInputStreamMicro.readString());
                    break;
                case 24:
                    bM(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    eo(codedInputStreamMicro.readString());
                    break;
                case 40:
                    aU(codedInputStreamMicro.readBool());
                    break;
                case 48:
                    aV(codedInputStreamMicro.readBool());
                    break;
                case 58:
                    ep(codedInputStreamMicro.readString());
                    break;
                case 64:
                    bN(codedInputStreamMicro.readSInt32());
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

    public a aU(boolean z) {
        this.arF = true;
        this.arG = z;
        return this;
    }

    public a aV(boolean z) {
        this.arH = true;
        this.arI = z;
        return this;
    }

    public a bL(int i) {
        this.ary = true;
        this.arz = i;
        return this;
    }

    public a bM(int i) {
        this.arC = true;
        this.level_ = i;
        return this;
    }

    public a bN(int i) {
        if (this.arL.isEmpty()) {
            this.arL = new ArrayList();
        }
        this.arL.add(Integer.valueOf(i));
        return this;
    }

    public a en(String str) {
        this.arA = true;
        this.arB = str;
        return this;
    }

    public a eo(String str) {
        this.arD = true;
        this.arE = str;
        return this;
    }

    public a ep(String str) {
        this.arJ = true;
        this.arK = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.arM < 0) {
            getSerializedSize();
        }
        return this.arM;
    }

    public int getCode() {
        return this.arz;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.arE;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = vv() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0 : 0;
        if (vx()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, vw());
        }
        if (hasLevel()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        if (vz()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, vy());
        }
        if (vB()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, vA());
        }
        int computeStringSize = vC() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : computeInt32Size;
        for (Integer num : vD()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
        }
        int size = computeStringSize + i + (vD().size() * 1);
        this.arM = size;
        return size;
    }

    public String getUid() {
        return this.arK;
    }

    public boolean hasLevel() {
        return this.arC;
    }

    public boolean hasName() {
        return this.arD;
    }

    public boolean vA() {
        return this.arI;
    }

    public boolean vB() {
        return this.arH;
    }

    public boolean vC() {
        return this.arJ;
    }

    public List<Integer> vD() {
        return this.arL;
    }

    public boolean vv() {
        return this.ary;
    }

    public String vw() {
        return this.arB;
    }

    public boolean vx() {
        return this.arA;
    }

    public boolean vy() {
        return this.arG;
    }

    public boolean vz() {
        return this.arF;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vv()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (vx()) {
            codedOutputStreamMicro.writeString(2, vw());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(4, getName());
        }
        if (vz()) {
            codedOutputStreamMicro.writeBool(5, vy());
        }
        if (vB()) {
            codedOutputStreamMicro.writeBool(6, vA());
        }
        if (vC()) {
            codedOutputStreamMicro.writeString(7, getUid());
        }
        for (Integer num : vD()) {
            codedOutputStreamMicro.writeSInt32(8, num.intValue());
        }
    }
}
