package com.baidu.g.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class a extends MessageMicro {
    private boolean arU;
    private boolean arW;
    private boolean arY;
    private boolean arZ;
    private boolean asb;
    private boolean asd;
    private boolean asf;
    private int arV = 0;
    private String arX = "";
    private int level_ = 0;
    private String asa = "";
    private boolean asc = false;
    private boolean ase = false;
    private String asg = "";
    private List<Integer> ash = Collections.emptyList();
    private int asi = -1;

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
                    dY(codedInputStreamMicro.readString());
                    break;
                case 24:
                    bM(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    dZ(codedInputStreamMicro.readString());
                    break;
                case 40:
                    aR(codedInputStreamMicro.readBool());
                    break;
                case 48:
                    aS(codedInputStreamMicro.readBool());
                    break;
                case 58:
                    ea(codedInputStreamMicro.readString());
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

    public a aR(boolean z) {
        this.asb = true;
        this.asc = z;
        return this;
    }

    public a aS(boolean z) {
        this.asd = true;
        this.ase = z;
        return this;
    }

    public a bL(int i) {
        this.arU = true;
        this.arV = i;
        return this;
    }

    public a bM(int i) {
        this.arY = true;
        this.level_ = i;
        return this;
    }

    public a bN(int i) {
        if (this.ash.isEmpty()) {
            this.ash = new ArrayList();
        }
        this.ash.add(Integer.valueOf(i));
        return this;
    }

    public a dY(String str) {
        this.arW = true;
        this.arX = str;
        return this;
    }

    public a dZ(String str) {
        this.arZ = true;
        this.asa = str;
        return this;
    }

    public a ea(String str) {
        this.asf = true;
        this.asg = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.asi < 0) {
            getSerializedSize();
        }
        return this.asi;
    }

    public int getCode() {
        return this.arV;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.asa;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = uM() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0 : 0;
        if (uO()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, uN());
        }
        if (hasLevel()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        if (uQ()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, uP());
        }
        if (uS()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, uR());
        }
        int computeStringSize = uT() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : computeInt32Size;
        for (Integer num : uU()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
        }
        int size = computeStringSize + i + (uU().size() * 1);
        this.asi = size;
        return size;
    }

    public String getUid() {
        return this.asg;
    }

    public boolean hasLevel() {
        return this.arY;
    }

    public boolean hasName() {
        return this.arZ;
    }

    public boolean uM() {
        return this.arU;
    }

    public String uN() {
        return this.arX;
    }

    public boolean uO() {
        return this.arW;
    }

    public boolean uP() {
        return this.asc;
    }

    public boolean uQ() {
        return this.asb;
    }

    public boolean uR() {
        return this.ase;
    }

    public boolean uS() {
        return this.asd;
    }

    public boolean uT() {
        return this.asf;
    }

    public List<Integer> uU() {
        return this.ash;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (uM()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (uO()) {
            codedOutputStreamMicro.writeString(2, uN());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(4, getName());
        }
        if (uQ()) {
            codedOutputStreamMicro.writeBool(5, uP());
        }
        if (uS()) {
            codedOutputStreamMicro.writeBool(6, uR());
        }
        if (uT()) {
            codedOutputStreamMicro.writeString(7, getUid());
        }
        for (Integer num : uU()) {
            codedOutputStreamMicro.writeSInt32(8, num.intValue());
        }
    }
}
