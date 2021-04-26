package com.alibaba.fastjson.asm;
/* loaded from: classes.dex */
public class MethodWriter implements MethodVisitor {
    public int access;
    public ByteVector code = new ByteVector();
    public final ClassWriter cw;
    public final int desc;
    public int exceptionCount;
    public int[] exceptions;
    public int maxLocals;
    public int maxStack;
    public final int name;
    public MethodWriter next;

    public MethodWriter(ClassWriter classWriter, int i2, String str, String str2, String str3, String[] strArr) {
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.next = this;
        }
        classWriter.lastMethod = this;
        this.cw = classWriter;
        this.access = i2;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.exceptionCount = length;
        this.exceptions = new int[length];
        for (int i3 = 0; i3 < this.exceptionCount; i3++) {
            this.exceptions[i3] = classWriter.newClassItem(strArr[i3]).index;
        }
    }

    public final int getSize() {
        int i2;
        if (this.code.length > 0) {
            this.cw.newUTF8("Code");
            i2 = this.code.length + 18 + 0 + 8;
        } else {
            i2 = 8;
        }
        if (this.exceptionCount > 0) {
            this.cw.newUTF8("Exceptions");
            return i2 + (this.exceptionCount * 2) + 8;
        }
        return i2;
    }

    public final void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        int i2 = this.code.length > 0 ? 1 : 0;
        if (this.exceptionCount > 0) {
            i2++;
        }
        byteVector.putShort(i2);
        int i3 = this.code.length;
        if (i3 > 0) {
            byteVector.putShort(this.cw.newUTF8("Code")).putInt(i3 + 12 + 0);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            ByteVector putInt = byteVector.putInt(this.code.length);
            ByteVector byteVector2 = this.code;
            putInt.putByteArray(byteVector2.data, 0, byteVector2.length);
            byteVector.putShort(0);
            byteVector.putShort(0);
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
            byteVector.putShort(this.exceptionCount);
            for (int i4 = 0; i4 < this.exceptionCount; i4++) {
                byteVector.putShort(this.exceptions[i4]);
            }
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int i2, String str, String str2, String str3) {
        this.code.put12(i2, this.cw.newFieldItem(str, str2, str3).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int i2, int i3) {
        this.code.putByte(132).put11(i2, i3);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int i2) {
        this.code.putByte(i2);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int i2, int i3) {
        this.code.put11(i2, i3);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int i2, Label label) {
        if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
            throw new UnsupportedOperationException();
        }
        this.code.putByte(i2);
        ByteVector byteVector = this.code;
        label.put(this, byteVector, byteVector.length - 1, i2 == 200);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label label) {
        ByteVector byteVector = this.code;
        label.resolve(this, byteVector.length, byteVector.data);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Item newConstItem = this.cw.newConstItem(obj);
        int i2 = newConstItem.index;
        int i3 = newConstItem.type;
        if (i3 == 5 || i3 == 6) {
            this.code.put12(20, i2);
        } else if (i2 >= 256) {
            this.code.put12(19, i2);
        } else {
            this.code.put11(18, i2);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int i2, int i3) {
        this.maxStack = i2;
        this.maxLocals = i3;
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int i2, String str, String str2, String str3) {
        boolean z = i2 == 185;
        Item newMethodItem = this.cw.newMethodItem(str, str2, str3, z);
        int i3 = newMethodItem.intVal;
        if (z) {
            if (i3 == 0) {
                i3 = Type.getArgumentsAndReturnSizes(str3);
                newMethodItem.intVal = i3;
            }
            this.code.put12(185, newMethodItem.index).put11(i3 >> 2, 0);
            return;
        }
        this.code.put12(i2, newMethodItem.index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int i2, String str) {
        this.code.put12(i2, this.cw.newClassItem(str).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int i2, int i3) {
        if (i3 < 4 && i2 != 169) {
            this.code.putByte((i2 < 54 ? ((i2 - 21) << 2) + 26 : ((i2 - 54) << 2) + 59) + i3);
        } else if (i3 >= 256) {
            this.code.putByte(196).put12(i2, i3);
        } else {
            this.code.put11(i2, i3);
        }
    }
}
