package com.baidu.ar.http;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class m implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Charset qI;
    public StringBuilder qJ;
    public String rm;
    public Map<String, String> rn;
    public Map<String, byte[]> ro;
    public int rp;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rp = 0;
        this.rm = d.MULTIPART_BOUNDARY;
        this.qJ = new StringBuilder();
        this.ro = new HashMap();
        this.rn = new HashMap();
    }

    private InputStream a(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            StringBuilder sb = new StringBuilder();
            String format = String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", j.a(str2, this.qI), j.a(str3, this.qI));
            sb.append(str);
            sb.append("--");
            sb.append(this.rm);
            sb.append("\r\n");
            sb.append(format);
            sb.append("\r\n");
            sb.append("Content-Type:");
            sb.append(str4);
            sb.append(";");
            if (z) {
                sb.append("charset=");
                sb.append(this.qI.name());
            }
            sb.append("\r\n");
            sb.append("\r\n");
            return new ByteArrayInputStream(sb.toString().getBytes(this.qI));
        }
        return (InputStream) invokeCommon.objValue;
    }

    public void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, bArr) == null) {
            if (bArr != null) {
                this.rp += bArr.length;
            }
            this.ro.put(str, bArr);
        }
    }

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charset) == null) {
            this.qI = charset;
        }
    }

    public void at(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.rm = str;
        }
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.qJ.length() > 0) {
                arrayList.add(new ByteArrayInputStream(this.qJ.toString().getBytes(this.qI)));
            }
            String str = "";
            if (!this.rn.isEmpty()) {
                String str2 = "";
                for (Map.Entry<String, String> entry : this.rn.entrySet()) {
                    arrayList.add(a(str2, entry.getKey(), new File(entry.getValue()).getName(), j.ar(entry.getValue()), false));
                    arrayList.add(new FileInputStream(entry.getValue()));
                    str2 = "\r\n";
                }
                str = str2;
            }
            if (!this.ro.isEmpty()) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                int i2 = 1;
                String str3 = str;
                for (Map.Entry<String, byte[]> entry2 : this.ro.entrySet()) {
                    arrayList.add(a(str3, entry2.getKey(), valueOf + i2 + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX, "application/octet-stream", true));
                    arrayList.add(new ByteArrayInputStream(entry2.getValue()));
                    str3 = "\r\n";
                    i2++;
                }
                str = str3;
            }
            if (!this.rn.isEmpty() || !this.ro.isEmpty()) {
                arrayList.add(new ByteArrayInputStream((str + "--" + this.rm + "--\r\n").getBytes(this.qI)));
            }
            return (InputStream[]) arrayList.toArray(new InputStream[arrayList.size()]);
        }
        return (InputStream[]) invokeV.objValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        StringBuilder sb = this.qJ;
        sb.append("--");
        sb.append(this.rm);
        sb.append("\r\n");
        StringBuilder sb2 = this.qJ;
        sb2.append("Content-Disposition: form-data; name=\"");
        sb2.append(j.a(str, this.qI));
        sb2.append("\"\r\n");
        this.qJ.append("\r\n");
        this.qJ.append(j.a(str2, this.qI));
        this.qJ.append("\r\n");
    }

    public String getBoundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.rm : (String) invokeV.objValue;
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "multipart/form-data;boundary=" + getBoundary();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.rp : invokeV.intValue;
    }

    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            File file = new File(str2);
            if (file.exists()) {
                this.rp = (int) (this.rp + file.length());
            }
            this.rn.put(str, str2);
        }
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.qJ.length() == 0 && this.ro.isEmpty() && this.rn.isEmpty() : invokeV.booleanValue;
    }
}
