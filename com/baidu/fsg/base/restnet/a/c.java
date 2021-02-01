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
/* loaded from: classes5.dex */
public class c extends a<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f1890a = Charset.forName("UTF-8");

    @Override // com.baidu.fsg.base.restnet.a.a
    protected Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InputStreamReader inputStreamReader = new InputStreamReader(eVar.c(), a(eVar.d()));
        String copyToString = FileCopyUtils.copyToString(inputStreamReader);
        if (ApollonConstants.DEBUG) {
            int length = copyToString.length();
            for (int i = 0; i < length; i += 2000) {
                LogUtil.i("ServerResponse", i + 2000 > length ? copyToString.substring(i) : copyToString.substring(i, i + 2000));
            }
        }
        try {
            Object fromJson = JsonUtils.fromJson(copyToString, cls);
            inputStreamReader.close();
            return fromJson;
        } catch (JSONException e) {
            throw new RestRuntimeException("Could not read JSON: " + e.getMessage(), e);
        }
    }

    private Charset a(com.baidu.fsg.base.restnet.http.a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.j())) ? f1890a : Charset.forName(aVar.j());
    }
}
