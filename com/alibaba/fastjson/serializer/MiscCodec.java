package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.cookie.ClientCookie;
import org.w3c.dom.Node;
/* loaded from: classes6.dex */
public class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static boolean FILE_RELATIVE_PATH_SUPPORT;
    public static final MiscCodec instance;
    public static Method method_paths_get;
    public static boolean method_paths_get_error;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(740448720, "Lcom/alibaba/fastjson/serializer/MiscCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(740448720, "Lcom/alibaba/fastjson/serializer/MiscCodec;");
                return;
            }
        }
        instance = new MiscCodec();
        method_paths_get_error = false;
        FILE_RELATIVE_PATH_SUPPORT = "true".equals(IOUtils.getStringProperty("fastjson.deserializer.fileRelativePathSupport"));
    }

    public MiscCodec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String toString(Node node) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, node)) == null) {
            try {
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                DOMSource dOMSource = new DOMSource(node);
                StringWriter stringWriter = new StringWriter();
                newTransformer.transform(dOMSource, new StreamResult(stringWriter));
                return stringWriter.toString();
            } catch (TransformerException e2) {
                throw new JSONException("xml node to string error", e2);
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r10v41, types: [T, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Object parse;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) != null) {
            return (T) invokeLLL.objValue;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        InetAddress inetAddress = null;
        int i2 = 0;
        if (type == InetSocketAddress.class) {
            if (jSONLexer.token() == 8) {
                jSONLexer.nextToken();
                return null;
            }
            defaultJSONParser.accept(12);
            while (true) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(17);
                if (stringVal.equals("address")) {
                    defaultJSONParser.accept(17);
                    inetAddress = (InetAddress) defaultJSONParser.parseObject((Class<Object>) InetAddress.class);
                } else if (stringVal.equals(ClientCookie.PORT_ATTR)) {
                    defaultJSONParser.accept(17);
                    if (jSONLexer.token() == 2) {
                        int intValue = jSONLexer.intValue();
                        jSONLexer.nextToken();
                        i2 = intValue;
                    } else {
                        throw new JSONException("port is not int");
                    }
                } else {
                    defaultJSONParser.accept(17);
                    defaultJSONParser.parse();
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                } else {
                    defaultJSONParser.accept(13);
                    return (T) new InetSocketAddress(inetAddress, i2);
                }
            }
        } else {
            if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
                defaultJSONParser.accept(16);
                if (jSONLexer.token() == 4) {
                    if ("val".equals(jSONLexer.stringVal())) {
                        jSONLexer.nextToken();
                        defaultJSONParser.accept(17);
                        parse = defaultJSONParser.parse();
                        defaultJSONParser.accept(13);
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            } else {
                parse = defaultJSONParser.parse();
            }
            if (parse == null) {
                str = null;
            } else if (parse instanceof String) {
                str = (String) parse;
            } else if (parse instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) parse;
                if (type == Currency.class) {
                    String string = jSONObject.getString("currency");
                    if (string != null) {
                        return (T) Currency.getInstance(string);
                    }
                    String string2 = jSONObject.getString("currencyCode");
                    if (string2 != null) {
                        return (T) Currency.getInstance(string2);
                    }
                }
                if (type == Map.Entry.class) {
                    return (T) jSONObject.entrySet().iterator().next();
                }
                return (T) jSONObject.toJavaObject(type);
            } else {
                throw new JSONException("expect string");
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e2) {
                    throw new JSONException("create url error", e2);
                }
            } else if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            } else {
                if (type == Locale.class) {
                    return (T) TypeUtils.toLocale(str);
                }
                if (type == SimpleDateFormat.class) {
                    ?? r10 = (T) new SimpleDateFormat(str, jSONLexer.getLocale());
                    r10.setTimeZone(jSONLexer.getTimeZone());
                    return r10;
                } else if (type != InetAddress.class && type != Inet4Address.class && type != Inet6Address.class) {
                    if (type == File.class) {
                        if (str.indexOf(IStringUtil.TOP_PATH) >= 0 && !FILE_RELATIVE_PATH_SUPPORT) {
                            throw new JSONException("file relative path not support.");
                        }
                        return (T) new File(str);
                    } else if (type == TimeZone.class) {
                        return (T) TimeZone.getTimeZone(str);
                    } else {
                        if (type instanceof ParameterizedType) {
                            type = ((ParameterizedType) type).getRawType();
                        }
                        if (type == Class.class) {
                            return (T) TypeUtils.loadClass(str, defaultJSONParser.getConfig().getDefaultClassLoader(), false);
                        }
                        if (type == Charset.class) {
                            return (T) Charset.forName(str);
                        }
                        if (type == Currency.class) {
                            return (T) Currency.getInstance(str);
                        }
                        if (type == JSONPath.class) {
                            return (T) new JSONPath(str);
                        }
                        if (type instanceof Class) {
                            String name = ((Class) type).getName();
                            if (name.equals("java.nio.file.Path")) {
                                try {
                                    if (method_paths_get == null && !method_paths_get_error) {
                                        method_paths_get = TypeUtils.loadClass("java.nio.file.Paths").getMethod("get", String.class, String[].class);
                                    }
                                    if (method_paths_get != null) {
                                        return (T) method_paths_get.invoke(null, str, new String[0]);
                                    }
                                    throw new JSONException("Path deserialize erorr");
                                } catch (IllegalAccessException e3) {
                                    throw new JSONException("Path deserialize erorr", e3);
                                } catch (NoSuchMethodException unused) {
                                    method_paths_get_error = true;
                                } catch (InvocationTargetException e4) {
                                    throw new JSONException("Path deserialize erorr", e4);
                                }
                            }
                            throw new JSONException("MiscCodec not support " + name);
                        }
                        throw new JSONException("MiscCodec not support " + type.toString());
                    }
                } else {
                    try {
                        return (T) InetAddress.getByName(str);
                    } catch (UnknownHostException e5) {
                        throw new JSONException("deserialize inet adress error", e5);
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        String miscCodec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull();
                return;
            }
            Class<?> cls = obj.getClass();
            if (cls == SimpleDateFormat.class) {
                miscCodec = ((SimpleDateFormat) obj).toPattern();
                if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && obj.getClass() != type) {
                    serializeWriter.write(123);
                    serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                    jSONSerializer.write(obj.getClass().getName());
                    serializeWriter.writeFieldValue(',', "val", miscCodec);
                    serializeWriter.write(125);
                    return;
                }
            } else if (cls == Class.class) {
                miscCodec = ((Class) obj).getName();
            } else if (cls == InetSocketAddress.class) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetAddress address = inetSocketAddress.getAddress();
                serializeWriter.write(123);
                if (address != null) {
                    serializeWriter.writeFieldName("address");
                    jSONSerializer.write(address);
                    serializeWriter.write(44);
                }
                serializeWriter.writeFieldName(ClientCookie.PORT_ATTR);
                serializeWriter.writeInt(inetSocketAddress.getPort());
                serializeWriter.write(125);
                return;
            } else if (obj instanceof File) {
                miscCodec = ((File) obj).getPath();
            } else if (obj instanceof InetAddress) {
                miscCodec = ((InetAddress) obj).getHostAddress();
            } else if (obj instanceof TimeZone) {
                miscCodec = ((TimeZone) obj).getID();
            } else if (obj instanceof Currency) {
                miscCodec = ((Currency) obj).getCurrencyCode();
            } else if (obj instanceof JSONStreamAware) {
                ((JSONStreamAware) obj).writeJSONString(serializeWriter);
                return;
            } else if (obj instanceof Iterator) {
                writeIterator(jSONSerializer, serializeWriter, (Iterator) obj);
                return;
            } else if (obj instanceof Iterable) {
                writeIterator(jSONSerializer, serializeWriter, ((Iterable) obj).iterator());
                return;
            } else if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof String) {
                    String str = (String) key;
                    if (value instanceof String) {
                        serializeWriter.writeFieldValueStringWithDoubleQuoteCheck(ExtendedMessageFormat.START_FE, str, (String) value);
                    } else {
                        serializeWriter.write(123);
                        serializeWriter.writeFieldName(str);
                        jSONSerializer.write(value);
                    }
                } else {
                    serializeWriter.write(123);
                    jSONSerializer.write(key);
                    serializeWriter.write(58);
                    jSONSerializer.write(value);
                }
                serializeWriter.write(125);
                return;
            } else if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
                serializeWriter.writeNull();
                return;
            } else if (obj instanceof Node) {
                miscCodec = toString((Node) obj);
            } else {
                throw new JSONException("not support class : " + cls);
            }
            serializeWriter.writeString(miscCodec);
        }
    }

    public void writeIterator(JSONSerializer jSONSerializer, SerializeWriter serializeWriter, Iterator<?> it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jSONSerializer, serializeWriter, it) == null) {
            serializeWriter.write(91);
            int i2 = 0;
            while (it.hasNext()) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                jSONSerializer.write(it.next());
                i2++;
            }
            serializeWriter.write(93);
        }
    }
}
