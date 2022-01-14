package com.alibaba.fastjson.parser.deserializer;

import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public class ASMDeserializerFactory implements Opcodes {
    public static /* synthetic */ Interceptable $ic;
    public static final String DefaultJSONParser;
    public static final String JSONLexerBase;
    public transient /* synthetic */ FieldHolder $fh;
    public final ASMClassLoader classLoader;
    public final AtomicLong seed;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1467702453, "Lcom/alibaba/fastjson/parser/deserializer/ASMDeserializerFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1467702453, "Lcom/alibaba/fastjson/parser/deserializer/ASMDeserializerFactory;");
                return;
            }
        }
        DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
        JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    }

    public ASMDeserializerFactory(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {classLoader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.seed = new AtomicLong();
        this.classLoader = classLoader instanceof ASMClassLoader ? (ASMClassLoader) classLoader : new ASMClassLoader(classLoader);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, methodVisitor) == null) {
            _batchSet(context, methodVisitor, true);
        }
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, methodVisitor) == null) {
            Constructor<?> constructor = context.beanInfo.defaultConstructor;
            if (Modifier.isPublic(constructor.getModifiers())) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(context.getInstClass()));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
                methodVisitor.visitVarInsn(58, context.var(Transition.MATCH_INSTANCE_STR));
                return;
            }
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, ASMUtils.type(JavaBeanDeserializer.class), Bundle.EXTRA_KEY_CLAZZ, "Ljava/lang/Class;");
            String type = ASMUtils.type(JavaBeanDeserializer.class);
            methodVisitor.visitMethodInsn(183, type, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitVarInsn(58, context.var(Transition.MATCH_INSTANCE_STR));
        }
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{context, methodVisitor, fieldInfo, cls, Integer.valueOf(i2)}) == null) {
            _getFieldDeser(context, methodVisitor, fieldInfo);
            Label label = new Label();
            Label label2 = new Label();
            if ((fieldInfo.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
                methodVisitor.visitInsn(89);
                methodVisitor.visitTypeInsn(193, ASMUtils.type(JavaBeanDeserializer.class));
                methodVisitor.visitJumpInsn(153, label);
                methodVisitor.visitTypeInsn(192, ASMUtils.type(JavaBeanDeserializer.class));
                methodVisitor.visitVarInsn(25, 1);
                if (fieldInfo.fieldType instanceof Class) {
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
                } else {
                    methodVisitor.visitVarInsn(25, 0);
                    methodVisitor.visitLdcInsn(Integer.valueOf(i2));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                methodVisitor.visitLdcInsn(fieldInfo.name);
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.parserFeatures));
                String type = ASMUtils.type(JavaBeanDeserializer.class);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
                methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
                methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                methodVisitor.visitJumpInsn(167, label2);
                methodVisitor.visitLabel(label);
            }
            methodVisitor.visitVarInsn(25, 1);
            if (fieldInfo.fieldType instanceof Class) {
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            } else {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitLdcInsn(Integer.valueOf(i2));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            methodVisitor.visitLdcInsn(fieldInfo.name);
            String type2 = ASMUtils.type(ObjectDeserializer.class);
            methodVisitor.visitMethodInsn(185, type2, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
            methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitLabel(label2);
        }
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, context, methodVisitor, label) == null) {
            methodVisitor.visitIntInsn(21, context.var("matchedCount"));
            methodVisitor.visitJumpInsn(158, label);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(13);
            methodVisitor.visitJumpInsn(160, label);
            _quickNextTokenComma(context, methodVisitor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0e66  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0e85  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _deserialze(ClassWriter classWriter, Context context) {
        FieldInfo[] fieldInfoArr;
        int i2;
        Label label;
        int i3;
        ASMDeserializerFactory aSMDeserializerFactory;
        String str;
        String str2;
        MethodWriter methodWriter;
        Label label2;
        int i4;
        int i5;
        Label label3;
        int i6;
        FieldInfo fieldInfo;
        Label label4;
        Label label5;
        Label label6;
        Label label7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, classWriter, context) == null) {
            ASMDeserializerFactory aSMDeserializerFactory2 = this;
            if (context.fieldInfoList.length == 0) {
                return;
            }
            for (FieldInfo fieldInfo2 : context.fieldInfoList) {
                Class<?> cls = fieldInfo2.fieldClass;
                java.lang.reflect.Type type = fieldInfo2.fieldType;
                if (cls == Character.TYPE) {
                    return;
                }
                if (Collection.class.isAssignableFrom(cls) && (!(type instanceof ParameterizedType) || !(((ParameterizedType) type).getActualTypeArguments()[0] instanceof Class))) {
                    return;
                }
            }
            JavaBeanInfo javaBeanInfo = context.beanInfo;
            context.fieldInfoList = javaBeanInfo.sortedFields;
            MethodWriter methodWriter2 = new MethodWriter(classWriter, 1, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
            Label label8 = new Label();
            Label label9 = new Label();
            Label label10 = new Label();
            Label label11 = new Label();
            aSMDeserializerFactory2.defineVarLexer(context, methodWriter2);
            Label label12 = new Label();
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodWriter2.visitLdcInsn(14);
            methodWriter2.visitJumpInsn(160, label12);
            if ((javaBeanInfo.parserFeatures & Feature.SupportArrayToBean.mask) == 0) {
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitVarInsn(21, 4);
                methodWriter2.visitLdcInsn(Integer.valueOf(Feature.SupportArrayToBean.mask));
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "isEnabled", "(II)Z");
                methodWriter2.visitJumpInsn(153, label12);
            }
            methodWriter2.visitVarInsn(25, 0);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitVarInsn(25, 3);
            methodWriter2.visitInsn(1);
            methodWriter2.visitMethodInsn(183, context.className, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
            methodWriter2.visitInsn(Opcodes.ARETURN);
            methodWriter2.visitLabel(label12);
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitLdcInsn(Integer.valueOf(Feature.SortFeidFastMatch.mask));
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "isEnabled", "(I)Z");
            Label label13 = new Label();
            methodWriter2.visitJumpInsn(Opcodes.IFNE, label13);
            methodWriter2.visitJumpInsn(200, label9);
            methodWriter2.visitLabel(label13);
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitLdcInsn(context.clazz.getName());
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanType", "(Ljava/lang/String;)I");
            methodWriter2.visitLdcInsn(-1);
            Label label14 = new Label();
            methodWriter2.visitJumpInsn(160, label14);
            methodWriter2.visitJumpInsn(200, label9);
            methodWriter2.visitLabel(label14);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
            methodWriter2.visitVarInsn(58, context.var("mark_context"));
            methodWriter2.visitInsn(3);
            methodWriter2.visitVarInsn(54, context.var("matchedCount"));
            aSMDeserializerFactory2._createInstance(context, methodWriter2);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
            methodWriter2.visitVarInsn(58, context.var("context"));
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitVarInsn(25, context.var("context"));
            methodWriter2.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
            methodWriter2.visitVarInsn(25, 3);
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
            methodWriter2.visitVarInsn(58, context.var("childContext"));
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            String str3 = "matchStat";
            String str4 = "I";
            methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
            methodWriter2.visitLdcInsn(4);
            methodWriter2.visitJumpInsn(159, label10);
            int i7 = 3;
            methodWriter2.visitInsn(3);
            methodWriter2.visitIntInsn(54, context.var("matchStat"));
            int length = context.fieldInfoList.length;
            int i8 = 0;
            while (i8 < length) {
                methodWriter2.visitInsn(i7);
                methodWriter2.visitVarInsn(54, context.var("_asm_flag_" + (i8 / 32)));
                i8 += 32;
                i7 = 3;
            }
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitLdcInsn(Integer.valueOf(Feature.InitStringFieldAsEmpty.mask));
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "isEnabled", "(I)Z");
            methodWriter2.visitIntInsn(54, context.var("initStringFieldAsEmpty"));
            int i9 = 0;
            while (i9 < length) {
                Class<?> cls2 = context.fieldInfoList[i9].fieldClass;
                if (cls2 != Boolean.TYPE && cls2 != Byte.TYPE && cls2 != Short.TYPE && cls2 != Integer.TYPE) {
                    if (cls2 == Long.TYPE) {
                        methodWriter2.visitInsn(9);
                        methodWriter2.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
                    } else if (cls2 == Float.TYPE) {
                        methodWriter2.visitInsn(11);
                        methodWriter2.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
                    } else if (cls2 == Double.TYPE) {
                        methodWriter2.visitInsn(14);
                        methodWriter2.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
                    } else {
                        if (cls2 == String.class) {
                            Label label15 = new Label();
                            label5 = label9;
                            Label label16 = new Label();
                            label6 = label10;
                            label7 = label11;
                            methodWriter2.visitVarInsn(21, context.var("initStringFieldAsEmpty"));
                            methodWriter2.visitJumpInsn(153, label16);
                            aSMDeserializerFactory2._setFlag(methodWriter2, context, i9);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            label4 = label8;
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
                            methodWriter2.visitJumpInsn(167, label15);
                            methodWriter2.visitLabel(label16);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitLabel(label15);
                        } else {
                            label4 = label8;
                            label5 = label9;
                            label6 = label10;
                            label7 = label11;
                            methodWriter2.visitInsn(1);
                        }
                        methodWriter2.visitTypeInsn(192, ASMUtils.type(cls2));
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    }
                    label4 = label8;
                    label5 = label9;
                    label6 = label10;
                    label7 = label11;
                } else {
                    label4 = label8;
                    label5 = label9;
                    label6 = label10;
                    label7 = label11;
                    methodWriter2.visitInsn(3);
                    methodWriter2.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                }
                i9++;
                aSMDeserializerFactory2 = this;
                label9 = label5;
                label10 = label6;
                label11 = label7;
                label8 = label4;
            }
            Label label17 = label8;
            Label label18 = label9;
            Label label19 = label10;
            Label label20 = label11;
            int i10 = 0;
            while (i10 < length) {
                FieldInfo fieldInfo3 = context.fieldInfoList[i10];
                Class<?> cls3 = fieldInfo3.fieldClass;
                java.lang.reflect.Type type2 = fieldInfo3.fieldType;
                Label label21 = new Label();
                if (cls3 == Boolean.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldBoolean", "([C)Z");
                    methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                    i2 = length;
                } else {
                    i2 = length;
                    if (cls3 == Byte.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                        methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                    } else {
                        label = label21;
                        i3 = i10;
                        if (cls3 == Byte.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label22 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label22);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label22);
                        } else if (cls3 == Short.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                            methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                        } else if (cls3 == Short.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label23 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label23);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label23);
                        } else if (cls3 == Integer.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                            methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                        } else if (cls3 == Integer.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label24 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label24);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label24);
                        } else if (cls3 == Long.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldLong", "([C)J");
                            methodWriter2.visitVarInsn(55, context.var(fieldInfo3.name + "_asm", 2));
                        } else if (cls3 == Long.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldLong", "([C)J");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label25 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label25);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label25);
                        } else if (cls3 == Float.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloat", "([C)F");
                            methodWriter2.visitVarInsn(56, context.var(fieldInfo3.name + "_asm"));
                        } else if (cls3 == Float.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloat", "([C)F");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label26 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label26);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label26);
                        } else if (cls3 == Double.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDouble", "([C)D");
                            methodWriter2.visitVarInsn(57, context.var(fieldInfo3.name + "_asm", 2));
                        } else {
                            if (cls3 == Double.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDouble", "([C)D");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                                Label label27 = new Label();
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                methodWriter2.visitLdcInsn(5);
                                methodWriter2.visitJumpInsn(160, label27);
                                methodWriter2.visitInsn(1);
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                                methodWriter2.visitLabel(label27);
                            } else if (cls3 == String.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == Date.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDate", "([C)Ljava/util/Date;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == UUID.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldUUID", "([C)Ljava/util/UUID;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == BigDecimal.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDecimal", "([C)Ljava/math/BigDecimal;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == BigInteger.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldBigInteger", "([C)Ljava/math/BigInteger;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == int[].class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldIntArray", "([C)[I");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == float[].class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloatArray", "([C)[F");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == float[][].class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloatArray2", "([C)[[F");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3.isEnum()) {
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                aSMDeserializerFactory = this;
                                aSMDeserializerFactory._getFieldDeser(context, methodWriter2, fieldInfo3);
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "scanEnum", "(L" + JSONLexerBase + ";[C" + ASMUtils.desc(ObjectDeserializer.class) + ")Ljava/lang/Enum;");
                                methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                                StringBuilder sb = new StringBuilder();
                                sb.append(fieldInfo3.name);
                                sb.append("_asm");
                                methodWriter2.visitVarInsn(58, context.var(sb.toString()));
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                Label label28 = new Label();
                                methodWriter2.visitJumpInsn(158, label28);
                                i6 = i3;
                                aSMDeserializerFactory._setFlag(methodWriter2, context, i6);
                                methodWriter2.visitLabel(label28);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                methodWriter2.visitInsn(89);
                                methodWriter2.visitVarInsn(54, context.var(str3));
                                methodWriter2.visitLdcInsn(-1);
                                Label label29 = label17;
                                methodWriter2.visitJumpInsn(159, label29);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                Label label30 = label;
                                methodWriter2.visitJumpInsn(158, label30);
                                methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                                methodWriter2.visitInsn(4);
                                methodWriter2.visitInsn(96);
                                methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                methodWriter2.visitLdcInsn(4);
                                Label label31 = label20;
                                methodWriter2.visitJumpInsn(159, label31);
                                methodWriter2.visitLabel(label30);
                                if (i6 == i2 - 1) {
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                    methodWriter2.visitLdcInsn(4);
                                    methodWriter2.visitJumpInsn(160, label29);
                                }
                                str = str3;
                                label3 = label29;
                                str2 = str4;
                                label2 = label31;
                                methodWriter = methodWriter2;
                                i4 = i2;
                                i5 = i6;
                                int i11 = i5 + 1;
                                label20 = label2;
                                methodWriter2 = methodWriter;
                                label17 = label3;
                                length = i4;
                                str3 = str;
                                str4 = str2;
                                i10 = i11;
                            } else {
                                aSMDeserializerFactory = this;
                                if (Collection.class.isAssignableFrom(cls3)) {
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    methodWriter2.visitVarInsn(25, 0);
                                    methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                    Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type2);
                                    if (collectionItemClass == String.class) {
                                        methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.desc(Collection.class));
                                        methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                        Label label282 = new Label();
                                        methodWriter2.visitJumpInsn(158, label282);
                                        i6 = i3;
                                        aSMDeserializerFactory._setFlag(methodWriter2, context, i6);
                                        methodWriter2.visitLabel(label282);
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                        methodWriter2.visitInsn(89);
                                        methodWriter2.visitVarInsn(54, context.var(str3));
                                        methodWriter2.visitLdcInsn(-1);
                                        Label label292 = label17;
                                        methodWriter2.visitJumpInsn(159, label292);
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                        Label label302 = label;
                                        methodWriter2.visitJumpInsn(158, label302);
                                        methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                                        methodWriter2.visitInsn(4);
                                        methodWriter2.visitInsn(96);
                                        methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                                        methodWriter2.visitLdcInsn(4);
                                        Label label312 = label20;
                                        methodWriter2.visitJumpInsn(159, label312);
                                        methodWriter2.visitLabel(label302);
                                        if (i6 == i2 - 1) {
                                        }
                                        str = str3;
                                        label3 = label292;
                                        str2 = str4;
                                        label2 = label312;
                                        methodWriter = methodWriter2;
                                        i4 = i2;
                                        i5 = i6;
                                    } else {
                                        label2 = label20;
                                        str = str3;
                                        i4 = i2;
                                        MethodWriter methodWriter3 = methodWriter2;
                                        str2 = str4;
                                        methodWriter = methodWriter2;
                                        i5 = i3;
                                        _deserialze_list_obj(context, methodWriter3, label17, fieldInfo3, cls3, collectionItemClass, i5);
                                        if (i5 == i4 - 1) {
                                            Label label32 = label17;
                                            aSMDeserializerFactory._deserialize_endCheck(context, methodWriter, label32);
                                            label3 = label32;
                                        } else {
                                            label3 = label17;
                                        }
                                    }
                                } else {
                                    str = str3;
                                    str2 = str4;
                                    methodWriter = methodWriter2;
                                    label2 = label20;
                                    Label label33 = label17;
                                    i4 = i2;
                                    i5 = i3;
                                    label3 = label33;
                                    _deserialze_obj(context, methodWriter, label33, fieldInfo3, cls3, i5);
                                    if (i5 == i4 - 1) {
                                        aSMDeserializerFactory._deserialize_endCheck(context, methodWriter, label3);
                                    }
                                }
                                int i112 = i5 + 1;
                                label20 = label2;
                                methodWriter2 = methodWriter;
                                label17 = label3;
                                length = i4;
                                str3 = str;
                                str4 = str2;
                                i10 = i112;
                            }
                            aSMDeserializerFactory = this;
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            Label label2822 = new Label();
                            methodWriter2.visitJumpInsn(158, label2822);
                            i6 = i3;
                            aSMDeserializerFactory._setFlag(methodWriter2, context, i6);
                            methodWriter2.visitLabel(label2822);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            methodWriter2.visitInsn(89);
                            methodWriter2.visitVarInsn(54, context.var(str3));
                            methodWriter2.visitLdcInsn(-1);
                            Label label2922 = label17;
                            methodWriter2.visitJumpInsn(159, label2922);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            Label label3022 = label;
                            methodWriter2.visitJumpInsn(158, label3022);
                            methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                            methodWriter2.visitInsn(4);
                            methodWriter2.visitInsn(96);
                            methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                            methodWriter2.visitLdcInsn(4);
                            Label label3122 = label20;
                            methodWriter2.visitJumpInsn(159, label3122);
                            methodWriter2.visitLabel(label3022);
                            if (i6 == i2 - 1) {
                            }
                            str = str3;
                            label3 = label2922;
                            str2 = str4;
                            label2 = label3122;
                            methodWriter = methodWriter2;
                            i4 = i2;
                            i5 = i6;
                            int i1122 = i5 + 1;
                            label20 = label2;
                            methodWriter2 = methodWriter;
                            label17 = label3;
                            length = i4;
                            str3 = str;
                            str4 = str2;
                            i10 = i1122;
                        }
                        aSMDeserializerFactory = this;
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                        Label label28222 = new Label();
                        methodWriter2.visitJumpInsn(158, label28222);
                        i6 = i3;
                        aSMDeserializerFactory._setFlag(methodWriter2, context, i6);
                        methodWriter2.visitLabel(label28222);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                        methodWriter2.visitInsn(89);
                        methodWriter2.visitVarInsn(54, context.var(str3));
                        methodWriter2.visitLdcInsn(-1);
                        Label label29222 = label17;
                        methodWriter2.visitJumpInsn(159, label29222);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                        Label label30222 = label;
                        methodWriter2.visitJumpInsn(158, label30222);
                        methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                        methodWriter2.visitInsn(4);
                        methodWriter2.visitInsn(96);
                        methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                        methodWriter2.visitLdcInsn(4);
                        Label label31222 = label20;
                        methodWriter2.visitJumpInsn(159, label31222);
                        methodWriter2.visitLabel(label30222);
                        if (i6 == i2 - 1) {
                        }
                        str = str3;
                        label3 = label29222;
                        str2 = str4;
                        label2 = label31222;
                        methodWriter = methodWriter2;
                        i4 = i2;
                        i5 = i6;
                        int i11222 = i5 + 1;
                        label20 = label2;
                        methodWriter2 = methodWriter;
                        label17 = label3;
                        length = i4;
                        str3 = str;
                        str4 = str2;
                        i10 = i11222;
                    }
                }
                i3 = i10;
                label = label21;
                aSMDeserializerFactory = this;
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                Label label282222 = new Label();
                methodWriter2.visitJumpInsn(158, label282222);
                i6 = i3;
                aSMDeserializerFactory._setFlag(methodWriter2, context, i6);
                methodWriter2.visitLabel(label282222);
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                methodWriter2.visitInsn(89);
                methodWriter2.visitVarInsn(54, context.var(str3));
                methodWriter2.visitLdcInsn(-1);
                Label label292222 = label17;
                methodWriter2.visitJumpInsn(159, label292222);
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                Label label302222 = label;
                methodWriter2.visitJumpInsn(158, label302222);
                methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                methodWriter2.visitInsn(4);
                methodWriter2.visitInsn(96);
                methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(180, JSONLexerBase, str3, str4);
                methodWriter2.visitLdcInsn(4);
                Label label312222 = label20;
                methodWriter2.visitJumpInsn(159, label312222);
                methodWriter2.visitLabel(label302222);
                if (i6 == i2 - 1) {
                }
                str = str3;
                label3 = label292222;
                str2 = str4;
                label2 = label312222;
                methodWriter = methodWriter2;
                i4 = i2;
                i5 = i6;
                int i112222 = i5 + 1;
                label20 = label2;
                methodWriter2 = methodWriter;
                label17 = label3;
                length = i4;
                str3 = str;
                str4 = str2;
                i10 = i112222;
            }
            int i12 = length;
            MethodWriter methodWriter4 = methodWriter2;
            Label label34 = label17;
            methodWriter4.visitLabel(label20);
            if (!context.clazz.isInterface() && !Modifier.isAbstract(context.clazz.getModifiers())) {
                _batchSet(context, methodWriter4);
            }
            methodWriter4.visitLabel(label19);
            _setContext(context, methodWriter4);
            methodWriter4.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
            Method method = context.beanInfo.buildMethod;
            if (method != null) {
                methodWriter4.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(context.getInstClass()), method.getName(), "()" + ASMUtils.desc(method.getReturnType()));
            }
            methodWriter4.visitInsn(Opcodes.ARETURN);
            methodWriter4.visitLabel(label34);
            _batchSet(context, methodWriter4);
            methodWriter4.visitVarInsn(25, 0);
            methodWriter4.visitVarInsn(25, 1);
            methodWriter4.visitVarInsn(25, 2);
            methodWriter4.visitVarInsn(25, 3);
            methodWriter4.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
            methodWriter4.visitVarInsn(21, 4);
            int i13 = i12 / 32;
            if (i12 != 0 && i12 % 32 != 0) {
                i13++;
            }
            if (i13 == 1) {
                methodWriter4.visitInsn(4);
            } else {
                methodWriter4.visitIntInsn(16, i13);
            }
            methodWriter4.visitIntInsn(Opcodes.NEWARRAY, 10);
            for (int i14 = 0; i14 < i13; i14++) {
                methodWriter4.visitInsn(89);
                if (i14 == 0) {
                    methodWriter4.visitInsn(3);
                } else if (i14 == 1) {
                    methodWriter4.visitInsn(4);
                } else {
                    methodWriter4.visitIntInsn(16, i14);
                }
                methodWriter4.visitVarInsn(21, context.var("_asm_flag_" + i14));
                methodWriter4.visitInsn(79);
            }
            methodWriter4.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "parseRest", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;");
            methodWriter4.visitTypeInsn(192, ASMUtils.type(context.clazz));
            methodWriter4.visitInsn(Opcodes.ARETURN);
            methodWriter4.visitLabel(label18);
            methodWriter4.visitVarInsn(25, 0);
            methodWriter4.visitVarInsn(25, 1);
            methodWriter4.visitVarInsn(25, 2);
            methodWriter4.visitVarInsn(25, 3);
            methodWriter4.visitVarInsn(21, 4);
            methodWriter4.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            methodWriter4.visitInsn(Opcodes.ARETURN);
            methodWriter4.visitMaxs(10, context.variantIndex);
            methodWriter4.visitEnd();
        }
    }

    private void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        int i2;
        MethodWriter methodWriter;
        Class<JavaBeanDeserializer> cls;
        int i3;
        FieldInfo[] fieldInfoArr;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, classWriter, context) == null) {
            Class<JavaBeanDeserializer> cls2 = JavaBeanDeserializer.class;
            MethodWriter methodWriter2 = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
            defineVarLexer(context, methodWriter2);
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitVarInsn(25, 1);
            String str = DefaultJSONParser;
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
            String str2 = JSONLexerBase;
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "scanTypeName", "(" + ASMUtils.desc(SymbolTable.class) + ")Ljava/lang/String;");
            methodWriter2.visitVarInsn(58, context.var(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME));
            Label label = new Label();
            methodWriter2.visitVarInsn(25, context.var(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME));
            methodWriter2.visitJumpInsn(Opcodes.IFNULL, label);
            methodWriter2.visitVarInsn(25, 1);
            String str3 = DefaultJSONParser;
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str3, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
            methodWriter2.visitVarInsn(25, 0);
            methodWriter2.visitFieldInsn(180, ASMUtils.type(cls2), "beanInfo", ASMUtils.desc(JavaBeanInfo.class));
            methodWriter2.visitVarInsn(25, context.var(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME));
            String type = ASMUtils.type(cls2);
            methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, type, "getSeeAlso", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + "Ljava/lang/String;)" + ASMUtils.desc(cls2));
            methodWriter2.visitVarInsn(58, context.var("userTypeDeser"));
            methodWriter2.visitVarInsn(25, context.var("userTypeDeser"));
            methodWriter2.visitTypeInsn(193, ASMUtils.type(cls2));
            methodWriter2.visitJumpInsn(153, label);
            methodWriter2.visitVarInsn(25, context.var("userTypeDeser"));
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitVarInsn(25, 3);
            methodWriter2.visitVarInsn(25, 4);
            String type2 = ASMUtils.type(cls2);
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type2, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
            methodWriter2.visitInsn(Opcodes.ARETURN);
            methodWriter2.visitLabel(label);
            _createInstance(context, methodWriter2);
            FieldInfo[] fieldInfoArr2 = context.beanInfo.sortedFields;
            int length = fieldInfoArr2.length;
            int i5 = 0;
            while (i5 < length) {
                boolean z = i5 == length + (-1);
                int i6 = z ? 93 : 44;
                FieldInfo fieldInfo = fieldInfoArr2[i5];
                Class<?> cls3 = fieldInfo.fieldClass;
                java.lang.reflect.Type type3 = fieldInfo.fieldType;
                int i7 = length;
                FieldInfo[] fieldInfoArr3 = fieldInfoArr2;
                if (cls3 != Byte.TYPE && cls3 != Short.TYPE && cls3 != Integer.TYPE) {
                    boolean z2 = z;
                    int i8 = i5;
                    if (cls3 == Byte.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        Label label2 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(160, label2);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter2.visitLabel(label2);
                    } else if (cls3 == Short.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        Label label3 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(160, label3);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter2.visitLabel(label3);
                    } else if (cls3 == Integer.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        Label label4 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(160, label4);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter2.visitLabel(label4);
                    } else if (cls3 == Long.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                        methodWriter2.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
                    } else if (cls3 == Long.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        Label label5 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(160, label5);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter2.visitLabel(label5);
                    } else if (cls3 == Boolean.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanBoolean", "(C)Z");
                        methodWriter2.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == Float.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFloat", "(C)F");
                        methodWriter2.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == Float.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFloat", "(C)F");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        Label label6 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(160, label6);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter2.visitLabel(label6);
                    } else if (cls3 == Double.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDouble", "(C)D");
                        methodWriter2.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
                    } else if (cls3 == Double.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDouble", "(C)D");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        Label label7 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(160, label7);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter2.visitLabel(label7);
                    } else if (cls3 == Character.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                        methodWriter2.visitInsn(3);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "charAt", "(I)C");
                        methodWriter2.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == String.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == BigDecimal.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == Date.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDate", "(C)Ljava/util/Date;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    } else if (cls3 == UUID.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanUUID", "(C)Ljava/util/UUID;");
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    } else if (cls3.isEnum()) {
                        Label label8 = new Label();
                        Label label9 = new Label();
                        Label label10 = new Label();
                        Label label11 = new Label();
                        cls = cls2;
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
                        methodWriter2.visitInsn(89);
                        methodWriter2.visitVarInsn(54, context.var("ch"));
                        methodWriter2.visitLdcInsn(110);
                        methodWriter2.visitJumpInsn(159, label11);
                        methodWriter2.visitVarInsn(21, context.var("ch"));
                        methodWriter2.visitLdcInsn(34);
                        methodWriter2.visitJumpInsn(160, label8);
                        methodWriter2.visitLabel(label11);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                        methodWriter2.visitVarInsn(25, 1);
                        String str4 = DefaultJSONParser;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
                        methodWriter2.visitVarInsn(16, i6);
                        String str5 = JSONLexerBase;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc(SymbolTable.class) + "C)Ljava/lang/Enum;");
                        methodWriter2.visitJumpInsn(167, label10);
                        methodWriter2.visitLabel(label8);
                        methodWriter2.visitVarInsn(21, context.var("ch"));
                        methodWriter2.visitLdcInsn(48);
                        methodWriter2.visitJumpInsn(161, label9);
                        methodWriter2.visitVarInsn(21, context.var("ch"));
                        methodWriter2.visitLdcInsn(57);
                        methodWriter2.visitJumpInsn(163, label9);
                        _getFieldDeser(context, methodWriter2, fieldInfo);
                        methodWriter2.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                        methodWriter2.visitJumpInsn(167, label10);
                        methodWriter2.visitLabel(label9);
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(16, i6);
                        String type4 = ASMUtils.type(cls);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type4, "scanEnum", "(L" + JSONLexerBase + ";C)Ljava/lang/Enum;");
                        methodWriter2.visitLabel(label10);
                        methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter = methodWriter2;
                        i3 = i7;
                        fieldInfoArr = fieldInfoArr3;
                        i2 = i8;
                    } else {
                        cls = cls2;
                        if (Collection.class.isAssignableFrom(cls3)) {
                            Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type3);
                            if (collectionItemClass == String.class) {
                                if (cls3 != List.class && cls3 != Collections.class && cls3 != ArrayList.class) {
                                    methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                    methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                                } else {
                                    methodWriter2.visitTypeInsn(Opcodes.NEW, ASMUtils.type(ArrayList.class));
                                    methodWriter2.visitInsn(89);
                                    methodWriter2.visitMethodInsn(183, ASMUtils.type(ArrayList.class), "<init>", "()V");
                                }
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                                methodWriter2.visitVarInsn(16, i6);
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanStringArray", "(Ljava/util/Collection;C)V");
                                Label label12 = new Label();
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                                methodWriter2.visitLdcInsn(5);
                                methodWriter2.visitJumpInsn(160, label12);
                                methodWriter2.visitInsn(1);
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                                methodWriter2.visitLabel(label12);
                                i4 = i8;
                            } else {
                                Label label13 = new Label();
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
                                methodWriter2.visitVarInsn(54, context.var("token"));
                                methodWriter2.visitVarInsn(21, context.var("token"));
                                int i9 = i8 == 0 ? 14 : 16;
                                methodWriter2.visitLdcInsn(Integer.valueOf(i9));
                                methodWriter2.visitJumpInsn(159, label13);
                                methodWriter2.visitVarInsn(25, 1);
                                methodWriter2.visitLdcInsn(Integer.valueOf(i9));
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "throwException", "(I)V");
                                methodWriter2.visitLabel(label13);
                                Label label14 = new Label();
                                Label label15 = new Label();
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
                                methodWriter2.visitVarInsn(16, 91);
                                methodWriter2.visitJumpInsn(160, label14);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
                                methodWriter2.visitInsn(87);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitLdcInsn(14);
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
                                methodWriter2.visitJumpInsn(167, label15);
                                methodWriter2.visitLabel(label14);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitLdcInsn(14);
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
                                methodWriter2.visitLabel(label15);
                                i4 = i8;
                                _newCollection(methodWriter2, cls3, i4, false);
                                methodWriter2.visitInsn(89);
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                                _getCollectionFieldItemDeser(context, methodWriter2, fieldInfo, collectionItemClass);
                                methodWriter2.visitVarInsn(25, 1);
                                methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(collectionItemClass)));
                                methodWriter2.visitVarInsn(25, 3);
                                String type5 = ASMUtils.type(cls);
                                methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, type5, "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc(ObjectDeserializer.class) + "L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            }
                            i2 = i4;
                            methodWriter = methodWriter2;
                            i3 = i7;
                            fieldInfoArr = fieldInfoArr3;
                        } else if (cls3.isArray()) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitLdcInsn(14);
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
                            methodWriter2.visitVarInsn(25, 1);
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitLdcInsn(Integer.valueOf(i8));
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                            methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                            i2 = i8;
                            methodWriter = methodWriter2;
                            i3 = i7;
                            fieldInfoArr = fieldInfoArr3;
                        } else {
                            Label label16 = new Label();
                            Label label17 = new Label();
                            if (cls3 == Date.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
                                methodWriter2.visitLdcInsn(49);
                                methodWriter2.visitJumpInsn(160, label16);
                                methodWriter2.visitTypeInsn(Opcodes.NEW, ASMUtils.type(Date.class));
                                methodWriter2.visitInsn(89);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(16, i6);
                                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                                methodWriter2.visitMethodInsn(183, ASMUtils.type(Date.class), "<init>", "(J)V");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                                methodWriter2.visitJumpInsn(167, label17);
                            }
                            methodWriter2.visitLabel(label16);
                            _quickNextToken(context, methodWriter2, 14);
                            i2 = i8;
                            i3 = i7;
                            fieldInfoArr = fieldInfoArr3;
                            methodWriter = methodWriter2;
                            _deserObject(context, methodWriter2, fieldInfo, cls3, i2);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
                            methodWriter.visitLdcInsn(15);
                            methodWriter.visitJumpInsn(159, label17);
                            methodWriter.visitVarInsn(25, 0);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            if (!z2) {
                                methodWriter.visitLdcInsn(16);
                            } else {
                                methodWriter.visitLdcInsn(15);
                            }
                            String type6 = ASMUtils.type(cls);
                            methodWriter.visitMethodInsn(183, type6, BundleOpProvider.METHOD_BUNDLE_CHECK, "(" + ASMUtils.desc(JSONLexer.class) + "I)V");
                            methodWriter.visitLabel(label17);
                        }
                    }
                    methodWriter = methodWriter2;
                    cls = cls2;
                    i3 = i7;
                    fieldInfoArr = fieldInfoArr3;
                    i2 = i8;
                } else {
                    i2 = i5;
                    methodWriter = methodWriter2;
                    cls = cls2;
                    i3 = i7;
                    fieldInfoArr = fieldInfoArr3;
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i6);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                    methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                }
                i5 = i2 + 1;
                length = i3;
                methodWriter2 = methodWriter;
                fieldInfoArr2 = fieldInfoArr;
                cls2 = cls;
            }
            MethodWriter methodWriter3 = methodWriter2;
            _batchSet(context, methodWriter3, false);
            Label label18 = new Label();
            Label label19 = new Label();
            Label label20 = new Label();
            Label label21 = new Label();
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
            methodWriter3.visitInsn(89);
            methodWriter3.visitVarInsn(54, context.var("ch"));
            methodWriter3.visitVarInsn(16, 44);
            methodWriter3.visitJumpInsn(160, label19);
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
            methodWriter3.visitInsn(87);
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitLdcInsn(16);
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodWriter3.visitJumpInsn(167, label21);
            methodWriter3.visitLabel(label19);
            methodWriter3.visitVarInsn(21, context.var("ch"));
            methodWriter3.visitVarInsn(16, 93);
            methodWriter3.visitJumpInsn(160, label20);
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
            methodWriter3.visitInsn(87);
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitLdcInsn(15);
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodWriter3.visitJumpInsn(167, label21);
            methodWriter3.visitLabel(label20);
            methodWriter3.visitVarInsn(21, context.var("ch"));
            methodWriter3.visitVarInsn(16, 26);
            methodWriter3.visitJumpInsn(160, label18);
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
            methodWriter3.visitInsn(87);
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitLdcInsn(20);
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodWriter3.visitJumpInsn(167, label21);
            methodWriter3.visitLabel(label18);
            methodWriter3.visitVarInsn(25, context.var("lexer"));
            methodWriter3.visitLdcInsn(16);
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
            methodWriter3.visitLabel(label21);
            methodWriter3.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
            methodWriter3.visitInsn(Opcodes.ARETURN);
            methodWriter3.visitMaxs(5, context.variantIndex);
            methodWriter3.visitEnd();
        }
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i2) {
        String str;
        String str2;
        String str3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{context, methodVisitor, label, fieldInfo, cls, cls2, Integer.valueOf(i2)}) == null) {
            Label label2 = new Label();
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "matchField", "([C)Z");
            methodVisitor.visitJumpInsn(153, label2);
            _setFlag(methodVisitor, context, i2);
            Label label3 = new Label();
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(8);
            methodVisitor.visitJumpInsn(160, label3);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(16);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label3);
            Label label4 = new Label();
            Label label5 = new Label();
            Label label6 = new Label();
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(21);
            methodVisitor.visitJumpInsn(160, label5);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(14);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
            _newCollection(methodVisitor, cls, i2, true);
            methodVisitor.visitJumpInsn(167, label4);
            methodVisitor.visitLabel(label5);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(14);
            methodVisitor.visitJumpInsn(159, label6);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(12);
            methodVisitor.visitJumpInsn(160, label);
            _newCollection(methodVisitor, cls, i2, false);
            methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            String type = ASMUtils.type(ObjectDeserializer.class);
            methodVisitor.visitMethodInsn(185, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
            methodVisitor.visitVarInsn(58, context.var("list_item_value"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitVarInsn(25, context.var("list_item_value"));
            if (cls.isInterface()) {
                str = "list_item_value";
                methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
            } else {
                str = "list_item_value";
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
            }
            methodVisitor.visitInsn(87);
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label6);
            _newCollection(methodVisitor, cls, i2, false);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            boolean isPrimitive2 = ParserConfig.isPrimitive2(fieldInfo.fieldClass);
            _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
            if (isPrimitive2) {
                methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
                methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
                methodVisitor.visitVarInsn(25, context.var("lexer"));
                methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
                str2 = "(I)V";
                str3 = "nextToken";
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, str3, str2);
            } else {
                str2 = "(I)V";
                str3 = "nextToken";
                methodVisitor.visitInsn(87);
                methodVisitor.visitLdcInsn(12);
                methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
                _quickNextToken(context, methodVisitor, 12);
            }
            methodVisitor.visitVarInsn(25, 1);
            String str4 = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "getContext", "()" + ASMUtils.desc(ParseContext.class));
            methodVisitor.visitVarInsn(58, context.var("listContext"));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitLdcInsn(fieldInfo.name);
            String str5 = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
            methodVisitor.visitInsn(87);
            Label label7 = new Label();
            Label label8 = new Label();
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, context.var("i"));
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            String str6 = str2;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(15);
            methodVisitor.visitJumpInsn(159, label8);
            methodVisitor.visitVarInsn(25, 0);
            String str7 = context.className;
            String str8 = str3;
            methodVisitor.visitFieldInsn(180, str7, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
            methodVisitor.visitVarInsn(21, context.var("i"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            String type2 = ASMUtils.type(ObjectDeserializer.class);
            methodVisitor.visitMethodInsn(185, type2, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
            String str9 = str;
            methodVisitor.visitVarInsn(58, context.var(str9));
            methodVisitor.visitIincInsn(context.var("i"), 1);
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitVarInsn(25, context.var(str9));
            if (cls.isInterface()) {
                methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
            } else {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
            }
            methodVisitor.visitInsn(87);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "checkListResolve", "(Ljava/util/Collection;)V");
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(16);
            methodVisitor.visitJumpInsn(160, label7);
            if (isPrimitive2) {
                methodVisitor.visitVarInsn(25, context.var("lexer"));
                methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, str8, str6);
                i3 = 167;
            } else {
                _quickNextToken(context, methodVisitor, 12);
                i3 = 167;
            }
            methodVisitor.visitJumpInsn(i3, label7);
            methodVisitor.visitLabel(label8);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("listContext"));
            String str10 = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
            methodVisitor.visitLdcInsn(15);
            methodVisitor.visitJumpInsn(160, label);
            _quickNextTokenComma(context, methodVisitor);
            methodVisitor.visitLabel(label2);
        }
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{context, methodVisitor, label, fieldInfo, cls, Integer.valueOf(i2)}) == null) {
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(25, 0);
            String str = context.className;
            methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_prefix__", "[C");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "matchField", "([C)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label2);
            methodVisitor.visitInsn(1);
            methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitJumpInsn(167, label3);
            methodVisitor.visitLabel(label2);
            _setFlag(methodVisitor, context, i2);
            methodVisitor.visitVarInsn(21, context.var("matchedCount"));
            methodVisitor.visitInsn(4);
            methodVisitor.visitInsn(96);
            methodVisitor.visitVarInsn(54, context.var("matchedCount"));
            _deserObject(context, methodVisitor, fieldInfo, cls, i2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getResolveStatus", "()I");
            methodVisitor.visitLdcInsn(1);
            methodVisitor.visitJumpInsn(160, label3);
            methodVisitor.visitVarInsn(25, 1);
            String str2 = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "getLastResolveTask", "()" + ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
            methodVisitor.visitVarInsn(58, context.var("resolveTask"));
            methodVisitor.visitVarInsn(25, context.var("resolveTask"));
            methodVisitor.visitVarInsn(25, 1);
            String str3 = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str3, "getContext", "()" + ASMUtils.desc(ParseContext.class));
            methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
            methodVisitor.visitVarInsn(25, context.var("resolveTask"));
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(fieldInfo.name);
            String type = ASMUtils.type(JavaBeanDeserializer.class);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.desc(FieldDeserializer.class));
            methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitLdcInsn(0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setResolveStatus", "(I)V");
            methodVisitor.visitLabel(label3);
        }
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, this, context, methodVisitor, fieldInfo, cls) == null) {
            Label label = new Label();
            methodVisitor.visitVarInsn(25, 0);
            String str = context.className;
            methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            String str2 = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            String type = ASMUtils.type(ParserConfig.class);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
            String str3 = context.className;
            methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, 0);
            String str4 = context.className;
            methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        }
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, context, methodVisitor, fieldInfo) == null) {
            Label label = new Label();
            methodVisitor.visitVarInsn(25, 0);
            String str = context.className;
            methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            String str2 = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            String type = ASMUtils.type(ParserConfig.class);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
            String str3 = context.className;
            methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, 0);
            String str4 = context.className;
            methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        }
    }

    private void _init(ClassWriter classWriter, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, classWriter, context) == null) {
            int length = context.fieldInfoList.length;
            for (int i2 = 0; i2 < length; i2++) {
                FieldInfo fieldInfo = context.fieldInfoList[i2];
                new FieldWriter(classWriter, 1, fieldInfo.name + "_asm_prefix__", "[C").visitEnd();
            }
            int length2 = context.fieldInfoList.length;
            for (int i3 = 0; i3 < length2; i3++) {
                FieldInfo fieldInfo2 = context.fieldInfoList[i3];
                Class<?> cls = fieldInfo2.fieldClass;
                if (!cls.isPrimitive()) {
                    if (Collection.class.isAssignableFrom(cls)) {
                        new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                    } else {
                        new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                    }
                }
            }
            MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V", null, null);
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitVarInsn(25, 1);
            methodWriter.visitVarInsn(25, 2);
            String type = ASMUtils.type(JavaBeanDeserializer.class);
            methodWriter.visitMethodInsn(183, type, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V");
            int length3 = context.fieldInfoList.length;
            for (int i4 = 0; i4 < length3; i4++) {
                FieldInfo fieldInfo3 = context.fieldInfoList[i4];
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitLdcInsn("\"" + fieldInfo3.name + "\":");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toCharArray", "()[C");
                String str = context.className;
                methodWriter.visitFieldInsn(181, str, fieldInfo3.name + "_asm_prefix__", "[C");
            }
            methodWriter.visitInsn(177);
            methodWriter.visitMaxs(4, 4);
            methodWriter.visitEnd();
        }
    }

    private void _isFlag(MethodVisitor methodVisitor, Context context, int i2, Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65551, this, methodVisitor, context, i2, label) == null) {
            methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i2 / 32)));
            methodVisitor.visitLdcInsn(Integer.valueOf(1 << i2));
            methodVisitor.visitInsn(126);
            methodVisitor.visitJumpInsn(153, label);
        }
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, this, context, methodVisitor, fieldInfo) == null) {
            Class<?> cls = fieldInfo.fieldClass;
            java.lang.reflect.Type type = fieldInfo.fieldType;
            if (cls == Boolean.TYPE) {
                methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
                _set(context, methodVisitor, fieldInfo);
            } else if (cls != Byte.TYPE && cls != Short.TYPE && cls != Integer.TYPE && cls != Character.TYPE) {
                if (cls == Long.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                    methodVisitor.visitVarInsn(22, context.var(fieldInfo.name + "_asm", 2));
                    if (fieldInfo.method != null) {
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
                        if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                            return;
                        }
                        methodVisitor.visitInsn(87);
                        return;
                    }
                    methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
                } else if (cls == Float.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                    methodVisitor.visitVarInsn(23, context.var(fieldInfo.name + "_asm"));
                    _set(context, methodVisitor, fieldInfo);
                } else if (cls != Double.TYPE) {
                    if (cls == String.class) {
                        methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                        _set(context, methodVisitor, fieldInfo);
                    } else if (cls.isEnum()) {
                        methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                        _set(context, methodVisitor, fieldInfo);
                    } else if (Collection.class.isAssignableFrom(cls)) {
                        methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                        if (TypeUtils.getCollectionItemClass(type) == String.class) {
                            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                            methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
                        } else {
                            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                        }
                        _set(context, methodVisitor, fieldInfo);
                    } else {
                        methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                        _set(context, methodVisitor, fieldInfo);
                    }
                } else {
                    methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                    methodVisitor.visitVarInsn(24, context.var(fieldInfo.name + "_asm", 2));
                    _set(context, methodVisitor, fieldInfo);
                }
            } else {
                methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
                methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
                _set(context, methodVisitor, fieldInfo);
            }
        }
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{methodVisitor, cls, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (cls.isAssignableFrom(ArrayList.class) && !z) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList");
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
            } else if (cls.isAssignableFrom(LinkedList.class) && !z) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(LinkedList.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedList.class), "<init>", "()V");
            } else if (cls.isAssignableFrom(HashSet.class)) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(HashSet.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
            } else if (cls.isAssignableFrom(TreeSet.class)) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(TreeSet.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, ASMUtils.type(TreeSet.class), "<init>", "()V");
            } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(LinkedHashSet.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
            } else if (z) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(HashSet.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
            } else {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitLdcInsn(Integer.valueOf(i2));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
            }
            methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
        }
    }

    private void _quickNextToken(Context context, MethodVisitor methodVisitor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65554, this, context, methodVisitor, i2) == null) {
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
            if (i2 == 12) {
                methodVisitor.visitVarInsn(16, 123);
            } else if (i2 == 14) {
                methodVisitor.visitVarInsn(16, 91);
            } else {
                throw new IllegalStateException();
            }
            methodVisitor.visitJumpInsn(160, label);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
            methodVisitor.visitInsn(87);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(Integer.valueOf(i2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(Integer.valueOf(i2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
            methodVisitor.visitLabel(label2);
        }
    }

    private void _quickNextTokenComma(Context context, MethodVisitor methodVisitor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, context, methodVisitor) == null) {
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(54, context.var("ch"));
            methodVisitor.visitVarInsn(16, 44);
            methodVisitor.visitJumpInsn(160, label2);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
            methodVisitor.visitInsn(87);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(16);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodVisitor.visitJumpInsn(167, label5);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitVarInsn(21, context.var("ch"));
            methodVisitor.visitVarInsn(16, 125);
            methodVisitor.visitJumpInsn(160, label3);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
            methodVisitor.visitInsn(87);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(13);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodVisitor.visitJumpInsn(167, label5);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(21, context.var("ch"));
            methodVisitor.visitVarInsn(16, 93);
            methodVisitor.visitJumpInsn(160, label4);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "next", "()C");
            methodVisitor.visitInsn(87);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(15);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodVisitor.visitJumpInsn(167, label5);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitVarInsn(21, context.var("ch"));
            methodVisitor.visitVarInsn(16, 26);
            methodVisitor.visitJumpInsn(160, label);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitLdcInsn(20);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
            methodVisitor.visitJumpInsn(167, label5);
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "()V");
            methodVisitor.visitLabel(label5);
        }
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, this, context, methodVisitor, fieldInfo) == null) {
            Method method = fieldInfo.method;
            if (method != null) {
                methodVisitor.visitMethodInsn(method.getDeclaringClass().isInterface() ? 185 : Opcodes.INVOKEVIRTUAL, ASMUtils.type(fieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
                if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                    return;
                }
                methodVisitor.visitInsn(87);
                return;
            }
            methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
        }
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, this, context, methodVisitor) == null) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("context"));
            String str = DefaultJSONParser;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
            Label label = new Label();
            methodVisitor.visitVarInsn(25, context.var("childContext"));
            methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
            methodVisitor.visitVarInsn(25, context.var("childContext"));
            methodVisitor.visitVarInsn(25, context.var(Transition.MATCH_INSTANCE_STR));
            methodVisitor.visitFieldInsn(181, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
            methodVisitor.visitLabel(label);
        }
    }

    private void _setFlag(MethodVisitor methodVisitor, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65558, this, methodVisitor, context, i2) == null) {
            String str = "_asm_flag_" + (i2 / 32);
            methodVisitor.visitVarInsn(21, context.var(str));
            methodVisitor.visitLdcInsn(Integer.valueOf(1 << i2));
            methodVisitor.visitInsn(128);
            methodVisitor.visitVarInsn(54, context.var(str));
        }
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, context, methodVisitor) == null) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
            methodVisitor.visitTypeInsn(192, JSONLexerBase);
            methodVisitor.visitVarInsn(58, context.var("lexer"));
        }
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) throws Exception {
        InterceptResult invokeLL;
        Class<?> cls;
        String str;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, parserConfig, javaBeanInfo)) == null) {
            if (!javaBeanInfo.clazz.isPrimitive()) {
                String str2 = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + "_" + cls.getSimpleName();
                Package r1 = ASMDeserializerFactory.class.getPackage();
                if (r1 != null) {
                    String str3 = name.replace('.', '/') + "/" + str2;
                    str = r1.getName() + "." + str2;
                    str2 = str3;
                } else {
                    str = str2;
                }
                ClassWriter classWriter = new ClassWriter();
                classWriter.visit(49, 33, str2, ASMUtils.type(JavaBeanDeserializer.class), null);
                _init(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
                _createInstance(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
                _deserialze(classWriter, new Context(str2, parserConfig, javaBeanInfo, 5));
                _deserialzeArrayMapping(classWriter, new Context(str2, parserConfig, javaBeanInfo, 4));
                byte[] byteArray = classWriter.toByteArray();
                return (ObjectDeserializer) this.classLoader.defineClassPublic(str, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, JavaBeanInfo.class).newInstance(parserConfig, javaBeanInfo);
            }
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        return (ObjectDeserializer) invokeLL.objValue;
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, this, context, methodVisitor, z) == null) {
            int length = context.fieldInfoList.length;
            for (int i2 = 0; i2 < length; i2++) {
                Label label = new Label();
                if (z) {
                    _isFlag(methodVisitor, context, i2, label);
                }
                _loadAndSet(context, methodVisitor, context.fieldInfoList[i2]);
                if (z) {
                    methodVisitor.visitLabel(label);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class Context {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int fieldName = 3;
        public static final int parser = 1;
        public static final int type = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final JavaBeanInfo beanInfo;
        public final String className;
        public final Class<?> clazz;
        public FieldInfo[] fieldInfoList;
        public int variantIndex;
        public final Map<String, Integer> variants;

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, parserConfig, javaBeanInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.variantIndex = -1;
            this.variants = new HashMap();
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i2;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public Class<?> getInstClass() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Class<?> cls = this.beanInfo.builderClass;
                return cls == null ? this.clazz : cls;
            }
            return (Class) invokeV.objValue;
        }

        public int var(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
                if (this.variants.get(str) == null) {
                    this.variants.put(str, Integer.valueOf(this.variantIndex));
                    this.variantIndex += i2;
                }
                return this.variants.get(str).intValue();
            }
            return invokeLI.intValue;
        }

        public int var(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.variants.get(str) == null) {
                    Map<String, Integer> map = this.variants;
                    int i2 = this.variantIndex;
                    this.variantIndex = i2 + 1;
                    map.put(str, Integer.valueOf(i2));
                }
                return this.variants.get(str).intValue();
            }
            return invokeL.intValue;
        }
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, classWriter, context) == null) && Modifier.isPublic(context.beanInfo.defaultConstructor.getModifiers())) {
            MethodWriter methodWriter = new MethodWriter(classWriter, 1, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(context.getInstClass()));
            methodWriter.visitInsn(89);
            methodWriter.visitMethodInsn(183, ASMUtils.type(context.getInstClass()), "<init>", "()V");
            methodWriter.visitInsn(Opcodes.ARETURN);
            methodWriter.visitMaxs(3, 3);
            methodWriter.visitEnd();
        }
    }
}
