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
import java.io.File;
import java.io.IOException;
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
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes7.dex */
public class MiscCodec implements ObjectDeserializer, ObjectSerializer {
    private static boolean FILE_RELATIVE_PATH_SUPPORT;
    private static Method method_paths_get;
    public static final MiscCodec instance = new MiscCodec();
    private static boolean method_paths_get_error = false;

    static {
        FILE_RELATIVE_PATH_SUPPORT = false;
        FILE_RELATIVE_PATH_SUPPORT = "true".equals(IOUtils.getStringProperty("fastjson.deserializer.fileRelativePathSupport"));
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        String currencyCode;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            currencyCode = ((SimpleDateFormat) obj).toPattern();
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && obj.getClass() != type) {
                serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_QUERY);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.writeFieldValue(',', "val", currencyCode);
                serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
                return;
            }
        } else if (cls == Class.class) {
            currencyCode = ((Class) obj).getName();
        } else if (cls == InetSocketAddress.class) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
            InetAddress address = inetSocketAddress.getAddress();
            serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_QUERY);
            if (address != null) {
                serializeWriter.writeFieldName("address");
                jSONSerializer.write(address);
                serializeWriter.write(44);
            }
            serializeWriter.writeFieldName(ClientCookie.PORT_ATTR);
            serializeWriter.writeInt(inetSocketAddress.getPort());
            serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
            return;
        } else if (obj instanceof File) {
            currencyCode = ((File) obj).getPath();
        } else if (obj instanceof InetAddress) {
            currencyCode = ((InetAddress) obj).getHostAddress();
        } else if (obj instanceof TimeZone) {
            currencyCode = ((TimeZone) obj).getID();
        } else if (obj instanceof Currency) {
            currencyCode = ((Currency) obj).getCurrencyCode();
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
                    serializeWriter.writeFieldValueStringWithDoubleQuoteCheck('{', str, (String) value);
                } else {
                    serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_QUERY);
                    serializeWriter.writeFieldName(str);
                    jSONSerializer.write(value);
                }
            } else {
                serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_QUERY);
                jSONSerializer.write(key);
                serializeWriter.write(58);
                jSONSerializer.write(value);
            }
            serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
            return;
        } else if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
            serializeWriter.writeNull();
            return;
        } else {
            throw new JSONException("not support class : " + cls);
        }
        serializeWriter.writeString(currencyCode);
    }

    protected void writeIterator(JSONSerializer jSONSerializer, SerializeWriter serializeWriter, Iterator<?> it) {
        int i = 0;
        serializeWriter.write(91);
        while (it.hasNext()) {
            if (i != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(it.next());
            i++;
        }
        serializeWriter.write(93);
    }

    /* JADX WARN: Type inference failed for: r2v37, types: [T, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parse;
        String str;
        int i;
        InetAddress inetAddress;
        InetAddress inetAddress2 = null;
        int i2 = 0;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
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
                    int i3 = i2;
                    inetAddress = (InetAddress) defaultJSONParser.parseObject((Class<Object>) InetAddress.class);
                    i = i3;
                } else if (stringVal.equals(ClientCookie.PORT_ATTR)) {
                    defaultJSONParser.accept(17);
                    if (jSONLexer.token() != 2) {
                        throw new JSONException("port is not int");
                    }
                    i = jSONLexer.intValue();
                    jSONLexer.nextToken();
                    inetAddress = inetAddress2;
                } else {
                    defaultJSONParser.accept(17);
                    defaultJSONParser.parse();
                    i = i2;
                    inetAddress = inetAddress2;
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                    inetAddress2 = inetAddress;
                    i2 = i;
                } else {
                    defaultJSONParser.accept(13);
                    return (T) new InetSocketAddress(inetAddress, i);
                }
            }
        } else {
            if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
                defaultJSONParser.accept(16);
                if (jSONLexer.token() == 4) {
                    if (!"val".equals(jSONLexer.stringVal())) {
                        throw new JSONException("syntax error");
                    }
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    parse = defaultJSONParser.parse();
                    defaultJSONParser.accept(13);
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
                } catch (MalformedURLException e) {
                    throw new JSONException("create url error", e);
                }
            } else if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            } else {
                if (type == Locale.class) {
                    return (T) TypeUtils.toLocale(str);
                }
                if (type == SimpleDateFormat.class) {
                    ?? r2 = (T) new SimpleDateFormat(str, jSONLexer.getLocale());
                    r2.setTimeZone(jSONLexer.getTimeZone());
                    return r2;
                } else if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                    try {
                        return (T) InetAddress.getByName(str);
                    } catch (UnknownHostException e2) {
                        throw new JSONException("deserialize inet adress error", e2);
                    }
                } else if (type == File.class) {
                    if (str.indexOf(IStringUtil.TOP_PATH) >= 0 && !FILE_RELATIVE_PATH_SUPPORT) {
                        throw new JSONException("file relative path not support.");
                    }
                    return (T) new File(str);
                } else if (type == TimeZone.class) {
                    return (T) TimeZone.getTimeZone(str);
                } else {
                    Type rawType = type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type;
                    if (rawType == Class.class) {
                        return (T) TypeUtils.loadClass(str, defaultJSONParser.getConfig().getDefaultClassLoader());
                    }
                    if (rawType == Charset.class) {
                        return (T) Charset.forName(str);
                    }
                    if (rawType == Currency.class) {
                        return (T) Currency.getInstance(str);
                    }
                    if (rawType == JSONPath.class) {
                        return (T) new JSONPath(str);
                    }
                    if (rawType instanceof Class) {
                        String name = ((Class) rawType).getName();
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
                            } catch (NoSuchMethodException e4) {
                                method_paths_get_error = true;
                            } catch (InvocationTargetException e5) {
                                throw new JSONException("Path deserialize erorr", e5);
                            }
                        }
                        throw new JSONException("MiscCodec not support " + name);
                    }
                    throw new JSONException("MiscCodec not support " + rawType.toString());
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }
}
