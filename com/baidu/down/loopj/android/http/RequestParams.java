package com.baidu.down.loopj.android.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.BasicNameValuePair;
import com.baidu.down.utils.URLEncodedUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class RequestParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ENCODING = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, FileWrapper> fileParams;
    public ConcurrentHashMap<String, String> urlParams;
    public ConcurrentHashMap<String, ArrayList<String>> urlParamsWithArray;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(659325157, "Lcom/baidu/down/loopj/android/http/RequestParams;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(659325157, "Lcom/baidu/down/loopj/android/http/RequestParams;");
        }
    }

    /* loaded from: classes3.dex */
    public static class FileWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String contentType;
        public String fileName;
        public InputStream inputStream;

        public FileWrapper(InputStream inputStream, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.inputStream = inputStream;
            this.fileName = str;
            this.contentType = str2;
        }

        public String getFileName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.fileName;
                if (str != null) {
                    return str;
                }
                return "nofilename";
            }
            return (String) invokeV.objValue;
        }
    }

    public RequestParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.urlParams = new ConcurrentHashMap<>();
            this.fileParams = new ConcurrentHashMap<>();
            this.urlParamsWithArray = new ConcurrentHashMap<>();
        }
    }

    public String getParamString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return URLEncodedUtils.format(getParamsList(), ENCODING);
        }
        return (String) invokeV.objValue;
    }

    public RequestParams(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init();
        put(str, str2);
    }

    public RequestParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        init();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public RequestParams(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {objArr};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        init();
        int length = objArr.length;
        if (length % 2 == 0) {
            for (int i3 = 0; i3 < length; i3 += 2) {
                put(String.valueOf(objArr[i3]), String.valueOf(objArr[i3 + 1]));
            }
            return;
        }
        throw new IllegalArgumentException("Supplied arguments must be even");
    }

    public List<BasicNameValuePair> getParamsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
                linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            for (Map.Entry<String, ArrayList<String>> entry2 : this.urlParamsWithArray.entrySet()) {
                Iterator<String> it = entry2.getValue().iterator();
                while (it.hasNext()) {
                    linkedList.add(new BasicNameValuePair(entry2.getKey(), it.next()));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public void put(String str, File file) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, file) == null) {
            put(str, new FileInputStream(file), file.getName());
        }
    }

    public void put(String str, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, inputStream) == null) {
            put(str, inputStream, null);
        }
    }

    public void put(String str, InputStream inputStream, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, inputStream, str2) == null) {
            put(str, inputStream, str2, null);
        }
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048581, this, str, inputStream, str2, str3) == null) && str != null && inputStream != null) {
            this.fileParams.put(str, new FileWrapper(inputStream, str2, str3));
        }
    }

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && str != null && str2 != null) {
            this.urlParams.put(str, str2);
        }
    }

    public void put(String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, arrayList) == null) && str != null && arrayList != null) {
            this.urlParamsWithArray.put(str, arrayList);
        }
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.urlParams.remove(str);
            this.fileParams.remove(str);
            this.urlParamsWithArray.remove(str);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            for (Map.Entry<String, FileWrapper> entry2 : this.fileParams.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry2.getKey());
                sb.append("=");
                sb.append("FILE");
            }
            for (Map.Entry<String, ArrayList<String>> entry3 : this.urlParamsWithArray.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                ArrayList<String> value = entry3.getValue();
                for (int i = 0; i < value.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(entry3.getKey());
                    sb.append("=");
                    sb.append(value.get(i));
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
