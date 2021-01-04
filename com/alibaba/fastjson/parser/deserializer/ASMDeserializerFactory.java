package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
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
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
/* loaded from: classes6.dex */
public class ASMDeserializerFactory implements Opcodes {
    static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
    static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    public final ASMClassLoader classLoader;
    protected final AtomicLong seed = new AtomicLong();

    public ASMDeserializerFactory(ClassLoader classLoader) {
        this.classLoader = classLoader instanceof ASMClassLoader ? (ASMClassLoader) classLoader : new ASMClassLoader(classLoader);
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) throws Exception {
        Class<?> cls;
        String name;
        if (javaBeanInfo.clazz.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String str = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + cls.getSimpleName();
        String str2 = name.replace('.', '/') + "/" + str;
        String str3 = ASMDeserializerFactory.class.getPackage().getName() + "." + str;
        ClassWriter classWriter = new ClassWriter();
        classWriter.visit(49, 33, str2, ASMUtils.type(JavaBeanDeserializer.class), null);
        _init(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
        _createInstance(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
        _deserialze(classWriter, new Context(str2, parserConfig, javaBeanInfo, 5));
        _deserialzeArrayMapping(classWriter, new Context(str2, parserConfig, javaBeanInfo, 4));
        byte[] byteArray = classWriter.toByteArray();
        return (ObjectDeserializer) this.classLoader.defineClassPublic(str3, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, JavaBeanInfo.class).newInstance(parserConfig, javaBeanInfo);
    }

    private void _setFlag(MethodVisitor methodVisitor, Context context, int i) {
        String str = "_asm_flag_" + (i / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    private void _isFlag(MethodVisitor methodVisitor, Context context, int i, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(Opcodes.IAND);
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
    }

    private void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        defineVarLexer(context, methodWriter);
        _createInstance(context, methodWriter);
        FieldInfo[] fieldInfoArr = context.beanInfo.sortedFields;
        int length = fieldInfoArr.length;
        int i = 0;
        while (i < length) {
            boolean z = i == length + (-1);
            int i2 = z ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr[i];
            Class<?> cls = fieldInfo.fieldClass;
            Type type = fieldInfo.fieldType;
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else if (cls == Byte.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                Label label = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                methodWriter.visitLabel(label);
            } else if (cls == Short.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                Label label2 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label2);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                methodWriter.visitLabel(label2);
            } else if (cls == Integer.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                Label label3 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label3);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                methodWriter.visitLabel(label3);
            } else if (cls == Long.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                methodWriter.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
            } else if (cls == Long.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                Label label4 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label4);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                methodWriter.visitLabel(label4);
            } else if (cls == Boolean.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanBoolean", "(C)Z");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else if (cls == Float.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFloat", "(C)F");
                methodWriter.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
            } else if (cls == Float.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFloat", "(C)F");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                Label label5 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label5);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                methodWriter.visitLabel(label5);
            } else if (cls == Double.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDouble", "(C)D");
                methodWriter.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
            } else if (cls == Double.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDouble", "(C)D");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                Label label6 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label6);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                methodWriter.visitLabel(label6);
            } else if (cls == Character.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                methodWriter.visitInsn(3);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "charAt", "(I)C");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else if (cls == String.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else if (cls == BigDecimal.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else if (cls == Date.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDate", "(C)Ljava/util/Date;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else if (cls == UUID.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanUUID", "(C)Ljava/util/UUID;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else if (cls.isEnum()) {
                Label label7 = new Label();
                Label label8 = new Label();
                Label label9 = new Label();
                Label label10 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
                methodWriter.visitInsn(89);
                methodWriter.visitVarInsn(54, context.var("ch"));
                methodWriter.visitLdcInsn(110);
                methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label10);
                methodWriter.visitVarInsn(21, context.var("ch"));
                methodWriter.visitLdcInsn(34);
                methodWriter.visitJumpInsn(160, label7);
                methodWriter.visitLabel(label10);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls)));
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc(SymbolTable.class) + "C)Ljava/lang/Enum;");
                methodWriter.visitJumpInsn(167, label9);
                methodWriter.visitLabel(label7);
                methodWriter.visitVarInsn(21, context.var("ch"));
                methodWriter.visitLdcInsn(48);
                methodWriter.visitJumpInsn(161, label8);
                methodWriter.visitVarInsn(21, context.var("ch"));
                methodWriter.visitLdcInsn(57);
                methodWriter.visitJumpInsn(Opcodes.IF_ICMPGT, label8);
                _getFieldDeser(context, methodWriter, fieldInfo);
                methodWriter.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                methodWriter.visitJumpInsn(167, label9);
                methodWriter.visitLabel(label8);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i2);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "scanEnum", "(L" + JSONLexerBase + ";C)Ljava/lang/Enum;");
                methodWriter.visitLabel(label9);
                methodWriter.visitTypeInsn(192, ASMUtils.type(cls));
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else if (Collection.class.isAssignableFrom(cls)) {
                Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type);
                if (collectionItemClass == String.class) {
                    if (cls == List.class || cls == Collections.class || cls == ArrayList.class) {
                        methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(ArrayList.class));
                        methodWriter.visitInsn(89);
                        methodWriter.visitMethodInsn(183, ASMUtils.type(ArrayList.class), "<init>", "()V");
                    } else {
                        methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls)));
                        methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                    }
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitVarInsn(16, i2);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanStringArray", "(Ljava/util/Collection;C)V");
                    Label label11 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label11);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label11);
                } else {
                    Label label12 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
                    methodWriter.visitVarInsn(54, context.var("token"));
                    methodWriter.visitVarInsn(21, context.var("token"));
                    methodWriter.visitLdcInsn(Integer.valueOf(i == 0 ? 14 : 16));
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label12);
                    methodWriter.visitVarInsn(25, 1);
                    methodWriter.visitVarInsn(21, context.var("token"));
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "throwException", "(I)V");
                    methodWriter.visitLabel(label12);
                    Label label13 = new Label();
                    Label label14 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
                    methodWriter.visitVarInsn(16, 91);
                    methodWriter.visitJumpInsn(160, label13);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
                    methodWriter.visitInsn(87);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitLdcInsn(14);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
                    methodWriter.visitJumpInsn(167, label14);
                    methodWriter.visitLabel(label13);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitLdcInsn(14);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
                    methodWriter.visitLabel(label14);
                    _newCollection(methodWriter, cls, i, false);
                    methodWriter.visitInsn(89);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    _getCollectionFieldItemDeser(context, methodWriter, fieldInfo, collectionItemClass);
                    methodWriter.visitVarInsn(25, 1);
                    methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(collectionItemClass)));
                    methodWriter.visitVarInsn(25, 3);
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(JavaBeanDeserializer.class), "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc(ObjectDeserializer.class) + "L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                }
            } else if (cls.isArray()) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitLdcInsn(14);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitLdcInsn(Integer.valueOf(i));
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                methodWriter.visitTypeInsn(192, ASMUtils.type(cls));
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            } else {
                Label label15 = new Label();
                Label label16 = new Label();
                if (cls == Date.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
                    methodWriter.visitLdcInsn(49);
                    methodWriter.visitJumpInsn(160, label15);
                    methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(Date.class));
                    methodWriter.visitInsn(89);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i2);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                    methodWriter.visitMethodInsn(183, ASMUtils.type(Date.class), "<init>", "(J)V");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitJumpInsn(167, label16);
                }
                methodWriter.visitLabel(label15);
                _quickNextToken(context, methodWriter, 14);
                _deserObject(context, methodWriter, fieldInfo, cls, i);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
                methodWriter.visitLdcInsn(15);
                methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label16);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                if (!z) {
                    methodWriter.visitLdcInsn(16);
                } else {
                    methodWriter.visitLdcInsn(15);
                }
                methodWriter.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "check", "(" + ASMUtils.desc(JSONLexer.class) + "I)V");
                methodWriter.visitLabel(label16);
            }
            i++;
        }
        _batchSet(context, methodWriter, false);
        Label label17 = new Label();
        Label label18 = new Label();
        Label label19 = new Label();
        Label label20 = new Label();
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
        methodWriter.visitInsn(89);
        methodWriter.visitVarInsn(54, context.var("ch"));
        methodWriter.visitVarInsn(16, 44);
        methodWriter.visitJumpInsn(160, label18);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
        methodWriter.visitJumpInsn(167, label20);
        methodWriter.visitLabel(label18);
        methodWriter.visitVarInsn(21, context.var("ch"));
        methodWriter.visitVarInsn(16, 93);
        methodWriter.visitJumpInsn(160, label19);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(15);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
        methodWriter.visitJumpInsn(167, label20);
        methodWriter.visitLabel(label19);
        methodWriter.visitVarInsn(21, context.var("ch"));
        methodWriter.visitVarInsn(16, 26);
        methodWriter.visitJumpInsn(160, label17);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(20);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
        methodWriter.visitJumpInsn(167, label20);
        methodWriter.visitLabel(label17);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
        methodWriter.visitLabel(label20);
        methodWriter.visitVarInsn(25, context.var("instance"));
        methodWriter.visitInsn(Opcodes.ARETURN);
        methodWriter.visitMaxs(5, context.variantIndex);
        methodWriter.visitEnd();
    }

    private void _deserialze(ClassWriter classWriter, Context context) {
        FieldInfo[] fieldInfoArr;
        FieldInfo fieldInfo;
        if (context.fieldInfoList.length == 0) {
            return;
        }
        for (FieldInfo fieldInfo2 : context.fieldInfoList) {
            Class<?> cls = fieldInfo2.fieldClass;
            Type type = fieldInfo2.fieldType;
            if (cls != Character.TYPE) {
                if (Collection.class.isAssignableFrom(cls) && (!(type instanceof ParameterizedType) || !(((ParameterizedType) type).getActualTypeArguments()[0] instanceof Class))) {
                    return;
                }
            } else {
                return;
            }
        }
        JavaBeanInfo javaBeanInfo = context.beanInfo;
        context.fieldInfoList = javaBeanInfo.sortedFields;
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        defineVarLexer(context, methodWriter);
        Label label5 = new Label();
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
        methodWriter.visitLdcInsn(14);
        methodWriter.visitJumpInsn(160, label5);
        if ((javaBeanInfo.parserFeatures & Feature.SupportArrayToBean.mask) == 0) {
            methodWriter.visitVarInsn(25, context.var("lexer"));
            methodWriter.visitVarInsn(21, 4);
            methodWriter.visitLdcInsn(Integer.valueOf(Feature.SupportArrayToBean.mask));
            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "isEnabled", "(II)Z");
            methodWriter.visitJumpInsn(Opcodes.IFEQ, label5);
        }
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitInsn(1);
        methodWriter.visitMethodInsn(183, context.className, "deserialzeArrayMapping", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        methodWriter.visitInsn(Opcodes.ARETURN);
        methodWriter.visitLabel(label5);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(Integer.valueOf(Feature.SortFeidFastMatch.mask));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "isEnabled", "(I)Z");
        methodWriter.visitJumpInsn(Opcodes.IFEQ, label2);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(context.clazz.getName());
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanType", "(Ljava/lang/String;)I");
        methodWriter.visitLdcInsn(-1);
        methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label2);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodWriter.visitVarInsn(58, context.var("mark_context"));
        methodWriter.visitInsn(3);
        methodWriter.visitVarInsn(54, context.var("matchedCount"));
        _createInstance(context, methodWriter);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodWriter.visitVarInsn(58, context.var("context"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, context.var("context"));
        methodWriter.visitVarInsn(25, context.var("instance"));
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
        methodWriter.visitVarInsn(58, context.var("childContext"));
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
        methodWriter.visitLdcInsn(4);
        methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label3);
        methodWriter.visitInsn(3);
        methodWriter.visitIntInsn(54, context.var("matchStat"));
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i += 32) {
            methodWriter.visitInsn(3);
            methodWriter.visitVarInsn(54, context.var("_asm_flag_" + (i / 32)));
        }
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(Integer.valueOf(Feature.InitStringFieldAsEmpty.mask));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "isEnabled", "(I)Z");
        methodWriter.visitIntInsn(54, context.var("initStringFieldAsEmpty"));
        for (int i2 = 0; i2 < length; i2++) {
            Class<?> cls2 = context.fieldInfoList[i2].fieldClass;
            if (cls2 == Boolean.TYPE || cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE) {
                methodWriter.visitInsn(3);
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else if (cls2 == Long.TYPE) {
                methodWriter.visitInsn(9);
                methodWriter.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
            } else if (cls2 == Float.TYPE) {
                methodWriter.visitInsn(11);
                methodWriter.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
            } else if (cls2 == Double.TYPE) {
                methodWriter.visitInsn(14);
                methodWriter.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
            } else {
                if (cls2 == String.class) {
                    Label label6 = new Label();
                    Label label7 = new Label();
                    methodWriter.visitVarInsn(21, context.var("initStringFieldAsEmpty"));
                    methodWriter.visitJumpInsn(Opcodes.IFEQ, label7);
                    _setFlag(methodWriter, context, i2);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
                    methodWriter.visitJumpInsn(167, label6);
                    methodWriter.visitLabel(label7);
                    methodWriter.visitInsn(1);
                    methodWriter.visitLabel(label6);
                } else {
                    methodWriter.visitInsn(1);
                }
                methodWriter.visitTypeInsn(192, ASMUtils.type(cls2));
                methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            }
        }
        for (int i3 = 0; i3 < length; i3++) {
            FieldInfo fieldInfo3 = context.fieldInfoList[i3];
            Class<?> cls3 = fieldInfo3.fieldClass;
            Type type2 = fieldInfo3.fieldType;
            Label label8 = new Label();
            if (cls3 == Boolean.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldBoolean", "([C)Z");
                methodWriter.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == Byte.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                methodWriter.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == Byte.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                Label label9 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label9);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                methodWriter.visitLabel(label9);
            } else if (cls3 == Short.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                methodWriter.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == Short.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                Label label10 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label10);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                methodWriter.visitLabel(label10);
            } else if (cls3 == Integer.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                methodWriter.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == Integer.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                Label label11 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label11);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                methodWriter.visitLabel(label11);
            } else if (cls3 == Long.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldLong", "([C)J");
                methodWriter.visitVarInsn(55, context.var(fieldInfo3.name + "_asm", 2));
            } else if (cls3 == Long.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldLong", "([C)J");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                Label label12 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label12);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                methodWriter.visitLabel(label12);
            } else if (cls3 == Float.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloat", "([C)F");
                methodWriter.visitVarInsn(56, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == Float.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloat", "([C)F");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                Label label13 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label13);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                methodWriter.visitLabel(label13);
            } else if (cls3 == Double.TYPE) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDouble", "([C)D");
                methodWriter.visitVarInsn(57, context.var(fieldInfo3.name + "_asm", 2));
            } else if (cls3 == Double.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDouble", "([C)D");
                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                Label label14 = new Label();
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(5);
                methodWriter.visitJumpInsn(160, label14);
                methodWriter.visitInsn(1);
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                methodWriter.visitLabel(label14);
            } else if (cls3 == String.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == Date.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDate", "([C)Ljava/util/Date;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == UUID.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldUUID", "([C)Ljava/util/UUID;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == BigDecimal.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDecimal", "([C)Ljava/math/BigDecimal;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == BigInteger.class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldBigInteger", "([C)Ljava/math/BigInteger;");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == int[].class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldIntArray", "([C)[I");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == float[].class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloatArray", "([C)[F");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3 == float[][].class) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloatArray2", "([C)[[F");
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else if (cls3.isEnum()) {
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                _getFieldDeser(context, methodWriter, fieldInfo3);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "scanEnum", "(L" + JSONLexerBase + ";[C" + ASMUtils.desc(ObjectDeserializer.class) + ")Ljava/lang/Enum;");
                methodWriter.visitTypeInsn(192, ASMUtils.type(cls3));
                methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
            } else {
                if (Collection.class.isAssignableFrom(cls3)) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                    Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type2);
                    if (collectionItemClass == String.class) {
                        methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls3)));
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.desc(Collection.class));
                        methodWriter.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                    } else {
                        _deserialze_list_obj(context, methodWriter, label, fieldInfo3, cls3, collectionItemClass, i3);
                        if (i3 == length - 1) {
                            _deserialize_endCheck(context, methodWriter, label);
                        }
                    }
                } else {
                    _deserialze_obj(context, methodWriter, label, fieldInfo3, cls3, i3);
                    if (i3 == length - 1) {
                        _deserialize_endCheck(context, methodWriter, label);
                    }
                }
            }
            methodWriter.visitVarInsn(25, context.var("lexer"));
            methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
            Label label15 = new Label();
            methodWriter.visitJumpInsn(Opcodes.IFLE, label15);
            _setFlag(methodWriter, context, i3);
            methodWriter.visitLabel(label15);
            methodWriter.visitVarInsn(25, context.var("lexer"));
            methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
            methodWriter.visitInsn(89);
            methodWriter.visitVarInsn(54, context.var("matchStat"));
            methodWriter.visitLdcInsn(-1);
            methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label);
            methodWriter.visitVarInsn(25, context.var("lexer"));
            methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
            methodWriter.visitJumpInsn(Opcodes.IFLE, label8);
            methodWriter.visitVarInsn(21, context.var("matchedCount"));
            methodWriter.visitInsn(4);
            methodWriter.visitInsn(96);
            methodWriter.visitVarInsn(54, context.var("matchedCount"));
            methodWriter.visitVarInsn(25, context.var("lexer"));
            methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
            methodWriter.visitLdcInsn(4);
            methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label4);
            methodWriter.visitLabel(label8);
            if (i3 == length - 1) {
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitFieldInsn(180, JSONLexerBase, "matchStat", "I");
                methodWriter.visitLdcInsn(4);
                methodWriter.visitJumpInsn(160, label);
            }
        }
        methodWriter.visitLabel(label4);
        if (!context.clazz.isInterface() && !Modifier.isAbstract(context.clazz.getModifiers())) {
            _batchSet(context, methodWriter);
        }
        methodWriter.visitLabel(label3);
        _setContext(context, methodWriter);
        methodWriter.visitVarInsn(25, context.var("instance"));
        Method method = context.beanInfo.buildMethod;
        if (method != null) {
            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(context.getInstClass()), method.getName(), "()" + ASMUtils.desc(method.getReturnType()));
        }
        methodWriter.visitInsn(Opcodes.ARETURN);
        methodWriter.visitLabel(label);
        _batchSet(context, methodWriter);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitVarInsn(25, context.var("instance"));
        methodWriter.visitVarInsn(21, 4);
        int i4 = length / 32;
        int i5 = (length == 0 || length % 32 == 0) ? i4 : i4 + 1;
        if (i5 == 1) {
            methodWriter.visitInsn(4);
        } else {
            methodWriter.visitIntInsn(16, i5);
        }
        methodWriter.visitIntInsn(Opcodes.NEWARRAY, 10);
        for (int i6 = 0; i6 < i5; i6++) {
            methodWriter.visitInsn(89);
            if (i6 == 0) {
                methodWriter.visitInsn(3);
            } else if (i6 == 1) {
                methodWriter.visitInsn(4);
            } else {
                methodWriter.visitIntInsn(16, i6);
            }
            methodWriter.visitVarInsn(21, context.var("_asm_flag_" + i6));
            methodWriter.visitInsn(79);
        }
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "parseRest", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;");
        methodWriter.visitTypeInsn(192, ASMUtils.type(context.clazz));
        methodWriter.visitInsn(Opcodes.ARETURN);
        methodWriter.visitLabel(label2);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitVarInsn(21, 4);
        methodWriter.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
        methodWriter.visitInsn(Opcodes.ARETURN);
        methodWriter.visitMaxs(10, context.variantIndex);
        methodWriter.visitEnd();
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
        methodVisitor.visitTypeInsn(192, JSONLexerBase);
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Constructor<?> constructor = context.beanInfo.defaultConstructor;
        if (Modifier.isPublic(constructor.getModifiers())) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
            methodVisitor.visitVarInsn(58, context.var("instance"));
            return;
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, ASMUtils.type(JavaBeanDeserializer.class), "clazz", "Ljava/lang/Class;");
        methodVisitor.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z) {
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i++) {
            Label label = new Label();
            if (z) {
                _isFlag(methodVisitor, context, i, label);
            }
            _loadAndSet(context, methodVisitor, context.fieldInfoList[i]);
            if (z) {
                methodVisitor.visitLabel(label);
            }
        }
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> cls = fieldInfo.fieldClass;
        Type type = fieldInfo.fieldType;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(22, context.var(fieldInfo.name + "_asm", 2));
            if (fieldInfo.method != null) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
                if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                    methodVisitor.visitInsn(87);
                    return;
                }
                return;
            }
            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(23, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(24, context.var(fieldInfo.name + "_asm", 2));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (Collection.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            if (TypeUtils.getCollectionItemClass(type) == String.class) {
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            } else {
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            }
            _set(context, methodVisitor, fieldInfo);
        } else {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        }
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitMethodInsn(method.getDeclaringClass().isInterface() ? 185 : Opcodes.INVOKEVIRTUAL, ASMUtils.type(fieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
            if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                methodVisitor.visitInsn(87);
                return;
            }
            return;
        }
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("context"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
        methodVisitor.visitLabel(label);
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i) {
        Label label2 = new Label();
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
        _setFlag(methodVisitor, context, i);
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
        _newCollection(methodVisitor, cls, i, true);
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label5);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(14);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(12);
        methodVisitor.visitJumpInsn(160, label);
        _newCollection(methodVisitor, cls, i, false);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitInsn(3);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), IMTrack.DbBuilder.ACTION_ADD, "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), IMTrack.DbBuilder.ACTION_ADD, "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label6);
        _newCollection(methodVisitor, cls, i, false);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        boolean isPrimitive2 = ParserConfig.isPrimitive2(fieldInfo.fieldClass);
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        if (isPrimitive2) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
        } else {
            methodVisitor.visitInsn(87);
            methodVisitor.visitLdcInsn(12);
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            _quickNextToken(context, methodVisitor, 12);
        }
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(58, context.var("listContext"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitInsn(87);
        Label label7 = new Label();
        Label label8 = new Label();
        methodVisitor.visitInsn(3);
        methodVisitor.visitVarInsn(54, context.var("i"));
        methodVisitor.visitLabel(label7);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label8);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitVarInsn(21, context.var("i"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitIincInsn(context.var("i"), 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), IMTrack.DbBuilder.ACTION_ADD, "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), IMTrack.DbBuilder.ACTION_ADD, "(Ljava/lang/Object;)Z");
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
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
        } else {
            _quickNextToken(context, methodVisitor, 12);
        }
        methodVisitor.visitJumpInsn(167, label7);
        methodVisitor.visitLabel(label8);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("listContext"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextToken(Context context, MethodVisitor methodVisitor, int i) {
        Label label = new Label();
        Label label2 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "getCurrent", "()C");
        if (i == 12) {
            methodVisitor.visitVarInsn(16, Constants.METHOD_IM_FRIEND_GROUP_QUERY);
        } else if (i == 14) {
            methodVisitor.visitVarInsn(16, 91);
        } else {
            throw new IllegalStateException();
        }
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextTokenComma(Context context, MethodVisitor methodVisitor) {
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
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
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
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()C");
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

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(ParserConfig.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i, boolean z) {
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
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i) {
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_prefix__", "[C");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label2);
        methodVisitor.visitInsn(1);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label2);
        _setFlag(methodVisitor, context, i);
        methodVisitor.visitVarInsn(21, context.var("matchedCount"));
        methodVisitor.visitInsn(4);
        methodVisitor.visitInsn(96);
        methodVisitor.visitVarInsn(54, context.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls, i);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getResolveStatus", "()I");
        methodVisitor.visitLdcInsn(1);
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getLastResolveTask", "()" + ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
        methodVisitor.visitVarInsn(58, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setResolveStatus", "(I)V");
        methodVisitor.visitLabel(label3);
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i) {
        _getFieldDeser(context, methodVisitor, fieldInfo);
        Label label = new Label();
        Label label2 = new Label();
        if ((fieldInfo.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
            methodVisitor.visitInsn(89);
            methodVisitor.visitTypeInsn(193, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            methodVisitor.visitTypeInsn(192, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitVarInsn(25, 1);
            if (fieldInfo.fieldType instanceof Class) {
                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            } else {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitLdcInsn(Integer.valueOf(i));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.parserFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label);
        }
        methodVisitor.visitVarInsn(25, 1);
        if (fieldInfo.fieldType instanceof Class) {
            methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitLabel(label2);
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(ParserConfig.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Context {
        static final int fieldName = 3;
        static final int parser = 1;
        static final int type = 2;
        private final JavaBeanInfo beanInfo;
        private final String className;
        private final Class<?> clazz;
        private FieldInfo[] fieldInfoList;
        private int variantIndex;
        private final Map<String, Integer> variants = new HashMap();

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i) {
            this.variantIndex = -1;
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public Class<?> getInstClass() {
            Class<?> cls = this.beanInfo.builderClass;
            if (cls == null) {
                return this.clazz;
            }
            return cls;
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }
    }

    private void _init(ClassWriter classWriter, Context context) {
        FieldInfo fieldInfo;
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i++) {
            new FieldWriter(classWriter, 1, context.fieldInfoList[i].name + "_asm_prefix__", "[C").visitEnd();
        }
        int length2 = context.fieldInfoList.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Class<?> cls = context.fieldInfoList[i2].fieldClass;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new FieldWriter(classWriter, 1, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                } else {
                    new FieldWriter(classWriter, 1, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                }
            }
        }
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V", null, null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V");
        int length3 = context.fieldInfoList.length;
        for (int i3 = 0; i3 < length3; i3++) {
            FieldInfo fieldInfo2 = context.fieldInfoList[i3];
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn("\"" + fieldInfo2.name + "\":");
            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toCharArray", "()[C");
            methodWriter.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo2.name + "_asm_prefix__", "[C");
        }
        methodWriter.visitInsn(Opcodes.RETURN);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        if (Modifier.isPublic(context.beanInfo.defaultConstructor.getModifiers())) {
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
