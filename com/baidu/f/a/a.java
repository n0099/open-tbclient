package com.baidu.f.a;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes20.dex */
public final class a extends MessageMicro {
    private boolean ape;
    private boolean apg;
    private boolean api;
    private boolean apj;
    private boolean apm;
    private boolean apo;
    private boolean apr;
    private int apf = 0;
    private String aph = "";
    private int level_ = 0;
    private String apl = "";
    private boolean apn = false;
    private boolean apq = false;
    private String aps = "";
    private List<Integer> apt = Collections.emptyList();
    private int apu = -1;

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
                    bF(codedInputStreamMicro.readInt32());
                    break;
                case 18:
                    dZ(codedInputStreamMicro.readString());
                    break;
                case 24:
                    bG(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    ea(codedInputStreamMicro.readString());
                    break;
                case 40:
                    aP(codedInputStreamMicro.readBool());
                    break;
                case 48:
                    aQ(codedInputStreamMicro.readBool());
                    break;
                case 58:
                    eb(codedInputStreamMicro.readString());
                    break;
                case 64:
                    bH(codedInputStreamMicro.readSInt32());
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
        this.apm = true;
        this.apn = z;
        return this;
    }

    public a aQ(boolean z) {
        this.apo = true;
        this.apq = z;
        return this;
    }

    public a bF(int i) {
        this.ape = true;
        this.apf = i;
        return this;
    }

    public a bG(int i) {
        this.api = true;
        this.level_ = i;
        return this;
    }

    public a bH(int i) {
        if (this.apt.isEmpty()) {
            this.apt = new ArrayList();
        }
        this.apt.add(Integer.valueOf(i));
        return this;
    }

    public a dZ(String str) {
        this.apg = true;
        this.aph = str;
        return this;
    }

    public a ea(String str) {
        this.apj = true;
        this.apl = str;
        return this;
    }

    public a eb(String str) {
        this.apr = true;
        this.aps = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.apu < 0) {
            getSerializedSize();
        }
        return this.apu;
    }

    public int getCode() {
        return this.apf;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.apl;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = vh() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) + 0 : 0;
        if (vj()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, vi());
        }
        if (hasLevel()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        if (vl()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, vk());
        }
        if (vn()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, vm());
        }
        int computeStringSize = vo() ? computeInt32Size + CodedOutputStreamMicro.computeStringSize(7, getUid()) : computeInt32Size;
        for (Integer num : vp()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(num.intValue());
        }
        int size = computeStringSize + i + (vp().size() * 1);
        this.apu = size;
        return size;
    }

    public String getUid() {
        return this.aps;
    }

    public boolean hasLevel() {
        return this.api;
    }

    public boolean hasName() {
        return this.apj;
    }

    public boolean vh() {
        return this.ape;
    }

    public String vi() {
        return this.aph;
    }

    public boolean vj() {
        return this.apg;
    }

    public boolean vk() {
        return this.apn;
    }

    public boolean vl() {
        return this.apm;
    }

    public boolean vm() {
        return this.apq;
    }

    public boolean vn() {
        return this.apo;
    }

    public boolean vo() {
        return this.apr;
    }

    public List<Integer> vp() {
        return this.apt;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (vh()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (vj()) {
            codedOutputStreamMicro.writeString(2, vi());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(4, getName());
        }
        if (vl()) {
            codedOutputStreamMicro.writeBool(5, vk());
        }
        if (vn()) {
            codedOutputStreamMicro.writeBool(6, vm());
        }
        if (vo()) {
            codedOutputStreamMicro.writeString(7, getUid());
        }
        for (Integer num : vp()) {
            codedOutputStreamMicro.writeSInt32(8, num.intValue());
        }
    }
}
