package com.baidu.fsg.base.restnet.a;

import android.text.TextUtils;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.utils.FileCopyUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.LogUtil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class c extends a<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f5199a = Charset.forName("UTF-8");

    private Charset a(com.baidu.fsg.base.restnet.http.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
            return Charset.forName(aVar.j());
        }
        return f5199a;
    }

    @Override // com.baidu.fsg.base.restnet.a.a
    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InputStreamReader inputStreamReader = new InputStreamReader(eVar.c(), a(eVar.d()));
        String copyToString = FileCopyUtils.copyToString(inputStreamReader);
        if (ApollonConstants.DEBUG) {
            int length = copyToString.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 2000;
                LogUtil.i("ServerResponse", i3 > length ? copyToString.substring(i2) : copyToString.substring(i2, i3));
                i2 = i3;
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
