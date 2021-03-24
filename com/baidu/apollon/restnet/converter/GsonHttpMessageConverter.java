package com.baidu.apollon.restnet.converter;

import android.text.TextUtils;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class GsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3746a = Charset.forName("UTF-8");

    private Charset a(com.baidu.apollon.restnet.http.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
            return Charset.forName(aVar.j());
        }
        return f3746a;
    }

    @Override // com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter
    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InputStreamReader inputStreamReader = new InputStreamReader(eVar.c(), a(eVar.d()));
        String copyToString = FileCopyUtils.copyToString(inputStreamReader);
        a(copyToString);
        if (ApollonConstants.DEBUG) {
            int length = copyToString.length();
            int i = 0;
            while (i < length) {
                int i2 = i + 2000;
                LogUtil.i("ServerResponse", i2 > length ? copyToString.substring(i) : copyToString.substring(i, i2));
                i = i2;
            }
        }
        try {
            Object fromJson = JsonUtils.fromJson(copyToString, cls);
            inputStreamReader.close();
            return fromJson;
        } catch (JSONException e2) {
            throw new RestRuntimeException("Could not read JSON: " + e2.getMessage(), e2);
        }
    }
}
