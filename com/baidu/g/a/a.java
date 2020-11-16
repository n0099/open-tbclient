package com.baidu.g.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class a extends MessageMicro {
    private boolean aqA;
    private boolean aqC;
    private boolean aqE;
    private boolean aqF;
    private boolean aqH;
    private boolean aqJ;
    private boolean aqL;
    private int aqB = 0;
    private String aqD = "";
    private int level_ = 0;
    private String aqG = "";
    private boolean aqI = false;
    private boolean aqK = false;
    private String aqM = "";
    private List<Integer> aqN = Collections.emptyList();
    private int aqO = -1;

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
                    bH(codedInputStreamMicro.readInt32());
                    break;
                case 18:
                    ej(codedInputStreamMicro.readString());
                    break;
                case 24:
                    bI(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    ek(codedInputStreamMicro.readString());
                    break;
                case 40:
                    aU(codedInputStreamMicro.readBool());
                    break;
                case 48:
                    aV(codedInputStreamMicro.readBool());
                    break;
                case 58:
                    el(codedInputStreamMicro.readString());
                    break;
                case 64:
                    bJ(codedInputStreamMicro.readSInt32());
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
        this.aqH = true;
        this.aqI = z;
        return this;
    }

    public a aV(boolean z) {
        this.aqJ = true;
        this.aqK = z;
        return this;
    }

    public a bH(int i) {
        this.aqA = true;
        this.aqB = i;
        return this;
    }

    public a bI(int i) {
        this.aqE = true;
        this.level_ = i;
        return this;
    }

    public a bJ(int i) {
        if (this.aqN.isEmpty()) {
            this.aqN = new ArrayList();
        }
        this.aqN.add(Integer.valueOf(i));
        return this;
    }

    public a ej(String str) {
        this.aqC = true;
        this.aqD = str;
        return this;
    }

    public a ek(String str) {
        this.aqF = true;
        this.aqG = str;
        return this;
    }

    public a el(String str) {
        this.aqL = true;
        this.aqM = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqO < 0) {
            getSerializedSize();
        }
        return this.aqO;
    }

    public int getCode() {
        return this.aqB;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.aqG;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = vD() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0 : 0;
        if (vF()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, vE());
        }
        if (hasLevel()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        if (vH()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, vG());
        }
        if (vJ()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, vI());
        }
        int computeStringSize = vK() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : computeInt32Size;
        for (Integer num : vL()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
        }
        int size = computeStringSize + i + (vL().size() * 1);
        this.aqO = size;
        return size;
    }

    public String getUid() {
        return this.aqM;
    }

    public boolean hasLevel() {
        return this.aqE;
    }

    public boolean hasName() {
        return this.aqF;
    }

    public boolean vD() {
        return this.aqA;
    }

    public String vE() {
        return this.aqD;
    }

    public boolean vF() {
        return this.aqC;
    }

    public boolean vG() {
        return this.aqI;
    }

    public boolean vH() {
        return this.aqH;
    }

    public boolean vI() {
        return this.aqK;
    }

    public boolean vJ() {
        return this.aqJ;
    }

    public boolean vK() {
        return this.aqL;
    }

    public List<Integer> vL() {
        return this.aqN;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vD()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (vF()) {
            codedOutputStreamMicro.writeString(2, vE());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(4, getName());
        }
        if (vH()) {
            codedOutputStreamMicro.writeBool(5, vG());
        }
        if (vJ()) {
            codedOutputStreamMicro.writeBool(6, vI());
        }
        if (vK()) {
            codedOutputStreamMicro.writeString(7, getUid());
        }
        for (Integer num : vL()) {
            codedOutputStreamMicro.writeSInt32(8, num.intValue());
        }
    }
}
