package c.n.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public final class f<M extends Message<M, B>, B extends Message.a<M, B>> extends ProtoAdapter<M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<M> a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<B> f30720b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, a<M, B>> f30721c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Class<M> cls, Class<B> cls2, Map<Integer, a<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cls;
        this.f30720b = cls2;
        this.f30721c = map;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> f<M, B> a(Class<M> cls) {
        InterceptResult invokeL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            Class e2 = e(cls);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Field field : cls.getDeclaredFields()) {
                WireField wireField = (WireField) field.getAnnotation(WireField.class);
                if (wireField != null) {
                    linkedHashMap.put(Integer.valueOf(wireField.tag()), new a(wireField, field, e2));
                }
            }
            return new f<>(cls, e2, Collections.unmodifiableMap(linkedHashMap));
        }
        return (f) invokeL.objValue;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> Class<B> e(Class<M> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            try {
                return (Class<B>) Class.forName(cls.getName() + "$Builder");
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
            }
        }
        return (Class) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: b */
    public M decode(c cVar) throws IOException {
        InterceptResult invokeL;
        ProtoAdapter<?> i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
            return (M) invokeL.objValue;
        }
        B f2 = f();
        long c2 = cVar.c();
        while (true) {
            int f3 = cVar.f();
            if (f3 != -1) {
                a<M, B> aVar = this.f30721c.get(Integer.valueOf(f3));
                if (aVar != null) {
                    try {
                        if (aVar.f()) {
                            i2 = aVar.a();
                        } else {
                            i2 = aVar.i();
                        }
                        aVar.j(f2, i2.decode(cVar));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                        f2.addUnknownField(f3, FieldEncoding.VARINT, Long.valueOf(e2.value));
                    }
                } else {
                    FieldEncoding g2 = cVar.g();
                    f2.addUnknownField(f3, g2, g2.rawProtoAdapter().decode(cVar));
                }
            } else {
                cVar.d(c2);
                return (M) f2.build();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: c */
    public void encode(d dVar, M m) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, m) == null) {
            for (a<M, B> aVar : this.f30721c.values()) {
                Object b2 = aVar.b(m);
                if (b2 != null) {
                    aVar.a().encodeWithTag(dVar, aVar.f30703c, b2);
                }
            }
            dVar.k(m.unknownFields());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: d */
    public int encodedSize(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m)) == null) {
            int i2 = m.cachedSerializedSize;
            if (i2 != 0) {
                return i2;
            }
            int i3 = 0;
            for (a<M, B> aVar : this.f30721c.values()) {
                Object b2 = aVar.b(m);
                if (b2 != null) {
                    i3 += aVar.a().encodedSizeWithTag(aVar.f30703c, b2);
                }
            }
            int size = i3 + m.unknownFields().size();
            m.cachedSerializedSize = size;
            return size;
        }
        return invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? (obj instanceof f) && ((f) obj).a == this.a : invokeL.booleanValue;
    }

    public B f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return this.f30720b.newInstance();
            } catch (IllegalAccessException | InstantiationException e2) {
                throw new AssertionError(e2);
            }
        }
        return (B) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: g */
    public M redact(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m)) == null) {
            Message.a<M, B> newBuilder = m.newBuilder();
            for (a<M, B> aVar : this.f30721c.values()) {
                if (aVar.f30706f && aVar.a == WireField.Label.REQUIRED) {
                    throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", aVar.f30702b, this.javaType.getName()));
                }
                boolean isAssignableFrom = Message.class.isAssignableFrom(aVar.i().javaType);
                if (!aVar.f30706f && (!isAssignableFrom || aVar.a.isRepeated())) {
                    if (isAssignableFrom && aVar.a.isRepeated()) {
                        c.n.a.h.a.k((List) aVar.e(newBuilder), aVar.i());
                    }
                } else {
                    Object e2 = aVar.e(newBuilder);
                    if (e2 != null) {
                        aVar.h(newBuilder, aVar.a().redact(e2));
                    }
                }
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
        return (M) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: h */
    public String toString(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            StringBuilder sb = new StringBuilder();
            for (a<M, B> aVar : this.f30721c.values()) {
                Object b2 = aVar.b(m);
                if (b2 != null) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(aVar.f30702b);
                    sb.append(com.alipay.sdk.encrypt.a.f31351h);
                    if (aVar.f30706f) {
                        b2 = "██";
                    }
                    sb.append(b2);
                }
            }
            sb.replace(0, 2, this.a.getSimpleName() + ExtendedMessageFormat.START_FE);
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.hashCode() : invokeV.intValue;
    }
}
