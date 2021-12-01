package com.alibaba.fastjson.asm;
/* loaded from: classes7.dex */
public interface MethodVisitor {
    void visitEnd();

    void visitFieldInsn(int i2, String str, String str2, String str3);

    void visitIincInsn(int i2, int i3);

    void visitInsn(int i2);

    void visitIntInsn(int i2, int i3);

    void visitJumpInsn(int i2, Label label);

    void visitLabel(Label label);

    void visitLdcInsn(Object obj);

    void visitMaxs(int i2, int i3);

    void visitMethodInsn(int i2, String str, String str2, String str3);

    void visitTypeInsn(int i2, String str);

    void visitVarInsn(int i2, int i3);
}
