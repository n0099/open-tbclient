package com.alibaba.fastjson.serializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public class ASMSerializerFactory implements Opcodes {
    public static /* synthetic */ Interceptable $ic;
    public static final String JSONSerializer;
    public static final String JavaBeanSerializer;
    public static final String JavaBeanSerializer_desc;
    public static final String ObjectSerializer;
    public static final String ObjectSerializer_desc;
    public static final String SerialContext_desc;
    public static final String SerializeFilterable_desc;
    public static final String SerializeWriter;
    public static final String SerializeWriter_desc;
    public transient /* synthetic */ FieldHolder $fh;
    public final ASMClassLoader classLoader;
    public final AtomicLong seed;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-698787393, "Lcom/alibaba/fastjson/serializer/ASMSerializerFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-698787393, "Lcom/alibaba/fastjson/serializer/ASMSerializerFactory;");
                return;
            }
        }
        JSONSerializer = ASMUtils.type(JSONSerializer.class);
        ObjectSerializer = ASMUtils.type(ObjectSerializer.class);
        ObjectSerializer_desc = "L" + ObjectSerializer + ";";
        SerializeWriter = ASMUtils.type(SerializeWriter.class);
        SerializeWriter_desc = "L" + SerializeWriter + ";";
        JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
        JavaBeanSerializer_desc = "L" + ASMUtils.type(JavaBeanSerializer.class) + ";";
        SerialContext_desc = ASMUtils.desc(SerialContext.class);
        SerializeFilterable_desc = ASMUtils.desc(SerializeFilterable.class);
    }

    public ASMSerializerFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.classLoader = new ASMClassLoader();
        this.seed = new AtomicLong();
    }

    private void _after(MethodVisitor methodVisitor, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, methodVisitor, context) == null) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
            methodVisitor.visitVarInsn(54, context.var("seperator"));
        }
    }

    private void _apply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, methodVisitor, fieldInfo, context) == null) {
            Class<?> cls = fieldInfo.fieldClass;
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            if (cls == Byte.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("byte"));
                methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            } else if (cls == Short.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("short"));
                methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            } else if (cls == Integer.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("int"));
                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else if (cls == Character.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("char"));
                methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            } else if (cls == Long.TYPE) {
                methodVisitor.visitVarInsn(22, context.var("long", 2));
                methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            } else if (cls == Float.TYPE) {
                methodVisitor.visitVarInsn(23, context.var(ShaderParams.VALUE_TYPE_FLOAT));
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            } else if (cls == Double.TYPE) {
                methodVisitor.visitVarInsn(24, context.var("double", 2));
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            } else if (cls == Boolean.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("boolean"));
                methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            } else if (cls == BigDecimal.class) {
                methodVisitor.visitVarInsn(25, context.var("decimal"));
            } else if (cls == String.class) {
                methodVisitor.visitVarInsn(25, context.var("string"));
            } else if (cls.isEnum()) {
                methodVisitor.visitVarInsn(25, context.var("enum"));
            } else if (List.class.isAssignableFrom(cls)) {
                methodVisitor.visitVarInsn(25, context.var("list"));
            } else {
                methodVisitor.visitVarInsn(25, context.var("object"));
            }
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
        }
    }

    private void _before(MethodVisitor methodVisitor, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, methodVisitor, context) == null) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
            methodVisitor.visitVarInsn(54, context.var("seperator"));
        }
    }

    private void _decimal(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, this, cls, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitVarInsn(58, context.var("decimal"));
            _filters(methodVisitor, fieldInfo, context, label);
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitVarInsn(25, context.var("decimal"));
            methodVisitor.visitJumpInsn(199, label3);
            _if_write_null(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(167, label4);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("decimal"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
            _seperator(methodVisitor, context);
            methodVisitor.visitJumpInsn(167, label4);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLabel(label);
        }
    }

    private void _double(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, cls, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitVarInsn(57, context.var("double", 2));
            _filters(methodVisitor, fieldInfo, context, label);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
            _seperator(methodVisitor, context);
            methodVisitor.visitLabel(label);
        }
    }

    private void _enum(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, this, cls, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label3);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitTypeInsn(192, "java/lang/Enum");
            methodVisitor.visitVarInsn(58, context.var("enum"));
            _filters(methodVisitor, fieldInfo, context, label3);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitJumpInsn(199, label);
            _if_write_null(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label);
            if (context.writeDirect) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(21, context.var("seperator"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitVarInsn(25, context.var("enum"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Enum", "name", "()Ljava/lang/String;");
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
            } else {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(21, context.var("seperator"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitInsn(3);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("enum"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            _seperator(methodVisitor, context);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLabel(label3);
        }
    }

    private void _filters(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, this, methodVisitor, fieldInfo, context, label) == null) {
            if (fieldInfo.fieldTransient) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor.visitJumpInsn(154, label);
            }
            _notWriteDefault(methodVisitor, fieldInfo, context, label);
            if (context.writeDirect) {
                return;
            }
            _apply(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(153, label);
            _processKey(methodVisitor, fieldInfo, context);
            _processValue(methodVisitor, fieldInfo, context, label);
        }
    }

    private void _float(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, this, cls, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitVarInsn(56, context.var(ShaderParams.VALUE_TYPE_FLOAT));
            _filters(methodVisitor, fieldInfo, context, label);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(23, context.var(ShaderParams.VALUE_TYPE_FLOAT));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
            _seperator(methodVisitor, context);
            methodVisitor.visitLabel(label);
        }
    }

    private void _get(MethodVisitor methodVisitor, Context context, FieldInfo fieldInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, methodVisitor, context, fieldInfo) == null) {
            Method method = fieldInfo.method;
            if (method != null) {
                methodVisitor.visitVarInsn(25, context.var("entity"));
                Class<?> declaringClass = method.getDeclaringClass();
                methodVisitor.visitMethodInsn(declaringClass.isInterface() ? 185 : Opcodes.INVOKEVIRTUAL, ASMUtils.type(declaringClass), method.getName(), ASMUtils.desc(method));
                if (method.getReturnType().equals(fieldInfo.fieldClass)) {
                    return;
                }
                methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
                return;
            }
            methodVisitor.visitVarInsn(25, context.var("entity"));
            Field field = fieldInfo.field;
            methodVisitor.visitFieldInsn(180, ASMUtils.type(fieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
            if (field.getType().equals(fieldInfo.fieldClass)) {
                return;
            }
            methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
        }
    }

    private void _getFieldSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, context, methodVisitor, fieldInfo) == null) {
            Label label = new Label();
            methodVisitor.visitVarInsn(25, 0);
            String str = context.className;
            methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_ser_", ObjectSerializer_desc);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            String str2 = JSONSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "getObjectWriter", "(Ljava/lang/Class;)" + ObjectSerializer_desc);
            String str3 = context.className;
            methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_ser_", ObjectSerializer_desc);
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, 0);
            String str4 = context.className;
            methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_ser_", ObjectSerializer_desc);
        }
    }

    private void _getListFieldItemSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, this, context, methodVisitor, fieldInfo, cls) == null) {
            Label label = new Label();
            methodVisitor.visitVarInsn(25, 0);
            String str = context.className;
            methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_list_item_ser_", ObjectSerializer_desc);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            String str2 = JSONSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "getObjectWriter", "(Ljava/lang/Class;)" + ObjectSerializer_desc);
            String str3 = context.className;
            methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_list_item_ser_", ObjectSerializer_desc);
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, 0);
            String str4 = context.className;
            methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_list_item_ser_", ObjectSerializer_desc);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _if_write_null(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        int i2;
        int mask;
        int mask2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, methodVisitor, fieldInfo, context) == null) {
            Class<?> cls = fieldInfo.fieldClass;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            methodVisitor.visitLabel(label);
            JSONField annotation = fieldInfo.getAnnotation();
            int of = annotation != null ? SerializerFeature.of(annotation.serialzeFeatures()) : 0;
            JSONType jSONType = context.beanInfo.jsonType;
            if (jSONType != null) {
                of |= SerializerFeature.of(jSONType.serialzeFeatures());
            }
            if (cls == String.class) {
                mask = SerializerFeature.WriteMapNullValue.getMask();
                mask2 = SerializerFeature.WriteNullStringAsEmpty.getMask();
            } else if (Number.class.isAssignableFrom(cls)) {
                mask = SerializerFeature.WriteMapNullValue.getMask();
                mask2 = SerializerFeature.WriteNullNumberAsZero.getMask();
            } else if (!Collection.class.isAssignableFrom(cls)) {
                if (Boolean.class == cls) {
                    mask = SerializerFeature.WriteMapNullValue.getMask();
                    mask2 = SerializerFeature.WriteNullBooleanAsFalse.getMask();
                } else {
                    i2 = SerializerFeature.WRITE_MAP_NULL_FEATURES;
                    if ((of & i2) == 0) {
                        methodVisitor.visitVarInsn(25, context.var("out"));
                        methodVisitor.visitLdcInsn(Integer.valueOf(i2));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                        methodVisitor.visitJumpInsn(153, label2);
                    }
                    methodVisitor.visitLabel(label3);
                    methodVisitor.visitVarInsn(25, context.var("out"));
                    methodVisitor.visitVarInsn(21, context.var("seperator"));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
                    _writeFieldName(methodVisitor, context);
                    methodVisitor.visitVarInsn(25, context.var("out"));
                    methodVisitor.visitLdcInsn(Integer.valueOf(of));
                    if (cls == String.class && cls != Character.class) {
                        if (!Number.class.isAssignableFrom(cls)) {
                            if (cls == Boolean.class) {
                                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
                            } else if (!Collection.class.isAssignableFrom(cls) && !cls.isArray()) {
                                methodVisitor.visitLdcInsn(0);
                            } else {
                                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
                            }
                        } else {
                            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
                        }
                    } else {
                        methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
                    }
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeNull", "(II)V");
                    _seperator(methodVisitor, context);
                    methodVisitor.visitJumpInsn(167, label4);
                    methodVisitor.visitLabel(label2);
                    methodVisitor.visitLabel(label4);
                }
            } else {
                mask = SerializerFeature.WriteMapNullValue.getMask();
                mask2 = SerializerFeature.WriteNullListAsEmpty.getMask();
            }
            i2 = mask | mask2;
            if ((of & i2) == 0) {
            }
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
            _writeFieldName(methodVisitor, context);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(of));
            if (cls == String.class) {
            }
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeNull", "(II)V");
            _seperator(methodVisitor, context);
            methodVisitor.visitJumpInsn(167, label4);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLabel(label4);
        }
    }

    private void _int(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, int i2, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{cls, methodVisitor, fieldInfo, context, Integer.valueOf(i2), Character.valueOf(c2)}) == null) {
            Label label = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitVarInsn(54, i2);
            _filters(methodVisitor, fieldInfo, context, label);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(21, i2);
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeFieldValue", "(CLjava/lang/String;" + c2 + ")V");
            _seperator(methodVisitor, context);
            methodVisitor.visitLabel(label);
        }
    }

    private void _labelApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, this, methodVisitor, fieldInfo, context, label) == null) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitLdcInsn(fieldInfo.label);
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
            methodVisitor.visitJumpInsn(153, label);
        }
    }

    private void _list(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label;
        Label label2;
        Label label3;
        Label label4;
        String str;
        Label label5;
        Label label6;
        int i2;
        int i3;
        int i4;
        Label label7;
        Label label8;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, this, cls, methodVisitor, fieldInfo, context) == null) {
            java.lang.reflect.Type collectionItemType = TypeUtils.getCollectionItemType(fieldInfo.fieldType);
            Class<?> cls2 = null;
            Class<?> cls3 = collectionItemType instanceof Class ? (Class) collectionItemType : null;
            if (cls3 != Object.class && cls3 != Serializable.class) {
                cls2 = cls3;
            }
            Label label9 = new Label();
            Label label10 = new Label();
            Label label11 = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label9);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitTypeInsn(192, "java/util/List");
            methodVisitor.visitVarInsn(58, context.var("list"));
            _filters(methodVisitor, fieldInfo, context, label9);
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitJumpInsn(199, label10);
            _if_write_null(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(167, label11);
            methodVisitor.visitLabel(label10);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
            _writeFieldName(methodVisitor, context);
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
            methodVisitor.visitVarInsn(54, context.var("size"));
            Label label12 = new Label();
            Label label13 = new Label();
            methodVisitor.visitVarInsn(21, context.var("size"));
            methodVisitor.visitInsn(3);
            methodVisitor.visitJumpInsn(160, label12);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn("[]");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(Ljava/lang/String;)V");
            methodVisitor.visitJumpInsn(167, label13);
            methodVisitor.visitLabel(label12);
            if (!context.nonContext) {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("list"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
            if (collectionItemType == String.class && context.writeDirect) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(25, context.var("list"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(Ljava/util/List;)V");
                label = label13;
                i2 = 1;
                i3 = 25;
                i4 = Opcodes.INVOKEVIRTUAL;
            } else {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(16, 91);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
                Label label14 = new Label();
                Label label15 = new Label();
                Label label16 = new Label();
                methodVisitor.visitInsn(3);
                label = label13;
                methodVisitor.visitVarInsn(54, context.var("i"));
                methodVisitor.visitLabel(label14);
                methodVisitor.visitVarInsn(21, context.var("i"));
                methodVisitor.visitVarInsn(21, context.var("size"));
                methodVisitor.visitJumpInsn(162, label16);
                methodVisitor.visitVarInsn(21, context.var("i"));
                methodVisitor.visitJumpInsn(153, label15);
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(16, 44);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
                methodVisitor.visitLabel(label15);
                methodVisitor.visitVarInsn(25, context.var("list"));
                methodVisitor.visitVarInsn(21, context.var("i"));
                methodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
                methodVisitor.visitVarInsn(58, context.var("list_item"));
                Label label17 = new Label();
                Label label18 = new Label();
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                methodVisitor.visitJumpInsn(199, label18);
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeNull", "()V");
                methodVisitor.visitJumpInsn(167, label17);
                methodVisitor.visitLabel(label18);
                Label label19 = new Label();
                Label label20 = new Label();
                if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                    label2 = label14;
                    label3 = label17;
                    label4 = label19;
                    str = AlbumActivityConfig.FROM_WRITE;
                    label5 = label16;
                    label6 = label20;
                } else {
                    label5 = label16;
                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                    label2 = label14;
                    label3 = label17;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                    methodVisitor.visitJumpInsn(166, label20);
                    _getListFieldItemSer(context, methodVisitor, fieldInfo, cls2);
                    methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                    Label label21 = new Label();
                    Label label22 = new Label();
                    if (context.writeDirect) {
                        if (context.nonContext && context.writeDirect) {
                            label8 = label20;
                            str3 = "writeDirectNonContext";
                        } else {
                            label8 = label20;
                            str3 = AlbumActivityConfig.FROM_WRITE;
                        }
                        label7 = label19;
                        methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                        methodVisitor.visitTypeInsn(193, JavaBeanSerializer);
                        methodVisitor.visitJumpInsn(153, label21);
                        methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                        str2 = AlbumActivityConfig.FROM_WRITE;
                        methodVisitor.visitTypeInsn(192, JavaBeanSerializer);
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("list_item"));
                        if (context.nonContext) {
                            methodVisitor.visitInsn(1);
                        } else {
                            methodVisitor.visitVarInsn(21, context.var("i"));
                            methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        }
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                        methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                        String str4 = JavaBeanSerializer;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, str3, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        methodVisitor.visitJumpInsn(167, label22);
                        methodVisitor.visitLabel(label21);
                    } else {
                        label7 = label19;
                        label8 = label20;
                        str2 = AlbumActivityConfig.FROM_WRITE;
                    }
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor.visitInsn(1);
                    } else {
                        methodVisitor.visitVarInsn(21, context.var("i"));
                        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                    String str5 = ObjectSerializer;
                    str = str2;
                    methodVisitor.visitMethodInsn(185, str5, str, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor.visitLabel(label22);
                    label4 = label7;
                    methodVisitor.visitJumpInsn(167, label4);
                    label6 = label8;
                }
                methodVisitor.visitLabel(label6);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                if (context.nonContext) {
                    methodVisitor.visitInsn(1);
                } else {
                    methodVisitor.visitVarInsn(21, context.var("i"));
                    methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                if (cls2 != null && Modifier.isPublic(cls2.getModifiers())) {
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class) collectionItemType)));
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                } else {
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                }
                methodVisitor.visitLabel(label4);
                methodVisitor.visitLabel(label3);
                i2 = 1;
                methodVisitor.visitIincInsn(context.var("i"), 1);
                methodVisitor.visitJumpInsn(167, label2);
                methodVisitor.visitLabel(label5);
                i3 = 25;
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(16, 93);
                String str6 = SerializeWriter;
                i4 = Opcodes.INVOKEVIRTUAL;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, str, "(I)V");
            }
            methodVisitor.visitVarInsn(i3, i2);
            methodVisitor.visitMethodInsn(i4, JSONSerializer, "popContext", "()V");
            methodVisitor.visitLabel(label);
            _seperator(methodVisitor, context);
            methodVisitor.visitLabel(label11);
            methodVisitor.visitLabel(label9);
        }
    }

    private void _long(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, this, cls, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitVarInsn(55, context.var("long", 2));
            _filters(methodVisitor, fieldInfo, context, label);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
            _seperator(methodVisitor, context);
            methodVisitor.visitLabel(label);
        }
    }

    private void _nameApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65554, this, methodVisitor, fieldInfo, context, label) == null) {
            if (!context.writeDirect) {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitVarInsn(25, Context.fieldName);
                String str = JavaBeanSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
                methodVisitor.visitJumpInsn(153, label);
                _labelApply(methodVisitor, fieldInfo, context, label);
            }
            if (fieldInfo.field == null) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor.visitJumpInsn(154, label);
            }
        }
    }

    private void _notWriteDefault(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65555, this, methodVisitor, fieldInfo, context, label) == null) || context.writeDirect) {
            return;
        }
        Label label2 = new Label();
        methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
        methodVisitor.visitJumpInsn(153, label2);
        Class<?> cls = fieldInfo.fieldClass;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long"));
            methodVisitor.visitInsn(9);
            methodVisitor.visitInsn(148);
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var(ShaderParams.VALUE_TYPE_FLOAT));
            methodVisitor.visitInsn(11);
            methodVisitor.visitInsn(Opcodes.FCMPL);
            methodVisitor.visitJumpInsn(153, label);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double"));
            methodVisitor.visitInsn(14);
            methodVisitor.visitInsn(151);
            methodVisitor.visitJumpInsn(153, label);
        }
        methodVisitor.visitLabel(label2);
    }

    private void _object(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, this, cls, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            _nameApply(methodVisitor, fieldInfo, context, label);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitVarInsn(58, context.var("object"));
            _filters(methodVisitor, fieldInfo, context, label);
            _writeObject(methodVisitor, fieldInfo, context, label);
            methodVisitor.visitLabel(label);
        }
    }

    private void _processKey(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, this, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
            methodVisitor.visitJumpInsn(153, label);
            Class<?> cls = fieldInfo.fieldClass;
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            if (cls == Byte.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("byte"));
                methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            } else if (cls == Short.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("short"));
                methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            } else if (cls == Integer.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("int"));
                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else if (cls == Character.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("char"));
                methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            } else if (cls == Long.TYPE) {
                methodVisitor.visitVarInsn(22, context.var("long", 2));
                methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            } else if (cls == Float.TYPE) {
                methodVisitor.visitVarInsn(23, context.var(ShaderParams.VALUE_TYPE_FLOAT));
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            } else if (cls == Double.TYPE) {
                methodVisitor.visitVarInsn(24, context.var("double", 2));
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            } else if (cls == Boolean.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("boolean"));
                methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            } else if (cls == BigDecimal.class) {
                methodVisitor.visitVarInsn(25, context.var("decimal"));
            } else if (cls == String.class) {
                methodVisitor.visitVarInsn(25, context.var("string"));
            } else if (cls.isEnum()) {
                methodVisitor.visitVarInsn(25, context.var("enum"));
            } else if (List.class.isAssignableFrom(cls)) {
                methodVisitor.visitVarInsn(25, context.var("list"));
            } else {
                methodVisitor.visitVarInsn(25, context.var("object"));
            }
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, Context.fieldName);
            methodVisitor.visitLabel(label);
        }
    }

    private void _processValue(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65558, this, methodVisitor, fieldInfo, context, label) == null) {
            Label label2 = new Label();
            Class<?> cls = fieldInfo.fieldClass;
            if (cls.isPrimitive()) {
                Label label3 = new Label();
                methodVisitor.visitVarInsn(21, context.var("checkValue"));
                methodVisitor.visitJumpInsn(154, label3);
                methodVisitor.visitInsn(1);
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
                methodVisitor.visitVarInsn(58, Context.processValue);
                methodVisitor.visitJumpInsn(167, label2);
                methodVisitor.visitLabel(label3);
            }
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(context.getFieldOrinal(fieldInfo.name)));
            String str = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getBeanContext", "(I)" + ASMUtils.desc(BeanContext.class));
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            if (cls == Byte.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("byte"));
                methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == Short.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("short"));
                methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == Integer.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("int"));
                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == Character.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("char"));
                methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == Long.TYPE) {
                methodVisitor.visitVarInsn(22, context.var("long", 2));
                methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == Float.TYPE) {
                methodVisitor.visitVarInsn(23, context.var(ShaderParams.VALUE_TYPE_FLOAT));
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == Double.TYPE) {
                methodVisitor.visitVarInsn(24, context.var("double", 2));
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == Boolean.TYPE) {
                methodVisitor.visitVarInsn(21, context.var("boolean"));
                methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(58, Context.original);
            } else if (cls == BigDecimal.class) {
                methodVisitor.visitVarInsn(25, context.var("decimal"));
                methodVisitor.visitVarInsn(58, Context.original);
                methodVisitor.visitVarInsn(25, Context.original);
            } else if (cls == String.class) {
                methodVisitor.visitVarInsn(25, context.var("string"));
                methodVisitor.visitVarInsn(58, Context.original);
                methodVisitor.visitVarInsn(25, Context.original);
            } else if (cls.isEnum()) {
                methodVisitor.visitVarInsn(25, context.var("enum"));
                methodVisitor.visitVarInsn(58, Context.original);
                methodVisitor.visitVarInsn(25, Context.original);
            } else if (List.class.isAssignableFrom(cls)) {
                methodVisitor.visitVarInsn(25, context.var("list"));
                methodVisitor.visitVarInsn(58, Context.original);
                methodVisitor.visitVarInsn(25, Context.original);
            } else {
                methodVisitor.visitVarInsn(25, context.var("object"));
                methodVisitor.visitVarInsn(58, Context.original);
                methodVisitor.visitVarInsn(25, Context.original);
            }
            String str2 = JavaBeanSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "processValue", "(L" + JSONSerializer + ";" + ASMUtils.desc(BeanContext.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
            methodVisitor.visitVarInsn(58, Context.processValue);
            methodVisitor.visitVarInsn(25, Context.original);
            methodVisitor.visitVarInsn(25, Context.processValue);
            methodVisitor.visitJumpInsn(165, label2);
            _writeObject(methodVisitor, fieldInfo, context, label);
            methodVisitor.visitJumpInsn(167, label);
            methodVisitor.visitLabel(label2);
        }
    }

    private void _seperator(MethodVisitor methodVisitor, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, methodVisitor, context) == null) {
            methodVisitor.visitVarInsn(16, 44);
            methodVisitor.visitVarInsn(54, context.var("seperator"));
        }
    }

    private void _string(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65560, this, cls, methodVisitor, fieldInfo, context) == null) {
            Label label = new Label();
            if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 4);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                methodVisitor.visitJumpInsn(154, label);
            }
            _nameApply(methodVisitor, fieldInfo, context, label);
            _get(methodVisitor, context, fieldInfo);
            methodVisitor.visitVarInsn(58, context.var("string"));
            _filters(methodVisitor, fieldInfo, context, label);
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitJumpInsn(199, label2);
            _if_write_null(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(167, label3);
            methodVisitor.visitLabel(label2);
            if ("trim".equals(fieldInfo.format)) {
                methodVisitor.visitVarInsn(25, context.var("string"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "trim", "()Ljava/lang/String;");
                methodVisitor.visitVarInsn(58, context.var("string"));
            }
            if (context.writeDirect) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(21, context.var("seperator"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitVarInsn(25, context.var("string"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
            } else {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(21, context.var("seperator"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitVarInsn(25, context.var("string"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
            }
            _seperator(methodVisitor, context);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLabel(label);
        }
    }

    private void _writeFieldName(MethodVisitor methodVisitor, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, this, methodVisitor, context) == null) {
            if (context.writeDirect) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
                return;
            }
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    private void _writeObject(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Class<?> cls;
        String str;
        Label label2;
        Label label3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65562, this, methodVisitor, fieldInfo, context, label) == null) {
            String format = fieldInfo.getFormat();
            Class<?> cls2 = fieldInfo.fieldClass;
            Label label4 = new Label();
            if (context.writeDirect) {
                methodVisitor.visitVarInsn(25, context.var("object"));
            } else {
                methodVisitor.visitVarInsn(25, Context.processValue);
            }
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, context.var("object"));
            methodVisitor.visitJumpInsn(199, label4);
            _if_write_null(methodVisitor, fieldInfo, context);
            methodVisitor.visitJumpInsn(167, label);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
            _writeFieldName(methodVisitor, context);
            Label label5 = new Label();
            Label label6 = new Label();
            if (!Modifier.isPublic(cls2.getModifiers()) || ParserConfig.isPrimitive2(cls2)) {
                cls = String.class;
                str = format;
                label2 = label5;
                label3 = label6;
            } else {
                methodVisitor.visitVarInsn(25, context.var("object"));
                cls = String.class;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                methodVisitor.visitJumpInsn(166, label6);
                _getFieldSer(context, methodVisitor, fieldInfo);
                methodVisitor.visitVarInsn(58, context.var("fied_ser"));
                Label label7 = new Label();
                Label label8 = new Label();
                methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                methodVisitor.visitTypeInsn(193, JavaBeanSerializer);
                methodVisitor.visitJumpInsn(153, label7);
                boolean z = (fieldInfo.serialzeFeatures & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
                boolean z2 = (SerializerFeature.BeanToArray.mask & fieldInfo.serialzeFeatures) != 0;
                String str2 = (z || (context.nonContext && context.writeDirect)) ? z2 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z2 ? "writeAsArray" : AlbumActivityConfig.FROM_WRITE;
                methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                str = format;
                methodVisitor.visitTypeInsn(192, JavaBeanSerializer);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("object"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitVarInsn(25, 0);
                String str3 = context.className;
                methodVisitor.visitFieldInsn(180, str3, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                String str4 = JavaBeanSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitJumpInsn(167, label8);
                methodVisitor.visitLabel(label7);
                methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("object"));
                methodVisitor.visitVarInsn(25, Context.fieldName);
                methodVisitor.visitVarInsn(25, 0);
                String str5 = context.className;
                methodVisitor.visitFieldInsn(180, str5, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                String str6 = ObjectSerializer;
                methodVisitor.visitMethodInsn(185, str6, AlbumActivityConfig.FROM_WRITE, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitLabel(label8);
                label2 = label5;
                methodVisitor.visitJumpInsn(167, label2);
                label3 = label6;
            }
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(25, 1);
            if (context.writeDirect) {
                methodVisitor.visitVarInsn(25, context.var("object"));
            } else {
                methodVisitor.visitVarInsn(25, Context.processValue);
            }
            if (str != null) {
                methodVisitor.visitLdcInsn(str);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
            } else {
                methodVisitor.visitVarInsn(25, Context.fieldName);
                java.lang.reflect.Type type = fieldInfo.fieldType;
                if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                } else {
                    Class<?> cls3 = cls;
                    if (fieldInfo.fieldClass == cls3) {
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                    } else {
                        methodVisitor.visitVarInsn(25, 0);
                        String str7 = context.className;
                        methodVisitor.visitFieldInsn(180, str7, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                    }
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                }
            }
            methodVisitor.visitLabel(label2);
            _seperator(methodVisitor, context);
        }
    }

    private void generateWriteAsArray(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        String str;
        int i2;
        int i3;
        String str2;
        String str3;
        ASMSerializerFactory aSMSerializerFactory;
        Label label;
        String str4;
        int i4;
        java.lang.reflect.Type type;
        int i5;
        Label label2;
        Label label3;
        Label label4;
        int i6;
        int i7;
        String str5;
        int i8;
        Label label5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, this, cls, methodVisitor, fieldInfoArr, context) == null) {
            ASMSerializerFactory aSMSerializerFactory2 = this;
            FieldInfo[] fieldInfoArr2 = fieldInfoArr;
            Label label6 = new Label();
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 0);
            String str6 = JSONSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "hasPropertyFilters", "(" + SerializeFilterable_desc + ")Z");
            methodVisitor.visitJumpInsn(154, label6);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(21, 5);
            String str7 = JavaBeanSerializer;
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            sb.append(JSONSerializer);
            String str8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor.visitMethodInsn(183, str7, "writeNoneASM", sb.toString());
            methodVisitor.visitInsn(177);
            methodVisitor.visitLabel(label6);
            String str9 = "out";
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 91);
            String str10 = "(I)V";
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
            int length = fieldInfoArr2.length;
            if (length == 0) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(16, 93);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
                return;
            }
            int i9 = 0;
            while (i9 < length) {
                int i10 = i9 == length + (-1) ? 93 : 44;
                FieldInfo fieldInfo = fieldInfoArr2[i9];
                Class<?> cls2 = fieldInfo.fieldClass;
                methodVisitor.visitLdcInsn(fieldInfo.name);
                methodVisitor.visitVarInsn(58, Context.fieldName);
                if (cls2 != Byte.TYPE && cls2 != Short.TYPE && cls2 != Integer.TYPE) {
                    if (cls2 == Long.TYPE) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitInsn(89);
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeLong", "(J)V");
                        methodVisitor.visitVarInsn(16, i10);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str10);
                    } else if (cls2 == Float.TYPE) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitInsn(89);
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFloat", "(FZ)V");
                        methodVisitor.visitVarInsn(16, i10);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str10);
                    } else if (cls2 == Double.TYPE) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitInsn(89);
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeDouble", "(DZ)V");
                        methodVisitor.visitVarInsn(16, i10);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str10);
                    } else if (cls2 == Boolean.TYPE) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitInsn(89);
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(Z)V");
                        methodVisitor.visitVarInsn(16, i10);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str10);
                    } else if (cls2 == Character.TYPE) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitMethodInsn(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                        methodVisitor.visitVarInsn(16, i10);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                    } else if (cls2 == String.class) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitVarInsn(16, i10);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                    } else if (cls2.isEnum()) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitInsn(89);
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeEnum", "(Ljava/lang/Enum;)V");
                        methodVisitor.visitVarInsn(16, i10);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str10);
                    } else if (List.class.isAssignableFrom(cls2)) {
                        java.lang.reflect.Type type2 = fieldInfo.fieldType;
                        if (type2 instanceof Class) {
                            type = Object.class;
                        } else {
                            type = ((ParameterizedType) type2).getActualTypeArguments()[0];
                        }
                        Class<?> cls3 = (!(type instanceof Class) || (cls3 = type) == Object.class) ? null : null;
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        i3 = length;
                        methodVisitor.visitTypeInsn(192, "java/util/List");
                        i2 = i9;
                        methodVisitor.visitVarInsn(58, context.var("list"));
                        if (cls3 == String.class && context.writeDirect) {
                            methodVisitor.visitVarInsn(25, context.var(str9));
                            methodVisitor.visitVarInsn(25, context.var("list"));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(Ljava/util/List;)V");
                            str = str9;
                            i5 = i10;
                            str2 = str8;
                            str5 = str10;
                            i6 = 25;
                            i7 = 16;
                            i8 = Opcodes.INVOKEVIRTUAL;
                        } else {
                            Label label7 = new Label();
                            Label label8 = new Label();
                            i5 = i10;
                            methodVisitor.visitVarInsn(25, context.var("list"));
                            methodVisitor.visitJumpInsn(199, label8);
                            methodVisitor.visitVarInsn(25, context.var(str9));
                            java.lang.reflect.Type type3 = type;
                            String str11 = str8;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeNull", "()V");
                            methodVisitor.visitJumpInsn(167, label7);
                            methodVisitor.visitLabel(label8);
                            methodVisitor.visitVarInsn(25, context.var("list"));
                            methodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
                            methodVisitor.visitVarInsn(54, context.var("size"));
                            methodVisitor.visitVarInsn(25, context.var(str9));
                            methodVisitor.visitVarInsn(16, 91);
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str10);
                            Label label9 = new Label();
                            Label label10 = new Label();
                            Label label11 = new Label();
                            methodVisitor.visitInsn(3);
                            methodVisitor.visitVarInsn(54, context.var("i"));
                            methodVisitor.visitLabel(label9);
                            methodVisitor.visitVarInsn(21, context.var("i"));
                            methodVisitor.visitVarInsn(21, context.var("size"));
                            methodVisitor.visitJumpInsn(162, label11);
                            methodVisitor.visitVarInsn(21, context.var("i"));
                            methodVisitor.visitJumpInsn(153, label10);
                            methodVisitor.visitVarInsn(25, context.var(str9));
                            methodVisitor.visitVarInsn(16, 44);
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str10);
                            methodVisitor.visitLabel(label10);
                            methodVisitor.visitVarInsn(25, context.var("list"));
                            methodVisitor.visitVarInsn(21, context.var("i"));
                            methodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
                            methodVisitor.visitVarInsn(58, context.var("list_item"));
                            Label label12 = new Label();
                            Label label13 = new Label();
                            String str12 = str10;
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            methodVisitor.visitJumpInsn(199, label13);
                            methodVisitor.visitVarInsn(25, context.var(str9));
                            String str13 = str9;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeNull", "()V");
                            methodVisitor.visitJumpInsn(167, label12);
                            methodVisitor.visitLabel(label13);
                            Label label14 = new Label();
                            Label label15 = new Label();
                            if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                                label2 = label9;
                                label3 = label12;
                                str2 = str11;
                                label4 = label15;
                            } else {
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                label2 = label9;
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                methodVisitor.visitJumpInsn(166, label15);
                                aSMSerializerFactory2._getListFieldItemSer(context, methodVisitor, fieldInfo, cls3);
                                methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                                Label label16 = new Label();
                                Label label17 = new Label();
                                if (context.writeDirect) {
                                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                    methodVisitor.visitTypeInsn(193, JavaBeanSerializer);
                                    methodVisitor.visitJumpInsn(153, label16);
                                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                    methodVisitor.visitTypeInsn(192, JavaBeanSerializer);
                                    methodVisitor.visitVarInsn(25, 1);
                                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                                    if (context.nonContext) {
                                        methodVisitor.visitInsn(1);
                                        label3 = label12;
                                    } else {
                                        methodVisitor.visitVarInsn(21, context.var("i"));
                                        label3 = label12;
                                        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                    String str14 = JavaBeanSerializer;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("(L");
                                    sb2.append(JSONSerializer);
                                    str2 = str11;
                                    sb2.append(str2);
                                    label5 = label15;
                                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "writeAsArrayNonContext", sb2.toString());
                                    methodVisitor.visitJumpInsn(167, label17);
                                    methodVisitor.visitLabel(label16);
                                } else {
                                    label3 = label12;
                                    str2 = str11;
                                    label5 = label15;
                                }
                                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                methodVisitor.visitVarInsn(25, 1);
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                if (context.nonContext) {
                                    methodVisitor.visitInsn(1);
                                } else {
                                    methodVisitor.visitVarInsn(21, context.var("i"));
                                    methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                String str15 = ObjectSerializer;
                                methodVisitor.visitMethodInsn(185, str15, AlbumActivityConfig.FROM_WRITE, "(L" + JSONSerializer + str2);
                                methodVisitor.visitLabel(label17);
                                methodVisitor.visitJumpInsn(167, label14);
                                label4 = label5;
                            }
                            methodVisitor.visitLabel(label4);
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            if (context.nonContext) {
                                methodVisitor.visitInsn(1);
                            } else {
                                methodVisitor.visitVarInsn(21, context.var("i"));
                                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            if (cls3 != null && Modifier.isPublic(cls3.getModifiers())) {
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class) type3)));
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            } else {
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            }
                            methodVisitor.visitLabel(label14);
                            methodVisitor.visitLabel(label3);
                            methodVisitor.visitIincInsn(context.var("i"), 1);
                            methodVisitor.visitJumpInsn(167, label2);
                            methodVisitor.visitLabel(label11);
                            str = str13;
                            i6 = 25;
                            methodVisitor.visitVarInsn(25, context.var(str));
                            i7 = 16;
                            methodVisitor.visitVarInsn(16, 93);
                            String str16 = SerializeWriter;
                            str5 = str12;
                            i8 = Opcodes.INVOKEVIRTUAL;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, AlbumActivityConfig.FROM_WRITE, str5);
                            methodVisitor.visitLabel(label7);
                        }
                        methodVisitor.visitVarInsn(i6, context.var(str));
                        methodVisitor.visitVarInsn(i7, i5);
                        methodVisitor.visitMethodInsn(i8, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str5);
                        aSMSerializerFactory = this;
                        str3 = str5;
                    } else {
                        String str17 = str9;
                        i2 = i9;
                        int i11 = i10;
                        i3 = length;
                        str2 = str8;
                        String str18 = str10;
                        Label label18 = new Label();
                        Label label19 = new Label();
                        _get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitVarInsn(58, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitJumpInsn(199, label19);
                        methodVisitor.visitVarInsn(25, context.var(str17));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeNull", "()V");
                        methodVisitor.visitJumpInsn(167, label18);
                        methodVisitor.visitLabel(label19);
                        Label label20 = new Label();
                        Label label21 = new Label();
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                        methodVisitor.visitJumpInsn(166, label21);
                        _getFieldSer(context, methodVisitor, fieldInfo);
                        methodVisitor.visitVarInsn(58, context.var("fied_ser"));
                        Label label22 = new Label();
                        Label label23 = new Label();
                        if (context.writeDirect && Modifier.isPublic(cls2.getModifiers())) {
                            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                            methodVisitor.visitTypeInsn(193, JavaBeanSerializer);
                            methodVisitor.visitJumpInsn(153, label22);
                            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                            str4 = "writeWithFieldName";
                            methodVisitor.visitTypeInsn(192, JavaBeanSerializer);
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                            methodVisitor.visitVarInsn(25, Context.fieldName);
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            String str19 = JavaBeanSerializer;
                            label = label21;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str19, "writeAsArrayNonContext", "(L" + JSONSerializer + str2);
                            methodVisitor.visitJumpInsn(167, label23);
                            methodVisitor.visitLabel(label22);
                        } else {
                            label = label21;
                            str4 = "writeWithFieldName";
                        }
                        methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitVarInsn(25, Context.fieldName);
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                        methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                        String str20 = ObjectSerializer;
                        methodVisitor.visitMethodInsn(185, str20, AlbumActivityConfig.FROM_WRITE, "(L" + JSONSerializer + str2);
                        methodVisitor.visitLabel(label23);
                        methodVisitor.visitJumpInsn(167, label20);
                        methodVisitor.visitLabel(label);
                        String format = fieldInfo.getFormat();
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        if (format != null) {
                            methodVisitor.visitLdcInsn(format);
                            String str21 = JSONSerializer;
                            i4 = Opcodes.INVOKEVIRTUAL;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str21, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                        } else {
                            methodVisitor.visitVarInsn(25, Context.fieldName);
                            java.lang.reflect.Type type4 = fieldInfo.fieldType;
                            if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, str4, "(Ljava/lang/Object;Ljava/lang/Object;)V");
                                i4 = Opcodes.INVOKEVIRTUAL;
                            } else {
                                methodVisitor.visitVarInsn(25, 0);
                                String str22 = context.className;
                                methodVisitor.visitFieldInsn(180, str22, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                String str23 = JSONSerializer;
                                i4 = Opcodes.INVOKEVIRTUAL;
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str23, str4, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                        }
                        methodVisitor.visitLabel(label20);
                        methodVisitor.visitLabel(label18);
                        str = str17;
                        methodVisitor.visitVarInsn(25, context.var(str));
                        methodVisitor.visitVarInsn(16, i11);
                        str3 = str18;
                        methodVisitor.visitMethodInsn(i4, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str3);
                        aSMSerializerFactory = this;
                    }
                    aSMSerializerFactory = aSMSerializerFactory2;
                    str = str9;
                    i2 = i9;
                    i3 = length;
                    str2 = str8;
                    str3 = str10;
                } else {
                    str = str9;
                    i2 = i9;
                    i3 = length;
                    str2 = str8;
                    str3 = str10;
                    methodVisitor.visitVarInsn(25, context.var(str));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory = this;
                    aSMSerializerFactory._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeInt", str3);
                    methodVisitor.visitVarInsn(16, i10);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, str3);
                }
                fieldInfoArr2 = fieldInfoArr;
                i9 = i2 + 1;
                str10 = str3;
                str8 = str2;
                length = i3;
                str9 = str;
                aSMSerializerFactory2 = aSMSerializerFactory;
            }
        }
    }

    private void generateWriteMethod(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        Label label;
        String str;
        String str2;
        int i2;
        String str3;
        Class<?> cls2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65564, this, cls, methodVisitor, fieldInfoArr, context) == null) {
            FieldInfo[] fieldInfoArr2 = fieldInfoArr;
            Label label2 = new Label();
            int length = fieldInfoArr2.length;
            String str4 = "out";
            if (context.writeDirect) {
                label = label2;
            } else {
                Label label3 = new Label();
                Label label4 = new Label();
                label = label2;
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor.visitJumpInsn(154, label4);
                int length2 = fieldInfoArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        z = false;
                        break;
                    }
                    int i4 = length2;
                    if (fieldInfoArr2[i3].method != null) {
                        z = true;
                        break;
                    } else {
                        i3++;
                        length2 = i4;
                    }
                }
                if (z) {
                    methodVisitor.visitVarInsn(25, context.var("out"));
                    methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                    methodVisitor.visitJumpInsn(153, label3);
                } else {
                    methodVisitor.visitJumpInsn(167, label3);
                }
                methodVisitor.visitLabel(label4);
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitVarInsn(25, 3);
                methodVisitor.visitVarInsn(25, 4);
                methodVisitor.visitVarInsn(21, 5);
                String str5 = JavaBeanSerializer;
                methodVisitor.visitMethodInsn(183, str5, AlbumActivityConfig.FROM_WRITE, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitInsn(177);
                methodVisitor.visitLabel(label3);
            }
            if (!context.nonContext) {
                Label label5 = new Label();
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitVarInsn(21, 5);
                String str6 = JavaBeanSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "writeReference", "(L" + JSONSerializer + ";Ljava/lang/Object;I)Z");
                methodVisitor.visitJumpInsn(153, label5);
                methodVisitor.visitInsn(177);
                methodVisitor.visitLabel(label5);
            }
            if (context.writeDirect) {
                str = context.nonContext ? "writeAsArrayNonContext" : "writeAsArray";
            } else {
                str = "writeAsArrayNormal";
            }
            if ((context.beanInfo.features & SerializerFeature.BeanToArray.mask) == 0) {
                Label label6 = new Label();
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.BeanToArray.mask));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor.visitJumpInsn(153, label6);
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitVarInsn(25, 3);
                methodVisitor.visitVarInsn(25, 4);
                methodVisitor.visitVarInsn(21, 5);
                String str7 = context.className;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, str, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitInsn(177);
                methodVisitor.visitLabel(label6);
            } else {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitVarInsn(25, 3);
                methodVisitor.visitVarInsn(25, 4);
                methodVisitor.visitVarInsn(21, 5);
                String str8 = context.className;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, str, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitInsn(177);
            }
            if (!context.nonContext) {
                methodVisitor.visitVarInsn(25, 1);
                String str9 = JSONSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str9, "getContext", "()" + SerialContext_desc);
                methodVisitor.visitVarInsn(58, context.var("parent"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("parent"));
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitVarInsn(25, 3);
                methodVisitor.visitLdcInsn(Integer.valueOf(context.beanInfo.features));
                String str10 = JSONSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "setContext", "(" + SerialContext_desc + "Ljava/lang/Object;Ljava/lang/Object;I)V");
            }
            boolean z2 = (context.beanInfo.features & SerializerFeature.WriteClassName.mask) != 0;
            if (!z2 && context.writeDirect) {
                methodVisitor.visitVarInsn(16, 123);
                str2 = "parent";
            } else {
                Label label7 = new Label();
                Label label8 = new Label();
                Label label9 = new Label();
                if (z2) {
                    str2 = "parent";
                    i2 = Opcodes.INVOKEVIRTUAL;
                } else {
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, 4);
                    methodVisitor.visitVarInsn(25, 2);
                    String str11 = JSONSerializer;
                    str2 = "parent";
                    i2 = Opcodes.INVOKEVIRTUAL;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                    methodVisitor.visitJumpInsn(153, label8);
                }
                methodVisitor.visitVarInsn(25, 4);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(i2, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor.visitJumpInsn(165, label8);
                methodVisitor.visitLabel(label9);
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(16, 123);
                methodVisitor.visitMethodInsn(i2, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitVarInsn(25, 1);
                if (context.beanInfo.typeKey != null) {
                    methodVisitor.visitLdcInsn(context.beanInfo.typeKey);
                } else {
                    methodVisitor.visitInsn(1);
                }
                methodVisitor.visitVarInsn(25, 2);
                String str12 = JavaBeanSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "writeClassName", "(L" + JSONSerializer + ";Ljava/lang/String;Ljava/lang/Object;)V");
                methodVisitor.visitVarInsn(16, 44);
                methodVisitor.visitJumpInsn(167, label7);
                methodVisitor.visitLabel(label8);
                methodVisitor.visitVarInsn(16, 123);
                methodVisitor.visitLabel(label7);
            }
            methodVisitor.visitVarInsn(54, context.var("seperator"));
            if (!context.writeDirect) {
                _before(methodVisitor, context);
            }
            if (!context.writeDirect) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isNotWriteDefaultValue", "()Z");
                methodVisitor.visitVarInsn(54, context.var("notWriteDefaultValue"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 0);
                String str13 = JSONSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "checkValue", "(" + SerializeFilterable_desc + ")Z");
                methodVisitor.visitVarInsn(54, context.var("checkValue"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 0);
                String str14 = JSONSerializer;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "hasNameFilters", "(" + SerializeFilterable_desc + ")Z");
                methodVisitor.visitVarInsn(54, context.var("hasNameFilters"));
            }
            int i5 = 0;
            while (i5 < length) {
                FieldInfo fieldInfo = fieldInfoArr2[i5];
                Class<?> cls3 = fieldInfo.fieldClass;
                methodVisitor.visitLdcInsn(fieldInfo.name);
                methodVisitor.visitVarInsn(58, Context.fieldName);
                if (cls3 != Byte.TYPE && cls3 != Short.TYPE && cls3 != Integer.TYPE) {
                    if (cls3 == Long.TYPE) {
                        cls2 = cls;
                        _long(cls2, methodVisitor, fieldInfo, context);
                    } else {
                        cls2 = cls;
                        if (cls3 == Float.TYPE) {
                            _float(cls2, methodVisitor, fieldInfo, context);
                        } else if (cls3 == Double.TYPE) {
                            _double(cls2, methodVisitor, fieldInfo, context);
                        } else if (cls3 == Boolean.TYPE) {
                            str3 = str4;
                            _int(cls, methodVisitor, fieldInfo, context, context.var("boolean"), 'Z');
                        } else {
                            str3 = str4;
                            if (cls3 == Character.TYPE) {
                                _int(cls, methodVisitor, fieldInfo, context, context.var("char"), 'C');
                            } else if (cls3 == String.class) {
                                _string(cls2, methodVisitor, fieldInfo, context);
                            } else if (cls3 == BigDecimal.class) {
                                _decimal(cls2, methodVisitor, fieldInfo, context);
                            } else if (List.class.isAssignableFrom(cls3)) {
                                _list(cls2, methodVisitor, fieldInfo, context);
                            } else if (cls3.isEnum()) {
                                _enum(cls2, methodVisitor, fieldInfo, context);
                            } else {
                                _object(cls2, methodVisitor, fieldInfo, context);
                            }
                        }
                    }
                    str3 = str4;
                } else {
                    str3 = str4;
                    _int(cls, methodVisitor, fieldInfo, context, context.var(cls3.getName()), 'I');
                }
                i5++;
                fieldInfoArr2 = fieldInfoArr;
                str4 = str3;
            }
            String str15 = str4;
            if (!context.writeDirect) {
                _after(methodVisitor, context);
            }
            Label label10 = new Label();
            Label label11 = new Label();
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitIntInsn(16, 123);
            methodVisitor.visitJumpInsn(160, label10);
            methodVisitor.visitVarInsn(25, context.var(str15));
            methodVisitor.visitVarInsn(16, 123);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
            methodVisitor.visitLabel(label10);
            methodVisitor.visitVarInsn(25, context.var(str15));
            methodVisitor.visitVarInsn(16, 125);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, AlbumActivityConfig.FROM_WRITE, "(I)V");
            methodVisitor.visitLabel(label11);
            methodVisitor.visitLabel(label);
            if (context.nonContext) {
                return;
            }
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var(str2));
            String str16 = JSONSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "setContext", "(" + SerialContext_desc + ")V");
        }
    }

    public JavaBeanSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        InterceptResult invokeL;
        String str;
        String str2;
        boolean z;
        Class<SerializeBeanInfo> cls;
        String str3;
        boolean z2;
        boolean z3;
        String str4;
        boolean z4;
        boolean z5;
        String str5;
        JSONType jSONType;
        FieldInfo[] fieldInfoArr;
        int i2;
        ClassWriter classWriter;
        int i3;
        String str6;
        String name;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, serializeBeanInfo)) == null) {
            Class<SerializeBeanInfo> cls2 = SerializeBeanInfo.class;
            Class<?> cls3 = serializeBeanInfo.beanType;
            if (!cls3.isPrimitive()) {
                JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(cls3, JSONType.class);
                FieldInfo[] fieldInfoArr2 = serializeBeanInfo.fields;
                for (FieldInfo fieldInfo : fieldInfoArr2) {
                    if (fieldInfo.field == null && (method = fieldInfo.method) != null && method.getDeclaringClass().isInterface()) {
                        return new JavaBeanSerializer(serializeBeanInfo);
                    }
                }
                FieldInfo[] fieldInfoArr3 = serializeBeanInfo.sortedFields;
                boolean z6 = fieldInfoArr3 == serializeBeanInfo.fields;
                if (fieldInfoArr3.length > 256) {
                    return new JavaBeanSerializer(serializeBeanInfo);
                }
                for (FieldInfo fieldInfo2 : fieldInfoArr3) {
                    if (!ASMUtils.checkName(fieldInfo2.getMember().getName())) {
                        return new JavaBeanSerializer(serializeBeanInfo);
                    }
                }
                String str7 = "ASMSerializer_" + this.seed.incrementAndGet() + "_" + cls3.getSimpleName();
                Package r2 = ASMSerializerFactory.class.getPackage();
                if (r2 != null) {
                    str = r2.getName() + "." + str7;
                    str2 = name.replace('.', WebvttCueParser.CHAR_SLASH) + "/" + str7;
                } else {
                    str = str7;
                    str2 = str;
                }
                ClassWriter classWriter2 = new ClassWriter();
                classWriter2.visit(49, 33, str2, JavaBeanSerializer, new String[]{ObjectSerializer});
                int length = fieldInfoArr3.length;
                int i4 = 0;
                while (i4 < length) {
                    FieldInfo fieldInfo3 = fieldInfoArr3[i4];
                    if (fieldInfo3.fieldClass.isPrimitive() || fieldInfo3.fieldClass == String.class) {
                        i3 = length;
                        str6 = str;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        i3 = length;
                        sb.append(fieldInfo3.name);
                        sb.append("_asm_fieldType");
                        str6 = str;
                        new FieldWriter(classWriter2, 1, sb.toString(), "Ljava/lang/reflect/Type;").visitEnd();
                        if (List.class.isAssignableFrom(fieldInfo3.fieldClass)) {
                            new FieldWriter(classWriter2, 1, fieldInfo3.name + "_asm_list_item_ser_", ObjectSerializer_desc).visitEnd();
                        }
                        new FieldWriter(classWriter2, 1, fieldInfo3.name + "_asm_ser_", ObjectSerializer_desc).visitEnd();
                    }
                    i4++;
                    length = i3;
                    str = str6;
                }
                String str8 = str;
                MethodWriter methodWriter = new MethodWriter(classWriter2, 1, "<init>", "(" + ASMUtils.desc(cls2) + ")V", null, null);
                methodWriter.visitVarInsn(25, 0);
                methodWriter.visitVarInsn(25, 1);
                methodWriter.visitMethodInsn(183, JavaBeanSerializer, "<init>", "(" + ASMUtils.desc(cls2) + ")V");
                int i5 = 0;
                while (i5 < fieldInfoArr3.length) {
                    FieldInfo fieldInfo4 = fieldInfoArr3[i5];
                    if (fieldInfo4.fieldClass.isPrimitive() || fieldInfo4.fieldClass == String.class) {
                        classWriter = classWriter2;
                    } else {
                        methodWriter.visitVarInsn(25, 0);
                        if (fieldInfo4.method != null) {
                            methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo4.declaringClass)));
                            methodWriter.visitLdcInsn(fieldInfo4.method.getName());
                            classWriter = classWriter2;
                            methodWriter.visitMethodInsn(184, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                        } else {
                            classWriter = classWriter2;
                            methodWriter.visitVarInsn(25, 0);
                            methodWriter.visitLdcInsn(Integer.valueOf(i5));
                            methodWriter.visitMethodInsn(183, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                        }
                        methodWriter.visitFieldInsn(181, str2, fieldInfo4.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                    }
                    i5++;
                    classWriter2 = classWriter;
                }
                ClassWriter classWriter3 = classWriter2;
                methodWriter.visitInsn(177);
                methodWriter.visitMaxs(4, 4);
                methodWriter.visitEnd();
                if (jSONType2 != null) {
                    for (SerializerFeature serializerFeature : jSONType2.serialzeFeatures()) {
                        if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                int i6 = 0;
                while (true) {
                    cls = cls2;
                    if (i6 >= 3) {
                        break;
                    }
                    if (i6 == 0) {
                        str4 = AlbumActivityConfig.FROM_WRITE;
                        z5 = z;
                        z4 = true;
                    } else if (i6 == 1) {
                        str4 = "writeNormal";
                        z5 = z;
                        z4 = false;
                    } else {
                        str4 = "writeDirectNonContext";
                        z4 = true;
                        z5 = true;
                    }
                    ClassWriter classWriter4 = classWriter3;
                    String str9 = str8;
                    int i7 = i6;
                    String str10 = str2;
                    Context context = new Context(fieldInfoArr3, serializeBeanInfo, str2, z4, z5);
                    MethodWriter methodWriter2 = new MethodWriter(classWriter4, 1, str4, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[]{"java/io/IOException"});
                    Label label = new Label();
                    methodWriter2.visitVarInsn(25, 2);
                    methodWriter2.visitJumpInsn(199, label);
                    methodWriter2.visitVarInsn(25, 1);
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeNull", "()V");
                    methodWriter2.visitInsn(177);
                    methodWriter2.visitLabel(label);
                    methodWriter2.visitVarInsn(25, 1);
                    methodWriter2.visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
                    methodWriter2.visitVarInsn(58, context.var("out"));
                    if (z6 || context.writeDirect || !(jSONType2 == null || jSONType2.alphabetic())) {
                        str5 = str10;
                    } else {
                        Label label2 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("out"));
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isSortField", "()Z");
                        methodWriter2.visitJumpInsn(154, label2);
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitVarInsn(25, 1);
                        methodWriter2.visitVarInsn(25, 2);
                        methodWriter2.visitVarInsn(25, 3);
                        methodWriter2.visitVarInsn(25, 4);
                        methodWriter2.visitVarInsn(21, 5);
                        str5 = str10;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "writeUnsorted", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        methodWriter2.visitInsn(177);
                        methodWriter2.visitLabel(label2);
                    }
                    if (!context.writeDirect || z5) {
                        jSONType = jSONType2;
                        fieldInfoArr = fieldInfoArr2;
                        i2 = 177;
                    } else {
                        Label label3 = new Label();
                        Label label4 = new Label();
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitVarInsn(25, 1);
                        String str11 = JavaBeanSerializer;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("(L");
                        jSONType = jSONType2;
                        sb2.append(JSONSerializer);
                        sb2.append(";)Z");
                        fieldInfoArr = fieldInfoArr2;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "writeDirect", sb2.toString());
                        methodWriter2.visitJumpInsn(154, label4);
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitVarInsn(25, 1);
                        methodWriter2.visitVarInsn(25, 2);
                        methodWriter2.visitVarInsn(25, 3);
                        methodWriter2.visitVarInsn(25, 4);
                        methodWriter2.visitVarInsn(21, 5);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "writeNormal", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        methodWriter2.visitInsn(177);
                        methodWriter2.visitLabel(label4);
                        methodWriter2.visitVarInsn(25, context.var("out"));
                        methodWriter2.visitLdcInsn(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                        methodWriter2.visitJumpInsn(153, label3);
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitVarInsn(25, 1);
                        methodWriter2.visitVarInsn(25, 2);
                        methodWriter2.visitVarInsn(25, 3);
                        methodWriter2.visitVarInsn(25, 4);
                        methodWriter2.visitVarInsn(21, 5);
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "writeDirectNonContext", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        i2 = 177;
                        methodWriter2.visitInsn(177);
                        methodWriter2.visitLabel(label3);
                    }
                    methodWriter2.visitVarInsn(25, 2);
                    methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                    methodWriter2.visitVarInsn(58, context.var("entity"));
                    generateWriteMethod(cls3, methodWriter2, fieldInfoArr3, context);
                    methodWriter2.visitInsn(i2);
                    methodWriter2.visitMaxs(7, context.variantIndex + 2);
                    methodWriter2.visitEnd();
                    i6 = i7 + 1;
                    str2 = str5;
                    jSONType2 = jSONType;
                    cls2 = cls;
                    fieldInfoArr2 = fieldInfoArr;
                    classWriter3 = classWriter4;
                    str8 = str9;
                }
                FieldInfo[] fieldInfoArr4 = fieldInfoArr2;
                ClassWriter classWriter5 = classWriter3;
                String str12 = str8;
                String str13 = str2;
                if (!z6) {
                    Context context2 = new Context(fieldInfoArr3, serializeBeanInfo, str13, false, z);
                    MethodWriter methodWriter3 = new MethodWriter(classWriter5, 1, "writeUnsorted", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[]{"java/io/IOException"});
                    methodWriter3.visitVarInsn(25, 1);
                    methodWriter3.visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
                    methodWriter3.visitVarInsn(58, context2.var("out"));
                    methodWriter3.visitVarInsn(25, 2);
                    methodWriter3.visitTypeInsn(192, ASMUtils.type(cls3));
                    methodWriter3.visitVarInsn(58, context2.var("entity"));
                    generateWriteMethod(cls3, methodWriter3, fieldInfoArr4, context2);
                    methodWriter3.visitInsn(177);
                    methodWriter3.visitMaxs(7, context2.variantIndex + 2);
                    methodWriter3.visitEnd();
                }
                int i8 = 0;
                for (int i9 = 3; i8 < i9; i9 = 3) {
                    if (i8 == 0) {
                        str3 = "writeAsArray";
                        z3 = z;
                        z2 = true;
                    } else if (i8 == 1) {
                        str3 = "writeAsArrayNormal";
                        z3 = z;
                        z2 = false;
                    } else {
                        str3 = "writeAsArrayNonContext";
                        z2 = true;
                        z3 = true;
                    }
                    Context context3 = new Context(fieldInfoArr3, serializeBeanInfo, str13, z2, z3);
                    MethodWriter methodWriter4 = new MethodWriter(classWriter5, 1, str3, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[]{"java/io/IOException"});
                    methodWriter4.visitVarInsn(25, 1);
                    methodWriter4.visitFieldInsn(180, JSONSerializer, "out", SerializeWriter_desc);
                    methodWriter4.visitVarInsn(58, context3.var("out"));
                    methodWriter4.visitVarInsn(25, 2);
                    methodWriter4.visitTypeInsn(192, ASMUtils.type(cls3));
                    methodWriter4.visitVarInsn(58, context3.var("entity"));
                    generateWriteAsArray(cls3, methodWriter4, fieldInfoArr3, context3);
                    methodWriter4.visitInsn(177);
                    methodWriter4.visitMaxs(7, context3.variantIndex + 2);
                    methodWriter4.visitEnd();
                    i8++;
                }
                byte[] byteArray = classWriter5.toByteArray();
                return (JavaBeanSerializer) this.classLoader.defineClassPublic(str12, byteArray, 0, byteArray.length).getConstructor(cls).newInstance(serializeBeanInfo);
            }
            throw new JSONException("unsupportd class " + cls3.getName());
        }
        return (JavaBeanSerializer) invokeL.objValue;
    }

    /* loaded from: classes3.dex */
    public static class Context {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int features = 5;
        public static int fieldName = 6;
        public static final int obj = 2;
        public static int original = 7;
        public static final int paramFieldName = 3;
        public static final int paramFieldType = 4;
        public static int processValue = 8;
        public static final int serializer = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final SerializeBeanInfo beanInfo;
        public final String className;
        public final FieldInfo[] getters;
        public final boolean nonContext;
        public int variantIndex;
        public Map<String, Integer> variants;
        public final boolean writeDirect;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1726158388, "Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1726158388, "Lcom/alibaba/fastjson/serializer/ASMSerializerFactory$Context;");
            }
        }

        public Context(FieldInfo[] fieldInfoArr, SerializeBeanInfo serializeBeanInfo, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldInfoArr, serializeBeanInfo, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.variants = new HashMap();
            this.variantIndex = 9;
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z;
            this.nonContext = z2 || serializeBeanInfo.beanType.isEnum();
        }

        public int getFieldOrinal(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int length = this.getters.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.getters[i2].name.equals(str)) {
                        return i2;
                    }
                }
                return -1;
            }
            return invokeL.intValue;
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
    }
}
