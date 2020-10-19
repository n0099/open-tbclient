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
    private boolean aqA;
    private boolean aqC;
    private boolean aqE;
    private boolean aqt;
    private boolean aqv;
    private boolean aqx;
    private boolean aqy;
    private int aqu = 0;
    private String aqw = "";
    private int level_ = 0;
    private String aqz = "";
    private boolean aqB = false;
    private boolean aqD = false;
    private String aqF = "";
    private List<Integer> aqG = Collections.emptyList();
    private int aqH = -1;

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
        this.aqA = true;
        this.aqB = z;
        return this;
    }

    public a aT(boolean z) {
        this.aqC = true;
        this.aqD = z;
        return this;
    }

    public a bJ(int i) {
        this.aqt = true;
        this.aqu = i;
        return this;
    }

    public a bK(int i) {
        this.aqx = true;
        this.level_ = i;
        return this;
    }

    public a bL(int i) {
        if (this.aqG.isEmpty()) {
            this.aqG = new ArrayList();
        }
        this.aqG.add(Integer.valueOf(i));
        return this;
    }

    public a eh(String str) {
        this.aqv = true;
        this.aqw = str;
        return this;
    }

    public a ei(String str) {
        this.aqy = true;
        this.aqz = str;
        return this;
    }

    public a ej(String str) {
        this.aqE = true;
        this.aqF = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.aqH < 0) {
            getSerializedSize();
        }
        return this.aqH;
    }

    public int getCode() {
        return this.aqu;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.aqz;
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
        this.aqH = size;
        return size;
    }

    public String getUid() {
        return this.aqF;
    }

    public boolean hasLevel() {
        return this.aqx;
    }

    public boolean hasName() {
        return this.aqy;
    }

    public boolean vE() {
        return this.aqt;
    }

    public String vF() {
        return this.aqw;
    }

    public boolean vG() {
        return this.aqv;
    }

    public boolean vH() {
        return this.aqB;
    }

    public boolean vI() {
        return this.aqA;
    }

    public boolean vJ() {
        return this.aqD;
    }

    public boolean vK() {
        return this.aqC;
    }

    public boolean vL() {
        return this.aqE;
    }

    public List<Integer> vM() {
        return this.aqG;
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
