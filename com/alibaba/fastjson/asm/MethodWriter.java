package com.alibaba.fastjson.asm;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MethodWriter implements MethodVisitor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int access;
    public ByteVector code;
    public final ClassWriter cw;
    public final int desc;
    public int exceptionCount;
    public int[] exceptions;
    public int maxLocals;
    public int maxStack;
    public final int name;
    public MethodWriter next;

    public MethodWriter(ClassWriter classWriter, int i2, String str, String str2, String str3, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {classWriter, Integer.valueOf(i2), str, str2, str3, strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.code = new ByteVector();
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
        for (int i5 = 0; i5 < this.exceptionCount; i5++) {
            this.exceptions[i5] = classWriter.newClassItem(strArr[i5]).index;
        }
    }

    public final int getSize() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return invokeV.intValue;
    }

    public final void put(ByteVector byteVector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteVector) == null) {
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
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            this.code.put12(i2, this.cw.newFieldItem(str, str2, str3).index);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.code.putByte(132).put11(i2, i3);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.code.putByte(i2);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            this.code.put11(i2, i3);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int i2, Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, label) == null) {
            if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
                throw new UnsupportedOperationException();
            }
            this.code.putByte(i2);
            ByteVector byteVector = this.code;
            label.put(this, byteVector, byteVector.length - 1, i2 == 200);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, label) == null) {
            ByteVector byteVector = this.code;
            label.resolve(this, byteVector.length, byteVector.data);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
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
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            this.maxStack = i2;
            this.maxLocals = i3;
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
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
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            this.code.put12(i2, this.cw.newClassItem(str).index);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            if (i3 < 4 && i2 != 169) {
                this.code.putByte((i2 < 54 ? ((i2 - 21) << 2) + 26 : ((i2 - 54) << 2) + 59) + i3);
            } else if (i3 >= 256) {
                this.code.putByte(196).put12(i2, i3);
            } else {
                this.code.put11(i2, i3);
            }
        }
    }
}
