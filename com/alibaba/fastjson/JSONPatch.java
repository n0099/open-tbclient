package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.baidu.fsg.base.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.webkit.sdk.LoadErrorCode;
/* loaded from: classes4.dex */
public class JSONPatch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.alibaba.fastjson.JSONPatch$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-600642388, "Lcom/alibaba/fastjson/JSONPatch$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-600642388, "Lcom/alibaba/fastjson/JSONPatch$1;");
                    return;
                }
            }
            int[] iArr = new int[OperationType.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType = iArr;
            try {
                iArr[OperationType.add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.replace.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.remove.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.copy.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.move.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.test.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @JSONType(orders = {"op", "from", "path", "value"})
    /* loaded from: classes4.dex */
    public static class Operation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String from;
        public String path;
        @JSONField(name = "op")
        public OperationType type;
        public Object value;

        public Operation() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class OperationType {
        public static final /* synthetic */ OperationType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OperationType add;
        public static final OperationType copy;
        public static final OperationType move;
        public static final OperationType remove;
        public static final OperationType replace;
        public static final OperationType test;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1708645052, "Lcom/alibaba/fastjson/JSONPatch$OperationType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1708645052, "Lcom/alibaba/fastjson/JSONPatch$OperationType;");
                    return;
                }
            }
            add = new OperationType("add", 0);
            remove = new OperationType("remove", 1);
            replace = new OperationType(StickerDataChangeType.REPLACE, 2);
            move = new OperationType("move", 3);
            copy = new OperationType("copy", 4);
            OperationType operationType = new OperationType(a.f39363g, 5);
            test = operationType;
            $VALUES = new OperationType[]{add, remove, replace, move, copy, operationType};
        }

        public OperationType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static OperationType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OperationType) Enum.valueOf(OperationType.class, str) : (OperationType) invokeL.objValue;
        }

        public static OperationType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OperationType[]) $VALUES.clone() : (OperationType[]) invokeV.objValue;
        }
    }

    public JSONPatch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String apply(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? JSON.toJSONString(apply(JSON.parse(str, Feature.OrderedField), str2)) : (String) invokeLL.objValue;
    }

    public static boolean isObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return false;
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (!JSONLexerBase.isWhitespace(charAt)) {
                    return charAt == '{';
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Object apply(Object obj, String str) {
        InterceptResult invokeLL;
        Operation[] operationArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, str)) == null) {
            for (Operation operation : isObject(str) ? new Operation[]{(Operation) JSON.parseObject(str, Operation.class)} : (Operation[]) JSON.parseObject(str, Operation[].class)) {
                JSONPath compile = JSONPath.compile(operation.path);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[operation.type.ordinal()]) {
                    case 1:
                        compile.patchAdd(obj, operation.value, false);
                        break;
                    case 2:
                        compile.patchAdd(obj, operation.value, true);
                        break;
                    case 3:
                        compile.remove(obj);
                        break;
                    case 4:
                    case 5:
                        JSONPath compile2 = JSONPath.compile(operation.from);
                        Object eval = compile2.eval(obj);
                        if (operation.type == OperationType.move && !compile2.remove(obj)) {
                            throw new JSONException("json patch move error : " + operation.from + LoadErrorCode.TOKEN_NEXT + operation.path);
                        }
                        compile.set(obj, eval);
                        break;
                    case 6:
                        Object eval2 = compile.eval(obj);
                        if (eval2 == null) {
                            return Boolean.valueOf(operation.value == null);
                        }
                        return Boolean.valueOf(eval2.equals(operation.value));
                }
            }
            return obj;
        }
        return invokeLL.objValue;
    }
}
