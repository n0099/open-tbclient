package com.baidu.f.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class a extends MessageMicro {
    private boolean apK;
    private boolean apM;
    private boolean apO;
    private boolean apP;
    private boolean apR;
    private boolean apT;
    private boolean apV;
    private int apL = 0;
    private String apN = "";
    private int level_ = 0;
    private String apQ = "";
    private boolean apS = false;
    private boolean apU = false;
    private String apW = "";
    private List<Integer> apX = Collections.emptyList();
    private int apY = -1;

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
                    ec(codedInputStreamMicro.readString());
                    break;
                case 24:
                    bK(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    ed(codedInputStreamMicro.readString());
                    break;
                case 40:
                    aP(codedInputStreamMicro.readBool());
                    break;
                case 48:
                    aQ(codedInputStreamMicro.readBool());
                    break;
                case 58:
                    ee(codedInputStreamMicro.readString());
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

    public a aP(boolean z) {
        this.apR = true;
        this.apS = z;
        return this;
    }

    public a aQ(boolean z) {
        this.apT = true;
        this.apU = z;
        return this;
    }

    public a bJ(int i) {
        this.apK = true;
        this.apL = i;
        return this;
    }

    public a bK(int i) {
        this.apO = true;
        this.level_ = i;
        return this;
    }

    public a bL(int i) {
        if (this.apX.isEmpty()) {
            this.apX = new ArrayList();
        }
        this.apX.add(Integer.valueOf(i));
        return this;
    }

    public a ec(String str) {
        this.apM = true;
        this.apN = str;
        return this;
    }

    public a ed(String str) {
        this.apP = true;
        this.apQ = str;
        return this;
    }

    public a ee(String str) {
        this.apV = true;
        this.apW = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apY < 0) {
            getSerializedSize();
        }
        return this.apY;
    }

    public int getCode() {
        return this.apL;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.apQ;
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
        this.apY = size;
        return size;
    }

    public String getUid() {
        return this.apW;
    }

    public boolean hasLevel() {
        return this.apO;
    }

    public boolean hasName() {
        return this.apP;
    }

    public boolean vA() {
        return this.apU;
    }

    public boolean vB() {
        return this.apT;
    }

    public boolean vC() {
        return this.apV;
    }

    public List<Integer> vD() {
        return this.apX;
    }

    public boolean vv() {
        return this.apK;
    }

    public String vw() {
        return this.apN;
    }

    public boolean vx() {
        return this.apM;
    }

    public boolean vy() {
        return this.apS;
    }

    public boolean vz() {
        return this.apR;
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
