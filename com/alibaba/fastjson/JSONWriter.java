package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes9.dex */
public class JSONWriter implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONStreamContext context;
    public JSONSerializer serializer;
    public SerializeWriter writer;

    public JSONWriter(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SerializeWriter serializeWriter = new SerializeWriter(writer);
        this.writer = serializeWriter;
        this.serializer = new JSONSerializer(serializeWriter);
    }

    private void afterWrite() {
        JSONStreamContext jSONStreamContext;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONStreamContext = this.context) == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case 1003:
                i2 = 1002;
                break;
            case 1002:
                i2 = 1003;
                break;
            case 1004:
                i2 = 1005;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            this.context.state = i2;
        }
    }

    private void beforeWrite() {
        JSONStreamContext jSONStreamContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (jSONStreamContext = this.context) == null) {
            return;
        }
        int i2 = jSONStreamContext.state;
        if (i2 == 1002) {
            this.writer.write(58);
        } else if (i2 == 1003) {
            this.writer.write(44);
        } else if (i2 != 1005) {
        } else {
            this.writer.write(44);
        }
    }

    private void beginStructure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i2 = this.context.state;
            switch (i2) {
                case 1001:
                case 1004:
                    return;
                case 1002:
                    this.writer.write(58);
                    return;
                case 1003:
                default:
                    throw new JSONException("illegal state : " + i2);
                case 1005:
                    this.writer.write(44);
                    return;
            }
        }
    }

    private void endStructure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            JSONStreamContext jSONStreamContext = this.context.parent;
            this.context = jSONStreamContext;
            if (jSONStreamContext == null) {
                return;
            }
            int i2 = jSONStreamContext.state;
            int i3 = i2 != 1001 ? i2 != 1002 ? i2 != 1004 ? -1 : 1005 : 1003 : 1002;
            if (i3 != -1) {
                this.context.state = i3;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.writer.close();
        }
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, serializerFeature, z) == null) {
            this.writer.config(serializerFeature, z);
        }
    }

    public void endArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.writer.write(93);
            endStructure();
        }
    }

    public void endObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.writer.write(125);
            endStructure();
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.writer.flush();
        }
    }

    public void startArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.context != null) {
                beginStructure();
            }
            this.context = new JSONStreamContext(this.context, 1004);
            this.writer.write(91);
        }
    }

    public void startObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.context != null) {
                beginStructure();
            }
            this.context = new JSONStreamContext(this.context, 1001);
            this.writer.write(123);
        }
    }

    @Deprecated
    public void writeEndArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            endArray();
        }
    }

    @Deprecated
    public void writeEndObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            endObject();
        }
    }

    public void writeKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            writeObject(str);
        }
    }

    public void writeObject(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            beforeWrite();
            this.serializer.write(str);
            afterWrite();
        }
    }

    @Deprecated
    public void writeStartArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            startArray();
        }
    }

    @Deprecated
    public void writeStartObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            startObject();
        }
    }

    public void writeValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, obj) == null) {
            writeObject(obj);
        }
    }

    public void writeObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
            beforeWrite();
            this.serializer.write(obj);
            afterWrite();
        }
    }
}
